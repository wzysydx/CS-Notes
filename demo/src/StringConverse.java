import java.util.Collection;
import java.util.Collections;

/**
 * 类注释
 *
 * @Auther: 王中一
 * @Date: 2021/03/12/23:43
 * @Description:
 */
public class StringConverse {
    public static void main(String[] args) {
        String str = "";
        System.out.println(reverseString(str));
        System.out.println(reverseStringByStringBuilderApi(str));
        System.out.println(reverseStringByRecursion(str));
    }

    /**
    * @Description: 自己实现
    * @Param:
    * @return:
    * @Author: 王中一
    * @Date:
    */
    public static String reverseString(String str){
        if(str != null && str.length() > 0){
            int len = str.length();
            char[] chars = new char[len];
            for (int i = len-1; i >= 0; i--) {
                chars[len -1 - i] = str.charAt(i);
            }
            return new String(chars);
        }
        return str;
    }

    /**
    * @Description: StringBuilder
    * @Param:
    * @return:
    * @Author: 王中一
    * @Date:
    */
    public static String reverseStringByStringBuilderApi(String str){
        if (str != null && !str.isEmpty()){
            return new StringBuilder(str).reverse().toString();
        }

        return str;
    }


    /**
    * @Description: 递推
    * @Param:
    * @return:
    * @Author: 王中一
    * @Date:
    */
    public static String reverseStringByRecursion(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverseStringByRecursion(str.substring(1)) + str.charAt(0);

    }



}
