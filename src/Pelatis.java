package Pelatis;

/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alex
 */
/**
 * Κλάση που αναπαριστά έναν πελάτη με κωδικό και όνομα.
 */
public class Pelatis 
{
    private String id;      // ΚΩΔΙΚΟΣ ΠΕΛΑΤΗ
    private String name;    // ΟΝΟΜΑ ΠΕΛΑΤΗ

    
     /**
     * CONSTRUCTOR - Αρχικοποιεί τα πεδία του πελάτη όταν δημιουργείται το αντικείμενο.
     * @param id Κωδικός πελάτη
     * @param name Όνομα πελάτη
     */
    public Pelatis(String id, String name) 
    {
        this.id = id;
        this.name = name;
    }

    // GETTERS - Μέθοδοι για πρόσβαση στις τιμές των πεδίων
    /** @return Επιστρέφει τον κωδικό του πελάτη */
    public String getid() 
    { 
        return id; 
    }
    /** @return Επιστρέφει τον κωδικό του πελάτη */
    public String getname() 
    { 
        return name; 
    }

    // 
    /**
     * SETTERS - Μέθοδοι για των ορισμό των τιμών των πεδίων.
     * @param id Ο νέος κωδικός
     */
    public void setid(String id) 
    { 
        this.id = id; 
    }
    /**
     * Θέτει νέο όνομα πελάτη.
     * @param name Το νέο όνομα
     */
    public void setname(String name) 
    { 
        this.name = name; 
    }

    /** Εκτυπώνει τις πληροφορίες του πελάτη */ 
    public void printinfo() 
    {
        System.out.println("Κωδικός Πελάτη: " + id + "\n" + "Όνομα Πελάτη: " + name + "\n");
        System.out.println("-----------------------------");
        
    }
}

