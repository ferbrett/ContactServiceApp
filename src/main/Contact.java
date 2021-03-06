package main;

public class Contact {

	/*
	 * Reusable constant/variable declarations/initializations
	 */
	private static final int CONTACT_PHONENUMBER_LENGTH = 10;
	private static final byte CONTACT_ID_LENGTH         = 10;
	private static final byte CONTACT_FIRSTNAME_LENGTH  = 10;
	private static final byte CONTACT_LASTNAME_LENGTH   = 10;
	private static final byte CONTACT_ADDRESS_LENGTH    = 30;
	
	private static final String INITIALIZER    = "INITIAL";
	public static final String INITIALIZER_NUM = "1235559999";
	
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	/*
	 * Create Contact objects.
	 */
	public Contact() {
		this.contactId   = INITIALIZER;
		this.firstName   = INITIALIZER;
		this.lastName    = INITIALIZER;
		this.phoneNumber = INITIALIZER;
		this.address     = INITIALIZER;
	}
	
	public Contact(String contactId) {
		updateContactId(contactId);
		this.firstName   = INITIALIZER;
		this.lastName    = INITIALIZER;
		this.phoneNumber = INITIALIZER;
		this.address     = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName) {
		updateContactId(contactId);
		updateFirstName(firstName);
		this.lastName    = INITIALIZER;
		this.phoneNumber = INITIALIZER;
		this.address     = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName, String lastName) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		this.phoneNumber = INITIALIZER;
		this.address     = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName, String lastName,
			String phoneNumber) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		this.address = INITIALIZER;
	}
	
	public Contact(String contactId, String firstName, String lastName,
			String phoneNumber, String address) {
		updateContactId(contactId);
		updateFirstName(firstName);
		updateLastName(lastName);
		updatePhoneNumber(phoneNumber);
		updateAddress(address);
	}
	
	/*
	 * Get information about each contact
	 */
	public final String getContactId() {
		return contactId;
	}
	
	public final String getFirstName() {
		return firstName;
	}
	
	public final String getLastName() {
		return lastName;
	}
	
	public final String getPhoneNumber() {
		return phoneNumber;
	}
	
	public final String getAddress() {
		return address;
	}
	
	/*
	 * Add update functionality
	 */
	public void updateFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name can't be empty.");
		} else if (firstName.length() > CONTACT_FIRSTNAME_LENGTH) {
			throw new IllegalArgumentException("First name can't be longer than " +
												CONTACT_FIRSTNAME_LENGTH + " characters.");
		} else {
			this.firstName = firstName;
		}
	}
	
	public void updateLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name can't be empty.");
		} else if (lastName.length() > CONTACT_LASTNAME_LENGTH) {
			throw new IllegalArgumentException("Last name can't be loger than " +
												CONTACT_LASTNAME_LENGTH + " characters");
		} else {
			this.lastName = lastName;
		}
	}
	
	public void updatePhoneNumber(String phoneNumber) {
		String allowed = "[0-9]+";
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone number can't be empty.");
		} else if (phoneNumber.length() != CONTACT_PHONENUMBER_LENGTH) {
			throw new IllegalArgumentException(
					"Phone number length is invalid. Ensure it is " +
					CONTACT_PHONENUMBER_LENGTH + " digits.");
		} else if (!phoneNumber.matches(allowed)) {
			throw new IllegalArgumentException(
					"Phone number can't have any characters except numbers.");
		} else {
			this.phoneNumber = phoneNumber;
		}
	}
	
	public void updateAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address can't be empty.");
		} else if (address.length() > CONTACT_ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address can't be longer than " +
												CONTACT_ADDRESS_LENGTH +
												" characters.");
		} else {
			this.address = address;
		}
	}
	
	public void updateContactId(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID can't be empty.");
		} else if (address.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID can't be longer than " +
												CONTACT_ID_LENGTH + " characters.");
		} else {
			this.contactId = contactId;
		}
	}
}