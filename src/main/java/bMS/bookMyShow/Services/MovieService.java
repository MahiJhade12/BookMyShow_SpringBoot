package bMS.bookMyShow.Services;

import bMS.bookMyShow.Dtos.MovieRequestDto;
import bMS.bookMyShow.Models.MovieEntity;
import bMS.bookMyShow.Repositorys.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String createMovie(MovieRequestDto movieRequestDto){
        MovieEntity movie= MovieEntity.builder().movieName(movieRequestDto.getMovieName()).
                duration(movieRequestDto.getDuration())
                .releaseDate(movieRequestDto.getReleaseDate())
                .build();
        try {
            movieRepository.save(movie);
        }
        catch (Exception e){
            return "movie can not add";
        }
          return "movie added successfully";
    }
}
