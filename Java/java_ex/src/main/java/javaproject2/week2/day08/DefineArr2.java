package javaproject2.week2.day08;

import java.util.Arrays;

public class DefineArr2 {

    public static void main(String[] args) {
        int[] iArr = new int[] {1, 2, 3, 8};
        int[][] arr32 = new int[3][2];
        int[][] arr67 = new int[6][7];

        int[][] arr2 = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };

        System.out.println(Arrays.toString(arr2[0])); // [10, 20, 30]
        System.out.println(Arrays.toString(arr2[1])); // [40, 50, 60]
        System.out.println(Arrays.toString(arr2[2])); // [70, 80, 90]

        System.out.println(arr2[0][0]); // 10
        System.out.println(arr2[0][1]); // 20
    }
}
