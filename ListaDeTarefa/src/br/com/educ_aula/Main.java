package br.com.educ_aula;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		/* Color palette:
		 * 0 - Background whit
		 * 1 - In Bold 
		 * 2 - Cyan
		 * 3 - Yellow
		 * 4 - Red
		 * 5 - Green
		 * 6 - Stop
		 */
		String[] color = new String[]{"\u001B[47;1;30m", "\u001B[1m"
									, "\u001B[1;36m", "\u001B[1;33m"
									, "\u001B[1;91m","\u001B[1;92m"
									, "\u001B[0m"};
		

		List<Tarefa> listaDeTarefas = new ArrayList<>();
		try {
			try (Scanner input = new Scanner(System.in)) {

				System.out.println(color[0] + "\nBEM VINDO A SUA LISTA DE TAREFAS!!!" + color[6]);

				// menu
				while (true) {
					System.out.print(color[3] + "\n=== || MENU DE OPÇÕES || ===\n\n" + color[6]
											  + color[1]+ "(1) - Adicionar uma nova Tarefa\n"
											  + "(2) - Remover uma tarefa\n" 
											  + "(3) - Ver tarefas\n" 
											  + "(4) - Listar suas tarefas\n" 
											  + "(7) - Sair\n" + color[5] 
											  + color[2] + "Escolha uma opção: " + color[6]);
					int menu = input.nextInt();
					if (menu == 4) {
						System.out.println(color[1] + "Como deseja listar suas tarefas?\n"
								+ "(5) - Listar suas  tarefas em ordem alfabética\n"
								+ "(6) - Listar suas  tarefas em ordem cronológica\n" + color[6] 
								+ color[2] + "Escolha uma opção: "+ color[6]);
						menu = input.nextInt();
					}

					switch (menu) {
					case 1:
						
						Tarefa tarefas = new Tarefa();
						input.nextLine();

						System.out.println(color[5] + "\nDigite uma nova tarefa: " + color[6]);

						String novaT = input.nextLine();

						if (!novaT.equals(tarefas.getNovaT())) {
							tarefas.setNovaT(novaT);
						}

						System.out.println(color[5] + "Digite uma descrição para a tarefa:" + color[6]);
						String descriT = input.nextLine();

						if (!descriT.equals(tarefas.getDescriT())) {
							tarefas.setDescriT(descriT);
						}

						listaDeTarefas.add(tarefas);

						System.out.println(color[2] + "Tarefa adicionada com sucesso! - Vá em " + color[6] 
										  + color[1] + "(Ver tarefa)"+ color[6] 
										  + color[2] + " para visualizá-las" + color[6]);
						break;

					case 2:
						
						System.out.println(color[5] + "Digite o numero da tarefa que deseja remover: " + color[6]);
						int removT = input.nextInt();

						System.out.println(color[4] + "Tem certeza que deseja remover a Tarefa de número " + color[6] 
										 + color[1] + removT+ " (S / N): " + color[6]);
						
						String confirma = input.next();

						int sizeList = listaDeTarefas.size();

						if (confirma.equals("s") || confirma.equals("S")) {
							listaDeTarefas.removeIf(tarefa -> tarefa.getNum() == removT);

							if (listaDeTarefas.size() < sizeList) {
								System.out.println(color[5] + "Tarefa Removida com sucesso" + color[6]);
							} else {
								System.out.println(color[4] + "Tarefa de número " + color[6] 
												 + color[1] + removT + color[6] 
												 + color[4]+ " não encontrada" + color[6]);
							}
						}
						break;
						
					case 3:
						for (Tarefa ver : listaDeTarefas) {
							System.out.println(ver);
						}
						if (listaDeTarefas.isEmpty()) {
							System.out.println(color[4] + "Não há nada aqui! Adicione uma nova tarefa à sua lista." + color[6]);
						}

						break;

					case 5:
						listaDeTarefas.sort(Tarefa.compara_tarefa);
						for (Tarefa alfa : listaDeTarefas) {
							System.out.println(alfa);
						}
						if (listaDeTarefas.isEmpty()) {
							System.out.println(color[4] + "Não há nada aqui! Adicione uma nova tarefa à sua lista." + color[6]);
						}

						break;

					case 6:
						listaDeTarefas.sort(Tarefa.compara_descri);
						for (Tarefa crono : listaDeTarefas) {
							System.out.println(crono);
						}
						if (listaDeTarefas.isEmpty()) {
							System.out.println(color[4] + "Não há nada aqui! Adicione uma nova tarefa à sua lista." + color[6]);
						}

						break;

					case 7:
						for (int i = 0; i < 60; i++) {
							System.out.print("=");
						}

						System.out.println(color[3] + "\nEstou ansioso para te ver em breve assumindo novas tarefas!" + color[6]);

						for (int i = 0; i < 60; i++) {
							System.out.print("=");
						}

						System.exit(0);
						break;

					default:
						System.out.println(color[4] + "\n -|| Opção inválida, digite novamente ||- \n" + color[6]);
						input.nextLine();
					}

				}
			}
		} catch (Exception e) {
			System.out.println(color[4] + "Erro de exceção! - Por Favor, digite um " + color[6] 
							 + color[1] + "(número)" + color[6] + color[4]+ "ao invés de uma" + color[6] 
							 + color[1] + " (letra)." + color[6]);
		}
	}
}
