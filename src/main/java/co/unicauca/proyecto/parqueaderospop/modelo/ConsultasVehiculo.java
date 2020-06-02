/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyecto.parqueaderospop.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    
}
