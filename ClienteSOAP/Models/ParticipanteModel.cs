using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ClienteSOAP.Models
{
    public class ParticipanteModel
    {

        int id;
        String apodo;
        DateTime fechaIns;
        DateTime dechaCad;

        public ParticipanteModel(int id, string apodo, DateTime fechaIns, DateTime dechaCad)
        {
            this.Id = id;
            this.Apodo = apodo;
            this.FechaIns = fechaIns;
            this.DechaCad = dechaCad;
        }

        public int Id { get => id; set => id = value; }
        public string Apodo { get => apodo; set => apodo = value; }
        public DateTime FechaIns { get => fechaIns; set => fechaIns = value; }
        public DateTime DechaCad { get => dechaCad; set => dechaCad = value; }
    }
}