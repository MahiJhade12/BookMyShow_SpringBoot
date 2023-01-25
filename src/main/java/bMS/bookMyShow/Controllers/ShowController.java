package bMS.bookMyShow.Controllers;


import bMS.bookMyShow.Dtos.ShowRequestDto;
import bMS.bookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add_show")
   public String addShow(@RequestBody ShowRequestDto showRequestDto){
     return showService.addShow(showRequestDto);
   }
}
