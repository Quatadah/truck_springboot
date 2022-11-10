package com.example.TruckProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/truck")
public class Controller {

    @Autowired ServiceTruck serviceTruck;

    @GetMapping("/{id}")
    public Position get(@PathVariable int id){
        Truck truck = serviceTruck.getById(id);
        return truck.getPosition();
    }

    @RequestMapping("/{id}/map")
    public RedirectView localRedirect(@PathVariable int id) {
        RedirectView redirectView = new RedirectView();
        String url = serviceTruck.getUrlById(id);
        redirectView.setUrl(url);
        return redirectView;
    }
}
