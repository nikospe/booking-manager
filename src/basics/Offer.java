
package basics;


public class Offer {
    
    private Route routeOffer;
    private Driver driverOffer;
    private Car carOffer;

    public Car getCarOffer() {
        return carOffer;
    }

    public void setCarOffer(Car carOffer) {
        this.carOffer = carOffer;
    }

    public Driver getDriverOffer() {
        return driverOffer;
    }

    public void setDriverOffer(Driver driverOffer) {
        this.driverOffer = driverOffer;
    }

    public Route getRouteOffer() {
        return routeOffer;
    }

    public void setRouteOffer(Route routeOffer) {
        this.routeOffer = routeOffer;
    }

    public String toString() {
        return routeOffer + "\r\n" + carOffer + "\r\n" + driverOffer;
    }

    public Offer(Route routeOffer, Driver driverOffer, Car carOffer) {
        this.routeOffer = routeOffer;
        this.driverOffer = driverOffer;
        this.carOffer = carOffer;
    }
       
}
