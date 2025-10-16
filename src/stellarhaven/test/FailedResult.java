package stellarhaven.test;

public final class FailedResult extends Result {
	public FailedResult(String message, Object info) {
		super(message, info);
	}

	@Override
	public Result.Type getResultType() {
		return Result.Type.FAILURE;
	}
}
