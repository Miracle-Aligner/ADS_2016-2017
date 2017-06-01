package lab4_task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import common.GeomFigure;

public class TestTask1 {

	@Test
	public void testEmptyTable() {
		Hastable tableEmpty = new Hastable();
		assertEquals(tableEmpty.size(), 0);
		assertTrue(tableEmpty.isEmpty());

		// remove from empty hashTable
		int v1[] = {10,3};
		int v2[] = {11, 25};
		int v3[] = {-11, 35};
		GeomFigure gf = new GeomFigure(v1, v2, v3, 45);
		assertFalse(tableEmpty.remove(gf));
		assertEquals(tableEmpty.size(), 0);

		// search in empty hashTable
		assertFalse(tableEmpty.contains(gf));

	}

	@Test
	public void testAddOneElement() {
		// TODO
		// add one element, check the size
		Hastable table = new Hastable();
		assertEquals(table.size(), 0);
		assertTrue(table.isEmpty());

		// adding an element to hashTable
		int v1[] = {10,3};
		int v2[] = {11, 25};
		int v3[] = {-11, 35};
		GeomFigure gf = new GeomFigure(v1, v2, v3, 45);
		assertTrue(table.add(gf));
		assertEquals(table.size(), 1);

		// search added element in hashTable
		assertTrue(table.contains(gf));
	}

	@Test
	public void testAddSomeNotUniqueElements() {
		// TODO
		Hastable table = new Hastable();
		assertEquals(table.size(), 0);
		assertTrue(table.isEmpty());

		// add element to hashTable
		int v1[] = {10,3};
		int v2[] = {11, 25};
		int v3[] = {-11, 35};
		GeomFigure gf1 = new GeomFigure(v1, v2, v3, 45);
		assertTrue(table.add(gf1));
		assertEquals(table.size(), 1);
		
		// add not unique element to hashTable
		GeomFigure gf2 = new GeomFigure(v1, v2, v3, 45);
		assertFalse(table.add(gf2));
		assertEquals(table.size(), 1);
	}

	@Test
	public void testAddSomeUniqueElements() {
		// TODO
		Hastable table = new Hastable(40);
		assertEquals(table.size(), 0);
		assertTrue(table.isEmpty());

		// add element to hashTable
		GeomFigure gf[] = new GeomFigure [6];
		int v1[][] = {  {1,5}, 
						{2,10},
						{3, 14},
						{5,10},
						{20,9},
						{12,3}
		};
		int v2[][] = {  {3,8}, 
						{3,20},
						{9, 16},
						{9,3},
						{3,16},
						{2,6}
		};
		int v3[][] = {  {9,15}, 
						{12,30},
						{12, 32},
						{6,12},
						{11,13},
						{16,20}
		};
		double angle[] = { 30, 28, 63, 98, 5, 95};
		for (int i = 0; i < 6; i++)
		{
			gf[i] = new GeomFigure(v1[i], v2[i], v3[i], angle[i]);
		}
		
		// adding 6 unique elements to hashTable
		for (int i = 0; i < gf.length; i++)
		{
			assertTrue(table.add(gf[i]));
			assertEquals(table.size(), i + 1);
		}
		
		// test if all elements are added
		for (int i = 0; i < gf.length; i++)
		{
			assertTrue(table.contains(gf[i]));
		}
	}

	@Test
	public void testRehash() {
		// TODO
		Hastable table = new Hastable(3);
		assertEquals(table.size(), 0);
		assertTrue(table.isEmpty());

		// add element to hashTable
		GeomFigure gf[] = new GeomFigure [8];
		int v1[][] = {  {1,5}, 
						{2,10},
						{3, 14},
						{5,10},
						{20,9},
						{12,3},
						{4,14},
						{69,2}
		};
		int v2[][] = {  {3,8}, 
						{3,20},
						{9, 16},
						{9,3},
						{3,16},
						{2,6},
						{24,31},
						{5,14}
		};
		int v3[][] = {  {9,15}, 
						{12,30},
						{12, 11},
						{6,12},
						{11,13},
						{22,66},
						{29,32},
						{15,12}
		};
		double angle[] = { 30, 28, 63, 98, 5, 95, 41, 148};
		for (int i = 0; i < 8; i++)
		{
			gf[i] = new GeomFigure(v1[i], v2[i], v3[i], angle[i]);
		}
		
		for (int i = 0; i < gf.length; i++)
		{
			table.add(gf[i]);
		}
		assertTrue(table.size() > 3);
		
	}

	@Test
	public void testRemove() {
		// TODO
		Hastable table = new Hastable();
		assertEquals(table.size(), 0);
		assertTrue(table.isEmpty());

		GeomFigure gf[] = new GeomFigure [6];
		int v1[][] = {  {1,5}, 
						{2,10},
						{3, 14},
						{5,10},
						{20,9},
						{12,3}
		};
		int v2[][] = {  {3,8}, 
						{3,20},
						{9, 16},
						{9,3},
						{3,16},
						{2,6}
		};
		int v3[][] = {  {9,15}, 
						{12,30},
						{12, -3},
						{6,12},
						{11,13},
						{22,66}
		};
		double angle[] = { 30, 28, 63, 98, 5, 95};
		for (int i = 0; i < 6; i++)
		{
			gf[i] = new GeomFigure(v1[i], v2[i], v3[i], angle[i]);
		}
		
		// adding 6 unique elements to hashTable
		for (int i = 0; i < gf.length; i++)
		{
			assertTrue(table.add(gf[i]));
			assertEquals(table.size(), i + 1);
		}
		
		// deleting 6 unique elements from hashTable
		int startingSize = table.size();
		for (int i = startingSize - 1; i >= 0; i--)
		{
			assertTrue(table.remove(gf[i]));
			assertEquals(table.size(), --startingSize);
		}

		// search in empty hashTable
		assertTrue(table.isEmpty());
	}

	@Test
	public void testContains() {
		// TODO
		Hastable table = new Hastable(40);
		assertEquals(table.size(), 0);
		assertTrue(table.isEmpty());
		
		GeomFigure gf[] = new GeomFigure [3];
		int v1[][] = {  {1,5}, 
						{2,10},
						{3, 14}
		};
		int v2[][] = {  {3,8}, 
						{3,20},
						{9, 16}
		};
		int v3[][] = {  {9,15}, 
						{12,30},
						{12, 33}
		};
		double angle[] = { 30, 28, 63};
		for (int i = 0; i < 3; i++)
		{
			gf[i] = new GeomFigure(v1[i], v2[i], v3[i], angle[i]);
		}

		
		// adding 3 unique elements to hashTable
		for (int i = 0; i < gf.length; i++)
		{
			assertTrue(table.add(gf[i]));
			assertEquals(table.size(), i + 1);
		}
		
		// searching presenting elements
		for (int i = 0; i < gf.length; i++)
		{
			assertTrue(table.contains(gf[i]));
		}
		
		// creating the array of figures which is not presented in hashTable
		GeomFigure notPresFigures[] = new GeomFigure [3];
		int newV1[][] = {{5,10},
						{20,9},
						{12,3}
		};
		int newV2[][] = {{9,3},
						{22,16},
						{2,6}
		};
		int newV3[][] = {{6,12},
						{11,13},
						{22,66}
		};
		double angles[] = {98, 5, 95};
		for (int i = 0; i < 3; i++)
		{
			notPresFigures[i] = new GeomFigure(newV1[i], newV2[i], newV3[i], angles[i]);
		}

		
		// searching the elements which is not presented in hashTable
		for (int i = 0; i < notPresFigures.length; i++)
		{
			assertFalse(table.contains(notPresFigures[i]));
		}
	}

}
