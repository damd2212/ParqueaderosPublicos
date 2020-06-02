/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyecto.parqueaderospop.modelo;

/**
 *esta clase nos ayuda a crear objetos de tipo ficha con los cuales podremos contabilizar el tiempo que estuvo el vehículo
 * en el parqueadero además de que tipo de vehículo es ,para esto contamos con cuatro atributos
 * NumFicha,Estado,TipoVehiculo,HoraFechaEntrada con sus respectivos getters y setters 
 * 
 */

public class Ficha {
    
    private int NumFicha;
    private String Estado;
    private String TipoVehiculo;
    private String HoraFechaEntrada;

    public int getNumFicha() {
        return NumFicha;
    }

    public void setNumFicha(int NumFicha) {
        this.NumFicha = NumFicha;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    public String getHoraFechaEntrada() {
        return HoraFechaEntrada;
    }

    public void setHoraFechaEntrada(String HoraFechaEntrada) {
        this.HoraFechaEntrada = HoraFechaEntrada;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Placa) {
        this.Estado = Placa;
    }
    
}
