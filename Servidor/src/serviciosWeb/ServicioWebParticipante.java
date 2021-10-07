package serviciosWeb;

import estructural.Mesa;

import estructural.Participante;

import java.util.List;

import repositorio.JavaServiceJPAParticipante;

import servicios.ServicioParticipante;

public class ServicioWebParticipante {
    
    private final ServicioParticipante sp;
    
    
    public ServicioWebParticipante() {
        super();
        JavaServiceJPAParticipante jpa = new JavaServiceJPAParticipante();
        sp = new ServicioParticipante(jpa);
    }
    
    public Integer crearParticipante(Participante participante){
        try{
            sp.crearParticipante(participante);
        }
        catch(Exception e){
            return 1;
        }
        return 0;
    }
    
    public Participante buscarParticipante(Participante participante){
        try{
            participante = sp.buscarParticipanteId(participante);
        }
        catch(Exception e){
            return null;
        }
        return participante;
    }
    
    public Integer eliminarParticipante(Participante participante){
        try{
            sp.eliminarParticipante(participante);
        }
        catch(Exception e){
            return 1;
        }
        return 0;
    }
    
    public Integer actualizarParticipante(Participante participante){
        try{
            sp.actualizarParticipante(participante);
        }
        catch(Exception e){
            return 1;
        }
        return 0;
    }
    
    
    public List<Participante> listarParticipantes(){
        List<Participante> participantes = null;
        try{
            participantes = sp.listarTodosLosParticipantes();
        }catch (Exception e){
            //Manejo error
            return null;
        }
        return participantes;
    }
}
