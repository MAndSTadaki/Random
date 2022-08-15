package randomNumbers;

import java.io.IOException;
import java.util.Random;
import java.util.function.Function;

/**
 * 変換法による乱数生成
 */
public class Transform extends AbstractRandom {

    private final Function<Double, Double> invProDist;//確率分布の逆関数

    /**
     * コンストラクタ
     *
     * @param invProDist 確率分布の逆関数
     * @param seed
     */
    public Transform(Function<Double, Double> invProDist, long seed) {
        this(invProDist, new Random(seed));
    }

    public Transform(Function<Double, Double> invProDist, Random random) {
        super(random);
        this.invProDist = invProDist;
    }

    /**
     * 乱数を一つ生成
     *
     * @return 生成された乱数
     */
    @Override
    public double getNext() {
        double x = random.nextDouble();
        return invProDist.apply(x);
    }

}
