package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Pedido;

public class ComidaFacade extends AbstractFacade<Pedido>{

	
	 @PersistenceContext(unitName = "Atancuri-Jonathan-Examen")
	    private EntityManager em;

	    public ComidaFacade() {
	        super(Pedido.class);
	    }
	    
	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	
}
