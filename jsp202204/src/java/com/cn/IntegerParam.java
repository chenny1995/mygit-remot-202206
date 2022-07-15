package com.cn;
public class IntegerParam{
    public IntegerParam(String id){
        output(id);
    }

    public IntegerParam(String id,boolean flag){
        String zipCode = convertIdToZipCode(id);
        output(id);
    }
    private static String convertIdToZipCode(String id){
        return id+"000";
    }
    private static void output(String id){
        System.out.println(id);
    }
}

class MyFactory{
    public static IntegerParam getInstance(String id,boolean flag){
        if(flag){
            return new IntegerParam(id);
        } else {
            return new IntegerParam(id,flag);
        }
    }
}
