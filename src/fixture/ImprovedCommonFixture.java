package fixture;

/**
 * 継承によりパラメータの持たせ方を拡張した<br>
 * 共通のフィクスチャークラス。
 *
 * @author chibakotaro
 * @since 2022/02/06
 *
 * @param <P> テスト対象メソッドの引数
 * @param <R> テスト対象メソッドの返り値
 */
public class ImprovedCommonFixture<P, R> {

    P param1;
    R retVal;

    public ImprovedCommonFixture(P param1, R retVal) {
        this.param1 = param1;
        this.retVal = retVal;
    }

    /**
     * 引数を2つ持つメソッドで用いるフィクスチャークラス。
     *
     * @author chibakotaro
     * @since 2022/02/06
     *
     * @see {@link ImprovedCommonFixture}
     */
    public static class Param2Fixture<P, R> extends ImprovedCommonFixture<P, R> {

        P p2;

        public Param2Fixture(P param1, P param2, R retVal) {
            super(param1, retVal);
            this.p2 = param2;
        }
    }
}
