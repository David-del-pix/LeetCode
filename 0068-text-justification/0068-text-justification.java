import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Try to fit as many words as possible into the current line
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = last - index;
            int numSpaces = maxWidth - totalChars + (numWords - 1); // total spaces to distribute

            // If last line or line has only one word: left justify
            if (last == n || numWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        sb.append(" ");
                    }
                }
                // Fill remaining spaces
                int remaining = maxWidth - sb.length();
                while (remaining > 0) {
                    sb.append(" ");
                    remaining--;
                }
            } else {
                // Middle justified
                int spacesBetweenWords = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        for (int s = 0; s < spacesBetweenWords; s++) {
                            sb.append(" ");
                        }
                        if (extraSpaces > 0) {
                            sb.append(" ");
                            extraSpaces--;
                        }
                    }
                }
            }

            result.add(sb.toString());
            index = last;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(sol.fullJustify(words1, 16));

        String[] words2 = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(sol.fullJustify(words2, 16));

        String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(sol.fullJustify(words3, 20));
    }
}
