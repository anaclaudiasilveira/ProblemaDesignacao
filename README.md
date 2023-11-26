# ProblemaDesignacao
Este repositório refere-se ao trabalho da disciplina Pesquisa Operacional.

Alunos:
Abne Martins Machado	E01797
Ana Claudia Silveira Rodrigues  E01598
Luiz Henrique Silveira Rodrigues E01599
Pedro Henrique Almeida de Freitas	E01723
Problema de alocação de funcionários na Fábrica de Automóveis

Considere que a fábrica de automóveis precisa transferir trabalhadores de diferentes habilidades para diferentes estações de montagem, de modo a maximizar a eficiência na produção automotiva. Cada trabalhador pode ser visto como uma "unidade" que pode ser alocada em estações de montagem específicas, e a eficiência do trabalhador em cada estação pode ser interpretada como o custo associado a essa alocação.

Objetivo:
Maximizar a eficiência global da fábrica, que pode ser representada pela minimização do custo total associado às alocações de trabalhadores para estações de montagem utilizando método do Método Húngaro para alocação.
Para modelar matematicamente o problema de alocação de trabalhadores para estações de montagem, vamos utilizar a Teoria dos Grafos e o Método Húngaro. Vamos definir as variáveis e parâmetros necessários.

Modelagem matemática
Notações:
	n é o número de trabalhadores e também o número de estações de montagem.
	xij: Variável binária que indica se o trabalhador i alocado na estação de montagem j.
	xij = 0, se o trabalhador i estiver alocado à estação.
	xij = 0, caso contrário.

Parâmetros:
Cij é o custo associado à alocação do trabalhador i à estação j. Este custo pode representar a eficiência do trabalhador naquela estação

Função Objetivo: Minimizar Z= ∑_i^n▒∑_j^n▒〖x_ij.C_ij 〗

Restrições:
	Cada trabalhador só pode ser alocado a uma estação: 
∑_(j=1)^n▒〖x_ij=1,〗  para i=1,2,3,…,n.
	Cada estação deve receber a quantidade necessária de trabalho:
∑_(i=1)^n▒〖x_ij= 1,para j=1,2,3,…,n.〗
	As quantidades de trabalho devem ser não negativas e binárias:
x_ij∈{0,1},para i=1,2,3,…,n e j=1,2,3,…,n.

Método Húngaro:
Para resolver este problema de alocação, você pode usar o Método Húngaro. Este método é eficiente para resolver problemas de alocação quadrados.
Para resolver este problema de alocação, você pode usar o Método Húngaro. Este método é eficiente para resolver problemas de alocação quadrados.
A matriz de custos Cij deve ser transformada em uma matriz de custos reduzida aplicando os passos do Método Húngaro. A alocação ótima pode ser encontrada a partir da matriz reduzida

Testes utilizados para o algoritmo implementado
Problema exemplo 1: 
Dado o contexto da fábrica de automóveis com 4 trabalhadores, 4 estações de trabalho, e cada trabalhador possuindo um custo por hora trabalhada diferente, podemos criar uma função objetivo para minimizar o custo total de alocação de trabalhadores para estações de montagem utilizando método do Método Húngaro para alocação.
Funcionários	Estação de trabalho – Valor por hora em reais
	1	                        2                 	3           	4
1	 R$       32,84 	 R$       33,84 	 R$       34,84 	 R$       35,84 
2	 R$       30,93 	 R$       28,93 	 R$       26,93 	 R$       20,93 
3	 R$       25,93 	 R$       30,93 	 R$       40,93 	 R$       30,93 
4	 R$       43,55 	 R$       53,55 	 R$       33,55 	 R$       23,55 

Interpretação dos resultados apresentados pelo algoritmo implementado neste teste
MATRIZ INICIAL
32.84  33.84  34.84  35.84   
30.93  28.93  26.93  20.93   
25.93  30.93  40.93  30.93   
43.55  53.55  33.55  23.55   

REDUZINDO LINHAS
0.0  1.0  2.0  3.0   
10.0  8.0  6.0  0.0   
0.0  5.0  15.0  5.0   
20.0  30.0  10.0  0.0   

REDUZINDO COLUNAS
0.0  0.0  0.0  3.0   
10.0  7.0  4.0  0.0   
0.0  4.0  13.0  5.0   
20.0  29.0  8.0  0.0   

MOVIMENTAÇÕES 
0.0  0.0  0.0  3.0   
10.0  7.0  4.0  0.0   
0.0  4.0  13.0  5.0   
20.0  29.0  8.0  0.0   
 
4.0  0.0  0.0  7.0   
10.0  3.0  0.0  0.0   
0.0  0.0  9.0  5.0   
20.0  25.0  4.0  0.0   

MATRIZ APOS AS MOVIMENTACOES 
4.0  0.0  0.0  7.0   
10.0  3.0  0.0  0.0   
0.0  0.0  9.0  5.0   
20.0  25.0  4.0  0.0   
 
Funcionario 0 esta alocado na Estacao de trabalho 1 recebendo R$ 33.84 por hora
Funcionario 1 esta alocado na Estacao de trabalho 2 recebendo R$ 26.93 por hora
Funcionario 2 esta alocado na Estacao de trabalho 0 recebendo R$ 25.93 por hora
Funcionario 3 esta alocado na Estacao de trabalho 3 recebendo R$ 23.55 por hora
O custo total associado as alocacoes dos Funcionariosera R$ 110.25

A interpretação final indica que o Funcionário 0 está alocado na Estação de trabalho 1 recebendo R$ 33.84 por hora, o Funcionário 1 está alocado na Estação de trabalho 2 recebendo R$ 26.93 por hora, e assim por diante.
O custo total associado a essas alocações é R$ 110.25.

Essencialmente, o algoritmo tenta minimizar o custo total das alocações, e os resultados indicam como os funcionários foram alocados em diferentes estações de trabalho para atingir esse objetivo. Isso significa que o menor custo que a empresa terá com a alocação destes quatro funcionários nas quatro estações de trabalho será de R$ 110,25.
 
Problema exemplo 2: 
Dado o contexto da fábrica de automóveis com 10 trabalhadores, 10 estações de trabalho, e cada trabalhador possuindo um custo por hora trabalhada diferente, podemos criar uma função objetivo para minimizar o custo total de alocação de trabalhadores para estações de montagem utilizando método do Método Húngaro para alocação.
As demandas de cada estação, os custos por hora dos funcionários e a capacidade de horas trabalhadas por eles em 30 dias estão listadas na tabela a seguir.

Funcionário	Estação de trabalho – Valor por hora em reais
	1	            2	       3	         4	       5	       6	       7	       8	       9	      10
1	   32,84 	   45,67 	   21,34 	   88,92 	   12,56 	   33,78 	   77,45 	   54,21 	   99,00 	   63,45 
2	   11,23 	   77,89 	   49,01 	   63,45 	   88,92 	   32,84 	   21,34 	   45,67 	   54,21 	   99,00 
3	   33,78 	   54,21 	   12,56 	   77,45 	   21,34 	   45,67 	   88,92 	   99,00 	   63,45 	   77,89 
4	   77,45 	   88,92 	   32,84 	   45,67 	   63,45 	   21,34 	   33,78 	   12,56 	   49,01 	   54,21 
5	   21,34 	   99,00 	   45,67 	   77,45 	   12,56 	   49,01 	   63,45 	   33,78 	   88,92 	   54,21 
6	   54,21 	   12,56 	   88,92 	   33,78 	   45,67 	   21,34 	   63,45 	   99,00 	   77,89 	   77,45 
7	   63,45 	   33,78 	   54,21 	   12,56 	   77,45 	   45,67 	   88,92 	   21,34 	   99,00 	   49,01 
8	   45,67 	   21,34 	   63,45 	   54,21 	   99,00 	   88,92 	   77,45 	   12,56 	   33,78 	   49,01 
9	   49,01 	   63,45 	   33,78 	   99,00 	   77,45 	   12,56 	   54,21 	   88,92 	   21,34 	   45,67 
10	    8,92 	   77,45 	   99,00 	   21,34 	   54,21 	   63,45 	   45,67 	   49,01 	   33,78 	  12,56 

Interpretação dos resultados apresentados pelo algoritmo implementado neste teste
MATRIZ INICIAL
32.84  45.67  21.34  88.92  12.56  33.78  77.45  54.21  99.0  63.45   
11.23  77.89  49.01  63.45  88.92  32.84  21.34  45.67  54.21  99.0   
33.78  54.21  12.56  77.45  21.34  45.67  88.92  99.0  63.45  77.89   
77.45  88.92  32.84  45.67  63.45  21.34  33.78  12.56  49.01  54.21   
21.34  99.0  45.67  77.45  12.56  49.01  63.45  33.78  88.92  54.21   
54.21  12.56  88.92  33.78  45.67  21.34  63.45  99.0  77.89  77.45   
63.45  33.78  54.21  12.56  77.45  45.67  88.92  21.34  99.0  49.01   
45.67  21.34  63.45  54.21  99.0  88.92  77.45  12.56  33.78  49.01   
49.01  63.45  33.78  99.0  77.45  12.56  54.21  88.92  21.34  45.67   
88.92  77.45  99.0  21.34  54.21  63.45  45.67  49.01  33.78  12.56   

REDUZINDO LINHAS
20.28  33.11  8.78  76.36  0.0  21.22  64.89  41.65  86.44  50.89   
0.0  66.66  37.78  52.22  77.69  21.61  10.11  34.44  42.98  87.77   
21.22  41.65  0.0  64.89  8.78  33.11  76.36  86.44  50.89  65.33   
64.89  76.36  20.28  33.11  50.89  8.78  21.22  0.0  36.45  41.65   
8.78  86.44  33.11  64.89  0.0  36.45  50.89  21.22  76.36  41.65   
41.65  0.0  76.36  21.22  33.11  8.78  50.89  86.44  65.33  64.89   
50.89  21.22  41.65  0.0  64.89  33.11  76.36  8.78  86.44  36.45   
33.11  8.78  50.89  41.65  86.44  76.36  64.89  0.0  21.22  36.45   
36.45  50.89  21.22  86.44  64.89  0.0  41.65  76.36  8.78  33.11   
76.36  64.89  86.44  8.78  41.65  50.89  33.11  36.45  21.22  0.0   

REDUZINDO COLUNAS
20.28  33.11  8.78  76.36  0.0  21.22  54.78  41.65  77.66  50.89   
0.0  66.66  37.78  52.22  77.69  21.61  0.0  34.44  34.2  87.77   
21.22  41.65  0.0  64.89  8.78  33.11  66.25  86.44  42.11  65.33   
64.89  76.36  20.28  33.11  50.89  8.78  11.11  0.0  27.67  41.65   
8.78  86.44  33.11  64.89  0.0  36.45  40.78  21.22  67.58  41.65   
41.65  0.0  76.36  21.22  33.11  8.78  40.78  86.44  56.55  64.89   
50.89  21.22  41.65  0.0  64.89  33.11  66.25  8.78  77.66  36.45   
33.11  8.78  50.89  41.65  86.44  76.36  54.78  0.0  12.44  36.45   
36.45  50.89  21.22  86.44  64.89  0.0  31.54  76.36  0.0  33.11   
76.36  64.89  86.44  8.78  41.65  50.89  23.0  36.45  12.44  0.0 
 
Movimentações
20.28  33.11  8.78  76.36  0.0  21.22  54.78  41.65  77.66  50.89   
0.0  66.66  37.78  52.22  77.69  21.61  0.0  34.44  34.2  87.77   
21.22  41.65  0.0  64.89  8.78  33.11  66.25  86.44  42.11  65.33   
64.89  76.36  20.28  33.11  50.89  8.78  11.11  0.0  27.67  41.65   
8.78  86.44  33.11  64.89  0.0  36.45  40.78  21.22  67.58  41.65   
41.65  0.0  76.36  21.22  33.11  8.78  40.78  86.44  56.55  64.89   
50.89  21.22  41.65  0.0  64.89  33.11  66.25  8.78  77.66  36.45   
33.11  8.78  50.89  41.65  86.44  76.36  54.78  0.0  12.44  36.45   
36.45  50.89  21.22  86.44  64.89  0.0  31.54  76.36  0.0  33.11   
76.36  64.89  86.44  8.78  41.65  50.89  23.0  36.45  12.44  0.0   
 
11.5  33.11  8.78  76.36  0.0  12.44  46.0  41.65  68.88  50.89   
0.0  75.44  46.56  61.0  86.47  21.61  0.0  43.22  34.2  96.55   
12.44  41.65  0.0  64.89  8.78  24.33  57.47  86.44  33.33  65.33   
56.11  76.36  20.28  33.11  50.89  0.0  2.33  0.0  18.89  41.65   
0.0  86.44  33.11  64.89  0.0  27.67  32.0  21.22  58.8  41.65   
32.87  0.0  76.36  21.22  33.11  0.0  32.0  86.44  47.77  64.89   
42.11  21.22  41.65  0.0  64.89  24.33  57.47  8.78  68.88  36.45   
24.33  8.78  50.89  41.65  86.44  67.58  46.0  0.0  3.66  36.45   
36.45  59.67  30.0  95.22  73.67  0.0  31.54  85.14  0.0  41.89   
67.58  64.89  86.44  8.78  41.65  42.11  14.22  36.45  3.66  0.0   

MATRIZ APOS AS MOVIMENTACOES 
11.5  33.11  8.78  76.36  0.0  12.44  46.0  41.65  68.88  50.89   
0.0  75.44  46.56  61.0  86.47  21.61  0.0  43.22  34.2  96.55   
12.44  41.65  0.0  64.89  8.78  24.33  57.47  86.44  33.33  65.33   
56.11  76.36  20.28  33.11  50.89  0.0  2.33  0.0  18.89  41.65   
0.0  86.44  33.11  64.89  0.0  27.67  32.0  21.22  58.8  41.65   
32.87  0.0  76.36  21.22  33.11  0.0  32.0  86.44  47.77  64.89   
42.11  21.22  41.65  0.0  64.89  24.33  57.47  8.78  68.88  36.45   
24.33  8.78  50.89  41.65  86.44  67.58  46.0  0.0  3.66  36.45   
36.45  59.67  30.0  95.22  73.67  0.0  31.54  85.14  0.0  41.89   
67.58  64.89  86.44  8.78  41.65  42.11  14.22  36.45  3.66  0.0   

Resultado Final:
Funcionario 0 esta alocado na Estacao de trabalho 4 recebendo R$ 12.56 por hora
Funcionario 1 esta alocado na Estacao de trabalho 6 recebendo R$ 21.34 por hora
Funcionario 2 esta alocado na Estacao de trabalho 2 recebendo R$ 12.56 por hora
Funcionario 3 esta alocado na Estacao de trabalho 5 recebendo R$ 21.34 por hora
Funcionario 4 esta alocado na Estacao de trabalho 0 recebendo R$ 21.34 por hora
Funcionario 5 esta alocado na Estacao de trabalho 1 recebendo R$ 12.56 por hora
Funcionario 6 esta alocado na Estacao de trabalho 3 recebendo R$ 12.56 por hora
Funcionario 7 esta alocado na Estacao de trabalho 7 recebendo R$ 12.56 por hora
Funcionario 8 esta alocado na Estacao de trabalho 8 recebendo R$ 21.34 por hora
Funcionario 9 esta alocado na Estacao de trabalho 9 recebendo R$ 12.56 por hora
O custo total associado as alocacoes dos Funcionariosera R$ 160.72 
 
Interpretação:
Cada linha da matriz após movimentações representa um funcionário, e cada coluna representa uma estação de trabalho.
Os valores não nulos indicam a alocação dos funcionários nas estações de trabalho correspondentes.
O custo total associado a essas alocações é R$ 160.72.

Resultado Final:
 
O algoritmo otimizou a alocação para minimizar o custo total, levando em consideração as preferências dos funcionários e as capacidades das estações de trabalho.
Os custos associados a cada alocação refletem a eficiência global da fábrica, sendo minimizados na alocação final apresentada.

Apresentação do Algoritmo 

O código implementa o Algoritmo Húngaro, uma técnica de otimização usado para resolver problemas de atribuição. Esses problemas geralmente envolvem a alocação de recursos de maneira eficiente, minimizando ou maximizando algum critério, como custo. Vou fornecer uma explicação passo a passo do código:

Definição de Nomes e Unidade de Medida:

As variáveis eixoHorizontal e eixoVertical representam os rótulos para as duas dimensões do problema (por exemplo, funcionários e estações de trabalho). unidadeMedida é a unidade associada ao custo.

Matriz de Custo:

A matriz matriz1 representa os custos associados à alocação de cada "funcionário" a uma "estação de trabalho". Existem diferentes matrizes de exemplo no código que podem ser alternadas para testar o algoritmo.

Redução de Linhas e Colunas:

reduzLinhas e reduzColunas são funções que realizam a redução dos valores nas linhas e colunas da matriz, respectivamente.

Encontrar Traços:

encontraTracos identifica traços na matriz. Traços são zeros isolados em linhas ou colunas.
Encontrar Zeros e Marcar Linhas/Colunas:

encontraZeros identifica zeros isolados e marca linhas e colunas correspondentes.
Terminar Linhas/Colunas:

terminaLinhasHorizontal e terminaLinhasVertical são funções recursivas que realizam a marcação de linhas e colunas para encontrar uma solução viável.

Resolução de Entradas não Riscadas:

resolvendoEntradasNaoRiscadas ajusta os valores da matriz para continuar a busca pela solução ótima.

Retornar Resultado:

retornaResultado exibe os resultados finais, mostrando como os funcionários são alocados nas estações de trabalho e o custo total associado.

Cópia de Matriz:

copiaMatriz cria uma cópia de uma matriz.

Impressão de Matriz:

printaMatrizNumerica imprime uma matriz numérica.

Arredondamento de Números:
arredondarDouble é uma função auxiliar para arredondar números para duas casas decimais.

O código utiliza diferentes métodos e recursividade para percorrer as etapas do algoritmo. O Algoritmo Húngaro é um método eficiente para resolver problemas de atribuição, e o código implementa a lógica necessária para encontrar uma solução ótima.

 
Funcionamento do Programa

O algoritmo é iterativo e utiliza diversas estratégias para marcar e ajustar valores na matriz, buscando encontrar uma alocação que minimize ou maximize o custo total, dependendo da natureza do problema.

O código é estruturado de forma modular, com funções específicas para cada etapa do algoritmo. A lógica é baseada nas propriedades dos problemas de atribuição e na busca por soluções viáveis de maneira eficiente. 

Execução do código do programa implementado explicando os parâmetros de entrada e os parâmetros de saída (solução)
Parâmetros de Entrada:
Matriz de Custos (matriz1):
A matriz que representa os custos associados à atribuição. Cada elemento matriz1[i][j] representa o custo de atribuir a i-ésima linha à j-ésima coluna.
Nomes das Variáveis (eixoHorizontal, eixoVertical, unidadeMedida):
Strings que fornecem rótulos para as variáveis, como "Funcionário", "Estação de trabalho", e "por hora". Esses rótulos são usados para imprimir resultados.
Parâmetros de Saída (Solução):
Alocações e Custos:
O programa imprime na tela a alocação resultante, indicando qual "Funcionario" está alocado a qual "Estacao de trabalho". O custo total associado a essas alocações também é exibido.
Matriz Após Movimentações (matrizReduzida):
A matriz original é processada por diversas etapas (redução de linhas, redução de colunas, marcação de traços, etc.), e a matriz resultante é exibida na tela.
Iterações e Passos Intermediários:
O código imprime várias matrizes intermediárias durante as iterações, mostrando a redução de linhas, redução de colunas, marcação de zeros, entre outros passos.

Funcionamento Geral do Programa:
Inicialização:
O programa inicia com a definição da matriz de custos e outros parâmetros.
Redução de Linhas e Colunas:
São realizadas operações para reduzir as linhas e colunas da matriz original, visando simplificar o problema.
Marcação de Traços e Zeros:
O código encontra zeros na matriz reduzida e os marca. Em seguida, traços são colocados nas linhas e colunas contendo zeros, com o objetivo de encontrar uma solução inicial.
Designação de Linhas e Colunas:
A alocação é aprimorada iterativamente, alternando entre designação de linhas e colunas, para encontrar uma solução aprimorada.
Saída Final:
O programa exibe na tela a matriz após todas as movimentações e a alocação final, indicando qual funcionário está alocado em qual estação de trabalho.
Observações:
O código é projetado para ser adaptável a diferentes matrizes de custo.
Durante as iterações, o programa utiliza estratégias heurísticas para melhorar as alocações.
O resultado final é uma alocação que minimiza o custo total.

Possíveis Melhorias:
A implementação usa heurísticas para encontrar uma solução eficiente, mas não garante a solução globalmente ótima.
Pode haver variação nos resultados dependendo da implementação específica das heurísticas.
Este é um algoritmo bem conhecido para resolver problemas de atribuição e é eficaz na prática. O código é estruturado de maneira clara, facilitando a compreensão das etapas do algoritmo.

Comparação com a Modelagem Matemática:
Quanto a eficiência
O algoritmo húngaro é conhecido por ser eficiente, mas dependendo da implementação e do problema específico, pode haver casos em que uma modelagem matemática e um solver linear, como o Simplex, também são eficientes.

Precisão e confiabilidade
Ambos são precisos em suas soluções e também confiáveis.

Facilidade de Implementação e Manutenção:
O algoritmo húngaro é relativamente direto de implementar, enquanto a modelagem matemática pode exigir o uso de bibliotecas ou solvers externos.

Adaptabilidade a Diferentes Problemas:
Alguns métodos podem ser mais flexíveis em lidar com variações nos requisitos do problema.

Escalabilidade:
O desempenho pode variar à medida que o tamanho do problema aumenta.

Limitações e Restrições:
O algoritmo húngaro é especialmente eficaz para o Problema de Atribuição, mas pode ter limitações em outros contextos. A modelagem matemática pode oferecer uma abordagem mais geral, mas pode ter limitações de desempenho para problemas específicos.

Implementação do algorítmo em Java com comentários
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
