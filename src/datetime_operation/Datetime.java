package datetime_operation;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class Datetime {

    public static class ofのテスト {

        @Test
        public void _2020年1月1日の日付を生成する() {
            LocalDate date = LocalDate.of(2020, 1, 1);
            TemporalAccessor parsed = DateTimeFormatter
                    .ofPattern("yyyy/MM/dd")
                    .parse("2020/01/01");
            assertThat(date, is(LocalDate.from(parsed)));
        }

        @Test
        public void _10時20分30秒400の時刻を生成する() {
            LocalTime time = LocalTime.of(10, 20, 30, 400_000_000);
            TemporalAccessor parsed = DateTimeFormatter
                    .ofPattern("HH時mm分ss秒SSS")
                    .parse("10時20分30秒400");
            assertThat(time, is(LocalTime.from(parsed)));
        }

        @Test
        public void _2021年1月16日22時13分10秒の日時を生成する() {
            LocalDateTime datetime = LocalDateTime.of(2021, 1, 16, 22, 13, 10);
            TemporalAccessor parsed = DateTimeFormatter
                    .ofPattern("yyyy年MM月dd日HH時mm分ss秒")
                    .parse("2021年01月16日22時13分10秒");
            assertThat(datetime, is(LocalDateTime.from(parsed)));
        }
    }

    public static class parseのテスト {

        @Test
        public void _2020年1月1日の日付を生成する() {
            LocalDate date = LocalDate.parse("2020-01-01");
            assertThat(date, is(LocalDate.of(2020, 1, 1)));
        }

        @Test(expected = DateTimeParseException.class)
        public void スラッシュ区切りの日付でparseする() {
            LocalDate.parse("2020/01/01");
        }

        @Test(expected = DateTimeParseException.class)
        public void 区切りなしの日付でparseする() {
            LocalDate.parse("20200101");
        }

        @Test(expected = DateTimeParseException.class)
        public void 日が欠けた日付でparseする() {
            LocalDate.parse("2020-01");
        }

        @Test
        public void _10時20分30秒400の時刻を生成する() {
            LocalTime time = LocalTime.parse("10:20:30.400");
            assertThat(time, is(LocalTime.of(10, 20, 30, 400_000_000)));
        }

        @Test(expected = DateTimeParseException.class)
        public void コンマ区切りの時刻でparseする() {
            LocalTime.parse("10.20.30.400");
        }

        @Test
        public void _2021年1月16日22時13分10秒456の日時を生成する() {
            LocalDateTime dateTime = LocalDateTime.parse("2021-01-16T22:13:10.456");
            assertThat(dateTime, is(LocalDateTime.of(2021, 1, 16, 22, 13, 10, 456_000_000)));
        }

        @Test(expected = DateTimeParseException.class)
        public void Tを脱字した日時でparseする() {
            LocalDateTime.parse("2021-01-1622:13:10.456");
        }
    }

    public static class formatのテスト {

        @Test
        public void _2020年1月1日の日付文字列を生成する() {
            LocalDate date = LocalDate.of(2020, 1, 1);
            assertThat(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(date),
                    is("2020/01/01"));
        }

        @Test
        public void _10時20分30秒400の時刻文字列を生成する() {
            LocalTime time = LocalTime.of(10, 20, 30, 400_000_000);
            assertThat(DateTimeFormatter.ofPattern("HH時mm分ss秒400").format(time),
                    is("10時20分30秒400"));
        }

        @Test
        public void _2021年1月16日22時13分10秒の日時文字列を生成する() {
            LocalDateTime datetime = LocalDateTime.of(2021, 1, 16, 22, 13, 10);
            assertThat(DateTimeFormatter.ofPattern("yyyy年MM月dd日HH時mm分ss秒").format(datetime),
                    is("2021年01月16日22時13分10秒"));
        }
    }
}
