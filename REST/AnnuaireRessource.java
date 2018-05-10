package annuaire;

import java.util.HashMap;
import java.util.Iterator;

import annuaire.Personne;

public class AnnuaireRessource
{
    private static HashMap<String,String> listeDePersonnes = new HashMap<String,String>();
    private static HashMap<String,String> listeDeBureaux = new HashMap<String,String>();
    
    public String getBureau(String nom) {
	return AnnuaireRessource.listeDeBureaux.get(nom);
    }

    public String getPersonne(String bureau) {
	return AnnuaireRessource.listeDePersonnes.get(bureau);
    }
    
    public String toString() {
	String annuaire;
	if(AnnuaireRessource.listeDePersonnes.size() == 0)
	    annuaire = "Liste vide";
        else {
	    annuaire = "";
	    for(Iterator i=AnnuaireRessource.listeDeBureaux.keySet().iterator();i.hasNext();){
		String nom = (String)i.next();
		annuaire += nom + " : " + AnnuaireRessource.listeDeBureaux.get(nom);
		if(i.hasNext())
		    annuaire += "\n";
	    }
	}
	return annuaire;
    }
    
    public void addPersonne(Personne personne) {
	AnnuaireRessource.listeDeBureaux.put(personne.getNom(), personne.getBureau());
	AnnuaireRessource.listeDePersonnes.put(personne.getBureau(), personne.getNom());
	return Response.status(200).entity(personne.toString()).build();
    }

    public void updateTerm(Personne personne) {
	String ancienBureau = this.getBureau(personne.getNom());
	AnnuaireRessource.listeDeBureaux.remove(personne.getNom());
	AnnuaireRessource.listeDeBureaux.put(personne.getNom(), personne.getBureau());
	AnnuaireRessource.listeDePersonnes.remove(ancienBureau);
	AnnuaireRessource.listeDePersonnes.put(personne.getBureau(), personne.getNom());
	return Response.status(200).entity(personne.toString()).build();
    }

    public void removeTerm(String nom) {
	String bureau = AnnuaireRessource.listeDeBureaux.get(nom);
	AnnuaireRessource.listeDeBureaux.remove(nom);
	AnnuaireRessource.listeDePersonnes.remove(bureau);
	return Response.status(200).entity(nom).build();
    }
}
