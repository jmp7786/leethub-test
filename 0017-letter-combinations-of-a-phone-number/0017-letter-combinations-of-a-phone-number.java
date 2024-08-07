class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, char[]> map = new HashMap<>();
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        List<String> result =  addChars(digits, map, 0);
        return result;
    }

    private List<String> addChars(String digits, Map<Character, char[]> map, int idx) {
        List<String> result = new LinkedList<>();

        if (idx == digits.length()-1)  {
            char[] chars = map.get(digits.charAt(idx));
            for(int i = 0; i < chars.length; i++) {
                result.add(String.valueOf(chars[i]));
            }
            return result;
        }

        
        char[] chars = map.get(digits.charAt(idx));
        

        for(int i = 0; i < chars.length; i++) {
            List<String> strs = addChars(digits, map, idx+1);
            for(String str: strs) {
                StringBuilder sb = new StringBuilder();
                sb.append(chars[i]);   
                sb.append(str);   
                result.add(sb.toString());
            }
        }

        return result;
    }
}