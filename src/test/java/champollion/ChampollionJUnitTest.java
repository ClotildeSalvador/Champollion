package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;

	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
	}

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(), "Un nouvel enseignant doit avoir 0 heures prévues");
	}

	@Test
	public void testAjouteHeures() {
		// 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

		// 20h TD pour UML
		untel.ajouteEnseignement(uml, 0, 20, 0);

		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

	}
	@Test
	public void testHeureParUE() {
//		quand l'enseignant n'a pas d'heure prevues pour l'ue
		untel.ajouteEnseignement(uml, 10, 10, 0);
		assertEquals(untel.heuresPrevuesPourUE(java), 0, "l'enseignant ne doit avoir aucune heure prevue pour cette ue" );
//		quand il en a : ici doit etre egal a 15+10=25
		assertEquals(untel.heuresPrevuesPourUE(uml), 25, "l'enseignant n'a pas le bon nb d'heure equivalent td") ;
	}

	@Test
	public void testAjouterIntervention() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		untel.ajouteIntervention(inter);
//		on verifie que l'intervention s'est bien ajoutee a la liste
		int a = untel.InterventionsPlanifiees.size() - 1;
		assertEquals(untel.InterventionsPlanifiees.get(a), inter,
				"la derniere intervention ajoutee n'est pas la bonne");
//		on verifie que l'intervention est bien faite par le bon intervenant
		assertEquals(inter.getIntervenant(), untel,
				"l'intervenant de l'intervention doit etre celui dans lequel on se trouve");
	}

	@Test
	public void testHeuresPrevues() {
		untel.ajouteEnseignement(uml, 0, 10, 0);
//		vaut 10 equivalent TD
		untel.ajouteEnseignement(java, 10, 10, 10);
//		vaut 15+10+7,5=32,5 arrondi =33
//		total doit faire 43
		assertEquals(untel.heuresPrevues(), 43, "les calculs sont pas bons kevin");

	}

	@Test
	public void testUeGetIntitule() {
//		on essaie sur les 2 au cas ou
		assertEquals(java.getIntitule(), "Programmation en java", "l'intitule de l'UE n'est pas bon");
		assertEquals(uml.getIntitule(), "UML", "l'intitule de l'UE n'est pas bon");
	}

	@Test
	public void testGetNomPersonne() {
		assertEquals(untel.getNom(), "untel", "le test du nom échoue");
	}

	@Test
	public void testGetEmailPersonne() {
		assertEquals(untel.getEmail(), "untel@gmail.com", "le test du mail échoue");

	}
	
//	test de la classe ServicePrevu=SP
	
	@Test
	public void testSetUeSP() {
		untel.ajouteEnseignement(java, 10, 10, 10);
		untel.getEnseignements().get(0).setUe(uml); 
		assertEquals(untel.getEnseignements().get(0).getUe(), uml, "l'ue n'a pas ete changee") ;
	}
	
	@Test
	public void testSetCmSP() {
		untel.ajouteEnseignement(java, 10, 10, 10);
		untel.getEnseignements().get(0).setVolumeCM(0); 
		assertEquals(untel.getEnseignements().get(0).getVolumeCM(), 0, "les heures de CM n'ont pas ete correctement changee") ;
	}
	
	@Test
	public void testSetTdSP() {
		untel.ajouteEnseignement(java, 10, 10, 10);
		untel.getEnseignements().get(0).setVolumeTD(0); 
		assertEquals(untel.getEnseignements().get(0).getVolumeTD(), 0, "les heures de TD n'ont pas ete correctement changee") ;
	}
	
	@Test
	public void testSetTpSP() {
		untel.ajouteEnseignement(java, 10, 10, 10);
		untel.getEnseignements().get(0).setVolumeTP(0); 
		assertEquals(untel.getEnseignements().get(0).getVolumeTP(), 0, "les heures de TP n'ont pas ete correctement changee") ;
	}
	
//	test sur la classe salle
	
	@Test
	public void testSalleGetIntitule() {
		Salle s= new Salle("salle", 50) ;
		assertEquals(s.getIntitule(), "salle", "l'intitule retourne n'est pas le bon") ;
	}
	@Test
	public void testSalleSetIntitule() {
		Salle s= new Salle("salle", 50) ;
		s.setIntitule("amphi");
		assertEquals(s.getIntitule(), "amphi", "l'intitule n'a pas ete correctement modifie") ;
	}
	@Test
	public void testSalleGetCapacite() {
		Salle s= new Salle("salle", 50) ;
		assertEquals(s.getCapacite(), 50, "la capacite retournee n'est pas la bonne") ;
	}
	@Test
	public void testSalleSetCapacite() {
		Salle s= new Salle("salle", 50) ;
		s.setCapacite(100);
		assertEquals(s.getCapacite(), 100, "la capacite n'a pas ete correctemment modifiee") ;
	}
	
//	test sur la classe intervention
	
	@Test
	public void testInterGetDebut() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		assertEquals(inter.getDebut(), date) ;
	}
	
	@Test
	public void testInterSetDebut() {
		Date date = new Date();
		Date date2 = new Date(2021L) ;
		Intervention inter = new Intervention(date, 2, 16);
		inter.setDebut(date2);
		assertEquals(inter.getDebut(), date2) ;
	}
	
	@Test
	public void testInterGetDuree() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		assertEquals(inter.getDuree(), 2) ;
	}
	
	@Test
	public void testInterSetDuree() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		inter.setDuree(4);
		assertEquals(inter.getDuree(), 4) ;
	}
	
	@Test
	public void testInterGetHeureD() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		assertEquals(inter.getHeureDebut(), 16) ;
	}
	
	@Test
	public void testInterSetHeureD() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		inter.setHeureDebut(8);
		assertEquals(inter.getHeureDebut(), 8) ;
	}
	
	@Test
	public void testInterIsAnnulee() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		assertFalse(inter.isAnnulee(), "l'intervention ne doit pas etre annulee a sa creation") ;
		inter.annulerInterventino();
		assertTrue(inter.isAnnulee(), "l'intervention doit etre annulee") ;
	}
	
	@Test
	public void testInterAnnuler() {
		Date date = new Date();
		Intervention inter = new Intervention(date, 2, 16);
		inter.annulerInterventino();
		assertTrue(inter.isAnnulee()) ;
	}
}
