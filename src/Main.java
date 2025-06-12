import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File musicFile = new File("src/video/Submerged.wav");
        System.out.println("Absolute path: " + musicFile.getAbsolutePath());
        System.out.println("File exists: " + musicFile.exists());
        MusicPlayer.playSound(musicFile);
        Frame.createFrame();
    }
}
  