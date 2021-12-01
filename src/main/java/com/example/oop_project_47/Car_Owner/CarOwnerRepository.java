package com.example.oop_project_47.Car_Owner;


import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface CarOwnerRepository extends Repository<CarOwner, Integer> {
    Optional<CarOwner> findUserByUsername(String username);

    List<CarOwner> findUserById(Integer userId);

    CarOwner findById(Integer categoryId);

    CarOwner save(CarOwner carOwner);

    Long deleteById(Integer categoryId);

    void delete(CarOwner carOwner);
}
