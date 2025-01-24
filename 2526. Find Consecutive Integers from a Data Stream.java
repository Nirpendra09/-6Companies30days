class DataStream {
    int val, k;
    int count = 0;

    public DataStream(int value, int k) {
        this.val = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        if(num != val) count = 0;
        if(num == val) count++;
        return count >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */