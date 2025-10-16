package stellarhaven.test;

/**This interface is meant to be a lambda that runs tests
 *
 * @author William
 */
@FunctionalInterface
public interface Test {
	Result run();
}
