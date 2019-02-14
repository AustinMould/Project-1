import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDist {
	
	//private variables
	private int distance;
	
	private String firstStation;
	
	private String secondStation;
	
	private String[] allStations = new String[119];
	
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
	
	
	//Reads file to String[] allStations
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

        	allStations[index] = strg;
        }
        
        br.close();
    }
	
	public int[] calcAllDistance(String station) {
		
		int[] allHammingDistanceCounts = new int[4];
		
		
		
		return null;
	}
	
	/* Output for toString should be modeled like so:
	 * 
	 * The Hamming Distance of NRMN and NOWA: 3.
	 * Out of 119, for NRMN, number of nodes are: 0, 0, 23, 96 and
	 * for NOWA, number of nodes are: 0, 5, 16, 98 respectively.
	 */
	public String toString() {
		return String.format("The Hamming Distance of %s and %s: %d.\nOut of 119, for %s, number of nodes are: %d, %d, %d, %d and\nfor %s, number of nodes are: %d, %d, %d, %d respectively.", 
				firstStation, secondStation, distance, firstStation, 0, 0, 0, 0, secondStation, 0, 0, 0, 0);
	}
}