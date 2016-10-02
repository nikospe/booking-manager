
package basics;


public class MyTime {
    
    private int hour;
    private int minutes;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String toString() {
        return formatTime(this);
    }
    
    public static String formatTime(MyTime tim) {
        
        int hour=tim.getHour();
        int min=tim.getMinutes();
        String formattedTime="";
        if (hour<10) {
            formattedTime+="0";
        }
        formattedTime+=Integer.toString(hour);
        formattedTime+=":";
        if (min<10) {
             formattedTime+="0";
        }
        formattedTime+=Integer.toString(min);
        return formattedTime;
        
    }

    public MyTime(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }
    
}
