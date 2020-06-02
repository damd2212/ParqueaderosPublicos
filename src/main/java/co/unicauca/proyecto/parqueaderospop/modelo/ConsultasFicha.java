
package co.unicauca.proyecto.parqueaderospop.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *la clase consultasFicha nos sirve para para hacer la inserción de un objeto tipo Ficha a la base de datos en MYSQL
 *para ello extiende la clase conexión 
 */
public class ConsultasFicha extends Conexion{
    public boolean registrar(Ficha fi){//método que recibe el objeto Ficha que se insertara
          //variable para realizar transacciones a MySQL
        PreparedStatement ps = null;
        Connection con = getConnection();
        //consulta sql
        String sql = "INSERT INTO ficha (fiNumeroFicha,fiEstado,fiTipoVehiculo,fiHoraFechaEntrada) VALUES(?,?,?,?)";
        
        try{
           ps = con.prepareStatement(sql);
            // envio de datos
           ps.setInt(1,fi.getNumFicha());
           ps.setString(2,fi.getEstado());
           ps.setString(3,fi.getTipoVehiculo());
           ps.setString(4,fi.getHoraFechaEntrada());
           ps.execute();
           return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
