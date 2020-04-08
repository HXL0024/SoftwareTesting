import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
public class TestBubbleSort {
	BubbleSort bubbleSort;
	@Before
	public void setUp(){
		bubbleSort = new BubbleSort();
	}
	
	@Test
	public void BubbleSort() {
		int except[] = {1,2,3,5,6};
		int par[] = {2,5,6,2,1};
		Assert.assertArrayEquals(except,bubbleSort.BubbleSort(par));
	}

}
