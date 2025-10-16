package stellarhaven.test;

public final class InfoResult extends Result {
	public InfoResult(String message, Object info) {
		super(message, info);
	}

	@Override
	public Type getResultType() {
		return Type.INFO;
	}
}
