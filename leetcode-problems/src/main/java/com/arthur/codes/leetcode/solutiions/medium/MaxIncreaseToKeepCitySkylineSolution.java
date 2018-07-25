package com.arthur.codes.leetcode.solutiions.medium;

/**
 * Solution of problem:
 *
 * 807. Max Increase to Keep City Skyline
 *
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
 *
 * @author: Arthur Hu
 * @date: 2018/5/16 下午1:14
 * Description:
 */
public class MaxIncreaseToKeepCitySkylineSolution {

    public static void main(String[] args){

        MaxIncreaseToKeepCitySkylineSolution maxIncreaseToKeepCitySkylineSolution = new MaxIncreaseToKeepCitySkylineSolution();

        int[][] grid = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

        int result = maxIncreaseToKeepCitySkylineSolution.maxIncreaseKeepingSkyline(grid);

        System.out.println(result);

    }


    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int increased = 0;


        if(null == grid){
            return increased;
        }

        if(grid.length < 1 || grid.length>50 || grid[0].length != grid.length){
            return 0;
        }

        int[] leftSkyLine = findSkylineForLeft(grid);

        int[] topSkyLine = findSkylineForTop(grid);

        int[][] newGrid = new int[grid.length][grid[0].length];


        for(int i=0; i<grid.length;i++){
            int marRow = leftSkyLine[i];

            for(int j=0; j<grid[0].length; j++){
                int marCol = topSkyLine[j];
                newGrid[i][j] = min(marRow,marCol);
                increased += (newGrid[i][j]-grid[i][j]);
            }
        }
        return increased;

    }

    private int min(int a, int b){

        if(a < b){
            return a;
        }else if(a > b){
            return b;
        }else{
            return a;
        }
    }


    private int[] findSkylineForTop(int[][] grid){

        if(null == grid){
            return null;
        }

        int[] result = new int[grid[0].length];

        for(int colIndex=0; colIndex<grid[0].length;colIndex++){

            int[] col = new int[grid[0].length];

            for(int i=0;i<grid.length;i++){
                col[i] = grid[i][colIndex];
            }

            int max = 0;
            for(int i = 0; i<col.length;i++){
                if(col[i] > max){
                    max = col[i];
                }
            }

            result[colIndex] = max;
        }


        return result;

    }



    private int[] findSkylineForLeft(int[][] grid){
        if(null == grid){
            return null;
        }

        int[] result = new int[grid[0].length];

        for(int rowIndex=0; rowIndex<grid.length;rowIndex++){
            int[] row = grid[rowIndex];

            int max = 0;
            for(int i = 0; i<row.length;i++){
                if(row[i] > max){
                    max = row[i];
                }
            }

            result[rowIndex] = max;
        }


        return result;
    }


    private boolean compareArray(int[] o, int[] n){
        if(null == o || null == n){
            return true;
        }
        if(o.length != n.length){
            return false;
        }

        for(int i=0;i<o.length;i++){
            if(o[i] != n[i]){
                return false;
            }
        }

        return true;


    }
}
