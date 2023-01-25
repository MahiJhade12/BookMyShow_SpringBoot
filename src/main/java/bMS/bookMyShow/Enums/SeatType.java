package bMS.bookMyShow.Enums;

import bMS.bookMyShow.Models.TheaterSeatEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public enum SeatType {
     CLASSIC,
     PLATINUM

}
