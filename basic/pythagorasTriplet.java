
import java.util.Scanner;

public class pythagorasTriplet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a= scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        scn.close();

        if (a + b > c && a + c > b && b + c > a) {
    // Now try all 3 combinations
    if (a * a + b * b == c * c ||
        a * a + c * c == b * b ||
        b * b + c * c == a * a) {
        System.out.println("It's a Pythagorean triplet");
    } else {
        System.out.println("It's a triangle, but not a Pythagorean triplet");
    }
} else {
    System.out.println("Not a valid triangle");
}

    }
}
