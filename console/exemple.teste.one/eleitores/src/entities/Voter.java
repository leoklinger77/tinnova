package entities;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Voter {

	private ArrayList<VoterType> listVoter = new ArrayList<VoterType>();
	private int totalSize;
	
	public Voter() {
		for(int i = 0; i < 800; i++) {
			listVoter.add(VoterType.valid);
		}
		for(int i = 0; i < 150; i++) {	
			listVoter.add(VoterType.white);
		}
		for(int i = 0; i < 50; i++) {
			listVoter.add(VoterType.nullo);
		}		
		totalSize = listVoter.size();
	}
	
	
	public int TotalSize() {
		return totalSize;
	}
	
	public double calcTotalValid() {
		
		int totalValid = listVoter.stream()
									.filter(t -> t==VoterType.valid)
									.collect(Collectors.toList()).size();
		
		return  (totalValid*100) / totalSize;
	}
	
	public double calcWhiteTotalValid() {
		int total = listVoter.size();
		int totalValid = listVoter.stream()
									.filter(t -> t==VoterType.white)
									.collect(Collectors.toList()).size();

		return  (totalValid*100) / totalSize;
	}
	
	public double calcNullTotalValid() {
		int totalValid = listVoter.stream()
									.filter(t -> t==VoterType.nullo)
									.collect(Collectors.toList()).size();

		return  (totalValid*100) / totalSize;
	}
}


 