package view;

import java.util.concurrent.Semaphore;

import controller.CruzamentoController;

public class main {

	public static void main(String[] args) {
		int permissao=1;
		Semaphore semaforo = new Semaphore(permissao);
		for(int i=0;i<4;i++) {
			Thread cruzamento = new CruzamentoController(i, semaforo);
			cruzamento.start();
		}

	}

}
