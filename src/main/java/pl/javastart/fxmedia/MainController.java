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
        Media media = new Media("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_1280_10MG.mp4");
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        mediaView.setMediaPlayer(player);
        pausePlayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               if  (player.getStatus() == MediaPlayer.Status.READY ||player.getStatus()==MediaPlayer.Status.PAUSED)
                   player.play();
               else player.pause();
            }
        });
        player.setOnError(() -> System.out.println("Error: " + player.getError()));
        System.out.println(media.getDuration());
    }
}