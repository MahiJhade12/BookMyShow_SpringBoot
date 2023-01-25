package bMS.bookMyShow.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private  LocalTime showTime;

    private double multiplier;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updateDate;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;  //many shows for one movie


    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;  //many show to one theater

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfSeats;  //one show for many seat

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private  List<TicketEntity> listOfTicket;  //one show for many ticket

}
