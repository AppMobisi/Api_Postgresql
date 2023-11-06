package com.mobisi.api.repository;

import com.mobisi.api.model.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentsRepository extends JpaRepository<Establishment, Long> {
    
}
