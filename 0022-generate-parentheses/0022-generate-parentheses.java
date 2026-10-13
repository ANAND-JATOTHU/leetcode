import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start the backtracking process with empty string, 0 open, 0 close brackets
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: if the current string length is 2 * max, it's complete and valid
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Decision 1: Add an open parenthesis if we haven't reached the limit (max)
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // backtrack step
        }

        // Decision 2: Add a close parenthesis if there are unmatched open parentheses
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // backtrack step
        }
    }
}