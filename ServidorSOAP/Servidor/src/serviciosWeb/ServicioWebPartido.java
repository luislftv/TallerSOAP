package serviciosWeb;

import estructural.Partido;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import repositorio.JavaServiceJPAPartido;

import servicios.ServicioPartido;

@WebService(serviceName = "ServicioWebPartidoServiceSW")
public class ServicioWebPartido {
    
    private final ServicioPartido sp;
    
    public ServicioWebPartido() {
        super();
        JavaServiceJPAPartido jpa = new JavaServiceJPAPartido();
        sp = new ServicioPartido(jpa);
    }

    @WebMethod
    public Integer crearPartido(@WebParam(name = "arg0") Partido partido){
        try{
            sp.crearPartido(partido);
        }
        catch (Exception e){
            return 1;
        }
        return 0;
    }

    @WebMethod
    public Integer eliminarPartido(@WebParam(name = "arg0") Partido partido){
        try{
            sp.eliminarPartido(partido);
        }
        catch (Exception e){
            return 1;
        }
        return 0;
    }

    @WebMethod
    public Integer actualizarPartido(@WebParam(name = "arg0") Partido partido){
        try{
            sp.actualizarPartido(partido);
        }
        catch (Exception e){
            return 1;
        }
        return 0;
    }

    @WebMethod
    public List<Partido> listarTodosLosPartidos(){
        return sp.listarTodosLosPartidos();
    }
    
    
    
    
    
}
