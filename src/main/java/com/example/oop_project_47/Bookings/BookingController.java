package com.example.oop_project_47.Bookings;

import com.example.oop_project_47.Car_Owner.CarOwner;
import com.example.oop_project_47.Car_Owner.ConfirmationToken;
import com.example.oop_project_47.Car_Owner.CurrentUser;
import com.example.oop_project_47.LoginModule.LoginController;
import com.example.oop_project_47.LoginModule.LoginCredentials;
import com.example.oop_project_47.Parking_Space.ParkingSpace;
import com.example.oop_project_47.Parking_Space.ParkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Controller
public class BookingController {
    LoginController loginController;
    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;
    @Autowired
    private BookingRepository bookingRepository;
    String location;

    @RequestMapping(value = "/Dashboard/c/BookingSlot/SpaceInformation", method = RequestMethod.POST)
    public ModelAndView searchSlots(ModelAndView modelAndView, Booking booking) {
        // carOwner.fillCarOwner();
        location = booking.getLocation();
        List<ParkingSpace> nearBySpaces = parkingSpaceRepository.findAllByLocation(location);
        List<Booking> allSpaceBookings;
        CarOwner currentOwner = CurrentUser.getCurrentUser();
        if (currentOwner.getCarType() == null) {
            modelAndView.addObject("currentUser", currentOwner);
            modelAndView.setViewName("/DashboardModule2/UserDashboard/PreRegFormUserDashboard");
            return modelAndView;
        } else { // ParkingSpace parkingSpace = new ParkingSpace();
            if (nearBySpaces.size() == 0) {
                modelAndView.addObject("message", "No Parking Spaces Available for the given Location");
                modelAndView.setViewName("redirect:/Dashboard/c/BookingSlot");
                return modelAndView;
            } else {
                int clicked = 0;
                List<String> relevantSlots = new ArrayList<String>();
                for (int i = 0; i < nearBySpaces.size(); i++) {
                    nearBySpaces.get(i).setStatus("Not Available");
                    //nearBySpaces.get(i).setAvailableHatchback(nearBySpaces.get(i).getHatchbackSlots());
                    //nearBySpaces.get(i).setAvailableSedan(nearBySpaces.get(i).getSedanSlots());
                    //nearBySpaces.get(i).setAvailableSUV(nearBySpaces.get(i).getSuvSlots());
                    //nearBySpaces.get(i).setAvailableBuffer(nearBySpaces.get(i).getBufferSlots());
                    String carType = currentOwner.getCarType();
                    booking.setCarType(carType);
                    if (carType.equals("Hatchback")) {
                        if (nearBySpaces.get(i).getAvailableHatchback() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            nearBySpaces.get(i).setHatchbackStatus("Book");
                            booking.setSlotType("Hatchback");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            // nearBySpaces.get(i).setAvailableHatchback(nearBySpaces.get(i).getAvailableHatchback() - 1);
                        } else if (nearBySpaces.get(i).getAvailableSedan() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            nearBySpaces.get(i).setSedanStatus("Book");
                            booking.setSlotType("Sedan");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            // nearBySpaces.get(i).setAvailableSedan(nearBySpaces.get(i).getAvailableSedan() - 1);
                        } else if (nearBySpaces.get(i).getAvailableSUV() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            nearBySpaces.get(i).setSUVStatus("Book");
                            booking.setSlotType("SUV");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            //nearBySpaces.get(i).setAvailableSUV(nearBySpaces.get(i).getAvailableSUV() - 1);
                        } else if (nearBySpaces.get(i).getAvailableBuffer() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            booking.setSlotType("Buffer");
                            //nearBySpaces.get(i).setAvailableBuffer(nearBySpaces.get(i).getAvailableBuffer() - 1);
                        } else {
                            relevantSlots.add("Hatchback");
                            relevantSlots.add("Sedan");
                            relevantSlots.add("SUV");
                            allSpaceBookings = bookingRepository.findAllBySpaceAndCarTypeIn(nearBySpaces.get(i).getId(), relevantSlots);
                            if(allSpaceBookings.size() == 0)  {

                            } else {
                            LocalDateTime earliestAvailable = Collections.min(allSpaceBookings.stream().map(Booking::getCheckOut).collect(Collectors.toList()));
                            long diffInMilli = Math.abs(earliestAvailable.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()) - LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                            long diff = TimeUnit.HOURS.convert(diffInMilli, TimeUnit.MILLISECONDS);
                            nearBySpaces.get(i).setStatus("Available in" + diff);
                            if (clicked == nearBySpaces.get(i).getId()) {
                                modelAndView.addObject("message", "This parking Space is not available for Booking!");
                                modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotUserDashboard");
                                return modelAndView;
                            }
                            }
                        }
                    } else if (carType.equals("Sedan")) {

                        if (nearBySpaces.get(i).getAvailableSedan() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            nearBySpaces.get(i).setSedanStatus("Book");
                            booking.setSlotType("Sedan");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            //nearBySpaces.get(i).setAvailableSedan(nearBySpaces.get(i).getAvailableSedan() - 1);
                        } else if (nearBySpaces.get(i).getAvailableSUV() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            nearBySpaces.get(i).setSUVStatus("Book");
                            booking.setSlotType("SUV");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            //nearBySpaces.get(i).setAvailableSUV(nearBySpaces.get(i).getAvailableSUV() - 1);
                        } else if (nearBySpaces.get(i).getAvailableBuffer() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            booking.setSlotType("Buffer");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            //nearBySpaces.get(i).setAvailableBuffer(nearBySpaces.get(i).getAvailableBuffer() - 1);
                        } else {
                            relevantSlots.add("Sedan");
                            relevantSlots.add("SUV");
                            allSpaceBookings = bookingRepository.findAllBySpaceAndCarTypeIn(nearBySpaces.get(i).getId(), relevantSlots);
                            if(allSpaceBookings.size() == 0)  {

                            } else {
                                LocalDateTime earliestAvailable = Collections.min(allSpaceBookings.stream().map(Booking::getCheckOut).collect(Collectors.toList()));
                                long diffInMilli = Math.abs(earliestAvailable.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()) - LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                long diff = TimeUnit.HOURS.convert(diffInMilli, TimeUnit.MILLISECONDS);
                                nearBySpaces.get(i).setStatus("Available in" + diff);
                                if (clicked == nearBySpaces.get(i).getId()) {
                                    modelAndView.addObject("message", "This parking Space is not available for Booking!");
                                    modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotUserDashboard");
                                    return modelAndView;
                                }
                            }
                        }

                    } else if (carType.equals("SUV")) {


                        if (nearBySpaces.get(i).getAvailableSUV() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            nearBySpaces.get(i).setSUVStatus("Book");
                            booking.setSlotType("SUV");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            //nearBySpaces.get(i).setAvailableSUV(nearBySpaces.get(i).getAvailableSUV() - 1);
                        } else if (nearBySpaces.get(i).getAvailableBuffer() != 0) {
                            nearBySpaces.get(i).setStatus("Available");
                            booking.setSlotType("Buffer");
                            if (clicked == nearBySpaces.get(i).getId()) ;
                            //nearBySpaces.get(i).setAvailableBuffer(nearBySpaces.get(i).getAvailableBuffer() - 1);

                        } else {
                            relevantSlots.add("SUV");
                            allSpaceBookings = bookingRepository.findAllBySpaceAndCarTypeIn(nearBySpaces.get(i).getId(), relevantSlots);
                            if(allSpaceBookings.size() == 0)  {

                            } else {
                                LocalDateTime earliestAvailable = Collections.min(allSpaceBookings.stream().map(Booking::getCheckOut).collect(Collectors.toList()));
                                long diffInMilli = Math.abs(earliestAvailable.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()) - LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                long diff = TimeUnit.HOURS.convert(diffInMilli, TimeUnit.MILLISECONDS);
                                nearBySpaces.get(i).setStatus("Available in" + diff);
                                if (clicked == nearBySpaces.get(i).getId()) {
                                    modelAndView.addObject("message", "This parking Space is not available for Booking!");
                                    modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotUserDashboard");
                                    return modelAndView;
                                }

                            }
                        }
                    }
                    parkingSpaceRepository.save(nearBySpaces.get(i));
                }
            }
            modelAndView.addObject("parkingSpace", new ParkingSpace());
            modelAndView.addObject("nearBySpaces", nearBySpaces);
            CurrentBooking.setCurrentBooking(booking);
            modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotScreen1UserDashboard");
            return modelAndView;
        }

    }


    @RequestMapping(value = "/Dashboard/c/BookingSlot/Checkout", method = RequestMethod.POST)
    public ModelAndView CheckoutOrFillDetails(ModelAndView modelAndView, @RequestParam("group1") int count) {
        // carOwner.fillCarOwner();
        // ParkingSpace parkingSpace = new ParkingSpace();
        List<ParkingSpace> nearBySpaces = parkingSpaceRepository.findAllByLocation(location);
        modelAndView.addObject("nearBySpaces", nearBySpaces);
        modelAndView.addObject("count", count);
        //modelAndView.addObject("parkingSpace", parkingSpace);
         ParkingSpace bookParkingSpace = parkingSpaceRepository.findById(count);
        if (!(bookParkingSpace.getStatus().equals("Available"))) {
            modelAndView.addObject("message", "Not Available for booking");
            modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotScreen1UserDashboard");}
         else if (bookParkingSpace == null) {
            modelAndView.addObject("message", "Please select one");
            modelAndView.setViewName("/DashboardModule2/UserDashboard/BookingSlotScreen1UserDashboard");
            } else {
            Booking currentBooking = CurrentBooking.getCurrentBooking();
            currentBooking.setSpace(count);
            CurrentBooking.setCurrentBooking(currentBooking);
            modelAndView.setViewName("redirect:/Dashboard/c/BookingSlot/Checkout");
            }
            return modelAndView;

        }
        @RequestMapping(value = "/Dashboard/c/BookingSlot/Checkout", method = RequestMethod.GET)
        public ModelAndView displayCheckout(ModelAndView modelAndView)  {

        Booking booking = CurrentBooking.getCurrentBooking();
        long totalTimeMilli = Math.abs(booking.getCheckOut().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()- booking.getCheckIn().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        long totalTime =  TimeUnit.HOURS.convert(totalTimeMilli, TimeUnit.MILLISECONDS);
        long totalCost = 25*totalTime;
        modelAndView.addObject("totalTime", totalTime);
        modelAndView.addObject("totalCost", totalCost);
        CarOwner currentUser = CurrentUser.getCurrentUser();
        if(currentUser.getWallet()<totalCost)
        {
            modelAndView.addObject("message", "Please add money before proceeding");
            modelAndView.setViewName("/DashboardModule2/UserDashboard/CheckoutUserDashboard");
        }
        else {
            currentUser.setWallet(currentUser.getWallet()-totalCost);
            CurrentUser.setCurrentUser(currentUser);
            Booking currentBooking = CurrentBooking.getCurrentBooking();
            currentBooking.setUsername(currentUser.getUsername());
            bookingRepository.save(currentBooking);
            modelAndView.setViewName("/DashboardModule2/UserDashboard/HomeUserDashboard");
        }
        return modelAndView;

        }

}