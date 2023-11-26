package AlgoritmoHungaro;

public class AlgHungaro {

	// Nomes das variaveis do problema
	static String eixoHorizontal = "Funcionario";
	static String eixoVertical = "Estacao de trabalho";
	static String unidadeMedida = "por hora";

	// matrizes de facil acesso para teste resolvida em sala de aula
//	public static double[][] matriz1 = new double[][] { // matriz referente ao problema do trabalho
//			{ 1.0, 4.0, 6.0, 3.0 }, 
//			{ 9.0, 7.0, 10.0, 9.0 }, 
//			{ 4.0, 5.0, 11.0, 7.0 }, 
//			{ 8.0, 7.0, 8.0, 5.0 } 
//			};
	 public static double[][] matriz1 = new double[][]{ //matriz Custo teste 1
	{32.84, 33.84, 34.84, 35.84},
    {30.93, 28.93, 26.93, 20.93},
    {25.93, 30.93, 40.93, 30.93},
    {43.55, 53.55, 33.55, 23.55}
};

//	public static double[][] matriz1 = new double[][] { // matriz do Custo teste 2
//
//		{32.84, 45.67, 21.34, 88.92, 12.56, 33.78, 77.45, 54.21, 99.00, 63.45},
//	    {11.23, 77.89, 49.01, 63.45, 88.92, 32.84, 21.34, 45.67, 54.21, 99.00},
//	    {33.78, 54.21, 12.56, 77.45, 21.34, 45.67, 88.92, 99.00, 63.45, 77.89},
//	    {77.45, 88.92, 32.84, 45.67, 63.45, 21.34, 33.78, 12.56, 49.01, 54.21},
//	    {21.34, 99.00, 45.67, 77.45, 12.56, 49.01, 63.45, 33.78, 88.92, 54.21},
//	    {54.21, 12.56, 88.92, 33.78, 45.67, 21.34, 63.45, 99.00, 77.89, 77.45},
//	    {63.45, 33.78, 54.21, 12.56, 77.45, 45.67, 88.92, 21.34, 99.00, 49.01},
//	    {45.67, 21.34, 63.45, 54.21, 99.00, 88.92, 77.45, 12.56, 33.78, 49.01},
//	    {49.01, 63.45, 33.78, 99.00, 77.45, 12.56, 54.21, 88.92, 21.34, 45.67},
//	    {88.92, 77.45, 99.00, 21.34, 54.21, 63.45, 45.67, 49.01, 33.78, 12.56}
//	};

	public static void main(String[] args) {

		// escolha da matriz utilizada
		double[][] matrizOriginal = copiaMatriz(matriz1);
		double[][] matrizUtilizada = matriz1;

		// printa a matriz inicial
		System.out.println("MATRIZ INICIAL");
		printaMatrizNumerica(matrizUtilizada);

		// fazendo a redução de linhas horizontalmente
		System.out.println("\n\nREDUZINDO LINHAS");
		double[][] matrizReduzida = reduzLinhas(matrizUtilizada);
		printaMatrizNumerica(matrizReduzida);

		// fazendo a redução de colunas verticalmente
		System.out.println("\n\nREDUZINDO COLUNAS");
		matrizReduzida = reduzColunas(matrizReduzida);
		printaMatrizNumerica(matrizReduzida);

		// verificando a quantidade de traços e colunas para encontrar a solução otima

		matrizReduzida = encontraTracos(matrizReduzida);
		// printaMatrizNumerica(matrizReduzida);

		// encontrando o 0 inicial que esteja em uma sozinho na linha

		String[][] matrizString = encontraZeros(matrizReduzida);
		// printaMatrizString(matrizString);

		// fazendo adesignação das linhas certas do passo 6

		matrizString = terminaLinhasHorizontal(matrizReduzida, matrizString);
		// printaMatrizString(matrizString);

		// fazendo adesignação das colunas certas do passo 6

		matrizString = terminaLinhasVertical(matrizReduzida, matrizString);
		// printaMatrizNumerica(matrizReduzida);

		// mostrando na tela resultados finais
		System.out.println("\nMATRIZ APOS AS MOVIMENTACOES ");
		printaMatrizNumerica(matrizReduzida);
		System.out.println(" ");
		// System.out.println("\nMATRIZ DE PONTOS OTIMOS ");
		// printaMatrizString(matrizString);

		// printaMatrizNumerica(matrizOriginal);
		// System.out.println(" ");
		retornaResultado(matrizOriginal, matrizString);

	}

	public static double[][] reduzLinhas(double[][] matriz) {

		double[][] matrizReduzida = matriz;

		for (int i = 0; i < matriz.length; i++) {

			double menor = matriz[i][0];

			for (int j = 1; j < matriz[0].length; j++) {

				if (matriz[i][j] < menor) {
					menor = matriz[i][j];
				}
			}
			for (int j = 0; j < matriz[0].length; j++) {
				matrizReduzida[i][j] = arredondarDouble(matriz[i][j] - menor);
			}
		}
		return matrizReduzida;
	}

	public static double[][] reduzColunas(double[][] matriz) {

		double[][] matrizReduzida = matriz;

		for (int i = 0; i < matriz[0].length; i++) {

			double menor = matriz[0][i];

			for (int j = 1; j < matriz.length; j++) {

				if (matriz[j][i] < menor) {
					menor = matriz[j][i];
				}
			}
			for (int j = 0; j < matriz.length; j++) {
				matrizReduzida[j][i] = arredondarDouble(matriz[j][i] - menor);
			}
		}
		return matrizReduzida;
	}

	public static double[][] encontraTracos(double[][] matrizNum) {

		int qtdTracos = 0;
		int[] zerosPorLinhas = new int[matrizNum.length];
		int[] zerosPorColunas = new int[matrizNum.length];
		String[][] matrizResultado = new String[matrizNum.length][matrizNum[0].length];

		while (qtdTracos < matrizNum.length) {
			qtdTracos = 0;
			for (int i = 0; i < matrizResultado.length; i++) {
				for (int j = 0; j < matrizResultado.length; j++) {
					matrizResultado[i][j] = "X";
				}
			}

			for (int i = 0; i < matrizNum.length; i++) {
				zerosPorLinhas[i] = 0;
				zerosPorColunas[i] = 0;
			}

			for (int i = 0; i < matrizNum.length; i++) {
				for (int j = 0; j < matrizNum[0].length; j++) {
					if (matrizNum[i][j] == 0) {
						zerosPorLinhas[i]++;
						zerosPorColunas[j]++;
					}
				}
			}

			int maiorLinhas = 0;
			for (int i = 0; i < zerosPorLinhas.length; i++) {
				if (zerosPorLinhas[i] > maiorLinhas) {
					maiorLinhas = zerosPorLinhas[i];
				}
			}

			int maiorColunas = 0;
			for (int i = 0; i < zerosPorColunas.length; i++) {
				if (zerosPorColunas[i] > maiorColunas) {
					maiorColunas = zerosPorColunas[i];
				}
			}

			for (int i = 0; i < matrizNum.length; i++) {
				if (zerosPorLinhas[i] == maiorLinhas) {
					qtdTracos++;
					for (int j = 0; j < matrizNum.length; j++) {
						matrizResultado[i][j] = "-";
					}
				}
			}

			for (int i = 0; i < matrizNum[0].length; i++) {
				for (int j = 0; j < matrizNum[0].length; j++) {
					if (matrizNum[j][i] == 0) {
						if ("X".equals(matrizResultado[j][i])) {
							qtdTracos++;
							for (int k = 0; k < matrizNum[0].length; k++) {
								if ("-".equals(matrizResultado[k][i])) {
									matrizResultado[k][i] = "+";
								} else {
									matrizResultado[k][i] = "|";
								}
							}
						}
					}
				}
			}
			System.out.println(" ");
			// printaMatrizString(matrizResultado);
			printaMatrizNumerica(matrizNum);
			if (qtdTracos != matrizNum.length) {
				matrizNum = formataMatriz(matrizNum, matrizResultado);
			}
		}
		// printaMatrizString(matrizResultado);
		// System.out.println("");
		return matrizNum;
	}

	public static double[][] formataMatriz(double[][] matrizNum, String[][] matrizResultado) {

		double menorDescoberto = 999999999;
		for (int i = 0; i < matrizNum.length; i++) {
			for (int j = 0; j < matrizNum[0].length; j++) {
				if ("X".equals(matrizResultado[i][j])) {
					if (matrizNum[i][j] < menorDescoberto) {
						menorDescoberto = matrizNum[i][j];
					}
				}
			}
		}

		for (int i = 0; i < matrizNum.length; i++) {
			for (int j = 0; j < matrizNum[0].length; j++) {
				if ("X".equals(matrizResultado[i][j])) {
					matrizNum[i][j] = arredondarDouble(matrizNum[i][j] - menorDescoberto);
				}
				if ("+".equals(matrizResultado[i][j])) {
					matrizNum[i][j] = arredondarDouble(matrizNum[i][j] + menorDescoberto);
				}
			}
		}
		return matrizNum;

	}

	public static String[][] encontraZeros(double[][] matriz) {

		int linha = -1, coluna = -1;
		String[][] matrizResultado = new String[matriz.length][matriz[0].length];

		for (int i = 0; i < matrizResultado.length; i++) {
			for (int j = 0; j < matrizResultado.length; j++) {
				matrizResultado[i][j] = "X";
			}
		}

		for (int i = 0; i < matriz.length; i++) {

			int contadorDeZeros = 0, ultimaLinha = 0, ultimaColuna = 0;

			for (int j = 0; j < matriz[0].length; j++) {

				if (matriz[i][j] == 0) {
					contadorDeZeros++;
					ultimaLinha = i;
					ultimaColuna = j;
				}
			}
			if (contadorDeZeros == 1) {

				linha = ultimaLinha;
				coluna = ultimaColuna;
				break;

			}
		}

		if (coluna == -1 || linha == -1) {
			return matrizResultado;
		}

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz[0].length; j++) {
				if (i == linha && j == coluna) {
					matrizResultado[i][j] = "0";
				} else if (linha == i) {
					matrizResultado[i][j] = "-";
				} else if (coluna == j) {
					matrizResultado[i][j] = "|";
				}
			}

		}

		return matrizResultado;
	}

	public static String[][] terminaLinhasHorizontal(double[][] matrizNum, String[][] matrizString) {

		int linha = -1, coluna = -1;

		for (int i = 0; i < matrizNum.length; i++) {

			int contadorDeZeros = 0, ultimaLinha = 0, ultimaColuna = 0;

			for (int j = 0; j < matrizNum[0].length; j++) {

				if (matrizNum[i][j] == 0 && "X".equals(matrizString[i][j])) {
					contadorDeZeros++;
					ultimaLinha = i;
					ultimaColuna = j;
				}
			}
			if (contadorDeZeros == 1) {

				linha = ultimaLinha;
				coluna = ultimaColuna;
				break;

			}
		}

		if (coluna == -1 || linha == -1) {
			return matrizString;
		}

		for (int i = 0; i < matrizNum.length; i++) {
			for (int j = 0; j < matrizNum[0].length; j++) {
				if (i == linha && j == coluna) {
					matrizString[i][j] = "0";
				} else if (linha == i) {
					if ("|".equals(matrizString[i][j])) {
						matrizString[i][j] = "+";
					} else {
						matrizString[i][j] = "-";
					}
				} else if (coluna == j) {
					if ("-".equals(matrizString[i][j])) {
						matrizString[i][j] = "+";
					} else {
						matrizString[i][j] = "|";
					}
				}
			}
		}

		return terminaLinhasHorizontal(matrizNum, matrizString);

	}

	public static String[][] terminaLinhasVertical(double[][] matrizNum, String[][] matrizString) {

		int linha = -1, coluna = -1;

		for (int i = 0; i < matrizNum[0].length; i++) {

			int contadorDeZeros = 0, ultimaLinha = 0, ultimaColuna = 0;

			for (int j = 0; j < matrizNum.length; j++) {

				if (matrizNum[j][i] == 0 && "X".equals(matrizString[j][i])) {
					contadorDeZeros++;
					ultimaLinha = j;
					ultimaColuna = i;
				}
			}
			if (contadorDeZeros == 1) {

				linha = ultimaLinha;
				coluna = ultimaColuna;
				break;

			}
		}

		if (coluna == -1 || linha == -1) {
			return matrizString;
		}

		for (int i = 0; i < matrizNum.length; i++) {
			for (int j = 0; j < matrizNum[0].length; j++) {
				if (i == linha && j == coluna) {
					matrizString[i][j] = "0";
				} else if (linha == i) {
					if ("|".equals(matrizString[i][j])) {
						matrizString[i][j] = "+";
					} else {
						matrizString[i][j] = "-";
					}
				} else if (coluna == j) {
					if ("-".equals(matrizString[i][j])) {
						matrizString[i][j] = "+";
					} else {
						matrizString[i][j] = "|";
					}
				}
			}
		}
		return terminaLinhasVertical(matrizNum, matrizString);
	}

	public static double[][] resolvendoEntradasNaoRiscadas(double[][] matrizNum, String[][] matrizString) {

		double menor = -1;

		for (int i = 0; i < matrizString.length; i++) {
			for (int j = 0; j < matrizString[0].length; j++) {
				if ("X".equals(matrizString[i][j])) {
					if (menor == -1) {
						menor = matrizNum[i][j];
					} else if (matrizNum[i][j] < menor) {
						menor = matrizNum[i][j];
					}
				}
			}
		}

		for (int i = 0; i < matrizString.length; i++) {
			for (int j = 0; j < matrizString[0].length; j++) {
				if ("X".equals(matrizString[i][j])) {
					matrizNum[i][j] = matrizNum[i][j] - menor;
				}
				if ("+".equals(matrizString[i][j])) {
					matrizNum[i][j] = matrizNum[i][j] + menor;
				}
			}
		}

		printaMatrizNumerica(matrizNum);
		System.out.println(" \n");
		// printaMatrizString(matrizString);

		return matrizNum;
	}

	public static void retornaResultado(double[][] matrizNum, String[][] matrizString) {
		double valorTotal = 0;
		for (int i = 0; i < matrizString.length; i++) {
			for (int j = 0; j < matrizString[0].length; j++) {
				if ("0".equals(matrizString[i][j])) {
					System.out.println(eixoHorizontal + " " + (i) + " esta alocado na " + eixoVertical + " " + (j)
							+ " recebendo R$ " + matrizNum[i][j] + " " + unidadeMedida);
					valorTotal = valorTotal + matrizNum[i][j];
				}
			}
		}
		System.out.println("O custo total associado as alocacoes dos " + eixoHorizontal + "sera R$ " + valorTotal);
	}

	public static double[][] copiaMatriz(double[][] matrizOriginal) {

		double[][] matrizNova = new double[matrizOriginal.length][matrizOriginal[0].length];

		for (int i = 0; i < matrizOriginal.length; i++) {
			for (int j = 0; j < matrizOriginal[0].length; j++) {
				matrizNova[i][j] = matrizOriginal[i][j];
			}
		}

		return matrizNova;
	}

	public static void printaMatrizNumerica(double[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + "  ");
			}
			System.out.println(" "); // muda de linha
		}

	}

//	public static void printaMatrizString(String[][] matriz) {
//
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz[0].length; j++) {
//				System.out.print(matriz[i][j] + "  ");
//			}
//			System.out.println(" "); // muda de linha
//		}

	private static double arredondarDouble(double numero) {
		return Math.round(numero * 100.0) / 100.0;
	}
}