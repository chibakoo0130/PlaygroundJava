package fixture;

/**
 * ジェネリクスを用いて様々なクラスを利用できるフィクスチャークラス。
 *
 * @author chibakotaro
 * @since 2022/02/05
 *
 * @param <P> テスト対象メソッドの引数
 * @param <R> テスト対象メソッドの返り値
 */
public class CommonFixture<P, R> {

    P input;
    R result;

    public CommonFixture(P input, R result) {
        this.input = input;
        this.result = result;
    }
}
