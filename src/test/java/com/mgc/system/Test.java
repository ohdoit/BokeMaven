package com.mgc.system;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args)  
    {  
    	Test ins = new Test();  
        int size = 100000;  
        // try catch 放在循环外面与里面的区别
        ins.method1(size);  
        ins.method2(size);  
        ins.method3(size);  
        
    }  
    
    public void method1(int size)  
    {  
        long start = System.currentTimeMillis();  
        ArrayList<String> al = new ArrayList<String>();  
        String str = null;  
        try  
        {  
            for (int i = 0; i < size; i++)  
            {  
                str = "str" + i;  
                al.add(str);  
            }  
        }  
        catch (Exception e)  
        {  
        }  
        System.out.println("method1 total: " + (System.currentTimeMillis() - start));  
    }  
    public void method2(int size)  
    {  
        long start = System.currentTimeMillis();  
        ArrayList<String> al = new ArrayList<String>();  
        String str = null;  
        for (int i = 0; i < size; i++)  
        {  
            try  
            {  
                str = "str" + i;  
                al.add(str);  
            }  
            catch (Exception e)  
            {  
            }  
        }  
        System.out.println("method2 total: " + (System.currentTimeMillis() - start));  
    }  
    public void method3(int size)  
    {  
        long start = System.currentTimeMillis();  
        ArrayList<String> al = new ArrayList<String>();  
        String str = null;  
        for (int i = 0; i < size; i++)  
        {  
            str = "str" + i;  
            al.add(str);  
        }  
        System.out.println("method3 total: " + (System.currentTimeMillis() - start));  
    }  
}
