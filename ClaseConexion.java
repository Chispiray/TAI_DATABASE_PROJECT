/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xavier_school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClaseConexion {
    // Atributos de la clase ClaseConexion
    private static String user = "postgres"; //User de la BD
    private static String pswd = "123456"; //Password de la BD
    private static String bd = "xavierDb"; //Nombre de la BD
    private static String server = "jdbc:postgresql://localhost:5432/"+bd; //Llamando a nuestro server de BD
    private static String driver = "org.postgresql.Driver";//Driver que permite conectarse con PostgreSQL
    private static Connection con = null; //Para verificar la conexión

    // Metodo especial: constructor. Siempre tiene el mismo nombre que la clase
    public ClaseConexion() {
        try {
            Class.forName(driver);
            con = (Connection)DriverManager.getConnection(server, user, 
                            pswd);

            if(con != null) {
                    System.out.println("La conexión a la BD: "+ server +" "
                                    + "se realizo al 100%");
            }
        }
        catch(SQLException ex) {
            System.out.println("Error al intentar conectarse a la BD "+ server);
        }
        catch(ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }	

    public ResultSet getQuery(String query) {
        Statement state = null;
        ResultSet result = null;

        try {
            state=(Statement) con.createStatement();
            // esta línea es la que ejecuta la consulta SQL, representada por el parámetro "query"
            // por ejemplo, en un momento dado query = select * from clientes
            result=state.executeQuery(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // En este momento este método no se utiliza en ninguna parte del programa
    public void setQuery (String query) {
        Statement state = null;
        try {
            state = (Statement) con.createStatement();
            state.executeQuery(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}