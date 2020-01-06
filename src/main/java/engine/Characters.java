package engine;

public enum Characters {
    EMPTY(' '),
    POINT('■'),
    NAN('▦');



    char value;

    Characters(char value) {
        this.value = value;
    }

    public char get() {
        return value;
    }
}
