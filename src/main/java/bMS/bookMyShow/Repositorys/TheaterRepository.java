package bMS.bookMyShow.Repositorys;

import bMS.bookMyShow.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {

    TheaterEntity findByNameAndCity(String name,String city);

}
