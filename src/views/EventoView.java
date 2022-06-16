package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import databases.EventoDB;
import databases.UsuarioDB;
import models.Evento;
import models.Usuario;

public class EventoView {
	Scanner sc = new Scanner(System.in);
	EventoDB evb = EventoDB.getInstance();

    public void listar(List<Evento> lista) {
        for (int i =0; i < lista.size(); i++) {
            Evento evt = lista.get(i);
            System.out.println(evt.getId()+" - "+ "Nome: " + evt.getNome() +" - " + "Endere�o: " + evt.getEndereco() + " - " + " Hor�rio: " + evt.getHorario() + " - " + " Participantes: " + evt.listarParticipantes());
        }
    }
    public void displayEvento(Evento evt) {
        System.out.println("--------------------------------");
        System.out.println("ID: "+evt.getId());
        System.out.println("Nome: "+ evt.getNome());
        System.out.println("Endere�o: "+evt.getEndereco());
        System.out.println("Categoria.: "+evt.getCategoria());
        System.out.println("--------------------------------");
    }

    public Evento displayFormularioEvento(){
		String nome, contato, endereco, newCategoria;
		int categoria = -1;
		ArrayList<Usuario> participantes = new ArrayList<Usuario>();
		System.out.println("Digite o nome do seu evento: $");
		nome = (sc.next());
		System.out.println("Digite o seu endere�o: $");
		endereco = (sc.next());
		do {
			System.out.println(
					" _______________________________\n"
	    			+"|                               |)\n"
	    			+"| === ? ESCOLHA A CATEGORIA === |)\n"
	    			+"|                               |)\n"
	    			+"|  1 - Bail�o retr� anos 80/90  |)\n"
	    			+"|  2 - Festa Junina             |)\n"
	    			+"|  3 - Encontro ens. m�dio      |)\n"
	    			+"|  4 - 'Botequinho cos guri'    |)\n"
	    			+ "|_______________________________|)"
					);
		} while ( categoria < 1 && categoria > 4);
		categoria = sc.nextInt();
		switch (categoria) {
			case 1:
				newCategoria =  "Bail�o retr� anos 80/90";
				break;
			case 2:
				newCategoria = "Festa Junina";
				break;
			case 3:
				newCategoria = "Encontro do ensino m�dio";
				break;
			case 4:
				newCategoria = "Botequinho cos guri";
				break;
			default:
				newCategoria = "LOQUEOU, T� MALUCO MEU?!?";
				break;
		}
		Evento evt = new Evento(0,nome,endereco,newCategoria, participantes);
		return evt;
    }
    
    public void addParticipante() {
		UsuarioDB udb = UsuarioDB.getInstance();
		EventoDB edb = EventoDB.getInstance();
		System.out.println("ESCOLHA QUAL DOS SEUS USU�RIOS VOC� QUER QUE PARTICIPE: \n");
		for (int i = 0; i < udb.getTodosUsuarios().size(); i ++) {
			System.out.print(udb.getTodosUsuarios().get(i)+ "\n");
		}
		System.out.println("Digite o id do usu�rio escolhido: ");
		int id = sc.nextInt();
		System.out.println("ESCOLHA QUAL DOS SEUS EVENTOS VOC� QUER PARTICIPAR: \n");
		for (int i = 0; i < edb.getTodosEventos().size(); i ++) {
			System.out.println(edb.getTodosEventos().get(i));
		}
		System.out.println("\n");
		System.out.print("Digite o id do evento escolhido: ");
		int idEvt = sc.nextInt();
		try {
			evb.addParticipante(udb.getTodosUsuarios().get(id -1), evb.getTodosEventos().get(idEvt -1));
			System.out.println("USUARIO ADICIONADO AEEE\n\n");
		} catch (Error error) {
			System.out.println(error);
		}

		
    }

}
