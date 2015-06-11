
/*
 * Copyright (C) 2015 UTN-FRRe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dacs.tpi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Cliente;
import model.Direccion;
import model.Estado;
import model.Paquete;
import model.Sucursal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author Dr. Jorge Eduardo Villaverde
 *
 */
public class JpaDemo {

	private static final Logger logger = 
			LoggerFactory.getLogger(JpaDemo.class);
	
	private static final String PERSISTENCE_UNIT_NAME = "tpidacs";
	
	private static EntityManagerFactory factory;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Paso 1: Obtener el Entity Manager Factory 
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		logger.info("Paso 1: OK, tengo el EM Factory");
		
		// Paso 2: Obtener el Entity Manager
		EntityManager entityManager = factory.createEntityManager();
		
		logger.info("Paso 2: OK, tengo el Entity Manager");
		
		// Paso 3: Ejecutar consultas
		
		ejecutarConsultasProvincias(entityManager);
		
		logger.info("Paso 3: OK, consultas ejecutadas");
		
		// Paso 4: cierro el Entity Manager
		entityManager.close();
		
		logger.info("Paso 4: OK, Entity Manager cerrado");
		
		// Paso 5: cierro el EM Factory
		factory.close();
		
		logger.info("Paso 5: OK, cierro el EM Factory");
	}

	private static void ejecutarConsultasProvincias(EntityManager entityManager) {
		
		Cliente cliente = insertarRegistros(entityManager);
		
		leerRegistros(entityManager);
		
		//actualizarRegistros(entityManager, cliente);
		
		//borrarRegistros(entityManager, provincia);
		
		//leerRegistros(entityManager);
	}

	@SuppressWarnings("unchecked")
	private static void leerRegistros(EntityManager entityManager) {
		logger.info("Paso 3: leer las provincias.");
		
		Query q = entityManager.createQuery("select c from Cliente c");
	    
		List<Cliente> provincias = q.getResultList();
		
		
	    /*for (Cliente provincia : provincias) {
	    	System.out.println(provincia.getDireccion().getCalle());
	    	logger.info("Provincia: id = " 
	    			+ provincia.getId()
	    			+ ", nombre = "
	    			+ provincia.getNombre()
	    			+",calle = "
	    			+ provincia.getDireccion().getCalle());
	    	
	    }
	    */
	    
	    	 q = entityManager.createQuery("select c from Sucursal c");
	    
	    	 List<Sucursal> sucursales = q.getResultList();
		
		
	    for (Sucursal sucursal : sucursales) {
	    	System.out.println("sucursal calle: "+sucursal.getDireccion().getCalle());
	    	logger.info("Provincia: id = " 
	    			+ sucursal.getId()
	    			+ ", nombre = "
	    			+ sucursal.getTelefono()
	    			+",calle = "
	    			+ sucursal.getDireccion().getCalle());
	    	
	    }
	    
	    q = entityManager.createQuery("select p from Paquete p");
	    
   	 	List<Paquete> paquetes = q.getResultList();
	
	
   	 	for (Paquete paquete : paquetes) {
   	 		
   	 		logger.info("Provincia: id = " 
   			+ paquete.getId()
   			+ ", nombre = "
   			+ paquete.getTamaño());
   	 		System.out.println("estados!!");
   	 		for (Estado estado: paquete.getEstado()){
   	 			System.out.println(estado.getLatitud()+" "+estado.getLongitud()+" sucursal: "+estado.getSucursal().getEmail());
   	 			
   	 		}   	 		
   	 	}    
	}

	private static void borrarRegistros(EntityManager entityManager, Cliente provincia) {
		logger.info("Paso 3: borrar la provincia: id = " 
	    			+ provincia.getId()
	    			+ ", nombre = "
	    			+ provincia.getNombre());
		
		entityManager.getTransaction().begin();
		entityManager.remove(provincia);
		entityManager.getTransaction().commit();
		
		logger.info("Paso 3: se ha borrado la provincia: " + provincia.getNombre());
	}

	private static void actualizarRegistros(EntityManager entityManager, Cliente cliente) {
		logger.info("Paso 3: actualizar una provincia.");
		
		cliente.setNombre("hipolito  Sodero");
		
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		
		logger.info("Paso 3: se ha actualizar la provincia: " + cliente.getNombre());
	}

	private static Cliente insertarRegistros(EntityManager entityManager) {
		logger.info("Paso 3: insertar una provincia.");
		
		
		
		Direccion direccion = new Direccion();
		direccion.setCiudad("Corrientes");
		direccion.setCalle("tucuman");
		direccion.setAltura(1814);
		direccion.setProvincia("Corrientes");
		direccion.setPais("Argentina");
		/*		
		Cliente cliente = new Cliente();
		cliente.setDireccion(direccion);
		cliente.setEmail("jerosode@gmail.com");
		cliente.setTelefono("4234693482");
		cliente.setFecNac(new Date());
		cliente.setNombre("Jeronimo Sodero");
		cliente.setCUIL(123L);
		cliente.setDNI(37886892L);
		*/
		
		Sucursal sucursal = new Sucursal();
		sucursal.setEmail("caca@pichi.com");
		sucursal.setTelefono("444-222");
		sucursal.setDireccion(direccion);
		
		Estado estado1 = new Estado();
		estado1.setFecha_Hora(new Date());
		estado1.setLatitud(30);
		estado1.setLongitud(40);
		estado1.setSucursal(sucursal);
		
		Estado estado2 = new Estado();
		estado2.setFecha_Hora(new Date());
		estado2.setLatitud(55);
		estado2.setLongitud(65);
		estado2.setSucursal(sucursal);
		
		
		
		
		Paquete paquete = new Paquete();
		paquete.setContenido("droga");
		paquete.setPeso(30);
		paquete.setTamaño(300);
		
		List<Estado> estados = new ArrayList<Estado>();
		estados.add(estado1);
		estados.add(estado2);
		
		paquete.setEstado(estados);
		estado1.setPaquete(paquete);
		estado2.setPaquete(paquete);
		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(direccion);
		entityManager.persist(sucursal);
		entityManager.persist(estado1);
		entityManager.persist(estado2);
		entityManager.persist(paquete);
		
		
		
		
		//entityManager.persist(cliente);
		
		entityManager.getTransaction().commit();	
		
		//logger.info("Paso 3: se ha creado la provincia: " + cliente.getNombre());
		
		return null;
	}

}