package com.zoomtravel.flights;

import java.util.Date;

public class BritishAirways extends Flights {

	public BritishAirways(String flightNo, String source_terminal,
			String destination_terminal, Date date,
			double fare, Date timeduration)  {
				
	super(flightNo, source_terminal, destination_terminal, date, fare,timeduration);
	
	}
	

}
