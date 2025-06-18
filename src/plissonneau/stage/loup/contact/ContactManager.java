package plissonneau.stage.loup.contact;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
	
	
	private List <Contact> contactListe = new ArrayList<>();

	public List<Contact> getContact() {
	return contactListe;
	}

	public void ajouterContact(Contact pContact) {
		contactListe.add(pContact);
    }
    
    public void supprimerContact(Contact pContact) {
    	contactListe.remove(pContact);
    }
    
    public void afficherContact(Contact pContact, String parametre) {
    	  
    	System.err.println(pContact.getNom());
    	System.err.println(pContact.getPrenom());
    	System.err.println(pContact.getNumero());
    	
    	System.err.println(parametre);
    }
    
}
