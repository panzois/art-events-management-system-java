import Reservation.ReservationMenu;
import Reservation.ReservationManager;
import Theater.TheaterPlayManager;
import Theater.TheaterMenu;
import Pelatis.PelatisMenu;
import Pelatis.PelatisManager;
import Music.MusicPerformanceManager;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panzois
 */

/**
 * Η κεντρική κλάση του προγράμματος που εμφανίζει το κύριο μενού της εφαρμογής 
 * και διαχειρίζεται τις βασικές λειτουργίες: θεατρικές και μουσικές παραστάσεις, 
 * πελάτες και κρατήσεις.
 * 
 * @author panzois
 */
public class MainApplicationMenu 
{
    /** Αντικείμενο Scanner για είσοδο δεδομένων από το χρήστη. */
    Scanner scnr = new Scanner (System.in);
    private TheaterPlayManager tpm;
    private PelatisManager pelman;
    private MusicPerformanceManager mpm;
    private ReservationManager rm;
    private ReservationMenu resmenu;
    private TheaterMenu mtm;
    /** Όνομα αρχείου CSV για παραστάσεις. */
    private final String FILE_NAME = "performances.csv";
    private PelatisMenu pm;
    
    /**
     * Κατασκευαστής της κλάσης που αρχικοποιεί όλους τους διαχειριστές και τα μενού.
     * Επίσης φορτώνει δεδομένα από αρχεία για παραστάσεις, πελάτες και κρατήσεις.
     *
     * @throws FileNotFoundException αν δεν βρεθούν τα αρχεία κατά τη φόρτωση
     */
    public MainApplicationMenu() throws FileNotFoundException  
    {
        // Αρχικοποίηση αντικειμένων διαχείρισης
        scnr = new Scanner(System.in);
        tpm = new TheaterPlayManager();
        pelman = new PelatisManager();
        mpm = new MusicPerformanceManager();
        rm = new ReservationManager(pelman, tpm, mpm); 
        resmenu = new ReservationMenu(rm);
        mtm = new TheaterMenu(tpm);
        pm = new PelatisMenu(pelman);
        
        // Φόρτωση Θεατρικών παραστάσεων 
        try 
        {
            tpm.loadFileCSV("TheaterPlaysFile.csv"); // Αυτόματη φόρτωση αρχείου
        } catch (FileNotFoundException e) {
            System.out.println("Δεν βρέθηκε αρχείο πελατών. Ξεκινάμε με κενή λίστα.");
        }
        
        // Φόρτωση Μουσικών παραστάσεων
        try {
            mpm.loadFileCSV(FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("Δεν βρέθηκε αρχείο δεδομένων. Ξεκινάμε με κενή λίστα.");
        }
        
        // Φόρτωση Πελατών
        
        try
        {
            pelman.loadFromCSV("customers.csv");
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Δεν βρέθηκε αρχείο δεδομένων. Ξεκινάμε με κενή λίστα.");
        }
        
        
        // Φόρτωση κρατήσεων θεάτρου
        
        try 
        {
            rm.loadTheaterReservations("TheaterReservations.csv");
        
        } 
        catch (Exception e) 
        {
            System.out.println("Δεν βρέθηκε αρχείο κρατήσεων. Ξεκινάμε με κενή λίστα.");
        }
        
        // Φόρτωση κρατήσεων μουσικών παραστάσεων
        try {
          rm.loadMusicReservations("MusicReservations.csv");
        }
        catch (Exception e){
          System.out.println("Δεν βρέθηκε αρχείο κρατήσεων. Ξεκινάμε με κενή λίστα.");
        }
    }
    
    /**
    * Εμφανίζει το Κεντρικό Μενού της εφαρμογής και διαχειρίζεται τις επιλογές του χρήστη.
    *
    * @throws FileNotFoundException αν υπάρξει πρόβλημα κατά την αποθήκευση ή φόρτωση δεδομένων
    */   
    public void KentrikoMenu () throws FileNotFoundException 
    {
        
        int choice = -1;
        do
        {
            System.out.println("\n--- ΚΕΝΤΡΙΚΟ ΜΕΝΟΥ ---");
            System.out.println("[1] Διαχείριση Θεατρικών Παραστάσεων");
            System.out.println("[2] Διαχείριση Μουσικών Παραστάσεων");
            System.out.println("[3] Διαχείριση Πελατών");
            System.out.println("[4] Διαχείριση Κρατήσεων");
            System.out.println("[5] Έξοδος");
            System.out.print("\nΕπιλογή: ");
            
            String input = scnr.nextLine();
            if (!input.matches("\\d+")) // Ελέγχει αν η είσοδος του χρήστη δεν είναι αριθμός.
            { 
               System.out.println("Μη έγκυρη επιλογή.Επιλέξτε μεταξύ των αριθμών 1-5.");
               continue;  
            }

            choice = Integer.parseInt(input);
            
            switch(choice)
            {
               case 1:
                    mtm.TheaterMenu();
                    break;
                case 2:
                    mpm.showMenu();
                    break;
                case 3:
                    pm.showPelatisMenu();  
                    break;
                case 4:
                    resmenu.showMenu();
                    break;
                case 5:
                    System.out.println("Καλή Συνέχεια...");
                    break;
                default:
                    System.out.println("Μη έγκυρη επιλογή.Επιλέξτε μεταξύ των αριθμών 1-5.");
            }
        } while (choice != 5);
    }
    
    /**
     * Η μέθοδος εκκίνησης του προγράμματος.
     *
     * @param args τα ορίσματα της γραμμής εντολών
     * @throws FileNotFoundException αν δεν βρεθούν τα απαιτούμενα αρχεία κατά την εκκίνηση
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        
        MainApplicationMenu mam = new MainApplicationMenu();
       
        mam.KentrikoMenu();
        
    }
     
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
