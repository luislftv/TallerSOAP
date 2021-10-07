package serviciosWeb;

import estructural.Mesa;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import repositorio.JavaServiceJPAMesa;

import servicios.ServicioMesa;

@WebService(serviceName = "ServicioWebMesaServiceSW")
public class ServicioWebMesa {
    
    private final ServicioMesa sm;
    
    
    public ServicioWebMesa() {
        super();
        JavaServiceJPAMesa jsjm = new JavaServiceJPAMesa();    
        sm = new ServicioMesa(jsjm);
    }

    @WebMethod
    public Integer crearMesa(@WebParam(name = "arg0") Mesa mesa){
        try{
            sm.crearMesa(mesa);
        }catch(Exception e){
            return 1;
        }
        return 0;
    }

    @WebMethod
    public Integer actualizarMesa(@WebParam(name = "arg0") Mesa mesa){
        try{
            sm.actualizarMesa(mesa);
        }catch (Exception e){
            //Manejo error
            return 1;
        }
        return 0;
    }

    @WebMethod
    public Integer eliminarMesa(@WebParam(name = "arg0") Mesa mesa){
        try{
            sm.eliminarMesa(mesa);
        }catch (Exception e){
            //Manejo error
            return 0;
        }
        return 1;
    }

    @WebMethod
    public Mesa buscarMesa (@WebParam(name = "arg0") Mesa mesa){
        try{
            mesa = sm.buscarMesaId(mesa);
        }catch (Exception e){
            //Manejo error
        }
        return mesa;
    }

    @WebMethod
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
