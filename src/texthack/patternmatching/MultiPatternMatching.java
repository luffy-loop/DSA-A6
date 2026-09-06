package texthack.patternmatching;

import java.util.Scanner;

public class MultiPatternMatching {

    static void search(String text, String[] patterns) {

        for (String pattern : patterns) {

            boolean found = false;

            System.out.println("\nPattern: " + pattern);

            int index = text.indexOf(pattern);

            while (index != -1) {
                System.out.println("Found at index: " + index);
                found = true;

                index = text.indexOf(pattern, index + 1);
            }

            if (!found) {
                System.out.println("Pattern not found");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter number of patterns: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] patterns = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter pattern " + (i + 1) + ": ");
            patterns[i] = sc.nextLine();
        }

        search(text, patterns);

        sc.close();
    }
}