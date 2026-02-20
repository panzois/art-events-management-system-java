package Theater;


import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author panzois
 */
/**Κλάση Μενού Θεατρικής Παράστασης.
 */
public class TheaterMenu 
{
    Scanner scnr = new Scanner (System.in);
    private TheaterPlayManager mngr;
    
    public TheaterMenu(TheaterPlayManager mngr) 
    {
        this.mngr = mngr;      
    }
       
    public void TheaterMenu () throws FileNotFoundException
    {
        int choice = -1;
        do
        {
            System.out.println("\n--- ΔΙΑΧΕΙΡΙΣΗ ΘΕΑΤΡΙΚΩΝ ΠΑΡΑΣΤΑΣΕΩΝ ---");
            System.out.println("1. Προσθήκη θεατρικής παράστασης");
            System.out.println("2. Επεξεργασία θεατρικής παράστασης");
            System.out.println("3. Διαγραφή θεατρικής παράστασης");
            System.out.println("4. Εμφάνιση θεατρικών παραστάσεων");
            System.out.println("5. Αποθήκευση και Έξοδος");
            System.out.print("\nΕπιλογή: ");

            String input = scnr.nextLine();

            try {
                    if (input.length() != 1) 
                    {
                        throw new NumberFormatException(); // αναγκαστικά ρίχνουμε αν μήκος ≠ 1
                    }

                    int num = Integer.parseInt(input); // Αν δεν είναι αριθμός, ρίχνει εξαίρεση

                    if (num < 1 || num > 5) 
                    {
                        System.out.println("Μη έγκυρη επιλογή. Επιλέξτε έναν αριθμό μεταξύ 1-5.");
                        continue;
                    }

                    choice = num;

                    switch(choice)
                    {
                        case 1:
                            mngr.addPlay(scnr);
                            break;
                        case 2:
                            mngr.editPlay(scnr); 
                            break;
                        case 3:
                            mngr.deletePlay(scnr);
                            break;
                        case 4:
                            mngr.ShowTheaterPlayList();
                            break;
                        case 5: 
                            mngr.saveToFileCSV("TheaterPlaysFile.csv");
                            System.out.println("Έξοδος...");
                            break;
                    }
                } 
                catch (NumberFormatException e) 
                {
                    System.out.println("Μη έγκυρη επιλογή.Επιλέξτε μεταξύ των αριθμών 1-5.");
                }
        } 
            while (choice != 5);
    }
}