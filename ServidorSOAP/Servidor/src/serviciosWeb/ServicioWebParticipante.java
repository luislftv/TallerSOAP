package serviciosWeb;

import estructural.Mesa;

import estructural.Participante;

import estructural.Partido;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import repositorio.JavaServiceJPAParticipante;

import servicios.ServicioParticipante;

@WebService(serviceName = "ServicioWebParticipanteServiceSW")
public class ServicioWebParticipante {
    
    private final ServicioParticipante sp;
    
    
    public ServicioWebParticipante() {
        super();
        JavaServiceJPAParticipante jpa = new JavaServiceJPAParticipante();
        sp = new ServicioParticipante(jpa);
    }

    @WebMethod
    public Integer crearParticipante(@WebParam(name = "arg0") Participante participante){
        try{
            sp.crearParticipante(participante);
        }
        catch(Exception e){
            return 1;
        }
        return 0;
    }

    @WebMethod
    public Participante buscarParticipante(@WebParam(name = "arg0") Participante participante){
        try{
            participante = sp.buscarParticipanteId(participante);
        }
        catch(Exception e){
            return null;
        }
        return participante;
    }

    @WebMethod
    public Integer eliminarParticipante(@WebParam(name = "arg0") Participante participante){
        try{
            sp.eliminarParticipante(participante);
        }
        catch(Exception e){
            return 1;
        }
        return 0;
    }

    @WebMethod
    public Integer actualizarParticipante(@WebParam(name = "arg0") Participante participante){
        try{
            sp.actualizarParticipante(participante);
        }
        catch(Exception e){
            return 1;
        }
        return 0;
    }


    @WebMethod
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

    @WebMethod
    public Integer[] Estadisticas(@WebParam(name = "arg0") Participante participante){
        
             return sp.Estadisticas(participante);
        
    }

    @WebMethod
    public List<Partido> listarPartidosDeUnParticipante(@WebParam(name = "arg0") Participante participante){
        
        return sp.listarPartidosDeUnParticipante(participante);
        
    }

    @WebMethod
    public List<Participante> filtrarParticipantePorApodo(@WebParam(name = "arg0") Participante participante){
        
        return sp.filtrarParticipantePorApodo(participante);
    
    }
    
    
    
    
}
