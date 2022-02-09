package barberodormilon;

public class Barbero {

	public int sillas = 0;
	boolean estacortando = false;

	/* Creamos metodos getter y setter para cambiar el valor y saberlo */
	public int getSillas() {
		return sillas;
	}

	public void setSillas(int sillas) {
		this.sillas = sillas;
	}

	/*
	 * Creamos los metodos shyncronized cortar pelo y terminarcorte para utilizarlos
	 */
	public synchronized void cortarpelo() {
		sillas ++;
		try {
			while (estacortando) {
				wait();

			}
			estacortando = true;
			System.out.println("EL barbero esta empieza el corte  el pelo");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void terminarcorte() throws InterruptedException {
		System.out.println("El barbero termina el corte");
		estacortando = false;
		sillas--;
		notify();

	}

	public synchronized boolean Sillas() {
		System.out.println("hay : " + sillas + " sillas ocupadas");
		if (sillas <=6) {
			return true;
		} else {
			System.out.println("No hay sillas disponibles!");
			return false;
		}

	}

}
