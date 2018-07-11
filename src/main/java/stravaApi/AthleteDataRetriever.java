package stravaApi;

import javastrava.model.StravaActivity;
import javastrava.model.StravaAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        List<Long> activitiesId = new ArrayList<>();

        for (StravaActivity activity : apiBuilder.build().listAllAuthenticatedAthleteActivities()) {
            activitiesId.add(activity.getId());
        }

        String[] routes = new String[activitiesId.size()];

        for (int i = 0; i < routes.length; i++) {
            routes[i] =  apiBuilder.build().getActivity(activitiesId.get(i)).getMap().getPolyline();
        }

        return routes;
    }
}
