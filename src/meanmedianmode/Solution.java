package meanmedianmode;

/*************************************************************
 *  Project Name : days-of-statistics
 *  File Name    : Solution.java
 *  Author       : Nishan Subba
 *  Created Date : 8/15/25
 *  Description  : Solution to HackerRank's Mean, Median, and Mode problem
 *
 *  Last Modified: 8/15/25
 *  Modified By  : Nishan Subba
 *  Modifications:
 *      - 8/15/25 [What was changed and why]
 *************************************************************/

import java.util.*;

public class Solution {
    public static void selectionSort(int arraySize, List<Integer> array) {
        for (int i = 0; i < arraySize; i++) {
            int minIndex = i;
            for (int j = i; j < arraySize; j++) {
                if (array.get(j).compareTo(array.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            int temp = array.get(i);
            array.set(i, array.get(minIndex));
            array.set(minIndex, temp);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            int val = input.nextInt();
            numList.add(val);
        }

        // sorting
        // for (int i = 0; i < arraySize; i++) {
        //     int minIndex = i;
        //     for (int j = i; j < arraySize; j++) {
        //         if (numList.get(j).compareTo(numList.get(minIndex)) < 0) {
        //             minIndex = j;
        //         }
        //     }

        //     int currIndexVal = numList.get(i);
        //     numList.set(i, numList.get(minIndex));
        //     numList.set(minIndex, currIndexVal);
        // }
        selectionSort(arraySize, numList);

        int total = 0;

        for (int i : numList) {
            total += i;
        }

        double mean = Math.round((total / (double) arraySize) * 10.0) / 10.0;

        // median

        double median;

        if (arraySize % 2 == 0) {
            median = Math.round(((numList.get(arraySize / 2) + numList.get((arraySize / 2) - 1)) / (double) 2) * 10.0) / 10.0;
        } else {
            int index = (arraySize - 1) / 2;
            median = Math.round(numList.get(index) * 10.0) / 10.0;
        }


        // Hashmap
        Map<Integer, Integer> table = new HashMap<>();

        for (int i : numList) {
            if (table.containsKey(i)) {
                int currCount = table.get(i);
                table.put(i, currCount + 1);
            } else {
                table.put(i, 1);
            }
        }

        // for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
        //     System.out.println(entry.getKey() + ":" + entry.getValue());
        // }

        List<Integer> modeList = new ArrayList<>();

        int maxFreqCount = 0;
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue().compareTo(maxFreqCount) > 0) {
                maxFreqCount = entry.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
            if (entry.getValue().compareTo(maxFreqCount) == 0) {
                modeList.add(entry.getKey());
            }
        }

        // System.out.println("Max count: " + maxFreqCount);
        selectionSort(modeList.size(), modeList);
        // System.out.println(modeList);

        // System.out.println(numList);

        int mode = modeList.get(0);

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        input.close();
    }
}
