package bevans.ztm.arrays;

public class LongestWord {
    public String longestWord(String sen) {
        var parts = sen.split("\\W");
        String longestWord = null;
        int longestLength = 0;

        for (var word : parts) {
            if (word.length() > longestLength) {
                longestWord = word;
                longestLength = word.length();
            }
        }

        return longestWord;
    }
}
