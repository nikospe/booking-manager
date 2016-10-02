
package basics;
import java.util.*;


public class Route {
    
    private String leaveFromTown;
    private String goToTown;
    private MyDate departureDay;
    private MyTime earlyDepTime;
    private MyTime lateDepTime;
    private ArrayList<String> pitStops;

    public MyDate getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(MyDate departureDay) {
        this.departureDay = departureDay;
    }

    public MyTime getEarlyDepTime() {
        return earlyDepTime;
    }

    public void setEarlyDepTime(MyTime earlyDepTime) {
        this.earlyDepTime = earlyDepTime;
    }

    public String getGoToTown() {
        return goToTown;
    }

    public void setGoToTown(String goToTown) {
        this.goToTown = goToTown;
    }

    public MyTime getLateDepTime() {
        return lateDepTime;
    }

    public void setLateDepTime(MyTime lateDepTime) {
        this.lateDepTime = lateDepTime;
    }

    public String getLeaveFromTown() {
        return leaveFromTown;
    }

    public void setLeaveFromTown(String leaveFromTown) {
        this.leaveFromTown = leaveFromTown;
    }

    public ArrayList<String> getPitStops() {
        return pitStops;
    }

    public void setPitStops(ArrayList<String> pitStops) {
        this.pitStops = pitStops;
    }

    public String toString() {
        String RouteString= "" + leaveFromTown + ";" + goToTown + ";" + departureDay + ";" + earlyDepTime + ";" + lateDepTime + "";
        if (pitStops!=null) {
            RouteString = RouteString + ";" + pitStops.get(0);
            for (int i=1;i<pitStops.size();i++) {
                String pit=pitStops.get(i);
                RouteString=RouteString+"," + pit + "";
            }
        }
        else {
            RouteString = RouteString + ";";
        }
        return RouteString;
    }

    public Route(String leaveFromTown, String goToTown, MyDate departureDay, MyTime earlyDepTime, MyTime lateDepTime, ArrayList<String> pitStops) {
        this.leaveFromTown = leaveFromTown;
        this.goToTown = goToTown;
        this.departureDay = departureDay;
        this.earlyDepTime = earlyDepTime;
        this.lateDepTime = lateDepTime;
        this.pitStops = pitStops;
    }
      
}
