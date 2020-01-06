package engine;

public class Utils {

    public static <T> void copyArray(T[][] to, T[][] from) {
        for (int i = 0; i < from.length; i++) {
            for (int j = 0; j < from[0].length; j++) {
                to[i][j] = from[i][j];
            }
        }
    }
}
