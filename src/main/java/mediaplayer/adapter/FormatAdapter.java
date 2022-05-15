package mediaplayer.adapter;


import java.util.ArrayList;
import java.util.List;

public class FormatAdapter implements MP4{
   // List<fileFormat> anyFormat = new ArrayList<>();
   // fileFormat format = new fileFormat();
    private final OtherFormat otherFormat;
    public FormatAdapter(OtherFormat otherFormat){
        this.otherFormat = otherFormat;
    }
    @Override
    public void add(String filename) {
        otherFormat.add(filename);
       // format.setFormat(filename);
       // anyFormat.add(format);
    }
}
