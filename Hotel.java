public class Hotel {
    private int precioUnitario;
    private String ubicacion;
    private boolean existeVacante;
    private String nombre;
    private int cantHabitacionesHabilitadas;
    private int cantHabitacionesUsadas;

    public Hotel(int precioUnitario, String ubicacion,String nombre) {
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        existeVacante = true;
        cantHabitacionesHabilitadas = 30;
        cantHabitacionesUsadas = 0;
    }
    //espacio de los geters

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNombre(){
        return nombre;
    }
    
    //espacio de los seters

    public void setNombre (String nombre){
      this.nombre = nombre;
    }

    public void setExisteVacante(boolean existeVacante) {
        this.existeVacante = existeVacante;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean existenVacantes(boolean existeReserva){
      boolean respuesta = false;
      if (existeReserva){
        cantHabitacionesUsadas++;
        if (cantHabitacionesUsadas <= cantHabitacionesHabilitadas){
          respuesta = true;
        }
      }
      return respuesta;
    }
    
}