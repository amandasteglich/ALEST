/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListArrayOfInteger {

    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(n)
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    public void reverse() { // complexidade  O(n). nessa lista, o método faz 3 trocas
                            // e são 6 elementos. se fossem 8, seriam feitas 4 trocas
                            // então significa que o número de trocas se dá pela metadade
                            // de N, ou seja, n/2. comportamento linear
    for (int i = 0; i < count / 2; i++) {
        Integer temp = data[i];
        data[i] = data[count - 1 - i];
        data[count - 1 - i] = temp;
    }
    }

    public int countOccurrences(int element) {
        int occurrences = 0;
        for (int i = 0; i < count; i++) {
            if (data[i] != null && data[i].equals(element)) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public void addIncreasingOrder(int element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }

        int i = count - 1;
        while (i >= 0 && data[i] != null && data[i] > element) {
            data[i + 1] = data[i];
            i--;
        }

        data[i + 1] = element;
        count++;
    }

    public ListArrayOfInteger merge(ListArrayOfInteger l1, ListArrayOfInteger l2){
        ListArrayOfInteger resultado = new ListArrayOfInteger(l1.size() + l2.size());

        for(int i = 0; i< l1.size(); i++) {
            resultado.add(l1.get(i));
        }

        for(int i = 0; i< l2.size(); i++) {
            resultado.add(l2.get(i));
        }
        return resultado;
    }


    public void inique(){
        ListArrayOfInteger aux = new ListArrayOfInteger(this.count);

        //Percorre a lista atual usando métodos da lista
        for (int i = 0; i < this.size(); i++) {
            int elemento = this.get(i);

            //Se a lista auxiliar ainda não tem o elemento, adiciona nele
            if (!aux.contains(elemento)) {
                aux.add(elemento);
            }
        }

        // Limpa a lista atual e copia os elementos únicos de volta
        this.clear();
        for (int i = 0; i < aux.size(); i++) {
            this.add(aux.get(i));
        }
    }


    public int indexOf(Integer element) {
        for (int i = 0; i < count ; i++) {
            if (data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Integer element){
        for(int i = 0; i<count; i++){
            if (data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public void add (int index, int element) {
        if((index < 0) || (index>count))
            throw new IndexOutOfBoundsException();
        if(count == data.length){
            setCapacity(data.length * 2);
        }
        for(int i = 0; i<count; i++){
            data[i] = data [ i -1];
        }
        data[index] = element;
        count++;
}

    public boolean remove(int element) {
        for (int i = 0; i < count; i++) {
        if (data[i].equals(element)) { 
            for (int j = i; j < count - 1; j++) {
                data[j] = data[j + 1];
            }
            data[count - 1] = null; 
            count--;
            return true;
        }
    }
    return false;
}
    public int removeByIndex(int index) { 
    if ((index < 0) || (index >= count)) {
        throw new IndexOutOfBoundsException(); 
    }
    
    int removedValue = data[index];
    
    for (int j = index; j < count - 1; j++) { 
        data[j] = data[j + 1]; 
    }
    
    data[count - 1] = null; 
    count--; 
    
    return removedValue;
}
    
    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        }
    }
