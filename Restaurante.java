import java.util.ArrayList;
public class Restaurante {
    private String nombreRest;
    private ArrayList<Comida> menu;
    private String ubicacion;

    public Restaurante( String ubicacion,String nombreRest) {
        menu = new ArrayList<Comida>();
        this.ubicacion = ubicacion;
        this.nombreRest=nombreRest;
    }

    public void agregarPlato(Comida plato){
        menu.add(plato);
    }
    
    public void eliminarPlato (Comida platoEliminar){
      boolean eliminado = false;
      if (menu.size() != 0){
        for (int i = 0 ; i<menu.size() && !eliminado; i++){
          Comida platoI = menu.get(i);
          String plato1 = platoEliminar.getPlato();
          String plato2 = platoI.getPlato();
          if (plato1.equals(plato2)){
            menu.remove(i);
            eliminado = true;
          }
        }
      }
    }
    //zona de geters
    public ArrayList<Comida> getMenu() {
        return menu;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    public String getNombreRest() {
      return nombreRest;
    }
    //zona seters
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int calcularPrecioMenu (){
      int precio = 0;
      if (menu.size() != 0){
        for (int i = 0; i<menu.size();i++){
          Comida comidai = menu.get(i);
          precio = precio + comidai.getPrecio();
        }
      }
      return precio;
    }
    
}