package stellarhaven.test;

import java.util.ArrayList;
import java.util.List;

public interface Testable {
	Test getTest();
	default List<Test> getTests() {
		return new ArrayList<Test>();
	}
}
