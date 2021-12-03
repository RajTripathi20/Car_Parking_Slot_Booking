package com.example.oop_project_47.Bookings;

import com.example.oop_project_47.Car_Owner.CarOwner;
import com.example.oop_project_47.Car_Owner.ConfirmationToken;
import com.example.oop_project_47.LoginModule.LoginCredentials;
import com.example.oop_project_47.Parking_Space.ParkingSpace;
import com.example.oop_project_47.Parking_Space.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/Dashboard/a/ParkingSpace/")
public class BookingController {
    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @RequestMapping(value = "/SpaceInformation", method = RequestMethod.POST)
    public ModelAndView searchSlots(ModelAndView modelAndView, Booking booking) {
        // carOwner.fillCarOwner();
        String location = booking.getLocation();
       // ParkingSpace parkingSpace = new ParkingSpace();
        List<ParkingSpace> nearBySpaces = parkingSpaceRepository.findAllByLocation(location);

        if (nearBySpaces.size() == 0) {
            modelAndView.addObject("message", "No Parking Spaces Available for the given Location");

            modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotUserDashboard");
            return modelAndView;
        }
        else{
            modelAndView.addObject("nearBySpaces", nearBySpaces);
            modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotScreen1UserDashboard");
            return modelAndView;
        }
    }
}
