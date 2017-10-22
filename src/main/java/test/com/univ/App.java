package test.com.univ;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.univ.Person;
import com.univ.Rent;
import com.univ.Vehicule;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
    	try{
    		
			tx.begin();
			
			//Define
			Person p = new Person();
			Rent rent = new Rent();
			Vehicule car = new Vehicule();
			
			p.setName("Tintin");
					
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date beginDate = dateFormat.parse("23/09/2015");
			p.setDate(beginDate);
			
			rent.setBeginRent(beginDate);
			rent.setEndRent(beginDate);
			
			car.setPlateNumber("京NNA917");
			
			rent.setUser(p);
			rent.setCar(car);
			
			
			
			//run
			
			entityManager.persist(p);
			entityManager.persist(rent);
			entityManager.persist(car);
				
			tx.commit();			
		
		}catch(Exception e){
			tx.rollback();
		}
		
	}
}
