package servicios;

import estructural.Mesa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import repositorio.JavaServiceJPAMesa;

public class ServicioMesa {
    
    private final JavaServiceJPAMesa jpaMesa;
    
    
    public ServicioMesa(JavaServiceJPAMesa jpaMesa) {
        super();
        this.jpaMesa = jpaMesa;
    }
    
    /**
     *Metodo que crea una mesa
     * @param mesa
     * @return true si se pudo guardar false de lo contrario
     */
    public boolean crearMesa (Mesa mesa){
        try{jpaMesa.persistMesa(mesa);}
        catch(Exception e){return false;}
        return true;
    }
    
    /**
     *Metodo que actualiza una mesa
     * @param mesa
     * @return true si se pudo actualizar false de lo contrario
     */
    public boolean actualizarMesa(Mesa mesa){
        try{jpaMesa.mergeMesa(mesa);}
        catch(Exception e){return false;}
        return true;
        }
    
    /**
     *Metodo que elimina una mesa
     * @param mesa
     * @return true si se eliminó la mesa false de lo contrario
     */
    public boolean eliminarMesa(Mesa mesa){
        try{jpaMesa.removeMesa(mesa);}
        catch(Exception e){return false;}
        return true;
        }
    
    /**
     *Metodo que lista todas las mesas
     * @return
     */
    public List<Mesa> listarTodasLasMesas(){
        List<Mesa> mesas = null;
        try{
            mesas = jpaMesa.listarMesas();
        }
        catch (Exception e){
            System.out.println("No hay nada");
        }
        return mesas;
    }
    
}
