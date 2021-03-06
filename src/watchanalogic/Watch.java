package watchanalogic;
import java.util.*;

public class Watch {
    private double seconds = Math.PI/2;
    private double minutes = Math.PI/2;
    private double hours = Math.PI/2;
    private List<Observer> observers = new ArrayList<>();

    // Constructor
    public Watch() {
        Timer timer = new Timer();
        timer.schedule(task(), 0, 100);
    }

    // Getters
    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    // Method to add new observers
    public void add(Observer o){
        observers.add(o);
    }
    
    // Method to update all the observers when status changes
    private void notifyObservers(){
        for(Observer observer: observers)
            observer.update();
    }
    
    private TimerTask task() {
        return new TimerTask(){
            private static final double PI2 = Math.PI*2;
            private static final double DegreesPerSecond = PI2/60;
            private static final double DegreesPerMinute = DegreesPerSecond/60;
            private static final double DegreesPerHour = DegreesPerMinute/12;
            
               
            @Override
            public void run() {
                seconds = normalize(seconds - DegreesPerSecond);
                minutes = normalize(minutes - DegreesPerMinute);
                hours = normalize(hours - DegreesPerHour);
                notifyObservers();
            }

            private double normalize(double angle) {
                return (angle + PI2) % PI2;
            }
        };
        
    }
    
    
    
}
