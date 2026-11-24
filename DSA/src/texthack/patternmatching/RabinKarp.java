package texthack.patternmatching;

public class RabinKarp {

    static final int MC = 256;

    public static void search(String text, String pattern) {

        int prime = 101;
        int pLen = pattern.length();
        int tLen = text.length();

        if (pLen > tLen) {
            System.out.println("Pattern not found");
            return;
        }

        int pHash = 0;
        int tHash = 0;
        int h = 1;
        int j;
        boolean found = false;

        for (int i = 0; i < pLen - 1; i++) {
            h = (h * MC) % prime;
        }

        for (int i = 0; i < pLen; i++) {
            pHash = (MC * pHash + pattern.charAt(i)) % prime;
            tHash = (MC * tHash + text.charAt(i)) % prime;
        }

        for (int i = 0; i <= tLen - pLen; i++) {

            if (pHash == tHash) {

                for (j = 0; j < pLen; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == pLen) {
                    System.out.println("Pattern found at index " + i);
                    found = true;
                }
            }

            if (i < tLen - pLen) {

                tHash = (MC * (tHash - text.charAt(i) * h)
                        + text.charAt(i + pLen)) % prime;

                if (tHash < 0)
                    tHash += prime;
            }
        }

        if (!found)
            System.out.println("Pattern not found");
    }
}