package com.zoomtravel.flights;

import java.util.Date;

public abstract class Flights {

	String flightNo;
	String source_terminal;
	String destination_terminal;
	Date date;
	Date time;
	double fare;

	public Flights(String flightNo, String source_terminal, String destination_terminal, Date date, double fare,
			Date timeduration) {
		this.flightNo = flightNo;
		this.source_terminal = source_terminal;
		this.destination_terminal = destination_terminal;
		this.fare = fare;
		this.date = date;
		this.time = timeduration;
	}

	public Date getDate() {
		return date;
	}

	public String getSource_terminal() {
		return source_terminal;
	}

	public String getDestination_terminal() {
		return destination_terminal;
	}

	public double getFare() {
		return fare;
	}

	public String getFlightNo() {
		return flightNo;
	}
	public Date getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "Flight no : " + this.flightNo+"\n";/* + "\nSource : " + this.source_terminal + "\nDestination : "
				+ this.destination_terminal + "\nDate : " + this.date + "\nTime Duration : " + this.time + "\nFare : "
				+ this.fare;*/
	}

}
