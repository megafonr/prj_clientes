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
public class ClaseCliente {
    private String Nombre, Apellido, Nro_Clie;

    public ClaseCliente(String Nombre, String Apellido, String Nro_Clie) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Nro_Clie = Nro_Clie;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setNro_Clie(String Nro_Clie) {
        this.Nro_Clie = Nro_Clie;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getNro_Clie() {
        return Nro_Clie;
    }
    
    
    
}
