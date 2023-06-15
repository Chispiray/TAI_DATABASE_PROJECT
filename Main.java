/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xavier_school;

import java.sql.ResultSet;
import java.sql.SQLException;


/*
En este caso para efectos demostrativos se coloca toda la lógica del programa
en el método main de la clase Main. Lo ideal (y más lógico) es que, por ejemplo,
los atributos ID, EDAD y NOMBRE pertenezcan a una clase que se llame Cliente. Es
decir, que exista coherencia entre lo que representa la clase (en este caso un
cliente) y lo que contiene (sus atributos y métodos). 
*/
public class Main {
    public static void main (String[] args) {
        
        // Creamos una instancia/objeto llamado conexion de la clase MiBD
        ClaseConexion conexion =  new ClaseConexion();
        
        // El conjunto de resultados (result set) que obtenemos
        // al ejecutar la consulta SQL (select)
        ResultSet result;
        
        // ¿Cómo pasamos de una tabla de PostgreSQL a una clase en Java?
        // A cada tabla de PostgreSQL le corresponde una clase en Java. Normalmente
        // el nombre de la tabla en una base de datos se encuentra en plural: Clientes,
        // Productos, Alumnos, etc. En Java, las clases se nombran en singular: Cliente.java,
        // Producto.java, Alumno.java, etc.
        
        // Ejemplo: supongamos que tenemos una tabla en PostgreSQL de la siguiente manera:
        // CREATE TABLE Alumnos (
        //      Matricula TEXT,
        //      Nombre TEXT,
        //      ApellidoPaterno TEXT,
        //      ApellidoMaterno TEXT,
        //      Edad INT,
        //      Efectivo NUMERIC
        // );
        
        // Su clase en Java se vería algo así:
        // public class Alumno {
        //      [public|private] String matricula;
        //      [public|private] String nombre;
        //      [public|private] String apellidoPaterno;
        //      [public|private] String apellidoMaterno;
        //      [public|private] int edad;
        //      [public|private] [double|float] efectivo;
        
        //      todos los métodos que quieran poner van aquí, incluidos los métodos
        //      especiales como el constructor, getters y setters
        // }
        
        // NOTA: la notación [A|B] significa que pueden poner A o B. Ejemplo:
        // [public|private] String matricula puede ser public String matricula o
        // private String matricula
        
        // atributos que contiene nuestro cliente
        int id, edad;
        String nombre;
        
        // conexion.getQuery() ejecuta el método getQuery que se encuentra en la
        // clase MiBD. El parámetro que le pasamos ("select * from clientes") es
        // la consulta SQL que ejecutamos en la base de datos y que nos proporciona
        // un conjunto de resultados (result set)
        result = conexion.getQuery("select * from alumnos");
        try {
            while(result.next()) {
                id = result.getInt("Id"); // si el dato que queremos obtener es INT, usamos getInt(nombreColumna)
                nombre = result.getString("Nombre"); // si el dato que queremos es texto, usamos getString(nombreColumna)
                edad = result.getInt("Edad");

                System.out.println ("\nID Maestro: " + id);
                System.out.println("Nombre Maestro: " +  nombre);
                System.out.println("Edad: " + edad);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

/*
NOTA: un metodo se declara de la siguiente manera:
public valorRetorno nombreMetodo (tipoDato parametro1, tipoDato parametro2, ...) {

}

El valor de retorno puede ser cualquier tipo de dato válido en Java: int, double,
float, String, boolean (true, false), etc.

El nombre del método, en teoría, puede ser cualquiera. La recomendación es que
el nombre del método sea acorde a lo que hace. No llamar resta() a una
función que realiza una suma, por ejemplo.

public int suma(int a, int b) {
    return a + b;
}

Es un método que realiza la suma de dos números enteros, muy parecido a C solo
que se añade el modififcador de acceso (public, private).

Los métodos deben ir siempre dentro de una clase.
*/