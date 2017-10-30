package cz.spring.boot.start.start.controller;

import cz.spring.boot.start.start.model.Visit;
import cz.spring.boot.start.start.repository.VisitsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Controller
public class IndexController {

    final VisitsRepository visitsRepository;

    public IndexController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @GetMapping("/")
    public ModelAndView index() {

        Map<String,String> model=new HashMap<>();
        model.put("name", "Alexey");
        model.put("surname","Mironov");
        model.put("age","33");


        Visit visit=new Visit();
        visit.setDescription(String.format("Visit at %s", LocalDateTime.now()));
        visitsRepository.save(visit);

//        ModelAndView modelAndView=new ModelAndView("index");
//        modelAndView.addObject("name", "Alexey");
//        modelAndView.addObject("surname","Mironov");
//        modelAndView.addObject("age","33");
//        return  modelAndView;
        ModelAndView modelAndView= new ModelAndView("index",model);
        return modelAndView;
    }
}
