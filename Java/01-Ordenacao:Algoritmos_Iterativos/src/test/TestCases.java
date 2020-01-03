package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.AbstractSorting;
import sorting.SimpleSorting.BubbleSort;
import sorting.SimpleSorting.InsertionSort;
import sorting.SimpleSorting.SelectionSort;
import sorting.VariationsOfSelectionsort.SimultaneousSelectionsort;


import java.util.Arrays;

public class TestCases {

    private Integer[] vetorTamPar;
    private Integer[] vetorTamImpar;
    private Integer[] vetorVazio = {};
    private Integer[] vetorValoresRepetidos;
    private Integer[] vetorValoresIguais;
    private Integer[] vetorValoresNegativos;
    private Integer[] vetorElementoUnico = {2};
    private Integer[] vetorOrdenado = {1,5,8,17,28,55,86,99};
    private Integer[] vetorOrdenadoReverso = {99,86,55,27,15,7,3,1};
    private Integer[] vetorTudoRepetido = {8,8,8,8,5,5,5,5,1,1,1,1,1};
    private Double[] vetorDeFloats = {1.1, 13.9, 2.29, 77.33, 9.0, 1.01, 28.6, 184.937, 0.001, 0.01};
    private String[] vetorDeStrings = {"zrluagcwwhqnyx", "wmxnqzoj", "wujct", "zynlvlswhlsqu", "cujcy", "cwopxzkjrb", "hkqiipemi", "y", "hiradmnkfaqo", "", "wstz"};

    private AbstractSorting<Integer> implementation;
    private AbstractSorting<Double> imp;
    private AbstractSorting<String> impt;

    @Before
    public void setUp() {
        populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 22, 11 });
        populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 });
        populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
        populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
        populaValoresNegativos(new Integer[] { 16, 6, 4, 8, 31, -17, 25, 12, -9, 7, -2, 0 });

        getImplementation();
    }

    // // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
    /**
     * Método que inicializa a implementação a ser testada com a implementação do
     * aluno
     */
    private void getImplementation() {

        /*
        this.implementation = new BubbleSort<>();
        this.imp = new BubbleSort<>();
        this.impt = new BubbleSort<>();
        */

        /*
        this.implementation = new InsertionSort<>();
        this.imp = new InsertionSort<>();
        this.impt = new InsertionSort<>();
        */

        /*
        this.implementation = new SelectionSort<>();
        this.imp = new SelectionSort<>();
        this.impt = new SelectionSort<>();
        */


        this.implementation = new SimultaneousSelectionsort<>();
        this.imp = new SimultaneousSelectionsort<>();
        this.impt = new SimultaneousSelectionsort<>();

    }

    private void populaVetorTamanhoPar(Integer[] arrayPadrao) {
        this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    private void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
        this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    private void populaVetorRepetido(Integer[] arrayPadrao) {
        this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    private void populaVetorIgual(Integer[] arrayPadrao) {
        this.vetorValoresIguais = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
    }

    private void populaValoresNegativos(Integer[] arrayPadrao) {
        this.vetorValoresNegativos = Arrays.copyOf(arrayPadrao, arrayPadrao.length);

    }

    // FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

    // MÉTODOS DE TESTE

    private void genericTest(Integer[] array) {
        Integer[] copy1 = {};
        if (array.length > 0) {
            copy1 = Arrays.copyOf(array, array.length);
        }

        implementation.sort(array);
        Arrays.sort(copy1);

        Assert.assertArrayEquals(copy1, array);

    }

    private void testedouble(Double[] array){
        Double[] copia =  Arrays.copyOf(array, array.length);

        imp.sort(array);
        Arrays.sort(copia);

        Assert.assertArrayEquals(copia, array);

    }

    private void testestring (String[] array){
        String[] copia =  Arrays.copyOf(array, array.length);

        impt.sort(array);
        Arrays.sort(copia);

        Assert.assertArrayEquals(copia, array);

    }

    private void delimitedTest(Integer[] array, int leftIndex, int rightIndex) {

        Integer[] copy1 = {};
        if (array.length > 0) {
            copy1 = Arrays.copyOf(array, array.length);
        }

        implementation.sort(array, leftIndex, rightIndex);
        Arrays.sort(copy1, leftIndex, rightIndex + 1);
        /*
         * a implementação do Arrays.sort() é exclusiva com rightIndex passado, por isso
         * o +1.
         */

        Assert.assertArrayEquals(copy1, array);
    }

    @Test
    public void testSort01() {
        genericTest(vetorTamPar);
    }

    @Test
    public void testSort02() {
        genericTest(vetorTamImpar);
    }

    @Test
    public void testSort03() {
        genericTest(vetorVazio);
    }

    @Test
    public void testSort04() {
        genericTest(vetorValoresIguais);
    }

    @Test
    public void testSort05() {
        genericTest(vetorValoresRepetidos);
    }

    @Test
    public void testSort06() {

        int leftIndex = 0;
        int rightIndex = vetorTamPar.length - 1;

        Integer[] copy1;

        while (leftIndex <= rightIndex) {

            copy1 = Arrays.copyOf(vetorTamPar, vetorTamPar.length);

            delimitedTest(copy1, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    @Test
    public void testSort07() {

        int leftIndex = 0;
        int rightIndex = vetorTamImpar.length - 1;

        Integer[] copy1;

        while (leftIndex <= rightIndex) {

            copy1 = Arrays.copyOf(vetorTamImpar, vetorTamImpar.length);

            delimitedTest(copy1, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    @Test
    public void testSort08() {
        int leftIndex = 0;
        int rightIndex = vetorVazio.length - 1;

        Integer[] copy1;

        while (leftIndex <= rightIndex) {

            copy1 = Arrays.copyOf(vetorVazio, vetorVazio.length);

            delimitedTest(copy1, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    @Test
    public void testSort09() {
        int leftIndex = 0;
        int rightIndex = vetorValoresIguais.length - 1;

        Integer[] copy1;

        while (leftIndex <= rightIndex) {

            copy1 = Arrays.copyOf(vetorValoresIguais, vetorValoresIguais.length);

            delimitedTest(copy1, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    @Test
    public void testSort10() {
        int leftIndex = 0;
        int rightIndex = vetorValoresRepetidos.length - 1;

        Integer[] copy1;

        while (leftIndex <= rightIndex) {

            copy1 = Arrays.copyOf(vetorValoresRepetidos, vetorValoresRepetidos.length);

            delimitedTest(copy1, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    @Test
    public void testSort11() {

        int quantidade = 30000;
        Integer[] vetor = new Integer[quantidade];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * quantidade);
        }

        genericTest(vetor);

    }

    @Test
    public void testSort12() {
        genericTest(vetorValoresNegativos);
    }

    @Test
    public void testSort13() {
        int leftIndex = 0;
        int rightIndex = vetorValoresNegativos.length - 1;

        Integer[] copy1;

        while (leftIndex <= rightIndex) {

            copy1 = Arrays.copyOf(vetorValoresNegativos, vetorValoresNegativos.length);

            delimitedTest(copy1, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    @Test
    public void testvetorElementoUnico(){
        genericTest(vetorElementoUnico);
    }

    @Test
    public void testvetorOrdenado(){
        genericTest(vetorOrdenado);
    }

    @Test
    public void testvetorOrdenadoReverso(){
        genericTest(vetorOrdenadoReverso);
    }

    @Test
    public void testvetorTudoRepetido(){
        genericTest(vetorTudoRepetido);
    }

    @Test
    public void testvetorDeFloats(){
        testedouble(vetorDeFloats);
    }

    @Test
    public void testvetorDeStrings(){
        testestring(vetorDeStrings);
    }

}
