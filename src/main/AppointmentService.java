package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/*
 * Create different methods to handle the updating, creating, and deleting of appointments.
 * 
 * Store appointments in a list.
 */
public class AppointmentService {

	final public List<Appointment> appointmentList = new ArrayList<>();
	
	public String newUniqueId() {
		return UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	public void newAppointment() {
		Appointment appointment = new Appointment(newUniqueId());
		appointmentList.add(appointment);
	}
	
	public void newAppointment(Date date) {
		Appointment appointment = new Appointment(newUniqueId(), date);
		appointmentList.add(appointment);
	}
	
	public void newAppointment(Date date, String description) {
		Appointment appointment = new Appointment(newUniqueId(), date, description);
		appointmentList.add(appointment);
	}
	
	public void deleteAppointment(String id) throws Exception {
		appointmentList.remove(searchForAppointment(id));
	}
	
	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	
	public Appointment searchForAppointment(String id) throws Exception {
		int index = 0;
		while (index < appointmentList.size()) {
			if (id.equals(appointmentList.get(index).getAppointmentId())) {
				return appointmentList.get(index);
			}
			index++;
		}
		throw new Exception("The appointment does not exist.");
	}
}