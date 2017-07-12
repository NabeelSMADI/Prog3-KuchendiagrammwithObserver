package observer;


public class ChartObserver implements Observer{
    private double min;
    private double max;
    private double wert;

    private static int observerIDTracker = 0;
    private int observerID;

    private Subject ChartSubject;


    public ChartObserver(Subject ChartSubject){

        // Store the reference to the stockGrabber object so
        // I can make calls to its methods

        this.ChartSubject = ChartSubject;

        // Assign an observer ID and increment the static counter

        this.observerID = ++observerIDTracker;

        // Message notifies user of new observer

        System.out.println("New Observer " + this.observerID);

        // Add the observer to the Subjects ArrayList

        ChartSubject.register(this);

    }


    public void update(double min, double max, double wert) {
        this.min = min;
        this.max = max;
        this.wert = wert;
        Main.Kuchendiagramm.update();
    }

    public double getMin(){
        return this.min ;
    }

    public double getMax(){
        return this.max ;
    }

    public double getWert(){
        return this.wert ;
    }
}
