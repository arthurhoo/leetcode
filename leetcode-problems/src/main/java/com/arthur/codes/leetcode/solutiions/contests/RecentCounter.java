package com.arthur.codes.leetcode.solutiions.contests;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Arthur Hu
 * @date: 2018/11/4 上午10:06
 * Description:
 */

/**
 * Intuition

 We only care about the most recent calls in the last 3000 ms, so let's use a data structure that keeps only those.

 Algorithm

 Keep a queue of the most recent calls in increasing order of t. When we see a new call with time t, remove all calls that occurred before t - 3000.
 */
public class RecentCounter {


    Queue<Integer> caculator;

    public RecentCounter() {
        caculator = new LinkedList<>();
    }

    public int ping(int t) {

        if(t<1){
            return -1;
        }

        caculator.add(t);
        while(caculator.peek()<(t-3000)){
            caculator.poll();
        }

        return caculator.size();
    }


    public static void main(String[] args){
        RecentCounter recentCounter = new RecentCounter();
        int result = recentCounter.ping(825);

        int result2 = recentCounter.ping(2295);

        int result3 = recentCounter.ping(4131);

        int result4 = recentCounter.ping(5455);

        int result5 = recentCounter.ping(5884);
        int result6 = recentCounter.ping(5975);






        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);





    }

}
