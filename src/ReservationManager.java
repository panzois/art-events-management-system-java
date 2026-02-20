package Reservation;

import Theater.TheaterPlayManager;
import Theater.TheaterPlay;
import Pelatis.PelatisManager;
import Music.MusicPerformanceManager;
import Music.MusicPerformance;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Η κλάση {@code ReservationManager} διαχειρίζεται τις κρατήσεις θεατρικών και μουσικών παραστάσεων
 * συνδέοντας πελάτες με παραστάσεις. Παρέχει λειτουργίες δημιουργίας, προβολής, αποθήκευσης και φόρτωσης κρατήσεων.
 * 
 * Υποστηρίζει ξεχωριστές λίστες για κρατήσεις θεάτρου και μουσικής.
 * Συνδέεται με τις κλάσεις {@code PelatisManager}, {@code TheaterPlayManager}, και {@code MusicPerformanceManager}.
 */
public class ReservationManager 
{
    private ArrayList<ReservationTheater> theaterRes;
    private ArrayList<ReservationMusic> musicRes;
    Scanner scan = new Scanner(System.in);
    private PelatisManager pm;
    private TheaterPlayManager tpm;
    private MusicPerformanceManager mpm;

    /**
     * Κατασκευαστής του {@code ReservationManager}.
     * 
     * @param pm  Αντικείμενο για διαχείριση πελατών.
     * @param tpm Αντικείμενο για διαχείριση θεατρικών παραστάσεων.
     * @param mpm Αντικείμενο για διαχείριση μουσικών παραστάσεων.
     */
    public ReservationManager(PelatisManager pm, TheaterPlayManager tpm, MusicPerformanceManager mpm) 
    {
        this.theaterRes = new ArrayList<>();
        this.musicRes = new ArrayList<>();
        this.pm = pm;
        this.tpm = tpm;
        this.mpm = mpm;
    }

    /**
     * Δημιουργεί νέα κράτηση για θεατρική παράσταση, εφόσον ο πελάτης και η παράσταση υπάρχουν
     * και δεν υπάρχει ήδη η ίδια κράτηση.
     * 
     * @throws FileNotFoundException αν υπάρχει πρόβλημα κατά την αποθήκευση.
     */
    public void addTheaterReservation() throws FileNotFoundException 
    {
        System.out.println("\n--- Δημιουργία Κράτησης Θεατρικής Παράστασης ---");
        System.out.print("Δώσε Κωδικό Πελάτη: ");
        String kwdikospelati = scan.nextLine();

        if (!pm.pelatisExists(kwdikospelati)) 
        {
            System.out.println("Ο πελάτης δεν υπάρχει.");
            return;
        }

        System.out.print("Δώσε Κωδικό Παράστασης (π.χ. T0001): ");
        String theatercode = scan.nextLine();

        for (ReservationTheater r : theaterRes) 
        {
            if (r.getId().equals(kwdikospelati) && r.getCode().equals(theatercode)) 
            {
                System.out.println("Υπάρχει ήδη αυτή η κράτηση!");
                return;
            }
        }

        if (tpm.FindCode(theatercode)) 
        {
            theaterRes.add(new ReservationTheater(kwdikospelati, theatercode));
            System.out.println("Η κράτηση δημιουργήθηκε: " + kwdikospelati + " - " + theatercode);
            saveTheaterReservations("TheaterReservations.csv");
        } 
        else 
        {
            System.out.println("Η παράσταση δεν βρέθηκε.");
        }

        
    }

    /** Δημιουργία κράτησης μουσικής παράστασης
     * @throws java.io.FileNotFoundException */
    public void addMusicReservation() throws FileNotFoundException 
    {
        System.out.println("\n--- Δημιουργία Κράτησης Μουσικής Παράστασης ---");
        System.out.print("Δώσε Κωδικό Πελάτη: ");
        String kwdikospelati = scan.nextLine();

        if (!pm.pelatisExists(kwdikospelati)) 
        {
            System.out.println("Ο πελάτης δεν υπάρχει.");
            return;
        }

        System.out.print("Δώσε Κωδικό Παράστασης (π.χ. M0001): ");
        String musicCode = scan.nextLine();

        for (ReservationMusic r : musicRes) 
        {
            if (r.getIdpelati().equals(kwdikospelati) && r.getCodemusic().equals(musicCode)) 
            {
                System.out.println("Υπάρχει ήδη αυτή η κράτηση!");
                return;
            }
        }

        if (mpm.FindCodeMusic(musicCode))
        {
            musicRes.add(new ReservationMusic(kwdikospelati, musicCode));
            System.out.println("Η μουσική κράτηση δημιουργήθηκε: " + kwdikospelati + " - " + musicCode); 
            saveMusicReservations("MusicReservations.csv");
        } 
        else 
        {
            System.out.println("Η παράσταση δεν βρέθηκε.");
        }

        
    }

    /**
     * Προβάλλει όλες τις κρατήσεις που υπάρχουν, τόσο θεατρικές όσο και μουσικές.
     * Αν η παράσταση έχει διαγραφεί, εμφανίζει σχετικό μήνυμα.
     */
    public void showAllReservationsWithTitles() 
    {
        if (theaterRes.isEmpty() && musicRes.isEmpty())
        {
            System.out.println("Δεν υπάρχουν κρατήσεις.");
            return;
        }

        System.out.println("\n-- Όλες οι Κρατήσεις --");

        for (ReservationTheater r : theaterRes) 
        {
            String title = " Η παράσταση διαγράφηκε από την λίστα "; //!!!!!! προς αλλαγη!!!!!!!
            for (TheaterPlay p : tpm.getPlays()) 
            {
                if (p.getCode().equals(r.getCode())) 
                {
                    title = p.getTitle();
                    break;
                }
            }
            System.out.println("Πελάτης [" + r.getId() + "] -> Θεατρική Παράσταση [" + r.getCode() + " - " + title + "]");
        }
        
        for (ReservationMusic resm : musicRes) 
        {
            String titlos = " Η παράσταση διαγράφηκε από την λίστα "; ////// προς αλλαγη!!!!!!!!!
            for (MusicPerformance mousikiparastasi : mpm.getMusicPerformances()) 
            {
                if (mousikiparastasi.getCode().equals(resm.getCodemusic())) 
                {
                    titlos = mousikiparastasi.getTitle();
                    break;
                }
            }
            System.out.println("Πελάτης [" + resm.getIdpelati() + "] -> Μουσική Παράσταση [" + resm.getCodemusic() + " - " + titlos + "]");
        }
    }

    /**
     * Υπολογίζει και εμφανίζει πόσες κρατήσεις έχουν γίνει ανά θεατρική ή μουσική παράσταση.
     */
    public void showStatsPerPlay() 
    {
        System.out.println("\n-- Στατιστικά Κρατήσεων --");

        for (TheaterPlay p : tpm.getPlays()) 
        {
            int count = 0;
            for (ReservationTheater r : theaterRes) 
            {
                if (r.getCode().equals(p.getCode())) 
                {
                    count++;
                }
            }
            if (count > 0) 
            {
                System.out.println("Θεατρική Παράσταση [" + p.getCode() + " - " + p.getTitle() + "]: " + count + " κρατήσεις");
            }
        }
        
        
        for (MusicPerformance mp : mpm.getMusicPerformances()) 
        {
            int count = 0;
            for (ReservationMusic rm : musicRes) 
            {
                if (rm.getCodemusic().equals(mp.getCode())) 
                {
                    count++;
                }
            }
            if (count > 0) 
            {
                System.out.println("Moυσική Παράσταση [" + mp.getCode() + " - " + mp.getTitle() + "]: " + count + " κρατήσεις");
            }
        }
        
    }

    /** Αποθήκευση κρατήσεων θεάτρου
     * @param arxeio 
     */
    public void saveTheaterReservations(String arxeio) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arxeio))) {
            for (ReservationTheater r : theaterRes) {
                pw.println(r.getId() + ";" + r.getCode());
            }
            System.out.println("Οι θεατρικές κρατήσεις αποθηκεύτηκαν.");
        } catch (Exception e) {
            System.out.println("Σφάλμα αποθήκευσης: " + e.getMessage());
        }
    }

    /** Αποθήκευση κρατήσεων μουσικής
     * @param arxeio 
     */
    public void saveMusicReservations(String arxeio) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arxeio))) {
            for (ReservationMusic r : musicRes) {
                pw.println(r.getIdpelati() + ";" + r.getCodemusic());
            }
            System.out.println("Οι μουσικές κρατήσεις αποθηκεύτηκαν.");
        } catch (Exception e) {
            System.out.println("Σφάλμα αποθήκευσης μουσικών κρατήσεων: " + e.getMessage());
        }
    }

    /** Φόρτωση κρατήσεων θεάτρου
     * @param arxeio 
     */
    public void loadTheaterReservations(String arxeio) {
        try {
            theaterRes.clear();
            String FileLocation = new File(arxeio).getAbsolutePath();
            File file = new File(FileLocation);
            if (!file.exists()) return;

            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(";|\\n");

            while (scanner.hasNext()) {
                String id = scanner.next().trim();
                String code = scanner.next().trim();
                theaterRes.add(new ReservationTheater(id, code));
            }
        
            scanner.close();
            System.out.println("Check!...Αρχείο φορτώθηκε από: " + FileLocation);
        } catch (FileNotFoundException e) {
            System.out.println("Σφάλμα κατά τη φόρτωση: " + e.getMessage());
        }
    }

    /** Φόρτωση κρατήσεων μουσικής
     * @param arxeio 
     */
    public void loadMusicReservations(String arxeio) {
        try {
            musicRes.clear();
            String FileLocation = new File(arxeio).getAbsolutePath();
            File file = new File(FileLocation);
            if (!file.exists()) return;

            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(";|\\n");

            while (scanner.hasNext()) {
                String id = scanner.next().trim();
                String code = scanner.next().trim();
                musicRes.add(new ReservationMusic(id, code));
            }

            scanner.close();
            System.out.println("Check!...Αρχείο φορτώθηκε από: " + FileLocation);        
        } catch (FileNotFoundException e) {
            System.out.println("Σφάλμα κατά τη φόρτωση μουσικών κρατήσεων: " + e.getMessage());
        }
    }
}
