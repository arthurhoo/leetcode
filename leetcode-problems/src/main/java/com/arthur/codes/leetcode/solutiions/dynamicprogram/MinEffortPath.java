package com.arthur.codes.leetcode.solutiions.dynamicprogram;

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
public class MinEffortPath {

    //主函数
    public int minimumEffortPath(int[][] heights){
        if(null == heights){
            return 0;
        }
        if(heights.length <1 || heights.length>100 || heights[0].length < 1 || heights[0].length >100){
            throw new IllegalArgumentException("初始化参数异常");
        }
        
        int cost = heights[0][0];
        int rows = heights.length;
        int columns = heights[0].length;
        
        int[][] minCostTable = new int[rows][columns];
        
        minCostTable = calMinCost(heights,minCostTable,rows-1,columns-1,rows,columns);

        cost = minCostTable[rows-1][columns-1];
        
        return cost;
        
        
    }
    
    
    public int[][] calMinCost(int[][] heights, int[][] minCostTable, int row, int col, int rows, int cols){
        int minCost = Integer.MAX_VALUE;
        int upCost = Integer.MAX_VALUE;
        int leftCost = Integer.MAX_VALUE;
        int rightCost = Integer.MAX_VALUE;
        int downCost = Integer.MAX_VALUE;
        int minCostDirect = -1;
        if(row ==0 && col == 0){
            minCost = 0;
        } else if (row == 0 && col == cols-1) {

            leftCost = heights[row][col] - heights[row][col-1];
            downCost = heights[row][col] - heights[row+1][col];

//            minCost = Math.min(leftCost,downCost);
//            minCostTable[row][col] = minCost;

        }else if(row == rows-1 && col ==0){
            upCost = heights[row][col] - heights[row-1][col];
            rightCost = heights[row][col] - heights[row][col+1];
//            minCost = Math.min(upCost,rightCost);
//            minCostTable[row][col] = minCost;
        } else if (row == rows-1 && col == cols-1) {
            upCost = heights[row][col] - heights[row-1][col];
            leftCost = heights[row][col] - heights[row][col-1];
//            minCost = Math.min(upCost,leftCost);
//            minCostTable[row][col] = minCost;
        }else if(row == 0 && col>0 && col<cols-1){
            leftCost = heights[row][col] - heights[row][col-1];
            rightCost = heights[row][col] - heights[row][col+1];
            downCost = heights[row][col] - heights[row+1][col];
//            minCost = Math.min(leftCost,rightCost);
//            minCost = Math.min(minCost,downCost);

        } else if (row == rows-1 && col>0 && col<cols-1) {
            upCost = heights[row][col] - heights[row-1][col];
            leftCost = heights[row][col] - heights[row][col-1];
            rightCost = heights[row][col] - heights[row][col+1];
//            minCost = Math.min(leftCost,rightCost);
//            minCost = Math.min(minCost,upCost);

        }else if(col == 0 && row>0 && row <rows-1){
            upCost = heights[row][col] - heights[row-1][col];
            downCost = heights[row][col] - heights[row+1][col];
            rightCost = heights[row][col] - heights[row][col+1];
//            minCost = Math.min(upCost,downCost);
//            minCost = Math.min(minCost,rightCost);

        }else if(col == cols-1 && row >0 && row< rows-1){
            upCost = heights[row][col] - heights[row-1][col];
            downCost = heights[row][col] - heights[row+1][col];
            leftCost = heights[row][col] - heights[row][col-1];
//            minCost = Math.min(upCost,downCost);
//            minCost = Math.min(leftCost,minCost);

        }else{
            upCost = heights[row][col] - heights[row-1][col];
            downCost = heights[row][col] - heights[row+1][col];
            leftCost = heights[row][col] - heights[row][col-1];
            rightCost = heights[row][col] - heights[row][col+1];

//            minCost = Math.min(upCost,leftCost);
//            minCost = Math.min(minCost,downCost);
//            minCost = Math.min(minCost,rightCost);
        }
        upCost = Math.abs(upCost);
        leftCost = Math.abs(leftCost);
        rightCost = Math.abs(rightCost);
        downCost = Math.abs(downCost);

        if(minCost > upCost){
            minCost = upCost;
            minCostDirect = 1;
        }

        if(minCost > leftCost){
            minCost = leftCost;
            minCostDirect = 2;
        }
        if(minCost > downCost){
            minCost = downCost;
            minCostDirect = 3;
        }
        if(minCost > rightCost){
            minCost = rightCost;
            minCostDirect = 4;
        }

        minCostTable[row][col] = minCost;
        if( minCostDirect == 1){
           return calMinCost(heights, minCostTable, row-1, col, rows, cols);
        }else if(minCostDirect == 2){
            return calMinCost(heights, minCostTable, row, col-1, rows, cols);
        }else if(minCostDirect == 3){
            return calMinCost(heights, minCostTable, row+1, col, rows, cols);
        }else if(minCostDirect ==4){
            return calMinCost(heights, minCostTable, row, col+1, rows, cols);
        }

        return minCostTable;
    }

}
