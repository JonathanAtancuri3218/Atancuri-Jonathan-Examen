package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PedidoFacade;
import ec.edu.ups.entidad.Pedido;



@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EJB
    private PedidoFacade pedidoFacade;
    //@EJB 
    //private LocalidadFacade localidadFacade;
	private int numero;
	private String fecha;
	private String nombre_cliente;
	private double subtotal;
	private double iva;
	private double total;
    private List<Pedido> pedidos;
    private String nombreBodega;

    public PedidoBean() {
    }

    @PostConstruct
    public void init() {
        try {
            this.pedidos = pedidoFacade.findAll();
        } catch (Exception e) {
            System.out.println("Error---" + e);
        }
    }

    public PedidoFacade getPedidoFacade() {
		return pedidoFacade;
	}

	public void setPedidoFacade(PedidoFacade pedidoFacade) {
		this.pedidoFacade = pedidoFacade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getNombreBodega() {
		return nombreBodega;
	}

	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}

	public void guardarDatos() {
        
        System.out.println("llegando los datos.............................................................................................");
        
        //Localidad newLocalidad = new Localidad(this.pais, this.provincia, this.Ciudad, this.direccion, this.telefono);
        Pedido pedido = new Pedido();
        
        pedido.setNumero(this.numero);
        pedido.setFecha(this.fecha);
        pedido.setNombre_cliente(this.nombre_cliente);
        pedido.setSubtotal(this.subtotal);
        pedido.setIva(this.iva);
        pedido.setTotal(this.total);
        
        //newLocalidad.setBodega(bodega);
        //bodega.setLocalidad(newLocalidad);
        
        
        pedidoFacade.create(pedido);
        
        this.pedidos = pedidoFacade.findAll();

    }

    public String delete(Pedido b) {
        System.out.println("esta entrando al metodo eliminar......." + b);
        this.pedidoFacade.remove(b);
        this.pedidos = pedidoFacade.findAll();
        return null;
    }

    public String edit(Pedido b) {
        //b.setEditable(true);
        return null;
    }

    public String save(Pedido b) {
        pedidoFacade.edit(b);
        //System.out.println("Nueva localidad: "+b.getLocalidad().toString());
        //b.setEditable(false);
        this.pedidos = pedidoFacade.findAll();
        return null;
    }
    
    public void newPedido() {
        this.numero=0;
        this.fecha="";
        this.nombre_cliente="";
        this.subtotal=0;
        this.iva=0;
        this.total=0;
            
   }
    
    public void buscarPorNombre() {
        if (nombreBodega != null) {
            //System.out.println("Cambio de item em bodega..." +bodegaItem.toString());
            this.pedidos = pedidoFacade.findByName(this.nombreBodega);
        } else {
            //System.out.println("Es nulo... ");
            this.pedidos = this.pedidoFacade.findAll();    
        }
        
        //System.out.println("Nombre............ " + nombreBodega);
    }
    public void listar() {
       
         try {
            this.pedidos = pedidoFacade.findAll();
            //System.out.println("Lista categorias" + this.bodegas);

        } catch (Exception e) {
            System.out.println("Error---" + e);
        }
         nombreBodega = null;
    }
	    
	    
	}

