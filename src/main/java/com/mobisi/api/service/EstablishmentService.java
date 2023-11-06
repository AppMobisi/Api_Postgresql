    package com.mobisi.api.service;

    import com.fasterxml.jackson.databind.JsonNode;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import com.mobisi.api.dto.EstablishmentDto;
    import com.mobisi.api.exceptions.BaseHttpException;
    import com.mobisi.api.exceptions.ExceptionHandler;
    import com.mobisi.api.model.Establishment;
    import com.mobisi.api.repository.EstablishmentsRepository;
    import org.modelmapper.ModelMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.stereotype.Service;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;
    import java.util.stream.Collectors;


    @Service
    public class EstablishmentService {
        private final EstablishmentsRepository establishmentsRepository;
        private final ModelMapper modelMapper = new ModelMapper();

        @Autowired
        public EstablishmentService(EstablishmentsRepository establishmentsRepository) {
            this.establishmentsRepository = establishmentsRepository;
        }
    //    public List<EstablishmentDto> getAllEstablishments() throws BaseHttpException{
    //        try{
    //            List<Establishment> establishments = this.establishmentsRepository.findAll();
    //            return establishments
    //                    .stream()
    //                    .map(establishment -> modelMapper.map(establishment, EstablishmentDto.class))
    //                    .collect(Collectors.toList());
    //        }
    //        catch (Exception exc){
    //            throw ExceptionHandler.handleHttpException(exc);
    //        }
    //    }

    //    public EstablishmentDto getEstablishmentById(Long id) throws BaseHttpException {
    //        try {
    //            Optional<Establishment> data = this.establishmentsRepository.findById(id);
    //
    //            if (data.isEmpty()) {
    //                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("Establishment with id %s was not found", id));
    //            }
    //
    //            Establishment establishment = data.get();
    //
    //            return modelMapper.map(establishment, EstablishmentDto.class);
    //        }
    //        catch (Exception exc) {
    //            throw ExceptionHandler.handleHttpException(exc);
    //        }
    //    }

        public void deleteEstablishment(Long id) throws BaseHttpException {
            try {
                Optional<Establishment> data = this.establishmentsRepository.findById(id);

                if (data.isEmpty()) {
                    throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("User with id %s was not found", id));
                }

                Establishment establishment = data.get();
                this.establishmentsRepository.delete(establishment);
            } catch (Exception exc) {
                throw ExceptionHandler.handleHttpException(exc);
            }
        }

        public List<EstablishmentDto> ByLocal(String longitude, String latitude, String radius) throws BaseHttpException {
            try {
                URL url = new URL("https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                        "key=AIzaSyBzAGAGzBzvVwTKsKwAtI76Hjfp-lZQ3uo" +
                        "&location=" + longitude + "," + latitude +
                        "&radius=" + radius +
                        "&fields=address,international_phone_number,website,price_range,opening_hours,popularity,review,photo,name"
                );
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output;
                StringBuilder full = new StringBuilder();
                while ((output = br.readLine()) != null) {
                    full.append(output);
                }

                ObjectMapper mapper = new ObjectMapper();
                JsonNode responseGoogle = mapper.readTree(full.toString());
                JsonNode resultGoogle = responseGoogle.get("results");

                System.out.println(resultGoogle);

                List<EstablishmentDto> establishments = new ArrayList<>();
                for (JsonNode establishmentNode : resultGoogle) {
                    System.out.println(establishmentNode);
                    EstablishmentDto establishment = mapper.treeToValue(establishmentNode, EstablishmentDto.class);
                    System.out.println("\n");
                    System.out.println(establishment);
                    System.out.println("\n");
                }

                System.out.println(establishments);

                return establishments;

            } catch (IOException | RuntimeException exc) {
                exc.printStackTrace();
                throw new BaseHttpException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Failed to retrieve establishments.");
            }
        }


    //        try {
    //            Optional<Establishment> data = establishmentsRepository.findById(id);
    //
    //            if (data.isEmpty()) {
    //                throw new BaseHttpException(HttpStatus.NOT_FOUND.value(), String.format("Establishment with id %s was not found", id));
    //            }
    //
    //            Establishment existingEstablishment = data.get();
    //
    //            Establishment updatedEstablishment = establishmentsRepository.save(existingEstablishment);
    //
    //            return modelMapper.map(updatedEstablishment, EstablishmentDto.class);
    //        } catch (Exception exc) {
    //            throw ExceptionHandler.handleHttpException(exc);
    //        }
    //    }


    }



