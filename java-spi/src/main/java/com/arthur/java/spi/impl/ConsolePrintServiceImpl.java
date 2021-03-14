package com.arthur.java.spi.impl;

import com.arthur.java.spi.PrintService;

/**
 * @author: Arthur Hu
 * @date: 2021/3/14 6:55 下午
 * Description:
 */
public class ConsolePrintServiceImpl implements PrintService {
    @Override
    public void printInfo() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
