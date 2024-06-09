package bimestral1;

import BDConexion.Conexion;
import Clases.Fila;
import Clases.ProcesadorMatriz;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import Logica.Logica;
import java.util.concurrent.ThreadPoolExecutor;
/*
*CUENCA CUENCA LENIN ANDRES
*/
public class Bimestral1 {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        List<Fila> listaFilas = new ArrayList<>();
        try {
            Connection conexion = new Conexion().AbrirConexion();
            Statement declaracion = conexion.createStatement();
            String consultaSQL = "SELECT * FROM valores";
            ResultSet resultado = declaracion.executeQuery(consultaSQL);
            while (resultado.next()) {
                int col1 = resultado.getInt("col1");
                int col2 = resultado.getInt("col2");
                int col3 = resultado.getInt("col3");
                int col4 = resultado.getInt("col4");

                Fila fila = new Fila(col1, col2, col3, col4);
                listaFilas.add(fila);
            }
            resultado.close();
            declaracion.close();
            new Conexion().CerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int numHilos = 8;
        List<int[][]> matricesResultantes = Logica.dividirEnMatrices(listaFilas, numHilos);
        
        var numCores = Runtime.getRuntime().availableProcessors();
         ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);
        int[] resultados = new int[numHilos];

        for (int i = 0; i < matricesResultantes.size(); i++) {
            int[][] matrizResultante = matricesResultantes.get(i);
            executor.execute(new ProcesadorMatriz(matrizResultante, resultados, i));
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        int sumaTotal = Logica.sumarResultados(resultados);
        System.out.println("El Total de primos: " + sumaTotal);
    }
}

