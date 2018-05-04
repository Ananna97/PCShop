
package magazinit;

import java.lang.*;
import java.util.*;

public class categorie {
    String denumire;
    int cod;

    public categorie() {
        this.denumire ="";
        this.cod = 0;
    }

    public categorie(String denumire, int cod) {
        this.denumire = denumire;
        this.cod = cod;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getCod() {
        return cod;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "categorie{" + "denumire=" + denumire + ", cod=" + cod + '}';
    }
    
    public void afisarecategorie(){
            System.out.println(toString() );
    }
    
}
