package mediaplayer.adapter;

import java.util.ArrayList;
import java.util.List;

public class addMP4 implements MP4{
    List<fileFormat> MP4formats = new ArrayList<>();
    fileFormat mp4 = new fileFormat();
    @Override
    public void add(String filename) {
        mp4.setFormat(filename);
        MP4formats.add(mp4);
        for (fileFormat f : MP4formats) {
            System.out.println(f.getFormat());
        }

    }
}
