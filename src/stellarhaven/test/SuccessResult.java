package stellarhaven.test;

public final class SuccessResult extends Result {
	public SuccessResult(String message, Object info) {
		super(message, info);
	}

	public SuccessResult(String message) {
		this(message, null);
	}

	@Override
	public Type getResultType() {
		return Type.SUCCESS;
	}
	
}
