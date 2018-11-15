/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.vistas;

import hotel.modelo.CamasHabitacion;
import hotel.modelo.CamasHabitacionData;
import hotel.modelo.Conexion;
import hotel.modelo.Habitacion;
import hotel.modelo.HabitacionData;
import hotel.modelo.Huesped;
import hotel.modelo.HuespedData;
import hotel.modelo.TipoCama;
import hotel.modelo.TipoCamaData;
import hotel.modelo.TipoHabitacion;
import hotel.modelo.TipoHabitacionData;

/**
 *
 * @author clara
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion;

        try {
            conexion = new Conexion();
            TestCase testCase;
            testCase = new TestCase(conexion);

            /**
             * *********** TEST HUESPEDES ***********
             */
            // Editar --
            //testCase.testHuespedEditar();
            
            // Listar huéspedes --
            //testCase.testHuespedesListar();

            // Is Huesped DNI
            //testCase.testIsHuespedDni();

            /**
             * *********** TEST HABITACIONES ***********
             */
            // Listar habitaciones --
            //testCase.testHabitacionesListar();

            // Listar por ID --
            //testCase.testHabitacionesListarPorId();

            // Listar por Tipo Habitacion --
            //testCase.testHabitacionesListarPorTipo();

            // Guardar --
            //testCase.testHabitacionesGuardar();
 
            // Editar --
            //testCase.testHabitacionesEditar();
            /**
             * *********** TEST CAMAS_HABITACIONES ***********
             */
            // la habitacion debe guardarse en la tabla habitacion antes de guardar en camasHabitacion
            //testCase.testCamasHabitacionGuardar();

            // Listar Camas de habitacion por Tipo
            //testCase.testCamasHabitacionListarPorTipo();

            // Listar Camas de habitacion por ID habitación
            //testCase.testObtenerCamasPorHabitacionId();
            /**
             * *********** TEST TIPOS DE CAMAS ***********
             */
            // Buscar camas por tipo
            // testCase.testBuscarTipoCamaPorId();

            /**
             *********TEST TIPO DE HABITACION *************
             */
            //Buscar tipo de habitacion por id
            // testCase.testBuscarTipoHabitacionPorId();

            /**
             * *********** TEST RESERVAS ***********
             */
            // Guardar Reserva
            //testCase.testReservaGuardar();
          
            // Verifica si hay registro para una habitacion en un periodo dado
             // testCase.testIsDisponibleEntreFecha();
            
            // Verifica si cambia estado 
            //testCase.testBuscaReservasAFinalizar();
            
            // Cambia estado para finalizar la misma
            //testCase.testFinReserva();
            
            // Lista reservas
            testCase.testListaReservas();
            
            // Lista reservas por id de huesped
            //testCase.testListaReservasPorIdHuesped();
            
          /////////////////////  
        } catch (Exception e) {
            System.out.println("Error al instanciar la clase conexion: " + e.getMessage());
        }
    }
    

}
