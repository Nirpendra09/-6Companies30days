class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int idx = 0;

        for(int[] query : queries) {
            List<String[]> trimmedNums = new ArrayList<>();

            for(int i = 0; i < nums.length; i++) {
                String num = nums[i];
                String newNum = num.substring(num.length() - query[1]);
                trimmedNums.add(new String[]{newNum, String.valueOf(i)});
            }

            Collections.sort(trimmedNums, (a,b) -> {
                int cmp = a[0].compareTo(b[0]);
                if(cmp == 0) {
                    return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
                }
                return cmp;
            });

            res[idx++] = Integer.parseInt(trimmedNums.get(query[0] - 1)[1]);
        }
        return res;
    }
}