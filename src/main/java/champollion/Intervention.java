package champollion;

import java.util.Date;

public class Intervention {
	private Date debut ;
	private int duree ;
	private boolean annulee ;
	private int heureDebut ;
	private Enseignant intervenant ;
	
	public Intervention(Date deb, int dur, int hdeb) {
		this.debut=deb ;
		this.duree=dur;
		this.heureDebut=hdeb ;
		this.annulee=false ;
		this.intervenant=null ;
	}
	
	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public boolean isAnnulee() {
		return annulee;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Enseignant getIntervenant() {
		return intervenant;
	}

	public void setIntervenant(Enseignant intervenant) {
		this.intervenant = intervenant;
	}

	public void annulerInterventino() {
		this.annulee=true ;
	}
}
