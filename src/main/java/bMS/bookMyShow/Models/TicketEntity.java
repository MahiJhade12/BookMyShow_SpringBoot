package bMS.bookMyShow.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ticket")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allotted_seat;

    private int amount;

    private Date booked_at;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL) //one ticket can buy  many seat
    private List<ShowSeatEntity> ListOfShow;

    @ManyToOne
    @JoinColumn
    private UserEntity user;  //many ticket is connected to one user

     @ManyToOne
     @JoinColumn
     private ShowEntity show;
}
