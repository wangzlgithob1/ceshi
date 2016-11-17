package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<String, Employee>();
		staff.put("1", new Employee("d:\\a"));
		staff.put("2", new Employee("d:\\b"));
		staff.put("3", new Employee("d:\\c"));
		staff.put("4", new Employee("d:\\s"));
		System.out.println(staff);
		
		staff.remove("567-24-2546");//ɾ��
		System.out.println(staff);
		
		staff.put("456-62-5527", new Employee("Bob"));//�滻
		System.out.println(staff);
		
		System.out.println(staff.get("157-62-7935"));//��ѯ
		
		//ȡ��map�����е�key��value
		for(Map.Entry<String, Employee> entry : staff.entrySet()) {
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key=" + key + ", value=" + value + "");
		}
		
		//ȡ��map�����е�key
		Set<String> keys = staff.keySet();
		for(String key : keys) {
			System.out.println(key);
		}
		
		//ȡ��map�����е�value
		Collection<Employee> values = staff.values();
		for(Employee value : values) {
			System.out.println(value);
		}
	}
}

class Employee {
	public Employee(String n) {
		name = n;
		salary = 0;
	}
	
	public String toString() {
		return "[name=" + name + ", salary=" + salary + "]";
	}
	
	private String name;
	private double salary;
}
