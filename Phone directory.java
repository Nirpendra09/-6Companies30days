class Solution {
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s) {
        // Result list to store matches for each prefix
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        // Remove duplicates and sort contacts
        TreeSet<String> uniqueContacts = new TreeSet<>();
        for (String cont : contact) {
            uniqueContacts.add(cont);
        }
        
        // For each prefix length
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            ArrayList<String> currentMatches = new ArrayList<>();
            
            // Check each contact for current prefix
            for (String cont : uniqueContacts) {
                if (cont.startsWith(prefix)) {
                    currentMatches.add(cont);
                }
            }
            
            // If no matches found, add "0"
            if (currentMatches.isEmpty()) {
                currentMatches.add("0");
            }
            
            result.add(currentMatches);
        }
        
        return result;
    }
}