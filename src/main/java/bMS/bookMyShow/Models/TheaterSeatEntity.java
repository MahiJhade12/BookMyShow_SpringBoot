package bMS.bookMyShow.Models;

import bMS.bookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "theater_seat")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheaterSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

     @Enumerated(value = EnumType.STRING)
     private SeatType seatType;

     private int rate;


     //child table unidirectional
     @ManyToOne
     @JoinColumn
     private TheaterEntity theater; //many theater_seat can be in one theater


    public TheaterSeatEntity(String seatNo, SeatType seatType, int rate) {
        this.seatNo=seatNo;
        this.rate=rate;
        this.seatType=seatType;
    }
}