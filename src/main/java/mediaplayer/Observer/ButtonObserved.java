package mediaplayer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ButtonObserved implements Observed{

    List<String> event = new ArrayList<>();
    List<Observer> observers = new ArrayList<>();

    public void addEvent(String event){
        this.event.add(event);
        notifyObservers();
    }


    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }


    @Override
    public void notifyObservers() {
        for (Observer observer: observers){
            observer.handleEvent(this.event);
        }
    }
}