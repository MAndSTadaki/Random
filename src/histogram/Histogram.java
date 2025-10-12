package histogram;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * ヒストグラム
 */
public class Histogram {

    private final double lowerBound;//範囲の下限
    private final double upperBound;//範囲の上限
    private final double binWidth;//bin の幅
    private final int hist[];//ヒストグラム
    private int count = 0;

    /**
     * コンストラクタ：binの数を指定
     *
     * @param lowerBound 下限
     * @param upperBound 上限
     * @param numBin binの数
     */
    public Histogram(double lowerBound, double upperBound, int numBin) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        binWidth = (upperBound - lowerBound) / numBin;
        hist = new int[numBin];
    }

    /**
     * コンストラクタ：binの幅を指定
     *
     * @param lowerBound 下限
     * @param upperBound 上限
     * @param binWidth binの幅
     */
    public Histogram(double lowerBound, double upperBound, double binWidth) {
        this.lowerBound = lowerBound;
        this.binWidth = binWidth;
        int numBin = (int) ((upperBound - lowerBound) / binWidth);
        if (lowerBound + numBin * binWidth < upperBound) { numBin++;}
        this.upperBound = lowerBound + numBin * binWidth;
        hist = new int[numBin];
    }

    /**
     * 値を一つ登録する
     *
     * @param x
     * @return
     */
    public boolean put(double x) {
        count++;
        if (x < lowerBound || x >= upperBound) { return false;}
        //xが入るべきbinの番号を調べる
        int binIndex = (int) ((x - lowerBound) / binWidth);
        hist[binIndex]++;//bin のカウントを一つ増やす
        return true;
    }

    public double getLowerBound() { return lowerBound; }
    public double getUpperBound() { return upperBound;}
    public int[] getHist() { return hist;}

    /**
     * 結果をリストとして取得する: 値は確率になるように規格化する
     *
     * @return
     */
    public List<Point2D.Double> calculateFrequency() {
        List<Point2D.Double> pList = new ArrayList<>();
        for (int i = 0; i < hist.length; i++) {
            double x = lowerBound + i * binWidth + binWidth / 2.;//binの中央値
            double y = (double) hist[i] / count / binWidth;//binに入る割合
            pList.add(new Point2D.Double(x, y));
        }
        return pList;
    }

    /**
     * pListが規格化されていることを確かめる
     *
     * @param pList
     * @return
     */
    public double checkNormalization(List<Point2D.Double> pList) {
        double frequency = 0.;
        for (Point2D.Double p : pList) { frequency += p.y * binWidth;}
        return frequency;
    }
}
