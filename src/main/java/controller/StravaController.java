package controller;

import domain.Athlete;
import stravaApi.AthleteDataRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StravaController {

    @Autowired
    private AthleteDataRetriever dataRetriever;

    @CrossOrigin
    @GetMapping("/stravamap")
    public Athlete athleteData() {
        return new Athlete(dataRetriever.getAthleteName(), dataRetriever.getAthleteRoutes());
    }
}
