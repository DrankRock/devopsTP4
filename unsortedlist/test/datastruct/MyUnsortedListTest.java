package datastruct;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {

	UnsortedList<Integer> listEmpty;
	UnsortedList<Integer> list;
	UnsortedList<Integer> listBig;
	
	
	@Before public void initialize() {
		listEmpty = MyUnsortedList.of();
		list = MyUnsortedList.of(0);
		listBig = MyUnsortedList.of(1,2,3,4,5);
	}

	@Test
	public void testIsEmpty() {
		assertTrue("list of 0 element", listEmpty.isEmpty());
		assertEquals("list of 0 element", 0, listEmpty.size());
		listEmpty.append(1);
		assertFalse("list of 1 element", listEmpty.isEmpty());
	}
	
	@Test
	public void testPrepend() {
		assertFalse("list of 1 element", list.isEmpty());
		assertEquals("size of list", 1, list.size());
		list.prepend(1);
		assertEquals("prepend one element", MyUnsortedList.of(1,0),list);
		assertEquals("size after prepend one element",2, list.size());
	}
	
	@Test
	public void testAppend() {
		assertFalse("list of 1 element", list.isEmpty());
		assertEquals("size of list", 1, list.size());
		list.append(1);
		assertEquals("append 1 element", MyUnsortedList.of(0,1),list);
		assertEquals("size after append one element", 2, list.size());
	}
	
	@Test
	public void testInsert() {
		assertFalse("list of 1 element", list.isEmpty());
		assertEquals("size of the list",1, list.size());
		list.insert(1,0);
		assertEquals("insert 1 at the position 0",MyUnsortedList.of(1,0),list);
		assertEquals("size after instert one element", 2, list.size());
		list.insert(1,list.size());
		assertEquals("insert 1 at the position list.size()",MyUnsortedList.of(1,0,1),list);
		assertEquals("size after instert one element",3, list.size());
		list.insert(2,2);
		assertEquals("insert 2 at the position 2",MyUnsortedList.of(1,0,2,1),list);
		assertEquals("size after instert one element",4, list.size());
	}
	
	@Test
	public void testPop() {
		assertFalse("list of 5 element", listBig.isEmpty());
		assertEquals("size of list of 5 elements",5, listBig.size());
		assertEquals("value returned by pop", 1, listBig.pop().intValue());
		assertEquals("list after pop one element",MyUnsortedList.of(2,3,4,5),listBig);
		assertEquals("size after pop one element", 4, listBig.size());
	}
	
	@Test
	public void testPopLast() {
		assertFalse("list of 5 element", listBig.isEmpty());
		assertEquals("size of list of 5 elements",5, listBig.size());
		assertEquals("value returned by popLast", 5, listBig.popLast().intValue());
		assertEquals("list after popLast one element",MyUnsortedList.of(1,2,3,4),listBig);
		assertEquals("size after popLast one element", 4, listBig.size());
	}
	
	@Test
	public void testRemove() {
		assertFalse("list of 5 element", listBig.isEmpty());
		assertEquals("size of list of 5 elements",5, listBig.size());
		assertEquals("value returned by remove",3,listBig.remove(2).intValue());
		assertEquals("remove the element at the position 2",MyUnsortedList.of(1,2,4,5),listBig);
		assertEquals("size after remove one element", 4, listBig.size());
	}
	
	@Test
	public void testRemoveZeroEqualsPop() {
		UnsortedList<Integer> tempList = MyUnsortedList.of(1,2,3,4,5);
		assertEquals("remove 0 equals to pop", listBig.remove(0), tempList.pop());
	}
	
	@Test
	public void testEquals() {
		assertFalse("instance of MyUnsortedList",list.equals(0));
		assertFalse("empty list equals to list of one elment", listEmpty.equals(list));
		assertTrue("list equals to listing its list", listBig.equals(MyUnsortedList.of(1,2,3,4,5)));
	}
	
	@Test(expected = EmptyListException.class)
	public void testPopEmptyException(){
		listEmpty.pop();
	}
	
	@Test(expected = EmptyListException.class)
	public void testPopLastEmptyException(){
		listEmpty.popLast();
	}
	
	// If pos < 0
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertOutOfBoundInfZero(){
		list.insert(3, -3);
	}
	
	// If pos > size
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertOutOfBoundSupSize(){
		list.insert(3, 3);
	}
	
	// If pos < 0
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfBoundInfZero(){
		listEmpty.remove(3);
	}
	
	// If pos > size
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfBoundSupSize(){
		listEmpty.remove(-3);
	}
	
	// If pos = 0
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveOutOfBound(){
		listEmpty.remove(0);
	}

	@Test
	public void testToString() {
		assertEquals("toString of list","MyUnsortedList { size = 5, [1, 2, 3, 4, 5] }", listBig.toString());
	}
}
