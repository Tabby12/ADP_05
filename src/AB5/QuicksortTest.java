package AB5;
import static org.junit.Assert.*;

import org.junit.Test;

public class QuicksortTest {
	private Quicksort _sort;
	
	public QuicksortTest()
	{
		_sort = new Quicksort();
	}

	@Test
	public void test() {
		Container [] arr = new Container[7];
		Container a = new Container(0,0);
		Container b = new Container(5,5);
		Container c = new Container(2,2);
		Container d = new Container(9,9);
		Container e = new Container(8,8);
		Container f = new Container(1,1);
		Container g = new Container(3,3);
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		arr[4] = e;
		arr[5] = f;
		arr[6] = g;
		_sort.sort(arr);
		assertEquals(arr[0],a);
		assertEquals(arr[1],f);
		assertEquals(arr[2],c);
		assertEquals(arr[3],g);
		assertEquals(arr[4],b);
		assertEquals(arr[5],e);
		assertEquals(arr[6],d);
		System.out.println(_sort.getCount());
	}
	
	@Test
	public void test2() {
		Container [] arr = new Container[7];
		Container a = new Container(0,0);
		Container f = new Container(1,1);
		Container e = new Container(8,8);
		Container g = new Container(2,2);
		Container d = new Container(9,9);		
		Container c = new Container(2,2);		
		Container b = new Container(2,2);		
		arr[0] = a;
		arr[1] = f;
		arr[2] = e;
		arr[3] = g;
		arr[4] = d;
		arr[5] = c;
		arr[6] = b;
		_sort.sort(arr);
		assertEquals(arr[0],a);
		assertEquals(arr[1],f);
		assertEquals(arr[2],g);
		assertEquals(arr[3],c);
		assertEquals(arr[4],b);
		assertEquals(arr[5],e);
		assertEquals(arr[6],d);
		System.out.println(_sort.getCount());
	}
	
	@Test
	public void test3() {
		Container [] arr = new Container[7];
		Container a = new Container(0,0);
		Container b = new Container(1,1);
		Container c = new Container(2,2);
		Container d = new Container(3,3);
		Container e = new Container(4,4);
		Container f = new Container(5,5);
		Container g = new Container(6,6);
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		arr[4] = e;
		arr[5] = f;
		arr[6] = g;
		_sort.sort(arr);
		assertEquals(arr[0],a);
		assertEquals(arr[1],b);
		assertEquals(arr[2],c);
		assertEquals(arr[3],d);
		assertEquals(arr[4],e);
		assertEquals(arr[5],f);
		assertEquals(arr[6],g);
		System.out.println(_sort.getCount());
	}

	@Test
	public void test4() {
		Container [] arr = new Container[7];
		Container a = new Container(0,0);
		Container b = new Container(1,1);
		Container c = new Container(2,2);
		Container d = new Container(3,3);
		Container e = new Container(3,3);
		Container f = new Container(5,5);
		Container g = new Container(6,6);
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		arr[3] = d;
		arr[4] = e;
		arr[5] = f;
		arr[6] = g;
		_sort.sort(arr);
		assertEquals(arr[0],a);
		assertEquals(arr[1],b);
		assertEquals(arr[2],c);
		assertEquals(arr[3],d);
		assertEquals(arr[4],e);
		assertEquals(arr[5],f);
		assertEquals(arr[6],g);
		System.out.println(_sort.getCount());
	}
	
	@Test
	public void testBestCaseRechts() {
		Container [] arr = new Container[10];
		Container a = new Container(0,0);
		Container b = new Container(1,1);
		Container c = new Container(2,2);
		Container d = new Container(3,3);
		Container e = new Container(4,4);
		Container f = new Container(5,5);
		Container g = new Container(6,6);
		Container h = new Container(7,7);
		Container i = new Container(8,8);
		Container j = new Container(9,9);
		arr[0] = h;
		arr[1] = i;
		arr[2] = j;
		arr[3] = f;
		arr[4] = a;
		arr[5] = g;
		arr[6] = d;
		arr[7] = b;
		arr[8] = c;
		arr[9] = e;
		_sort.sort(arr);
		assertEquals(arr[0],a);
		assertEquals(arr[1],b);
		assertEquals(arr[2],c);
		assertEquals(arr[3],d);
		assertEquals(arr[4],e);
		assertEquals(arr[5],f);
		assertEquals(arr[6],g);
		assertEquals(arr[7],h);
		assertEquals(arr[8],i);
		assertEquals(arr[9],j);
		System.out.println(_sort.getCount());
	}

}