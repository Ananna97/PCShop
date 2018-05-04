package magazinit;


import java.lang.*;
import java.util.*;

public class Componenta extends categorie {
    int cod_produs, pret, garantie, stoc = 0, an_fabricatie; 
    String marca = new String("");
    String producator = new String("");
    String tara_provenienta = new String("");

     public Componenta() {
        super("",0);
        this.cod_produs = 0;
        this.pret = 0;
        this.marca ="";
        this.an_fabricatie = 0;
        this.garantie = 0;
        this.producator = "";
        this.tara_provenienta = ""; 
        this.stoc = 0;
    }
    

    public Componenta(int cod_produs, int pret, String marca, int an_fabricatie, int garantie, String producator, String tara_provenienta, int stoc,String denumire,int cod) {
        super(denumire,cod);
        this.cod_produs = cod_produs;
        this.pret = pret;
        this.marca = marca;
        this.an_fabricatie = an_fabricatie;
        this.garantie = garantie;
        this.producator = producator;
        this.tara_provenienta = tara_provenienta; 
        this.stoc = stoc;
    }

    public int getCod_produs() {
        return cod_produs;
    }

    public int getPret() {
        return pret;
    }

    public String getMarca() {
        return marca;
    }

    public int getGarantie() {
        return garantie;
    }

    public int getStoc() {
        return stoc;
    }

    public int getAn_fabricatie() {
        return an_fabricatie;
    }

    public String getProducator() {
        return producator;
    }

    public String getTara_provenienta() {
        return tara_provenienta;
    }

    @Override
    public String getDenumire() {
        return denumire;
    }

    @Override
    public int getCod() {
        return cod;
    }

    public void setCod_produs(int cod_produs) {
        this.cod_produs = cod_produs;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public void setAn_fabricatie(int an_fabricatie) {
        this.an_fabricatie = an_fabricatie;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public void setTara_provenienta(String tara_provenienta) {
        this.tara_provenienta = tara_provenienta;
    }

    @Override
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return  "Componenta{" + "cod_produs=" + cod_produs + ", pret=" + pret + ", marca=" + marca + ", garantie=" + garantie + ", stoc=" + stoc + ", an_fabricatie=" + an_fabricatie + ", producator=" + producator + ", tara_provenienta=" + tara_provenienta + ",denumire = " + denumire + ",cod = " + cod + "}";
    }

    public void afisarecomponenta()
    {
        System.out.println(toString() );
    }
   
    
  
}
