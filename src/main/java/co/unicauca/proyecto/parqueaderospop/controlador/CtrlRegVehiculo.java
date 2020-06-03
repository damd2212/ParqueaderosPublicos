/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.proyecto.parqueaderospop.controlador;

//Se importan las cclases necesarias para el funcionamiento de la aplicacion

import co.unicauca.proyecto.parqueaderospop.modelo.ConsultasFicha;
import co.unicauca.proyecto.parqueaderospop.modelo.ConsultasRegVehiculo;
import co.unicauca.proyecto.parqueaderospop.modelo.ConsultasVehiculo;
import co.unicauca.proyecto.parqueaderospop.modelo.Ficha;
import co.unicauca.proyecto.parqueaderospop.modelo.RegistroVehiculo;
import co.unicauca.proyecto.parqueaderospop.modelo.Vehiculo;
import co.unicauca.proyecto.parqueaderospop.vistas.GUIRegistrarVehiculo;
//import co.unicauca.proyecto.parqueaderospop.vistas.GUIPaginaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author danny
 */


// En la clase controlador se ejecutan las consultas o metodos utilizados en las clses de consulta y ademas 
//se obtienen los datos que se ingresaron en la vista creada
public class CtrlRegVehiculo implements ActionListener {
    
    //Atributos de la clase    
    private RegistroVehiculo regVehi;
    private ConsultasRegVehiculo conRegVehi;
    private Vehiculo vehi;
    private ConsultasVehiculo conVehi;
    private Ficha fi;
    private ConsultasFicha conFi;
    private GUIRegistrarVehiculo frmRegVehi;
    
    //En el controlador se inicializan los atributos de la clase controlado
    public CtrlRegVehiculo(RegistroVehiculo regVehi,ConsultasRegVehiculo conRegVehi,Vehiculo vehi,ConsultasVehiculo conVehi,Ficha fi,ConsultasFicha conFi,GUIRegistrarVehiculo frmRegVehi){
        this.regVehi = regVehi;
        this.conRegVehi = conRegVehi;
        this.vehi = vehi;
        this.conVehi = conVehi;
        this.fi = fi;
        this.conFi = conFi;
        this.frmRegVehi = frmRegVehi;
        this.frmRegVehi.btnGuardar.addActionListener(this);
    }
    //Con este metodo se le da un titulo a la vista y ademos se restablecce lo localizacion
    public void iniciar(){
        frmRegVehi.setTitle("Vehiculo");
        frmRegVehi.setLocationRelativeTo(null);
    }
    //Como se menciono al comienzo de esta clase se obtienen los datos de las vistas y se ejecutan las consultas
    // cabe aclarar que con el metodo getSource se obtiene la accion que se esta realizando con el boton, ademas,
    //se validaran las casillas vacias y los datos ingresados, los cuales se les pasaran a los atributos de las 
    //clases a las que le pertenezcan. En este metodo se tienen en cuenta los botones Guardar y Vicunlar o ingresar 
    //donde estos botones ayudaran para que se haga una insercion a la tabla correspondiente en el sistema, teniendo en cuenta que si ocurre algun fallo 
    //el sistema lo va a notificar mediante un mensaje de error
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == frmRegVehi.btnGuardar) {
            if (frmRegVehi.jtxtFNumFicha.getText().isEmpty() || frmRegVehi.jtxtFPlaca.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo Numero de ficha o el campo placa no pueden estar vacios");
            }else{
                
                vehi.setPlacaVehiculo(frmRegVehi.jtxtFPlaca.getText());
                vehi.setTipoVehiculo(frmRegVehi.jcmbTipoVehiculo.getSelectedItem().toString());
                regVehi.setRegNumFicha(Integer.parseInt(frmRegVehi.jtxtFNumFicha.getText()));
                regVehi.setRegPlacaVehiculo(frmRegVehi.jtxtFPlaca.getText());
                regVehi.setRegTipoVehiculo(frmRegVehi.jcmbTipoVehiculo.getSelectedItem().toString());
                regVehi.setRegHoraYFechaEntrada(frmRegVehi.jtxtFHoraFecha.getText());
                regVehi.setRegEstadoVehiculo("Entrado");
                if (frmRegVehi.jchbLlaves.isSelected()) {
                    regVehi.setRegLlaves("Si");
                }else{
                    regVehi.setRegLlaves("No");
                }
                regVehi.setRegNumCascos(Integer.parseInt(frmRegVehi.jcmbNumCascos.getSelectedItem().toString()));
                regVehi.setRegNitParqueadero(1);
                if (frmRegVehi.jtxtFCasillero.getText() == null) {
                    regVehi.setRegNumCasillero(Integer.parseInt(null));
                }
                
                if (conVehi.buscar(vehi) == 0) {
                    conVehi.registrar(vehi);
                }
                
                if (conRegVehi.registrar(regVehi)){
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                    limpiar();
                }else{
                    JOptionPane.showMessageDialog(null, "Registro NO guardado");
                }   
            }          
        }

    }
    
    
    //Con este metodo despues de que se inserten los datos en la base de datos
    //se limpiaran las casillas de la vista 
    public void limpiar(){
        
        frmRegVehi.jtxtFNumFicha.setText(null);
        frmRegVehi.jtxtFPlaca.setText(null);
        frmRegVehi.jcmbTipoVehiculo.setSelectedItem("Carro");
        frmRegVehi.jcmbNumCascos.setSelectedItem("0");
        
        Date date =  new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");  
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        frmRegVehi.jtxtFHoraFecha.setText(hourFormat.format(date)+"  "+dateFormat.format(date));
       
        frmRegVehi.jchbLlaves.setSelected(false);
        frmRegVehi.jtxtFCasillero.setText(null);
    }
}
