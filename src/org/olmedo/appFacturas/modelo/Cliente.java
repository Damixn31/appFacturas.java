package org.olmedo.appFacturas.modelo;

public class Cliente {
  // Atributos
  private String nombre;
  private String nif; //nif es el numero de identificacion fiscal o tributaria


  // Getter and Setter
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  } 
  
  public String getNif() {
    return nif;
  }
  public void setNif(String nif) {
    this.nif = nif;
  }
}
