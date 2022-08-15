package randomNumbers;

import java.io.IOException;
import java.util.Random;
import java.util.function.Function;

/**
 * 棄却法による乱数生成
 */
public class Rejection extends AbstractRandom {

    private final Function<Double, Double> probDensity;//確率密度関数
    private final double min;//乱数生成の下限
    private final double max;//乱数生成の上限
    private final double maxOfFunction;//確率密度関数の最大値

    /**
     * コンストラクタ
     *
     * @param probDensity 確率密度関数
     * @param min 乱数生成の下限
     * @param max 乱数生成の上限
     * @param maxOfFunction 確率密度関数の最大値
     * @param seed
     */
    public Rejection(Function<Double, Double> probDensity,
            double min, double max, double maxOfFunction, long seed) {
        this(probDensity, min, max, maxOfFunction, new Random(seed));
    }

    public Rejection(Function<Double, Double> probDensity,
            double min, double max, double maxOfFunction, Random random) {
        super(random);
        this.probDensity = probDensity;
        this.min = min;
        this.max = max;
        this.maxOfFunction = maxOfFunction;
    }

    /**
     * 乱数を一つ生成
     *
     * @return 生成された乱数
     */
    @Override
    public double getNext() {
        boolean done = false;//乱数が生成されるとtrueとなる
        double nextRandom = 0.;
        while (!done) { //二つの乱数
            double x = random.nextDouble();
            double y = random.nextDouble();
            nextRandom = (max - min) * x + min;
            done = (y < probDensity.apply(nextRandom) / maxOfFunction);
        }
        return nextRandom;
    }

}
