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
		List<String[]> ll = readfile("D:\\�����ļ�\\��ְ����չ��\\����");
		//����������ļ����ݷ���ȥ�ؼ�����
		for (String[] arr : ll) {
			listquchong.add(arr[0]);
		}

		//��ȥ�ؼ��Ͻ����ļ����ظ����ݵ�ȥ��
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
		//����ȥ�غ�ļ��ϵ��ļ���
		for (String i : listquchong) {
			List<String> bb = new ArrayList<String>();
			//���������ļ����ϣ�ȡ���ļ�����ͬ���ļ�������·����������һ��������
			for (String[] arr : ll) {
				if (i.equals(arr[0])) {
					bb.add(arr[1]);
				}
			}

			for (String c : bb) {
				System.out.println(c + "----" + m);
			}
			m++;
			//���ļ�������key�����ļ�����ͬ���ļ�·�����뼯�ϣ�����values������map��
			staff.put(i, bb);
		}

		//����map�󣬼�����������ɣ�����sousuo�������ṩ����̨���룬����������������
		sousuo(staff);
	}

	//��������Ҫ���ҵ��ļ����µ������ļ��������뾲̬����
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

		System.out.println("�������ݣ�");
		Scanner scan = new Scanner(System.in);
		String read =null;
		//�������룬ʵ��һ����������β�ѯ
		while(true){
			
			 read = scan.nextLine();
			 List<String> lis = staff.get(read);
			 for (String li : lis) {
				 System.out.println(li);
				 
			 }
		}

	}

}
