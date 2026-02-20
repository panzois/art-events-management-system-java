package Reservation;


import Reservation.ReservationManager;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Η κλάση {@code ReservationMenu} είναι υπεύθυνη για την εμφάνιση και διαχείριση του μενού κρατήσεων
 * Παρέχει επιλογές στον χρήστη για να κάνει κράτηση σε παραστάσεις, να δει υπάρχουσες κρατήσεις και στατιστικά.
 */
public class ReservationMenu 
{
    private Scanner scanner;
    private ReservationManager resman;

    /**
     * Κατασκευαστής που αρχικοποιεί το μενού κρατήσεων με τον παρεχόμενο {@code ReservationManager}.
     *
     * @param resman Ο {@code ReservationManager} που χρησιμοποιείται για διαχείριση κρατήσεων.
     */
    public ReservationMenu(ReservationManager resman) 
    {
        scanner = new Scanner(System.in);      // Αρχικοποίηση του scanner
        this.resman = resman;
    }
    
    /**
     * Εμφανίζει το μενού κρατήσεων στον χρήστη και διαχειρίζεται τις επιλογές του.
     * @throws FileNotFoundException Αν προκύψει πρόβλημα σε λειτουργίες αρχείων στις μεθόδους του {@code ReservationManager}.
     */
    public void showMenu() throws FileNotFoundException 
    {
        
        int choice = -1;
            do 
            {
            
            System.out.println("\n===== MENU ΚΡΑΤΗΣΕΩΝ =====");
            System.out.println("[1] Κράτηση Θεατρικής Παράστασης");
            System.out.println("[2] Κράτηση Μουσικής Παράστασης");
            System.out.println("[3] Εμφάνιση όλων των Κρατήσεων");       
            System.out.println("[4] Στατιστικά Παραστάσεων");
            System.out.println("[5] Έξοδος");
            System.out.print("Επιλογή: ");
            
            String input = scanner.nextLine();

            
           try{ 
               
               choice = Integer.parseInt(input);  // ✔️ Μετατροπή string σε int
               if (choice < 0 || choice > 5) {
                   System.out.println("Μη έγκυρη επιλογή. Επιλέξτε έναν αριθμό από 1 έως 5.");
                   continue;
                }

               
            /** Ανάλογα με την επιλογή καλείται η αντίστοιχη μέθοδος. */
            switch (choice) 
            {
                case 1 -> resman.addTheaterReservation();
                case 2 -> resman.addMusicReservation();
                case 3 -> resman.showAllReservationsWithTitles();
                case 4 -> resman.showStatsPerPlay();
                case 5 -> System.out.println("Έξοδος από μενού κρατήσεων...");
                default -> System.out.println("Μη έγκυρη επιλογή.");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Μη έγκυρη επιλογή. Πληκτρολογήστε έναν αριθμό από 1 έως 5.");
        }
            
        } while (choice != 5); // Επανάληψη μέχρι ο χρήστης να επιλέξει έξοδο
        
    }

       
    
}
