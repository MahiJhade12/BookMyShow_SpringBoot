package bMS.bookMyShow.Dtos;

import lombok.Data;

import java.util.Date;


import java.util.List;

@Data
public class BookTicketRequestDto {


    private String allotted_seat;

    private int amount;

    private Date booked_at;

    private List< String> requested_seats;

    private int showId;

    private int userId;


}
