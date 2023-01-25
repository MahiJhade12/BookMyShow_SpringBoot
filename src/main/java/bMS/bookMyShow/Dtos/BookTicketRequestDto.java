package bMS.bookMyShow.Dtos;

import lombok.Data;

import java.util.Date;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> a6f88ca (Book_My_Show)

@Data
public class BookTicketRequestDto {

<<<<<<< HEAD
    private String allotted_seat;

    private int amount;

    private Date booked_at;
=======
    private List< String> requested_seats;

    private int showId;

    private int userId;
>>>>>>> a6f88ca (Book_My_Show)

}
