package javaproject2.week1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        MultiplicationTable multiplicationTable = new MultiplicationTable();
        System.out.printf("%d * %d = %d", A, B, A*B);

    }
}
