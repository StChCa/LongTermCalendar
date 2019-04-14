package Calendar;

// TODO make this an iterator so i can use foreach loop
public class EmployeeList {

	int numberOfEmployees = 0;
	Employee[] emps = new Employee[10];

	public void add(Employee addEmp) {
		if( (numberOfEmployees % 10) >= 9 ) {
			this.expand();
		}
		
		emps[numberOfEmployees] = addEmp;
		numberOfEmployees ++;
	}
	
	public void expand() {
		int currentSize = emps.length;
		int newSize = currentSize + 10;
		
		Employee[] tempArr = new Employee[currentSize];
		
		// add all employees into a tempAray
		for ( int x = 0; x < currentSize; x++ ) {
			Employee holder;
			holder = emps[x];
			tempArr[x] = holder;
		}
		
		// resize the emps array
		emps = null;
		emps = new Employee[newSize];
		
		// add temp items into new sized emps
		for (int x = 0; x < currentSize; x++) {
			emps[x] = tempArr[x];
		}
	}
	
	public String toString() {
		String retString = "Employees: ";
		
		for ( int x = 0; x < numberOfEmployees; x++ ) {
			retString += emps[x].getName() + " ";
		}
		
		return retString;
	}
	
	public String toCsv(){
		String rString = "";
		
		for (int x=0; x<numberOfEmployees; x++){
			rString += emps[x].getCsvFormat();
			rString += "\n";
			System.out.println(rString);
		}
		System.out.println(rString);
		return rString;
	}
}
