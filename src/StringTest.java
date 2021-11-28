import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class StringTest {

    public static class trimテスト {

	@Test
	public void trimされる() {
	    assertThat("".trim(), is(""));
	    assertThat(" ".trim(), is(""));
	    assertThat(" _".trim(), is("_"));
	    assertThat("1234567890".trim(), is("1234567890"));
	    assertThat("_ ".trim(), is("_"));
	    assertThat(" _ ".trim(), is("_"));
	    assertThat("    ".trim(), is(""));
	    assertThat(" q q".trim(), is("q q"));
	    assertThat("1  ".trim(), is("1"));
	}

	@Test
	public void trimされない() {
	    // 全角スペースはtrimされない
	    assertThat("　".trim(), is("　"));
	    assertThat("　trim　".trim(), is("　trim　"));
	}
    }

    public static class codePointAtテスト{

	@Test(expected = IndexOutOfBoundsException.class)
	public void 空文字に対してはエラー() {
	    "".codePointAt(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void 文字列より大きいインデックスを指定するとエラー() {
	    "1".codePointAt(2);
	}

	@Test
	public void codePointAtされる() {
	    assertThat(" ".codePointAt(0), is(32));
	    assertThat("東".codePointAt(0), is(26481));
	}
    }

    public static class getBytesテスト {

	@Test
	public void getBytesされる() {
	    assertThat(Byte.toString("1".getBytes()[0]), is("49"));
	    assertThat(Byte.toString("あ".getBytes()[0]), is("-29"));
	    assertThat(Byte.toString("あ".getBytes(StandardCharsets.UTF_8)[0]), is("-29"));
	    try {
		assertThat(Byte.toString("あ".getBytes("Shift-JIS")[0]), is("-126"));
	    } catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	    }
	    assertThat(Byte.toString("a".getBytes(StandardCharsets.UTF_8)[0]), is("97"));
	    assertThat("".getBytes().length, is(0)); // 空文字をgetBytesすると長さ0の配列を返される
	}
    }

    public static class splitテスト {

	@Test
	public void splitされる() {
	    String target = "boo:and:foo";
	    assertThat(target.split(":"), is(new String[] { "boo", "and", "foo" }));
	    // 後続の空文字要素は破棄される（split(regex, n)のn=0の挙動となっているため）
	    assertThat(target.split("o"), is(new String[] { "b", "", ":and:f" }));
	    assertThat(target.split(":and"), is(new String[] { "boo", ":foo" }));
	    assertThat(target.split("oo"), is(new String[] { "b", ":and:f"}));
	    assertThat("aoohoo".split("o"), is(new String[] { "a", "", "h" }));
	    assertThat("aoohoo!".split("o"), is(new String[] { "a", "", "h", "", "!" }));
	}
    }
}
