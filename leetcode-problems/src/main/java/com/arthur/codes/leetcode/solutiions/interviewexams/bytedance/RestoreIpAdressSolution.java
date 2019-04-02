package com.arthur.codes.leetcode.solutiions.interviewexams.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Arthur Hu
 * @date: 2019/3/19 下午11:21
 * Description:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1044/
 *
 */
public class RestoreIpAdressSolution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();


        if(null == s || s.isEmpty() || s.length() < 4 || s.length() > 12){
            return result;
        }


        getIpAddress(s,0,"", result);

        return result;

    }



    public void getIpAddress(String remain, int position, String ip, List<String> result){

        if(remain.length() == 0){
            return;
        }

        //校验最后一段IP
        if(position == 3){

            if(isValid(remain)){
                ip += remain;

                result.add(ip);
                return;
            }else {
                return;
            }

        }else{

            if(remain.length() >= 3 && !remain.startsWith("0")){
                String sub = remain.substring(0,3);

                if(isValid(sub)){
                    getIpAddress(remain.substring(3),position+1,ip+sub+".",result);

                }

            }

            if(remain.length() >= 2 && !remain.startsWith("0")){
                String sub = remain.substring(0,2);

                if(isValid(sub)){
                    getIpAddress(remain.substring(2),position+1,ip+sub+".",result);

                }

            }

            if(remain.length() >= 1){
                String sub = remain.substring(0,1);

                if(isValid(sub)){
                    getIpAddress(remain.substring(1),position+1,ip+sub+".",result);

                }

            }



        }


    }


    private boolean isValid(String number){
        if(null == number || number.isEmpty() || number.length()>3){
            return false;
        }


        if("0".equals(number)){
            return true;
        }else if(number.startsWith("0")){
            return false;
        }

        int value = Integer.parseInt(number);

        if(value > 0 && value<=255){
            return true;
        }

        return false;
    }


    public static void main(String[] args){
        RestoreIpAdressSolution restoreIpAdressSolution = new RestoreIpAdressSolution();

        String a = "0000";

        List<String> result = restoreIpAdressSolution.restoreIpAddresses(a);

        for(String str:result){
            System.out.println(str);
        }
    }
}
