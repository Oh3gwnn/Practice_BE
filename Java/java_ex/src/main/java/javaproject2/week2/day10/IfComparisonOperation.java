package javaproject2.week2.day10;

public class IfComparisonOperation {
    public static void main(String[] args) {
        int age = 15;
        boolean isAdult = age >= 18;

        if (isAdult) {
            System.out.println("성인입니다.");
        }
        if (age < 18) {
            System.out.println("미성년자입니다.");
        }
    }
}
