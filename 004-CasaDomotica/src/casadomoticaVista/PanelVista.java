package casadomoticaVista;

import casadomoticaModelo.ColorLuz;
import casadomoticaModelo.Luz;
import casadomoticaModelo.PanelModelo;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


/**
 * Se encarga de mostrar los datos al usuario.
 * 
 * @author abeherr
 * @author hechila
 */
public class PanelVista extends javax.swing.JFrame {
    private final PanelControlador controlador;
    private final PanelModelo modelo;
    
    private final ArrayList<JButton> botonesLuces;
    
    private int MODO_SELECCION_ACTUAL = -1;
    private Luz LUZ_SELECCIONADA_ACTUAL;
    
    public PanelVista() {
        initComponents();
        botonesLuces = new ArrayList<>();
        modelo = new PanelModelo();
        controlador = new PanelControlador(this, modelo);
        // Centra en la pantalla
        setLocationRelativeTo(null);
        actualizaConfiguracion(); // Carga la luz por defecto
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel5 = new javax.swing.JLabel();
        modosSeleccion = new javax.swing.JPanel();
        tituloModos = new javax.swing.JLabel();
        botonesModos = new javax.swing.JPanel();
        btnTodasEnc = new javax.swing.JButton();
        btnTodasApa = new javax.swing.JButton();
        btnAmbiente = new javax.swing.JButton();
        btnLectura = new javax.swing.JButton();
        luces = new javax.swing.JPanel();
        controles = new javax.swing.JPanel();
        tituloLuz = new javax.swing.JLabel();
        nombreLuz = new javax.swing.JTextField();
        tituloEstado = new javax.swing.JLabel();
        botonEstado = new javax.swing.JToggleButton();
        tituloColor = new javax.swing.JLabel();
        selectorColor = new javax.swing.JComboBox<>();
        tituloIntensidad = new javax.swing.JLabel();
        deslizadorIntensidad = new javax.swing.JSlider();
        previsColor = new javax.swing.JPanel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        modosSeleccion.setBackground(new java.awt.Color(204, 204, 204));
        modosSeleccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        modosSeleccion.setLayout(new java.awt.GridBagLayout());

        tituloModos.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        tituloModos.setText("MODOS DE SELECCIÓN");
        tituloModos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        tituloModos.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 20, 0);
        modosSeleccion.add(tituloModos, gridBagConstraints);

        botonesModos.setBackground(new java.awt.Color(204, 204, 204));
        botonesModos.setLayout(new java.awt.GridLayout(1, 4, 2, 0));

        btnTodasEnc.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTodasEnc.setText("Todas encendidas");
        btnTodasEnc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 4, true));
        btnTodasEnc.setBorderPainted(false);
        btnTodasEnc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTodasEnc.setFocusPainted(false);
        btnTodasEnc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasEncActionPerformed(evt);
            }
        });
        botonesModos.add(btnTodasEnc);

        btnTodasApa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnTodasApa.setText("Todas apagadas");
        btnTodasApa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 4, true));
        btnTodasApa.setBorderPainted(false);
        btnTodasApa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTodasApa.setFocusPainted(false);
        btnTodasApa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasApaActionPerformed(evt);
            }
        });
        botonesModos.add(btnTodasApa);

        btnAmbiente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAmbiente.setText("Ambiente");
        btnAmbiente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 4, true));
        btnAmbiente.setBorderPainted(false);
        btnAmbiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAmbiente.setFocusPainted(false);
        btnAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbienteActionPerformed(evt);
            }
        });
        botonesModos.add(btnAmbiente);

        btnLectura.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLectura.setText("Lectura");
        btnLectura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 4, true));
        btnLectura.setBorderPainted(false);
        btnLectura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLectura.setFocusPainted(false);
        btnLectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLecturaActionPerformed(evt);
            }
        });
        botonesModos.add(btnLectura);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.insets = new java.awt.Insets(0, 15, 15, 15);
        modosSeleccion.add(botonesModos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        getContentPane().add(modosSeleccion, gridBagConstraints);

        luces.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Selección de luz", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24))); // NOI18N
        luces.setToolTipText("");
        luces.setPreferredSize(new java.awt.Dimension(420, 348));
        luces.setLayout(new javax.swing.BoxLayout(luces, javax.swing.BoxLayout.Y_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(luces, gridBagConstraints);

        controles.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Configuración", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24))); // NOI18N
        controles.setToolTipText("");

        tituloLuz.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloLuz.setText("Nombre de luz:");

        nombreLuz.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nombreLuz.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreLuz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreLuzKeyReleased(evt);
            }
        });

        tituloEstado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloEstado.setText("Estado:");

        botonEstado.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        botonEstado.setSelected(true);
        botonEstado.setText("ENCENDIDA");
        botonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstadoActionPerformed(evt);
            }
        });

        tituloColor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloColor.setText("Color:");

        selectorColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        selectorColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Amarillo", "Azul", "Verde", "Naranja", "Blanca" }));
        selectorColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectorColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorColorActionPerformed(evt);
            }
        });

        tituloIntensidad.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloIntensidad.setText("Intensidad");

        deslizadorIntensidad.setMajorTickSpacing(10);
        deslizadorIntensidad.setMinorTickSpacing(10);
        deslizadorIntensidad.setPaintLabels(true);
        deslizadorIntensidad.setPaintTicks(true);
        deslizadorIntensidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deslizadorIntensidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                deslizadorIntensidadStateChanged(evt);
            }
        });

        previsColor.setBackground(new java.awt.Color(255, 255, 255));
        previsColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        previsColor.setPreferredSize(new java.awt.Dimension(104, 104));

        javax.swing.GroupLayout previsColorLayout = new javax.swing.GroupLayout(previsColor);
        previsColor.setLayout(previsColorLayout);
        previsColorLayout.setHorizontalGroup(
            previsColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );
        previsColorLayout.setVerticalGroup(
            previsColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout controlesLayout = new javax.swing.GroupLayout(controles);
        controles.setLayout(controlesLayout);
        controlesLayout.setHorizontalGroup(
            controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlesLayout.createSequentialGroup()
                .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloLuz)
                            .addGroup(controlesLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(tituloEstado))
                            .addGroup(controlesLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(tituloColor)))
                        .addGap(34, 34, 34)
                        .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(selectorColor, 0, 171, Short.MAX_VALUE)
                            .addComponent(nombreLuz)
                            .addComponent(botonEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(controlesLayout.createSequentialGroup()
                        .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controlesLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(tituloIntensidad))
                            .addComponent(deslizadorIntensidad, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 27, Short.MAX_VALUE)
                        .addComponent(previsColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        controlesLayout.setVerticalGroup(
            controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLuz)
                    .addComponent(nombreLuz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloEstado)
                    .addComponent(botonEstado))
                .addGap(32, 32, 32)
                .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectorColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloColor))
                .addGroup(controlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlesLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(tituloIntensidad)
                        .addGap(30, 30, 30)
                        .addComponent(deslizadorIntensidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controlesLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(previsColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(controles, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**********************************************
     *       EVENTOS PANEL DE CONFIGURACIÓN       *
     **********************************************/
    private void deslizadorIntensidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_deslizadorIntensidadStateChanged
        controlador.cambiaValorIntensidad();
    }//GEN-LAST:event_deslizadorIntensidadStateChanged

    private void selectorColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorColorActionPerformed
        controlador.procesaColorCambiado();
    }//GEN-LAST:event_selectorColorActionPerformed

    /**********************************************
     *              MODOS DE SELECCIÓN            *
     **********************************************/
    private void btnTodasEncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasEncActionPerformed
        MODO_SELECCION_ACTUAL = PanelModelo.CONFIG_TODAS_ENCENDIDAS;
        controlador.procesaSeleccion();
    }//GEN-LAST:event_btnTodasEncActionPerformed

    private void btnTodasApaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasApaActionPerformed
        MODO_SELECCION_ACTUAL = PanelModelo.CONFIG_TODAS_APAGADAS;
        controlador.procesaSeleccion();
    }//GEN-LAST:event_btnTodasApaActionPerformed

    private void btnAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbienteActionPerformed
        MODO_SELECCION_ACTUAL = PanelModelo.CONFIG_AMBIENTE;
        controlador.procesaSeleccion();
    }//GEN-LAST:event_btnAmbienteActionPerformed

    private void btnLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLecturaActionPerformed
        MODO_SELECCION_ACTUAL = PanelModelo.CONFIG_LECTURA;
        controlador.procesaSeleccion();
    }//GEN-LAST:event_btnLecturaActionPerformed

    private void nombreLuzKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreLuzKeyReleased
        controlador.procesaNombreCambiado();
    }//GEN-LAST:event_nombreLuzKeyReleased

    private void botonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstadoActionPerformed
        controlador.procesaCambioEstado();
    }//GEN-LAST:event_botonEstadoActionPerformed
    
    /**********************************************
     *          LLAMADAS DEL CONTROLADOR          *
     **********************************************/
    /**
     * Llena dinámicamente el panel selector de luces de la aplicación.
     */
    public void cargaLuces(){
        ArrayList<Luz> listaLuces = modelo.getLuces();
        GridBagLayout gbl = new GridBagLayout();
        JPanel pan = new JPanel();
        pan.setPreferredSize(null);
        pan.setLayout(gbl);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.333;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.CENTER;
        JButton btnLuz;
        int contadorCols = 0;
        for(Luz luz : listaLuces){
            ImageIcon resIcon = null;
            if(luz.estaEncendida()){
                resIcon = new ImageIcon(getClass().getResource(
                          ColorLuz.getIconoColor(luz.getColor().getColorImg())));
            }else{
                resIcon = new ImageIcon(getClass().getResource("/casadomoticaRecursos/bomb_apagada.jpg"));
            }
            btnLuz = new JButton(resIcon);
            btnLuz.setText(luz.getNombre());
            btnLuz.setVerticalTextPosition(SwingConstants.BOTTOM);
            btnLuz.setHorizontalTextPosition(SwingConstants.CENTER);
            btnLuz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnLuz.setFocusPainted(false);
            btnLuz.setBorder(new LineBorder(new java.awt.Color(102, 102, 102), 4, true));
            btnLuz.setBorderPainted(false);
            btnLuz.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    seleccionaLuz(luz);
                }
            });
            gbl.setConstraints(btnLuz, c);
            botonesLuces.add(btnLuz);
            pan.add(btnLuz);
            
            contadorCols++;
            if(contadorCols == 3){
                contadorCols = 0;
                // Añade la fila actual
                luces.add(pan);
                // Nueva fila
                gbl = new GridBagLayout();
                pan = new JPanel();
                pan.setPreferredSize(null);
                pan.setLayout(gbl);
            }
        }
        
        // Comprueba si el panel tiene hijos para añadir
        if(pan.getComponents().length > 0){
            luces.add(pan);
        }
    }
    
    
    /********** PANEL DE SELECCIÓN DE MODOS **********/
    /**
     * Devuelve el modo de selección actual.
     * @return Modo actual
     */
    public int getSeleccion(){
        return MODO_SELECCION_ACTUAL;
    }
    
    /********** PANEL DE SELECCIÓN DE LUZ **********/    
    /**
     * Actualiza el nombre de la luz deseada en el panel de botones de luces.
     * @param l Luz a actualizar
     */
    public void actualizaNombreLuz(Luz l){
        int i = modelo.getLuces().indexOf(l);
        botonesLuces.get(i).setText(l.getNombre());
    }
    
    /**
     * Actualiza el icono de la luz deseada en el panel de botones de luces.
     * @param l Luz a actualizar
     */
    public void actualizaIconoLuz(Luz l) {
        int i = modelo.getLuces().indexOf(l);
        JButton btn = botonesLuces.get(i);
        if(l.estaEncendida()){
            btn.setIcon(new ImageIcon(getClass().getResource(
                          ColorLuz.getIconoColor(l.getColor().getColorImg()))));
        }else{
            btn.setIcon(new ImageIcon(getClass().getResource("/casadomoticaRecursos/bomb_apagada.jpg")));
        }
    }
    
    /**
     * Una luz ha sido marcada por el usuario y notifica al controlador.
     * @param l Luz seleccionada
     */
    private void seleccionaLuz(Luz l){
        LUZ_SELECCIONADA_ACTUAL = l;
        controlador.seleccionaLuz();
    }
    
    /**
     * Desmarca todas las luces del panel de selección de luz.
     */
    private void desmarcaLuces(){
        for(JButton b : botonesLuces){
            b.setBorderPainted(false);
        }
    }
    
    /**
     * Marca la luz actual en el panel de selección de luz.
     */
    public void marcaLuz(){
        desmarcaLuces();
        int i = modelo.getLuces().indexOf(modelo.getSeleccionadaActual());
        botonesLuces.get(i).setBorderPainted(true);
    }
    
    /**
     * Devuelve la Luz que ha sido seleccionada en el panel de selección
     * de luces.
     * @return Luz seleccionada
     */
    public Luz getSeleccionadaActual(){
        return LUZ_SELECCIONADA_ACTUAL;
    }
    
    /**
     * Actualiza los valores y aspectos de todas las luces.
     */
    public void actualizaLuces() {
        for(Luz l : modelo.getLuces()){
            int i = modelo.getLuces().indexOf(l);
            // Actualiza el icono
            actualizaIconoLuz(l);
            actualizaNivelIntensidad(l);
        }
        
        actualizaConfiguracion();
    }
    
    /********** PANEL DE CONFIGURACIÓN **********/
    /**
     * Actualiza la configuración de la luz actualmente seleccionada, en el
     * panel de configuración.
     */
    public void actualizaConfiguracion(){
        Luz actual = modelo.getSeleccionadaActual();
        nombreLuz.setText(actual.getNombre());
        botonEstado.setText(actual.estaEncendida() ? "ENCENDIDA" : "APAGADA");
        botonEstado.setSelected(actual.estaEncendida());
        selectorColor.setSelectedIndex(actual.getColor().getColorImg());
        actualizaNivelIntensidad(actual);
    }
    
    /**
     * Devuelve el contenido del editor de nombre del panel de configuración.
     * @return Nombre actual
     */
    public String getNombreLuz(){
        return nombreLuz.getText();
    }
    
    /**
     * Devuelve el estado de la casilla de encendido/apagado en el panel
     * de configuración.
     * @return true si está marcado
     */
    public boolean getEstadoLuz(){
        return botonEstado.isSelected();
    }
    
    /**
     * Devuelve el índice de la opción seleccionada en el selector de colores
     * del panel de configuración.
     * @return Indice de la opción seleccionada
     */
    public int getColorLuz(){
        return selectorColor.getSelectedIndex();
    }
    
    /**
     * Actualiza el color de la luz en el previsualizador.
     * @param l Luz deseada
     */
    public void actualizaColorLuz(Luz l){
        // Muestra la previsualización del color
        /**
         * IMPORTANTE
         * 
         * Como te comentamos en el laboratorio, quisimos implementar una
         * previsualización teniendo en cuenta el alpha del fondo para mostrar
         * el nivel de la intensidad de la luz a mayores.
         * 
         * No conseguimos hacerlo, pues como viste ocurría un error extraño.
         */
        previsColor.setBackground(new Color(l.getColor().getColorHex()));
    }
    
    /**
     * Actualiza el nivel de intensidad del deslizador.
     * @param l Luz deseada
     */
    public void actualizaNivelIntensidad(Luz l){
        int intensidad = l.getIntensidad();
        deslizadorIntensidad.setValue(intensidad);
        actualizaColorLuz(l);
    }
    
    /**
     * Devuelve el nivel de intensidad que marca el deslizador.
     * @return Nivel de intensidad del deslizador
     */
    public int getNivelIntensidad(){
        return deslizadorIntensidad.getValue();
    }
    
    /**
     * Desmarca el borde de todas los botones de modo.
     */
    public void desmarcarTodas(){
        btnTodasEnc.setBorderPainted(false);
        btnTodasApa.setBorderPainted(false);
        btnAmbiente.setBorderPainted(false);
        btnLectura.setBorderPainted(false);
    }
    
    /**
     * Marca el botón de "Todas encendidas".
     */
    public void marcarTodasEncendidas(){
        btnTodasEnc.setBorderPainted(true);
    }
    
    /**
     * Marca el botón de "Todas apagadas".
     */
    public void marcarTodasApagadas(){
        btnTodasApa.setBorderPainted(true);
    }
    
    /**
     * Marca el botón de "Ambiente".
     */
    public void marcarAmbiente(){
        btnAmbiente.setBorderPainted(true);
    }
    
    /**
     * Marca el botón de "Lectura".
     */
    public void marcarLectura(){
        btnLectura.setBorderPainted(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonEstado;
    private javax.swing.JPanel botonesModos;
    private javax.swing.JButton btnAmbiente;
    private javax.swing.JButton btnLectura;
    private javax.swing.JButton btnTodasApa;
    private javax.swing.JButton btnTodasEnc;
    private javax.swing.JPanel controles;
    private javax.swing.JSlider deslizadorIntensidad;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel luces;
    private javax.swing.JPanel modosSeleccion;
    private javax.swing.JTextField nombreLuz;
    private javax.swing.JPanel previsColor;
    private javax.swing.JComboBox<String> selectorColor;
    private javax.swing.JLabel tituloColor;
    private javax.swing.JLabel tituloEstado;
    private javax.swing.JLabel tituloIntensidad;
    private javax.swing.JLabel tituloLuz;
    private javax.swing.JLabel tituloModos;
    // End of variables declaration//GEN-END:variables

}
