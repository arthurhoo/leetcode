package com.arthur.codes.leetcode.solutiions;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Arthur Hu
 * @date: 2017/12/7
 *
 * Description:
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 */
public class DailyTemperaturesSolution {

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length<1 || temperatures.length > 30000){
            throw new IllegalArgumentException("the length of temperatures array is out of range");
        }

        int[] result = new int[temperatures.length];

        for(int i=0; i<temperatures.length;i++){
            if(temperatures[i]<30 || temperatures[i] > 100){
                result[i]=0;
                continue;
            }
            int days = 0;
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[j] > temperatures[i]){
                    days = j-i;
                }else if(j<(temperatures.length-1)){
                    continue;
                }
                result[i] = days;
                break;
            }
        }

        return result;
    }


    public static void main(String[] args){
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperaturesSolution dailyTemperaturesSolution = new DailyTemperaturesSolution();

        int[] result = dailyTemperaturesSolution.dailyTemperatures(temperatures);

        for (int i:result) {
            System.out.println(i);
        }

    }
}
