package org.olmedo.appFacturas.modelo;

public class Producto {
  // Atributos
  private int codigo;
  private String nombre;
  private float precio;
  
  private static int ultimoCodigo;


  // Constructor
  public Producto() {
    this.codigo = ++ultimoCodigo;
  }


  // Getter and Setter
  public int getCodigo() {
    return codigo;
  }
  // el set seria el ID lo vamos a generar de manera automatica por eso no va 
  /*public void setCodigo(int codigo) {
    this.codigo = codigo;
  }*/

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public float getPrecio() {
    return precio;
  }
  public void setPrecio(float precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return codigo +
      "\t" + nombre +
      "\t" + precio;
  }
}
