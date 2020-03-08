package cn.tjuscs.st;
import static org.junit.Assert.*;


import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;

public class TestSearch {
	Search Sea;
	@Before
	public void setUp(){
		Sea = new Search();
	}
	
	@Test
	public void testSearch1(){
		boolean result1 = Sea.Search1(8);
		assertTrue(result1);
	}
	@Test
	public void testSearch2(){
		boolean result2 = Sea.Search1(51);
		assertTrue(result2);
	}
	
	
}
