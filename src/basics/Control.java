
package basics; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Control {

    public static Car readCar(String line) {
        
        StringTokenizer ST = new StringTokenizer(line, ";");
        String brand = ST.nextToken();
        String model = ST.nextToken();
        String boardNumber = ST.nextToken();
        String totalSeatsStr = ST.nextToken();
        int totalSeats = new Integer(totalSeatsStr).intValue();      
        String availableSeatsStr = ST.nextToken();
        int availableSeats = new Integer(availableSeatsStr).intValue();      
        Car returnCar = new Car(brand, model, boardNumber, totalSeats, availableSeats);
        return returnCar;
    
    }
    
    public static Driver readDriver(String line) {
        
        StringTokenizer ST = new StringTokenizer(line, ";");
        String name = ST.nextToken();
        String sex = ST.nextToken();
        String comNumberStr = ST.nextToken();
        int comNumber = new Integer(comNumberStr).intValue();
        String eMail = ST.nextToken();
        String expYearsStr = ST.nextToken();
        int expYears = new Integer(expYearsStr).intValue();
        Driver returnDriver = new Driver(name, sex, comNumber, eMail, expYears);
        return returnDriver;
    
    }
    
    public static Route readRoute(String line,int pitStopsIncluded) {
        
        StringTokenizer ST1 = new StringTokenizer(line, ";");
        String leaveFromTown = ST1.nextToken();
        String goToTown = ST1.nextToken();
        String DATE = ST1.nextToken();
        StringTokenizer ST2 = new StringTokenizer(DATE, "-");
        String dayStr = ST2.nextToken();
        int day = new Integer(dayStr).intValue();
        String monthStr = ST2.nextToken();
        int month = new Integer(monthStr).intValue();
        String yearStr = ST2.nextToken();
        int year = new Integer(yearStr).intValue();
        MyDate departureDay = new MyDate(day,month,year);
        String ETIME = ST1.nextToken();
        StringTokenizer ST3 = new StringTokenizer(ETIME, ":");
        String hourStr = ST3.nextToken();
        int hour = new Integer(hourStr).intValue();
        String minutesStr = ST3.nextToken();
        int minutes = new Integer(minutesStr).intValue();
        MyTime earlyDepHour=new MyTime(hour,minutes);
        String LTIME = ST1.nextToken();
        StringTokenizer ST4 = new StringTokenizer(LTIME, ":");
        hourStr = ST4.nextToken();
        hour = new Integer(hourStr).intValue();
        minutesStr = ST4.nextToken();
        minutes = new Integer(minutesStr).intValue();
        MyTime lateDepHour=new MyTime(hour,minutes);
        ArrayList<String> pitStops = new ArrayList();
        if (pitStopsIncluded==1) {
            String PT = ST1.nextToken();
            StringTokenizer ST5 = new StringTokenizer(PT,",");
            while (ST5.hasMoreTokens()) {
		String pitStop=ST5.nextToken();
                pitStops.add(pitStop);
            }
        }
        else {
            pitStops=null;
        }
        Route returnRoute = new Route(leaveFromTown,goToTown, departureDay,earlyDepHour,lateDepHour,pitStops);
        return returnRoute;
    
    }
    
    public static ArrayList<Offer> readOffersFromFile(String Offers) throws FileNotFoundException {
        ArrayList<Offer> allOffers = new ArrayList<Offer>(); 
        try {
            File  offerFileIn= new File(Offers);
            Scanner offerScan = new Scanner(offerFileIn);
            while(offerScan.hasNextLine()) {
                String routeLine = offerScan.nextLine();
                Route Rot = readRoute(routeLine,1);
                String carLine = offerScan.nextLine();
                Car Cr = readCar(carLine);
                String driverLine = offerScan.nextLine();
                Driver Dr = readDriver(driverLine);
                Offer Off = new Offer(Rot,Dr,Cr);
                allOffers.add(Off);
            }
        }
        catch(FileNotFoundException fnfex){
            System.out.println("File not found!");
        }
        return allOffers;
    }
    
    public static void writeOffersToFile(String Offers, ArrayList<Offer> allOffers) {
        try{
            FileOutputStream offerFileOutStream = new FileOutputStream(Offers);
            PrintWriter offerFileOut = new PrintWriter(offerFileOutStream);
            for(int i=0; i<allOffers.size(); i++) {
                offerFileOut.println(allOffers.get(i));
            } 
            offerFileOut.close();
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
     
    public static ArrayList<Request> readRequestsFromFile(String Requests) throws FileNotFoundException {
        ArrayList<Request> allRequests = new ArrayList<Request>();
        try {
            File requestFileIn = new File(Requests);
            Scanner requestScan = new Scanner(requestFileIn);
            while(requestScan.hasNextLine()) {
                String line = requestScan.nextLine();
            
                StringTokenizer ST1 = new StringTokenizer(line, ";");
                String leaveFromTown = ST1.nextToken();
                String goToTown = ST1.nextToken();
                String DATE = ST1.nextToken();
                StringTokenizer ST2 = new StringTokenizer(DATE, "-");
                String dayStr = ST2.nextToken();
                int day = new Integer(dayStr).intValue();
                String monthStr = ST2.nextToken();
                int month = new Integer(monthStr).intValue();
                String yearStr = ST2.nextToken();
                int year = new Integer(yearStr).intValue();
                MyDate departureDay = new MyDate(day,month,year);
                String ETIME = ST1.nextToken();
                StringTokenizer ST3 = new StringTokenizer(ETIME, ":");
                String hourStr = ST3.nextToken();
                int hour = new Integer(hourStr).intValue();
                String minutesStr = ST3.nextToken();
                int minutes = new Integer(minutesStr).intValue();
                MyTime earlyDepHour=new MyTime(hour,minutes);
                String LTIME = ST1.nextToken();
                StringTokenizer ST4 = new StringTokenizer(LTIME, ":");
                hourStr = ST4.nextToken();
                hour = new Integer(hourStr).intValue();
                minutesStr = ST4.nextToken();
                minutes = new Integer(minutesStr).intValue();
                MyTime lateDepHour=new MyTime(hour,minutes);
                Route routeRequest = new Route(leaveFromTown,goToTown,departureDay,earlyDepHour,lateDepHour,null);
                String personNumberStr = ST1.nextToken();
                int personNumber = new Integer(personNumberStr).intValue();
                Request Req = new Request(routeRequest,personNumber);
                allRequests.add(Req);
            }
        }
        catch(FileNotFoundException fnfex){
            System.out.println("File not found!");
        }
        return allRequests;
    }
    
    public static void writeRequestsToFile(String Requests, ArrayList<Request> allRequests) {
        
        try{
            FileOutputStream requestFileOutStream = new FileOutputStream(Requests);
            PrintWriter requestFileOut = new PrintWriter(requestFileOutStream);
            for(int i=0; i<allRequests.size(); i++) {
                requestFileOut.println(allRequests.get(i));
            } 
            requestFileOut.close();
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
          
    }
    
     public static ArrayList<Offer> timeMatchingOffers(ArrayList<Offer> offers, MyDate depDay, MyTime earlyDepTime, MyTime lateDepTime) {
        
        ArrayList<Offer> matchOffers = new ArrayList();
        Iterator itrOffer = offers.iterator();
        while (itrOffer.hasNext()) {
            Offer nextOffer = (Offer) itrOffer.next();
            if (Overlap(depDay,earlyDepTime,lateDepTime,nextOffer.getRouteOffer())==true) {
                matchOffers.add(nextOffer);
            }
        }
        return matchOffers;
    }
    
    public static ArrayList<Offer> townMatchingOffers(ArrayList<Offer> offers, String leaveFromTown, String goToTown) {
        
        ArrayList<Offer> matchOffers = new ArrayList();
        Iterator itrOffer = offers.iterator();
        while (itrOffer.hasNext()) {
            Offer nextOffer = (Offer) itrOffer.next();
            int leaveFlag=0;
            int goFlag=0;
            if (leaveFromTown.equals(nextOffer.getRouteOffer().getLeaveFromTown())) {
                 leaveFlag=1; 
            }
            if (goToTown.equals(nextOffer.getRouteOffer().getGoToTown())) {
                 goFlag=1;
            }
            if (leaveFlag==0 || goFlag==0) {
                Iterator itrPitStops = nextOffer.getRouteOffer().getPitStops().iterator();
                while (itrPitStops.hasNext()) {
                    String nextPitStop  = (String) itrPitStops.next();
                    if (leaveFromTown.equals(nextPitStop)) {
                        if (goFlag==0) {
                            leaveFlag=1;
                        }
                    }
                    if (goToTown.equals(nextPitStop)) {
                        if (leaveFlag==1) {
                            goFlag=1;
                        }
                    }
                }
            }
            if (goFlag==1 && goFlag==1) {
                matchOffers.add(nextOffer);
            }
        }
        return matchOffers;
        
    }
    
    public static ArrayList<Offer> roomMatchingOffers(ArrayList<Offer> offers, int personNumber) {
        
        ArrayList<Offer> matchOffers = new ArrayList();
        Iterator itrOffer = offers.iterator();
        while (itrOffer.hasNext()) {
            Offer nextOffer = (Offer) itrOffer.next();
            if ((nextOffer.getCarOffer().getAvailableSeats())>=personNumber) {
                matchOffers.add(nextOffer);
            }
        }
        return matchOffers;
        
    }
    
    public static boolean Overlap(MyDate reqDepDate, MyTime reqEarlyDepTime, MyTime reqLateDepTime, Route checkRoute) {
        
        MyDate checkDepDate=checkRoute.getDepartureDay();
        if ((checkDepDate.getDay()!=reqDepDate.getDay()) || (checkDepDate.getMonth()!=reqDepDate.getMonth()) || (checkDepDate.getYear()!=reqDepDate.getYear())) {
            return false;
        }
        MyTime checkEarlyDepTime=checkRoute.getEarlyDepTime();
        MyTime checkLateDepTime=checkRoute.getLateDepTime();
        String compCheckEarlyDepTime=checkEarlyDepTime.toString();
        String compCheckLateDepTime=checkLateDepTime.toString();
        String compReqEarlyDepTime=reqEarlyDepTime.toString();
        String compReqLateDepTime=reqLateDepTime.toString();
        
        if ((compCheckEarlyDepTime.compareTo(compReqLateDepTime)>0) || (compCheckLateDepTime.compareTo(compReqEarlyDepTime)<0)) {
            return false;
        }
        else {
            return true;
        }
        
    }
    
    public static void findMatchings(ArrayList<Offer> offers, ArrayList<Request> requests) {
    
        Request req;
        PrintWriter out=null;
        try{
            FileWriter fstream = new FileWriter("output.txt");
            out = new PrintWriter(fstream);
        }
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    
        for (int i=0;i<requests.size();i++) {
            req=requests.get(i);
            ArrayList<Offer> finalOffers=new ArrayList();
            ArrayList<Offer> personOkOffers;
            ArrayList<Offer> TownOkOffers;
            ArrayList<Offer> timingOkOffers;
            
            personOkOffers = Control.roomMatchingOffers(offers,req.getPersonNumber());
            if (personOkOffers.isEmpty()==false) {
                TownOkOffers=Control.townMatchingOffers(personOkOffers,req.getRouteRequest().getLeaveFromTown(),req.getRouteRequest().getGoToTown());
                if (TownOkOffers.isEmpty()==false) {
                    timingOkOffers=Control.timeMatchingOffers(TownOkOffers,req.getRouteRequest().getDepartureDay(),req.getRouteRequest().getEarlyDepTime(),req.getRouteRequest().getLateDepTime());
                    if (timingOkOffers.isEmpty()==false) {
                        finalOffers=timingOkOffers;
                    }
                }
            }
            out.println("Request:"+(i+1));
            out.println(req.toString());
            out.println("Matching offers:");
            for (int j=0;j<finalOffers.size();j++) {
                 out.print(""+(j+1)+") ");
                 out.println(finalOffers.get(j).toString());
            }
            out.println();
        }
        out.close();
    }
}
            
    /*public static Car initCar() {
        
        Scanner Carkeyboard=new Scanner(System.in);
        System.out.println("Details for the car!");
        System.out.println("(1) Write the car's brand : ");
        String brand=Carkeyboard.nextLine();
        System.out.println("(2) Write the model of the car : ");
        String model=Carkeyboard.nextLine();
        System.out.println("(3) Give the car's plate number : ");
        String boardNumber=Carkeyboard.nextLine();
        System.out.println("(4) Give the total number of car's seats : ");
        int totalSeats=Carkeyboard.nextInt();
        System.out.println("(5) Give the number of available seats : ");
        int availableSeats=Carkeyboard.nextInt();
        Car returnCar = new Car(brand,model,boardNumber, totalSeats,availableSeats);
        return returnCar;
        
    }
    
    public static Driver initDriver() {
       
        Scanner Driverkeyboard=new Scanner(System.in);
        System.out.println("Details for the driver!");
        System.out.println("(1) Write the driver's name : ");
        String name=Driverkeyboard.nextLine();
        System.out.println("(2) Write the driver's sex : ");
        String sex=Driverkeyboard.nextLine();
        System.out.println("(3) Give the driver's communication number : ");
        int comNumber=Driverkeyboard.nextInt();
        Driverkeyboard.nextLine();
        System.out.println("(4) Write the e-mail of the driver : ");
        String eMail=Driverkeyboard.nextLine();
        System.out.println("(5) Give the driving experience years : ");
        int expYears=Driverkeyboard.nextInt();
        Driver returnDriver = new Driver( name,sex,comNumber,eMail,expYears);
        return returnDriver;
         
    }
    
    public static Route initRoute(int pitStopsIncluded) {
        
        Scanner Routekeyboard=new Scanner(System.in);
        System.out.println("Details for route! ");
        System.out.println("(1) Write the -leave from- name of the town : ");
        String leaveFromTown=Routekeyboard.nextLine();
        System.out.println("(2) Write the -go to- name of the town : ");
        String goToTown=Routekeyboard.nextLine();
        System.out.println("(3) Give the departure day : ");
        int day=Routekeyboard.nextInt();
        System.out.println("(4) Give the departure month : ");
        int month=Routekeyboard.nextInt();
        System.out.println("(5) Give the departure year : ");
        int year=Routekeyboard.nextInt();
        MyDate departureDay=new MyDate(day,month,year);
        System.out.println("(6) In case of leaving earlier, give the departure time (hour) : ");
        int hour=Routekeyboard.nextInt();
        System.out.println("(7) In case of leaving earlier, give the departure time (minutes) : ");
        int minutes=Routekeyboard.nextInt();
        MyTime earlyDepHour=new MyTime(hour,minutes);
        System.out.println("(8) In case of leaving later, give the departure time (hour) : ");
        hour=Routekeyboard.nextInt();
        System.out.println("(9) In case of leaving later, give the departure time (minutes) : ");
        minutes=Routekeyboard.nextInt();
        Routekeyboard.nextLine();
        MyTime lateDepHour=new MyTime(hour,minutes);
        ArrayList<String> pitStops = new ArrayList();
        if (pitStopsIncluded==1) {
            System.out.println("(10) Write the names of the 'pit stops' : (give arrival town to end) ");
            String pitStop=Routekeyboard.nextLine();
            while (pitStop.equals(goToTown)==false) {
                pitStops.add(pitStop);
                pitStop=Routekeyboard.nextLine();
            }
        }
        else {
            pitStops=null;
        }
        System.out.println("(11) Give the route's ID number : ");
        int routeID=Routekeyboard.nextInt();
        Route returnRoute=new Route(leaveFromTown,goToTown, departureDay,earlyDepHour,lateDepHour,pitStops,routeID);
        return returnRoute;
        
    }
    
    public static Offer initOffer() {
        
        System.out.println("Details for offer! ");
        Car carOffer = initCar();
        Driver driverOffer = initDriver();
        Route routeOffer = initRoute(1);
        Offer returnOffer = new Offer(routeOffer,driverOffer,carOffer);
        return returnOffer;
        
    }
    
    public static Request initRequest() {
        
        Route routeRequest = initRoute(0);
        Scanner Requestkeyboard=new Scanner(System.in);
        System.out.println("(12) Give the number of the persons : ");
        int personNumber = Requestkeyboard.nextInt();
        Request returnRequest = new Request(routeRequest,personNumber);
        return returnRequest;
        
    }
    */
   
    
/*    public static void printRoutes(ArrayList<Route> routes) {
        System.out.println("The available routes are the following : ");
        Iterator itrRoute = routes.iterator();
        while (itrRoute.hasNext()) {
            Route nextRoute = (Route) itrRoute.next();
            System.out.println(nextRoute);
        }
    }
   
}*/
