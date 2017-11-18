package org.xueyao.utils.array;

import java.util.ArrayList;
import java.util.Iterator;

/** 
 * @description 数组工具类
 * @author Yao Xue
 * @date Jul 26, 2017 8:16:39 AM
 */
public class ArrayUtils {
    
    /**
     * @description 遍历任意类型的ArrayList
     * @param list  任意类型的ArrayList
     */
    public static void printArrayList(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }
    }
    
    /**
     * @description 反转任意类型数组
     * @param arr  任意类型的数组
     */
    public static <E> void reverse(E[] arr) {
        for (int start  = 0, end = arr.length-1; start < end; start++, end--) {
            E temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
}
