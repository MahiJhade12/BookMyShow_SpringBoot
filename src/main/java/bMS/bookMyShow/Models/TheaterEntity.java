package bMS.bookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
@Table(name = "theater")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String city;
    private  String address;


    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL) //one theater can have many shows
    private List<ShowEntity> listOfShow;


    //List of theater Seats
    //parent for theater seats....its will have many theaterSeats.. its real theater
     @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
     private List<TheaterSeatEntity> theaterSeatList;  //one theater have many theater seat

    public List<TheaterSeatEntity> getTheaterSeatList() {
        return theaterSeatList;
    }

    public void setTheaterSeatList(List<TheaterSeatEntity> theaterSeatList) {
        this.theaterSeatList = theaterSeatList;
    }
}
  //cascade is current class is parent to other child class