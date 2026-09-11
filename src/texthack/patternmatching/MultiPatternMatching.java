package texthack.patternmatching;

public class MultiPatternMatching {

    public static void search(String text, String[] patterns) {

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
}