package plissonneau.stage.loup.contact;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class FenetrePrincipale {
	 private JFrame frame;

	    private JTextField tfNom, tfPrenom, tfTelephone;

	    private JTextArea taContacts;

	    private ContactManager carnet;

	    
	    DatabaseManager DBManager = new DatabaseManager();
	    
	    public FenetrePrincipale() {

	        carnet = new ContactManager();

	        initUI();

	    }
public void initUI(){
	
	try {
        // Set System L&F        
		UIManager.setLookAndFeel(
        UIManager.getSystemLookAndFeelClassName());
} 
catch (UnsupportedLookAndFeelException e) {
   // handle exception
}
catch (ClassNotFoundException e) {
   // handle exception
}
catch (InstantiationException e) {
   // handle exception
}
catch (IllegalAccessException e) {
   // handle exception
}
	
	
	 frame = new JFrame("Carnet de Contacts");

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     frame.setSize(400, 400);

     frame.setLayout(new BorderLayout());


     JPanel panel = new JPanel();

     panel.setLayout(new GridLayout(4, 3));

     
     panel.add(new JLabel("Nom :"));

     tfNom = new JTextField();

     panel.add(tfNom);
     panel.add(new JLabel(""));


     panel.add(new JLabel("Prénom :"));

     tfPrenom = new JTextField();

     panel.add(tfPrenom);
     panel.add(new JLabel(""));


     panel.add(new JLabel("Téléphone :"));

     tfTelephone = new JTextField();

     panel.add(tfTelephone);
     panel.add(new JLabel(""));

   
     
     JPanel boutonPall = new JPanel();
     boutonPall.setLayout(new GridLayout(4, 3));
     
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterContact();
				
				
			}
		});
		boutonPall.add(btnAjouter);

		JButton btnAfficher = new JButton("Afficher contacts");
		btnAfficher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				afficherContacts();
			}
		});
		boutonPall.add(btnAfficher);
     
     
     JButton btnSupprimer = new JButton("Supprimer");
     btnSupprimer.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             supprimerContact();
         }
     });
     boutonPall.add(btnSupprimer);


     JButton btnEnvoyerSMS = new JButton("Envoyer SMS");
		btnEnvoyerSMS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		boutonPall.add(btnEnvoyerSMS);
  
     taContacts = new JTextArea();

     taContacts.setEditable(false);

     JScrollPane scroll = new JScrollPane(taContacts);



     frame.add(panel, BorderLayout.NORTH);

     frame.add(boutonPall, BorderLayout.SOUTH);
     
     frame.add(scroll, BorderLayout.CENTER);

     frame.setVisible(true);

 }

private void ajouterContact() {

    String nom = tfNom.getText();

    String prenom = tfPrenom.getText();

    String telephone = tfTelephone.getText();

    Contact c = new Contact(nom, prenom, telephone);

    carnet.ajouterContact(c);
    
    DBManager.insertContact(nom, prenom, telephone);

    tfNom.setText("");

    tfPrenom.setText("");

    tfTelephone.setText("");
 
    
}

private void afficherContacts() {

	List<Contact> databaseContacts = DBManager.chargerContact();
	
	List<Contact> memoryContacts = carnet.getContact();
	String memoryContactString =  carnet.listerContacts(memoryContacts);
	
    taContacts.setText("CONTACTS BDD" + "\n" + carnet.listerContacts(databaseContacts) + "\n"+  "CONTACT MEMOIRE" + "\n" + memoryContactString);
    
}

private void supprimerContact() {

    String nom = tfNom.getText();

    String prenom = tfPrenom.getText();

    carnet.supprimerContact( nom, prenom);

    DBManager.supprimerContact(nom, prenom);
    
    tfNom.setText("");

    tfPrenom.setText("");

    tfTelephone.setText("");

    
}



public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

        @Override

        public void run() {

            new FenetrePrincipale();

        }

    });

}
}


