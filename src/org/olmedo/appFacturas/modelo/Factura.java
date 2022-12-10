package org.olmedo.appFacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

  // Atributo
  private int folio;
  private String descripcion;
  private Date fecha;
  // Atributo Asociados
  private Cliente cliente;
  private ItemFactura[] items;
  private int indiceItems; // como ItemFactura es un arreglo aca vamos a ir agregando los elementos con el metodo add. esto no va con set porque vamos a usar el metodo add
  // Constante para pasarle al contructor queda mejor de esta manera
  public static final int MAX_ITEMS = 12;
  public static int ultimoFolio;

  // Constructor
  public Factura(String descripcion, Cliente cliente) {
    this.descripcion = descripcion;
    this.cliente = cliente;
    this.items = new ItemFactura[MAX_ITEMS];
    this.folio = ++ultimoFolio; //pre incremento para que comienze en 1
    this.fecha = new Date();
  }
  // Getter and Setter
  public int getFolio() {
    return folio;
  }
  //set folio no va porque no tiene sentido porque se auto genera
  /*public void setFolio(int folio) {
    this.folio = folio;
  }*/

  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Date getFecha() {
    return fecha;
  }
  public void setDate(Date fecha) {
    this.fecha = fecha;
  }

  public Cliente getCliente() {
    return cliente;
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public ItemFactura[] getItems() {
    return items;
  }
  public void addItemFactura(ItemFactura item) {
    this.items[indiceItems++] = item;
  }

  public float calcularTotal() {
    float total = 0.0f;
    for(int i = 0; i < indiceItems; i++) {
    /*  if(item == null) { // tambien puedo poner !(item instanceof ItemFactura) las dos maneras son validas
        continue;
      }*/
      total += this.items[i].calcularImporte();
    }
    return total;
  }

  public String generarDetalle() {
    StringBuilder sb = new StringBuilder("Factura N: "); //es bueno usar StringBuilder cuando tenemos que concatener muchas cadenas(String)
    sb.append(folio).append("\nCliente: ")
      .append(this.cliente.getNombre())
      .append("\t NIF: ")
      .append(cliente.getNif())
      .append("\nDescripcion: ")
      .append(this.descripcion)
      .append("\n");

    SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
    sb.append("Fecha Emision: ")
      .append(df.format(this.fecha))
      .append("\n")
      .append("\n#\tNombre\t$\tCant.\tTotal\n");

    for(int i = 0; i < indiceItems; i++) {
      sb.append(this.items[i].toString())  // de manera implicita esta invocanto el metodo toString si queremos que sea de manera explicita colocar el toString()  
        .append("\n");
    }
    sb.append("\nGran Total: ")
      .append(calcularTotal());

    return sb.toString();
  }

  @Override
  public String toString() {
    return generarDetalle();
  }

}
