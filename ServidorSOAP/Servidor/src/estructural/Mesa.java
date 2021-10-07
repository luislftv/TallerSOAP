package estructural;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Mesa.findAll", query = "select o from Mesa o") })
@Table(name = "\"mesa\"")
public class Mesa implements Serializable {
    private static final long serialVersionUID = 8705047086486768752L;
    @Id
    @Column(name = "id_mesa", nullable = false)
    private int id_mesa;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "nombre_lugar")
    private String nombre_lugar;
    @OneToMany(mappedBy = "mesa", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Partido> partidoList2;

    public Mesa() {
    }

    public Mesa(int id_mesa, String localidad, String nombre_lugar) {
        this.id_mesa = id_mesa;
        this.localidad = localidad;
        this.nombre_lugar = nombre_lugar;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public void setNombre_lugar(String nombre_lugar) {
        this.nombre_lugar = nombre_lugar;
    }

    public List<Partido> getPartidoList2() {
        return partidoList2;
    }

    public void setPartidoList2(List<Partido> partidoList2) {
        this.partidoList2 = partidoList2;
    }

    public Partido addPartido(Partido partido) {
        getPartidoList2().add(partido);
        partido.setMesa(this);
        return partido;
    }

    public Partido removePartido(Partido partido) {
        getPartidoList2().remove(partido);
        partido.setMesa(null);
        return partido;
    }
}
