class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
 
        for( char ch: s.toCharArray() ) {
            if( map.containsKey( ch ) )
                stk.push( ch );
            else if( stk.isEmpty() || map.get( stk.pop() ) != ch )
                    return false;
        }
        return stk.isEmpty();
    }
}