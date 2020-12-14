/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesVarias;

/**
 *
 * @author Rolo
 */
public class ClaseEncuesta extends ClaseCliente {
    private int NivelAtenc, NivelResol, NivelRecom;

    public ClaseEncuesta(int NivelAtenc, int NivelResol, int NivelRecom, String Nombre, String Apellido, String Nro_Clie) {
        super(Nombre, Apellido, Nro_Clie);
        this.NivelAtenc = NivelAtenc;
        this.NivelResol = NivelResol;
        this.NivelRecom = NivelRecom;
    }

    public int getNivelAtenc() {
        return NivelAtenc;
    }

    public int getNivelResol() {
        return NivelResol;
    }

    public int getNivelRecom() {
        return NivelRecom;
    }

    public void setNivelAtenc(int NivelAtenc) {
        this.NivelAtenc = NivelAtenc;
    }

    public void setNivelResol(int NivelResol) {
        this.NivelResol = NivelResol;
    }

    public void setNivelRecom(int NivelRecom) {
        this.NivelRecom = NivelRecom;
    }
    
    public double promedio(int NivelAtencion, int NivelRecomendac, int NivelResoluc) {
      Double prome = (double)(NivelAtencion + NivelRecomendac + NivelResoluc );
      prome = (prome / 3);
      
    return prome;
    
    }
    
}
