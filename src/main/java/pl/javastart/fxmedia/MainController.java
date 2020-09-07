package pl.javastart.fxmedia;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MainController {
    @FXML
    private Button pausePlayButton;
    @FXML
    private MediaView mediaView;

    public void initialize() {
        Media media = new Media("https://sample-videos.com/video123/mp4/240/big_buck_bunny_240p_1mb.mp4");
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        mediaView.setMediaPlayer(player);
        pausePlayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               if  (player.getStatus()==MediaPlayer.Status.PAUSED)
                   player.play();
               else player.pause();
            }
        });
        player.setOnError(() -> System.out.println("Error: " + player.getError()));
        System.out.println(media.getDuration());
    }
}