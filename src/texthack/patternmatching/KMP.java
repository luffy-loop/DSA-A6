package texthack.patternmatching;

public class KMP {

    void computeLPSArray(String pat, int m, int lps[]) {

        int len = 0;
        lps[0] = 0;

        int i = 1;

        while (i < m) {

            if (pat.charAt(i) == pat.charAt(len)) {

                len++;
                lps[i] = len;
                i++;

            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public void search(String pat, String txt) {

        int m = pat.length();
        int n = txt.length();

        int lps[] = new int[m];

        computeLPSArray(pat, m, lps);

        int i = 0;
        int j = 0;

        boolean found = false;

        while (i < n) {

            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {

                System.out.println("Pattern found at index " + (i - j));
                found = true;
                j = lps[j - 1];

            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }

        if (!found)
            System.out.println("Pattern not found");
    }
}