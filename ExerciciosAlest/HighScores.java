import java.util.ArrayList;
import java.util.List;

public class HighScores {
    private static final int MAX_SCORES = 10;
    private List<Integer> scores;

    public HighScores() {
        this.scores = new ArrayList<>(MAX_SCORES);
    }

    public void addScore(int score) {
        int size = scores.size();

        // Se a lista já está cheia e a nova pontuação é menor ou igual à menor pontuação atual (última da lista), ignora.
        if (size == MAX_SCORES && score <= scores.get(size - 1)) {
            return;
        }

        // Procura a posição correta de inserção (da maior para a menor)
        int index = 0;
        while (index < size && scores.get(index) > score) {
            index++;
        }

        // Insere a pontuação na posição encontrada
        scores.add(index, score);

        // Se excedeu o limite de 10 pontuações, remove a menor 
        if (scores.size() > MAX_SCORES) {
            scores.remove(MAX_SCORES);
        }
    }

    public void printScores() {
        System.out.println(" TOP 10: ");
        for (int i = 0; i < scores.size(); i++) {
            System.out.println((i + 1) + ") " + scores.get(i));
        }
    }
}