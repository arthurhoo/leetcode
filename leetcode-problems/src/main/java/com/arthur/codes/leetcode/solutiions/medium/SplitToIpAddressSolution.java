package com.arthur.codes.leetcode.solutiions.medium;

import java.util.regex.Pattern;

/**
 * @author: Arthur Hu
 * @date: 2018/4/25 下午8:50
 * Description:
 */
public class SplitToIpAddressSolution {

    private String regrex = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";



    public static void main(String[] args){
        String example = "134255255135";
        SplitToIpAddressSolution splitToIpAddressSolution = new SplitToIpAddressSolution();
        int count = splitToIpAddressSolution.countAddress(example);
        System.out.printf("ip count1 = "+count);

//        String example2 = "1921683089";
//        count = splitToIpAddressSolution.countAddress(example2);
//        System.out.printf("ip count2 = "+count);

    }


    public int countAddress(String str){
        int count = 0;

        if(str==null || str.isEmpty()){
            return count;
        }

//        for(int m = 0;m<str.length()-4;m++){
            for(int i=1;i<4;i++){
                for(int j=i+1;j<=i+3;j++){
                    for(int k=j+1;k<=k+3 && k<10;k++){
                        StringBuffer ip = new StringBuffer();
                        ip.append(str.substring(0,i)).append(".").append(str.substring(i,j)).append(".").append(str.substring(j,k)).append(".").append(str.substring(k));
                        System.out.println(ip.toString());

                        if(isIPNoRegrx(ip.toString())){
                            count++;
                            System.out.println("ip: "+ip.toString());
                        }

                    }
                }
            }

//        }

        return count;
    }


    public boolean isIp(String str){
        boolean result = false;

        result = Pattern.matches(regrex,str);

        return result;
    }

    public boolean isIPNoRegrx(String str){
        boolean result = false;

        String[] strings = str.split("\\.");

        if(strings.length < 4){
            return result;
        }

        try{
            for(int i=0;i<strings.length;i++){

                if(strings[i].startsWith("0") && strings[i].length()>1){
                    return false;
                }

                int temple = Integer.parseInt(strings[i]);
                if(temple>=0 && temple<=255){
                    result = true;
                }else{
                    result = false;
                    break;
                }
            }

        }catch (NumberFormatException e){
            e.printStackTrace();
            result = false;
        }

        return result;
    }

    public int convertStrToInt(String number){
        int result = -1;

        return result;
    }

}
