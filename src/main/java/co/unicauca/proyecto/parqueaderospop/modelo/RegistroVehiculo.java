
package co.unicauca.proyecto.parqueaderospop.modelo;

import java.sql.Date;

/**
 *esta clase nos ayuda a crear objetos de tipo RegistrarVehiculo con la cual vamos a poder guardar la 
 * información del vehículo que va entrar al parqueadero, para ello contaremos con los atributos 
 * regNumficha,regPlacaVehiculo,regTipoVehiculo,regHoraYFechaEntrada,regEstadoVehiculo,regLlaves,regNumCascos,regNitParqueadero,regNumCasillero
 * como también con sus respectivos getters y setters
 */

public class RegistroVehiculo {
    
    private int regNumFicha;
    private String regPlacaVehiculo;
    private String regTipoVehiculo;
    private String regHoraYFechaEntrada;
    private String regEstadoVehiculo;
    private String regLlaves;
    private int regNumCascos;
    private int regNitParqueadero;
    private int regNumCasillero;

    public int getRegNumFicha() {
        return regNumFicha;
    }

    public void setRegNumFicha(int regNumFicha) {
        this.regNumFicha = regNumFicha;
    }

    public String getRegPlacaVehiculo() {
        return regPlacaVehiculo;
    }

    public void setRegPlacaVehiculo(String regPlacaVehiculo) {
        this.regPlacaVehiculo = regPlacaVehiculo;
    }

    public String getRegTipoVehiculo() {
        return regTipoVehiculo;
    }

    public void setRegTipoVehiculo(String regTipoVehiculo) {
        this.regTipoVehiculo = regTipoVehiculo;
    }

    public String getRegHoraYFechaEntrada() {
        return regHoraYFechaEntrada;
    }

    public void setRegHoraYFechaEntrada(String regHoraYFechaEntrada) {
        this.regHoraYFechaEntrada = regHoraYFechaEntrada;
    }

    public String getRegEstadoVehiculo() {
        return regEstadoVehiculo;
    }

    public void setRegEstadoVehiculo(String regEstadoVehiculo) {
        this.regEstadoVehiculo = regEstadoVehiculo;
    }

    public String getRegLlaves() {
        return regLlaves;
    }

    public void setRegLlaves(String regLlaves) {
        this.regLlaves = regLlaves;
    }

    public int getRegNumCascos() {
        return regNumCascos;
    }

    public void setRegNumCascos(int regNumCascos) {
        this.regNumCascos = regNumCascos;
    }

    public int getRegNitParqueadero() {
        return regNitParqueadero;
    }

    public void setRegNitParqueadero(int regNitParqueadero) {
        this.regNitParqueadero = regNitParqueadero;
    }

    public int getRegNumCasillero() {
        return regNumCasillero;
    }

    public void setRegNumCasillero(int regNumCasillero) {
        this.regNumCasillero = regNumCasillero;
    }
}
