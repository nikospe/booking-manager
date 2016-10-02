
package basics;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {

    public static void main(String[] args) {
            /*ArrayList<Car> carList = new ArrayList();
            ArrayList<Driver> driverList = new ArrayList();
            ArrayList<Route> routeList = new ArrayList();
            ArrayList<Offer> offerList = new ArrayList();
            ArrayList<Request> requestList = new ArrayList();*/       
            
            /*ArrayList<Offer> allOffers=new ArrayList();
            ArrayList<Request> allRequests=new ArrayList();
            
            Car readyCar = new Car("Mercedes","CLK","ATH1234",3,2);
            Driver readyDriver = new Driver("Chris Kotronis","Male",21017,"chriskot92@hotmail.com",10);
            MyDate readyDepDay = new MyDate(14,11,2011);
            MyTime readyEarlyDepTime = new MyTime(10,0);
            MyTime readyLateDepTime = new MyTime(10,35);
            ArrayList<String> readyPitStops = new ArrayList();
            readyPitStops.add("Halandri");
            readyPitStops.add("Nomismatokopeio");
            readyPitStops.add("Syntagma");
            Route readyRoute = new Route("Vrilissia","Kallithea",readyDepDay,readyEarlyDepTime,readyLateDepTime,readyPitStops);
            Offer readyOffer = new Offer(readyRoute,readyDriver,readyCar);
            allOffers.add(readyOffer);*/
            
            
            /*System.out.println("Initialize offer from keyboard : ");
            Offer givenOffer = Control.initOffer();
            carList.add(givenOffer.getCarOffer());
            driverList.add(givenOffer.getDriverOffer());
            routeList.add(givenOffer.getRouteOffer());
            offerList.add(givenOffer);*/
            
            /*System.out.println("There are the following offers : ");
            System.out.println("The READY offer : ");
            System.out.println(readyOffer);
            /*System.out.println("The GIVEN offer : ");
            System.out.println(givenOffer);*/
            
            /*MyDate readyReqDepDay = new MyDate(14,11,2011);
            MyTime readyReqEarlyDepTime = new MyTime(10,0);
            MyTime readyReqLateDepTime = new MyTime(10,30);
            Route readyReqRoute = new Route("Syntagma","Kallithea",readyReqDepDay,readyReqEarlyDepTime,readyReqLateDepTime,null);
            int personNumber=2;
            Request readyRequest = new Request(readyReqRoute,personNumber);
            allRequests.add(readyRequest);*/
            
            /*System.out.println("Initialize request from keyboard :");
            Request givenRequest = Control.initRequest();
            requestList.add(givenRequest);*/
            
            /*System.out.println("There are the following requests : ");
            System.out.println("The READY request : ");
            System.out.println(readyRequest);
            /*System.out.println("The GIVEN request : ");
            System.out.println(givenRequest);*/
            
            /*ArrayList<Offer> readyOffers=null;
            ArrayList<Request> readyRequests=null;
            
            readyOffers= Control.readOffersFromFile("Offers.txt");
            allOffers.addAll(readyOffers);
            
            readyRequests = Control.readRequestsFromFile("Requests.txt"); 
            allRequests.addAll(readyRequests);

            Control.findMatchings(readyOffers,readyRequests);

            Control.writeOffersToFile("New_Offers.txt", allOffers);
            Control.writeRequestsToFile("New_Requests.txt", allRequests);
            */
            /*ArrayList<Route> okRoutes;
            System.out.println("Checking 1st request...");
            okRoutes=Control.matchRoutes(offerList, readyRequest);
            if (okRoutes.isEmpty()==false) {
                Control.printRoutes(okRoutes);
            }
            /*System.out.println("Checking 2nd request...");
            okRoutes=Control.matchRoutes(offerList, allRequests);
            if (okRoutes.isEmpty()==false) {
                Control.printRoutes(okRoutes);
            }*/
            
            mainFrame MyMainFrame = new mainFrame();
    }
}
 