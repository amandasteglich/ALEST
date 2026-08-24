import java.util.Scanner;
public class Exercicios {
    public static void main(String[] args) {
        Scanner dados = new Scanner(System.in);
        int[] vetor = {2, 5, 8, 12, 16, 23};

        System.out.println("Informe um valor n");
        int n = dados.nextInt();

        int resultado = buscaLinear(vetor, n);

        if (resultado == -1) {
            System.out.println("O número " + n + " não foi encontrado no vetor.");
        } else {
            System.out.println("O número " + n + " foi encontrado na posição " + resultado);
        }

        int resultadoBinaria = buscaBinaria(vetor, n);
        if (resultadoBinaria == -1) {
            System.out.println(" O número " + n + " não foi encontrado no vetor.");
        } else {
            System.out.println("O número " + n + " foi encontrado na posição " + resultadoBinaria);
        }

    }

    public static int buscaLinear(int vetor[], int n) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == n) {
                return i;
            }
        }
        return -1;
    }

   public static int buscaBinaria(int vetor[], int n) {
    int inicio = 0;
    int fim = vetor.length - 1;

    while (inicio <= fim) {
        int meio = (inicio + fim) / 2;

        if (vetor[meio] == n) {
            return meio;
        } else if (vetor[meio] < n) {
            inicio = meio + 1;
        } else {
            fim = meio - 1; 
        }
    }

    return -1;
   }
}