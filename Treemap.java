import java.util.*;  
public class Treemap {

	public static void main(String[] args) {
		//Create a tree map with employee ID and name
		TreeMap<Integer,String> map=new TreeMap<Integer,String>(); 
			map.put(100,"Zafar");    
			map.put(102,"Ravi");    
			map.put(101,"Divya");    
			map.put(103,"Abi");   
			//Print tree map with sorted by key
		    System.out.println("Treemap sorted by Employee ID: "+map);
		    //Print tree map with sorted by value
		    System.out.println("Treemap sorted by Name: "+entriesSortedByValues(map));
	}
	
	//Sort using sortedset with Map.Entry
	static <K,V extends Comparable<? super V>>
	SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
	    SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
	        new Comparator<Map.Entry<K,V>>() {
	            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
	                int res = e1.getValue().compareTo(e2.getValue());
	                return res != 0 ? res : 1;
	            }
	        }
	    );
	    sortedEntries.addAll(map.entrySet());
	    return sortedEntries;
	}
}
