/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eteksgestionsdesfichiers;

/**
 *
 * @author houcem
 * exemple d'ecriture du cours
 */
import java.io.*;
import java.util.Vector;

public class ConcatenationFichiers {
    // Méthode lancée à l'appel de l'instruction :
    // java ConcatenationFichiers nomFichier1 ...  nomFichierN nomFichierDest

    public static void main(String[] args) {
        try {

            Vector ensembleFichiers = new Vector();
            // Ajout à ensembleFichiers de tous les flux de données avec buffer
            // correspondant à chaque fichier d'entrée passé en paramètres 
            // (sauf le dernier paramètre)
            File testFile = new File("/home/houcem/NetBeansProjects/EteksGestionsDesFichiers/src/files/file_test");

            ensembleFichiers.addElement(new BufferedInputStream(
                    new FileInputStream(testFile)));
            testFile = new File("/home/houcem/NetBeansProjects/EteksGestionsDesFichiers/src/files/file_test  (another copy)");
            ensembleFichiers.addElement(new BufferedInputStream(
                    new FileInputStream(testFile)));
            testFile = new File("/home/houcem/NetBeansProjects/EteksGestionsDesFichiers/src/files/file_test  (copy)");
            ensembleFichiers.addElement(new BufferedInputStream(
                    new FileInputStream(testFile)));
            // Création d'un ensemble de flux d'entrée        
            InputStream fluxEntree
                    = new SequenceInputStream(ensembleFichiers.elements());

            // Ouverture en écriture avec un buffer du fichier
            // passé en dernier paramètre dans la ligne de commande
           testFile = new File("/home/houcem/NetBeansProjects/EteksGestionsDesFichiers/src/files/result");
            
            OutputStream fluxDestination
                    = new BufferedOutputStream(
                            new FileOutputStream(testFile));

            byte donnees[] = new byte[1000];
            int nbreOctetsLus;
            // Lecture puis écriture des données 
            while ((nbreOctetsLus = fluxEntree.read(donnees)) != -1) {
                fluxDestination.write(donnees, 0, nbreOctetsLus);
            }

            // Fermeture des flux
            fluxDestination.close();
            fluxEntree.close();
        } catch (IOException e) {
            // Exception déclenchée si un problème survient pendant l'accès aux fichiers
            System.out.println(e);
        }
    }
}
