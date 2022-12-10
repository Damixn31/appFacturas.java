package org.olmedo.appFacturas.modelo;

public class ItemFactura {
  // Atributo
  private int cantidad;
  // Atributo Asociados
  private Producto producto;
  

  // Constructor
  public ItemFactura(int cantidad, Producto producto) {
    this.cantidad = cantidad;
    this.producto = producto;
  }


  // Getter and Setter
  public int getCantidad() {
    return cantidad;
  }
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public float calcularImporte() {
    return this.cantidad *= this.producto.getPrecio();
  }

  @Override
  public String toString(){
    return producto.toString() + //se le agregar el toString para que sea explicita y para que ejecute el modo depuracion y poder entrar a estos metodos
      "\t" + cantidad +
      "\t" + calcularImporte();
  }
}
