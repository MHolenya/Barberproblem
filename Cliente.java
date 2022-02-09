package barberodormilon;

public class Cliente implements Runnable {

	Barbero barber = new Barbero();
	Tienda tienda = new Tienda();
	int Ncliente = 1;

	public Cliente(Barbero barber) {
		this.barber = barber;
	}
	public void  getNcliente() {
		Ncliente++;
	}
	

	@Override
	public void run() {

		try {
			if (barber.getSillas() <= 6) {
				barber.cortarpelo();
				Thread.sleep(3000);
				barber.terminarcorte();
				barber.setSillas(barber.getSillas() - 1);
			} else {

				
				System.out.println(" el cliente se va ");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

}
