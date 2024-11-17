package org.example.eventsystem.Controller;


import org.example.eventsystem.ApiResponse.ApiResponse;
import org.example.eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/events-system")

public class EventController {


    ArrayList<Event> events = new ArrayList<Event>();

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added successfully");
    }

    @GetMapping("displayAllEvents")
    public ArrayList<Event> getEvents() {
        return events;

    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
        events.set(index, event);
        return new ApiResponse("Event updated successfully");
    }

    @DeleteMapping(path = "/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Event deleted successfully");
    }

    //End CRUD endpoints


    @PutMapping(path = "/changeCapacity/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index,@PathVariable int capacity) {

        for(int i = 0 ; i < events.size() ; i++) {
            if(index == i) {
                events.get(i).setCapacity(capacity);
            }

            if(index < 0 || index >= events.size()) { //Incorrect index..out of bounds
                return new ApiResponse("Event not found");
            }


        } //End for
        return new ApiResponse("Event capacity changed successfully");
    }


    //Search for a event by given id

    @GetMapping("/searchEvent/{ID}")
    public ArrayList<Event> searchEvents(@PathVariable String ID) {
        ArrayList<Event> events1 = new ArrayList<>();
        for(Event event : events) {
            if(event.getID().equals(ID))
                events1.add(event);
        } //End for
        return events1;
    }


} //End controller
