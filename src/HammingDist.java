public class HammingDist {
	
	//private variables
	private int distance;
	
	private String firstStation;
	
	private String secondStation;
	
	//HammingDist Constructor which takes in two string inputs for city/station ID
	public HammingDist(String firstStation, String secondStation) {
		this.firstStation = firstStation;
		this.secondStation = secondStation;
		calcDistance();
	}
	
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