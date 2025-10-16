package stellarhaven.test;

import java.util.ArrayList;
import java.util.List;

/**This class is part of my testing framework
 *
 * @author William
 */
public abstract class TestSuite {
	protected List<Test> tests = new ArrayList<>();

	public abstract void initializeSuite();

	public void runTests() {
		System.out.println("Running Tests...");
		List<Result> results = tests.stream().map(Test::run).toList();
		System.out.println("Tests finished.");
		System.out.println("Results: ");
		for (Result result : results) {
			result.printMessage();
		}
	}

	public List<Test> getTests() {
		return tests;
	}
}
