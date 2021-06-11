package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import ec.edu.ups.ejb.ComidaFacade;
import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.entidad.Comida;
import ec.edu.ups.entidad.Pedido;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "comidaBean")
@SessionScoped
public class ComidaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
    private ComidaFacade comidaFacade;
    
	private int codigo;
	private String nombre;
	private double precio_unitario;
    private List<Comida> comidas;
    private Comida comida;
    private Pedido pedidos;
    private PedidoFacade pedidoFacade;
   
    
    
    public String add() {

        if (this.comida != null) {
            //Inventario inventario = new Inventario(this.cantidad);
            //inventario.setBodega(this.bodega);

            Comida comida = new Comida();
            comida.setCodigo(this.codigo);
            comida.setNombre(this.nombre);
            //comida.setPedido(this.pedidos);
            comida.setPrecio_unitario(this.precio_unitario);


            //producto.addInventario(inventario);

            pedidoFacade.create(pedidos);
        } else {
            FacesMessage message = new FacesMessage("Debe seleccionar una categoria y una bodega");
            throw new ValidatorException(message);
        }

        //this.comida = this.comidaFacade.findAll();
        return null;

    }


    public String save(Comida comida) {
        //System.out.println("Medida a editar..." + medida);
         comida.setCodigo(this.codigo);
         comida.setNombre(this.nombre);
         comida.setPrecio_unitario(this.precio_unitario);
         //comida.setPedido(pedidos);
         //this.comidas = this.comidaFacade.findAll();
         return null;
     }

}
