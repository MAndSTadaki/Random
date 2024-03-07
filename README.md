# 乱数とその性質

## packages
- `randomNumbers`: 変換法、棄却法
    - `AbstractRandom.java`: 乱数う生成の抽象クラス
    - `Transform.java`: 変換法
    - `Rejection.java`: 棄却法
    - `Tester.java`: 乱数を生成してヒストグラムを生成する
    - `Normal.java`: 正規分布
- `randomNumberExamples`: 乱数の例
    - `Cauchy.java`: Cauchy分布
    - `Exponential.java`: 指数分布
    - `Pi.java`: $\pi$を求める
    - `Poisson.java`: Poisson分布
    - `SinSquare.java`: $p(x)=2\sin^2 x/\pi$
    - `Uniform.java`: 一様分布
- `histogram`: ヒストグラム
    - `Histogram.java`: ヒストグラム
    - `RandomMain.java`: ヒストグラム生成のメインクラス
