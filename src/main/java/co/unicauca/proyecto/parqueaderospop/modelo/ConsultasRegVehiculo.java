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
 *la clase consutlasRegVehiculo nos sirve para para hacer la inserción de un objeto tipo Registrovehículo a la base de datos en MYSQL
 *para ello extiende la clase conexión 
 */
public class ConsultasRegVehiculo extends Conexion{
    
    
    public boolean registrar(RegistroVehiculo regVehiculo){//método que recibe el objeto regVehiculo que se insertara
         //variable para realizar transacciones a MySQL
        PreparedStatement ps = null;
        Connection con = getConnection();
        //consulta sql
        String sql = "INSERT INTO registrarvehiculo (regNumFicha,regPlacaVehiculo,regTipoVehiculo,regHoraYFechaEntrada,regEstadoVehiculo,regLlaves,regNumCascos,regNitParqueadero,regNumCasillero) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
             // envio de datos 
            ps.setInt(1,regVehiculo.getRegNumFicha());
            ps.setString(2,regVehiculo.getRegPlacaVehiculo());
            ps.setString(3,regVehiculo.getRegTipoVehiculo());
            ps.setString(4,regVehiculo.getRegHoraYFechaEntrada());
            ps.setString(5,regVehiculo.getRegEstadoVehiculo());
            ps.setString(6,regVehiculo.getRegLlaves());
            ps.setInt(7,regVehiculo.getRegNumCascos());
            ps.setInt(8,regVehiculo.getRegNitParqueadero());
            ps.setInt(9,regVehiculo.getRegNumCasillero());
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
