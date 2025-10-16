package agenda;

public class Agenda {
	
	public static void main(String[] args) {
		
		BancoDeDados banco = new BancoDeDados();
		
		banco.conectar();
		
		if(banco.estarConectado()) {			
			System.out.println("Banco de dados conectado!");
			
		}
		else {
			System.err.println("Banco de dados não conectado!");
			
		}
		
		
//		banco.inserirContato("Senac PR", "0800 643 6 346");
//		banco.inserirContato("Otavio", "41 98754 5689");
//		banco.inserirContato("Maria", "41 95454 9898");
		
//		banco.listarContato();
		
//		banco.apagarContato("1");
		
		banco.atualizarContato("2", "Senac PR", "3314-5850");
		
	}

}
