package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");			
			
	// Constructors
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		
		if (!checkOut.after(checkIn)) {			
			throw new DomainException("Check-out date must be after check-in date");			
		} 
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// Getters and Setters
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// Methods
	public long duration() {
		
		long diff = this.checkOut.getTime() - this.checkIn.getTime();	
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			
			throw new DomainException("Reservation dates for update must be future dates");			
		} 
		if (!checkOut.after(checkIn)) {
			
			throw new DomainException("Check-out date must be after check-in date");			
		} 

		this.checkIn = checkIn;
		this.checkOut = checkOut;		
	}
	
	@Override
	public String toString() {
		
		return String.format("Room %d, check-in: %s, check-out: %s, %d nights.", 
				this.getRoomNumber(), 
				sdf.format(this.checkIn),
				sdf.format(this.checkOut),
				this.duration());
	}
}
