package plissonneau.stage.loup.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
	String DB_URL = "jdbc:sqlite:C:\\SQlite\\instal\\sqlite-tools-win-x64-3500100\\contact.db";
	
	public  void insertContact(String nom, String prenom, String numero) {
    
	
	       String sql = "INSERT INTO T_CONTACT(nom, prenom, numero_telephone) VALUES(?, ?, ?)";
	 
	       try (Connection conn = DriverManager.getConnection(DB_URL);
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	           pstmt.setString(1, nom);
	           pstmt.setString(2, prenom);
	           pstmt.setString(3, numero);
	 
	           pstmt.executeUpdate();
	           System.out.println("Contact inséré avec succès.");

	       } catch (SQLException e) {
	          System.out.println("Erreur lors de l'insertion : " + e.getMessage());
	       }
	  }
	
	
	  public  void supprimerContact(String nom, String prenom) {

		  String sql = "DELETE FROM T_CONTACT where nom = ? and prenom = ?";
		  
		  try (Connection conn = DriverManager.getConnection(DB_URL);
			        PreparedStatement pstmt = conn.prepareStatement(sql)) {
			 
			       pstmt.setString(1, nom);
	               pstmt.setString(2, prenom);
			 
			       int affectedRows = pstmt.executeUpdate();
			 
			       if (affectedRows > 0) {
			          System.out.println("Contact supprimé avec succès.");
			       } else {
			          System.out.println("Aucun contact trouvé avec le nom : " + nom + " et le prénom " + prenom);
			       }
			 
			   } catch (SQLException e) {
			      System.out.println("Erreur lors de la suppression : " + e.getMessage());
			   }
	  }
	  
	  public List <Contact> chargerContact() {
		  String sql = "SELECT id_contact, nom, prenom, numero_telephone FROM T_CONTACT";
		  List <Contact> Cliste = new ArrayList<Contact>();
		  
	       try (Connection conn = DriverManager.getConnection(DB_URL);
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql)) {
	 
	           System.out.println("Liste des contacts :");
	           System.out.println("----------------------------");
	 
	           while (rs.next()) {
	               int id = rs.getInt("id_contact");
	               String nom = rs.getString("nom");
	               String prenom = rs.getString("prenom");
	               String numero = rs.getString("numero_telephone");
	 
	               Contact contact = new Contact();
	               contact.setId(id);
	               contact.setNom(nom);
	               contact.setPrenom(prenom);
	               contact.setNumero(numero);
	               
	               System.out.println("ID : " + id);
	               System.out.println("Nom : " + nom);
	              System.out.println("Prénom : " + prenom);
	              System.out.println("Téléphone : " + numero);
	              System.out.println("----------------------------");
	              
	              Cliste.add(contact);
	              
	           }
	 
	       } catch (SQLException e) {
	          System.err.println("Erreur lors de la sélection des contacts : " + e.getMessage());
	       }
	       
	       return Cliste;
	  }
	  
}
