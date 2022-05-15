package mediaplayer.Observer;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;

import java.util.List;

public class User implements Observer{
    @FXML
    private Slider volumeSlider;
    @Override
    public void handleEvent(List<String> event) {
        switch(event.get(event.size() - 1)){
            case "play":
                System.out.println("User: click play");
                break;
            case "pause":
                System.out.println("User: click pause");
                break;
            case "stop":
                System.out.println("User: click stop");
                break;
        }
        //System.out.println("Video has changed state: "+event+"\n");
    }
}
