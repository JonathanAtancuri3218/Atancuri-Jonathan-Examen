package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Tarjeta;

public class TarjetaFacade extends AbstractFacade<Tarjeta>{

	
	@PersistenceContext(unitName = "Atancuri-Jonathan-Examen")
    private EntityManager em;
    
    public TarjetaFacade() {
	super(Tarjeta.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
