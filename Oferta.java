import java.util.ArrayList;
import java.util.Date;

public class Oferta{
  private ArrayList<Date> fechasFestivas;
  private boolean oferta;

  public Oferta (ArrayList<Date>fechasFestivas){
   this.fechasFestivas = fechasFestivas;
   oferta = false;
  }
  public Oferta(){
    fechasFestivas = new ArrayList<>();
    oferta=false;
  }

  public void generarOfertaCantPasajeros(Reserva r){
    int descuento = 3;
    PaqueteTuristico paquete = r.getPaquete() ;
    Pasaje pasaje = r.getPasaje() ;
    int precioPaquete = paquete.calcularPrecio();
    int precioPasaje = pasaje.getPrecioTotal();
    precioPaquete = precioPaquete - ((precioPaquete*descuento)/100);
    precioPasaje =  precioPasaje - ((precioPasaje*descuento)/100);
    pasaje.setPrecioTotal(precioPasaje);
     paquete.setPrecio(precioPaquete);    
  }

  public void generarOfertaFechasFestivas(Reserva r){
    boolean encontrado = false;
    for (int i = 0; i<fechasFestivas.size() && !encontrado; i++){
      PaqueteTuristico paquete = r.getPaquete() ;
      Pasaje pasaje = r.getPasaje() ;
      Date fecha1 = pasaje.getFechaIda();
      Date fecha2 = pasaje.getFechaVuelta();
      Date fechaFestiva = fechasFestivas.get(i);
      if (fecha1.compareTo(fechaFestiva)<=0){ 
        if(fecha2.compareTo(fechaFestiva)>=0){
        int descuento = 5;
        int precioPaquete = paquete.calcularPrecio();
        int precioPasaje = pasaje.getPrecioTotal();
        precioPaquete = precioPaquete - ((precioPaquete*descuento)/100);
        precioPasaje =  precioPasaje - ((precioPasaje*descuento)/100);
        encontrado = true;
        pasaje.setPrecioTotal(precioPasaje);
        paquete.setPrecio(precioPaquete);
      }
     }
    }
  }

  public void generarOfertaClienteFrecuente(Reserva r){
      int descuento = 5;
      PaqueteTuristico paquete = r.getPaquete() ;
      Pasaje pasaje = r.getPasaje() ;
      int precioPaquete = paquete.calcularPrecio();
      int precioPasaje = pasaje.getPrecioTotal();
      precioPaquete = precioPaquete - ((precioPaquete*descuento)/100);
      precioPasaje =  precioPasaje - ((precioPasaje*descuento)/100);
      pasaje.setPrecioTotal(precioPasaje);
      paquete.setPrecio(precioPaquete);
  }

  public void generarOfertaCantDias(Reserva r){
    int descuento = 3;
    PaqueteTuristico paquete = r.getPaquete() ;
    Pasaje pasaje = r.getPasaje() ;
    int precioPaquete = paquete.calcularPrecio();
    int precioPasaje = pasaje.getPrecioTotal();
    precioPaquete = precioPaquete - ((precioPaquete*descuento)/100);
    precioPasaje =  precioPasaje - ((precioPasaje*descuento)/100);
    pasaje.setPrecioTotal(precioPasaje);
    paquete.setPrecio(precioPaquete);
  }

  public boolean getOferta(){
    return oferta;
  }
  public void setOferta(){
    this.oferta = true;
  }
}