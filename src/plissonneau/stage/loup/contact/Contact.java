package plissonneau.stage.loup.contact;

public class Contact {
	

	public Contact(String nom, String prenom, String numero) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
	}

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	private String nom;
	private String prenom;
	private String numero;
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("bienvenue Loup!");
		
		Contact loup = new Contact();
        loup.setNom("SERRES");
        loup.setPrenom("Olivier");
        loup.setNumero("0696435437");
//		System.err.println(loup.getNom());
//		System.err.println(loup.getPrenom());
//		System.err.println(loup.getNumero());
		
		ContactManager pContactManager = new ContactManager();
		System.err.println("Resultat ajout " + pContactManager.ajouterContact(loup));
		
		
		
		System.out.println(pContactManager.getContact().size());
		pContactManager.afficherContact(loup, "Ceci est un paramètre");
		
		
	}

	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom; 
	}
	
	public String getNumero() {
		return numero;
		
	}
	public void setNom(String pNom) {
		nom = pNom;
	}
	
	public void setPrenom(String pPrenom) {
		prenom = pPrenom;
	}
	
	public void setNumero(String pNumero) {
		numero = pNumero;
	}
	
	public String toString() {
		return nom + " " + prenom + " " + numero;
		
	}
}
