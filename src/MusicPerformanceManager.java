package Music;

import Music.MusicPerformance;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * Η κλάση {@code MusicPerformanceManager} παρέχει λειτουργίες διαχείρισης μουσικών παραστάσεων.
 * Περιλαμβάνει δυνατότητες για καταχώρηση, επεξεργασία, διαγραφή, εμφάνιση, αποθήκευση
 * και ανάκτηση παραστάσεων από αρχείο CSV.
 */
public class MusicPerformanceManager 
{
    private ArrayList<MusicPerformance> performances;
    private Scanner scanner;
    private final String FILE_NAME = "performances.csv";
    
    /**
     * Κατασκευαστής της κλάσης, Αρχικοποιεί τη λίστα παραστάσεων και τον scanner.
     */
    public MusicPerformanceManager() 
    {
        performances = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Κατασκευαστής της κλάσης. Αρχικοποιεί τη λίστα παραστάσεων και τον scanner.
     */
    public void showMenu() 
    {
        while (true) 
        {
            System.out.println("\n--- ΔΙΑΧΕΊΡΗΣΗ ΜΟΥΣΙΚΩΝ ΠΑΡΑΣΤΑΣΕΩΝ ---");
            System.out.println("1. Προσθήκη μουσικής παράστασης");
            System.out.println("2. Επεξεργασία μουσικής παράστασης");
            System.out.println("3. Διαγραφή μουσικής παράστασης");
            System.out.println("4. Εμφάνιση μουσικών παραστάσεων");
            System.out.println("5. Αποθήκευση και Έξοδος");
            System.out.print("Επιλογή: ");

            String choice = scanner.nextLine();
            switch (choice) 
            {
                case "1": addPerformance(); break;
                case "2": editPerformance(); break;
                case "3": deletePerformance(); break;
                case "4": showMusicPerformanceList(); break;
                case "5":
                    try 
                    {
                        saveToFileCSV(FILE_NAME);
                    } 
                    catch (FileNotFoundException e) 
                    {
                        System.out.println("Σφάλμα στην αποθήκευση: " + e.getMessage());
                    }
                    return;
                default:
                    System.out.println("Μη έγκυρη επιλογή. Επιλέξτε μεταξύ των αριθμών 1-5.");
            }
        }
    }
    
    /**
     * Προσθέτει μια νέα μουσική παράσταση στη λίστα, αφού πρώτα γίνει έλεγχος εγκυρότητας του κωδικού και της ημερομηνίας.
     */
    public void addPerformance() 
    {
        System.out.println("\nΚαταχωρίστε τα νέα στοιχεία: \n");

        String code;
        while (true) 
        {
            System.out.print("Κωδικός (Ο κωδικός πρέπει να ξεκινά με 'M'(λατινικό) και να έχει συνολικά 5 χαρακτήρες (π.χ. M0001): ");
            code = scanner.nextLine().trim();

            if (code.matches("^M\\d{4}$")) 
            {
                if (!FindCode(code)) 
                {
                    break;
                } 
                else 
                {
                    System.out.println("Υπάρχει ήδη παράσταση με αυτόν τον κωδικό. Δοκιμάστε ξανά.");
                }
            } 
            else 
            {
                System.out.println("Λάθος καταχώρηση. Ο κωδικός πρέπει να ξεκινά με 'M'(λατινικό) και να έχει συνολικά 5 χαρακτήρες (π.χ. M0001).");
            }
        }

        System.out.print("Τίτλος: ");
        String title = scanner.nextLine();

        System.out.print("Τραγουδιστής: ");
        String singer = scanner.nextLine();

        System.out.print("Χώρος: ");
        String venue = scanner.nextLine();

        LocalDate date;
        while (true) {
            System.out.print("Ημερομηνία (yyyy-MM-dd): ");
            try {
                date = LocalDate.parse(scanner.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Λάθος μορφή ημερομηνίας. Δοκιμάστε ξανά.");
            }
        }

        MusicPerformance mp = new MusicPerformance(code, title, singer, venue, date.toString());
        performances.add(mp);
        System.out.println("Επιτυχής καταχώρηση παράστασης. Πατήστε 5 για να αποθηκευτεί.");
    }
    
    /**
     * Επεξεργάζεται μια υπάρχουσα μουσική παράσταση που εντοπίζεται βάσει κωδικού.
     * Αν δεν βρεθεί, εμφανίζει κατάλληλο μήνυμα.
     */
    public void editPerformance() 
    {
        System.out.print("Κωδικός Παράστασης για Επεξεργασία (π.χ. M0001): ");
        String code = scanner.nextLine().trim();

        MusicPerformance p = findByCode(code);
        if (p == null) 
        {
            System.out.println("Δεν βρέθηκε παράσταση με τον κωδικό: " + code);
            return;
        }

        System.out.print("Νέος Τίτλος: ");
        p.setTitle(scanner.nextLine());

        System.out.print("Νέος Τραγουδιστής: ");
        p.setSinger(scanner.nextLine());

        System.out.print("Νέος Χώρος: ");
        p.setVenue(scanner.nextLine());

        LocalDate newDate;
        while (true) 
        {
            System.out.print("Νέα Ημερομηνία (yyyy-MM-dd): ");
            try {
                newDate = LocalDate.parse(scanner.nextLine().trim());
                break;
            } 
            catch (Exception e) 
            {
                System.out.println("Λάθος μορφή ημερομηνίας.");
            }
        }
        p.setDate(newDate);
        System.out.println("Επιτυχής ενημέρωση.");
    }
    
    /**
     * Διαγράφει μια μουσική παράσταση βάσει του κωδικού της.
     * Γίνεται πρώτα έλεγχος εγκυρότητας της μορφής του κωδικού.
     */
    public void deletePerformance() 
    {
        System.out.print("Κωδικός προς διαγραφή (π.χ. M0001): ");
        String code = scanner.nextLine().trim();
        if (!Pattern.matches("[Mm]\\d{4}", code)) 
        {
            System.out.println("Μη έγκυρη μορφή κωδικού.");
            return;
        }

        MusicPerformance mp = findByCode(code);
        if (mp == null) 
        {
            System.out.println("Δεν βρέθηκε παράσταση με αυτόν τον κωδικό.");
            return;
        }

        performances.remove(mp);
        System.out.println("Η παράσταση διαγράφηκε.");
    }
    
    /**
     * Εμφανίζει όλες τις αποθηκευμένες μουσικές παραστάσεις στην κονσόλα.
     * Αν δεν υπάρχουν, εμφανίζει κατάλληλο μήνυμα.
     */
    public void showMusicPerformanceList() 
    {
        if (performances.isEmpty()) {
            System.out.println("Δεν υπάρχουν παραστάσεις.");
            return;
        }

        for (MusicPerformance mp : performances) 
        {
            mp.fullPrint();
            System.out.println("---------------------------");
        }
    }
    
    /**
     * Επιστρέφει ένα αντικείμενο {@code MusicPerformance} βάσει του κωδικού του.
     *
     * @param code Ο κωδικός της παράστασης προς αναζήτηση.
     * @return Αντικείμενο {@code MusicPerformance} αν βρεθεί, αλλιώς {@code null}.
     */
    public MusicPerformance findByCode(String code) 
    {
        for (MusicPerformance mp : performances) 
        {
            if (mp.getCode().equalsIgnoreCase(code)) return mp;
        }
        return null;
    }
    
    /**
     * Ελέγχει αν υπάρχει ήδη παράσταση με τον συγκεκριμένο κωδικό.
     *
     * @param codeStr Ο κωδικός προς έλεγχο.
     * @return {@code true} αν υπάρχει ήδη, αλλιώς {@code false}.
     */
    public boolean FindCode(String codeStr) 
    {
        return findByCode(codeStr) != null;
    }
    
    /**
     * Αποθηκεύει τις μουσικές παραστάσεις σε αρχείο CSV.
     *
     * @param arxeio Το όνομα του αρχείου στο οποίο θα αποθηκευτούν.
     * @throws FileNotFoundException Αν το αρχείο δεν είναι προσβάσιμο.
     */
    public void saveToFileCSV(String arxeio) throws FileNotFoundException 
    {
        try 
        {
            PrintWriter pw = new PrintWriter(new File(arxeio).getAbsolutePath());
            for (MusicPerformance p : performances) 
            {
                pw.print(p.getCode() + ";");
                pw.print(p.getTitle() + ";");
                pw.print(p.getSinger() + ";");
                pw.print(p.getVenue() + ";");
                pw.println(p.getDateString());
            }
            pw.close();
            System.out.println("Αποθήκευση επιτυχής στο: performances.csv");
            System.out.println("\nΕπιστροφή στο κεντρικό μενού!");
            System.out.println("Έξοδος...");
        } 
        catch (FileNotFoundException e) 
        {
            throw e;
        }
    }
    
    /**
     * Φορτώνει μουσικές παραστάσεις από αρχείο CSV και τις αποθηκεύει στη λίστα.
     *
     * @param arxeio Το όνομα του αρχείου από το οποίο θα γίνει η φόρτωση.
     * @throws FileNotFoundException Αν το αρχείο δεν εντοπιστεί.
     */
    public void loadFileCSV(String arxeio) throws FileNotFoundException 
    {
        try 
        {
            String FileLocation = new File(arxeio).getAbsolutePath(); //!!!! για να παρουμε το path του αρχειου!!!
            File file = new File(FileLocation);
            
            if (!file.exists()) 
            {
                System.out.println("Το αρχείο δεν βρέθηκε! Ξεκινάμε με κενή λίστα.");
                return;
            }

            performances.clear(); //καθαριζει την λιστα για να μην κανει διπλοεγγραφες!!!!!

            Scanner scan = new Scanner (new File (FileLocation));
            scan.useDelimiter(";|\\n");
            while (scan.hasNext()) {
                String code = scan.next().trim();
                String title = scan.next().trim();
                String singer = scan.next().trim();
                String venue = scan.next().trim();
                String dateStr = scan.next().trim();

                LocalDate.parse(dateStr); // validate
                MusicPerformance p = new MusicPerformance(code, title, singer, venue, dateStr);
                performances.add(p);
            }
            scan.close();
            System.out.println("Check!...Αρχείο φορτώθηκε από: " + FileLocation);
        } 
        catch (Exception e) 
        {
            System.out.println("Σφάλμα κατά την ανάγνωση του αρχείου: " + e.getMessage());
        }
    }
    
    /**
     * Ελέγχει αν υπάρχει μουσική παράσταση με δοθέντα κωδικό.
     *
     * @param idParastasis Ο κωδικός της παράστασης.
     * @return {@code true} αν βρεθεί, αλλιώς {@code false}.
     */
    public boolean FindCodeMusic(String idParastasis) 
    {
        return FindCode(idParastasis);
    }

    /**
     * Επιστρέφει τη λίστα όλων των μουσικών παραστάσεων.
     *
     * @return Λίστα παραστάσεων τύπου {@code ArrayList<MusicPerformance>}.
     */
    public ArrayList<MusicPerformance> getMusicPerformances() 
    {
        return performances;
    }
}
