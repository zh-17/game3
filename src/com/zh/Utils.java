package com.zh;

/**
 * @description:
 * @author: zhangHang
 * @date: Created in 2020/4/27 10:31
 * @version: 1.0
 * @modified By:
 */
public class Utils {
        private static int min=0;
        private static int max=2;
        //产生随机数
        public static int randomMonsterChop(){
            return (int)(Math.random()*(max-min)+min);
        }
}
