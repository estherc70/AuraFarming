import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlayer {

    private static Clip clip;
    public static void playSound(File soundFile) {
        try {
            clip = AudioSystem.getClip();
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundFile);
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println("Could not play audio file: " + soundFile.getAbsolutePath());
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        // Assuming "your_music.wav" is in the same directory as your class file
//        File musicFile = new File("src/video/music.wav");
//        playSound(musicFile);
//    }

}
