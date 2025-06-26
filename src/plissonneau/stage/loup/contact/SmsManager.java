package plissonneau.stage.loup.contact;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SmsManager {

	public void sendMessage(String numero, String pMessage) {

	        String from_sender  = "Y/N";	        
	        String path_to_py_script = "send_sms_by_allmysms.py";

	        // Appeler le script Python
	        try {
	        	
	            String pythonExe = "python"; // ou "python3" selon config
	            ProcessBuilder processBuilder = new ProcessBuilder(
	                pythonExe,
	                path_to_py_script,
	                from_sender,
	                numero,
	                pMessage
	            );
	            
	            // Créer le processus pour exécuter le script
	            processBuilder.redirectErrorStream(true);
	            
	            // Démarrer le processus
	            Process process = processBuilder.start();
	            
	            // Lire la sortie du script Python
	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line); // Afficher la sortie du script
	            }
	            
	            // Attendre la fin du processus
	            int exitCode = process.waitFor();
	            System.out.println("Le processus s'est terminé avec le code : " + exitCode);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


}
