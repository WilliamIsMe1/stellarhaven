package stellarhaven.test;

import java.util.function.FunctionalInterface;

/**This interface is meant to be a returned lambda by classes trying to get themselves tested. {@link Testable} will be an interface to show a class
 * can be tested.
 *
 * @author William
 */
@FunctionalInterface
public interface Test {
	Result run();
}
