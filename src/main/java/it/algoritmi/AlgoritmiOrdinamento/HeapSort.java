package it.algoritmi.AlgoritmiOrdinamento;

@SuppressWarnings("rawtypes")
public class HeapSort {
    
    public static void heapSort(Comparable[] a) {

        int n = a.length;
        //Ciclo for per "disporre" a binary heap l'array iniziale
        for (int k=n/2; k>=1; k--)
            sink(a, k, n);

        /* Heap sort: scambiamo il primo elemento (il maggiore) con l'ultimo elemento.
        L'ultimo elemento diventato primo non rispetta più la struttura di un binary
        heap, quindi viene eseguito il sink, e viene decrementato n. La parte destra
        dell'array è infatti quella ordinata (vedere teoria).*/
        while (n > 1) {
            exch (a, 1, n);
            sink(a, 1, --n);
        }
        
    }

    private static void sink(Comparable[] a, int k, int n) {

        while (2*k <= n) {
            int j = 2*k;
            /*Se esiste un figlio (j<n, dove n è il numero totale degli elementi nell'array),
            e il suo successivo, che al più sarà n, è maggiore di lui, spostiamo il cursore di j
            sul figlio destro (più grande).*/
            if (j<n && less(a, j, j+1)) j++;
            //Se il maggiore tra i figli (j) è più piccolo del padre (k), è finito il sink.
            if (less(a, j, k)) break;
            //Altrimenti si scambiano
            exch(a, j, k);
            /*Spostiamo il cursore di k sull'elemento che abbiamo "affondato", per poter
            effettuare nuovi confronti e capire se va ancora affondato o meno per rispettare
            la struttura del binary heap*/
            k = j;
        }
    }

    private static boolean less (Comparable[] a, int i, int j) {
        /*
         * Le variabili di conteggio vengono decrementate dal momento che il binary heap lavora con il sistema
         * 1-based, ovvero l'elemento padre dell'albero è 1, appunto. Ma gli array, e in generale nell'informatica
         * si lavora con il sistema 0-based, motivo per cui è necessario decrementare le variabili.
         */
        return a[i-1].compareTo(a[j-1]) < 0;
    }

    private static void exch (Comparable[] a, int i, int j) {
        /*
         * Le variabili di conteggio vengono decrementate dal momento che il binary heap lavora con il sistema
         * 1-based, ovvero l'elemento padre dell'albero è 1, appunto. Ma gli array, e in generale nell'informatica
         * si lavora con il sistema 0-based, motivo per cui è necessario decrementare le variabili.
         */
        i--; j--;
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}
