package com.zoomtravel;

import java.util.ArrayList;
import com.zoomtravel.flights.Flights;
import com.zoomtravel.parse.Parse;

public class TestJava {

	public static void main(String[] args) {
		String source = "BOS";
		String destination = "CDG";
		String date = "31-12-2010";
		String preference = "time duration";

		ArrayList<Flights> filghts = new ArrayList<Flights>();
		Parse parse = new Parse();
		filghts = parse.csv(source, destination, date, preference);
		for (Flights flights : filghts) {
			System.out.println(flights);
		}

	}

}
