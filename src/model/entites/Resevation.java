package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Resevation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Resevation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if(!checkOut.after(checkIn)){
			throw new DomainException("Error in resevation: CheckOut date must be after checkIn date");	
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}


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

	
	public long durarion(){	
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Error in resevation: Reservation date must for updates must be futere dates");
		}
		if(!checkOut.after(checkIn)){
			throw new DomainException("Error in resevation: CheckOut date must be after checkIn date");	
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		
		return "Room "
				+ roomNumber
				+ ", checkIn: "
				+ sdf.format(checkIn)
				+", checkOut: "
				+ sdf.format(checkOut)
				+", "
				+durarion()
				+ " nights";
	}
	
}
