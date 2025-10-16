package stellarhaven.test;

public final class InfoResult extends Result {
	public InfoResult(String message, Object info) {
		super(message, info);
	}

	@Override
	public Result.Type getResultType() {
		return Result.Type.INFO;
	}
}
