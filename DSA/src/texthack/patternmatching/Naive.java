package texthack.patternmatching;

public class Naive {

    public static void search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();
        boolean found = false;

        for (int i = 0; i <= n - m; i++) {

            int j;

            for (j = 0; j < m; j++) {

                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + i);
                found = true;
            }
        }

        if (!found)
            System.out.println("Pattern not found");
    }
}