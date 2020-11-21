import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    private PaqueteTuristico paquete;
    private Pasaje pasaje;
    private Cliente cliente;
    private Date fechaReserva;
    private String estadoReserva;
    

    public Reserva(PaqueteTuristico paquete, Pasaje pasaje, Cliente cliente, Date fechaReserva) {
        this.paquete = paquete;
        this.pasaje = pasaje;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
        this.estadoReserva = "activo";
    }
    
    //zona de geters

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public Pasaje getPasaje() {
        return pasaje;
    }

    public String getEstado() {
        return estadoReserva;
    }
    //zona de seters

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }
    
}