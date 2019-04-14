package Calendar;

import java.util.*;

public class EventList {
	int chunkSize = 5;
	
	Dictionary events = new Hashtable();
	int[] emptys = new int[chunkSize];
	
	public EventList() {
		for( int x = 0; x < chunkSize; x++) {
			emptys[x] = 0;
		}
	}
	
	public int addEvent(Event event) {
		int emptyKey = this.getEmptyKey();
		events.put(emptyKey, event);
		emptys[emptyKey] = 1;
		return emptyKey;
	}
	
	public Event getEvent(int getKey) {
		return (Event) events.get(getKey);
	}
	
	public void deleteEvent(int delKey) {
		events.remove(delKey);
		emptys[delKey] = 0;
	}
	
	private int getEmptyKey() {
		for(int x = 0; x < emptys.length; x++) {
			if (emptys[x] == 0) {
				return x;
			}
		}
		expandEmptys();
		return getEmptyKey();
		
	}
	
	private void expandEmptys() {
		int currentSize = emptys.length;
		int newSize = currentSize + chunkSize;
		
		int[] tempArr = new int[currentSize];
		
		// add all employees into a tempAray
		for ( int x = 0; x < currentSize; x++ ) {
			int holder;
			holder = emptys[x];
			tempArr[x] = holder;
		}
		
		// resize the emptys array
		emptys = null;
		emptys = new int[newSize];
		
		// add temp items into new sized emps
		for (int x = 0; x < currentSize; x++) {
			emptys[x] = tempArr[x];
		}
	}
	
	public void checkEvents() {
		System.out.println("-----------------------------------------------------");
		for (int x = 0; x < emptys.length; x++) {
			System.out.println("empty? " + emptys[x]);
			System.out.println("value? " + events.get(x));
			System.out.println();
		}
		System.out.println("-----------------------------------------------------");
	}
}
