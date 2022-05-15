package mediaplayer.decorator;

public class HistoryDecorator implements History{
    private final History history;
    HistoryDecorator(History history){
        this.history = history;
    }
    @Override
    public void add(String s) {
        history.add(s);
    }
    @Override
    public void clear() {
        history.clear();
    }
}
