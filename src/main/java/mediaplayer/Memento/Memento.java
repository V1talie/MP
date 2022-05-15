package mediaplayer.Memento;

import javafx.util.Duration;

public class Memento {
    private final Duration state;
    public Memento(Duration state){
        this.state = state;
    }
    Duration getState(){
        return state;
    }
}
