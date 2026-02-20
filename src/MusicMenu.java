package Music;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Κλάση που υλοποιεί το μενού διαχείρισης μουσικών παραστάσεων.
 * Ο χρήστης μπορεί να προσθέτει, διαγράφει, προβάλλει και αποθηκεύει παραστάσεις.
 */
public class MusicMenu {
    Scanner scnr = new Scanner(System.in);
    private MusicPerformanceManager mngr;

    public MusicMenu(MusicPerformanceManager mngr) 
    {
        this.mngr = mngr;
    }
    
    /**
     * Κατασκευαστής της κλάσης MusicMenu.
     * @throws java.io.FileNotFoundException
     */
    public void MusicMenu() throws FileNotFoundException {
        int choice = 0;
        do {
            System.out.println("\n--- ΔΙΑΧΕΙΡΙΣΗ ΜΟΥΣΙΚΩΝ ΠΑΡΑΣΤΑΣΕΩΝ ---");
            System.out.println("[1] Προσθήκη Παράστασης");
            System.out.println("[2] Επεξεργασία Παράστασης");
            System.out.println("[3] Διαγραφή Παράστασης");
            System.out.println("[4] Προβολή Όλων");
            System.out.println("[5] Αποθήκευση και Έξοδος!");
            System.out.print("\nΕπιλογή: ");
           
            String input = scnr.nextLine();

            if (!input.matches("[1-5]")) 
            {
                System.out.println("Μη έγκυρη επιλογή. Επιλέξτε μεταξύ των αριθμών 1-5.");
                continue;
            }
            choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    mngr.addPerformance();
                    break;
                case 2:
                    break;
                case 3:
                    mngr.deletePerformance();
                    break;
                case 4:
                    mngr.showMusicPerformanceList();
                    break;
                case 5:
                    mngr.saveToFileCSV("MusicPerformancesFile.csv");
                    break;
                default:
                    System.out.println("Μη έγκυρη επιλογή.Επιλέξτε μεταξύ των αριθμών 1-5.");
            }
        } while (choice != 5);
    }
}
