package javaproject2.week2.day10;

public class ElseEx {
    public static void main(String[] args) {
        boolean checkTrue = true;
        if (checkTrue) {
            System.out.println("true입니다.");
        } else {
            System.out.println("false입니다.");
        }

        boolean checkFalse = false;
        if (checkFalse) { // 논리값이 false인 경우
            System.out.println("true입니다.");
        } else {
            System.out.println("false입니다.");
        }
    }

}
