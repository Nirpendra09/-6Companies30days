class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int n = aliceValues.length;
        for(int i = 0; i < n; i++) {
            int[] arr = new int[2];
            arr[0] = aliceValues[i] + bobValues[i];
            arr[1] = i;

            pq.add(arr);
        }

        int aliceScore = 0, bobScore = 0;
        boolean aliceTurn = true;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[1];

            if(aliceTurn) {
                aliceScore += aliceValues[idx];
                aliceTurn = false;
            } else {
                bobScore += bobValues[idx];
                aliceTurn = true;
            }
        }

        return Integer.compare(aliceScore, bobScore);
    }
}