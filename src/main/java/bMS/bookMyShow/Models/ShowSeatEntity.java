package bMS.bookMyShow.Models;


import bMS.bookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "show_seat")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

     @Enumerated(value = EnumType.STRING)
     private SeatType seatType;

     private boolean isAvailable;  //to check if seat it available

     private Date bookAt;  //automatic we will set its value while booking ticket



    @ManyToOne
    @JoinColumn
    private  ShowEntity show;  //many show seat can be in a show

    @ManyToOne
    @JoinColumn
    private TicketEntity ticket; //many show seat can buy in one ticket

    //joincolumn -current class child to that class
}
