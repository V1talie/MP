package mediaplayer.Memento;

import javafx.util.Duration;

public class StateChange {
    private Duration state;
    public void set(Duration state) {
        this.state = state;
    }
    public Memento save() {
        return new Memento(this.state);
    }
    public Duration restore(Memento memento) {
        this.state = memento.getState();
        return state;
    }
}
