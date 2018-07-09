package stravaApi;

import javastrava.model.StravaActivity;
import javastrava.model.StravaAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AthleteDataRetriever {

    @Autowired
    private ApiBuilder apiBuilder;

    public AthleteDataRetriever(){}

    public String getAthleteName() {
        StravaAthlete athlete = apiBuilder.build().getAuthenticatedAthlete();

        return athlete.getFirstname() + " " + athlete.getLastname();
    }

    public String[] getAthleteRoutes() {
        List<StravaActivity> activityList = apiBuilder.build().listAllAuthenticatedAthleteActivities();

        String[] routes = new String[activityList.size()];

        for (int i = 0; i < activityList.size(); i++) {
            routes[i] = activityList.get(i).getMap().getPolyline();
        }

        return routes;
    }
}
