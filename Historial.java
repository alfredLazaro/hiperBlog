import java.util.ArrayList;
import java.util.Date;

public class Historial {
    private ArrayList<Reserva> reservas;
    private int nroIdent; //el nro de identificacion sera el del cliente
    private Date fechaModificacion;

    public Historial(int nroIdent, Date fechaModificacion) {
        reservas = new ArrayList<Reserva>();
        this.nroIdent = nroIdent;
        this.fechaModificacion = fechaModificacion;
    }

    public void actualizarHistorial(Reserva reservActual){
      setFechaModificacion(new Date());
      aniadirReserva(reservActual);
    }

    private void aniadirReserva(Reserva reserva){
        reservas.add(0,reserva);
    }
    //zona de geters

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public int getNroIdent() {
        return nroIdent;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    //zona de seters
    private void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
}