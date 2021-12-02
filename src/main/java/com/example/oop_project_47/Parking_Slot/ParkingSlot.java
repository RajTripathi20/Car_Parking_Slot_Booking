package com.example.oop_project_47.Parking_Slot;

import com.example.oop_project_47.Model.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParkingSlot extends NamedEntity {

    @Column(name = "ID")
    private Integer id;

    @Column(name = "Slot Type")
    private Integer slotType;
}
