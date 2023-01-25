package bMS.bookMyShow.Services;
import bMS.bookMyShow.Dtos.ShowRequestDto;
import bMS.bookMyShow.Models.*;
import bMS.bookMyShow.Repositorys.MovieRepository;
import bMS.bookMyShow.Repositorys.ShowRepository;
import bMS.bookMyShow.Repositorys.ShowSeatsRepository;
import bMS.bookMyShow.Repositorys.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {


    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowRequestDto showRequestDto){
        ShowEntity showEntity=ShowEntity.builder().showTime(showRequestDto.getShowTime())
                .showDate(showRequestDto.getShowDate())
                .multiplier(showRequestDto.getMultiplier()).build();


        //To add which movie will play in show
        MovieEntity movieEntity =movieRepository.findByMovieName(showRequestDto.getMovieName());

        // To add in which theater show will play
        TheaterEntity theaterEntity=theaterRepository.findById(showRequestDto.getTheaterId()).get();

        //adding show list in movie entity
        movieEntity.getListOfShow().add(showEntity);

        //adding show list in theater entity
        theaterEntity.getListOfShow().add(showEntity);


        //aading movie and theater in show
        //doing vice-versa
        showEntity.setMovie(movieEntity);
        showEntity.setTheater(theaterEntity);

        List<ShowSeatEntity> showSeatEntitiesList= createShowSeats(theaterEntity.getTheaterSeatList());

        showEntity.setListOfSeats(showSeatEntitiesList);

        //for each Show seats we need to mark shoeEntity
        for (ShowSeatEntity showSeat: showSeatEntitiesList){
            showSeat.setShow(showEntity);
        }

        movieRepository.save(movieEntity);
        theaterRepository.save(theaterEntity);
        //this does not need to be called bcs we are calling above parent function movie
       // showRepository.save(showEntity);

        return  "Show added successfully";

    }
    public List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> theaterSeatEntitiesList){

        List<ShowSeatEntity> showSeatEntities=new ArrayList<>();
        for (TheaterSeatEntity theaterSeat:theaterSeatEntitiesList){
            ShowSeatEntity showSeat=ShowSeatEntity.builder()
                    .seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).build();
               showSeatEntities.add(showSeat);
        }
        showSeatsRepository.saveAll(showSeatEntities);
        return showSeatEntities;
    }

}
