import org.junit.Test;
import static org.junit.Assert.*;

public class MineUnitTest {
	@Test
	public void testGetMinePosition() {
		Mine mine = new Mine();
		int minePosition = mine.getMinePosition(1, 10);
		assertTrue(minePosition >= 1 && minePosition <= 10);
	}
}