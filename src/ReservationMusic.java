package Reservation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author george
 */
public class ReservationMusic 
{
    private String idpelati; 
    private String codemusic; 

    public ReservationMusic(String idpelati, String codemusic) {
        this.idpelati = idpelati;
        this.codemusic = codemusic;
    }
 
    public String getIdpelati() 
    {
        return idpelati;
    }

    public String getCodemusic()
    {
        return codemusic;
    }

    /**OVERRIDE toString. 
     */
    @Override
    public String toString()
    {
        return "Κράτηση:" +"[1]Κωδικός Πελάτη:"+ idpelati +"[2] Αριθμός Μουσικής Παράστασης" + codemusic;
        
    }
   
}
