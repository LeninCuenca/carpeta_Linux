package Semana1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author A S U S
 */
@Entity
public class Valores implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Basic
    String NombreHilo;
    int col1;
    int col2;
    int col3;
    int col4;

    public Valores() {
    }

    public Valores(int id, String NombreHilo, int col1, int col2, int col3, int col4) {
        this.id = id;
        this.NombreHilo = NombreHilo;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.col4 = col4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHilo() {
        return NombreHilo;
    }

    public void setNombreHilo(String NombreHilo) {
        this.NombreHilo = NombreHilo;
    }

    public int getCol1() {
        return col1;
    }

    public void setCol1(int col1) {
        this.col1 = col1;
    }

    public int getCol2() {
        return col2;
    }

    public void setCol2(int col2) {
        this.col2 = col2;
    }

    public int getCol3() {
        return col3;
    }

    public void setCol3(int col3) {
        this.col3 = col3;
    }

    public int getCol4() {
        return col4;
    }

    public void setCol4(int col4) {
        this.col4 = col4;
    }
    
    
}
