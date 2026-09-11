package texthack.patternmatching;

public class ZFunction {

    public static void search(String text, String pattern) {

        String s = pattern + "$" + text;

        int n = s.length();
        int[] z = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {

            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < n &&
                    s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (z[i] == pattern.length()) {

                System.out.println("Pattern found at index: "
                        + (i - pattern.length() - 1));

                found = true;
            }
        }

        if (!found) {
            System.out.println("Pattern not found");
        }
    }
}