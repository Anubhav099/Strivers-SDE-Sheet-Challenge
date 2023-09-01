// using memoization
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int dp[][] = new int[n][4];
        return findMax(0, 3, points, dp);
    }
    private static int findMax(int ind, int prev, int points[][], int[][] dp) {
        if (ind == points.length) return 0;
        if (dp[ind][prev] != 0) return dp[ind][prev];

        int mx = 0;
        for (int i = 0; i < 3; i++) {
            if (i == prev) continue;
            int curMax = points[ind][i] + findMax(ind + 1, i, points, dp);
            mx = Math.max(curMax, mx);
        }
        return dp[ind][prev] = mx;
    }
}


// using tabulation
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int dp[][] = new int[n][4];
        // Setting up the base cases dp[(0, 0), (0, 1), (0, 2), (0, 3)]
        for (int last = 0; last < 4; last++) {
            int mx = 0;
            for (int task = 0; task < 3; task++)
                if (task != last)
                    mx = Math.max(mx, points[0][task]);
            dp[0][last] = mx;
        }

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {

                int mx = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int curMax = points[day][task] + dp[day - 1][task];
                        mx = Math.max(mx, curMax);
                    }
                }
                dp[day][last] = mx;

            }
        }
        return dp[n - 1][3];
    }
}
// (day, 3) signifies the ans if we can pick any task (i.e. if we haven’t picked any task ever before) which is only relevant if this is task we are starting with. So, storing the (day, 3) for all days is a waste as we only care about [n-1][3] which is to mean that on the n-1 day, we haven’t picked anything ever before which is always true and false for all other cases. 
// we can optimize the space a little more by reducing the dp size to 3 instead of 4 and return max(dp[n – 1][0], max(dp[n – 1][1], dp[n – 1][2]));


// Cleaner code
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int dp[][] = new int[n][3];

        for (int day = 0; day < n; day++) {
            for (int last = 0; last < 3; last++) {

                int mx = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int curMax = points[day][task];
                        if (day > 0) curMax += dp[day - 1][task];
                        mx = Math.max(mx, curMax);
                    }
                }
                dp[day][last] = mx;

            }
        }
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}

// SPACE OPTIMIZATION
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int prev[] = new int[3];
        // Setting up the base cases
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);


        for (int day = 1; day < n; day++) {
            int[] temp = new int[3];
            for (int last = 0; last < 3; last++) {

                int mx = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int curMax = points[day][task] + prev[task];
                        mx = Math.max(mx, curMax);
                    }
                }
                temp[last] = mx;
            }
            prev = temp;
        }
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
}


// BEST SOLUTION
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        // Write your code here..
        int prev[] = new int[] {
            points[0][0],
            points[0][1],
            points[0][2]
        };

        for (int day = 1; day < n; day++) {
            int[] cur = new int[] {
                points[day][0] + Math.max(prev[1], prev[2]),
                points[day][1] + Math.max(prev[0], prev[2]),
                points[day][2] + Math.max(prev[0], prev[1])
            };
            prev = cur;
        }
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
}
// Simple logic. Just consider a small test case of 2 days.
// What we need to do is on the 2nd day we just need to find 3 things (points):
    // the max points if the task1 is selected today = task1 on day2(cur) PLUS max(task2 on day1(prev), task3 on day1(prev)).
    // the max points if task2 is selected today
    // the max points if task3 is selected today
// these 3 info for the cur day becomes the info of prev day for the next day.