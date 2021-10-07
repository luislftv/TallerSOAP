package servicios;

import estructural.Mesa;
import estructural.Participante;

import estructural.Partido;

import java.util.List;

import repositorio.JavaServiceJPAParticipante;

public class ServicioParticipante {
    
    private final JavaServiceJPAParticipante jpaParticipante;
    
    public ServicioParticipante(JavaServiceJPAParticipante jpaParticipante) {
        super();
        this.jpaParticipante = jpaParticipante;
    }
    
    
    public boolean crearParticipante (Participante participante){
        System.out.println(participante.toString());
        try{jpaParticipante.persistParticipante(participante);}
        catch(Exception e){return false;}
        return true;
    }
    
    
    public boolean actualizarParticipante(Participante participante){
        try{jpaParticipante.mergeParticipante(participante);}
        catch(Exception e){return false;}
        return true;
        }
    
    
    public boolean eliminarParticipante(Participante participante){
        try{jpaParticipante.removeParticipante(participante);}
        catch(Exception e){return false;}
        return true;
        }
    
    public Participante buscarParticipanteId(Participante participante){
        Participante participanteb = null;
        try{participanteb = jpaParticipante.searchParticipante(participante);}
        catch(Exception e){return null;}
        return participanteb;
        }
 
    
    public List<Participante> listarTodosLosParticipantes(){
        List<Participante> participante = null;
        try{
            participante = jpaParticipante.listarParticipantes();
        }
        catch (Exception e){
            System.out.println("No hay nada");
        }
        return participante;
    }
    
    public Integer[] Estadisticas(Participante participante){
        Integer [] res = null;
        try{
             res = jpaParticipante.EstadisticasNegrasYBlancas(participante);
        }
        catch (Exception e){
            System.out.println("No hay nada");
        }
        return res;
    }
    
    public List<Partido> listarPartidosDeUnParticipante(Participante participante){
        List<Partido> partidos = null;
        try{
             partidos = jpaParticipante.listarPartidosDeUnParticipante(participante);
        }
        catch (Exception e){
            System.out.println("No hay nada");
        }
        return partidos;
        
    }
    
    public List<Participante> filtrarParticipantePorApodo(Participante participante){
        List<Participante> participantes = null;
        try{
            participantes = jpaParticipante.filtrarParticipantePorApodo(participante);
        }
        catch (Exception e){
            System.out.println("No hay nada");
        }
        return participantes;
    }
}
