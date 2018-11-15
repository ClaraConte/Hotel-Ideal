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
import hotel.modelo.TipoCama;
import hotel.modelo.TipoCamaData;
import hotel.modelo.TipoHabitacion;
import hotel.modelo.TipoHabitacionData;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesica
 */
public class VistaHabitacionesLista extends javax.swing.JInternalFrame {

    private Conexion conexion;
    private DefaultTableModel modelo;
    private HabitacionData habitacionData;
    private TipoHabitacionData tipoHabitacionData;
    private CamasHabitacionData camasHabitacionData;
    private TipoCamaData tipoCamaData;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<CamasHabitacion> listaCamasHabitacion;
    private ArrayList<TipoHabitacion> listaTiposHabitaciones;
    private ArrayList listaCamasHabitaciones;

    /**
     * Creates new form VistaHabitaciones
     */
    public VistaHabitacionesLista() {
        initComponents();

        try {
            conexion = new Conexion();
            modelo = new DefaultTableModel();

            habitacionData = new HabitacionData(conexion);
            tipoHabitacionData = new TipoHabitacionData(conexion);
            camasHabitacionData = new CamasHabitacionData(conexion);
            tipoCamaData = new TipoCamaData(conexion);

            headersTablaHabitaciones();
            cargarDatos();

            cargaTipoHabitacion();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HabitacionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borraFilasTabla() {

        int a = modelo.getRowCount() - 1;

        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);

        }
    }

    public void headersTablaHabitaciones() {
        //Titulos de Columnas
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Num Habitacion");
        columnas.add("Tipo de habitacion");
        columnas.add("Capacidad maxima");
        columnas.add("Cantidad de camas");
        columnas.add("Tipos de camas");
        columnas.add("Precio");
        columnas.add("Estado");

        for (Object it : columnas) {
            modelo.addColumn(it);
        }
        jTable1.setModel(modelo);
    }

    public void cargarDatos() {

        TipoCama tipoCama;
        TipoCama tipoCamaId;
        Habitacion habitacionTipos;
        TipoHabitacion tipoHabitacionId;
        List<CamasHabitacion> tipoCamalist = new ArrayList<>();
        String camasDescripcion;
        List<String> cama = new ArrayList<String>();

        //Llenar filas
        listaHabitaciones = (ArrayList) habitacionData.obtenerHabitaciones();
        for (Habitacion h : listaHabitaciones) {

            // Busca tipo de cada habitacion
            habitacionTipos = habitacionData.buscarHabitacion(h.getHabitacionId());
            tipoHabitacionId = tipoHabitacionData.buscarTipoHabitacion(habitacionTipos.getTipoHabitacionId().getTipoHabitacionId());

            listaCamasHabitacion = (ArrayList) camasHabitacionData.obtenerCamasPorHabitacionId(h.getHabitacionId());
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
            camasDescripcion = "";
            for (String keyCama : setCama) {
                // Cuenta la cantidad de camas iguales que tiene una habitacion y agrupa de es manera. Crea string con esos datos
                camasDescripcion += Collections.frequency(cama, keyCama) + " - " + keyCama + " ";
            }

            modelo.addRow(new Object[]{h.getHabitacionId(), tipoHabitacionId.getTipoHabitacionNombre(), tipoHabitacionId.getTipoHabitacioCapacidadMax(), h.getHabitacionCantidadDeCamas(), camasDescripcion, tipoHabitacionId.getTipoHabitacionPrecio(), estado(h)});
        }
    }

    public void cargaTipoHabitacion() {
        // Obtiene los tipos de habitaciones

        listaTiposHabitaciones = (ArrayList) tipoHabitacionData.obtenerTipoHabitacion();

        TipoHabitacion tipoTodos = new TipoHabitacion("Tipo de habitaciones");
        listaTiposHabitaciones.add(0, tipoTodos);

        listaTiposHabitaciones.forEach((item) -> {
            tiposHabitacionesCombo.addItem(item);
        });
    }

    public String estado(Habitacion habitacion) {

        if (habitacion.isHabitacionEstado()) {
            return "Disponible";
        } else {
            return "Ocupado";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tiposHabitacionesCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        estadoCombo = new javax.swing.JComboBox();
        camasCantidadCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Num Habitación", "Tipo de habitación", "Capacidad Máxima", "Cantidad de camas", "Tipos de camas", "Precio", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Num Habitación");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Tipo de habitación");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Capacidad Máxima");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Cantidad de camas");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Tipos de camas");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Precio");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Estado");
        }

        tiposHabitacionesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiposHabitacionesComboActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/vistas/resources/list-8.png"))); // NOI18N
        jLabel2.setText("LISTADO DE HABITACIONES");

        estadoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estado", "Libre", "Ocupado" }));
        estadoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoComboActionPerformed(evt);
            }
        });

        camasCantidadCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cantidad de camas", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        camasCantidadCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camasCantidadComboActionPerformed(evt);
            }
        });

        jLabel3.setText("Filtrar por ");

        jLabel4.setText("Filtrar por ");

        jLabel5.setText("Filtrar por");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tiposHabitacionesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(camasCantidadCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estadoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tiposHabitacionesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(camasCantidadCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(estadoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tiposHabitacionesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiposHabitacionesComboActionPerformed
        // TODO add your handling code here:
        List<String> cama = new ArrayList<String>();
        TipoCama tipoCama;
        TipoCama tipoCamaId;
        String camasDescripcion;

        borraFilasTabla();
        TipoHabitacion habitacionPorTipo = (TipoHabitacion) tiposHabitacionesCombo.getSelectedItem();
        habitacionPorTipo.getTipoHabitacionNombre();

        if (habitacionPorTipo.getTipoHabitacionId() <= 0) {
            cargarDatos();
        } else {
            listaHabitaciones = (ArrayList) habitacionData.obtenerHabitacionesPorTipo(habitacionPorTipo.getTipoHabitacionId());

            for (Habitacion h : listaHabitaciones) {

                Habitacion habitacionTipos;
                TipoHabitacion tipoHabitacionId;
                // Busca tipo de cada habitacion
                habitacionTipos = habitacionData.buscarHabitacion(h.getHabitacionId());
                tipoHabitacionId = tipoHabitacionData.buscarTipoHabitacion(habitacionTipos.getTipoHabitacionId().getTipoHabitacionId());

                listaCamasHabitacion = (ArrayList) camasHabitacionData.obtenerCamasPorHabitacionId(h.getHabitacionId());
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
                camasDescripcion = "";
                for (String keyCama : setCama) {
                    // Cuenta la cantidad de camas iguales que tiene una habitacion y agrupa de es manera. Crea string con esos datos
                    camasDescripcion += Collections.frequency(cama, keyCama) + " - " + keyCama + " ";
                }

                modelo.addRow(new Object[]{h.getHabitacionId(), tipoHabitacionId.getTipoHabitacionNombre(), tipoHabitacionId.getTipoHabitacioCapacidadMax(), h.getHabitacionCantidadDeCamas(), camasDescripcion, tipoHabitacionId.getTipoHabitacionPrecio(), estado(h)});
            }
        }
    }//GEN-LAST:event_tiposHabitacionesComboActionPerformed

    private void estadoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoComboActionPerformed
        // TODO add your handling code here:
        TipoCama tipoCama;
        TipoCama tipoCamaId;
        Habitacion habitacionTipos;
        TipoHabitacion tipoHabitacionId;
        List<CamasHabitacion> tipoCamalist = new ArrayList<>();
        String camasDescripcion;
        List<String> cama = new ArrayList<String>();

        if (estadoCombo.getSelectedItem().equals("Libre")) {
            borraFilasTabla();
            for (Habitacion h : listaHabitaciones) {
                if (h.isHabitacionEstado()) {
                    habitacionTipos = habitacionData.buscarHabitacion(h.getHabitacionId());
                    tipoHabitacionId = tipoHabitacionData.buscarTipoHabitacion(habitacionTipos.getTipoHabitacionId().getTipoHabitacionId());

                    listaCamasHabitacion = (ArrayList) camasHabitacionData.obtenerCamasPorHabitacionId(h.getHabitacionId());
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
                    camasDescripcion = "";
                    for (String keyCama : setCama) {
                        // Cuenta la cantidad de camas iguales que tiene una habitacion y agrupa de es manera. Crea string con esos datos
                        camasDescripcion += Collections.frequency(cama, keyCama) + " - " + keyCama + " ";
                    }

                    modelo.addRow(new Object[]{h.getHabitacionId(), tipoHabitacionId.getTipoHabitacionNombre(), tipoHabitacionId.getTipoHabitacioCapacidadMax(), h.getHabitacionCantidadDeCamas(), camasDescripcion, tipoHabitacionId.getTipoHabitacionPrecio(), estado(h)});

                }
            }
        } else if (estadoCombo.getSelectedItem().equals("Ocupado")) {
            borraFilasTabla();
            for (Habitacion h : listaHabitaciones) {
                if (!h.isHabitacionEstado()) {
                    habitacionTipos = habitacionData.buscarHabitacion(h.getHabitacionId());
                    tipoHabitacionId = tipoHabitacionData.buscarTipoHabitacion(habitacionTipos.getTipoHabitacionId().getTipoHabitacionId());

                    listaCamasHabitacion = (ArrayList) camasHabitacionData.obtenerCamasPorHabitacionId(h.getHabitacionId());
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
                    camasDescripcion = "";
                    for (String keyCama : setCama) {
                        // Cuenta la cantidad de camas iguales que tiene una habitacion y agrupa de es manera. Crea string con esos datos
                        camasDescripcion += Collections.frequency(cama, keyCama) + " - " + keyCama + " ";
                    }

                    modelo.addRow(new Object[]{h.getHabitacionId(), tipoHabitacionId.getTipoHabitacionNombre(), tipoHabitacionId.getTipoHabitacioCapacidadMax(), h.getHabitacionCantidadDeCamas(), camasDescripcion, tipoHabitacionId.getTipoHabitacionPrecio(), estado(h)});

                }
            }
        } else {
            borraFilasTabla();
            cargarDatos();
        }


    }//GEN-LAST:event_estadoComboActionPerformed

    private void camasCantidadComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camasCantidadComboActionPerformed
        // TODO add your handling code here:
        List<String> cama = new ArrayList<String>();
        TipoCama tipoCama;
        TipoCama tipoCamaId;
        String camasDescripcion;

        borraFilasTabla();

        if (camasCantidadCombo.getSelectedIndex() <= 0) {
            cargarDatos();
        } else {
            int cantCamas = Integer.parseInt(camasCantidadCombo.getSelectedItem().toString());
            listaHabitaciones = (ArrayList) habitacionData.obtenerHabitacionesCantCamas(cantCamas);

            for (Habitacion h : listaHabitaciones) {

                Habitacion habitacionTipos;
                TipoHabitacion tipoHabitacionId;
                // Busca tipo de cada habitacion
                habitacionTipos = habitacionData.buscarHabitacion(h.getHabitacionId());
                tipoHabitacionId = tipoHabitacionData.buscarTipoHabitacion(habitacionTipos.getTipoHabitacionId().getTipoHabitacionId());

                listaCamasHabitacion = (ArrayList) camasHabitacionData.obtenerCamasPorHabitacionId(h.getHabitacionId());
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
                camasDescripcion = "";
                for (String keyCama : setCama) {
                    // Cuenta la cantidad de camas iguales que tiene una habitacion y agrupa de es manera. Crea string con esos datos
                    camasDescripcion += Collections.frequency(cama, keyCama) + " - " + keyCama + " ";
                }

                modelo.addRow(new Object[]{h.getHabitacionId(), tipoHabitacionId.getTipoHabitacionNombre(), tipoHabitacionId.getTipoHabitacioCapacidadMax(), h.getHabitacionCantidadDeCamas(), camasDescripcion, tipoHabitacionId.getTipoHabitacionPrecio(), estado(h)});
            }
        }
    }//GEN-LAST:event_camasCantidadComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox camasCantidadCombo;
    private javax.swing.JComboBox estadoCombo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox tiposHabitacionesCombo;
    // End of variables declaration//GEN-END:variables
}
