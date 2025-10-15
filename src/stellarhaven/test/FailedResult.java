package stellarhaven.test;

public sealed class FailedResult extends Result {
	@Override
	public Result.Type getResultType() {
		return Result.Type.FAILURE;
	}
}
