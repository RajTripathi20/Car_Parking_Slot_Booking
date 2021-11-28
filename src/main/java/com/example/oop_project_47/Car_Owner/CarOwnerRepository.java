package com.example.oop_project_47.Car_Owner;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOwnerRepository extends JpaRepository<CarOwner, String> {
    Optional<CarOwner> findUserByUsername(String username);
}
