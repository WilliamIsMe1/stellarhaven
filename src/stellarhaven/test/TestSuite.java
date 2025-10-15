package stellarhaven.test;

import java.util.ArrayList;

/**This class is part of my testing framework
 *
 * @author William
 */
public abstract class TestSuite {
	private ArrayList<Test> tests = new ArrayList<>();

	public abstract void initializeSuite();

	public abstract void runTests();
}
