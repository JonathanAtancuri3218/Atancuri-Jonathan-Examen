package ec.edu.ups.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Pedido;


public class PedidoFacade extends AbstractFacade<Pedido>{

	

	@PersistenceContext(unitName = "Atancuri-Jonathan-Examen")
    private EntityManager em;
    
    public PedidoFacade() {
	super(Pedido.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Pedido> findPedidosNombre() {
        String jpql = "FROM Usuario u WHERE u.rol = 'cliente' ORDER BY u.nombre DESC";
        return (List<Pedido>)em.createQuery(jpql).getResultList();
    }
    
    public List<Pedido> findPedidosTarjeta() {
        String jpql = "FROM Usuario u WHERE u.rol = 'cliente' ORDER BY u.nombre DESC";
        return (List<Pedido>)em.createQuery(jpql).getResultList();
    }
    public List<Pedido> findByName(String name) {
        //System.out.println("llego al metodo de buscar...............................");
        
        //System.out.println("nombre....... " + name.toString());
        String jpql = "FROM Pedido b WHERE b.numero LIKE '" + name + "%'";
        
        //System.out.println("Lista================================== " +  em.createQuery(jpql).getResultList());
        return (List<Pedido>) em.createQuery(jpql).getResultList();
    }

}
