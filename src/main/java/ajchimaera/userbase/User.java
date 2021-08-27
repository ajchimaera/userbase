package ajchimaera.userbase;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class User {

	private @Id @GeneratedValue long id;
	private String firstName;
	private String lastName;
	private String emailAddress;

	User() {
	}

	User(String firstName, String lastName, String emailAddress) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	public Long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(this.id, user.id) && Objects.equals(this.firstName, user.firstName)
				&& Objects.equals(this.lastName, user.lastName) && Objects.equals(this.emailAddress, user.emailAddress);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.firstName, this.lastName, this.emailAddress);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + this.id + ", firstName='" + this.firstName + "', lastName='" + this.lastName
				+ "', emailAddress='" + this.emailAddress + "'}";
	}
}