package veg.vegi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import veg.vegi.domain.Place;
import veg.vegi.service.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    PlaceService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/post")
    public Place post(@RequestBody Place place) {
        return service.save(place);
    }

    @GetMapping("/all")
    public List<Place> getAll(@RequestParam double x, @RequestParam double y, @RequestParam double radius){
        return service.att(x, y, radius);
    }
}
