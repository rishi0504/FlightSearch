Problem Statement

Problem

Implement a standalone flight search engine that lists matching flights for a traveler who is looking to fly 

between 2 locations on a given date. The input locations should be in 3-letter location code format as present 

in the airlines flight data.

Specifications

You are given 3 CSV files, each containing the available flights data for British Airways, Lufthansa Airlines and 

Air France respectively. Each file contains the following fields:

 FLIGHT_NUM - Unique flight number, starting with 2-letter airline code.

 DEP_LOC - Departure location code of the flight.

 ARR_LOC - Arrival location code of the flight.

 VALID_TILL - Date (DD-MM-YYYY) till which each flight is available. It means that this flight would fly 

once every day till this date. 

 FLIGHT_TIME - Local time (HHmm) at which the flight departs from the departure location.

 FLIGHT_DURN - Flight duration (HH.mm) from departure location to the arrival location.

FARE - This is the fare of the flight per person in $ (US Dollars).

Assumptions and Constraints

Following assumptions and constraints apply:

 The engine should accept 4 input parameters: Departure Location, Arrival Location, Flight Date, Output 

Preference. “Output Preference” is a String suggesting whether the flight results should be sorted only by 

fare, or by both fare and flight duration. 

 The engine should then search for the flights in all 3 CSV files, and list the aggregate results on standard 

output, sorted by Fare and Flight Duration, depending on “Output Preference”. 

 The engine should be written considering that there could be more CSV files in future, and each CSV file 

  


might contain more data than present. 

 If the Departure location or/and Arrival location is not present in any of the CSV files, then engine should 

return a user friendly error.   

If there are no flights available for the user entered input parameters, then engine should return a different 

user friendly error.

Input data

The following PIPE delimited sample data is given to you. You are allowed to extend on this data and create 

heavier input files.
===============================================
AIR FRANCE

FLIGHT_NUM|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DURN|FARE

AF299|FRA|LHR|20-11-2010|0600|4.10|480

AF118|DUB|MUC|21-12-2010|1410|5.40|580

AF371|AMS|MAD|30-11-2010|1210|3.45|320

AF453|BOS|CDG|20-11-2010|1350|7.30|1000

AF544|BOM|LHR|10-12-2010|1150|8.10|950

AF271|AMS|MAD|27-10-2010|1100|3.30|500

AF249|JFK|LHR|01-12-2010|1550|8.40|1030 
==========================================

========================================
LUFTHANSA AIRLINES

FLIGHT_NUM|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DURN|FARE

LH348|DEL|AMS|30-11-2010|2325|11.00|1050

LH201|LHR|MEL|21-11-2010|0230|15.30|1400

LH342|VIE|JFK|20-10-2010|1130|14.20|980

LH451|LHR|PEK|30-11-2010|1130|12.00|1400

LH119|FRA|CDG|06-12-2010|1220|3.40|380

LH929|FRA|LHR|10-12-2010|0100|4.30|450

LH801|DUB|MUC|11-12-2010|1710|6.00|560

LH137|AMS|MAD|30-12-2010|1000|3.25|340

LH562|GVA|BOM|20-10-2010|0215|7.30|800 
=======================================  

=======================================

BRITISH AIRWAYS

FLIGHT_NUM|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FLIGHT_DURN|FARE

BA123|DEL|AMS|12-10-2010|0050|8.00|950

BA412|BOS|CDG|31-12-2010|0210|7.50|800

BA413|BOS|AMS|30-11-2010|1530|7.00|750

BA111|LHR|PEK|30-10-2010|2340|12.50|1200

BA765|LHR|BOM|31-12-2010|1420|8.50|825

BA322|CDG|NRT|15-11-2010|0010|13.00|1150

BA438|DEL|AMS|30-11-2010|1325|10.50|920

BA102|LHR|MEL|01-12-2010|0330|16.00|1550

BA234|VIE|JFK|20-10-2010|1230|10.20|940 
=========================================

