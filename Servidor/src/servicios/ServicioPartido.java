package servicios;


import estructural.Partido;

import java.util.List;

import repositorio.JavaServiceJPAPartido;

public class ServicioPartido {
    
    private final JavaServiceJPAPartido jpaPartido;
    
    public ServicioPartido(JavaServiceJPAPartido jpaPartido) {
        super();
        this.jpaPartido = jpaPartido;    
    }
    
    public boolean crearMesa (Partido partido){
        try{jpaPartido.mergePartido(partido);}
        catch(Exception e){return false;}
        return true;
    }
    
    
    public boolean actualizarMesa(Partido partido){
        try{jpaPartido.mergePartido(partido);}
        catch(Exception e){return false;}
        return true;
        }
    
    
    public boolean eliminarMesa(Partido partido){
        try{jpaPartido.removePartido(partido);}
        catch(Exception e){return false;}
        return true;
        }
    
    
    public List<Partido> listarTodosLosPartidos(){
        List<Partido> partidos = null;
        try{
            partidos = jpaPartido.listarPartidos();
        }
        catch (Exception e){
            System.out.println("No hay nada");
        }
        return partidos;
    }
    
    
    
    
    
}
