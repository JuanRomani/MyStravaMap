package stravaApi;

import javastrava.auth.AuthorisationService;
import javastrava.auth.impl.AuthorisationServiceImpl;
import javastrava.service.Strava;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiBuilder {

    @Value("${clientId}")
    private Integer clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${code}")
    private String code;

    private AuthorisationService authService;

    ApiBuilder() {
        authService = new AuthorisationServiceImpl();
    }

    Strava build() {
        return new Strava(authService.tokenExchange(clientId, clientSecret, code));
    }
}
