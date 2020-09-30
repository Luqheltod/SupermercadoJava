package gui;

import utiles.Lector;

import java.util.ArrayList;

import model.Producto;

public class guiInterfaz {

	ArrayList<Producto> productos = new ArrayList<Producto>();

	public void mostrarMenu() {
		int seleccion = 0;
		// muestra las opciones
		do {

			System.out.println("Selecciona una opcion: ");
			System.out.println("1- Dar de alta un producto ");
			System.out.println("2- Listar Productos");
			System.out.println("3- Eliminar Producto");
			System.out.println("4- Indicar las cantidades existentes de un producto");
			System.out.println("5- Mostrar Productos con menos de 5 unidades.");
			System.out.println("6- Salir");

			// guardamos su seleccion.
			seleccion = Lector.leerNumero();

			// mediante un switch, vamos al metodo que debe ejecutarse.

			switch (seleccion) {

			case 1:
				altaProducto();
				break;

			case 2:
				listarProducto();
				break;

			case 3:

				eliminarProducto();
				break;

			case 4:

				cantidadesProducto();
				break;

			case 5:

				warningProducto();
				break;
			}
		} while (seleccion != 6);
	}

	public void altaProducto() {
		// guardamos los datos y obtenemos una instancia del producto. que guardaremos
		// en un array.
		System.out.println("Introduce el nombre ");

		String nombre = Lector.leerString();

		System.out.println("Introduce la categoria");

		String categoria = mostrarCategorias();

		System.out.println("Introduce la cantidad existente");

		int cantidadExistente = Lector.leerNumero();

		productos.add(new Producto(nombre, categoria, cantidadExistente));

	}

	public String mostrarCategorias() {

		System.out.println("1- Lacteo");
		System.out.println("2- Carne");
		System.out.println("3- Fruta");
		System.out.println("4- Pescado");
		System.out.println("5- Otro");

		int categoriaElegida = Lector.leerNumero();

		switch (categoriaElegida) {

		case 1:

			return "Lacteo";

		case 2:

			return "Carne";

		case 3:

			return "Fruta";

		case 4:

			return "Pescado";

		case 5:

			return "Otro";

		}
		return "";
	}

	public void listarProducto() {

		if (productos.isEmpty()) {
			System.out.println("No hay productos, por favor introduzca un producto.");
		} else {

			for (Producto producto : productos) {

				System.out.println(producto);
			}
		}
	}

	public void eliminarProducto() {

		if (!productos.isEmpty()) {
			System.out.println("Introduce el codigo del producto");

			int codigoEliminar = Lector.leerNumero();

			for (int i = 0; i < productos.size(); i++) {

				

				if (productos.get(i).getCodigo() == codigoEliminar) {

					productos.remove(i);

					System.out.println("Producto eliminado");
				} else {

					System.out.println("No se encuentra ese codigo");
				}

			}

		} else {
			System.out.println("No hay productos");
		}

	}
	
	
	public void warningProducto() {
		
		
		if (!productos.isEmpty()) {
		int cantidadLimite = 5; 
		boolean hayWarnings = false;
		
		
		 for (Producto p : productos) {
             if (p.getCantidad() <= cantidadLimite) {
                 int cant = p.getCantidad();
                 String name = p.getNombre();
                 System.out.println(name + " (" + cant + " unidades)");
                 hayWarnings= true;
             }
		
		//Este codigo no funciona y no se el motivo.
	/*	for (int i = 0 ; i > productos.size() ; i++  ) {
			System.out.println("ENtro en el for");
			int cantidadDelProducto = productos.get(i).getCantidad();
			if (cantidadDelProducto < cantidadLimite) {
				
				productos.get(i).toString();
				
			} */    
		}
		if(!hayWarnings) {
			
			System.out.println("Todo esta rebosante de stock! ");
		}
	}else {
		System.out.println("No hay productos");
	}
	}
	
	public void cantidadesProducto() {
		
		if (!productos.isEmpty()) {
			System.out.println("Introduce el codigo del producto");

			int codigoMostrar = Lector.leerNumero();

			//miramos si el producto esta por codigo, si está mostraremos sus cantidades , si no esta lo indicaremos
			for (int i = 0; i < productos.size(); i++) {

				

				if (productos.get(i).getCodigo() == codigoMostrar) {

				int cantidad =	productos.get(i).getCantidad();
					
				System.out.println("La cantidad es " +cantidad);	

					
				} else {

					System.out.println("No se encuentra ese codigo");
				}

			}

		} else {
			System.out.println("No hay productos");
		}
	}
	
}
