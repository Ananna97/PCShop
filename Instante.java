/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instante;
import  magazinit.*;
import java.lang.*;
import java.util.*;

public class Instante {

    
    public static void main(String[] args) {
         
        
        
        Componenta[] x = new Componenta[5];
            //public Componenta(int cod_produs, int pret, String marca, int an_fabricatie, int garantie, String producator, String tara_provenienta, int stoc,String denumire,int cod)
            x[0] =  new Componenta(1001,2000,"ROG 980Ti",2004,70,"ROG ASUS","Anglia",200,"placa video",3);
           
            for(int i=0;i<1;i++)
            {
               x[i].afisarecomponenta();
            }
        
            
        
        
    }
    
}