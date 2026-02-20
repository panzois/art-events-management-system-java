package Pelatis;


import Pelatis.Pelatis;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */

/**
 * ΔΙΑΧΕΙΡΗΣΗ ΤΩΝ ΠΕΛΑΤΩΝ. 
 */
public class PelatisManager 
{
    private ArrayList <Pelatis> pelates;
    
    /** Δημιουργεί τον διαχειριστή και προσθέτει ενδεικτικούς πελάτες */
    public PelatisManager() // CONSTRUCTOR
    {
         
        pelates = new ArrayList<>();
        
        /*loadFromCSV("customers.csv");
        //app.manager.testdata();

        Runtime.getRuntime().addShutdownHook
            (new Thread(() -> 
            {
                saveToCSV("customers.csv");
            }));*/
        
        
    }
    
    /** @return Επιστρέφει τη λίστα όλων των πελατών. */
    public ArrayList <Pelatis> getAllPelates() 
    {
        return pelates;
    }
    
     /**
     * Προσθέτει πελάτη αν ο κωδικός είναι μοναδικός.
     * @param id Κωδικός πελάτη
     * @param name Όνομα πελάτη
     * @return true αν προστέθηκε, false αν υπάρχει ήδη
     */
    public boolean addPelati(String id, String name) 
    {
        for (Pelatis p : pelates) 
        {
            if (p.getid().equalsIgnoreCase(id)) 
            {
                System.out.println("Ο Kωδικός Yπάρχει ήδη !!!!");
                return false; // Αν υπάρχει ήδη ο κωδικός, δεν επιτρέπεται η προσθήκη
            }
            
        }
        pelates.add(new Pelatis(id, name));
        return true;
    }
    // ΑΛΛΟΣ ΤΡΟΠΟΣ ΜΕ FOR i
    /* public boolean addPelati(String id, String name) {
    for (int i = 0; i < pelates.size(); i++) {
        Pelatis p = pelates.get(i);
        if (p.getid().equalsIgnoreCase(id)) {
            return false; // Αν υπάρχει ήδη ο κωδικός, δεν επιτρέπεται η προσθήκη
        }
    }
    pelates.add(new Pelatis(id, name));
    return true;
} */
    
    /**Εύρεση Ψάχνωντας μόνο το όνομα.
     * @param partialName.
     * @return 
     */
    public List<Pelatis> findAllByPartialName(String partialName) 
    {
        List<Pelatis> matching = new ArrayList<>();
        for (Pelatis p : pelates) 
        {
          if (p.getname().toLowerCase().contains(partialName.toLowerCase())) 
            {
                 matching.add(p);
            }
        }
    return matching;
}
    
    /**
     * Αναζητά πελάτη με βάση το όνομα.
     * @param name Όνομα πελάτη
     * @return Το αντικείμενο Pelatis ή null αν δεν βρέθηκε
     */
    public Pelatis findByName(String name) 
    {
        for (Pelatis c : pelates) 
        {
            if (c.getname().equalsIgnoreCase(name)) // Συγκρίνει ανεξάρτητα από πεζά/κεφαλαία
            {
                return c;
            }
        }
        return null; // Δεν βρέθηκε πελάτης
    }
    
    /**
     * Επεξεργάζεται το όνομα του πελάτη.
     * @param oldName Παλαιό όνομα
     * @param newName Νέο όνομα
     * @return true αν ενημερώθηκε, false αν δεν βρέθηκε
     */
    public boolean editPelati(String oldName, String newName) 
    {
        Pelatis p = findByName(oldName);
        if (p != null) 
        {
            p.setname(newName);
            return true;
        }
        return false; // Αν δεν βρέθηκε πελάτης
    }
    
    /**
     * Διαγράφει πελάτη με βάση το όνομα.
     * @param name Το όνομα του πελάτη προς διαγραφή
     * @return true αν διαγράφηκε, false αν δεν βρέθηκε
     */
    public boolean deletePelati(String name) 
    {
        Pelatis c = findByName(name);
        if (c != null) 
        {
            pelates.remove(c);
            return true;
        }
        return false;
    }
    
    /** Εμφανίζει όλους τους πελάτες. */
    public void showAllPelates() 
    {
        if (pelates.isEmpty()) 
        {
            System.out.println("Δεν υπάρχουν πελάτες.");
        }
        else 
        {
            for (Pelatis c : pelates) 
            {
                c.printinfo();
            }
        }
    }
    //======================================================================
    /**
     * Διαβάζει από το πληκτρολόγιο και προσθέτει πελάτη.
     * @param input Scanner για είσοδο χρήστη
     */
    public void addPelatiFromInput(Scanner input) 
    {
        System.out.print("Κωδικός πελάτη πχ.(P0002): ");
        String id = input.nextLine();
        
        /** ΕΛΕΓΧΟΣ ΜΕ REGULAR - EXPRESSION (REGEX).
         */
        if(!id.matches("^P\\d{4}$"))
        {
            System.out.println("Μη έγκυρη μορφή. Πρέπει να ξεκινά με 'P' και να έχει 4 ψηφία π.χ. P0001.");
            return;
        }
        int i;
        for(i = 0; i < pelates.size(); i++)
        {
           if(pelates.get(i).getid().equals(id))
            {
                System.out.println("O Κωδικός Υπάρχει ήδη !!!!!");
                return;
            } 
        }
                
        
        System.out.print("Όνομα: ");
        String name = input.nextLine();

        if (addPelati(id, name)) 
        {
            System.out.println("Ο πελάτης προστέθηκε.");
        } 
        
    }
    
    /**
     * Διαβάζει από το πληκτρολόγιο και εμφανίζει πελάτη.
     * @param input 
     * Scanner για είσοδο χρήστη
     */
    public void searchPelatiFromInput(Scanner input) 
    {
        System.out.print("Εισάγετε όνομα πελάτη: ");
        String partial = input.nextLine();
        List<Pelatis> results = findAllByPartialName(partial);
        if (results.isEmpty()) 
        {
            System.out.println("Δεν βρέθηκε πελάτης.");
        } 
        else 
        {
            System.out.println("Βρέθηκαν οι παρακάτω πελάτες:");
            for(Pelatis p : results)
            {
                p.printinfo();
            }
        }
    }
  
    /**
     * Επεξεργασία πελάτη μέσω πληκτρολογίου.
     * @param input Scanner για είσοδο χρήστη
     */
    public void editPelatiFromInput(Scanner input) 
    {
        try 
        {
            System.out.print("Εισάγετε μέρος ή πλήρες όνομα πελάτη προς επεξεργασία: ");
            String partialOnoma = input.nextLine();

            // Βρες όλους τους πελάτες που ταιριάζουν με το όνομα
            List<Pelatis> matchingPelates = findAllByPartialName(partialOnoma);

            if (matchingPelates.isEmpty()) 
            {
                System.out.println("Δεν βρέθηκε κανένας πελάτης με αυτό το όνομα.");
                return;
            }

            // Αν υπάρχει μόνο ένας, πάμε κατευθείαν σε επεξεργασία
            Pelatis pelatisToEdit = null;
            if (matchingPelates.size() == 1) 
            {
                pelatisToEdit = matchingPelates.get(0);
            } 
            else 
            {
                System.out.println("Βρέθηκαν παραπάνω από ένα Ονόματα:");
                for (int i = 0; i < matchingPelates.size(); i++) 
                {
                    System.out.println("[" + i + "] " + matchingPelates.get(i).getid() + " - " + matchingPelates.get(i).getname());
                }

                System.out.print("Επιλέξτε αριθμό πελάτη για επεξεργασία: ");
                int index = Integer.parseInt(input.nextLine());

                if (index < 0 || index >= matchingPelates.size()) 
                {
                    System.out.println("Μη έγκυρη επιλογή.");
                    return;
                }

                pelatisToEdit = matchingPelates.get(index);
            }

                System.out.print("Εισάγετε το νέο όνομα για τον πελάτη \"" + pelatisToEdit.getname() + "\": ");
                String newName = input.nextLine();

                pelatisToEdit.setname(newName);
                System.out.println("Ο πελάτης ενημερώθηκε με επιτυχία.");

        } 
            catch (Exception e) 
            {
                System.out.println("Σφάλμα κατά την επεξεργασία πελάτη: " + e.getMessage() + "Επιλέξτε μεταξύ [0],[1],[2]....[]");
            }
    }
    
    
    public void deletePelatiFromInput(Scanner input) 
    {
        
        System.out.print("Εισάγετε μέρος ή πλήρες όνομα πελάτη για διαγραφή: ");
        String nameQuery = input.nextLine();

        List<Pelatis> found = findAllByPartialName(nameQuery);

        if (found.isEmpty()) 
        {
            
            System.out.println("Δεν βρέθηκε πελάτης με αυτό το όνομα.");
        } 
        else if (found.size() == 1) 
        {
            
            Pelatis pelatis = found.get(0);
            System.out.println("Διαγραφή πελάτη: " + pelatis.getid() + " - " + pelatis.getname());
            pelates.remove(pelatis);
            System.out.println("Ο πελάτης διαγράφηκε.");
        } 
        else 
        {
            
            System.out.println("Βρέθηκαν πολλοί πελάτες:");
            for (int i = 0; i < found.size(); i++) 
            {
                System.out.println("[" + i + "] " + found.get(i).getid() + " - " + found.get(i).getname());
            }

            System.out.print("Επιλέξτε αριθμό πελάτη για διαγραφή: ");
            try 
            {
                int index = Integer.parseInt(input.nextLine());
                if (index >= 0 && index < found.size()) 
                {
                    
                    Pelatis pelatis = found.get(index);
                    pelates.remove(pelatis);
                    System.out.println("Ο πελάτης διαγράφηκε: " + pelatis.getid() + " - " + pelatis.getname());
                } 
                else 
                {
                    System.out.println(" Μη έγκυρη επιλογή αριθμού.");
                }
            } 
            catch (NumberFormatException ex) 
            {
                System.out.println("Σφάλμα: Πρέπει να εισάγετε αριθμό επιλογής [0],[1],[2]......[].");
            }
        }
}

    
     /**
     * Αποθηκεύει όλους τους πελάτες σε αρχείο CSV.
     * @param filename Το όνομα του αρχείου CSV
     */
    public void saveToCSV(String arxeio) throws FileNotFoundException 
    {
        try 
        {
            String FileLocation = new File(arxeio).getAbsolutePath();
            
            PrintWriter pw = new PrintWriter (FileLocation);
            {
                for (Pelatis c : pelates) 
                {
                    pw.println(c.getid() + ";" + c.getname());
                }
            }
            pw.close();
            
            System.out.println("Οι πελάτες αποθηκεύτηκαν στο αρχείο " + FileLocation);
            System.out.println("Επιτυχής Αποθήκευση.....");
            
        }
           catch (FileNotFoundException exc)  
        {
        
        System.out.println("Δεν ήταν δυνατή η αποθήκευση του αρχείου.");
        throw exc;   
        } 
    }
    
     /**
     * Φορτώνει πελάτες από αρχείο CSV και τους προσθέτει στη λίστα.
     * @param arxeio
     * @throws java.io.FileNotFoundException
     */
    public void loadFromCSV(String arxeio) throws FileNotFoundException 
    {

        try
        {
            String FileLocation = new File(arxeio).getAbsolutePath(); 
            File file = new File(FileLocation);
            
            if (!file.exists()) 
            {
            System.out.println("Το αρχείο δεν βρέθηκε! Ξεκινάμε με κενή λίστα.");
            return;
            }
            
            
            pelates.clear(); // katharizei to arraylist pelates PRIN FORTWSEI TA KAINOURIA, AMA DEN YPARXEI MPOREI NA TA FORTOSEI DUO FORES
            
            String id;
            String name;
          
            
     
            Scanner scan = new Scanner (new File (FileLocation));
            scan.useDelimiter (";|\\n");
            while (scan.hasNext ())
            {
                id  = scan.next().trim();
                name = scan.next().trim();
                Pelatis p = new Pelatis(id,name);
                pelates.add(p);
            }
            scan.close();
            System.out.println("Check!...Αρχείο Φορτώθηκε από: " + FileLocation);
           
           
        }
        catch (FileNotFoundException ex)
        {
            
            System.out.println("Πρόβλημα κατά τη φόρτωση αρχείου: " + ex.getMessage());
        } 
    }
    
    
    /**Μέθοδος boolean για την αναζήτηση πελάτη
     * @param kwdikos
     * @return 
     */
    public boolean pelatisExists(String kwdikos)
    {
       for (Pelatis pelatis: pelates ) 
       {
           if(pelatis.getid().equals(kwdikos))
           {
               return true;
           }
       
       } 
      return false;
    }
    
}
