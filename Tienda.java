package barberodormilon;

public class Tienda extends Barbero {
	static Barbero barber = new Barbero();

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		// *instanciamos las clases cliente y barbero para utilizar sus metodos *//

		while (true) {

			Runnable cliente = new Cliente(barber);
			Thread HiloC = new Thread(cliente);
			String name = HiloC.getName();
			int time = (int) ((Math.random() * 2) * 1100);
			HiloC.start();
			System.out.println(" Cliente : " + name);
			Thread.sleep(time);
		}

	}

}
