package map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class list_quchong {
	public static void main(String[] args) {

		testList();

	}

	public static void testList() {

		List<String> list = new ArrayList<String>();

		list.add("1");
		list.add("1");
		list.add("1");
		list.add("5");
		list.add("1");
		list.add("2");
		list.add("1");
		List<String> listTemp = new ArrayList<String>();
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String a = it.next();
			if (listTemp.contains(a)) {
				it.remove();
			} else {
				listTemp.add(a);
			}
		}
		for (String i : list) {
			System.out.println(i);
		}
	}

}
