package estructural;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Partido.findAll", query = "select o from Partido o") })
@Table(name = "\"partido\"")
@IdClass(PartidoPK.class)
public class Partido implements Serializable {
    private static final long serialVersionUID = -3655630250733473650L;
    @Column(name = "fecha_programada", nullable = false)
    private Timestamp fecha_programada;
    @Column(name = "ganador", nullable = false)
    private int ganador;
    @Column(name = "hora_fin", nullable = false)
    private Timestamp hora_fin;
    @Column(name = "hora_inicio", nullable = false)
    private Timestamp hora_inicio;
    @Column(name = "ronda", nullable = false)
    private int ronda;
    @Column(name = "torneo", nullable = false)
    private String torneo;
    @ManyToOne
    @Id
    @JoinColumn(name = "parcipante_2")
    private Participante participante;
    @ManyToOne
    @Id
    @JoinColumn(name = "parcipante_1")
    private Participante participante1;
    @ManyToOne
    @Id
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    public Partido() {
    }

    public Partido(Timestamp fecha_programada, int ganador, Timestamp hora_fin, Timestamp hora_inicio, Mesa mesa,
                   Participante participante1, Participante participante, int ronda, String torneo) {
        this.fecha_programada = fecha_programada;
        this.ganador = ganador;
        this.hora_fin = hora_fin;
        this.hora_inicio = hora_inicio;
        this.mesa = mesa;
        this.participante1 = participante1;
        this.participante = participante;
        this.ronda = ronda;
        this.torneo = torneo;
    }

    public Timestamp getFecha_programada() {
        return fecha_programada;
    }

    public void setFecha_programada(Timestamp fecha_programada) {
        this.fecha_programada = fecha_programada;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    public Timestamp getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Timestamp hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Timestamp getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Timestamp hora_inicio) {
        this.hora_inicio = hora_inicio;
    }


    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public String getTorneo() {
        return torneo;
    }

    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Participante getParticipante1() {
        return participante1;
    }

    public void setParticipante1(Participante participante1) {
        this.participante1 = participante1;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
}
