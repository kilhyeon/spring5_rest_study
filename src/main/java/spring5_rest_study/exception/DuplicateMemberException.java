package spring5_rest_study.exception;

@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String message) {
		super(message);
	}

}
