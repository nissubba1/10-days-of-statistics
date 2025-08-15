package weightedmean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {
    /*
     * Complete the 'weightedMean' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY X
     *  2. INTEGER_ARRAY W
     */

    public static void weightedMean(List<Integer> X, List<Integer> W) {
        List<Integer> arraySums = new ArrayList<>();

        for (int i = 0; i < X.size(); i++) {
            int total = X.get(i) * W.get(i);
            arraySums.add(total);
        }

        int arrayTotal = arraySums.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int weightedSum = W.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum: "  + arrayTotal + " W sum: " +  weightedSum);

        double avgMean = Math.round((arrayTotal / (double) weightedSum) * 10.0) / 10.0;

        System.out.println("Average mean = " + avgMean);
    }
}

public class WeightedMean {
     // Input test
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();
        List<Integer> X = new ArrayList<>();
        List<Integer> W = new ArrayList<>();

        for (int i = 0; i < arraySize; i++) {
            X.add(input.nextInt());
        }

        for (int i = 0; i < arraySize; i++) {
            W.add(input.nextInt());
        }

        System.out.println(X);
        System.out.println(W);

        Result.weightedMean(X, W);

        input.close();
    }
}
