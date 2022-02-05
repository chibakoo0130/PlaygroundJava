package fixture;

import static fixture.MethodSample.isGreaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MethodSampleTest {

    @RunWith(Theories.class)
    public static class Fixtureを用いる {

        @DataPoints
        public static Fixture[] params = {
                new Fixture(-1, false),
                new Fixture(0, false),
                new Fixture(1, false),
                new Fixture(2, true),
        };

        @Theory
        public void testIsGreater(Fixture f) {
            assertThat(isGreaterThan(f.input), is(f.result));
        }
    }

    @RunWith(Theories.class)
    public static class CommonFixtureを用いる {

        @DataPoints
        public static CommonFixture<?, ?>[] params = {
                new CommonFixture<Integer, Boolean>(-1, false),
                new CommonFixture<Integer, Boolean>(0, false),
                new CommonFixture<Integer, Boolean>(1, false),
                new CommonFixture<Integer, Boolean>(2, true),
        };

        @Theory
        public void testIsGreater(CommonFixture<Integer, Boolean> f) {
            assertThat(isGreaterThan(f.input), is(f.result));
        }
    }


}