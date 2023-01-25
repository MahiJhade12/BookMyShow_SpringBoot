package bMS.bookMyShow.Repositorys;

import bMS.bookMyShow.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeatEntity,Integer> {
}
