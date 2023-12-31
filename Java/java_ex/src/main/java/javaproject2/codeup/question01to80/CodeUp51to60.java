package javaproject2.codeup.question01to80;

import java.io.IOException;
import java.util.Scanner;

public class CodeUp51to60 {
    /* Main 클래스 복붙용
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

        }
    }
    */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 1051
        long compare1 = sc.nextLong(), compare2 = sc.nextLong();
        int ans1 = compare1<=compare2 ? 1 : 0;
        System.out.println(ans1);

        // 1052
        long compare3 = sc.nextLong(), compare4 = sc.nextLong();
        int ans2 = compare3!=compare4 ? 1 : 0;
        System.out.println(ans2);

        // 1053
        int i1 = sc.nextInt() == 1 ? 0 : 1;
        System.out.println(i1);

        // 1054 자바도 역시 한줄 if 되는구나(깨달음)
        int i2 = sc.nextInt(), i3 = sc.nextInt();
        if(i2==1 && i3==1) System.out.println(1);
        else System.out.println(0);

        // 1055
        int i4 = sc.nextInt(), i5 = sc.nextInt();
        if(i4==1 || i5==1) System.out.println(1);
        else System.out.println(0);

        // 1056
        int i6 = sc.nextInt(), i7 = sc.nextInt();
        if(i6!=i7) System.out.println(1);
        else System.out.println(0);

        // 1057
        int ox1 = sc.nextInt(), ox2 = sc.nextInt();
        if(ox1!=ox2) System.out.println(0);
        else System.out.println(1);

        // 1058
        int ox3 = sc.nextInt(), ox4 = sc.nextInt();
        if(ox3==0 && ox4==0) System.out.println(1);
        else System.out.println(0);

        // 1059
        int bitwise = ~sc.nextInt();
        System.out.println(bitwise);

        // 1060
        int bitwise1 = sc.nextInt() & sc.nextInt();
        System.out.println(bitwise1);
    }
}
