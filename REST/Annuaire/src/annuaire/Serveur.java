package annuaire;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

@Path("/annuaire")
public class Serveur {
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAIL_RESULT = "<result>fail</result>";
	public AnnuaireRessource ar = new AnnuaireRessource();
	
	@GET
	@Path("/personnes")
	@Produces(MediaType.TEXT_PLAIN)
	public String getListe() {
		return ar.toString();
	}
	
	@GET
	@Path("/bureaux/{PERSONNE}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPersonne(@PathParam("PERSONNE") String personne) {
		return ar.getPersonne(personne);
	}
	
	@GET
	@Path("/personnes/{BUREAU}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBureau(@PathParam("BUREAU") String bureau) {
		return ar.getBureau(bureau);
	}
	
	@POST
	@Path("/personnes")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String ajouterPersonne(@FormParam("nom") String nom, 
							   @FormParam("bureau") String bureau) {
		Personne personne = new Personne(nom, bureau);
		if (ar.getBureau(personne.getNom()) == null) {
			ar.addPersonne(personne);
			return SUCCESS_RESULT;
		}
		else return FAIL_RESULT;
	}
	
	@DELETE
	@Path("/personnes/{PERSONNE}")
	@Produces(MediaType.TEXT_PLAIN)
	public String supprimerPersonne(@PathParam("PERSONNE") String nom) {
		if (ar.getBureau(nom) != null) {
			ar.removeTerm(nom);
			return SUCCESS_RESULT;
		}
		else return FAIL_RESULT;
	}
	
	@PUT
	@Path("personnes")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String mettreAJourPersonne(@FormParam("nom") String nom,
									  @FormParam("bureau") String bureau) {
		Personne personne = new Personne(nom, bureau);
		if (ar.getBureau(personne.getNom()) == null)
			return FAIL_RESULT;
		ar.updateTerm(personne);
		return SUCCESS_RESULT;
	}
}
