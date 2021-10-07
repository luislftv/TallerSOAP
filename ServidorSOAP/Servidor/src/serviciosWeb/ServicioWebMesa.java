package serviciosWeb;

import estructural.Mesa;

import java.util.List;

import repositorio.JavaServiceJPAMesa;

import servicios.ServicioMesa;

public class ServicioWebMesa {
    
    private final ServicioMesa sm;
    
    
    public ServicioWebMesa() {
        super();
        JavaServiceJPAMesa jsjm = new JavaServiceJPAMesa();    
        sm = new ServicioMesa(jsjm);
    }
    
    public Integer crearMesa(Mesa mesa){
        try{
            sm.crearMesa(mesa);
        }catch(Exception e){
            return 1;
        }
        return 0;
    }
    
    public Integer actualizarMesa(Mesa mesa){
        try{
            sm.actualizarMesa(mesa);
        }catch (Exception e){
            //Manejo error
            return 1;
        }
        return 0;
    }
    
    public Integer eliminarMesa(Mesa mesa){
        try{
            sm.eliminarMesa(mesa);
        }catch (Exception e){
            //Manejo error
            return 0;
        }
        return 1;
    }
    
    public Mesa buscarMesa (Mesa mesa){
        try{
            mesa = sm.buscarMesaId(mesa);
        }catch (Exception e){
            //Manejo error
        }
        return mesa;
    }
    
    public List<Mesa> listarMesas(){
        List<Mesa> mesas = null;
        try{
            mesas = sm.listarTodasLasMesas();
        }catch (Exception e){
            //Manejo error
        }
        return mesas;
    }
    
}
