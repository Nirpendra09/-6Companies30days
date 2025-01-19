class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        
        Character[] nutsObj = new Character[n];
        Character[] boltsObj = new Character[n];
        
        for(int i = 0; i < n; i++) {
            nutsObj[i] = nuts[i];
            boltsObj[i] = bolts[i];
        }
        
        Map<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('!', 0);
        priorityMap.put('#', 1);
        priorityMap.put('$', 2);
        priorityMap.put('%', 3);
        priorityMap.put('&', 4);
        priorityMap.put('*', 5);
        priorityMap.put('?', 6);
        priorityMap.put('@', 7);
        priorityMap.put('^', 8);
        
        Arrays.sort(nutsObj, (c1, c2) -> priorityMap.get(c1) - priorityMap.get(c2));
        Arrays.sort(boltsObj, (c1, c2) -> priorityMap.get(c1) - priorityMap.get(c2));
        
        
        for(int i = 0; i < n; i++) {
            nuts[i] = nutsObj[i];
            bolts[i] = boltsObj[i];
        }
    }
}