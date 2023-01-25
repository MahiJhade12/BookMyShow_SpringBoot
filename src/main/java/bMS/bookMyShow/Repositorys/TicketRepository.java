package bMS.bookMyShow.Repositorys;

import bMS.bookMyShow.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
