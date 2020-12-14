/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesVarias;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Rolo
 */
public class Validadores {

    public Validadores() {
    }

    public String validarNombreApellido(String NomApe, int min, int max) {
        String resu="";
        NomApe=NomApe.trim().toUpperCase();
        
        if(NomApe.length() > min && NomApe.length() < max  ){
          if(!NomApe.contains("  "))
            resu=NomApe; 
        }
        if (resu=="") { 
            System.out.println("Debe Ingresar un Texto Valido ");
        }
        return resu;
    }    

    public String validarMail(String correo) {
        String resu="";
        correo = correo.trim();

        if( !correo.contains(" ")  ){
            if( (correo.length()> 6) && (correo.contains("@")))
                resu=correo; 
        }
        return resu;
    }

    public String validarPass(char pass1[], char pass2[]) {
        String passtxt1, passtxt2;
        String resu="";
    
        passtxt1=String.valueOf(pass1).trim();
        passtxt2=String.valueOf(pass2).trim();
        
        if( (passtxt1.length() > 7) && (passtxt1.length() < 21)){
            if( (passtxt1.equals(passtxt2)) && !(passtxt1.contains(" ") ) ) {
            resu=passtxt1; 
            }          
        }

        return resu;
    } 
//    Valida Numeros ...
//   str.matches("-?\\d+(\\.\\d+)?") para Numero, negativos (-) y Decimal (.)
    public boolean validarNumeros(String dato, int largo ){
    boolean resu=false;
    
      if(dato.matches("[0-9]*") && (dato.length() <= largo) ) 
         resu=true;
      
      return resu;  
    }
    
//    Valida Fecha ............... Retorna fecha valida o Null
    public String validarFecha(String fecha) {
        boolean resu=true;

        try{
        fecha = fecha.trim();
//        SimpleDateFormat fechaformato = new SimpleDateFormat("dd/MM/yyyy");
        
        SimpleDateFormat FecFormato = new SimpleDateFormat("dd/MM/yyyy");
        FecFormato.setLenient(false);

        String[] normali = fecha.split("/");
        if (normali.length == 3){
          if(normali[2].length() < 4)
            fecha=normali[0] + "/" + normali[1] + "/" + "19" + normali[2];
        
          FecFormato.parse(fecha);
        } else{
//           System.out.println("Debe ingresar una Fecha Valida: ");    
           fecha = "";
         }
        
        }
        catch (ParseException e){
         System.out.println("Debe ingresar una Fecha Valida: " + e);    
         fecha = "";
        }
        return fecha;
    }


//  Para  validar Mes - Dia - Año  Individualmente
    public boolean ValidoNumeroFecha(String dato, String tipo){
        boolean resu=false;
        int numero;
        
        try{
        numero =Integer.parseInt(dato);
        switch (tipo)
        {
           case "D" -> {
               if(numero >0 && numero < 31){
                 resu = true;  
               }       }
           case "M" -> {
               if(numero > 0 && numero < 13){
                 resu = true;  
               }
                }
           case "A" -> {
               if(numero > 1910 && numero < 2020 ){
                 resu = true;  
               }

           }
    } 
//        dato = dato.trim();
        }
        catch(NumberFormatException e){
         System.out.println("Debe ingresar un Numero Valido: " + e);    
        }
        return resu;
        
    }
    
//  Calcula edad segun la fecha introducida y retorna 0 si hay error.    
    public int CalculoEdad(String FechaNac) {
        int edad = 0;
        String mifecactu;        
        LocalDate FecActu = LocalDate.now();
        DateTimeFormatter formaFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        mifecactu = FecActu.format(formaFecha);
        String[] Arrfecactu = mifecactu.split("/");
        String[] Arrfecnac =  FechaNac.split("/");
        edad = Integer.parseInt(Arrfecactu[2]) - Integer.parseInt(Arrfecnac[2]);
        if(Integer.parseInt(Arrfecactu[1]) < Integer.parseInt(Arrfecactu[1])){
            edad = edad -1;
        } else if(Integer.parseInt(Arrfecactu[1]) == Integer.parseInt(Arrfecnac[1])){
            if(Integer.parseInt(Arrfecactu[0]) < Integer.parseInt(Arrfecnac[0])){
            edad = edad -1;
        }
        }
//            System.out.println("EL Dia es : " + Arrfecactu[0]);
     return edad;    
    }

    // Usado para Validar Rol: Usr - Admin
    public boolean ValidoValorOp(String tipoUs){
        //  Salida
        tipoUs = tipoUs.trim();
        if(tipoUs=="1"){
            return false;
        } else 
            return true;
    }
    
//   Grabo Archivo nuevo   ......................
    public boolean Grabo_Archivo(String ruta, String nombre, String[] lineas, int elem){
       boolean resu=false;
       int input=0;
       
       File archivo=new File(ruta+nombre); 

        if (archivo.exists()) {
           input = JOptionPane.showConfirmDialog(null, "El Archivo a Ingresar YA existe. Desea crearlo igualmente?","Seleccione una Opcion",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        // 0=yes, 1=no, 2=cancel
        }
        if(input==0){
            /**  ESCRITURA  **/
            FileWriter fichero = null;
            try {
		fichero = new FileWriter(ruta+nombre);
		// Escribo linea a linea en el fichero
		for (String linea : lineas) {
                    fichero.write(linea + "\n");
                }
//		fichero.close();
                resu=true;
            } catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Mensaje Error de la excepción: " + ex.getMessage());
            } finally {
                try {
                    if(fichero != null)
                        fichero.close();
                } catch (IOException ez) {
                    ez.printStackTrace();
                }
            }
        }   
       
        return resu;
    }  
    
//   Lectura de ARchivo  .............. 
//    Lectura de un archivo con clase FileReader lee caracteres, pero NO
//    puede leer linea completa. Para esto usamos la Clase BufferedReader
//    Otra forma es usando el Objeto Scanner, que es mas simple para 
//    Leer toda la fila completa.
    public String[] Leo_Archivo(String ruta, String nombre, int cantlin){
        boolean resu = false;
        Scanner arch = null;
        String[] todasLineas = new String[cantlin];
        int contador=0;
        
        File archivo=new File(ruta+nombre); 

        if (archivo.exists()) {
            try {
		// Leemos el contenido del Archivo
//		System.out.println("... Leemos el contenido del fichero ...");
		arch = new Scanner(archivo);
                // Leemos linea a linea el fichero
		while (arch.hasNextLine()) {
                    String linea = arch.nextLine(); // Guardamos la linea en un String
                    todasLineas[contador] = linea;  // Cargo linea en un array
                    contador++;
//                    System.out.println(linea);      // Imprimimos la linea .....
		}
                resu=true;
            } catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Mensaje Error de la excepción: " + ex.getMessage());
            } finally {
		// Cerramos el Archivo tanto si la lectura ha sido correcta o no
		try {
                    if (arch != null)
			arch.close();
		} catch (Exception ex2) {
                    JOptionPane.showMessageDialog(null, "Mensaje Error de la excepción: " + ex2.getMessage());
		}
            }                        
        } else{
            JOptionPane.showMessageDialog(null, "Archivo Inexistente. Verifique. " );
        }
        return todasLineas;
    }
    
    
}
