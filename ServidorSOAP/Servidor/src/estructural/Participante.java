package estructural;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Participante.findAll", query = "select o from Participante o") })
@Table(name = "\"participante\"")
public class Participante implements Serializable {
    private static final long serialVersionUID = 2724908626026484325L;
    @Column(name = "apodo", nullable = false, unique = true)
    private String apodo;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_caducidad", nullable = false)
    private Date fecha_caducidad;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inscripcion", nullable = false)
    private Date fecha_inscripcion;
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToMany(mappedBy = "participante", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Partido> partidoList;
    @OneToMany(mappedBy = "participante1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Partido> partidoList1;

    public Participante() {
    }

    public Participante(String apodo, Date fecha_caducidad, Date fecha_inscripcion, int id) {
        this.apodo = apodo;
        this.fecha_caducidad = fecha_caducidad;
        this.fecha_inscripcion = fecha_inscripcion;
        this.id = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Partido> getPartidoList() {
        return partidoList;
    }

    public void setPartidoList(List<Partido> partidoList) {
        this.partidoList = partidoList;
    }

    public Partido addPartido(Partido partido) {
        getPartidoList().add(partido);
        partido.setParticipante(this);
        return partido;
    }

    public Partido removePartido(Partido partido) {
        getPartidoList().remove(partido);
        partido.setParticipante(null);
        return partido;
    }

    public List<Partido> getPartidoList1() {
        return partidoList1;
    }

    public void setPartidoList1(List<Partido> partidoList1) {
        this.partidoList1 = partidoList1;
    }
}
