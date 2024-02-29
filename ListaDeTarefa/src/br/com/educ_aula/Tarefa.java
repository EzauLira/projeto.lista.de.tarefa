package br.com.educ_aula;

import java.util.Comparator;

public class Tarefa {
	private String n = "\u001B[1m", g = "\u001B[1;92m", stop = "\u001B[0m";

	private String novaT, descriT;
	private static int nextNum = 1;
	private int num;

	public Tarefa(String novaT, String descriT, int num) {
		this.novaT = novaT;
		this.descriT = descriT;
		this.num = num;
	}

	public Tarefa() {
		this.num = nextNum++;
	}

	public int getNum() {
		return num;
	}

	public String getNovaT() {
		return novaT;
	}

	public void setNovaT(String novaT) {
		this.novaT = novaT;
	}

	public String getDescriT() {
		return descriT;
	}

	public void setDescriT(String descriT) {
		this.descriT = descriT;
	}

	public String toString() {
		return "\n" + g+ "número da tarefa: "+stop+n+ num +stop+g+ "\nTarefa: "+stop+n+ novaT +stop+g+ "\nDescrição da tarefa: "+stop+n+ descriT + '.'+stop;

	}

	public static final Comparator<Tarefa> compara_tarefa = Comparator.comparing(Tarefa::getNovaT);

	public static final Comparator<Tarefa> compara_descri = Comparator.comparing(Tarefa::getNum);

}
