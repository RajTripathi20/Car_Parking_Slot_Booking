package com.example.oop_project_47.Parking_Space;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, String> {

    
    Optional<ParkingSpace> findById(Integer id);
    ParkingSpace findByAddress(String address);

   // ParkingSpace findByDate(LocalDate date);
    void deleteById(Integer id);
    ParkingSpace save(ParkingSpace parkingSpace);
}
