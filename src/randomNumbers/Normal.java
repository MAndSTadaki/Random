package randomNumbers;

import java.io.IOException;
import java.util.Random;
import java.util.function.Function;

/**
 *
 * @author tadaki
 */
public class Normal extends AbstractRandom {

    private final Function<Double, Double> invProDist;
    private final Transform transform;

    public Normal(double myu, double sigma, long seed) {
        this(myu, sigma, new Random(seed));
    }

    public Normal(double myu, double sigma, Random random) {
        super(random);
        invProDist = (x) -> sigma * Math.sqrt(-2. * Math.log(1. - x));
        transform = new Transform(invProDist, random);
    }

    @Override
    public double getNext() {
        double theta = 2 * Math.PI * Math.random();
        double r = transform.getNext();
        return r * Math.cos(theta);
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        double min = -10;
        double max = 10.;
        int numBin = 100;
        int numSamples = 100000;
        double myu = 0.;
        double sigma = 1.;
        Normal normal = new Normal(myu, sigma, 48L);
        String filename = Normal.class.getSimpleName() + ".txt";
        Tester tester = new Tester(normal);
        tester.generateHistgram(min, max, numBin, numSamples, filename);
    }

}
