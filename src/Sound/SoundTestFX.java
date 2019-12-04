package Sound;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class SoundTestFX extends Application {

    public static File Clap = new File("Game Files/Sounds/SFX/pacman_beginning.wav");
    public static File Clap2 = new File("Game Files/Sounds/SFX/pacman_chomp.wav");
    public static File Clap3 = new File("Game Files/Sounds/SFX/pacman_death.wav");
    public static File Clap4 = new File("Game Files/Sounds/SFX/pacman_eatfruit.wav");
    public static File Clap5 = new File("Game Files/Sounds/SFX/pacman_eatghost.wav");
    public static File Clap6 = new File("Game Files/Sounds/SFX/pacman_extrapac.wav");
    public static File Clap7 = new File("Game Files/Sounds/SFX/pacman_intermission.wav");
    public static File Clap8 = new File("Game Files/Sounds/SFX/credit.wav");
    public static File Clap9 = new File("Game Files/Sounds/SFX/siren_1.wav");
    public static File Clap10 = new File("Game Files/Sounds/SFX/siren_2.wav");
    public static File Clap11 = new File("Game Files/Sounds/SFX/siren_3.wav");
    public static File Clap12 = new File("Game Files/Sounds/SFX/siren_4.wav");
    public static File Clap13 = new File("Game Files/Sounds/SFX/siren_5.wav");
    public static File Clap14 = new File("Game Files/Sounds/SFX/retreating.wav");
    public static File Clap15 = new File("Game Files/Sounds/SFX/power_pellet.wav");
    public static File Clap16 = new File("Game Files/Sounds/SFX/munch_1.wav");
    public static File Clap17 = new File("Game Files/Sounds/SFX/munch_2.wav");
    public static File Clap18 = new File("Game Files/Sounds/SFX/game_start.wav");
    public static File Clap19 = new File("Game Files/Sounds/SFX/extend.wav");
    public static File Clap20 = new File("Game Files/Sounds/SFX/eat_ghost.wav");
    public static File Clap21 = new File("Game Files/Sounds/SFX/eat_fruit.wav");
    public static File Clap22 = new File("Game Files/Sounds/SFX/death_1.wav");
    public static File Clap23 = new File("Game Files/Sounds/SFX/death_2.wav");
    public static File Clap24 = new File("Game Files/Sounds/SFX/power_pellet.wav");

    String musicFile = "Game Files/Sounds/SFX/pacman_beginning.wav";
    Media m = new Media((new File(musicFile).toURI().toString()));
    MediaPlayer player  = new MediaPlayer(m);


  /*     private void playSound(String s) {
        URL path;
        AudioClip ac;
        switch (s) {
            case "Left":
            case "Right":
                path = getClass().getResource("Game Files/Sounds/SFX/pacman_intermission.wav");
                ac = new AudioClip(path.toString());
                ac.play();
                break;
            default:
        }
    }*/



    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        player.setVolume(0.3);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.play();


    }
}


