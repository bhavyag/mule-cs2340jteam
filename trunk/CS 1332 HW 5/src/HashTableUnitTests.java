import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class HashTableUnitTests<K,V>{
	@Test
	public void testPut(){
		HashTable table = new HashTable();
		table.put(10,0);
		table.put(15,1);
		MapEntry[] arr = table.getTable();
		assertEquals(arr[10].getValue(),0);
		assertEquals(arr[4].getValue(),1);
	}
	
	@Test
	public void testLinearProbe(){
		HashTable table = new HashTable();
		table.put(9,0);
		table.put(20,1);
		table.put(10,2);
		MapEntry[] arr = table.getTable();
		assertEquals(arr[9].getValue(),0);
		assertEquals(arr[10].getValue(),1);
		assertEquals(arr[0].getValue(),2);
	}
	
	@Test
	public void testResize(){
		HashTable table = new HashTable();
		for(int i=0;i<7;i++){
			table.put(i, i*3);
		}
		assertEquals(table.getTable().length,11);
		table.put(6654321, 558);
		assertEquals(table.getTable().length,23);
	}
	
	@Test
	public void testChaining(){
		HashTable table = new HashTable();
		table.put(3,4);
		table.put(3,123);
		table.put(3,1);
		MapEntry[] arr = table.getTable();
		assertEquals(arr[3].getValue(),4);
		assertEquals(arr[3].getNext().getValue(),123);
		assertEquals(arr[3].getNext().getNext().getValue(),1);
		assertEquals(3,table.keyValues(3));
	}
	
	@Test
	public void testContains(){
		HashTable table = new HashTable();
		table.put(4, 2);
		table.put(14, 3);
		assertTrue(table.contains(4));
		assertFalse(table.contains(3));
		assertTrue(table.contains(14));
	}
	
	@Test
	public void testClear(){
		HashTable table = new HashTable();
		for(int i=0;i<8;i++){
			table.put(i,i*3);
		}
		assertEquals(table.getTable().length,23);
		table.clear();
		assertEquals(table.getTable().length,11);
		MapEntry[] datArray = table.getTable();
		for(int i=0;i<datArray.length;i++){
			assertEquals(datArray[i],null);
		}
	}
	
	@Test
	public void getDemKeys(){
		HashTable table = new HashTable();
		table.put(20, 2);
		table.put(23, 3);
		table.put(1, 4);
		
		Set<K> keys = new HashSet();
		keys.add((K)(Integer)23);
		keys.add((K)(Integer)1);
		keys.add((K)(Integer)20);	
	}
	
	@Test
	public void thosValuesTho(){
		HashTable table = new HashTable();
		table.put(20, 2);
		table.put(23, 3);
		table.put(1, 4);
		Collection<V> values = new ArrayList();
		values.add((V)(Integer)3);
		values.add((V)(Integer)4);
		values.add((V)(Integer)2);
		assertEquals(values,table.values());
	}
	
	@Test
	public void testValuesChained(){
		HashTable table = new HashTable();
		table.put(20, 2);
		table.put(23, 3);
		table.put(23, 17);
		Collection<V> values = new ArrayList();
		values.add((V)(Integer)3);
		values.add((V)(Integer)17);
		values.add((V)(Integer)2);
		assertEquals(values,table.values());
	}
	
	@Test
	public void testKeyValues(){
		HashTable table = new HashTable();
		table.put(20, 2);
		table.put(23, 3);
		table.put(23, 4);
		assertEquals(2,table.keyValues((K)(Integer)23));
		assertEquals(1,table.keyValues((K)(Integer)20));
		assertEquals(-1,table.keyValues((K)(Integer)1));
	}
	
	@Test
	public void gtfo(){
		HashTable table = new HashTable();
		table.put(1, 2);
		table.put(2, 3);
		table.put(3, 4);
		table.remove((K)(Integer)2);
		Collection<V> values = new ArrayList();
		values.add((V)(Integer)2);
		values.add((V)(Integer)4);
		Set<K> keys = new HashSet();
		keys.add((K)(Integer)1);
		keys.add((K)(Integer)3);
		assertEquals(values,table.values());
		assertEquals(keys,table.keySet());
		assertFalse(table.contains((K)(Integer)2));
		assertTrue(table.getTable()[2].isRemoved());
		assertEquals(null,table.remove((K)(Integer)15));
	}
	
	@Test
	public void testRemoveChain(){
		HashTable table = new HashTable();
		table.put(2, 2);
		table.put(2, 5);
		table.put(2, 8);
		table.remove((K)(Integer)2);
		assertTrue(table.contains((K)(Integer)2));
		assertEquals(2,table.keyValues((K)(Integer)2));
		assertEquals(2,table.getTable()[2].getValue());
		assertEquals(5,table.getTable()[2].getNext().getValue());
		assertTrue(table.getTable()[2].getNext().getNext().isRemoved());
		assertFalse(table.getTable()[2].isRemoved());
	}
	
	@Test
	public void addAfterRemoved(){
		HashTable table = new HashTable();
		table.put(1, 2);
		table.put(2, 5);
		table.put(3, 8);
		table.remove((K)(Integer)2);
		assertTrue(table.getTable()[2].isRemoved());
		table.put(12, 49);
		assertEquals(12,table.getTable()[2].getKey());
	}
	
	@Test
	public void removeResizeShenanigans(){
		HashTable table = new HashTable();
		for(int i=0; i<7; i++){
			table.put(i,i*3);
			table.remove(i);
		}
		assertFalse(table.getTable()[6]==null);
		assertTrue(table.getTable()[7]==null);
		table.put(8,1);
		assertEquals(table.getTable().length,11);
	}
	
	@Test
	public void testEntrySet(){
		HashTable table = new HashTable();
		table.put(1,4);
		table.put(2, 2);
		table.put(2, 5);
		table.put(1,4);
		Set<MapEntry<K,V>> entries = new HashSet();
		entries.add(new MapEntry(1,4));
		entries.add(new MapEntry(2,2));
		entries.add(new MapEntry(2,5));
		assertEquals(entries,table.entrySet());
	}
	
}