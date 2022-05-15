package mediaplayer.decorator;

import java.util.ArrayList;
import java.util.List;

public class addSingle implements History {
    List<miniFile> list = new ArrayList<>();
    miniFile file = new miniFile();
    @Override
    public void add(String s) {
        file.setName(s);
        list.add(file);
        System.out.println("Opened a file");

    }

    @Override
    public void clear() {
        list.clear();
        System.out.println("Cleared");
    }
}
