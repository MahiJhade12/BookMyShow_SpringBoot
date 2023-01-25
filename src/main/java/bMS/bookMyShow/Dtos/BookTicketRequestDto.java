package bMS.bookMyShow.Dtos;

import lombok.Data;

import java.util.Date;

@Data
public class BookTicketRequestDto {

    private String allotted_seat;

    private int amount;

    private Date booked_at;

}
