package map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * 从键盘输入16位长整数,编程统计每个数字出现的个数
 * @author young
 *
 */
public class CharMapDemo {
    // 统计数字或者字符出现的次数
    public static TreeMap<Character, Integer> Pross(String str) {
        char[] charArray = str.toCharArray();
 
        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
 
        for (int x = 0; x < charArray.length; x++) {
            if (!tm.containsKey(charArray[x])) {
                tm.put(charArray[x], 1);
            } else {
                int count = tm.get(charArray[x]) + 1;
                tm.put(charArray[x], count);
            }
        }
        return tm;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//      System.out.println("请输入一个长整数：");
//      int temp = sc.nextInt();
//      String str = String.valueOf(temp);
//      TreeMap<Character, Integer> tm = Pross(str);
//      System.out.println(tm);
         
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
        TreeMap<Character, Integer> tm = Pross(str);
        System.out.println(tm);
    }
}