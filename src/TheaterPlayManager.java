package Theater;


import Theater.TheaterPlay;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panzois
 */
/** ΚΛΑΣΗ THEATER PLAY. */
public class TheaterPlayManager 
{
    private ArrayList<TheaterPlay> plays;
    
    /** CONSTRUCTOR THEATER PLAY. */
    public TheaterPlayManager ()
    {
        plays = new ArrayList<>();
        
    }
    /** ΕΠΙΛΟΓΗ ΠΑΡΑΣΤΑΣΗΣ
     * @param scan */
public void addPlay(Scanner scan) {
    System.out.println("\nΚαταχωρίστε τα νέα στοιχεία: \n");
    
    String kwdikos1;
    while (true) {
        System.out.print("Κωδικός (Ο κωδικός πρέπει να ξεκινά με 'T'(λατινικό) και να έχει συνολικά 5 χαρακτήρες (π.χ. T0001): ");
        kwdikos1 = scan.nextLine();
        if (kwdikos1.length() == 5 && kwdikos1.startsWith("T")) {
            if (!FindCode(kwdikos1)) {
                break; // Έγκυρος και μοναδικός κωδικός -> βγαίνουμε από το loop
            } else {
                System.out.println("Υπάρχει ήδη παράσταση με αυτόν τον κωδικό. Δοκιμάστε ξανά.");
            }
        } else {
            System.out.println("Λάθος καταχώρηση.");
        }
    }
    
    System.out.print("Τίτλος: ");
    String titlos = scan.nextLine();
    System.out.print("Πρωταγωνιστής: ");
    String ithopoios = scan.nextLine();
    System.out.print("Χώρος: ");
    String xwros = scan.nextLine();
    
    LocalDate imerominia;
    while (true) {
        System.out.print("Ημερομηνία (yyyy-MM-dd): ");
        try {
            imerominia = LocalDate.parse(scan.nextLine());
            break; // Έγκυρη ημερομηνία -> βγαίνουμε από το loop
        } catch (Exception x) {
            System.out.println("Λάθος μορφή ημερομηνίας. Προσπάθησε ξανά.");
        }
    }
    
    TheaterPlay parastasi = new TheaterPlay(kwdikos1, titlos, ithopoios, xwros, imerominia);
    plays.add(parastasi);
    System.out.println("\nΕπιτυχής καταχώρηση παράστασης. Πατήστε 5 για να αποθηκευτεί.");
}

    
    /** ΕΠΙΛΟΓΗ 2Η.
     * @param scnr */
     public void editPlay(Scanner scnr) // ΓΙΑ ΕΠΙΛΟΓΗ 2
{
    System.out.print("Κωδικός Παράστασης για Επεξεργασία (Ο κωδικός πρέπει να ξεκινά με 'T' και να έχει συνολικά 5 χαρακτήρες π.χ. T0001): ");
    String kwdikos2 = scnr.nextLine();

    for (int i = 0; i < plays.size(); i++)
    {
        if (plays.get(i).getCode().equals(kwdikos2))
        {
            System.out.print("Νέος Τίτλος: ");
            String neosTitlos = scnr.nextLine();
            plays.get(i).setTitle(neosTitlos);

            System.out.print("Νέος Πρωταγωνιστής: ");
            String neosIthopoios = scnr.nextLine();
            plays.get(i).setLeadActor(neosIthopoios);

            System.out.print("Νέος Χώρος: ");
            String neosXwros = scnr.nextLine();
            plays.get(i).setVenue(neosXwros);

            LocalDate neaMera;
            while (true)
            {
                System.out.print("Ημερομηνία (yyyy-MM-dd): ");
                String inputDate = scnr.nextLine();
                try
                {
                    neaMera = LocalDate.parse(inputDate);
                    break;
                }
                catch (Exception ex)
                {
                    System.out.println("Λάθος μορφή ημερομηνίας. Προσπάθησε ξανά.");
                }
            }
            plays.get(i).setDate(neaMera);

            System.out.println("Επιτυχής ενημέρωση.");
            return;
        }
    }

    System.out.println("\nΔεν βρέθηκε παράσταση με τον κωδικό: " + kwdikos2);
}

    /**ΔΙΑΓΡΑΦΗ ΕΡΓΟΥ.
     * @param scn */
    public void deletePlay (Scanner scn) // ΓΙΑ ΕΠΙΛΟΓΗ 3
    {
        System.out.print("Κωδικός Παράστασης για Διαγραφή: ");
        String kwdikos3 = scn.nextLine();
        int i;
        for (i=0; i<plays.size();i++)
        {
            if (plays.get(i).getCode().equals(kwdikos3))
            {
                plays.remove(i);
                System.out.println("Παράσταση διαγράφηκε επιτυχώς!");
                return; //gia diagrafi mias kataxwrisis se periptwsi poy uparxoyn kai alles
            }
        }
        
        System.out.println("Δεν βρέθηκε παράσταση με τον κωδικό: " + kwdikos3);
       
        
    }
    /** ΕΜΦΑΝΙΣΗ ΠΑΡΑΣΤΑΣΕΩΝ. */
    public void ShowTheaterPlayList() 
    {
        if (plays.isEmpty()) 
        {
            System.out.println("\nΚαμία καταχωρημένη θεατρική παράσταση.");
        } 
        else 
        {
            plays.sort(Comparator.comparing(TheaterPlay::getCode)); // ταξινόμηση κατά αύξοντα αριθμό στην λιστα τον παραστασεων!!!!
            System.out.println("\nΚαταχωρημένες Θεατρικές Παραστάσεις:");
            for (TheaterPlay p : plays) 
                p.fullPrintTheaterPlayinfo();
        }   
    } 
    /** ΑΠΟΘΗΚΕΥΣΗ ΣΕ ΑΡΧΕΙΟ CSV.
     * @param arxeio
     * @throws java.io.FileNotFoundException */
    public void saveToFileCSV (String arxeio) throws FileNotFoundException
    {
        try
        {   
            String FileLocation = new File(arxeio).getAbsolutePath();
            PrintWriter pw = new PrintWriter (FileLocation);
            {
                for (TheaterPlay p: plays)
                {
                pw.print (p.getCode() + ";");
                pw.print (p.getTitle() + ";");
                pw.print (p.getLeadActor() + ";");
                pw.print (p.getVenue() + ";");
                pw.println (p.getDate());
                }
            }
            pw.close();
            System.out.println("Αποθήκευση επιτυχής στο: TheaterPlaysFile.csv");
            System.out.println("\nΕπιστροφή στο κεντρικό μενού!");

        }       
        catch (FileNotFoundException exc)  
        {
        
        System.out.println("Δεν ήταν δυνατή η αποθήκευση του αρχείου.");
        throw exc;   
        } 
        
    }
    /** ΦΟΡΤΩΣΗ ΑΠΟ ΑΡΧΕΙΟ CSV.
     * @param arxeio
     * @throws java.io.FileNotFoundException */
    public void loadFileCSV (String arxeio) throws FileNotFoundException
    {
        try
        {
            String FileLocation = new File(arxeio).getAbsolutePath();
            File file = new File(FileLocation);



            
            if (!file.exists()) 
            {
            System.out.println("Το αρχείο δεν βρέθηκε!!!!!!!! Ξεκινάμε με κενή λίστα.");
            return;
            }

            plays.clear(); //!!!!! katharizei to arraylist prin fortosei 
            
            String kwdikos;
            String titlos;
            String protagonistis;
            String xwros;
            LocalDate imerominia;
            Scanner scan = new Scanner (new File (FileLocation));
            scan.useDelimiter (";|\\n");
            while (scan.hasNext ())
            {
                kwdikos  = scan.next().trim();
                titlos = scan.next().trim();
                protagonistis = scan.next().trim();
                xwros = scan.next().trim();
                imerominia = LocalDate.parse(scan.next().trim()); // edo prosoxi!!! xwris ta trim den ta emfanizei swsta
                TheaterPlay p = new TheaterPlay(kwdikos, titlos, protagonistis, xwros, imerominia);
                plays.add(p);
            }
            scan.close();
            System.out.println("Check!...Αρχείο φορτώθηκε από: " + FileLocation);
        }
        catch (FileNotFoundException ex)
        {
            
            System.out.println("Πρόβλημα κατά τη φόρτωση αρχείου: " + ex.getMessage());
        } 
    }
    
    /** ΕΥΡΕΣΗ ΚΩΔΙΚΟΥ.
     * @param idParastasis
     * @return  */
    public boolean FindCode (String idParastasis) //methodos gia reservationmanager gia euresi kwdikou theatrikis parastasis
    {

        for (TheaterPlay tp : plays)
        
        {
            if (tp.getCode().equals(idParastasis))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * ΔΙΝΕΙ ΤΗΝ ΛΙΣΤΑ ΤΩΝ ΘΕΑΤΡΙΚΩΝ ΠΑΡΑΣΤΑΣΕΩΝ ΣΤΟ reservation manager
     * @return
     */
    public ArrayList<TheaterPlay> getPlays() {
        return plays;
    }
}