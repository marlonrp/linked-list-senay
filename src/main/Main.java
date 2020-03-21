package main;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Person p1 = new Person("Marlon", 26);
		Person p2 = new Person("Gabi", 25);
		Person p3 = new Person("Elison", 22);
		Person p4 = new Person("Ray", 23);
		Person p5 = new Person("Lu", 50);
		LinkedList<Person> list = new LinkedList<Person>();

		list.add(p1);
		list.add(p2);
		list.add(p3);

		System.out.println(list.isEmpty()); // OK
		System.out.println(list); // OK

		list.add(2, p4);
		System.out.println(list); // OK
		
		System.out.println(list.contains(p2)); // OK true
		
		System.out.println(list.get(2)); // OK
		
		list.remove(3);
		System.out.println(list); // OK
		
		list.removeFirst(p2);
		System.out.println(list); // OK
		
		list.set(0, p3); 
		System.out.println(list); // OK
		
		System.out.println(list.contains(p2)); // OK false
		System.out.println(list.indexOf(p3)); // OK 0
		System.out.println(list.indexOf(p1)); // OK -1

		System.out.println(list.size()); // OK 2
		
		list.add(p1);
		list.add(1, p5);
		System.out.println(list); // OK
		
		for (Object x : list.toArray()) {
			System.out.println(x);
		} // OK
		
		list.clear();
		System.out.println(list); // OK
		
	}
}
