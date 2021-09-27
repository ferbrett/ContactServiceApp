package main;

public class Contact {

	// Contact object
	public void contact(String id, String firstName, String lastName, 
			String phoneNumber, String address) {
		
		boolean enteredValue = true;
		
		if (id.length() > 10) {
			System.out.println("This ID is too long. Please enter another ID under 10 characters: ");
		} else if (enteredValue == false) {
			System.out.println("You must enter a value here.");
		} else {
			System.out.println("ID accepted.");
		}
		
		if (firstName.length() > 10) {
			System.out.println("This first name is too long. Please enter another first name under 10 characters: ");
		} else if (enteredValue == false) {
			System.out.println("You must enter a value here.");
		} else {
			System.out.println("First name accepted.");
		}
		
		if (lastName.length() > 10) {
			System.out.println("This last name is too long. Please enter another last name under 10 characters: ");
		} else if (enteredValue == false) {
			System.out.println("You must enter a value here.");
		} else {
			System.out.println("Last name accepted.");
		}
		
		if (phoneNumber.length() > 10) {
			System.out.println("This phone number is too long. Please enter another phone number that is exactly 10 characters: ");
		} else if (enteredValue == false) {
			System.out.println("You must enter a value here.");
		} else {
			System.out.println("Phone number accepted.");
		}
		
		if (address.length() > 30) {
			System.out.println("This address is too long. Please enter another address under 30 characters: ");
		} else if (enteredValue == false) {
			System.out.println("You must enter a value here.");
		} else {
			System.out.println("Address accepted.");
		}
	}
}
