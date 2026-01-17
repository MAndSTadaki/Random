package randomNumberExamples;

import histogram.Histogram;
import java.awt.geom.Point2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 *
 * @author tadaki
 */
public class Poisson {

    private final double lambda;

    public Poisson(double lambda) {
        this.lambda = lambda;
    }

    public int getNext() {
        double x = 1.;
        int count = 0;
        while (x > Math.exp(-lambda)) {
            count++;
            x *= (1. - Math.random());
        }
        return count - 1;
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        double lambda = 1.;
        int numSamples = 1000000;
        double min = 0.;
        double max = 10.;
        int numBin = 100;
        Histogram histogram = new Histogram(min, max, numBin);
        Poisson poisson = new Poisson(lambda);
        for (int i = 0; i < numSamples; i++) {
            int x = poisson.getNext();
            histogram.put((double) x);
        }
        //ヒストグラムを出力
        List<Point2D.Double> plist = histogram.calculateFrequency();
        String filename = Poisson.class.getSimpleName() + ".txt";
        try (PrintStream out = new PrintStream(new FileOutputStream(filename))) {
            for (Point2D.Double p : plist) {
                out.println(p.x + " " + p.y);
            }
        }
    }

}
