package com.example.oop_project_47.Bookings;

import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;


public interface BookingRepository extends Repository<Booking, Integer> {


    List<Booking> findAllByUsername(Booking booking);

    Booking findById(Integer id);

    Booking findByDate(LocalDate date);
    Long deleteById(Integer id);
    void save(Booking diaryEntry);
}
