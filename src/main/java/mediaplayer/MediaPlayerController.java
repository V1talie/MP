package mediaplayer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import mediaplayer.Memento.Memento;
import mediaplayer.Memento.StateChange;
import mediaplayer.Observer.*;
import mediaplayer.adapter.FormatAdapter;
import mediaplayer.adapter.MP4;
import mediaplayer.adapter.addOtherFormat;
import mediaplayer.builder.Actions;
import mediaplayer.decorator.HistoryDecorator;
import mediaplayer.decorator.addSingle;
import mediaplayer.decorator.saveIt;


public class MediaPlayerController implements Initializable {

List<Actions> actiuni = new ArrayList<>();
    private String path;
    private MediaPlayer mediaPlayer;
    List<Memento> savedStates = new ArrayList<Memento>();
    StateChange stateChange = new StateChange();
    Duration time;
    Observer user = new User();
    Observer user2 = new User();
    ButtonObserved playButton = new ButtonObserved();
    ButtonObserved pauseButton = new ButtonObserved();
    ButtonObserved stopButton = new ButtonObserved();


    @FXML
    private MediaView mediaView;

    @FXML
    private Button openFile;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider progressBar;

    @FXML
    private Label label;

    @FXML
    private StackPane pane;

    @FXML
    private void OpenFileMethod(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        path = file.toURI().toString();


        if(path != null){
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

            String extens = getExtension.getFileExtension(file.getName());
            MP4 mp4 = new FormatAdapter(new addOtherFormat());
            mp4.add(extens);

            DoubleProperty widthProp = mediaView.fitWidthProperty();
            DoubleProperty heightProp = mediaView.fitHeightProperty();

            widthProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            heightProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            volumeSlider.setValue(mediaPlayer.getVolume()*100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeSlider.getValue()/100);
                }
            });

            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<javafx.util.Duration>() {
                                                              @Override
                                                              public void changed(ObservableValue<? extends javafx.util.Duration> observable, javafx.util.Duration oldValue, javafx.util.Duration newValue) {
                                                                  progressBar.setValue(newValue.toSeconds());
                                                              }
                                                          }
            );

            progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });

            progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });

            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    javafx.util.Duration total = media.getDuration();
                    progressBar.setMax(total.toSeconds());
                }
            });
            HistoryDecorator history = new saveIt(new addSingle()); // decorator

            history.add(file.getName());
            addObservers(user);
            mediaPlayer.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void pauseVideo(ActionEvent event){
        pauseButton.addEvent("pause");
        mediaPlayer.pause();
    }
    public void saveMem(ActionEvent event){//Memento
        time = mediaPlayer.getCurrentTime(); //get current time
        stateChange.set(time);
        savedStates.add(stateChange.save());
    }
    public void loadMem(ActionEvent event){//Memento
        mediaPlayer.seek(stateChange.restore(savedStates.get(savedStates.size()-1)));

    }

    public void stopVideo(ActionEvent event){
        stopButton.addEvent("stop");
        mediaPlayer.stop();
    }

    public void playVideo(ActionEvent event){
        Actions play = new Actions.Builder() //builder
                .setName("Play")
                .setType("Click Button")
                .setDescription("Starts the video").build();
        actiuni.add(play);
        /*for (   Actions actiune : actiuni) {
            System.out.println(actiune.getName());
            System.out.println(actiune.getDescription());
            System.out.println(actiune.getType());
        }*/
        playButton.addEvent("play");
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }

    public void skip5(ActionEvent event){
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    public void furtherSpeedUpVideo(ActionEvent event){
        mediaPlayer.setRate(2);
    }

    public void back5(ActionEvent event){
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    public void furtherSlowDownVideo(ActionEvent event){
        mediaPlayer.setRate(0.5);

    }
    public void addObservers(Observer user){
        playButton.addObserver(user);
        pauseButton.addObserver(user);
        stopButton.addObserver(user);
    }

}