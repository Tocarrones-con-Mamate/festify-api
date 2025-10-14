package com.TocarronesConMamate.festify_api.persistence.jpa.repository;

import com.TocarronesConMamate.festify_api.persistence.jpa.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistJpaRepository extends JpaRepository<ArtistEntity, Long> {
    
}
