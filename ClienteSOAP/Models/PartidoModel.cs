using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ClienteSOAP.Models
{
    public class PartidoModel
    {
        int mesaId;
        int participante1Id;
        int participante2Id;
        int ganador;
        int ronda;
        DateTime fechaProgramada;
        DateTime horaInicio;
        DateTime horaFin;
        String torneo;

        public PartidoModel(int mesaId, int participante1Id, int participante2Id, int ganador, int ronda, DateTime fechaProgramada, DateTime horaInicio, DateTime horaFin, string torneo)
        {
            this.MesaId = mesaId;
            this.Participante1Id = participante1Id;
            this.Participante2Id = participante2Id;
            this.Ganador = ganador;
            this.Ronda = ronda;
            this.FechaProgramada = fechaProgramada;
            this.HoraInicio = horaInicio;
            this.HoraFin = horaFin;
            this.Torneo = torneo;
        }

        public int MesaId { get => mesaId; set => mesaId = value; }
        public int Participante1Id { get => participante1Id; set => participante1Id = value; }
        public int Participante2Id { get => participante2Id; set => participante2Id = value; }
        public int Ganador { get => ganador; set => ganador = value; }
        public int Ronda { get => ronda; set => ronda = value; }
        public DateTime FechaProgramada { get => fechaProgramada; set => fechaProgramada = value; }
        public DateTime HoraInicio { get => horaInicio; set => horaInicio = value; }
        public DateTime HoraFin { get => horaFin; set => horaFin = value; }
        public string Torneo { get => torneo; set => torneo = value; }
    }
}