package plissonneau.stage.loup.contact;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public final class FenetrePrincipale {
	 private JFrame frame;

	    private JTextField tfNom, tfPrenom, tfTelephone;

	    private JTextArea taContacts;

	    private ContactManager carnet;

	    public FenetrePrincipale() {

	        carnet = new ContactManager();

	        initUI();

	    }
public void initUI(){
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


     JButton btnAjouter = new JButton("Ajouter");
     btnAjouter.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             ajouterContact();
         }
     });
     panel.add(btnAjouter);



     JButton btnAfficher = new JButton("Afficher contacts");

     btnAfficher.addActionListener(new ActionListener() {

         @Override

         public void actionPerformed(ActionEvent e) {

             afficherContacts();

         }

     });

     panel.add(btnAfficher);

     
     JButton btnSupprimer = new JButton("Supprimer");
     btnSupprimer.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             supprimerContact();
         }
     });
     panel.add(btnSupprimer);

     
     
     taContacts = new JTextArea();

     taContacts.setEditable(false);

     JScrollPane scroll = new JScrollPane(taContacts);



     frame.add(panel, BorderLayout.NORTH);

     frame.add(scroll, BorderLayout.CENTER);

     frame.setVisible(true);

 }

private void ajouterContact() {

    String nom = tfNom.getText();

    String prenom = tfPrenom.getText();

    String telephone = tfTelephone.getText();

    Contact c = new Contact(nom, prenom, telephone);

    carnet.ajouterContact(c);

    tfNom.setText("");

    tfPrenom.setText("");

    tfTelephone.setText("");
 
    
}

private void afficherContacts() {

    taContacts.setText(carnet.listerContacts());

}

private void supprimerContact() {

    String nom = tfNom.getText();

    String prenom = tfPrenom.getText();

    carnet.supprimerContact( nom, prenom);

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


