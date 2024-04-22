package com.arthur.codes.leetcode.solutiions;

import java.util.Arrays;

/**
 * @author: huhao
 * @create: 2024/4/21
 */
public class UnionFindUtil {
    int[] parent;
    int[] rank;
    int n;
    int count;

    public UnionFindUtil(int n){
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        Arrays.fill(rank,1);
        for(int index=0;index<n;index++){
            parent[index] = index;
        }
        this.count = n; // 计算有多少个连通分量
    }

    // 查找根节点
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return find(parent[x]);
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return false;
        }
        if(rank[rootX] < rank[rootY]){
            rootX = rootX ^ rootY;
            rootY = rootY ^ rootX;
            rootX = rootX ^ rootY;
        }
        parent[rootY]  = rootX; //按秩合并
        rank[rootX] += rank[rootY];
        --count; // 待合并的元素减一，独立根减一
        return true;
    }

    public boolean isConnected(int x, int y){
        x = find(x);
        y = find(y);
        return x == y; //根节点相同则连通
    }

    public int getCount() {
        return count;
    }
}
