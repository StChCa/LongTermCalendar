package Calendar;

public class Test {

	public static void main(String[] args) {
    	//testEmpStuff();
    	testEventStuff();
	}
	
	// change chunk size in Events to 5 and run this code.
	public static void testEventStuff() {
		Events events = new Events();
		
		Event a = new Event();
		a.setTitle("This is a title");
		Event b = new Event();
		Event c = new Event();
		Event d = new Event();
		Event e = new Event();
		Event f = new Event();
		
		int aKey = events.addEvent(a);
		events.addEvent(b);
		events.addEvent(c);
		events.addEvent(d);
		events.addEvent(e);
		events.addEvent(f);
		
		System.out.println(events.getEvent(aKey).title);
		
		events.deleteEvent(aKey);
		
		Event z = new Event();
		
		events.addEvent(z);
		
		events.checkEvents();
	}
	
	public static void testEmpStuff() {
    	
		Employees emps = new Employees();
    	
    	Employee a1 = new Employee(1, "Stephen");
    	Employee a2 = new Employee(2, "b");
    	Employee a3 = new Employee(3, "c");
    	Employee a4 = new Employee(4, "d");
    	Employee a5 = new Employee(5, "e");
    	Employee a6 = new Employee(6, "f");
    	Employee a7 = new Employee(7, "g");
    	Employee a8 = new Employee(8, "h");
    	Employee a9 = new Employee(9, "i");
    	Employee a10 = new Employee(10, "j");
    	Employee a11 = new Employee(11, "k");
    	
    	emps.add(a1);
    	emps.add(a2);
    	emps.add(a3);
    	emps.add(a4);
    	emps.add(a5);
    	emps.add(a6);
    	emps.add(a7);
    	emps.add(a8);
    	emps.add(a9);
    	emps.add(a10);
    	emps.add(a11);
    	
    	System.out.println(emps.toString());
	}

}
