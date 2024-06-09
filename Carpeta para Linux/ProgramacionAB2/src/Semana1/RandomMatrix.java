package Semana1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMatrix {

    private static Random random = new Random();

    public static List<List<Integer>> generateMatrix(int rows, int cols) {
        List<List<Integer>> output = new ArrayList<>();
        for (var i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(random.nextInt(21));
            }
            output.add(row);
        }
        return output;
    }
}
