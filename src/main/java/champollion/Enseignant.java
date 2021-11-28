package champollion;

import java.util.ArrayList;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
	private ArrayList<ServicePrevu> enseignements ;
	public ArrayList<Intervention> InterventionsPlanifiees ;
	

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.enseignements= new ArrayList<ServicePrevu>();
        this.InterventionsPlanifiees=new ArrayList<Intervention>() ;
    }

    
//     Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
//     de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
//     "équivalent TD"
//     
//     @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
    	float r=0 ;
    	for (ServicePrevu s : enseignements) {
    		r+=1.5*s.getVolumeCM() + s.getVolumeTD() + 0.75*s.getVolumeTP() ;
    	}
    	int total = Math.round(r) ;
        return total ;
    }

//    /**
//     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
//     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
//     * de TP vaut 0,75h "équivalent TD"
//     *
//     * @param ue l'UE concernée
//     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
//     *
//     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
    	double r=0 ;
    	for (ServicePrevu i : enseignements) {
    		if (i.getUe()==ue) {
    			r = 1.5*ue.getHeuresCM() + ue.getHeuresTD() + 0.75*ue.getHeuresTP() ;
    		}
    	}
    	int total =  (int) Math.round(r) ;
    	return total ;
    }

//    /**
//     * Ajoute un enseignement au service prévu pour cet enseignant
//     *
//     * @param ue l'UE concernée
//     * @param volumeCM le volume d'heures de cours magitral
//     * @param volumeTD le volume d'heures de TD
//     * @param volumeTP le volume d'heures de TP
//     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
    	ServicePrevu s = new ServicePrevu(volumeCM, volumeTD, volumeTP, ue) ;
    	this.enseignements.add(s) ; 
    	ue.ajouterIntervenant(this);
    	ue.setHeuresCM(ue.getHeuresCM()+volumeCM);
    	ue.setHeuresTD(ue.getHeuresTD()+volumeTD);
    	ue.setHeuresTP(ue.getHeuresTP()+volumeTP);
    	
    }
    
    public void ajouteIntervention(Intervention i) {
    	i.setIntervenant(this); 
    	this.InterventionsPlanifiees.add(i) ;
    }


	public ArrayList<ServicePrevu> getEnseignements() {
		return enseignements;
	}


//    public boolean enSousService() {
//    	
//    }
//    
//    public int resteAPlanifier() {
//    	
//    }

}
