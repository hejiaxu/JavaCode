package com.code.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L0207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visit = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCircle(graph, visit, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCircle(List<List<Integer>> graph, int[] visit, int i) {
        if (visit[i] == 1) {
            return true;
        }
        if (visit[i] > 1) {
            return false;
        }
        visit[i] = 1;
        List<Integer> integers = graph.get(i);
        for (Integer integer : integers) {
            if (isCircle(graph, visit, integer)) {
                return true;
            }
        }
        visit[i] = 2;

        return false;
    }

    public static void main(String[] args) {
        int i = 2;
        int[][] p= new int[][]{{1, 0},{0, 1}};
        boolean b = new L0207CourseSchedule().canFinish(i, p);
        System.out.print(b);
    }

}
// 拓扑排序。
// 1.判断有向图是否有环。深度优先遍历，标记栈中元素为1，如果没有出节点则标记2已访问。如果访问到栈中的元素1，则为有环。
// 2.广度遍历，去掉入度为0的点，并将出度的边的度-1.直到不存在入度为0的边，所有边已遍历则存在拓扑排序

