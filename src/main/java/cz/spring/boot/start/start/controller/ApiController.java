package cz.spring.boot.start.start.controller;

import cz.spring.boot.start.start.model.Visit;
import cz.spring.boot.start.start.repository.VisitsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class ApiController {

    private VisitsRepository visitsRepository;

    public ApiController(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    @GetMapping("/visits")
    public Iterable<Visit> getVisits(){
        Iterable<Visit> visits=visitsRepository.findAll();
//        for (Iterable iterable: visits
//             ) {
//
//        }
        return visits;
    }
}
