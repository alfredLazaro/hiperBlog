import java.util.ArrayList;
import java.util.Date;

public class Pasaje {
    private String origen;
    private String destino;
    private int precioTotal;
    private Date fechaIda;
    private Date fechaVuelta;
    private String nombreCliente;
    private String empresa;
    private String tipoTransporte;

    public Pasaje(String origen, String destino, Date fechaIda, Date fechaVuelta, String nombreCliente, String tipoTransporte, String empresa, int precioTotal) {
        this.origen = origen;
        this.destino = destino;
        this.precioTotal = precioTotal;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.nombreCliente = nombreCliente;
        this.empresa = empresa;
        this.tipoTransporte = tipoTransporte;
    }

//zona seters
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }

    public void setFechaVuelta(Date fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
    //zona geters
    public String getDestino() {
        return destino;
    }

    public Date getFechaIda() {
        return fechaIda;
    }

    public Date getFechaVuelta() {
        return fechaVuelta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getOrigen() {
        return origen;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }
    
    public String getEmpresa(){
        return empresa;
    }

    public String getTipoTransporte(){
        return tipoTransporte;
    }
}