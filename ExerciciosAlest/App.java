public class App {

    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        System.out.println(lista);

        System.out.println("Elemento armazenado na " + "primeira posicao da lista: " + lista.get(0));
        lista.reverse();
        System.out.println("Lista invertida:");
        System.out.println(lista);

        HighScores highScores = new HighScores();

        System.out.println("1. Adicionando 5 pontuações iniciais em ordem aleatória:");
        highScores.addScore(1500);
        highScores.addScore(3000);
        highScores.addScore(800);
        highScores.addScore(4500);
        highScores.addScore(2100);
        highScores.printScores();

        System.out.println("\n2. Adicionando mais 5 pontuações para completar as 10 posições:");
        highScores.addScore(5000); // Deve ser o novo #1
        highScores.addScore(100);  // Menor até agora
        highScores.addScore(3500);
        highScores.addScore(1200);
        highScores.addScore(2800);
        highScores.printScores();

        System.out.println("\n3. Tentando adicionar pontuação menor que a menor da lista (50):");
        highScores.addScore(50); // Deve ser ignorada
        highScores.printScores();

        System.out.println("\n4. Adicionando pontuação alta (4000) para substituir uma pontuação menor:");
        highScores.addScore(4000); // Deve entrar no ranking e a menor (100) deve sair
        highScores.printScores();
    }
}

