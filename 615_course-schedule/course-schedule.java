/*
@Copyright:LintCode
@Author:   yun16
@Problem:  http://www.lintcode.com/problem/course-schedule
@Language: Java
@Datetime: 17-01-26 20:28
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your code here
        ArrayList[] courses = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][1]].add(prerequisites[i][0]);
            degree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        //HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            for (int i = 0; i < courses[temp].size(); i++) {
                int pointer = (int) courses[temp].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        return count == numCourses;
    }
}