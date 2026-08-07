package texthack.patternmatching;

public class RabinKarp {

    static final int MC = 256;

    static void rabinKarp(String text, String pattern, int prime) {

        int pLen = pattern.length();
        int tLen = text.length();

        int pHash = 0;
        int tHash = 0;
        int h = 1;
        int j;

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
                }
            }

            if (i < tLen - pLen) {

                tHash = (MC * (tHash - text.charAt(i) * h)
                        + text.charAt(i + pLen)) % prime;

                if (tHash < 0)
                    tHash += prime;
            }
        }
    }

    public static void main(String[] args) {

        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        int prime = 101;

        rabinKarp(text, pattern, prime);
    }
}