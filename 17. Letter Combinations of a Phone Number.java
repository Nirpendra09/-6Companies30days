class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), digitToLetters);

        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder comb, Map<Character, String> digitToLetters) {
        if(idx == digits.length()) {
            res.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(idx));
        for(char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}