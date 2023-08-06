class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int val = 0;
            switch(s.charAt(i)) {
                case 'I' : val = 1; break;
                case 'V' : val = 5; break;
                case 'X' : val = 10; break;
                case 'L' : val = 50; break;
                case 'C' : val = 100; break;
                case 'D' : val = 500; break;
                case 'M' : val = 1000;
            }
            if ( 4 * val < ans ) ans -= val;
            else ans += val;
        }
        return ans;
    }
}
/*Intuition
whenever its a subtracting condition like:
{ IV=4, IX=9, XL=40, XC=90, CD=400, CM=900 }
=> first/second is either = 5 or 10;
=> first = 5sec or 10sec
In any case,
=> first > 4 * sec

We can also prove that we can put (3 * val < ans) if we work the other way around:
e.g. take 38 = XXXVIII
assume we have traversed till X|XXVIII from the ri8 and calculated ans = 28.
now for this last X: (3 * X) > (ans=28)
i.e. 30 > 28 ri8
Now, we know we need to add this X=10 to get ans = 30.
which means we should only subtract if the 3 * first < second.
This is one of the extreme case where the difference between 3 * first and second is just 2. In all other cases, the difference will only get large. ie 3 * first << second.

Complexity
Time complexity: O(n)

Space complexity: O(1) */