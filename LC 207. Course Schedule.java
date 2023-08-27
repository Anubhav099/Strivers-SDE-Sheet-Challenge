class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // using Modified Kahn's Algorithm
        boolean[] vis = new boolean[prerequisites.length];
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites)
            indegree[prerequisite[1]]++;
        
        boolean changesWereMade = true;
        while(changesWereMade){
            changesWereMade = false;
            for (int i = 0; i < prerequisites.length; i++)
                if (!vis[i])
                    if (indegree[prerequisites[i][0]] == 0) {
                        indegree[prerequisites[i][1]]--;
                        vis[i] = true;
                        changesWereMade = true;
                    }
        }

        for (int i: indegree)
            if (i != 0)
                return false;
        return true;
    }
}