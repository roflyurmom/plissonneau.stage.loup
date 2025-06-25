package plissonneau.stage.loup.contact;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {
	
	private List <Contact> contactListe = new ArrayList<>();

	public List<Contact> getContact() {
	 return contactListe;
	}

	public boolean ajouterContact(Contact pContact) {
		return contactListe.add(pContact);
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
    
    
    public String listerContacts(List<Contact> listContacts) {

        StringBuilder sb = new StringBuilder();

        for (Contact c : listContacts) {

            sb.append(c.toString()).append("\n");

        }

        return sb.toString();

    }

 

    public Contact trouverContact(String nom) {

        for (Contact c : contactListe) {

            if (c.getNom().equalsIgnoreCase(nom)) {

                return c;

            }

        }

        return null;

   
   } 
    
    public void supprimerContact(String pNom, String pPrenom) {
    	
    	for(int i= 0;  i<contactListe.size(); i++) {
    		
    		Contact contact = contactListe.get(i);
    		String nom = contact.getNom();
    		String prenom = contact.getPrenom();
    		
    		if (nom.equalsIgnoreCase(pNom)  &&
    				prenom.equalsIgnoreCase(pPrenom)) {
    		  contactListe.remove(i);
    		}
    		
    	}
    	
    }
}
