class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char number = board[r][c];
                if (number != '.') {
                    if (!seen.add(number + " in row " + r) ||
                            !seen.add(number + " in col " + c) ||
                            !seen.add(number + " in block " + r / 3 + "-" + c / 3))
                        return false;
                }
            }
        }
        return true;
    }
}