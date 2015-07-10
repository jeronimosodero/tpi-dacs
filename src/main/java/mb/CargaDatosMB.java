package mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.transaction.UserTransaction;

import model.Administrador;
import model.Cliente;
import model.Direccion;
import model.Empleado;
import model.Orden;
import model.Ruta;
import model.Seguro;
import model.Servicio;
import model.Sucursal;
import model.Unidad;
import model.Viaje;
import facade.AdministradorFacade;
import facade.ClienteFacade;
import facade.DireccionFacade;
import facade.EmpleadoFacade;
import facade.OrdenFacade;
import facade.RutaFacade;
import facade.SeguroFacade;
import facade.ServicioFacade;
import facade.SucursalFacade;
import facade.UnidadFacade;
import facade.ViajeFacade;

@ManagedBean
@RequestScoped
public class CargaDatosMB implements Serializable {

	private static final String LIST_ALL_CLIENTES = "listAllClientes";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteFacade clienteFacade;

	@EJB
	private DireccionFacade direccionFacade;

	@EJB
	private AdministradorFacade administradorFacade;

	@EJB
	private SucursalFacade sucursalFacade;

	@EJB
	private EmpleadoFacade empleadoFacade;

	@EJB
	private UnidadFacade unidadFacade;

	@EJB
	private RutaFacade rutaFacade;
	
	@EJB
	private SeguroFacade seguroFacade;

	@EJB
	private ServicioFacade servicioFacade;
	
	@EJB
	private ViajeFacade viajeFacade;
	
	@EJB
	private OrdenFacade ordenFacade;
	
	
	@Resource
	UserTransaction tx;

	public String cargaDatos() {
		try {
			tx.begin();

			// CREO DIRECCIONES
			Direccion d1 = new Direccion();
			d1.setCalle("Vedia");
			d1.setAltura(740);
			d1.setCiudad("CORRIENTES");
			d1.setDepartamento(1);
			d1.setPais("Argentina");
			d1.setPiso(1);
			d1.setProvincia("CORRIENTES");
			Direccion d2 = new Direccion();
			d2.setCalle("Junin");
			d2.setAltura(900);
			d2.setCiudad("RESISTENCIA");
			d2.setDepartamento(1);
			d2.setPais("Argentina");
			d2.setPiso(1);
			d2.setProvincia("CHACO");
			Direccion d3 = new Direccion();
			d3.setCalle("Junin");
			d3.setAltura(900);
			d3.setCiudad("CORRIENTES");
			d3.setDepartamento(1);
			d3.setPais("Argentina");
			d3.setPiso(1);
			d3.setProvincia("CORRIENTES");
			Direccion d4 = new Direccion();
			d4.setCalle("Junin");
			d4.setAltura(900);
			d4.setCiudad("RESISTENCIA");
			d4.setDepartamento(1);
			d4.setPais("Argentina");
			d4.setPiso(1);
			d4.setProvincia("CHACO");
			Direccion d5 = new Direccion();
			d5.setCalle("Junin");
			d5.setAltura(900);
			d5.setCiudad("RESISTENCIA");
			d5.setDepartamento(1);
			d5.setPais("Argentina");
			d5.setPiso(1);
			d5.setProvincia("CHACO");
			Direccion d6 = new Direccion();
			d6.setCalle("Junin");
			d6.setAltura(900);
			d6.setCiudad("CORRIENTES");
			d6.setDepartamento(1);
			d6.setPais("Argentina");
			d6.setPiso(1);
			d6.setProvincia("CORRIENTES");

			direccionFacade.save(d1);
			direccionFacade.save(d2);
			direccionFacade.save(d3);
			direccionFacade.save(d4);
			direccionFacade.save(d5);
			direccionFacade.save(d6);

			// CREO CLIENTES

			Cliente c1 = new Cliente();
			c1.setNombre("Paulo Muchutti");
			c1.setFecNac(new Date());
			c1.setTelefono("4222544");
			c1.setCUIL(20378883075L);
			c1.setEmail("paslo@gmail.com");
			c1.setDNI();
			c1.setPass();
			c1.setRole();
			c1.setDireccion(d1);
			Cliente c2 = new Cliente();
			c2.setNombre("Yaccuzzi Nelson");
			c2.setFecNac(new Date());
			c2.setTelefono("4222544");
			c2.setCUIL(20278886075L);
			c2.setDireccion(d2);
			c2.setEmail("nelson@hotmail.com");
			c2.setDNI();
			c2.setPass();
			c2.setRole();
			Cliente c3 = new Cliente();
			c3.setNombre("Jeronimo Sodero");
			c3.setFecNac(new Date());
			c3.setTelefono("4222544");
			c3.setCUIL(10378886075L);
			c3.setDireccion(d3);
			c3.setEmail("jerosode@gmail.com");
			c3.setDNI();
			c3.setPass();
			c3.setRole();
			Cliente c4 = new Cliente();
			c4.setNombre("Julian Ruiz Diaz");
			c4.setFecNac(new Date());
			c4.setTelefono("4222544");
			c4.setCUIL(50308886075L);
			c4.setDireccion(d4);
			c4.setEmail("julian_rd7@hotmail.com");
			c4.setDNI();
			c4.setPass();
			c4.setRole();
			Cliente c5 = new Cliente();
			c5.setNombre("Santiago Calcagno");
			c5.setFecNac(new Date());
			c5.setTelefono("4222544");
			c5.setCUIL(60378886075L);
			c5.setDireccion(d5);
			c5.setEmail("santiagofet@hotmail.com");
			c5.setDNI();
			c5.setPass();
			c5.setRole();
			Cliente c6 = new Cliente();
			c6.setNombre("Matias Wajnman");
			c6.setFecNac(new Date());
			c6.setTelefono("4222549");
			c6.setCUIL(60278886075L);
			c6.setDireccion(d6);
			c6.setEmail("matias@hotmail.com");
			c6.setDNI();
			c6.setPass();
			c6.setRole();

			clienteFacade.save(c1);
			clienteFacade.save(c2);
			clienteFacade.save(c3);
			clienteFacade.save(c4);
			clienteFacade.save(c5);
			clienteFacade.save(c6);

			// CREO ADMINISTRADOR
			Administrador admin = new Administrador();
			admin.setRole();
			admin.setNombre("Admin");
			admin.setFechaNac(new Date());
			admin.setFechaIng(new Date());
			admin.setEmail("tpi@dacs.com");
			admin.setCUIL(90378886075L);
			admin.setPass();
			admin.setDNI();

			administradorFacade.save(admin);

			// CREO DIRECCION PARA SUCURSAL
			Direccion ds1 = new Direccion("Vedia", 400, 1, 1, "Resistencia",
					"Chaco", "Argentina");
			Direccion ds2 = new Direccion("Junin", 500, 1, 1, "Formosa",
					"Formosa", "Argentina");
			Direccion ds3 = new Direccion("San Lorenzo", 600, 1, 1,
					"Colonia Benitez", "Chaco", "Argentina");
			Direccion ds4 = new Direccion("Irgoyen", 400, 1, 1, "Posadas",
					"Misiones", "Argentina");
			Direccion ds5 = new Direccion("3 de abri", 400, 1, 1, "Itati",
					"Corrientes", "Argentina");
			Direccion ds6 = new Direccion("Belgrano", 400, 1, 1, "Ituzaingo",
					"Corrientes", "Argentina");
			Direccion ds7 = new Direccion("Bolivar", 400, 1, 1,
					"Paso de la Patria", "Corrientes", "Argentina");
			Direccion ds8 = new Direccion("Callao", 400, 1, 1, "Buenos Aires",
					"Buenos Aires", "Argentina");
			Direccion ds9 = new Direccion("25 de mayo", 400, 1, 1, "Rosario",
					"Rosario", "Argentina");
			Direccion ds10 = new Direccion("San Martin", 400, 1, 1, "Santa Fe",
					"Santa Fe", "Argentina");
			Direccion ds11 = new Direccion("Quintana", 400, 1, 1, "Corrientes",
					"Corrientes", "Argentina");

			direccionFacade.save(ds1);
			direccionFacade.save(ds2);
			direccionFacade.save(ds3);
			direccionFacade.save(ds4);
			direccionFacade.save(ds5);
			direccionFacade.save(ds6);
			direccionFacade.save(ds7);
			direccionFacade.save(ds8);
			direccionFacade.save(ds9);
			direccionFacade.save(ds10);
			direccionFacade.save(ds11);

			// CREO SUCURSAL
			Sucursal s1 = new Sucursal("454445", "resistencia@hotmail.com",
					ds1, -27.4606615, -58.9953453);
			Sucursal s2 = new Sucursal("454445", "formosa@hotmail.com", ds2,
					-26.1721559, -58.1949699);
			Sucursal s3 = new Sucursal("454445", "colonia_benitez@hotmail.com",
					ds3, -27.3333046, -58.933333);
			Sucursal s4 = new Sucursal("454445", "posadas@hotmail.com", ds4,
					-27.3963094, -55.9245158);
			Sucursal s5 = new Sucursal("454445", "itati@hotmail.com", ds5,
					-27.269916, -58.2438316);
			Sucursal s6 = new Sucursal("454445", "ituzaingo@hotmail.com", ds6,
					-27.5899083, -56.6892701);
			Sucursal s7 = new Sucursal("454445", "pasodelapatria@hotmail.com",
					ds7, -27.3166691, -58.5833282);
			Sucursal s8 = new Sucursal("454445", "buenosaires@hotmail.com",
					ds8, -34.6158238, -58.4333203);
			Sucursal s9 = new Sucursal("454445", "rosario@hotmail.com", ds9,
					-32.9523035, -60.6981577);
			Sucursal s10 = new Sucursal("454445", "santafe@hotmail.com", ds10,
					-31.6181427, -60.7062571);
			Sucursal s11 = new Sucursal("454445", "corrientes@hotmail.com",
					ds11, -27.4862516, -58.7923866);

			sucursalFacade.save(s1);
			sucursalFacade.save(s2);
			sucursalFacade.save(s3);
			sucursalFacade.save(s4);
			sucursalFacade.save(s5);
			sucursalFacade.save(s6);
			sucursalFacade.save(s7);
			sucursalFacade.save(s8);
			sucursalFacade.save(s9);
			sucursalFacade.save(s10);
			sucursalFacade.save(s11);

			// CREO EMPLEADOS PARA SUCURSAL

			Empleado e1 = new Empleado("Mario", new Date(), new Date(), s1,
					"empleado1@nablainc.com", 20318886075L);
			Empleado e2 = new Empleado("Luis", new Date(), new Date(), s2,
					"empleado2@nablainc.com", 20328886075L);
			Empleado e3 = new Empleado("Victor", new Date(), new Date(), s3,
					"empleado3@nablainc.com", 20478886075L);
			Empleado e4 = new Empleado("Zohan", new Date(), new Date(), s4,
					"empleado4@nablainc.com", 20338886075L);
			Empleado e5 = new Empleado("Hernan", new Date(), new Date(), s5,
					"empleado5@nablainc.com", 20578886075L);
			Empleado e6 = new Empleado("Freddy", new Date(), new Date(), s6,
					"empleado6@nablainc.com", 20878886075L);
			Empleado e7 = new Empleado("Santiago", new Date(), new Date(), s7,
					"empleado7@nablainc.com", 90378886075L);
			Empleado e8 = new Empleado("Juan", new Date(), new Date(), s8,
					"empleado8@nablainc.com", 20378881075L);
			Empleado e9 = new Empleado("Hipolito", new Date(), new Date(), s9,
					"empleado9@nablainc.com", 20378826075L);
			Empleado e10 = new Empleado("Pablo", new Date(), new Date(), s10,
					"empleado10@nablainc.com", 20378836075L);
			Empleado e11 = new Empleado("Belen Sampayo", new Date(),
					new Date(), s11, "empleado11@nablainc.com", 20378886045L);

			empleadoFacade.save(e1);
			empleadoFacade.save(e2);
			empleadoFacade.save(e3);
			empleadoFacade.save(e4);
			empleadoFacade.save(e5);
			empleadoFacade.save(e6);
			empleadoFacade.save(e7);
			empleadoFacade.save(e8);
			empleadoFacade.save(e9);
			empleadoFacade.save(e10);
			empleadoFacade.save(e11);

			// CREO UNIDADES

			Unidad u1 = new Unidad("JSN 994", "C300", null, "Mercedes Benz",
					4500, 4500, new Date());
			Unidad u2 = new Unidad("ABC 123", "C300", null, "Mercedes Benz",
					4500, 4500, new Date());
			Unidad u3 = new Unidad("QWE 321", "C300", null, "Mercedes Benz",
					4500, 4500, new Date());

			unidadFacade.save(u1);
			unidadFacade.save(u2);
			unidadFacade.save(u3);

			// CREO RUTAS
			ArrayList<Sucursal> ls1 = new ArrayList<Sucursal>();
			ls1.add(s1);
			ls1.add(s10);
			ls1.add(s9);
			ls1.add(s8);
			Ruta r1 = new Ruta("Resistencia - Buenos Aires", ls1);
			rutaFacade.save(r1);

			ArrayList<Sucursal> ls2 = new ArrayList<Sucursal>();
			ls2.add(s8);
			ls2.add(s9);
			ls2.add(s10);
			ls2.add(s1);
			Ruta r2 = new Ruta("Buenos Aires - Resistencia", ls2);
			rutaFacade.save(r2);

			ArrayList<Sucursal> ls3 = new ArrayList<Sucursal>();
			ls3.add(s1);
			ls3.add(s11);
			ls3.add(s7);
			ls3.add(s5);
			ls3.add(s6);
			ls3.add(s4);
			Ruta r3 = new Ruta("Resistencia - Posadas", ls3);
			rutaFacade.save(r3);

			ArrayList<Sucursal> ls4 = new ArrayList<Sucursal>();
			ls4.add(s4);
			ls4.add(s6);
			ls4.add(s5);
			ls4.add(s7);
			ls4.add(s11);
			ls4.add(s1);
			Ruta r4 = new Ruta("Posadas - Resistencia", ls4);
			rutaFacade.save(r4);

			ArrayList<Sucursal> ls5 = new ArrayList<Sucursal>();
			ls5.add(s1);
			ls5.add(s3);
			ls5.add(s2);
			Ruta r5 = new Ruta("Resistencia - Formosa", ls5);
			rutaFacade.save(r5);

			ArrayList<Sucursal> ls6 = new ArrayList<Sucursal>();
			ls6.add(s2);
			ls6.add(s3);
			ls6.add(s1);
			Ruta r6 = new Ruta("Formosa - Resistencia", ls6);
			rutaFacade.save(r6);

			// CREO SEGURO
			Seguro seg1 = new Seguro();
			seg1.setNombre("Regular");
			seg1.setPorcentajeCubierto(50.0F);
			seg1.setPrecio(120F);
			seg1.setDuracion(12);
			seguroFacade.save(seg1);
			Seguro seg2 = new Seguro();
			seg2.setNombre("Premium");
			seg2.setPorcentajeCubierto(80.0F);
			seg2.setPrecio(250F);
			seg2.setDuracion(12);
			seguroFacade.save(seg2);

			// CREO SERVICIO
			Servicio ser1 = new Servicio();
			ser1.setNombre("Regular");
			ser1.setDescripcion("Servicio comun");
			ser1.setSeguro(seg1);
			ser1.setCoeficienteCosto(0.30F);
			servicioFacade.save(ser1);

			Servicio ser2 = new Servicio();
			ser2.setNombre("Premium");
			ser2.setDescripcion("Servicio express");
			ser2.setSeguro(seg2);
			ser2.setCoeficienteCosto(0.80F);
			servicioFacade.save(ser2);
			
			//CREO VIAJE
			Viaje v1 = new Viaje();
			v1.setFechaPartida(new Date());
			v1.setFinalizado(false);
			v1.setOrdenes(null);
			v1.setRuta(r1);
			v1.setUnidad(u2);
			viajeFacade.save(v1);

			Viaje v2 = new Viaje();
			v2.setFechaPartida(new Date());
			v2.setFinalizado(false);
			v2.setOrdenes(null);
			v2.setRuta(r5);
			v2.setUnidad(u2);
			viajeFacade.save(v2);
			
			Viaje v3 = new Viaje();
			v3.setFechaPartida(new Date());
			v3.setFinalizado(false);
			v3.setOrdenes(null);
			v3.setRuta(r1);
			v3.setUnidad(u1);
			viajeFacade.save(v3);
			
			Viaje v4 = new Viaje();
			v4.setFechaPartida(new Date());
			v4.setFinalizado(true);
			v4.setOrdenes(null);
			v4.setRuta(r3);
			v4.setUnidad(u3);
			viajeFacade.save(v4);
			
			//CREO ORDEN
			Orden o1 = new Orden();
			o1.setDestino(s6);
			o1.setEstado(null);
			o1.setFecha(new Date());
			o1.setMonto(2503.00F);
			o1.setOrigen(s3);
			o1.setPagado("Si");
			o1.setPaquetes(null);
			o1.setServicio(ser1);
			ordenFacade.save(o1);
			
			Orden o2 = new Orden();
			o2.setDestino(s5);
			o2.setEstado(null);
			o2.setFecha(new Date());
			o2.setMonto(2003.00F);
			o2.setOrigen(s1);
			o2.setPagado("No");
			o2.setPaquetes(null);
			o2.setServicio(ser2);
			ordenFacade.save(o2);
			
			Orden o3 = new Orden();
			o3.setDestino(s7);
			o3.setEstado(null);
			o3.setFecha(new Date());
			o3.setMonto(1201.00F);
			o3.setOrigen(s11);
			o3.setPagado("Si");
			o3.setPaquetes(null);
			o3.setServicio(ser2);
			ordenFacade.save(o3);
			
			Orden o4 = new Orden();
			o4.setDestino(s2);
			o4.setEstado(null);
			o4.setFecha(new Date());
			o4.setMonto(105.00F);
			o4.setOrigen(s1);
			o4.setPagado("Si");
			o4.setPaquetes(null);
			o4.setServicio(ser2);
			ordenFacade.save(o4);
			
			tx.commit();
		} catch (Exception e) {
			try {
				tx.rollback();
			} catch (Exception e1) {
				sendErrorMessageToUser("Error del servidor.");
				return STAY_IN_THE_SAME_PAGE;
			}
			sendErrorMessageToUser("Error datos invalidos.");
			return STAY_IN_THE_SAME_PAGE;
		}
		sendInfoMessageToUser("Operacion completada.");
		return LIST_ALL_CLIENTES;
	}

	// Views errors

	private void sendInfoMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				message, message));
	}

	private void sendErrorMessageToUser(String message) {
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
				message, message));
	}

	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}
}
