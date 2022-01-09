package array_collection;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ListTest {

    public static class iteratorのテスト {

        @Test
        public void iteratorで繰り返し処理中に要素をremoveする() {
            List<String> fruits = new ArrayList<String>();
            fruits.add("apple");
            fruits.add("orange");
            fruits.add("banana");

            for(Iterator<String> it = fruits.iterator(); it.hasNext(); ) {
                if (it.next().equals("orange")) {
                    it.remove();
                }
            }
            assertThat(fruits, hasItems("apple", "banana"));
            assertThat(fruits, not(hasItem("orange")));
        }

        @Test(expected =  ConcurrentModificationException.class)
        public void 拡張for文中にiteratorなしでremoveするとConcurrentModificationException() {
            // 例外が発生しなくてもremoveすることで、要素のインデックスがずれ、
            // 正常に操作されないことがある。
            // 要素に対して削除などインデックスが動く操作をする場合は
           // iteratorを利用するとよい。
            List<String> fruits = new ArrayList<>();
            fruits.add("apple");
            fruits.add("orange");
            fruits.add("banana");

            for (String fruit : fruits) {
                if (fruit.equals("banana")) {
                    fruits.remove("banana");
                }
            }
        }
    }
}
