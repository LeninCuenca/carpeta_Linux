package Logica;

import Clases.Fila;
import java.util.ArrayList;
import java.util.List;

public class Logica {

    public static List<int[][]> dividirEnMatrices(List<Fila> listaFilas, int numHilos) {
        List<int[][]> matricesResultantes = new ArrayList<>();
        int filasPorHilo = listaFilas.size() / numHilos;

        for (int i = 0; i < numHilos; i++) {
            int inicio = i * filasPorHilo;
            int fin = (i == numHilos - 1) ? listaFilas.size() : (i + 1) * filasPorHilo;
            List<Fila> sublista = listaFilas.subList(inicio, fin);
            int[][] matriz = convertirAMatriz(sublista);
            matricesResultantes.add(matriz);
        }

        return matricesResultantes;
    }

    private static int[][] convertirAMatriz(List<Fila> sublista) {
        int[][] matriz = new int[sublista.size()][4];
        for (int i = 0; i < sublista.size(); i++) {
            Fila fila = sublista.get(i);
            matriz[i][0] = fila.getCol1();
            matriz[i][1] = fila.getCol2();
            matriz[i][2] = fila.getCol3();
            matriz[i][3] = fila.getCol4();
        }
        return matriz;
    }

    public static int sumarResultados(int[] resultados) {
        int suma = 0;
        for (int resultado : resultados) {
            suma += resultado;
        }
        return suma;
    }
}
