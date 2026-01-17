package randomNumbers;

import java.util.Random;

/**
 *
 * @author tadaki
 */
abstract public class AbstractRandom {

    protected final Random random;

    public AbstractRandom(Random random) {
        this.random = random;
    }
    
    /**
     * seedを指定してRandomを初期化
     *
     * @param seed
     */
    public AbstractRandom(long seed) {
        this(new Random());
        if (seed > 0) {
            random.setSeed(seed);
        }
    }

    abstract public double getNext();

}
