package com.meteoweb.web;

import com.meteoweb.domain.StationInformation;
import com.meteoweb.repository.StationInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({ "/", "/index" })
public class StationInformationController {

    @Autowired
    private StationInformationRepository stationInformationRepository;

    @Autowired
    private EntityManager em;

    @GetMapping("/")
    private String searchStationInformation(Model model){

        List<StationInformation> stationInformation =  stationInformationRepository.findAll();
        model.addAttribute("stationInformation", stationInformation);

        return "view";
    }

    @GetMapping("/search")
    private String search(@RequestParam(value = "search", required = false) String search, Model model){

        TypedQuery<StationInformation> query = (TypedQuery<StationInformation>) em.createQuery(search);

        List<StationInformation> stationInformations = query.getResultList();

        //SELECT e FROM  StationInformation e
        if(stationInformations==null)
            model.addAttribute("stationInformation", Arrays.asList());
        else
            model.addAttribute("stationInformation",stationInformations);

        return "view";
    }



}
