
package basics;


public class Request {
    
    private Route routeRequest;
    private int personNumber;

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public Route getRouteRequest() {
        return routeRequest;
    }

    public void setRouteRequest(Route routeRequest) {
        this.routeRequest = routeRequest;
    }

    public String toString() {
        return routeRequest + "" + personNumber;
    }

    public Request(Route routeRequest, int personNumber) {
        this.routeRequest = routeRequest;
        this.personNumber = personNumber;
    }
    
}
