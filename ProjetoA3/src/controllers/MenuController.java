package controllers;

import databases.SistemaDB;


public class MenuController {
	private int op;
	
	
	public MenuController(int op) {
		this.op = op;
	}


	public void chooseOption(SistemaDB sdb) {
	    	switch(op) {
	    	case 1: 
	    		sdb.cadastrarUsuario();
	    		break;
	    	case 2: 
	    		sdb.listarUsuarios();
	    		break;
	    	case 3: 
	    		sdb.cadastrarEvento();
	    		break;
	    	case 4: 
	    		sdb.listarEventos();
	    		break;
	    	case 6: 
	    		System.out.println("FALTA FAZER\n");
	    		break;
	    	case 7: 
	    		System.out.println("FALTA FAZER\n");
	    		break;
	    	case 8: 
	    		System.out.println("FALTA FAZER\n");
	    		break;
	    	case 9: 
	    		System.out.println("FALTA FAZER\n");
	    		break;
	    	case 0: 
	    		System.out.println("Fim do programa!\n");
	    		break;
	    	default:
	    		System.out.println("Opção inválida!\n");
	    		break;
	    	}
	}
}