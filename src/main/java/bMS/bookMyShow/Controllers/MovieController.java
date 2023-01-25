package bMS.bookMyShow.Controllers;

import bMS.bookMyShow.Dtos.MovieRequestDto;
import bMS.bookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public String addMovie(@RequestBody MovieRequestDto movieRequestDto){
        return movieService.createMovie(movieRequestDto);
    }

}
