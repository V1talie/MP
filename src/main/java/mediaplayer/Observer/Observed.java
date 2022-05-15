package mediaplayer.Observer;


public interface Observed {
    public void addObserver(Observer o);
    public void notifyObservers();
}
