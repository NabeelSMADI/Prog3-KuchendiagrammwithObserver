package observer;

import java.util.Observer;

public interface Subject {

    public void register(ChartObserver o);
    public void unregister(Observer o);
    public void notifyObserver();

}