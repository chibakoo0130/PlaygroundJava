package fixture;

public class MethodSample {

    private static int BASE_NUM = 1;

     /**
     * 引数が基準値より大きければtrue、小さければfalseを返す。
     *
     * @param target 比較したい数値
     * @return true/false
     */
    public static boolean isGreaterThan(int target) {
       return target > BASE_NUM ? true : false;
    }

    /**
     * targetがbaseより大きければtrue、小さければfalseを返す。
     *
     * @param base 基準にしたい数値
     * @param target 基準と比較したい数値
     * @return true/false
     */
    public static boolean compare(int base, int target) {
        return target > base ? true : false;
    }
}
