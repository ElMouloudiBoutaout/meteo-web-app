package com.meteoweb.repository;

import com.meteoweb.domain.StationInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationInformationRepository extends JpaRepository<StationInformation,String> {
}
