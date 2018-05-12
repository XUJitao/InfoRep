package annuaire;

import java.util.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientApp {

    private Client client;
    private String REST_SERVICE_URL = "http://localhost:8080/Annuaire/rest/annuaire";
    //private String REST_SERVICE_URL = "http://localhost:8080/REST/rest/annuaire";
    private static final String SUCCESS_RESULT = "<result>success</result>";
    private static final String PASS = "pass";
    private static final String FAIL = "fail";
    
    private void init() {
        this.client = ClientBuilder.newClient();
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	System.out.println("Saisir votre opération: ");
    	
//        Client client = ClientBuilder.newClient();
//        WebTarget webTarget = client.target("http://localhost:8080/REST");
//        WebTarget restTarget = webTarget.path("rest");
//        WebTarget annuaireTarget = restTarget.path("annuaire");
        ClientApp clientApp = new ClientApp();
        clientApp.init();
        Scanner sc;
        while(true) {
        	sc = new Scanner(System.in);
        	String line = sc.nextLine();
        	String[] components = line.split(" ");
        	if (components.length == 1) {
        		if (components[0].equalsIgnoreCase("exit")) break;
        		clientApp.getAllPersonnes();
        	}
        	else if (components.length == 2) {
        		clientApp.delete(components[1]);
        	}
        	else {
        		if (components[0].equalsIgnoreCase("get")) {
        			if ("bureau".equalsIgnoreCase(components[1])) {
        				clientApp.getBureau(components[2]);
        			}
        			else {
        				clientApp.getPersonne(components[2]);
        			}
        		}
        		else if (components[0].equalsIgnoreCase("post")) {
        			clientApp.post(components[1], components[2]);
        		}
        		else {
        			clientApp.put(components[1], components[2]);
        		}
        	}
        }
    }
    
    private void getAllPersonnes() {
        GenericType<List<Personne>> list = new GenericType<List<Personne>>() {};
        List<Personne> personnes = client
                .target(REST_SERVICE_URL)
                .path("personnes")
                .request(MediaType.TEXT_PLAIN)
                .get(list);
        String result = PASS;
        if (personnes.isEmpty()) {
            result = FAIL;
        }
        System.out.println("getAllPersonnes, Result : " + result);
        for (Personne p : personnes) {
            System.out.println(p.toString());
        }
    }
    
    private void getBureau(String personne) {
        String bureau = client
                .target(REST_SERVICE_URL)
                .path("personnes")
                .path(personne)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        String result = FAIL;
        if (bureau != null) {
            result = PASS;
        }
        System.out.println("getBureau, Result : " + result);
        System.out.println(personne + " : " + bureau);
    }
    
    private void getPersonne(String bureau) {
        String personne = client
                .target(REST_SERVICE_URL)
                .path("bureaux")
                .path(bureau)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        String result = FAIL;
        if (personne != null) {
            result = PASS;
        }
        System.out.println("getPersonne, Result : " + result);
        System.out.println(bureau + " : " + personne);
    }
    
    private void post(String personne, String bureau) {
        Form form = new Form();
        form.param("nom", personne);
        form.param("bureau", bureau);
        
        String callResult =  client
                .target(REST_SERVICE_URL)
                .path("personnes")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.entity(form,
                        MediaType.APPLICATION_FORM_URLENCODED),
                        String.class);
        
        String result = PASS;
        if (!SUCCESS_RESULT.equals(callResult)) {
            result = FAIL;
        }
        
        System.out.println("post, result : " + result);
    }

    private void put(String personne, String bureau) {
        Form form = new Form();
        form.param("nom", personne);
        form.param("bureau", bureau);
        
        String callResult =  client
                .target(REST_SERVICE_URL)
                .path("personnes")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .put(Entity.entity(form,
                        MediaType.APPLICATION_FORM_URLENCODED),
                        String.class);
        
        String result = PASS;
        if (!SUCCESS_RESULT.equals(callResult)) {
            result = FAIL;
        }
        
        System.out.println("put, result : " + result);
    }

    private void delete(String personne) {        
        String callResult =  client
        		.target(REST_SERVICE_URL)
                .path("personnes")
                .path(personne)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .delete(String.class);
        
        String result = PASS;
        if (!SUCCESS_RESULT.equals(callResult)) {
            result = FAIL;
        }
        
        System.out.println("delete, result : " + result);
    }

}
