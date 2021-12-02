package com.example.oop_project_47.Parking_Slot;

import com.example.oop_project_47.Bookings.Booking;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;


public interface ParkingSlotRepository extends Repository<ParkingSlot, Integer> {


    List<ParkingSlot> findAll();

    ParkingSlot findById(Integer id);

   // ParkingSlot findByDate(LocalDate date);
    Long deleteById(Integer id);
    void save(ParkingSlot parkingSlot);
}
