package com.lrl.req;

import com.lrl.constant.RequestConstant;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @desc 策略管理
 * @author lrli
 * @date  2019/10/24
 * @return
 */
public class ManageRequest {
    public static void excuteStrategy(String type, String url, Map<String,String> param){

        String class_path= RequestConstant.requestMethods.get(type);
        try {
            //反射调用
            Class clazz=Class.forName(class_path);
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.getName().equals("request")) {
                    declaredMethod.invoke(clazz.newInstance(),url,param);
                }
            }
//            Method method =clazz.getDeclaredMethod("request");
//            method.invoke(clazz.newInstance(),url,param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
