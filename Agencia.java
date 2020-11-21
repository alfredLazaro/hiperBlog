import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Agencia {
    private Administrador usuario;
    private HashMap<String,ArrayList<PaqueteTuristico>> lugaresTuristicos;
    private HashMap<Integer,Cliente> clientes;
    private ArrayList<Pasaje> pasajes;
    private String nombEmpresa;
  
   public Agencia(Administrador usuario, ArrayList<Pasaje> pasajes, String nomb,HashMap<String,ArrayList<PaqueteTuristico>> lugaresTuristicos, HashMap<Integer,Cliente> clientes){
        this.usuario = usuario;
        
        this.lugaresTuristicos=lugaresTuristicos;
        this.clientes= clientes;
        this.pasajes = pasajes;
        //paquetes =paqu;
        nombEmpresa = nomb;
    }
    public String getNombEmpresa(){
      return nombEmpresa;
    }
    //creacion alterna de la clase agencia
    public Agencia(){
      //paquetes=new ArrayList<PaqueteTuristico>();
      lugaresTuristicos = new HashMap<>();
      clientes=new HashMap<Integer,Cliente>();
      pasajes=new ArrayList<Pasaje>();
    }

    //get para prueba
    public void registrarCliente(String nombreCliente, int cantidadPasajeros, String temporadaPreferencia, String tipoViaje){ //se añade un cliente a la lista 
      Integer cod=generarCod();
      Cliente cliente=new Cliente(nombreCliente,cantidadPasajeros,temporadaPreferencia,tipoViaje,cod);
      clientes.put(cod,cliente);
      //System.out.println("Se registro el cliente");
    }

    private Integer generarCod(){
      Integer res=(int) (Math.random()*10000);
      if(clientes.get(res)==null){
        res=res;
        System.out.println(res);
      }else{
        res=generarCod();
      }
      return res;
    }
    
    private Cliente verificarExistencia(String nombreCliente, int nroIdent){
      Cliente res=clientes.get(nroIdent);
        boolean estaRegistrado=false;
        if(res!=null && res.getNombreCliente().equals(nombreCliente) ){
            res=res;
        }else{}
        return res;
    }
    //en aqui se procede a escoger y crear paquete personalizados
    private Restaurante escogeRestaurant(String restaurant,ArrayList<PaqueteTuristico> paquets){
      Restaurante res=null;
      for(PaqueteTuristico paq:paquets){
        Restaurante rest=paq.getRestaurant();
        if(restaurant.equals(rest.getNombreRest())){
          res=rest;
        }else{}
      }
      return res;
    }
    private Transporte escogerTransporte(String nombTrans,ArrayList<PaqueteTuristico> paquets){
      Transporte res=null;
      for(PaqueteTuristico paq:paquets){
        Transporte transp=paq.getTransporte();
        if(nombTrans.equals(transp.getTipoTransporte())){
          res=transp;
        }else{}
      }
      return res;
    }
    private Hotel escogerHotel(String nombHotel,ArrayList<PaqueteTuristico> paquets){
      Hotel res=null;
      for(PaqueteTuristico paq:paquets){
        Hotel hotel=paq.getHotel();
        if(nombHotel.equals(hotel.getNombre())){
          res=hotel;
        }else{}
      }
      return res;
    }
    public void agregarPaquete(String lugarDestino,String nombTransporte,String nombRestaurant,String nombHotel,int cantDias){
      ArrayList<PaqueteTuristico> paquetes=lugaresTuristicos.get(lugarDestino);
      
      Hotel hotel=escogerHotel(nombHotel, paquetes);
      Restaurante resta=escogeRestaurant(nombRestaurant, paquetes);
      Transporte trans=escogerTransporte(nombTransporte, paquetes);
      if(hotel==null){
        System.out.println("escoga otro hotel por favor");
      }else{
        if(resta==null){
          System.out.println("escoga otro restaurante por favor");
        }else{
          if(trans==null){
            System.out.println("escoga otro transporte por favor");
          }else{
            agregarPaquete(lugarDestino,trans,hotel,resta,cantDias);
            System.out.println("se añadio el paquete con exito");
          }
        }
      }
    }
    //esta seccion es de paquetes ya definidos
    public void agregarPaquete(String lugarDestino, Transporte transporte, Hotel hotel, Restaurante restaurant, int cantDias){
      PaqueteTuristico nuevoPaquete = new PaqueteTuristico(transporte,hotel,restaurant,cantDias);
       if(!lugaresTuristicos.containsKey(lugarDestino)){
         lugaresTuristicos.put(lugarDestino, new ArrayList<PaqueteTuristico>()); 
       }
       lugaresTuristicos.get(lugarDestino).add(nuevoPaquete);
    }

    private void eliminarPaquete(String lugarTuristico, int ide){
      boolean encontrado = false;
      if(lugaresTuristicos.containsKey(lugarTuristico)){
        ArrayList<PaqueteTuristico> paquetes = lugaresTuristicos.get(lugarTuristico);
        for(PaqueteTuristico paquete : paquetes){
          if(ide == paquete.getNroIde()){
            paquetes.remove(paquete);
            encontrado = true;
            System.out.println("Paquete removido");
            break;
          }
        }
        if(!encontrado){
          System.out.println("El paquete con la ide: "+ide+" no existe");
        }
      }else{
        System.out.println("No existen paquetes en el lugar indicado");
      }
    }
    
    public void reservarPaquetes(String nombreCliente,int nroIdentificacion,int cantPasajeros,int nroPaq,String lugarTuristico){
      Cliente client=verificarExistencia(nombreCliente,nroIdentificacion);
        if(client!=null){
          PaqueteTuristico paq=buscarPaquete(lugarTuristico,nroPaq);
          if(paq!=null && paq.getDisponible()==true){
            Reserva reserva=new Reserva(paq,null, client,new Date());
            System.out.println("el client: "+client);
            Historial h=client.getHistorial();
            System.out.println("el historial: "+h);
            client.getHistorial().actualizarHistorial(reserva);
            //por ahora la reserva de pasaje esta pendiente
          }else{
            //se debe buscar un paquete
            System.out.println("el paquete no se encuentra disponible, se debe buscar otro paquete");
          }
        }else{
          //se debe crear un cliente
          System.out.println("por favor cree un cliente en intente nuevamente");
        }
    }
    
    private PaqueteTuristico buscarPaquete(String lugarTuristico ,int nroIdent){
        PaqueteTuristico paq=null;
        ArrayList<PaqueteTuristico> paquetes = lugaresTuristicos.get(lugarTuristico);
        int i=0;
        boolean encontrado=false;
        while(i<paquetes.size()&&!encontrado){
            if(nroIdent==paquetes.get(i).getNroIde()){
                paq=paquetes.get(i);
                encontrado=true;
            }else{}
            i++;
        }
        return paq;
    }
    
    public void anularReserva(Cliente cliente){
        if(clientes.containsKey(cliente.getNroIdent())){
          Historial historialCliente = cliente.getHistorial();
          if(historialCliente != null){
           ArrayList<Reserva> reserva = historialCliente.getReservas();
            if(reserva != null){
              if(reserva.get(0).getEstado().equals("activo")){
                reserva.remove(0);
              }else{
                System.out.println("La reserva ya fue cancelada");
              }
            }else{
              System.out.println("El cliente no realizó ninguna reserva");
            }
         }else{
          System.out.println("El cliente no tiene registrado un historial");
         }
       }else{
         System.out.println("El cliente no se encuentra registrado");
       }
    }
    
    private void buscarLugarTuristico(){// interfaz 
      
    }
    
    private void BuscarHistorial(String nombreCliente,int nroReferencia){
       Cliente cliente = verificarExistencia(nombreCliente,nroReferencia);
       Historial historial = null;
        if(cliente != null){
          historial = cliente.getHistorial();
          if(historial == null){
            System.out.println("Historial vacío");
          }else{
            System.out.println();
            //no se como se va a mostrar el historial si puede ser que se lo devuelva y el tipo de dato cambie o por pantalla.
          }
        }else{
          System.out.println("El cliente no se encuentra registrado");
        }
    }
    
    private void reservaPasaje(String origen,String destino,int codClient,String nomClient,Date fechaIda,Date fechaVuelta,String tipoTransporte,String nombrEmpresa, int precio)
    {
      //este metodo debe llamarse obligatiriamente aunque con datos null (ecepto en cliente)
        Cliente client=verificarExistencia(nomClient, codClient);
        if(client!= null){
            Pasaje pasaje= new Pasaje(origen, destino, fechaIda, fechaVuelta, nomClient,tipoTransporte, nombrEmpresa,precio);
            ArrayList<Reserva> reservsCliente=client.getHistorial().getReservas();
            Reserva ultReserv=reservsCliente.get(0);
            ultReserv.setPasaje(pasaje);
            System.out.println("se aniadio el pasaje");
            //se crea la oferta
            crearOferta(ultReserv);
        }else{
            System.out.println("no se encontro el cliente");
        }
    }
    
   private void crearOferta(Reserva reserva){
        PaqueteTuristico paquet=reserva.getPaquete();
        Pasaje pasaj=reserva.getPasaje();
        Cliente cliente=reserva.getCliente();
        if(paquet!=null && pasaj!=null){
            //oferta no necesita aniadir Fechasfestivos
            Oferta oferta=new Oferta();
            if(cliente.esFrecuente()){
                oferta.generarOfertaClienteFrecuente(reserva);
            }else{}
            if(reserva.getPaquete().existeOfertaDias()){
            oferta.generarOfertaCantDias(reserva);
        }else{}
            if(reserva.getCliente().exiteOfertaPasajeros()){
            oferta.generarOfertaCantPasajeros(reserva);
            }
            oferta.generarOfertaFechasFestivas(reserva);
        }else{}
    }
   //se añiaden metodos necesarios
   public HashMap<Integer,Cliente> getClientes(){
       return clientes;
    }
    
    public HashMap<String,ArrayList<PaqueteTuristico>> getLugaresTuristicos(){
        return lugaresTuristicos;
    }
}