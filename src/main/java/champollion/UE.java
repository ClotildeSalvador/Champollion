package champollion;

import java.util.ArrayList;

public class UE {
    private final String myIntitule;
    private int heuresCM ;
    private int heuresTD ;
    private int heuresTP ;
    private ArrayList<Enseignant> intervenants ;
    

    public UE(String intitule) {
        myIntitule = intitule;
        this.intervenants= new ArrayList<Enseignant>() ;
    }
    
    public void ajouterIntervenant(Enseignant e) {
    	intervenants.add(e) ;
    }

    public String getIntitule() {
        return myIntitule;
    }

	public int getHeuresCM() {
		return heuresCM;
	}

	public void setHeuresCM(int heuresCM) {
		this.heuresCM = heuresCM;
	}

	public int getHeuresTD() {
		return heuresTD;
	}

	public void setHeuresTD(int heuresTD) {
		this.heuresTD = heuresTD;
	}

	public int getHeuresTP() {
		return heuresTP;
	}

	public void setHeuresTP(int heuresTP) {
		this.heuresTP = heuresTP;
	}

    
}
