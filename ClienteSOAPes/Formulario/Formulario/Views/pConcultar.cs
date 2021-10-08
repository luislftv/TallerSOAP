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
    public partial class pConcultar : Form
    {
        public pConcultar()
        {
            InitializeComponent();
        }

        public static participante p = new participante();
        private void button1_Click(object sender, EventArgs e)
        {
            ServicioWebParticipanteClient servicio = new ServicioWebParticipanteClient();

            p.id = Convert.ToInt32(textBox1.Text);

            p=servicio.buscarParticipante(p);

            textBox2.Text = p.apodo;
            dateTimePicker1.Value = p.fecha_inscripcion;

            dateTimePicker2.Value = p.fecha_caducidad;



        }
    }
}
