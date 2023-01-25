package bMS.bookMyShow.Controllers;

import bMS.bookMyShow.Dtos.TheaterRequestDto;
import bMS.bookMyShow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @PostMapping("/add_theater")
    public String addTheater(TheaterRequestDto theaterRequestDto){
     return theaterService.createTheater(theaterRequestDto);
    }

}
