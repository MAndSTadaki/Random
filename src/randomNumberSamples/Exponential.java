package randomNumberSamples;

import randomNumbers.Transform;
import java.io.IOException;
import java.util.function.Function;
import randomNumbers.Tester;

/**
 * 変換法による乱数生成
 */
public class Exponential {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        double min = 0.;//下限
        double max = 1.;//上限
        int numBin = 100;//binの数
        int numSamples = 100000;//乱数の総数
        //指数分布に対応した分布関数の逆関数を定義
        // A * exp (-x)
        double A = Math.E / (Math.E - 1);
        Function<Double, Double> invProDist = (x) -> {
            return -Math.log(1 - x / A);
        };
        //変換法による乱数生成のインスタンス
        Transform transform = new Transform(invProDist, 48L);
        Tester tester = new Tester(transform);
        tester.generateHistgram(min, max, numBin, numSamples, "exp.txt");
    }

}
