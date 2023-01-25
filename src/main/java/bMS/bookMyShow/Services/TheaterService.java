package bMS.bookMyShow.Services;

import bMS.bookMyShow.Dtos.TheaterRequestDto;
import bMS.bookMyShow.Enums.SeatType;
import bMS.bookMyShow.Models.TheaterEntity;
import bMS.bookMyShow.Models.TheaterSeatEntity;
import bMS.bookMyShow.Repositorys.TheaterRepository;
import bMS.bookMyShow.Repositorys.TheaterSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    public String createTheater(TheaterRequestDto theaterRequestDto){
        TheaterEntity theater=TheaterEntity.builder().name(theaterRequestDto.getName())
                .address(theaterRequestDto.getAddress()).city(theaterRequestDto.getCity())
                .build();
        List<TheaterSeatEntity> theaterSeatEntities=createTheaterSeat();
        theater.setTheaterSeatList(theaterSeatEntities);

        ///For each theater seat : we need to set theaterEntity
        //example in city there can be many theater for each theater we need to set seat
        for(TheaterSeatEntity theaterSeat:theaterSeatEntities){
            theaterSeat.setTheater(theater);
        }
        theaterRepository.save(theater);
        return "Theater added";
    }

    private List<TheaterSeatEntity> createTheaterSeat(){
        List<TheaterSeatEntity> theaterSeat=new ArrayList<>();

        for(int i=0;i<5;i++){
            char ch=(char)('A'+i);
            String seatNo="1"+ch;
            TheaterSeatEntity theaterSeatEntity=new TheaterSeatEntity(seatNo,SeatType.CLASSIC,100);
            theaterSeat.add(theaterSeatEntity);
        }
        for(int i=0;i<5;i++){
            char ch=(char)('A'+i);
            String seatNo="2"+ch;
            TheaterSeatEntity theaterSeatEntity=new TheaterSeatEntity(seatNo,SeatType.PLATINUM,200);
            theaterSeat.add(theaterSeatEntity);
        }


//        TheaterSeatEntity s1=TheaterSeatEntity.builder().seatNo("1A")
//                .seatType(SeatType.CLASSIC).rate(100).build();
//        TheaterSeatEntity s2=TheaterSeatEntity.builder().seatNo("1B")
//                .seatType(SeatType.CLASSIC).rate(100).build();
//        TheaterSeatEntity s3=TheaterSeatEntity.builder().seatNo("1C")
//                .seatType(SeatType.CLASSIC).rate(100).build();
//        TheaterSeatEntity s4=TheaterSeatEntity.builder().seatNo("1D")
//                .seatType(SeatType.CLASSIC).rate(100).build();
//        TheaterSeatEntity s5=TheaterSeatEntity.builder().seatNo("1E")
//                .seatType(SeatType.CLASSIC).rate(100).build();
//        TheaterSeatEntity s6=TheaterSeatEntity.builder().seatNo("2A")
//                .seatType(SeatType.PLATINUM).rate(200).build();
//        TheaterSeatEntity s7=TheaterSeatEntity.builder().seatNo("2B")
//                .seatType(SeatType.PLATINUM).rate(200).build();
//        TheaterSeatEntity s8=TheaterSeatEntity.builder().seatNo("2C")
//                .seatType(SeatType.PLATINUM).rate(200).build();
//        TheaterSeatEntity s9=TheaterSeatEntity.builder().seatNo("2D")
//                .seatType(SeatType.PLATINUM).rate(200).build();
//        TheaterSeatEntity s10=TheaterSeatEntity.builder().seatNo("2E")
//                .seatType(SeatType.PLATINUM).rate(200).build();
//        theaterSeat.add(s1);
//        theaterSeat.add(s2);
//        theaterSeat.add(s3);
//        theaterSeat.add(s4);
//        theaterSeat.add(s6);
//        theaterSeat.add(s7);
//        theaterSeat.add(s8);
//        theaterSeat.add(s9);
//        theaterSeat.add(s10);
        theaterSeatsRepository.saveAll(theaterSeat);
       return theaterSeat;
    }


}
