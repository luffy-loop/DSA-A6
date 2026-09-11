package texthack.patternmatching;

import java.util.Arrays;

public class SuffixArrayLCP {

    static int[] buildSuffixArray(String text) {

        int n = text.length();
        Integer[] suffixes = new Integer[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = i;
        }

        Arrays.sort(suffixes, (a, b) ->
                text.substring(a).compareTo(text.substring(b)));

        int[] suffixArray = new int[n];

        for (int i = 0; i < n; i++) {
            suffixArray[i] = suffixes[i];
        }

        return suffixArray;
    }

    static int[] buildLCP(String text, int[] suffixArray) {

        int n = text.length();
        int[] lcp = new int[n];

        for (int i = 1; i < n; i++) {

            int a = suffixArray[i - 1];
            int b = suffixArray[i];
            int length = 0;

            while (a + length < n &&
                    b + length < n &&
                    text.charAt(a + length) == text.charAt(b + length)) {
                length++;
            }

            lcp[i] = length;
        }

        return lcp;
    }

    public static void search(String text) {

        int[] suffixArray = buildSuffixArray(text);
        int[] lcp = buildLCP(text, suffixArray);

        System.out.println("\nSuffix Array:");

        for (int i = 0; i < suffixArray.length; i++) {
            System.out.println(
                    suffixArray[i] + " -> " +
                            text.substring(suffixArray[i])
            );
        }

        System.out.println("\nLCP Array:");

        for (int i = 0; i < lcp.length; i++) {
            System.out.println(
                    "LCP[" + i + "] = " + lcp[i]
            );
        }
    }
}