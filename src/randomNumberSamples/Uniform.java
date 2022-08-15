package randomNumberSamples;

import java.io.IOException;
import java.util.Random;
import randomNumbers.Tester;
import randomNumbers.Transform;

/**
 *
 * @author tadaki
 */
public class Uniform extends Transform{

    public Uniform(double min,double max, long seed) {
        super(x->(max-min)*x+min, seed);
    }

    public Uniform(double min,double max,Random random) {
        super(x->(max-min)*x+min, random);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        double min = 0.;//下限
        double max = 1.;//上限
        int numBin = 100;//binの数
        int numSamples = 100000;//乱数の総数
        Uniform transform = new Uniform(min,max, 48L);
        Tester tester = new Tester(transform);
        tester.generateHistgram(min, max, numBin, numSamples, "uniform.txt");
    }
    
}
