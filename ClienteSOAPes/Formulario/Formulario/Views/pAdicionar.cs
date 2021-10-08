using Formulario.ServiceParticipante;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Formulario
{
    public partial class pAdicionar : Form
    {
        public pAdicionar()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
           ServicioWebParticipanteClient servicio= new ServicioWebParticipanteClient();

           participante participante= new participante();

            participante.id = Convert.ToInt32(textBox1.Text);
            participante.apodo =textBox2.Text;
            participante.fecha_inscripcion = dateTimePicker1.Value;
            participante.fecha_inscripcionSpecified = true;
            participante.fecha_caducidad = dateTimePicker2.Value;
            participante.fecha_caducidadSpecified = true;

            servicio.crearParticipante(participante);



        }
    }
}
