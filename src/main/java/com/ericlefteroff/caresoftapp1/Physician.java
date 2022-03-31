package com.ericlefteroff.caresoftapp1;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
//    
//    
    public Physician(Integer id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
	}

	@Override
    public boolean assignPin(int pin) {
		if(pin < 10000 && pin > 999) {
			this.pin = pin;
			return true;
		}
    	return false;
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID)  {
    	return this.id  == confirmedAuthID? true: false;
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    
    // GETTERS AND SETTERS
    
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
    
    


	
}
