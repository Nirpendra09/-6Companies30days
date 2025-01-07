class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0) {
            columnNumber--;
            char currentChar = (char) ((columnNumber % 26) + 'A');
            sb.append(currentChar);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}