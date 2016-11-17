package wenzi_sousuo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class maptest1 {
	static List<String[]> listzong = new ArrayList<String[]>();

	public static void main(String[] args) {
		jiansuo();
	}

	public static void jiansuo() {
		Map<String, List<String>> staff = new HashMap<String, List<String>>();

		List<String> listquchong = new ArrayList<String>();
		List<String[]> ll = readfile("D:\\桌面文件\\兼职国外展览\\安安");
		//将获得所有文件数据放入去重集合中
		for (String[] arr : ll) {
			listquchong.add(arr[0]);
		}

		//对去重集合进行文件名重复数据的去重
		List<String> listTemp = new ArrayList<String>();
		Iterator<String> it = listquchong.iterator();
		while (it.hasNext()) {
			String a = it.next();
			if (listTemp.contains(a)) {
				it.remove();
			} else {
				listTemp.add(a);
			}
		}
		int m = 1;
		//遍历去重后的集合的文件名
		for (String i : listquchong) {
			List<String> bb = new ArrayList<String>();
			//遍历所有文件集合，取出文件名相同的文件的所有路径，并放入一个集合中
			for (String[] arr : ll) {
				if (i.equals(arr[0])) {
					bb.add(arr[1]);
				}
			}

			for (String c : bb) {
				System.out.println(c + "----" + m);
			}
			m++;
			//将文件名当做key，将文件名相同的文件路径放入集合，当做values，放入map中
			staff.put(i, bb);
		}

		//放入map后，即创建索引完成，调用sousuo方法，提供控制台输入，即初级版搜索服务。
		sousuo(staff);
	}

	//遍历出想要查找的文件夹下的所有文件，并放入静态集合
	public static List<String[]> readfile(String path) {
		try {

			File file = new File(path);
			if (!file.isDirectory()) {
				String filepath = file.getPath();
				String filename = file.getName();

				String[] arr = new String[] { filename, filepath };
				listzong.add(arr);
			} else if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					try {
						readfile(path + "\\" + filelist[i]);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return listzong;
	}

	public static void sousuo(Map<String, List<String>> staff) {

		System.out.println("输入数据：");
		Scanner scan = new Scanner(System.in);
		String read =null;
		//反复输入，实现一次索引，多次查询
		while(true){
			
			 read = scan.nextLine();
			 List<String> lis = staff.get(read);
			 for (String li : lis) {
				 System.out.println(li);
				 
			 }
		}

	}

}
