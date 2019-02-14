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
		calcDistance();
		
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
	public int calcDistance() {
		distance = 0;
		for (int index = 0; index < 4; ++index) {
			char first = this.firstStation.charAt(index);
			char second = this.secondStation.charAt(index);
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

		int[] allHammingDistanceCounts = new int[8];
		for(int index = 0; index < allStations.length; ++index) {
			if (!station1.equals(allStations[index])) {
				if(station1.charAt(0) == allStations[index].charAt(0)) {
					++allHammingDistanceCounts[0];
				}
				if(station1.charAt(1) == allStations[index].charAt(1)) {
					++allHammingDistanceCounts[1];
				}
				if(station1.charAt(2) == allStations[index].charAt(2)) {
					++allHammingDistanceCounts[2];
				}
				if(station1.charAt(3) == allStations[index].charAt(3)) {
					++allHammingDistanceCounts[3];
				}
			}
		}
		for(int index = 0; index < allStations.length; ++index) {
			if (!station2.equals(allStations[index])) {
				if(station2.charAt(0) == allStations[index].charAt(0)) {
					++allHammingDistanceCounts[4];
				}
				if(station2.charAt(1) == allStations[index].charAt(1)) {
					++allHammingDistanceCounts[5];
				}
				if(station2.charAt(2) == allStations[index].charAt(2)) {
					++allHammingDistanceCounts[6];
				}
				if(station2.charAt(3) == allStations[index].charAt(3)) {
					++allHammingDistanceCounts[7];
				}
			}
		}
		firstStationNode1 = allHammingDistanceCounts[0];
		firstStationNode2 = allHammingDistanceCounts[1];
		firstStationNode3 = allHammingDistanceCounts[2];
		firstStationNode4 = allHammingDistanceCounts[3];
		
		secondStationNode1 = allHammingDistanceCounts[4];
		secondStationNode2 = allHammingDistanceCounts[5];
		secondStationNode3 = allHammingDistanceCounts[6];
		secondStationNode4 = allHammingDistanceCounts[7];

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