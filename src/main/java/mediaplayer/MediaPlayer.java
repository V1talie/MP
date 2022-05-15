
package mediaplayer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mediaplayer.Observer.ButtonObserved;
import mediaplayer.Observer.Observer;
import mediaplayer.Observer.User;

import java.util.Objects;

public class MediaPlayer extends Application {

/*    public enum EnumSingleton {

        INSTANCE("Initial class info");

        private String info;

        EnumSingleton(String info) {
            this.info = info;
        }

        public EnumSingleton getInstance() {
            return INSTANCE;
        }

        // getters and setters
        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

    }*/
        private static MediaPlayer instance;

        public static synchronized MediaPlayer getInstance() {
            if (instance == null) {
                instance = new MediaPlayer();
            }
            return instance;
        }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MediaPlayer.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("Media Player");
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
/*        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() ==2){
                    stage.setFullScreen(true);
                }
            }
        });*/



        stage.setScene(scene);
        stage.setWidth(809);
        stage.setHeight(571);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        getInstance();
        launch(args);

    }

}