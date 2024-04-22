package com.arthur.codes.leetcode.solutiions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Leetcode 1631: 最小体力消耗问题
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，
 * 且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
 * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * 
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 10^6
 *
 * @author: huhao
 * @create: 2024/4/8
 */
public class MinEffortPathSolution_1631 {

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<Edage> edages = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for (int j = 0; j<cols;j++){
                /**
                 * 由于地图是二维的，我们需要给每个格子对应的节点赋予一个唯一的节点编号。
                 * 如果地图的行数为 mmm，列数为 nnn，那么位置为 (i,j)(i, j)(i,j) 的格子对应的编号为 i×n+j，
                 * 这样 ,mn个格子的编号一一对应着 [0,mn)范围内的所有整数
                 *
                 */
                int id = i*cols+j; // 二维转一维的编号技巧
                if(i>0){
                    Edage edage = new Edage(new int[]{id-cols,id},Math.abs(heights[i][j] - heights[i-1][j]));
                    edages.add(edage);
                }
                if(j > 0){
                    Edage edage = new Edage(new int[]{id-1,id},Math.abs(heights[i][j] - heights[i][j-1]));
                    edages.add(edage);
                }
            }
        }

        Collections.sort(edages, new Comparator<Edage>() {
            @Override
            public int compare(Edage o1, Edage o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        int minEffort = 0;
        UnionFindUtil unionFindUtil = new UnionFindUtil(rows * cols);
        for(Edage edage:edages){
            int x = edage.vertexes[0],y = edage.vertexes[1];
            unionFindUtil.union(x,y);
            if(unionFindUtil.isConnected(0,cols * rows -1)){
                minEffort = edage.weight;
                break;
            }
        }
        return minEffort;
    }

    class Edage {
        int[] vertexes = new int[2];
        int weight;

        public Edage(int[] vertexes,int weight){
            this.vertexes = vertexes;
//            Arrays.sort(vertexes);
            this.weight = weight;
        }

        public int[] getVertexes() {
            return vertexes;
        }

        public int getWeight() {
            return weight;
        }

    }

    

    public static void main(String[] args) {
        MinEffortPathSolution_1631 minEffortPathSolution1631 = new MinEffortPathSolution_1631();
        int[][] heights = new int[][]{
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };

        int minEffort = minEffortPathSolution1631.minimumEffortPath(heights);
        System.out.println(minEffort);

        heights = new int[][]{
                {1,2,1,1,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,1,1,2,1}
        };
        System.out.println(minEffortPathSolution1631.minimumEffortPath(heights));
    }

}
