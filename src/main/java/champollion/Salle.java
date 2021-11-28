package champollion;

public class Salle {
	private String intitule ;
	private int capacite ;
	
	public Salle(String nom, int cap) {
		this.intitule = nom ;
		this.capacite = cap ;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
}
