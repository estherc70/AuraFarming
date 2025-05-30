import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Sponsors {
    private ArrayList<BufferedImage> sponsors;
    private ArrayList<BufferedImage> currentSponsors;
    private ArrayList<Integer> usedSponsors;

    public Sponsors() throws IOException {
        sponsors = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            try {
                String name = "src/MailImages/sponsors/" + i + ".png";
                BufferedImage image = ImageIO.read(new File(name));
                assert false;
                sponsors.add(image);
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }




    public ArrayList<BufferedImage> getSponsors() {
        return sponsors;
    }
}
