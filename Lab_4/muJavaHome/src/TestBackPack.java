import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
public class TestBackPack {
	BackPack backPack;
	@Before
	public void setUp(){
		backPack = new BackPack();
	}
	@Test
	public void BackPack() {
		int m = 10;
		int n = 3;
		int expect = 11;
		int w[] = {3, 4, 5};
                                int p[] = {4, 5, 6};
                                int c[][] = backPack.BackPack_Solution(m, n, w, p);
                                assertEquals( expect,c[n][m]);
        
	}

}
