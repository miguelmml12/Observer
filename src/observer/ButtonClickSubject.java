package observer;

import java.util.ArrayList;
import java.util.List;

public class ButtonClickSubject {
    private List<Observer> observers = new ArrayList<>();

    public void register(Observer o) {
        observers.add(o);
    }

    public void notifyAllObservers(String color) {
        for (Observer o : observers) {
            o.update(color);
        }
    }
}
