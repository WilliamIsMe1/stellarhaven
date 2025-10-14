package stellarhaven.test;

public abstract sealed class Result permits InfoResult, FailedResult, SuccessResult {

	protected String message;
	protected String info;

	public Result(String message, Object info) {
		this.message = message;
		this.info = info;
	}

	public abstract Type getResultType();

	public enum Type {
		SUCCESS,
		FAILURE,
		INFO
	}

	public void printMessage() {
		System.out.println(message);
	}

	
}
