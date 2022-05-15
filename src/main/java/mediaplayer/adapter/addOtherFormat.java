package mediaplayer.adapter;

import java.util.ArrayList;
import java.util.List;

public class addOtherFormat implements OtherFormat{
    List<fileFormat> otherFormats = new ArrayList<>();
    fileFormat other = new fileFormat();
    @Override
    public void add(String filename) {
        other.setFormat(filename);
        otherFormats.add(other);
        System.out.println("Opened a "+filename+" file");
    }
}
