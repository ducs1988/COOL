/**
 * Unique Word Abbreviation
 * 
 * is unique has two condition
 * 1. cannot find the abbrv
 * 2. find the abbrv, but the orginal word is matching the one inside of dictionary
 */

class ValidWordAbbr {
    private Set<String> dict;
    private Map<String, Boolean> map;

    public ValidWordAbbr(String[] dictionary) {
        dict = new HashSet<>();
        map = new HashMap<>();
        
        for (String str : dictionary) dict.add(str);
        
        for (String s : dict) {
            String str = toAbbrv(s);
            map.put(str, !map.containsKey(str));
        }
    }
    
    public boolean isUnique(String word) {
        String str = toAbbrv(word);
        Boolean hasAbbrv = map.get(str);
        return hasAbbrv == null || (hasAbbrv && dict.contains(word));
    }
    
    private String toAbbrv(String s) {
        int n = s.length();
        if (n <= 2)
            return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.length()-2);
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
