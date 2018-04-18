package com.bp.Util;

import java.util.concurrent.ExecutionException;

public class SignatureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(System.currentTimeMillis());
        for(int i=0 ;i<10;i++){
            System.out.println(SignatureUtil.getSignature("www.baidu.com/", "nonicestr", "1524067007123"));
            Thread.sleep(2000);
        }
    }

}
