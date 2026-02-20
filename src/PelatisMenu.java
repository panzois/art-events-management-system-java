package Pelatis;


import Pelatis.PelatisManager;
import java.io.FileNotFoundException;
import java.util.Scanner; // Για ανάγνωση από το πληκτρολόγιο

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Alex
 */

/****Κύρια εφαρμογή που διαχειρίζεται το μενού και καλεί τις μεθόδους από τον ClientManager****/

/** Κύρια κλάση εφαρμογής - MENU ΠΕΛΑΤΩΝ. 
 */
public class PelatisMenu 
{
    private Scanner scanner;           // Για είσοδο από το χρήστη
    private PelatisManager manager;  // Αντικείμενο διαχείρισης πελατών
    
    
    /** CONSTRUCTOR: αρχικοποιεί το Scanner και τον PelatisManager.
     * @param manager
     */
    public PelatisMenu(PelatisManager manager) 
    {
        scanner = new Scanner(System.in);      // Αρχικοποίηση του scanner
        //manager = new PelatisManager();       // Δημιουργία διαχειριστή πελατών με ενδεικτικά στοιχεία
        this.manager = manager;
    }

    /** Εμφανίζει το μενού πελατών.
     * @throws java.io.FileNotFoundException
     */
    public void showPelatisMenu() throws FileNotFoundException {
    int choice = -1;

    do {
            System.out.println("\n===== MENU ΠΕΛΑΤΩΝ =====");
            System.out.println("[1] Προβολή όλων των πελατών");
            System.out.println("[2] Προσθήκη πελάτη");
            System.out.println("[3] Αναζήτηση πελάτη βάση ονόματος");
            System.out.println("[4] Επεξεργασία πελάτη βάση ονόματος");
            System.out.println("[5] Διαγραφή πελάτη");
            System.out.println("[6] Αποθήκευση & Έξοδος");
            System.out.print("Επιλογή: ");

            try 
            {
                choice = Integer.parseInt(scanner.nextLine()); // Μετατρέπει μια συμβολοσειρά (String) σε ακέραιο αριθμό (int).

                switch (choice) 
                {
                    case 1 -> manager.showAllPelates();
                    case 2 -> manager.addPelatiFromInput(scanner);
                    case 3 -> manager.searchPelatiFromInput(scanner);
                    case 4 -> manager.editPelatiFromInput(scanner);
                    case 5 -> manager.deletePelatiFromInput(scanner);
                    case 6 -> 
                            {
                               manager.saveToCSV("customers.csv");
                               System.out.println("Έξοδος...");
                            }
                    default -> System.out.println("Μη έγκυρη επιλογή. Επιλέξτε αριθμό από 1 έως 6.");
                }

            } 
            catch (NumberFormatException e) 
            {
            System.out.println("Μη έγκυρη επιλογή. Επιλέξτε αριθμό από 0 έως 6.");
            }
        } 
        while (choice != 6);
        }
}
        
        
        
        
    

    

    
    

