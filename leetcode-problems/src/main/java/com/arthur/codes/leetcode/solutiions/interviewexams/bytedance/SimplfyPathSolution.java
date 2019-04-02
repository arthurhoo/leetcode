package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

import java.util.Stack;

/**
 * @author: Arthur Hu
 * @date: 2019/3/19 下午10:44
 * Description:
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。
 *
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1013/
 */
public class SimplfyPathSolution {

    /**
     * 路径设计父目录和子目录，可以用栈结构
     */

    public String simplifyPath(String path) {
        if(null == path || path.isEmpty()){
            return null;
        }


        String[] array = path.split("/");

        Stack<String> pathStack = new Stack<>();

        for(String str:array){
            if(str != null && !str.isEmpty()){
                if(str.equals(".")){
                    continue;
                }else if(str.equals("..")){
                    if(!pathStack.empty()){
                        pathStack.pop();
                    }
                    continue;
                }else{
                    pathStack.push(str.trim());
                }
            }
        }

        array = new String[pathStack.size()];

        for(int i = array.length-1; i>=0; i--){
            array[i] = pathStack.pop();
        }


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("/");

        for(int i =0 ;i< array.length;i++){
            stringBuffer.append(array[i]).append("/");
        }

        String result = stringBuffer.toString().trim();

        if(result.length() > 1){
            result = result.substring(0,result.length()-1);
        }

        return result;



    }


    public static void main(String[] args){
        String str = "/../";

        SimplfyPathSolution simplfyPathSolution = new SimplfyPathSolution();

        System.out.println(simplfyPathSolution.simplifyPath(str));
    }
}
