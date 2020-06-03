/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyecto.parqueaderospop.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *la clase ConsultasVehiculo sirve para hacer la inserción de un objeto tipo vehículo a la base de datos
 * para ello extiende la clase conexión  
 */

public class ConsultasVehiculo extends Conexion {
    
    public boolean registrar(Vehiculo vehi){//método que recibe el objeto vehículo que se insertara
        //variable para realizar transacciones a MySQL
        PreparedStatement ps = null;
        Connection con = getConnection();
        
         //consulta sql
        String sql = "INSERT INTO vehiculo (placaVehiculo,tipoVehiculo) VALUES(?,?)";//realizamos consulta en este caso un insert
    
        try{
            ps = con.prepareStatement(sql);
            // envio de datos 
            ps.setString(1, vehi.getPlacaVehiculo());
            ps.setString(2, vehi.getTipoVehiculo());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch (SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public int buscar(Vehiculo vehi){
        int conteo = 0;
        PreparedStatement ps = null;
        Connection cone = getConnection();
        ResultSet rs;
        
        String sqlb = "SELECT count(*) FROM vehiculo WHERE  placaVehiculo = ?";
        
        try{
            ps = cone.prepareStatement(sqlb);
            ps.setString(1, vehi.getPlacaVehiculo());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                conteo = rs.getInt(1);
            }
            return conteo;
        }catch(SQLException e){
            System.err.println(e);
            return conteo;
        }finally{
            try{
                cone.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
               
    }
    
}
