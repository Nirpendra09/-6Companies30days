class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int n = startWords.length;
        int count = 0;
        Set<String> set = new HashSet<>();

        for(String start : startWords) {
            char[] sArr = start.toCharArray();
            Arrays.sort(sArr);
            set.add(new String(sArr));
        }        

        int m = targetWords.length;
        boolean ans = false;

        for(int i = 0; i < m; i++) {
            char[] tArr = targetWords[i].toCharArray();
            Arrays.sort(tArr);
            int k = tArr.length;
            String s = String.valueOf(tArr);

            ans = false;

            for(int j = 0; j < k; j++) {
                String str = s.substring(0, j) + s.substring(j + 1);
                if(set.contains(str)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}