package com.arthur.java.spi;

import java.util.ServiceLoader;

/**
 * @author: Arthur Hu
 * @date: 2021/3/14 7:01 下午
 * Description:
 */
public class SpiTestApplication {
    public static void main(String[] args) {
        ServiceLoader<PrintService> serviceServiceLoaders = ServiceLoader.load(PrintService.class);

        for(PrintService printService:serviceServiceLoaders){
            printService.printInfo();
        }
    }
}
