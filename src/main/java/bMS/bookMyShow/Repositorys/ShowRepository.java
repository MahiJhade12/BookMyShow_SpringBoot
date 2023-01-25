package bMS.bookMyShow.Repositorys;

import bMS.bookMyShow.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
