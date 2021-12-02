package com.example.oop_project_47.Parking_Space;

import com.example.oop_project_47.Bookings.Booking;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;


public interface ParkingSpaceRepository extends Repository<ParkingSpace, Integer> {


    List<ParkingSpace> findAll();

    ParkingSpace findById(Integer id);
    ParkingSpace findByAddress(String address);

   // ParkingSpace findByDate(LocalDate date);
    Long deleteById(Integer id);
    void save(ParkingSpace parkingSpace);
}
