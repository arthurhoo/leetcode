package com.arthur.codes.leetcode.solutiions.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * @author: huhao
 * @create: 2024/4/19
 */
public class YanghuiTriangleSolution_118 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows <1 || numRows>30){
            return null;
        }
        List<List<Integer>> yanghuiTriangle = new ArrayList<>();
        for(int i=0;i < numRows;i++){
            List<Integer> row = new ArrayList<>();
            if(i == 0){
                row.add(1);
            }else {
                ArrayList<Integer> lastRow = (ArrayList<Integer>) yanghuiTriangle.get(i-1);
                row.add(1);
                for(int j = 0; j< lastRow.size()-1;j++){
                    row.add(j+1, lastRow.get(j)+lastRow.get(j+1));
                }
                row.add(1);
            }
            yanghuiTriangle.add(i,row);
        }
        return yanghuiTriangle;
    }

    public static void main(String[] args) {
        int rows = 5;
        YanghuiTriangleSolution_118 yanghuiTriangleSolution118 = new YanghuiTriangleSolution_118();
        List<List<Integer>> yanghuiTriangle = yanghuiTriangleSolution118.generate(5);
        yanghuiTriangle.stream().forEach(itemArray -> {
            itemArray.stream().forEach(value->System.out.printf("%d,",value));
            System.out.println();

        });
    }
}
