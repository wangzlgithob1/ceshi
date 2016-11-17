package map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * �Ӽ�������16λ������,���ͳ��ÿ�����ֳ��ֵĸ���
 * @author young
 *
 */
public class CharMapDemo {
    // ͳ�����ֻ����ַ����ֵĴ���
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
//      System.out.println("������һ����������");
//      int temp = sc.nextInt();
//      String str = String.valueOf(temp);
//      TreeMap<Character, Integer> tm = Pross(str);
//      System.out.println(tm);
         
        System.out.println("������һ���ַ�����");
        String str = sc.nextLine();
        TreeMap<Character, Integer> tm = Pross(str);
        System.out.println(tm);
    }
}