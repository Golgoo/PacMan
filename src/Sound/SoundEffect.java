package Sound;


import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;

public class SoundEffect implements  Sound {


    public static File Clap = new File("pacman_beginning.wav");
    public static File Clap2 = new File("pacman_chomp.wav");
    public static File Clap3 = new File("pacman_death.wav");
    public static File Clap4 = new File("pacman_eatfruit.wav");
    public static File Clap5 = new File("pacman_eatghost.wav");
    public static File Clap6 = new File("pacman_extrapac.wav");
    public static File Clap7 = new File("pacman_intermission.wav");
    public static File Clap8 = new File("credit.wav");
    public static File Clap9 = new File("siren_1.wav");
    public static File Clap10 = new File("siren_2.wav");
    public static File Clap11 = new File("siren_3.wav");
    public static File Clap12 = new File("siren_4.wav");
    public static File Clap13 = new File("siren_5.wav");
    public static File Clap14 = new File("retreating.wav");
    public static File Clap15 = new File("power_pellet.wav");
    public static File Clap16 = new File("munch_1.wav");
    public static File Clap17 = new File("munch_2.wav");
    public static File Clap18 = new File("game_start.wav");
    public static File Clap19 = new File("extend.wav");
    public static File Clap20 = new File("eat_ghost.wav");
    public static File Clap21 = new File("eat_fruit.wav");
    public static File Clap22 = new File("death_1.wav");
    public static File Clap23 = new File("death_2.wav");
    public static File Clap24 = new File("power_pellet.wav");




    private AudioClip clip;
    public void play() {


        clip.play();
    }

    @Override
    public void loop() {
        clip.loop();

    }


    @Override
    public void stop() {

        clip.stop();
    }



    static void PlaySound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();

            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

   /* static void PlaySound2(){
        Application.launch();
        String bip = "pacman_beginning.wav";
        Media Sound2 = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(Sound2);
        mediaPlayer.play();
    }*/
   //Un listenner sur javaFx




    // TEST 1 2 3 4 5
    public static void main(String[] args) {


        //PlaySound2();
        PlaySound(Clap);



    }
}
