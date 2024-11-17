package org.example.eventsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {


  //  event Class : ID , description , capacity, startDate , endDate

    private String ID;
    private String description;
    private int capacity;

    //We can use the @JsonFormat annotation to format a specific field:
    @JsonFormat (pattern="yyyy-MM-dd")
    private Date startDate;   //Using Date to only show the date without time

    @JsonFormat (pattern="yyyy-MM-dd")
    private Date endDate;



}
