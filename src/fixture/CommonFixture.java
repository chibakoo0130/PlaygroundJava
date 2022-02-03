package fixture;

public class CommonFixture<T> {

    T input;
    T result;

    public CommonFixture(T input, T result) {
        this.input = input;
        this.result = result;
    }

}
