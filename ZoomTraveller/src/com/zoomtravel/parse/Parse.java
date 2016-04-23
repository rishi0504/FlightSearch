package com.zoomtravel.parse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.zoomtravel.config.ZoomTravelConfig;
import com.zoomtravel.flights.AirFrance;
import com.zoomtravel.flights.BritishAirways;
import com.zoomtravel.flights.Flights;
import com.zoomtravel.flights.Lufthansa;

public class Parse {

	public ArrayList<Flights> csv(String source, String destination, String date, String preference) {

		ArrayList<Flights> flights = new ArrayList<Flights>();
		flights = parseCsvFile(source, destination, date, flights);
		if(preference.equals("time duration")){
			
			Collections.sort(flights, new Comparator<Flights>() {
			    public int compare(Flights m1, Flights m2) {
			        return m1.getTime().compareTo(m2.getTime());
			    }
			});
			
		}else if(preference.equals("prize")){
			Collections.sort(flights, new Comparator<Flights>() {
				@Override
				public int compare(Flights c1, Flights c2) {
					return Double.compare(c1.getFare(), c2.getFare());
				}
			});
		}
		
		
		return flights;
	}

	private ArrayList<Flights> parseCsvFile(String source, String destination, String date,
			ArrayList<Flights> flights) {
		ArrayList<Flights> flight = new ArrayList<Flights>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		SimpleDateFormat parsedDate = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateObject = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat timeFormate = new SimpleDateFormat("HH:mm:ss");
		String[] file = ZoomTravelConfig.DB_FILES;
		for (int i = 0; i < file.length; i++) {
			try {
				br = new BufferedReader(new FileReader(file[i]));
				try {
					while ((line = br.readLine()) != null) {

						// use comma as separator
						String[] string = line.split(cvsSplitBy);

						try {
							Date userDefinedDate = parsedDate.parse(date);
							Date csvDate = parsedDate.parse(string[3]);
							if (string[1].equals(source) && string[2].equals(destination)) {
								int compareOutput = userDefinedDate.compareTo(csvDate);
								if (compareOutput == 0) {
									if (i == 0) {
										Date flightDate = dateObject.parse(string[3] + " " + string[4]);
										Date timeDuration = timeFormate.parse(string[5]);
										AirFrance airfrance = new AirFrance(string[0], string[1], string[2], flightDate,
												Double.parseDouble(string[6]), timeDuration);
										flight.add(airfrance);
									} else if (i == 1) {
										Date flightDate = dateObject.parse(string[3] + " " + string[4]);
										Date timeDuration = timeFormate.parse(string[5]);
										BritishAirways britishairways = new BritishAirways(string[0], string[1],
												string[2], flightDate, Double.parseDouble(string[6]), timeDuration);
										flight.add(britishairways);
									} else if (i == 2) {
										Date flightDate = dateObject.parse(string[3] + " " + string[4]);
										Date timeDuration = timeFormate.parse(string[5]);
										Lufthansa lufthansa = new Lufthansa(string[0], string[1], string[2], flightDate,
												Double.parseDouble(string[6]), timeDuration);
										flight.add(lufthansa);
									}
								}
							}

						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flight;

	}

}
