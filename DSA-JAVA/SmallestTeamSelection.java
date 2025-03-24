/* Minimum Team Selection to Cover Required Skills
 * Problem Statement: 
 * You are given a list of required skills and a list of Candidates,
 * where each candidate has a subset of skills. Your task is to find the
 * smallest possible team such that all required skills are covered.
 * You will be given:
 * 1. Required skills list
 * 2. Number of candidates(N)
 * 3.Skillsets of N candidates
 * Return the indices of selected candidates forming the smallest team.
 * 
 * Example : 
 * Input: a b c d, 4, a b, b c, c d, d 
 * Output: 0 2
 * Input: a b c, 3, a, b c, c
 * Output: 0 1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestTeamSelection {

    public static List<Integer> findSmallestTeam(List<String> reqSkills, List<List<String>> candidates) {
        int n = reqSkills.size();
        int m = candidates.size();

        // Map skill to a bit position
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(reqSkills.get(i), i);
        }

        // Convert candidate skills to bitmasks
        int[] skillMasks = new int[m];
        for (int i = 0; i < m; i++) {
            for (String skill : candidates.get(i)) {
                if (skillIndex.containsKey(skill)) {
                    skillMasks[i] |= (1 << skillIndex.get(skill));
                }
            }
        }

        // DP approach: dp[mask] stores the smallest team covering 'mask' skills
        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());

        for (int i = 0; i < m; i++) {
            if (skillMasks[i] == 0) continue; // Skip candidates with no useful skills

            // Iterate over a copy of dp to prevent modification during iteration
            Map<Integer, List<Integer>> newDp = new HashMap<>(dp);
            for (int prevMask : dp.keySet()) {
                int newMask = prevMask | skillMasks[i];
                if (newMask == prevMask) continue; // No new skills added

                // If newMask is not in dp or we found a smaller team, update it
                if (!newDp.containsKey(newMask) || dp.get(prevMask).size() + 1 < newDp.get(newMask).size()) {
                    List<Integer> newTeam = new ArrayList<>(dp.get(prevMask));
                    newTeam.add(i);
                    newDp.put(newMask, newTeam);
                }
            }
            dp = newDp;
        }

        return dp.get((1 << n) - 1); // Return the team covering all skills
    }

    public static void main(String[] args) {
        // Example 1
        List<String> reqSkills = Arrays.asList("a", "b", "c", "d");
        List<List<String>> candidates = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c"),
            Arrays.asList("c", "d"),
            Arrays.asList("d")
        );
        System.out.println(findSmallestTeam(reqSkills, candidates)); // Output: [0, 2]

        // Example 2
        List<String> reqSkills2 = Arrays.asList("a", "b", "c");
        List<List<String>> candidates2 = Arrays.asList(
            Arrays.asList("a"),
            Arrays.asList("b", "c"),
            Arrays.asList("c")
        );
        System.out.println(findSmallestTeam(reqSkills2, candidates2)); // Output: [0, 1]
    }
}
