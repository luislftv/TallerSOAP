package serviciosWeb;

import estructural.Partido;

import java.util.List;

import repositorio.JavaServiceJPAPartido;

import servicios.ServicioPartido;

public class ServicioWebPartido {
    
    private final ServicioPartido sp;
    
    public ServicioWebPartido() {
        super();
        JavaServiceJPAPartido jpa = new JavaServiceJPAPartido();
        sp = new ServicioPartido(jpa);
    }
    
    public Integer crearPartido(Partido partido){
        try{
            sp.crearPartido(partido);
        }
        catch (Exception e){
            return 1;
        }
        return 0;
    }
    
    public Integer eliminarPartido(Partido partido){
        try{
            sp.eliminarPartido(partido);
        }
        catch (Exception e){
            return 1;
        }
        return 0;
    }
    public Integer actualizarPartido(Partido partido){
        try{
            sp.actualizarPartido(partido);
        }
        catch (Exception e){
            return 1;
        }
        return 0;
    }
    public List<Partido> listarTodosLosPartidos(){
        return sp.listarTodosLosPartidos();
    }
    
    
    
    
    
}
