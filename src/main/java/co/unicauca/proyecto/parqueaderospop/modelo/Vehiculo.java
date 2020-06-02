/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyecto.parqueaderospop.modelo;

/**
 *
 *esta clase nos ayuda a crear objetos de tipo vehículo para guardar un registro de los vehículos que han entrado al parqueadero 
 *estos objetos contaran con dos atributos placaVehiculo y tipoVehiculo, como también con sus respectivos getters y setters 
 */

public class Vehiculo {
    private String placaVehiculo;
    private String tipoVehiculo;

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
