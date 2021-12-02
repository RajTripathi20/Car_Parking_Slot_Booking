package com.example.oop_project_47.Parking_Space;

import com.example.oop_project_47.Model.NamedEntity;
import com.example.oop_project_47.Worker.Worker;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParkingSpace extends NamedEntity {

    @Column(name = "ID")
    private Integer id;

    @Column(name = "Location")
    private String location;

    @Column(name = "Address")
    private String address;

    @Column(name = "Hatchback Slots")
    private Integer hatchbackSlots;

    @Column(name = "Sedan Slots")
    private Integer sedanSlots;

    @Column(name = "SUV Slots")
    private Integer suvSlots;

    @Column(name = "Buffer Slots")
    private Integer bufferSlots;

    @Column(name = "Number of Workers")
    private Integer workerCount;

}
