/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eteksgestionsdesfichiers;

/**
 *
 * @author houcem
 * exemple du site eteks sur la lecture d'un fichier en flux
 * pour compiler et executer ce fichier on a besoin de passer en parametre un fichier et un entier
 */
import java.io.*;

public class LectureFichier {
    // Méthode lancée à l'appel de l'instruction :
    // java LectureFichier nomFichier nombreCaracteres

    public static void main(String[] args) {
        try {
            // Ouverture du fichier passé en paramètre dans la ligne de commande
            File testFile = new File("/home/houcem/NetBeansProjects/EteksGestionsDesFichiers/src/files/file_test");
            InputStream fluxFichier = new FileInputStream(testFile);

            // Lecture des n premiers octets du fichier. n est passé en paramètre
            String numberOfOctet = "10";
            byte contenuFichier[] = new byte[Integer.parseInt(numberOfOctet)];
            fluxFichier.read(contenuFichier);
            //i tried to avoid the use of args 
            // Ecriture sur la sortie standard des octets lus convertis
            // en une chaîne de caractères
            System.out.println(new String(contenuFichier, 0));

            // Fermeture du fichier
            fluxFichier.close();
        } catch (IOException e) {
            // Exception déclenchée si un problème survient pendant l'accès au fichier
            System.out.println(e);
        }
    }
}
