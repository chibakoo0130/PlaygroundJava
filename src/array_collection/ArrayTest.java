package array_collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import base.Student;

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

    public static class copyofのテスト {

        private int[] array = { 1, 2, 3, 4, 5 };

        @Test
        public void 旧型のSystem_arraycopy() {
            int[] copied = new int[array.length + 2];
            System.arraycopy(array, 0, copied, 0, array.length);
            assertThat(copied.length, is(7));
            assertThat(copied, is(new int[] { 1, 2, 3, 4, 5, 0, 0 }));
        }

        @Test
        public void Arrays_copyofする() {
            int[] copied = Arrays.copyOf(array, array.length + 3);
            assertThat(copied, is(new int[] { 1, 2, 3, 4, 5, 0, 0, 0 }));
        }
    }

    public static class sortのテスト {

        private final Student[] students = {
                new Student("John", 54),
                new Student("Kenny", 81),
                new Student("Mary", 32)
        };

        @Test
        public void プリミティブ型クラスをsortする() {
            int[] intArray = { 23, 1, 14, 5, 100 };
            Arrays.sort(intArray);
            assertThat(intArray, is(new int[] { 1, 5, 14, 23, 100 }));
        }

        @Test
        public void 降順でsortする1() {
            // 並び順を指定するため、sort(T[], Comparator)を使う。
            // T[]のため、ラッパークラスを使う。
            Integer[] integerArray = { 12, 3, 7, 91, 84 };
            Comparator<Integer> c = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            };
            Arrays.sort(integerArray, c);
            assertThat(integerArray, is(new Integer[] { 91, 84, 12, 7, 3  }));
        }

        @Test
        public void 参照型クラスをsortする() {

            Comparator<Student> c = new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return Integer.compare(o1.getScore(), o2.getScore());
                }
            };

            Arrays.sort(students, c);
            assertThat(students[0].getName(), is("Mary"));
            assertThat(students[1].getName(), is("John"));
            assertThat(students[2].getName(), is("Kenny"));
        }

        @Test(expected = ClassCastException.class)
        public void Comaratorを実装せずClassCastException() {
            Arrays.sort(students);
        }
    }

    public static class binarySearchのテスト {

        private final int[] array = { 1, 2, 3, 3, 7, 11, 17, 25, 31, 32 };

        @Test
        public void 検索対象がある場合は検索対象のインデックスが返される() {
            // 配列がソートされていない場合は不定の値が返されるので、使用には事前にソートが必要
            assertThat(Arrays.binarySearch(array, 7), is(4));
        }

        @Test
        public void 検索対象がない場合はある想定でインデックスが返される() {
            // 検索対象が入ると想定されるインデックスの負数-1のインデックス
            assertThat(Arrays.binarySearch(array, 8), is(-6));
        }
    }

}
