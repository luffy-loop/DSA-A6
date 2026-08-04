import java.util.Scanner;
import texthack.patternmatching.Naive;
import texthack.patternmatching.KMP;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();

        System.out.println("\n1. Naive String Matching");
        System.out.println("2. KMP Algorithm");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                Naive.search(text, pattern);
                break;

            case 2:
                KMP kmp = new KMP();
                kmp.search(pattern, text);
                break;

            default:
                System.out.println("Invalid Choice");
        }

        sc.close();
    }
}