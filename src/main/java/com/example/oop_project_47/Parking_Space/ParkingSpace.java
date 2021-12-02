package com.example.oop_project_47.Parking_Space;

import com.example.oop_project_47.Model.NamedEntity;
import com.example.oop_project_47.Worker.Worker;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Parking Spaces")
public class ParkingSpace extends NamedEntity {

    @Id
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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHatchbackSlots() {
        return hatchbackSlots;
    }

    public void setHatchbackSlots(Integer hatchbackSlots) {
        this.hatchbackSlots = hatchbackSlots;
    }

    public Integer getSedanSlots() {
        return sedanSlots;
    }

    public void setSedanSlots(Integer sedanSlots) {
        this.sedanSlots = sedanSlots;
    }

    public Integer getSuvSlots() {
        return suvSlots;
    }

    public void setSuvSlots(Integer suvSlots) {
        this.suvSlots = suvSlots;
    }

    public Integer getBufferSlots() {
        return bufferSlots;
    }

    public void setBufferSlots(Integer bufferSlots) {
        this.bufferSlots = bufferSlots;
    }

    public Integer getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(Integer workerCount) {
        this.workerCount = workerCount;
    }
}
