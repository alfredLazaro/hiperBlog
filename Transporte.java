public class Transporte {
    private int precio;
    private String origen;
    private String tipoTransporte;

    public Transporte(int precio, String origen, String tipoTransporte) {
        this.precio = precio;
        this.origen = origen;
        this.tipoTransporte = tipoTransporte;
    }

    public String getTipoTransporte(){
      return tipoTransporte;
    }

    public String getOrigen() {
        return origen;
    }

    public int getPrecio() {
        return precio;
    }


    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setPresio(int precio) {
        this.precio = precio;
    }
    
}