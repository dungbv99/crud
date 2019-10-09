package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
public class TourController {
    @Autowired
    private  TourRepository tourRepository;

    private List<Tour> init(){
        Iterator<Tour> iteratorTour = tourRepository.findAll().iterator();
        List<Tour> listTour = new ArrayList<Tour>();
        int i = 0;
        while (iteratorTour.hasNext()){
            Tour tour = iteratorTour.next();
//            i += 1;
//            tour.setId(i);
            listTour.add(tour);
        }
        return  listTour;
    }

    @GetMapping("/showTour")
    public String showTourPage(Model model){
        List<Tour> listTour = init();

        model.addAttribute("listTour",listTour);

        return "showTour";
    }


    @GetMapping("/addTour")
    public String showAddTourPage(Model model){
        System.out.println("********************");
        //List<Tour> listTour = init();
        Tour tour = new Tour();
        //tour.setId(listTour.size()+1);
        model.addAttribute("tour",tour);
        return "addTour";
    }
    @PostMapping("/addTour")
    public String showAfterAddTourPage(@ModelAttribute("tour") Tour tour){
        tourRepository.save(tour);
        return "home";
    }


    @GetMapping("/getIdEditTour")
    public String getIdEditTour(Model model){
        intClass id = new intClass();
        model.addAttribute("id",id);
        return "getIdEditTour";
    }

    @PostMapping("/getIdEditTour")
    public String getIdEditTour(@ModelAttribute("id") intClass id, Model model){
        List<Tour> listTour = init();
        for (Tour tour: listTour) {
            if(tour.getId() == id.n){


                model.addAttribute("tour", tour);
                //tourRepository.delete(tour);
                //tourRepository.deleteById(id.n);
                break;
            }
        }
        return "editTour";
    }

    @PostMapping("/editTour")
    public String editTour(@ModelAttribute("tour") Tour tour){
        System.out.println(tourRepository);
        //this.tourRepository.deleteById(tour.getId());
        this.tourRepository.save(tour);



        //tourRepository
        return "home";
    }

    @GetMapping("/deleteTourId")
    private String deleteTour(Model model){
        intClass id = new intClass();
        model.addAttribute("id",id);
        return "deleteTourId";
    }

    @PostMapping("/deleteTourId")
    private String deleteTour(@ModelAttribute("id") intClass id){
        //Tour tour = new Tour();

        tourRepository.deleteById(id.n);
        return "home";
    }
}
