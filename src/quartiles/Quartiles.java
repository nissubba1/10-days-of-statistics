package quartiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*************************************************************
 *  Project Name : days-of-statistics
 *  File Name    : Quartiles.java
 *  Author       : Nishan Subba
 *  Created Date : 8/15/25
 *  Description  : Solution to HackerRank's Quartiles problem
 *
 *  Last Modified: 8/15/25
 *  Modified By  : [Name or Initials]
 *  Modifications:
 *      - 8/15/25 [What was changed and why]
 *************************************************************/

class Result {
    /*
     * Complete the 'quartiles' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int getMedian(List<Integer> arr) {
        return arr.size() % 2 == 0 ? (arr.get(arr.size() / 2) + arr.get((arr.size() / 2 - 1))) / 2 : arr.get((arr.size() - 1) / 2);

    }

    public static List<Integer> quartiles(List<Integer> arr) {
        // Write your code here

        for (int i = 0; i < arr.size(); i++) {
            int minIndex = i;
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j).compareTo(arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Collections.swap(arr, i, minIndex);
        }

        int median = getMedian(arr);

        List<Integer> lowerQ = new ArrayList<>();
        List<Integer> upperQ = new ArrayList<>();

        int midIndex = arr.size() / 2;

        if (arr.size() % 2 == 0) {
            lowerQ.addAll(arr.subList(0, midIndex));
            upperQ.addAll(arr.subList(midIndex, arr.size()));
        } else {
            lowerQ.addAll(arr.subList(0, midIndex));
            upperQ.addAll(arr.subList(midIndex + 1, arr.size()));
        }

        int lowerQMedian = getMedian(lowerQ);
        int upperQMedian = getMedian(upperQ);

        List<Integer> result = new ArrayList<>();
        result.add(lowerQMedian);
        result.add(median);
        result.add(upperQMedian);

        return result;
    }

}

public class Quartiles {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(input.nextInt());
        }

        System.out.println(Result.quartiles(arr));

        input.close();
    }
}
