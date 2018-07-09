package domain;

public class Athlete {

    private String name;
    private String[] routes;

    public Athlete(){}

    public Athlete(String name, String[] routes) {
        this.setName(name);
        this.setRoutes(routes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRoutes() {
        return routes;
    }

    public void setRoutes(String[] routes) {
        this.routes = routes;
    }
}
