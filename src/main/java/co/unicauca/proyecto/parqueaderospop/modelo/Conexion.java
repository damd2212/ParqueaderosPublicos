package co.unicauca.proyecto.parqueaderospop.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
/*
En esta clase es donde se realiza la conexion con la base de datos en MYSQL
*/
public class Conexion {
       Connection con;//variable de tipo connection
   public Connection getConnection() // Metodo de tipo connection que realiza la conexion
  {
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");//trae el connector 
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parqueaderopopayan","root","usuario");//realizamos la conexión que tiene como parametros la URL,USUARIO Y CONTRASEÑA
       } catch (Exception e) {
           System.err.println("Error:" +e);
       }
           return con;
  }
}
