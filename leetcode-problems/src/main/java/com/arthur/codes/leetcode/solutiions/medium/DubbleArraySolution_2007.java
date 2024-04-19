package com.arthur.codes.leetcode.solutiions.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 *
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：changed = [1,3,4,2,6,8]
 * 输出：[1,3,4]
 * 解释：一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * 示例 2：
 *
 * 输入：changed = [6,3,0,1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * 示例 3：
 *
 * 输入：changed = [1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 *
 *
 * 提示：
 *
 * 1 <= changed.length <= 105
 * 0 <= changed[i] <= 105
 * @author: huhao
 * @create: 2024/4/18
 */
public class DubbleArraySolution_2007 {

    public int[] findOriginalArray(int[] changed) {
        if(null == changed || changed.length==0){
            return changed;
        }
        // 1.双倍数组的length一定是偶数
        // 2. 数组原始数字和2倍数字一定是成对存在的
        // 3. 存在奇数，则奇数一定属于original
        int total = changed.length;
        if(total % 2 != 0){
            return new int[0];
        }
        List<Integer> temple = new ArrayList<>();
        List<Integer> changedList = IntStream.of(changed).boxed().sorted().collect(Collectors.toList());
        changed = changedList.stream().mapToInt(Integer::intValue).toArray();
        for(int i=0;i< total; i++){
            if(changed[i] == -1){
                continue;
            }
            boolean isMatch = false;
            int first = changed[i];
            for(int j=i+1; j<total;j++){
                if(changed[j] == -1){
                    continue;
                }
                if(first == 2*changed[j] || changed[j] == 2*first){
                    isMatch = true;
                    temple.add(Math.min(first,changed[j]));
                    changed[i] = -1;
                    changed[j] = -1;
                    break;
                }
            }
            if(!isMatch){
                return new int[0];
            }

        }
        if(temple.size() != (total/2)){
            return new int[0];
        }else{
            return temple.stream().mapToInt(Integer::intValue).toArray();
        }

    }

    public int[] findOriginalArray_2(int[] changed) {
        if(null == changed || changed.length==0){
            return changed;
        }
        // 1.双倍数组的length一定是偶数
        // 2. 数组原始数字和2倍数字一定是成对存在的
        // 3. 存在奇数，则奇数一定属于original
        // 4。利用hash额外存储，降低时间复杂度
        int total = changed.length;
        if(total % 2 != 0){
            return new int[0];
        }
        Arrays.sort(changed);
        Map<Integer,Integer> diction = new HashMap<>();
        int half = total/2;
        for(int i=0; i<total;i++){
            diction.merge(changed[i],1,(a,b) -> Integer.sum(a,b));
        }
        int[] result = new int[half];
        int i=0;
        for(int n:changed){
            if(diction.get(n) == 0){
                continue;
            }
             diction.replace(n, diction.get(n)-1);
            if(diction.getOrDefault(n*2,0)==0){
                return new int[0];
            }
            diction.put(n*2,diction.get(n*2)-1);
            result[i] = n;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        DubbleArraySolution_2007 dubbleArraySolution2007 = new DubbleArraySolution_2007();
        int[] changed = new int[]{4,4,16,20,8,8,2,10};
        int[] original = dubbleArraySolution2007.findOriginalArray(changed);
        Arrays.stream(original).forEach(value -> System.out.printf("%d,", value));

    }
}
