package com.arthur.codes.leetcode.solutiions.medium;

import com.arthur.codes.leetcode.solutiions.UnionFindUtil;

/**
 * @author: huhao
 * @create: 2024/4/21
 */
public class ProvincesSolution_547 {

    public int findCircleNum(int[][] isConnected) {
        if (null == isConnected || isConnected.length == 0) {
            return 0;
        }

        int[] root = new int[isConnected[0].length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        for (int i = 0; i < root.length; i++) {
            for (int j = i + 1; j < root.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, root);
                }
            }
        }

        int provinces = 0;
        for (int i = 0; i < root.length; i++) {
            if (root[i] == i) {
                provinces++;
            }
        }


        return provinces;

    }

    public void union(int x, int y, int[] root) {
        int rootX = find(x, root);
        int rootY = find(y, root);
        if (rootX != rootY) {
            root[rootX] = rootY;

        }

    }

    public int find(int x, int[] root) {
        if (x == root[x]) {
            return x;
        } else {
            return find(root[x], root);
        }
    }

    public int findCircleNum_2(int[][] isConnected){
        if (null == isConnected || isConnected.length == 0) {
            return 0;
        }
        int length = isConnected.length;;
        UnionFindUtil unionFindUtil = new UnionFindUtil(length);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFindUtil.union(i,j);
                }
            }
        }

        return unionFindUtil.getCount();
    }

    public static void main(String[] args) {
        ProvincesSolution_547 provincesSolution547 = new ProvincesSolution_547();
//        int[][] input = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
//        int[][] input = new int[][]{{1,1,1},{1,1,1},{1,1,1}};

        int[][] input = new int[][]{
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };

        int result = provincesSolution547.findCircleNum(input);
        System.out.println(result);
        System.out.println(provincesSolution547.findCircleNum_2(input));
    }
}
