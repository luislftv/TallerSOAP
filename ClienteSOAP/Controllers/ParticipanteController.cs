using ClienteSOAP.Models;
using ClienteSOAP.ServiceParticipante;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Net.Http;


namespace ClienteSOAP.Controllers
{
    public class ParticipanteController : Controller
    {
        // GET: Participante

        public static participante participante;

        public ActionResult CrearParticipante(FormCollection formCollection)
        {
            ServicioWebParticipanteClient servicio;

            participante participante;
                
            servicio = new ServicioWebParticipanteClient();

            String _id = formCollection["id"];
            String _apodo = formCollection["apodo"];
            DateTime _fechaIns = Convert.ToDateTime(formCollection["fechaIns"]) ;
            DateTime _fechaCad = Convert.ToDateTime(formCollection["fechaCad"]);

            participante = new participante
            {

                apodo = _apodo,
                fecha_caducidad = _fechaIns,
                fecha_caducidadSpecified = true,
                fecha_inscripcion = _fechaCad,
                fecha_inscripcionSpecified = true,
                id = Convert.ToInt32(_id)

                
            };
            
            servicio.crearParticipante(participante);

            return View();
        }
      
        
        public ActionResult BuscarParticipante(participante participante)
        {
            ServicioWebParticipanteClient servicio;

            

            servicio = new ServicioWebParticipanteClient();




            participante = new participante
            {

                id = participante.id

            };
            
            participante = servicio.buscarParticipante(participante);

          

            return View();
        }



    }
}