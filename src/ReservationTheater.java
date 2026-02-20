package Reservation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panzois
 */
/** Κλάση Κρατήσεων. 
 */
public class ReservationTheater 
{
    private String id; // Αριθμός Πελάτη
    private String code; // Αριθμός Θεατρικής Παράστασης
    
    /** CONSTRUCTION Κρατήσεων
     * @param id.
     * @param code 
     */
    public ReservationTheater(String id,String code) 
    {
        this.id = id;
        
        this.code = code;       
    }
    
    /**SETTER
     * @return 
     */
    public String getId() 
    {
        return id;
    }
    
    /** GETTER CODE.
     * @return  
     */
    public String getCode() {
        return code;
    }
    
    /**OVERRIDE toString. 
     */
    @Override
    public String toString()
    {
        return "Κράτηση:" +"[1]Κωδικός Πελάτη:"+ id +"[2] Αριθμός θεατρικής Παράστασης" + code;
        
    }
   
}



