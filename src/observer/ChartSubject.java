package observer;



import java.util.ArrayList;
import java.util.Observer;

// Uses the Subject interface to update all Observers

public class ChartSubject implements Subject {

    private ArrayList<ChartObserver> observers;
    private double min;
    private double max;
    private double wert;

    public ChartSubject(){

        // Creates an ArrayList to hold all observers

        observers = new ArrayList<ChartObserver>();
    }

    public void register(ChartObserver newObserver) {

        // Adds a new observer to the ArrayList

        observers.add(newObserver);

    }

    public void unregister(Observer deleteObserver) {

        // Get the index of the observer to delete

        int observerIndex = observers.indexOf(deleteObserver);

        // Print out message (Have to increment index to match)

        System.out.println("Observer " + (observerIndex+1) + " deleted");

        // Removes observer from the ArrayList

        observers.remove(observerIndex);

    }



    public void notifyObserver() {

        // Cycle through all observers and notifies them of
        // price changes

        for(ChartObserver observer : observers){

            observer.update(min, max, wert);

        }
    }

    public void setWert(double min, double max, double x){
        this.min = min;
        this.max = max;
        this.wert = x;
    }

}