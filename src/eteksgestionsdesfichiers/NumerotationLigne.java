/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eteksgestionsdesfichiers;

/**
 *
 * @author houcem second example in the eteks course
 */
import java.io.*;

public class NumerotationLigne {
    // Méthode lancée à l'appel de l'instruction :
    // java LectureFichier nomFichier

    public static void main(String[] args) {
        try {
            File testFile = new File("/home/houcem/NetBeansProjects/EteksGestionsDesFichiers/src/files/file_test");
            // Ouverture du fichier 
            // avec un filtre utilisant un buffer
            InputStream fluxFichier = new BufferedInputStream(
                    new FileInputStream(testFile));

            // Numérotation des lignes                     
            numeroterLigne(fluxFichier);

            fluxFichier.close();
        } catch (IOException e) {
            // Exception déclenchée si un problème survient pendant l'accès au fichier
            System.out.println(e);
        }
    }

    public static void numeroterLigne(InputStream flux) throws IOException {
        // Création d'un filtre de décompte des lignes
        LineNumberInputStream fluxLignes = new LineNumberInputStream(flux);
        // Ajout d'un filtre pour lire de manière plus pratique les caractères
        DataInputStream fluxLecture = new DataInputStream(fluxLignes);

        // Lecture des lignes du flux jusqu'à la fin du flux
        String ligne;
        for (ligne = fluxLecture.readLine();
                ligne != null;
                ligne = fluxLecture.readLine()) // Ecriture sur la sortie standard de la ligne lue avec son numéro de ligne
        {
            System.out.println(String.valueOf(fluxLignes.getLineNumber())
                    + " : " + ligne);
        }
    }
}
