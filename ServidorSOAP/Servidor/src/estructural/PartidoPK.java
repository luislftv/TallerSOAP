package estructural;

import java.io.Serializable;

public class PartidoPK implements Serializable {
    private int participante;
    private int participante1;
    private int mesa;

    public PartidoPK() {
    }

    public PartidoPK(int participante, int participante1, int mesa) {
        this.participante = participante;
        this.participante1 = participante1;
        this.mesa = mesa;
    }

    public boolean equals(Object other) {
        if (other instanceof PartidoPK) {
            final PartidoPK otherPartidoPK = (PartidoPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int getParticipante() {
        return participante;
    }

    public void setParticipante(int participante) {
        this.participante = participante;
    }

    public int getParticipante1() {
        return participante1;
    }

    public void setParticipante1(int participante1) {
        this.participante1 = participante1;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
}
