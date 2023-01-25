package bMS.bookMyShow.Controllers;


import bMS.bookMyShow.Dtos.BookTicketRequestDto;
import bMS.bookMyShow.Services.BookTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    BookTicketService bookTicketService;

    @RequestMapping("/book_ticket")
    public String bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        try {
            return bookTicketService.BookTickes(bookTicketRequestDto);
        } catch (Exception e) {
            return "request seats not available";
        }
    }

}
