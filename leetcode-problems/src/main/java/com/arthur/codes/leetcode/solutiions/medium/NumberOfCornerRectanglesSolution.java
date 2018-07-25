package com.arthur.codes.leetcode.solutiions.medium;

/**
 * @author: Arthur Hu
 * @date: 2018/7/5 下午4:12
 * Description:
 * https://leetcode.com/problems/number-of-corner-rectangles/description/
 */


/**
 * Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

 A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.



 Example 1:

 Input: grid =
 [[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
 Output: 1
 Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].


 Example 2:

 Input: grid =
 [[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
 Output: 9
 Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.


 Example 3:

 Input: grid =
 [[1, 1, 1, 1]]
 Output: 0
 Explanation: Rectangles must have four distinct corners.


 Note:

 The number of rows and columns of grid will each be in the range [1, 200].
 Each grid[i][j] will be either 0 or 1.
 The number of 1s in the grid will be at most 6000.
 */
public class NumberOfCornerRectanglesSolution {


    /**
     * Use violence traversal to find the corner rectangle
     * @param grid
     * @return
     */
    public int countCornerRectangles(int[][] grid) {

        int result = 0;

        // check if the grid is valid
        // If there may be a corner rectangle, the grid should have at least 2 rows and 2 columns
        if(grid == null || grid[0].length < 2 || grid.length <2){
            return 0;
        }

        for( int row = 0; row < grid.length; row++){
            for(int cols=0; cols < grid[0].length; cols++){
                if(grid[row][cols] == 1){
                    int colsCursor = 1;
                    while (colsCursor < (grid[0].length - cols)){
                        if(grid[row][cols+colsCursor] == 1){
                            int rowCursor = 1;
                            while (rowCursor < (grid.length-row)){
                                if(grid[row+rowCursor][cols] == 1){
                                    if(grid[row+rowCursor][cols+colsCursor] == 1){
                                        result += 1;
                                    }
                                }
                                rowCursor++;
                            }

                        }
                        colsCursor++;
                    }
                }
            }
        }


        return result;
    }






    public static void main(String[] args){
        NumberOfCornerRectanglesSolution numberOfCornerRectanglesSolution = new NumberOfCornerRectanglesSolution();

        int[][] grid1 = new int[][]{{0,1,0},{1,0,1},{1,0,1},{0,1,0}};

        int result1 = numberOfCornerRectanglesSolution.countCornerRectangles(grid1);
        System.out.println(result1);


    }


}
