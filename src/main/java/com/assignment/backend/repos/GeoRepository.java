package com.assignment.backend.repos;

import com.assignment.backend.model.Geo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoRepository extends JpaRepository<Geo, Integer> {

}
