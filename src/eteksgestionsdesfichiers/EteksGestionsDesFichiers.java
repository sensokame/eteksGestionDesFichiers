/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eteksgestionsdesfichiers;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author houcem
 */
public class EteksGestionsDesFichiers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File testFile = new File("/home/houcem/NetBeansProjects/EteksGestionsDesFichiers/src/files/file_test");
        System.out.println(" can we read the file " + testFile.getName() + ": " + testFile.canRead());
        System.out.println("file path is " + testFile.getAbsolutePath());
        System.out.println("does the file exist: " + testFile.exists());
        System.out.println("and is it a file !!! : " + testFile.isFile());
        System.out.println("can we read the file? : " + testFile.canRead());
        System.out.println("can we write it? : " + testFile.canWrite());
        System.out.println("and can we execute it: " + testFile.canExecute());
        System.out.println("file was last modified on : " + (new Date(testFile.lastModified())).toString());
        //testFile.renameTo(new File("./src/files/file_test"));     //renaming the file would result in failed future runs with the same code
        //testFile.delete();        //deleting file would result in failed future runs of the same source code

        //FileDescriptor
        FileInputStream fileInputStream = null;
        DataInputStream dataInpurStream;
        PushbackInputStream pushBackStream;
        try {
            System.out.println("adding file to file descriptor");
            fileInputStream = new FileInputStream(testFile);
            FileDescriptor fd = fileInputStream.getFD();
            System.out.println("is the file valid: " + fd.valid());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EteksGestionsDesFichiers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EteksGestionsDesFichiers.class.getName()).log(Level.SEVERE, null, ex);
        }

        //InputStream
        //FileInputStream
        //DataInputStream
        //pushbackstream
        System.out.println("adding file to file input stream");
        try {
            fileInputStream = new FileInputStream(testFile);
            System.out.println("octet available : " + fileInputStream.available());
            System.out.println("read method : " + fileInputStream.read());
            System.out.println("available after first read : " + fileInputStream.available());
            System.out.println("is the file marksupported: " + fileInputStream.markSupported());
            if (fileInputStream.markSupported()) {
                System.out.println("resetting file : ");
                fileInputStream.reset();
                System.out.println("octet available after reset : " + fileInputStream.available());
            }
            dataInpurStream = new DataInputStream(fileInputStream);
            //example of a method
            System.out.println("reading a char of the datainputstream : " + dataInpurStream.readChar());
            System.out.println("reading an int of the datainputstream : " + dataInpurStream.readInt());
            System.out.println("reading a line of the datainputstream : " + dataInpurStream.readLine());
            pushBackStream = new PushbackInputStream(dataInpurStream);
            System.out.println(dataInpurStream.readLine());
            pushBackStream.unread('c');
            
            System.out.println(pushBackStream.read() );

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EteksGestionsDesFichiers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EteksGestionsDesFichiers.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // the other input classes all have the same methods with the same uses
            
            //acces en ecriture a un flux
            //les classes d'ecriture en flux sont les memes que celle de lire, mais en sens mirroire
            // read devient write et ainsi de suite
            
            //acces aleatoire de fichiers
            System.out.println("random access time");
            RandomAccessFile randomfile = new RandomAccessFile(testFile, "rw");
            System.out.println("shwing first line : "+randomfile.readLine());
            System.out.println("reading first char : "+randomfile.read());
            System.out.println("printing file length : "+randomfile.length());
            System.out.println("printing current position : "+ randomfile.getFilePointer());
            randomfile.seek(5);
            System.out.println("printing position after seek : "+randomfile.getFilePointer());
            System.out.println("printing length again to show that it's the total length : "+randomfile.length());
            randomfile.write(95);
            randomfile.seek(0);
            System.out.println("length after write to show that it overwrites : "+randomfile.length());
            System.out.println("showing line to show change : "+randomfile.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EteksGestionsDesFichiers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EteksGestionsDesFichiers.class.getName()).log(Level.SEVERE, null, ex);
        }
        //rest of methods are simple enough
        
        
    }
}
