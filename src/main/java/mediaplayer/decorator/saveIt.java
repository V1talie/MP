package mediaplayer.decorator;

import java.util.ArrayList;
import java.util.List;

public class saveIt extends HistoryDecorator{
    List<miniFile> list = new ArrayList<>();
    miniFile miniFile = new miniFile();

    public saveIt(History h){
        super(h);

    }

    public void saveFile(String name){
     miniFile.setName(name);
     list.add(miniFile);
     for(miniFile m:list){
         System.out.println(m.getName());
     }
    }

    @Override
    public void add(String s) {
        super.add(s);
        saveFile(s);
        System.out.println("saved");

    }
}
