package randomNumberExamples;

import java.io.IOException;
import java.util.function.Function;
import randomNumbers.Tester;
import randomNumbers.Transform;

/**
 *
 * @author tadaki
 */
public class Cauchy {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        double min = -100.;//下限
        double max = 100.;//上限
        int numBin = 1000;//binの数
        int numSamples = 1000000;//乱数の総数
        // p(x) = 1/(pi(1+x~2))
        Function<Double, Double> invProDist
                = (x) -> Math.tan(Math.PI * (x - .5));

        //変換法による乱数生成のインスタンス
        Transform transform = new Transform(invProDist, 48L);
        String filename = Cauchy.class.getSimpleName() + ".txt";
        Tester tester = new Tester(transform);
        tester.generateHistgram(min, max, numBin, numSamples, filename);
    }

}
