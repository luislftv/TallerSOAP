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
    public partial class Principal : Form
    {
        public Principal()
        {
            InitializeComponent();
        }

        private void crearParticipanteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pAdicionar pAdicionar = new pAdicionar();
            pAdicionar.Show();
        }

        private void jugadorToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void consultarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pConcultar pConcultar = new pConcultar();
            pConcultar.Show();
        }
    }
}
