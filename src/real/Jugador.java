
package real;

public class Jugador {
    private String id_jugador;
    private String nombre_jugador;
    private int horasjugadas;
    private double pagoporhora;
    private double sueldo_jugador;
    private double rebaja;
    private double caridad;
    private double total;
    
public void setId_jugador(String id_jugador){
    this.id_jugador = id_jugador;
}
public void setNombreJugador(String nombre_jugador){
    this.nombre_jugador = nombre_jugador;
}
public void setHorasjugadas(int horasjugadas){
    this.horasjugadas = horasjugadas;
}
 public void setPago(double pagoporhora){
        this.pagoporhora = pagoporhora;
    }
  public void setSueldo(double sueldo_jugador){
        this.sueldo_jugador = sueldo_jugador;
    }
  public void setRebaja(double rebaja){
        this.rebaja = rebaja;
    }
  public void setCaridad(double caridad){
        this.caridad = caridad;
    }
  public void setTotal(double total){
        this.total = total;
    }
   public void setCalcularSueldo(){
        sueldo_jugador = horasjugadas*pagoporhora;
    }
    public void setCalcularRebaja(){
        rebaja = sueldo_jugador*20/100;
    }     
    public void setCalcularCaridad(){
        caridad = sueldo_jugador*5/100;
    }
    public void setCalcularTotal(){
        total= sueldo_jugador-rebaja-caridad;
    }
    public String getIdJugador(){
        return id_jugador;
    }
    public String getNombre(){
        return nombre_jugador;
    }
    public int getHoras(){
        return horasjugadas;
    }
    public Double getPago(){
        return pagoporhora;
    }
    public Double getSueldo(){
        return sueldo_jugador;
    }
    public Double getRebaja(){
        return rebaja;
    }
    public Double getCaridad(){
        return caridad;
    }
    public Double getTotal(){
        return total;
    }
}
  
  
 

