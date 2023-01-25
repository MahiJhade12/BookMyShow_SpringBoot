package bMS.bookMyShow.Repositorys;

import bMS.bookMyShow.Models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatEntity,Integer> {
}
