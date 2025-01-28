class ThroneInheritance {
    HashMap<String, ArrayList<String>> map;
    String king = "";
    HashSet<String> set = new HashSet<>();

    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        king = kingName;    
    }
    
    public void birth(String parentName, String childName) {
        if(!map.containsKey(parentName)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(childName);
            map.put(parentName, list);
        }else {
            ArrayList<String> list = map.get(parentName);
            list.add(childName);
            map.put(parentName, list);
        }
    }
    
    public void death(String name) {
        set.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        ArrayList<String> result = new ArrayList<>();
        Stack<String> st = new Stack<>();
        st.add(king);

        while(!st.isEmpty()) {
            String s = st.pop();
            if(!set.contains(s)) {
                result.add(s);
            }

            if(map.containsKey(s)) {
                ArrayList<String> list = map.get(s);
                for(int i = list.size() - 1; i>= 0; i--) {
                    st.push(list.get(i));
                }
            }
        }
        return result;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */