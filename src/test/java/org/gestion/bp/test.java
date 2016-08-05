package org.gestion.bp;

import org.gestion.bp.entities.Client;
import org.gestion.bp.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
		IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
		
		metier.addClient(new Client("C1","AD1"));
		metier.addClient(new Client("C2","AD2"));

	}

}
