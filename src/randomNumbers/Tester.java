package randomNumbers;

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
public class Tester {

    private final AbstractRandom random;

    public Tester(AbstractRandom random) {
        this.random = random;
    }

    /**
     * 乱数を生成し、ヒストグラムを出力する
     *
     * @param min ヒストグラムの下限
     * @param max ヒストグラムの上限
     * @param numBin ヒストグラムのビン数
     * @param numSamples 乱数の生成数
     * @param filename ヒストグラムの出力先
     * @throws IOException
     */
    public void generateHistgram(double min, double max, int numBin,
            int numSamples, String filename)
            throws IOException {
        //乱数生成
        Histogram histogram = new Histogram(min, max, numBin);
        for (int i = 0; i < numSamples; i++) {
            double x = random.getNext();
            histogram.put(x);
        }
        //ヒストグラムを出力
        List<Point2D.Double> plist = histogram.calculateFrequency();
        try ( PrintStream out = new PrintStream(new FileOutputStream(filename))) {
            for (Point2D.Double p : plist) {
                out.println(p.x + " " + p.y);
            }
        }
    }
}
