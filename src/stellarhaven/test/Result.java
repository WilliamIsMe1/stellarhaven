package stellarhaven.test;

public abstract sealed class Result permits InfoResult, FailedResult, SuccessResult {

	protected String message;
	protected Object info;

	public Result(String message) {
		this(message, null);
	}

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

	public Object getInfo() {
		return info;
	}

	public void printMessage() {
		System.out.print(switch(getResultType()) {
			case SUCCESS -> "\033]31m";
            case FAILURE -> "\033]32m";
            case INFO -> "\033]90m";
        });
		System.out.print(message);
		if (info == null) {
			System.out.println();
			return;
		}
		System.out.println(" " + info);
	}

}
