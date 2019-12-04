package Sound;


import javax.sound.sampled.*;



import java.applet.Applet;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.*;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.rmi.server.ExportException;
import java.util.ResourceBundle;

public class SoundEffect implements Sound{


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






// effet sonore qui s'execute 1 fois

    static void PlaySound1time(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }






// boucle infini d'un son
        static void PlayMusicboucle(File musicLocation){
    try {
        File musicPath = new File(String.valueOf(musicLocation));

        if(musicPath.exists()){
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            while (true){
                clip.loop(1);
            }
        }
    }catch (Exception e) {
        e.printStackTrace();
    }
}






// test de la boucle avec un bouton qui permet de stopper la music
    static void PlayMusicLoop(File musicLocation){
        try {
            File musicPath = new File(String.valueOf(musicLocation));
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop((Clip.LOOP_CONTINUOUSLY));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }






   /* static void PlaySound2(){
        Application.launch();
        String bip = "Game Files/Sounds/SFX/pacman_beginning.wav";
        Media Sound2 = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(Sound2);
        mediaPlayer.play();
    }*/
   //Un listenner sur javaFx




    // TEST 1 2 3 4 5
    public static void main(String[] args) throws InterruptedException {

        //PlaySound2();

        //PlayMusicLoop(Clap);
        //PlayMusicboucle(Clap);
        //PlaySound1time(Clap3);
        //PlayMusicLoop(Clap9);



    }




}
