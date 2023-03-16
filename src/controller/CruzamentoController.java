package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CruzamentoController extends Thread {
	private int carro;
	private Semaphore semaforo;
	public CruzamentoController(int carro, Semaphore semaforo) {
		this.carro=carro;
		this.semaforo=semaforo;
	}
	
	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			Cruzamento();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
		
	}
	
	public void Cruzamento() {
		Random Gerador = new Random();
		int sentido=0;
		sentido=Gerador.nextInt(4)+1;
		if(sentido==1) {
			System.out.println("O Carro "+carro+ " atravessou de Norte para o Sul");
		}
		if(sentido==2) {
			System.out.println("O Carro "+carro+ " atravessou de Sul para o Norte");
		}
		if(sentido==3) {
			System.out.println("O Carro " +carro+ " atravessou de Oeste para o Leste");
		}
		if(sentido==4) {
			System.out.println("O Carro "+carro+ " atravessou de Leste para o Oeste");
		}
	}
	public void carroAndando() {
		Random Gerador = new Random();
		int distancia=Gerador.nextInt(500)+1;
		int movimento=0;
		int acumulador=0;
		for(movimento=Gerador.nextInt(35)+1;acumulador<distancia; movimento=Gerador.nextInt()) {
			acumulador+=movimento;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("O Carro "+carro+" chegou ao farol");
		
	}

}
