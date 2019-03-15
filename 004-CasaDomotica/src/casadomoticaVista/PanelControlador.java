package casadomoticaVista;

import casadomoticaModelo.ColorLuz;
import casadomoticaModelo.PanelModelo;
import casadomoticaModelo.Luz;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Trata los eventos que le notifica la vista,
 * modifica el modelo y actualiza la vista.
 * 
 * @author abeherr
 * @author hechila
 */
public final class PanelControlador {
    
    private final String PATH_LUCES = "/casadomoticaRecursos/luces.txt";
    
    private final PanelVista vista;
    private final PanelModelo modelo;
    
    public PanelControlador(PanelVista v, PanelModelo m){
        vista = v;
        modelo = m;
        // Inicializa las luces
        initLuces();
    }
    
    /**
     * Inicializa las luces desde fichero en memoria y asigna al modelo.
     */
    public void initLuces(){
        ArrayList<Luz> luces = new ArrayList<>();
        try {
            InputStream is = getClass().getResourceAsStream(PATH_LUCES);
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            try (BufferedReader br = new BufferedReader(isr)) {
                while(br.ready()){
                    // Lee datos de las luces
                    String nombre = br.readLine();
                    int intensidad = Integer.parseInt(br.readLine());
                    int colorImg = Integer.parseInt(br.readLine());
                    boolean encendida = Boolean.parseBoolean(br.readLine());
                    luces.add(new Luz(nombre, intensidad, new ColorLuz(colorImg), encendida));
                    br.readLine(); // Siguiente sección
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("[!] El archivo \"luces.txt\" no existe.");
            System.exit(-1);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("[!] Codificación no soportada. Puede haber problemas.");
        } catch (IOException ex) {
            System.out.println("[!] Error al leer el archivo \"luces.txt\".");
            System.exit(-1);
        } catch (NumberFormatException ex) {
            System.out.println("[!] Error al leer un entero en el archivo \"luces.txt\".");
            System.exit(-1);
        }
        
        modelo.setLuces(luces);
        vista.cargaLuces();
        modelo.setSeleccionadaActual(luces.get(0)); // QUITAR ESTO EN UN FUTURO
    }
    
    /**
     * Cambia la configuración de las luces según unas selecciones predeterminadas.
     * 
     * 1) Todas las luces encendidas: todas a 100% de intensidad y color blanco.
     * 2) Todas las luces apagadas.
     * 3) Luz ambiental: todas encendidas al 30% de intensidad y color amarillo.
     * 4) Luz de lectura: la primera y la tercera luz están encendidas al 60%
     *     de intensidad y color blanco. El resto están apagadas.
     */
    public void procesaSeleccion(){
        switch(vista.getSeleccion()){
            case PanelModelo.CONFIG_TODAS_ENCENDIDAS:
                for(Luz l : modelo.getLuces()){
                    l.setEncendida(true);
                    l.setIntensidad(100);
                    l.setColor(new ColorLuz(ColorLuz.COLOR_BLANCA));
                }
                break;
            case PanelModelo.CONFIG_TODAS_APAGADAS:
                for(Luz l : modelo.getLuces()){
                    l.setEncendida(false);
                }
                break;
            case PanelModelo.CONFIG_AMBIENTE:
                for(Luz l : modelo.getLuces()){
                    l.setEncendida(true);
                    l.setIntensidad(30);
                    l.setColor(new ColorLuz(ColorLuz.COLOR_AMARILLO));
                }
                break;
            case PanelModelo.CONFIG_LECTURA:
                Set<Integer> indices = new HashSet<Integer>();
                // Luces a encender: primera y tercera
                indices.add(0);
                indices.add(2);
                for(int i = 0; i < modelo.getLuces().size(); i++){
                    if(indices.contains(i)){
                        // Se enciende con la configuración deseada
                        modelo.getLuces().get(i).setEncendida(true);
                        modelo.getLuces().get(i).setIntensidad(30);
                        modelo.getLuces().get(i).setColor(new ColorLuz(ColorLuz.COLOR_AMARILLO));
                    }else{
                        // Se apagan
                        modelo.getLuces().get(i).setEncendida(false);
                    }
                }
                break;
        }
        
        vista.actualizaLuces();
    }
    
    /**
     * Procesa el evento de selección de luz individual.
     * @param l
     */
    public void seleccionaLuz(){
        modelo.setSeleccionadaActual(vista.getSeleccionadaActual());
        vista.actualizaConfiguracion();
    }
    
    /**
     * Procesa el evento de cambio de intensidad.
     */
    public void cambiaValorIntensidad(){
        modelo.getSeleccionadaActual().setIntensidad(vista.getNivelIntensidad());
        vista.actualizaNivelIntensidad(modelo.getSeleccionadaActual());
        if(modoTodasEncendidas()==true)
            vista.marcarTodasEncendidas();
        if(modoTodasApagadas()==true)
            vista.marcarTodasApagadas();
        if(modoAmbiente()==true)
            vista.marcarAmbiente();
        if(modoLectura()==true)
            vista.marcarLectura();
        
    }

    /**
     * Procesa el evento de cambio de nombre.
     */
    void procesaNombreCambiado() {
        modelo.getSeleccionadaActual().setNombre(vista.getNombreLuz());
        vista.actualizaNombreLuz(modelo.getSeleccionadaActual());
    }

    /**
     * Procesa el evento de cambio de estado de la luz (apagada/encendida).
     */
    void procesaCambioEstado() {
        modelo.getSeleccionadaActual().setEncendida(vista.getEstadoLuz());
        vista.actualizaIconoLuz(modelo.getSeleccionadaActual());
         if(modoTodasEncendidas()==true)
            vista.marcarTodasEncendidas();
        if(modoTodasApagadas()==true)
            vista.marcarTodasApagadas();
        if(modoAmbiente()==true)
            vista.marcarAmbiente();
        if(modoLectura()==true)
            vista.marcarLectura();
    }
    
    /**
     * Procesa el evento de cambio de color de la luz.
     */
    void procesaColorCambiado() {
        modelo.getSeleccionadaActual().setColor(new ColorLuz(vista.getColorLuz()));
        vista.actualizaColorLuz(modelo.getSeleccionadaActual());
        vista.actualizaIconoLuz(modelo.getSeleccionadaActual());
         if(modoTodasEncendidas()==true)
            vista.marcarTodasEncendidas();
        if(modoTodasApagadas()==true)
            vista.marcarTodasApagadas();
        if(modoAmbiente()==true)
            vista.marcarAmbiente();
        if(modoLectura()==true)
            vista.marcarLectura();
    }
    
    public boolean modoTodasEncendidas(){
        boolean res = true;
        
        for(Luz l : modelo.getLuces()){
            if(l.getColor()!=new ColorLuz(ColorLuz.COLOR_BLANCA)){
                res = false;
                break;
            }
            if(l.getIntensidad()!=100){
                res = false;
                break;
            }
            if(l.estaEncendida()==false){
                res = false;
                break;
                }
        }
        
        return res;
    }
    
    public boolean modoTodasApagadas(){
        boolean res = true;
        
        for(Luz l : modelo.getLuces()){
            if(l.estaEncendida()==true){
                res = false;
                break;
                }
        }
        
        return res;
    }
     public boolean modoAmbiente(){
        boolean res = true;
        
        for(Luz l : modelo.getLuces()){
            if(l.getColor()!=new ColorLuz(ColorLuz.COLOR_AMARILLO)){
                res = false;
                break;
            }
            if(l.getIntensidad()!=30){
                res = false;
                break;
            }
            if(l.estaEncendida()==false){
                res = false;
                break;
                }
        }
        
        return res;
    }
      public boolean modoLectura(){
        boolean res = true;
        
        if(modelo.getLuces().get(0).estaEncendida()!=true)
            res = false;
        if(modelo.getLuces().get(0).getColor()!=new ColorLuz(ColorLuz.COLOR_BLANCA))
            res = false;
        if(modelo.getLuces().get(0).getIntensidad()!=60)
            res = false;
        
        if(modelo.getLuces().get(2).estaEncendida()!=true)
            res = false;
        if(modelo.getLuces().get(2).getColor()!=new ColorLuz(ColorLuz.COLOR_BLANCA))
            res = false;
        if(modelo.getLuces().get(2).getIntensidad()!=60)
            res = false;
        return res;
    }
}
