package bMS.bookMyShow.Controllers;


import bMS.bookMyShow.Dtos.BookTicketRequestDto;
import bMS.bookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService bookTicketService;

    @RequestMapping("/book_ticket")
    public String bookTicket( @RequestBody BookTicketRequestDto bookTicketRequestDto) {
        try {
         return bookTicketService.bookTicket(bookTicketRequestDto);
        } catch (Exception e) {
            return "request seats not available";
        }
    }

}
