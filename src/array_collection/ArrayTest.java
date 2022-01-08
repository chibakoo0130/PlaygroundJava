package array_collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ArrayTest {

    public static class 初期化テスト {

        @Test
        public void 配列の初期化1() {
            int[] array1 = new int[5];
            assertThat(array1.length, is(5));
            assertThat(array1[0], is(0));
        }

        @Test
        public void 配列の初期化2() {
            int[] array2 = { 1, 2, 3, 4, 5 };
            assertThat(array2, is(new int[] { 1 , 2, 3, 4, 5 }));
        }

        @Test
        public void 配列の初期化3() {
            int[] array3 = new int[] { 1, 2, 3, 4, 5 };
            assertThat(array3, is(new int[] { 1, 2, 3, 4, 5 }));
        }

        @Test
        public void 配列の初期化4() {
            int[] array4;
            // array4 = { 1, 2, 3, 4, 5 }; これはコンパイルエラー
            array4 = new int[] { 1, 2, 3, 4, 5 };
            assertThat(array4, is(new int[] { 1, 2, 3, 4, 5 }));
        }

        @Test
        public void 配列の初期化_メソッド引数() {
            getArrayBundleStr(new String[] { "a", "b", "c" });
            // getArrayBundleStr({ "a", "b", "c" }); コンパイルエラー
        }

        private static String getArrayBundleStr(String[] array ) {
            StringBuilder temp = new StringBuilder();
            for (String str : array) {
                temp.append(str);
            }
            return temp.toString();
        }
    }

    public static class ArrayIndexOutOfBoundsException発生のテスト {

        @Test(expected = ArrayIndexOutOfBoundsException.class)
        public void 配列の長さを超えたインデックス指定での発生() {
            int[] array = new int[2];
            int value = array[2];
         }

       @Test(expected = ArrayIndexOutOfBoundsException.class)
       public void 配列のインデックスにマイナスの値指定での発生1() {
           int[] array = { 1, 2, 3 };
           int value = array[-1];
       }

       @Test(expected = ArrayIndexOutOfBoundsException.class)
       public void 配列のインデックスにマイナスの値指定での発生2() {
           int[] array = { 1, 2, 3 };
           int value = array[-100];
       }
    }
}
