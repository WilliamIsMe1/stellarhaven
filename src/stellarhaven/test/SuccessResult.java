package stellarhaven.test;

public final class SuccessResult extends Result {
	public SuccessResult(String message, Object info) {
		super(message, info);
	}

	@Override
	public Result.Type getResultType() {
		return Result.Type.SUCCESS;
	}
	
}
