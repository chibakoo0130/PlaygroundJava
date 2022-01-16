package datetime_operation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class Datetime {

    public static class DateAndTimeのテスト {

        @Test
        public void _2020年1月1日の日付を生成する() {
            LocalDate date = LocalDate.of(2020, 1, 1);
            assertThat(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(date), is("2020/01/01"));
        }

        @Test
        public void _10時20分30秒400の時刻を生成する() {
            LocalTime time = LocalTime.of(10, 20, 30);
            assertThat(DateTimeFormatter.ofPattern("HH時mm分ss秒").format(time), is("10時20分30秒"));
        }

        @Test
        public void _2021年1月16日22時13分10秒の日時を生成する() {
            LocalDateTime datetime = LocalDateTime.of(2021, 1, 16, 22, 13, 10);
            assertThat(DateTimeFormatter.ofPattern("yyyy年MM月dd日HH時mm分ss秒").format(datetime), is("2021年01月16日22時13分10秒"));
        }
    }
}
