package standarddeviation;

/*************************************************************
 *  Project Name : days-of-statistics
 *  File Name    : StandardDeviation.java
 *  Author       : Nishan Subba
 *  Created Date : 8/15/25
 *  Description  : Solution to HackerRank's Standard Deviation problem
 *
 *  Last Modified: 8/15/25
 *  Modified By  : Nishan Subba
 *  Modifications:
 *      - 8/15/25 [What was changed and why]
 *************************************************************/

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

class Result {
    /*
     * Complete the 'stdDev' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void stdDev(List<Integer> arr) {
        // To find standard deviation
        // 1. Find "mean" by sum of array and divide by num of elements (size of array)
        // 2. Subtract mean from each element and square the result
        // 3. Sum the total square
        // 4. Take the square root of sum of total square / num of elements
        // 5. Round to 1 decimal places

        int total = arr.stream()
                .mapToInt(Integer::intValue)
                .sum();

        int size = arr.size();

        double mean = Math.round((total / (double) size) * 10.0) / 10.0;

        List<Double> updatedArr = arr.stream()
                .map(num -> Math.pow((num - mean), 2))
                .collect(Collectors.toList());

        System.out.println("Mean: " + mean);
        System.out.println(updatedArr);
        double updatedTotal = updatedArr.stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Updated Total: " + updatedTotal);
        double standardDeviation = Math.round((Math.sqrt(updatedTotal / size)) * 10.0) / 10.0;
        System.out.println("Standard Deviation: " + standardDeviation);

    }
}

public class StandardDeviation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size = input.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(input.nextInt());
        }

        Result.stdDev(arr);

        input.close();

    }
}
