
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;    
    // Contador do numero de elementos da lista.
    private int count;

     private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

     /**
     * Esvazia a lista
     */
    //5 void clear(): limpa a lista
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    } 

    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    //1 boolean isEmpty(): retorna true se a lista está vazia e false caso contrário
    public boolean isEmpty() {
        return (count == 0);
    }
  
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    // 2 int size(): retorna o número de elementos armazenados na lista
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    //
    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
        count++;      
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    } 

//3 boolean contains(int element): retorna true se a lista contém o elemento e
//falso caso contrário. Ex: 4, 8, 12 -> contains(8) -> true; contains(5) -> false
    public boolean contains(int element) {
        Node aux = header.next; // inicia a busca a partir do primeiro nó válido
        while (aux != trailer) { // percorre a lista até o nó sentinela de fim
            if (aux.element == element) { // retorna true assim que encontra o elemento
                return true;
            }
            aux = aux.next;
        }
        return false; // retorna false se percorreu toda a lista sem encontrar
    }

//4 int indexOf(int element): retorna a posição da primeira ocorrência onde o
//elemento está na lista. Ex: 10, 20, 30, 20 -> indexOf(20) -> 1
    public int indexOf(int element) {
        Node aux = header.next; // inicia a busca no primeiro nó válido
        int pos = 0; // contador do índice atual na lista
        while (aux != trailer) { // percorre os nós válidos até o trailer
            if (aux.element == element) { // se encontrar o elemento, retorna a posição
                return pos;
            }
            aux = aux.next;
            pos++; // incrementa o índice a cada nó percorrido
        }
        return -1; // retorna -1 se o elemento não existir na lista
    }

//6 void add(int index, int element): insere um elemento na lista na posição
//indicada por index. Ex: 3, 7, 9 -> add(1, 5) -> 3, 5, 7, 9.
    public void add(int index, int element) {
        if (index < 0 || index > count) { // valida se o índice está nos limites permitidos
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        }
        if (index == count) { // trata o caso de inserção diretamente no final da lista
            add(Integer.valueOf(element)); // inserção no final
            return;
        }
        
        // localiza o nodo que hoje ocupa a posição index
        Node depois;
        if (index < count / 2) { // busca a partir do início se o índice estiver na 1ª metade
            depois = header.next;
            for (int i = 0; i < index; i++) {
                depois = depois.next;
            }
        } else { // busca a partir do fim se o índice estiver na 2ª metade
            depois = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                depois = depois.prev;
            }
        }
        
        // insere o novo nodo ajustando os ponteiros dos nós vizinhos
        Node n = new Node(element);
        n.prev = depois.prev;
        n.next = depois;
        depois.prev.next = n;
        depois.prev = n;
        count++; // incrementa a contagem de elementos
    }

// 7 int get(int index): retorna o elemento da posição indicada por index. Ex: 8,
    //12, 20, 25 -> get(2) -> 20
    public int get(int index) {
        if (index < 0 || index >= count) { // valida se o índice está dentro do intervalo válido
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        }
        Node aux;
        if (index < count / 2) { // busca do início para o meio se estiver na 1ª metade
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else { // busca do fim para o meio se estiver na 2ª metade
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux.element; // retorna o elemento armazenado no nó encontrado
    }

    // 8 int set(index, e): substitui o valor na posição index pelo elemento passado
    //por parâmetro e retorna o valor antigo. Ex: 5, 10, 15, 20 -> set(1, 50) -> 10;
    //Lista Final -> 5, 50, 15, 20.
    public int set(int index, int e) {
        if (index < 0 || index >= count) { // valida se o índice informado é válido
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        }
        Node aux;
        if (index < count / 2) { // busca pelo nó a partir do início
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else { // busca pelo nó a partir do fim
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        int antigo = aux.element; // salva o valor antigo antes de alterar
        aux.element = e; //atualiza o nó com o novo valor
        return antigo; // retorna o elemento substituído
    }

    // 9 boolean remove(Integer element): remove a primeira ocorrência do
    //elemento passado por parâmetro e retorna true se conseguiu remover e false
    //caso contrário. Ex: 10, 20, 30, 20, 40 -> remove(20) -> true; Lista Final ->
    //10, 30, 20, 40.
    public boolean remove(Integer element) {
        Node aux = header.next; // inicia a busca a partir do primeiro nó válido
        while (aux != trailer) { // percorre a lista até o nó sentinela de fim
            if (aux.element.equals(element)) { // encontra a primeira ocorrência do elemento
                aux.prev.next = aux.next; // desconecta o nó atual ajustando o ponteiro do anterior
                aux.next.prev = aux.prev; // ajusta o ponteiro do nó posterior
                count--; // decrementa a quantidade de elementos
                return true; // retorna true indicando remoção bem-sucedida
            }
            aux = aux.next;
        }
        return false; // retorna false caso o elemento não seja encontrado
    }

    // 10 int removeByIndex (int index): remove o elemento da posição index. Ex: 10,
    //20, 30, 40 -> removeByIndex(2) -> 30; Lista Final -> 10, 20, 40
    public int removeByIndex(int index) {
        if (index < 0 || index >= count) { // valida os limites do índice
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        }
        Node aux;
        if (index < count / 2) { //do início até a posição desejada
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else { //do fim até a posição desejada
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        int removido = aux.element; //armazena o valor do nó que será removido
        aux.prev.next = aux.next; // ajusta os ponteiros dos nós vizinhos para isolar o nó atual
        aux.next.prev = aux.prev;
        count--; // decrementa o contador da lista
        return removido; // retorna o elemento removido
    }

   // 11 boolean removeAll(int element): remove todas as ocorrências do elemento
    //passado por parâmetro e retorna true se conseguiu remover e falso caso
    //contrário
    public boolean removeAll(int element) {
        boolean removeu = false;
        Node aux = header.next; // inicia no primeiro nó válido
        while (aux != trailer) { // percorre toda a lista até o sentinela final
            Node proximo = aux.next; // guarda o próximo nó antes de desconectar o atual
            if (aux.element == element) { // encontra uma ocorrência do elemento
                aux.prev.next = aux.next; // ajustando os ponteiros
                aux.next.prev = aux.prev;
                count--; // decrementa a contagem de elementos
                removeu = true; //ao menos uma remoção foi realizada
            }
            aux = proximo; // avança para o próximo nó salvo
        }
        return removeu;
    }

    // 12 int[] subList(int fromIndex, int toIndex): retorna um arranjo com os elementos
    //da lista original entre fromIndex (inclusivo) e toIndex (exclusivo). Ex: 10, 20,
    //30, 40 -> subList(0, 3) -> 10, 20, 30
    public int[] subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > count || fromIndex > toIndex) { // valida o intervalo solicitado
            throw new IndexOutOfBoundsException("Intervalo invalido: [" + fromIndex + ", " + toIndex + ")");
        }
        int[] resultado = new int[toIndex - fromIndex]; // cria o array com o tamanho exato da sublista
        if (resultado.length == 0) {
            return resultado;
        }
        // localiza o nodo da posição fromIndex uma única vez
        Node aux;
        if (fromIndex < count / 2) { //a partir do início
            aux = header.next;
            for (int i = 0; i < fromIndex; i++) {
                aux = aux.next;
            }
        } else { //a partir do fim
            aux = trailer.prev;
            for (int i = count - 1; i > fromIndex; i--) {
                aux = aux.prev;
            }
        }
        // copia os elementos do intervalo para o array de resultado
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = aux.element;
            aux = aux.next;
        }
        return resultado;
    }

    // 13 void sort(): ordena a lista do maior para o menor elemento. Ex: 4, 7, 1, 9 ->
    //9, 7, 4, 1.
    public void sort() {
        for (Node i = header.next; i != trailer; i = i.next) { // percorre a lista para a ordenação (Selection Sort)
            // procura o maior valor
            Node maior = i;
            for (Node j = i.next; j != trailer; j = j.next) {
                if (j.element > maior.element) { // encontra o maior elemento restante
                    maior = j;
                }
            }
            if (maior != i) { // troca o conteúdo dos nós caso encontre um valor maior
                Integer tmp = i.element;
                i.element = maior.element;
                maior.element = tmp;
            }
        }
    }

    // 14 void reverse(): inverte o conteúdo da lista. Ex: 2,3,4,1 -> 1, 4, 3,2
    public void reverse() {
        Node esq = header.next; // ponteiro para o início
        Node dir = trailer.prev; // ponteiro para o fim
        for (int i = 0; i < count / 2; i++) { // percorre até a metade trocando os elementos
            Integer tmp = esq.element;
            esq.element = dir.element;
            dir.element = tmp;
            esq = esq.next; // da esquerda para a direita
            dir = dir.prev; //da direita para a esquerda
        }
    }

    // 15 int contaOcorrencias(int element): conta o número de ocorrências do
    //elemento passado como parâmetro na lista, retornando este valor. Ex: 5, 7, 5,
    //2, 5 -> contaOcorrencias(5) -> retorna 3.
    public int contaOcorrencias(int element) {
        int total = 0; // número de ocorrências
        Node aux = header.next; // do primeiro nó válido
        while (aux != trailer) { // percorre toda a lista
            if (aux.element == element) { // incrementa o total ao encontrar o elemento
                total++;
            }
            aux = aux.next;
        }
        return total;
    }

    // 16 boolean removeImpares(): remove todos os elementos ímpares da lista,
    //mantendo apenas os pares; retorna true se conseguiu remover e falso caso
    //contrário. Ex.: 2, 5, 8, 7, 10 -> 2, 8, 10.
    public boolean removeImpares() {
        boolean removeu = false;
        Node aux = header.next; // do primeiro nó válido
        while (aux != trailer) { // percorre toda a lista
            Node proximo = aux.next; // guarda o próximo nó antes de desconectar
            if (aux.element % 2 != 0) { // verifica se o número é ímpar
                aux.prev.next = aux.next; // desconecta o nó ímpar da lista
                aux.next.prev = aux.prev;
                count--; // decrementa o total de elementos
                removeu = true; // marca que removeu ao menos um elemento
            }
            aux = proximo; // avança para o próximo nó
        }
        return removeu;
    }
}