import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDist {
	
	//private variables
	private int distance;
	
	private String firstStation;
	
	private String secondStation;
	
	private String[] allStations = new String[120];
	
	private int firstStationNode1;

	private int firstStationNode2;
	
	private int firstStationNode3;
	
	private int firstStationNode4;
	
	private int secondStationNode1;
	
	private int secondStationNode2;
	
	private int secondStationNode3;
	
	private int secondStationNode4;

	//HammingDist Constructor which takes in two string inputs for city/station ID
	public HammingDist(String firstStation, String secondStation) {
		this.firstStation = firstStation;
		this.secondStation = secondStation;
		calcDistance(firstStation, secondStation);
		
		try
    	{
			read("Mesonet.txt");
    	}
    	catch(IOException e)
    	{
    		System.out.println("Error reading from file!\n");
    		e.printStackTrace();
    	}
		
		calcAllDistance(firstStation, secondStation);
	}
	
	//Method for calculating Hamming distance between two IDs
	public int calcDistance(String firstStation, String secondStation) {
		distance = 0;
		for (int index = 0; index < 4; ++index) {
			char first = firstStation.charAt(index);
			char second = secondStation.charAt(index);
			if(first != second) {
				++distance;
			}
		}
		return distance;
	}
	
	public int calcHammingDistance(String station1, String station2) {
		int distance = 0;
		for (int index = 0; index < 4; ++index) {
			char first = station1.charAt(index);
			char second = station2.charAt(index);
			if(first != second) {
				++distance;
			}
		}
		return distance;
	}
	
	
	//Reads the filename into allStations
	public void read(String filename) throws IOException
    {
    	// Use a buffered Reader on the file:
    	BufferedReader br = new BufferedReader(new FileReader(filename));
        String strg;
        strg = br.readLine();
        strg = br.readLine();
        strg = br.readLine();
        
        for(int index = 0; index < allStations.length; ++index) {

        	strg = br.readLine();
        	if(strg == null) {
        		break;
        	}
        	//Breaks the string into just the 4-digit IDs
        	allStations[index] = strg.substring(1, 5);
        }
        
        br.close();
    }
	
	public void calcAllDistance(String station1, String station2) {
		for(int index = 0; index < allStations.length; ++index) {
			int test1 = calcHammingDistance(station1, allStations[index]);
				if(test1 == 1) {
					++firstStationNode1;
				}
				if(test1 == 2) {
					++firstStationNode2;
				}
				if(test1 == 3) {
					++firstStationNode3;
				}
				if(test1 == 4) {
					++firstStationNode4;
				}
		}
		for(int index = 0; index < allStations.length; ++index) {
			int test2 = calcHammingDistance(station2, allStations[index]);
				if(test2 == 1) {
					++secondStationNode1;				
					}
				if(test2 == 2) {
					++secondStationNode2;				
					}
				if(test2 == 3) {
					++secondStationNode3;				
					}
				if(test2 == 4) {
					++secondStationNode4;
				}
		}
	}
	
	/* Output for toString should be modeled like so:
	 * 
	 * The Hamming Distance of NRMN and NOWA: 3.
	 * Out of 119, for NRMN, number of nodes are: 0, 0, 23, 96 and
	 * for NOWA, number of nodes are: 0, 5, 16, 98 respectively.
	 */
	public String toString() {
		return String.format("The Hamming Distance of %s and %s: %d.\nOut of 119, for %s, number of nodes are: %d, %d, %d, %d and\nfor %s, number of nodes are: %d, %d, %d, %d respectively.", 
				firstStation, secondStation, distance, firstStation, firstStationNode1, firstStationNode2, firstStationNode3, firstStationNode4, 
				secondStation, secondStationNode1, secondStationNode2, secondStationNode3, secondStationNode4);
	}
}