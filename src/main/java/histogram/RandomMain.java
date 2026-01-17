package histogram;

import randomNumbers.AbstractRandom;
import java.awt.geom.Point2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import randomNumberExamples.Uniform;

public class RandomMain {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int num = 1000000;//サンプル数
        int m = 100;//binの数
        AbstractRandom random = new Uniform(0, 1, 48L);
        Histogram histogram = new Histogram(0, 1, m);
        for (int t = 0; t < num; t++) {
            histogram.put(random.getNext());
        }
        String filename = RandomMain.class.getSimpleName() + ".txt";
        try ( PrintStream out = new PrintStream(new FileOutputStream(filename))) {
            for (Point2D.Double p : histogram.calculateFrequency()) {
                out.println(p.x + " " + p.y);
            }
        }
    }

}
