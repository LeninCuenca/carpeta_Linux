package Clases;

public class ProcesadorMatriz implements Runnable {
    
    private int[][] matriz;
    private int[] resultados;
    private int indice;

    public ProcesadorMatriz(int[][] matriz, int[] resultados, int indice) {
        this.matriz = matriz;
        this.resultados = resultados;
        this.indice = indice;
    }

    @Override
    public void run() {
        resultados[indice] = contarNumerosPrimosEnMatriz(matriz);
    }

    private int contarNumerosPrimosEnMatriz(int[][] matriz) {
        int contador = 0;
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (esPrimo(matriz[i][j])) {
                    contador++;
                }
            }
        }
        return contador;
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
