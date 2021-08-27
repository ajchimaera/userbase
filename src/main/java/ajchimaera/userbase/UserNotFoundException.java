package ajchimaera.userbase;

public class UserNotFoundException extends RuntimeException {

	UserNotFoundException(Long id) {
		super("Could not find user with identifier " + id);
	}

}
