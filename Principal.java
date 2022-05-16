package Pessoal_Java;

import java.util.Scanner;
import java.io.IOException;



public class Principal {
	
	
	public static void cls(){
		for (int i=0;i<40;i++) {
			System.out.println("");
		}
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Aluno[] aluno = new Aluno[40]; 	
		
		int contAluno=0;
		char op;
		int registro = 101; 
		
		String pular;
		
		Scanner leia = new Scanner(System.in);
		
		do {
			
			System.out.println("[1] - Cadastrar aluno.");
			System.out.println("[2] - Pesquisar aluno.");
			System.out.println("[3] - Lan�amento das notas de um prova.");
			System.out.println("[4] - Alterar nota de um aluno espec�fico.");
			System.out.println("[5] - Listar notas por Alunos.");
			System.out.println("[6] - Listar notas por Provas.");
			System.out.println("-----\n[0] - Encerrar o programa.");
			
			//todo menu.
			op = leia.next().charAt(0);
			
			switch(op){
				case '1'://Cadastrar aluno
					cls();
					String nome;
					String RA = String.valueOf(registro);
					System.out.println("Insira o nome do Aluno: ");
					nome = leia.next();
					
					aluno[contAluno] = new Aluno(nome,RA);
					
					contAluno++;
					registro++;
					break;
					
				case '2'://Pesquisar Aluno
					cls();
					String identificacao;
					String pesquisa;
					System.out.println("Insira o Nome do Aluno ou RA.");
					identificacao = leia.next();
					
					//pesquisa por nome
					for(int i=0; i<contAluno; i++) {
						pesquisa = aluno[i].pesquisaNome();
						
						if (identificacao.equals(pesquisa)){
							aluno[i].imprimirPesquisa();
							aluno[i].imprimirNota();
						}
					}
					
					//pesquisa por RA.
					for(int i=0; i<contAluno; i++) {
						pesquisa = aluno[i].pesquisaRA();
						
						if (identificacao.equals(pesquisa)){
							aluno[i].imprimirPesquisa();
							aluno[i].imprimirNota();
						}
					}
					break;
					
				case '3'://Cadastrar nota da disciplina
					cls();
					String nomeProva;
					System.out.println("Insira o nome da disciplina: ");
					nomeProva = leia.next();
					
					float nota;
					//Imprimir todos os alunos, e solicitar a nota dos mesmos.
					for(int i=0; i<contAluno; i++) {
						
						aluno[i].imprimirPesquisa();
						System.out.println("Insira o nota: ");
						nota = leia.nextFloat();
						
						aluno[i].lancarNota(nomeProva, nota);
					}	
					break;
					
				/*case 4:// Alterar nota de um aluno especifico
					String identificacao1;
					System.out.println("\nDigite o RA ou o nome do alune: ");
	                identificacao1 = leia.next();

	                for (int i = 0; i < contAluno; i++) {
	                	pesquisa = aluno[i].pesquisaRA();
	                	pesquisa1 = aluno[i].pesquisaNome();
	                		
	                		if (identificacao1.equals(pesquisa)) {
	                            System.out.println("Digite qual mat�ria deseja mudar a nota: ");
	                            String nomeProva1;
	                            nomeProva1 = leia.next();
	                            float nota1;
	                            int ra;
	                		}
	                }
					break;*/
					
				case '5':
					cls();
					for (int i = 0; i < contAluno; i++) {
						aluno[i].todasNotasAluno();
						System.out.println("");
					}
					
					break;	
				
				case '6':
					
					
					break;
					
				default:
					cls();
					System.out.println("Op��o Inv�lida. Por Favor, digite novamente.");
	
			}

		}while(op!=0);

	}

}

