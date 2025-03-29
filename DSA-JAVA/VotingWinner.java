/* Find the Winner Based on Votes There are N candidates and M
 * Each location casts votes for the candidates. The candidate 
 * who gets the maximum votes or more than 50% of the total
 * votes is the winner. if there is a tie, no winner is declared.
 * Input : 2 5 A B A A A A B B A B
 * Output : A
 */
import java.util.*;

public class VotingWinner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of candidates and locations
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        
        // Read candidate names
        Set<String> candidates = new HashSet<>();
        for (int i = 0; i < N; i++) {
            candidates.add(scanner.next());
        }
        
        // Count votes for each candidate
        Map<String, Integer> voteCount = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String vote = scanner.next();
            voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
        }
        
        // Determine the winner
        String winner = null;
        int maxVotes = 0;
        int totalVotes = M;
        boolean tie = false;

        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            String candidate = entry.getKey();
            int votes = entry.getValue();
            
            if (votes > maxVotes) {
                maxVotes = votes;
                winner = candidate;
                tie = false; // Reset tie status
            } else if (votes == maxVotes) {
                tie = true; // Tie detected
            }
        }

        // Check if the winner has more than 50% of votes
        if (!tie && maxVotes > totalVotes / 2) {
            System.out.println(winner);
        } else {
            System.out.println("No Winner");
        }

        scanner.close();
    }
}
