import java.util.ArrayList;
import java.util.Date;
public class Cliente {
        private ArrayList<String> lugaresFrecuentes;
        private String nombreCliente;
        private int cantidadPasajeros;
        private String temporadaPreferencia;
        private String tipoViaje;
        private boolean frecuencia;
        private boolean tienePaquete;
        private Pasaje pasaje;
        private int nroIdent;
        private Historial historial;
    public Cliente(String nombreCliente, int cantidadPasajeros, String temporadaPreferencia, String tipoViaje,int nroId){
      this.nombreCliente=nombreCliente;
      this.cantidadPasajeros=cantidadPasajeros;
      this.temporadaPreferencia=temporadaPreferencia;
      this.tipoViaje=tipoViaje;
      frecuencia=false;
      tienePaquete=false;
      pasaje=null;
      nroIdent=nroId;
      historial= new Historial(getNroIdent(),new Date()); //
      
      }
    
    public boolean esFrecuente(){
      ArrayList<Reserva> reservas=historial.getReservas();
      int cantUsado,tamReservas;
      cantUsado=0;
      tamReservas=reservas.size();
      if(tamReservas>20){
          for(int i=0;i<tamReservas;i++){
              Reserva reserva=reservas.get(i);
              if(reserva.getEstado().equals("usado")){
                  cantUsado=cantUsado+1;
              }else{}
              if(cantUsado>=19){
                  setFrecuencia(true);
              }
          }
      }else{}
      return frecuencia;
    }

    public boolean exiteOfertaPasajeros(){
      boolean existe=false;
      if(cantidadPasajeros>6){
        existe=true;
      }
      return existe;
    }

    //zona de seters y geters
    public void setFrecuencia(boolean frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setTienePaquete(boolean tienePaquete) {
        this.tienePaquete = tienePaquete;
    }

    public boolean getTienePaquete(){
      return tienePaquete;
    }

    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }

    public boolean getFrecuencia () {
      return frecuencia;
    }

    public int getCantidadPasajeros(){
      return cantidadPasajeros;
    }

    public ArrayList<String> getLugaresFrecuentes() {
        return lugaresFrecuentes;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Pasaje getPasaje() {
        return pasaje;
    }

    public String getTemporadaPreferencia() {
        return temporadaPreferencia;
    }

    public Historial getHistorial(){
      System.out.println("el hitorial es;"+historial);
      return historial;
    }
    
    public int getNroIdent() {
      return nroIdent;
    }
}