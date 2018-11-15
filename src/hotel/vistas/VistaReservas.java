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
import hotel.modelo.Reservas;
import hotel.modelo.ReservasData;
import hotel.modelo.TipoCama;
import hotel.modelo.TipoCamaData;
import hotel.modelo.TipoHabitacion;
import hotel.modelo.TipoHabitacionData;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clara
 */
public class VistaReservas extends javax.swing.JInternalFrame {

    private Conexion conexion;
    private ReservasData reservasData;
    private HabitacionData habitacionData;
    private HuespedData huespedData;
    private TipoHabitacionData tipoHabitacionData;
    private TipoCamaData tipoCamaData;
    private CamasHabitacionData camasHabitacionData;
    private ArrayList<Huesped> listaHuesped;
    private ArrayList<TipoHabitacion> listaTiposHabitaciones;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<CamasHabitacion> listaCamasHabitacion;
    private DefaultTableModel model;

    /**
     * Creates new form VistaReservas
     */
    public VistaReservas() {
        initComponents();
        try {
            conexion = new Conexion();
            model = new DefaultTableModel();

            reservasData = new ReservasData(conexion);
            huespedData = new HuespedData(conexion);
            habitacionData = new HabitacionData(conexion);
            tipoHabitacionData = new TipoHabitacionData(conexion);
            camasHabitacionData = new CamasHabitacionData(conexion);
            tipoCamaData = new TipoCamaData(conexion);

            // Obtiene los huespedes 
            listaHuesped = (ArrayList) huespedData.obtenerHuespedes();
            
            // Obtiene los tipos de habitaciones
            listaTiposHabitaciones = (ArrayList) tipoHabitacionData.obtenerTipoHabitacion();

            // Obtiene Habitaciones
            listaHabitaciones = (ArrayList) habitacionData.obtenerHabitaciones();

            // Se Cargan los ComboBox
            cargaHuespedes();
            cargarCantidadPersonas();
            cargaTipoHabitacion();

            // Set calendario
            setConfiguracionJDateChooser();

            // Se Cargan las habitaciones
            headersTablaHabitaciones();
            cargaDatosHabitaciones();
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        texttitleHacerReserva = new javax.swing.JLabel();
        textHacerReservaHuesped = new javax.swing.JLabel();
        HacerReservaReservar = new javax.swing.JButton();
        HacerReservaLimpiar = new javax.swing.JButton();
        textHacerReservaFechaInicio = new javax.swing.JLabel();
        textHacerReservaFechaFin = new javax.swing.JLabel();
        hacerReservaFechaInicio = new com.toedter.calendar.JDateChooser();
        hacerReservaFechaFin = new com.toedter.calendar.JDateChooser();
        textHacerReservaPersonas = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        hacerReservaTipos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        hacerReservaHabitaciones = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        textHacerReservaMontoSigno = new javax.swing.JLabel();
        montoTotalAPagar = new javax.swing.JLabel();
        hacerReservaHuesped = new javax.swing.JComboBox<>();
        textHacerReservaTipos = new javax.swing.JLabel();
        hacerReservaPersonas = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        precio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reservaDias = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("CANTIDAD PERSONAS");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        texttitleHacerReserva.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        texttitleHacerReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/vistas/resources/star.png"))); // NOI18N
        texttitleHacerReserva.setText("HACER UNA RESERVA");

        textHacerReservaHuesped.setText("SELECCIONE UN HUESPED");

        HacerReservaReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/vistas/resources/add.png"))); // NOI18N
        HacerReservaReservar.setText("GUARDAR RESERVAR ");
        HacerReservaReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HacerReservaReservarActionPerformed(evt);
            }
        });

        HacerReservaLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/vistas/resources/escoba.png"))); // NOI18N
        HacerReservaLimpiar.setText("REINICIAR");
        HacerReservaLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HacerReservaLimpiarActionPerformed(evt);
            }
        });

        textHacerReservaFechaInicio.setText("FECHA INICIO");

        textHacerReservaFechaFin.setText("FECHA FIN");

        hacerReservaFechaFin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                hacerReservaFechaFinPropertyChange(evt);
            }
        });

        textHacerReservaPersonas.setText("CANTIDAD DE PERSONAS");

        hacerReservaTipos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hacerReservaTiposItemStateChanged(evt);
            }
        });

        hacerReservaHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        hacerReservaHabitaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        hacerReservaHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hacerReservaHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hacerReservaHabitaciones);

        textHacerReservaMontoSigno.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        textHacerReservaMontoSigno.setText("$");

        montoTotalAPagar.setBackground(new java.awt.Color(255, 204, 255));
        montoTotalAPagar.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        montoTotalAPagar.setText(" ");

        textHacerReservaTipos.setText("TIPO HABITACIÓN");

        hacerReservaPersonas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hacerReservaPersonasItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("NÚMERO DE DÍAS:");

        reservaDias.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        reservaDias.setText(" ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 102));
        jLabel1.setText("MONTO TOTAL A PAGAR:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1)
                .addGap(723, 723, 723))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textHacerReservaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(hacerReservaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textHacerReservaMontoSigno, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(montoTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HacerReservaLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HacerReservaReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textHacerReservaPersonas)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(precio)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(hacerReservaPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(reservaDias, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addComponent(texttitleHacerReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textHacerReservaFechaInicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hacerReservaFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textHacerReservaFechaFin)
                                .addGap(18, 18, 18)
                                .addComponent(hacerReservaFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textHacerReservaHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hacerReservaHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(texttitleHacerReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hacerReservaHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHacerReservaHuesped))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hacerReservaFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textHacerReservaFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(hacerReservaFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHacerReservaFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reservaDias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textHacerReservaPersonas)
                        .addComponent(hacerReservaPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textHacerReservaMontoSigno)
                    .addComponent(hacerReservaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHacerReservaTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montoTotalAPagar))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HacerReservaLimpiar)
                    .addComponent(HacerReservaReservar))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hacerReservaTiposItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hacerReservaTiposItemStateChanged
    // Muestra habitacione según tipo selecciona en comboBox
        cargaDatosHabitaciones();
    }//GEN-LAST:event_hacerReservaTiposItemStateChanged

    private void HacerReservaReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HacerReservaReservarActionPerformed

        //Crear y cargar el objeto reserva para poder guardar
        if (hacerReservaHabitaciones.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, hacerReservaHabitaciones.getSelectedRow() + " Debe seleccionar una habitación ");
        } else if (hacerReservaPersonas.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, hacerReservaHabitaciones.getSelectedRow() + " Debe seleccionar cantidad de huéspedes ");
        } else {
            Reservas reserva;
            reserva = new Reservas();

            Habitacion habitacion;
            habitacion = new Habitacion();
            habitacion = habitacionData.buscarHabitacion((int) hacerReservaHabitaciones.getValueAt(hacerReservaHabitaciones.getSelectedRow(), 0));
            habitacion.setHabitacionEstado(false);

            reserva.setHabitacionId(habitacion);
            reserva.setReservasDias(Integer.parseInt(reservaDias.getText()));
            reserva.setReservasFechaCheckin(formatearFecha(hacerReservaFechaInicio.getDate()));
            reserva.setReservasfechaCheckout(formatearFecha(hacerReservaFechaFin.getDate()));
            Calendar toDay = new GregorianCalendar();
            reserva.setReservasFechaCreacion(formatearFecha(toDay.getTime()));
            reserva.setReservasDias(Integer.parseInt(reservaDias.getText()));
            Huesped huesped;
            huesped = new Huesped();
            // Cambiar 
            String value = String.valueOf(hacerReservaHuesped.getSelectedItem());
            String[] valueDni = value.split(" - ");
            huesped = huespedData.buscarHuesped(Integer.parseInt(valueDni[1]));
            reserva.setHuespedId(huesped);
            reserva.setReservasMonto(Double.parseDouble(montoTotalAPagar.getText()));
            reserva.setReservasEstado(true);
            if (reserva != null && habitacion != null) {
                int resp = JOptionPane.showConfirmDialog(null, "Está seguro que desea reservar la habitación seleccionada ? ", "Alerta!", JOptionPane.YES_NO_OPTION);
                if (resp != 1) {
                    reservasData.crearReserva(reserva);
                    habitacionData.editarHabitacion(habitacion);
                    JOptionPane.showMessageDialog(null, "Su reserva ha sido guardada");
                    cargaDatosHabitaciones();

                } else if (resp != 2) {
                    JOptionPane.showMessageDialog(null, "Verifique información y vuelva a intentarlo");
                    cargaDatosHabitaciones();
                }
            } 
        }
    }//GEN-LAST:event_HacerReservaReservarActionPerformed

    private void hacerReservaHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacerReservaHabitacionesMouseClicked
        // TODO add your handling code here 
        
        TipoHabitacion tipo = new TipoHabitacion();
        double value = (double)hacerReservaHabitaciones.getValueAt(hacerReservaHabitaciones.getSelectedRow(), 3);
        //int totalDias;
        calculaMontoTotalAPagar(value, Integer.parseInt(reservaDias.getText()));
        
        // Mantiene seleccionado el item despues de cambiar de tipo
        /* TipoHabitacion tipo = new TipoHabitacion();
        int value = (int) hacerReservaHabitaciones.getValueAt(hacerReservaHabitaciones.getSelectedRow(), 0);
        tipo.setTipoHabitacionNombre(String.valueOf(hacerReservaHabitaciones.getValueAt(hacerReservaHabitaciones.getSelectedRow(), 1)));
        listaTiposHabitaciones.forEach((item) -> {
            if (item.getTipoHabitacionNombre().equals(tipo.getTipoHabitacionNombre())) {
                hacerReservaTipos.setSelectedIndex(listaTiposHabitaciones.indexOf(item));
                for (int i = 0; i < hacerReservaHabitaciones.getRowCount(); i++) {
                    int valueList = (int) hacerReservaHabitaciones.getValueAt(i, 0);
                    if (valueList == value) {
                        hacerReservaHabitaciones.changeSelection(i, 0, false, false);
                    }
                }
            }
        });*/
    }//GEN-LAST:event_hacerReservaHabitacionesMouseClicked

    private void hacerReservaFechaFinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_hacerReservaFechaFinPropertyChange
        if (isFechaChecOutAnterior()) {
            // Se muestra dos veces el cartel... Revisar por qué ?
            setConfiguracionJDateChooser();
            JOptionPane.showMessageDialog(null, "La fecha de fin de reserva no puede ser anterior a la fecha de inicio");
        } else {
            calculaDiasReservar();
            cargaDatosHabitaciones();
        }
    }//GEN-LAST:event_hacerReservaFechaFinPropertyChange

    private void HacerReservaLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HacerReservaLimpiarActionPerformed
        vaciarCampos();
    // TODO add your handling code here:
    }//GEN-LAST:event_HacerReservaLimpiarActionPerformed

    private void hacerReservaPersonasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hacerReservaPersonasItemStateChanged
        cargaDatosHabitaciones();
        // TODO add your handling code here:
    }//GEN-LAST:event_hacerReservaPersonasItemStateChanged

    // Carga huéspedes al ComboBox
    public void cargaHuespedes() {
        listaHuesped.forEach((item) -> {
            hacerReservaHuesped.addItem(item);
        });
    }

    // Carga tipos habitaciones al ComboBox
    public void cargaTipoHabitacion() {
        // Agrega elemento "Todos" al comboBox en el primer lugar
        TipoHabitacion tipoTodos = new TipoHabitacion("Todos");
        listaTiposHabitaciones.add(0, tipoTodos);
        
        listaTiposHabitaciones.forEach((item) -> {
            hacerReservaTipos.addItem(item);
        });
    }

    // Genera lista de números según el maximo que permite un tipo de habitacion
    public void cargarCantidadPersonas() {
        hacerReservaPersonas.removeAllItems();
        // Busca máximo número de personas que puede alojar una habitación según el tipo de la misma
        int maxPersonas = tipoHabitacionData.buscaMaxCapacidadDeHabitacion();
        for (int i = 1; i <= maxPersonas; ++i) {
            hacerReservaPersonas.addItem(i);
        }
    }

    // Asigana modelo a la tabla, Titulos de Columnas
    public void headersTablaHabitaciones() {

        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("N° habitación");
        columnas.add("Tipo habitación");
        columnas.add("Máximo de Personas");
        columnas.add("Precio X noche");
        columnas.add("Camas");
        columnas.add("Total X Tipo de camas");
        columnas.add("Estado");

        for (Object it : columnas) {
            model.addColumn(it);
        }
        hacerReservaHabitaciones.setModel(model);
    }

    // Borrar Filas tabla 
    public void borraFilasTabla() {
        int totalRow = model.getRowCount() - 1;
        for (int row = totalRow; row >= 0; row--) {
            model.removeRow(row);
        }
    }
    
    // Evalúa según selección comboBox
    public void cargaDatosHabitaciones() {
        borraFilasTabla();
        montoTotalAPagar.setText("");
        
        // Calendario no puede ser null
        if(hacerReservaFechaInicio.getDate() == null){setConfiguracionJDateChooser();}
        if(hacerReservaTipos.getSelectedItem() == null){cargaTipoHabitacion();}
        
        // Toma tipo seleccionado en el comboBox
        TipoHabitacion habitacionPorTipo = (TipoHabitacion)hacerReservaTipos.getSelectedItem();

        // Si hay un tipo de habitacion seleccionado
        if (habitacionPorTipo.getTipoHabitacionId() > 0) {
            // Obtiene las habitaciones según tipo seleccionado en comboBox
            listaHabitaciones = (ArrayList) habitacionData.obtenerHabitacionesPorTipo(habitacionPorTipo.getTipoHabitacionId());
        } else {
            // Si Está La opción TODOS seleccionada obtiene todas la habitaciones
            listaHabitaciones = (ArrayList) habitacionData.obtenerHabitaciones();
        }
        // carga tabla por tipo de habitacion y todos los datos asociados
        cargarDatosTabla(listaHabitaciones);
    }

    // Carga Datos de Habitaciones en la tabla
    private void cargarDatosTabla(ArrayList<Habitacion> listaHabitaciones) {

        TipoCama tipoCama;
        TipoCama tipoCamaId;
        Habitacion habitacionTipos;
        TipoHabitacion tipoHabitacionId;

        String estado;
        String camasDecripcion;
        
        List<String> cama = new ArrayList<String>();
        
        for (Habitacion habitacion : listaHabitaciones) {
                // Busca tipo de cada habitacion
                habitacionTipos = habitacionData.buscarHabitacion(habitacion.getHabitacionId());
                tipoHabitacionId = tipoHabitacionData.buscarTipoHabitacion(habitacionTipos.getTipoHabitacionId().getTipoHabitacionId());
                
                // si la habitacion esta disponible en la fecha dada
                if (!reservasData.isDisponibleEntreFecha(formatearFecha(hacerReservaFechaInicio.getDate()),formatearFecha(hacerReservaFechaFin.getDate()), habitacion.getHabitacionId())
                // y si el tipo tiene capacidad solicitada
                && tipoHabitacionId.getTipoHabitacioCapacidadMax() >= (Integer) hacerReservaPersonas.getSelectedItem()) {
                
                // Busca camas que tiene cada habitación
                listaCamasHabitacion = (ArrayList) camasHabitacionData.obtenerCamasPorHabitacionId(habitacion.getHabitacionId());
                // Vacia lista para reutilizar
                cama.clear();
                for (CamasHabitacion camasHabitacion : listaCamasHabitacion) {
                    // Guarda Id de tipo de cama
                    tipoCamaId = camasHabitacion.getTipoCamaId();
                    // Busca nombre de camas de cada habitación según id de tipo
                    tipoCama = tipoCamaData.buscarTipoCamaPorId(tipoCamaId.getTipoCamaId());
                    // Los guarda en el ArrayList
                    cama.add(tipoCama.getTipoCamaNombre());
                }
                // Transforma ArrayList cama en Set
                Set<String> setCama = new HashSet<String>(cama);
                // Vacía para reutilizar
                camasDecripcion = " ";
                for (String keyCama : setCama) {
                    // Cuenta la cantidad de camas iguales que tiene una habitacion y agrupa de es manera. Crea string con esos datos
                    camasDecripcion += Collections.frequency(cama, keyCama) + " - " + keyCama + " ";
                }
                
                // Asigna los valores a mostrar en la tabla 
                model.addRow(new Object[]{habitacion.getHabitacionId(), tipoHabitacionId.getTipoHabitacionNombre(), tipoHabitacionId.getTipoHabitacioCapacidadMax(), tipoHabitacionId.getTipoHabitacionPrecio(), habitacion.getHabitacionCantidadDeCamas(), camasDecripcion, "Disponible"});

            }
        }
    }

    // Calcular dias de reserva
    public int calculaDiasReservar() {
        int totalDias;
        long reservasDias = ChronoUnit.DAYS.between(formatearFecha(hacerReservaFechaInicio.getDate()), formatearFecha(hacerReservaFechaFin.getDate()));
        reservasDias = (reservasDias == 0) ? reservasDias = 1 : reservasDias;
        totalDias = (int) (long) reservasDias;
        reservaDias.setText(Integer.toString(totalDias));
        return totalDias;
    }

    // Calcula monto total a pagar 
    public void calculaMontoTotalAPagar(double precioNoche, int totalDias) {
        double motoTotal = totalDias * precioNoche;
        montoTotalAPagar.setText(Double.toString(motoTotal));
    }

    // Convierte fecha tipo Date a LocalDate
    public LocalDate formatearFecha(Date date) {
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        LocalDate fechaFormateada = LocalDate.parse(formato.format(date));
        return fechaFormateada;
    }

    // Verifica si fecha salida seleccionada es menor a la de inicio
    public boolean isFechaChecOutAnterior() {
        LocalDate fechaIn = formatearFecha(hacerReservaFechaInicio.getDate());
        LocalDate fechaOut = formatearFecha(hacerReservaFechaFin.getDate());

        return fechaOut.isBefore(fechaIn);
    }
    
    // Inicializa calendario con valores por defecto
    public void setConfiguracionJDateChooser() {
        // Setea fecha actual
        Calendar toDay = new GregorianCalendar();
        hacerReservaFechaInicio.setCalendar(toDay);
        hacerReservaFechaFin.setCalendar(toDay);

        // Setea fecha mínima
        hacerReservaFechaInicio.setMinSelectableDate(toDay.getTime());
        hacerReservaFechaFin.setMinSelectableDate(toDay.getTime());

        // Desactiva edición y carga manual de fechas
        ((JTextField) this.hacerReservaFechaInicio.getDateEditor()).setEditable(false);
        ((JTextField) this.hacerReservaFechaFin.getDateEditor()).setEditable(false);
    }

    // Calcula moto a pagar segun tipo habitación
    public void calculaTotalAPagarSegunTipo() {
        TipoHabitacion habitacionPorTipo = (TipoHabitacion) hacerReservaTipos.getSelectedItem();
        calculaMontoTotalAPagar(habitacionPorTipo.getTipoHabitacionPrecio(), calculaDiasReservar());
    }

    public boolean isCellEditable(int row, int column) {
        return false;
    }

    // Inicializa valores por defecto
    private void vaciarCampos() {
        setConfiguracionJDateChooser();
        montoTotalAPagar.setText("");
        hacerReservaTipos.setSelectedIndex(0);
        hacerReservaPersonas.setSelectedIndex(0);
        cargaDatosHabitaciones();
    }
    
    private boolean validarCampoNumEntero(String value) {
        try {
            int num = Integer.parseInt(value);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HacerReservaLimpiar;
    private javax.swing.JButton HacerReservaReservar;
    private com.toedter.calendar.JDateChooser hacerReservaFechaFin;
    private com.toedter.calendar.JDateChooser hacerReservaFechaInicio;
    private javax.swing.JTable hacerReservaHabitaciones;
    private javax.swing.JComboBox<Huesped> hacerReservaHuesped;
    private javax.swing.JComboBox hacerReservaPersonas;
    private javax.swing.JComboBox<TipoHabitacion> hacerReservaTipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel montoTotalAPagar;
    private javax.swing.JLabel precio;
    private javax.swing.JLabel reservaDias;
    private javax.swing.JLabel textHacerReservaFechaFin;
    private javax.swing.JLabel textHacerReservaFechaInicio;
    private javax.swing.JLabel textHacerReservaHuesped;
    private javax.swing.JLabel textHacerReservaMontoSigno;
    private javax.swing.JLabel textHacerReservaPersonas;
    private javax.swing.JLabel textHacerReservaTipos;
    private javax.swing.JLabel texttitleHacerReserva;
    // End of variables declaration//GEN-END:variables

}