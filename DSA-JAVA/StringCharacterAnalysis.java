/* 
 * Given a string S, find: 
 * 1.The first non-repeating character (or "None" if none exists).
 * 2.The most frequent character (or the first character if all are unique).
 * Input1: swadesh
 * Output1: w s
 * Input2: aabbcc
 * Output2: None a
 */

import java.util.*;

public class StringCharacterAnalysis {

    public static void main(String[] args) {
        System.out.println(findCharacters("swadesh")); // Output: w s
        System.out.println(findCharacters("aabbcc")); // Output: None a
    }

    public static String findCharacters(String s) {
        // Step 1: Frequency Map to store character counts
        Map<Character, Integer> freqMap = new HashMap<>();
        // Step 2: LinkedHashMap to maintain order of first occurrences
        LinkedHashMap<Character, Integer> indexMap = new LinkedHashMap<>();

        // Count the frequencies and track the index of first occurrences
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            if (!indexMap.containsKey(ch)) {
                indexMap.put(ch, i);
            }
        }

        // Step 3: Find the first non-repeating character
        String firstNonRepeating = "None";
        for (char ch : indexMap.keySet()) {
            if (freqMap.get(ch) == 1) {
                firstNonRepeating = String.valueOf(ch);
                break;
            }
        }

        // Step 4: Find the most frequent character
        char mostFrequentChar = s.charAt(0);
        int maxFrequency = 0;
        boolean allUnique = true;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentChar = entry.getKey();
                allUnique = false;
            }
        }

        // If all characters are unique, return the first character
        if (allUnique) {
            mostFrequentChar = s.charAt(0);
        }

        return firstNonRepeating + " " + mostFrequentChar;
    }
}
