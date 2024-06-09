package Ejecutor;
import Semana1.RandomMatrix;
import Semana1.Valores;
import Semana1.NumPrimos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
/*
*CUENCA CUENCA LENIN ANDRES
*/
public class Main {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgramacionAB2PU");
    private static final EntityManager em = emf.createEntityManager();
    private static final int filas = 500;
    private static final int columnas = 5;
    private static final int filasHi = 25;
    private static final int numCore = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {
        // Generar datos y guardar en lista temporal
        List<List<Integer>> matriz = RandomMatrix.generateMatrix(filas, columnas);
        List<Valores> valoresList = new ArrayList<>();

        for (int i = 0; i < matriz.size(); i++) {
            List<Integer> fila = matriz.get(i);
            Valores valores = new Valores();
            valores.setNombreHilo("Hilo" + i);
            valores.setCol1(fila.get(0));
            valores.setCol2(fila.get(1));
            valores.setCol3(fila.get(2));
            valores.setCol4(fila.get(3));
            valoresList.add(valores);
        }

        // Ejecutar proceso de contar primos
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCore);
        CountDownLatch latch = new CountDownLatch(valoresList.size() / filasHi);
        List<NumPrimos> num = new ArrayList<>();

        for (int i = 0; i < valoresList.size(); i += filasHi) {
            List<Valores> sublist = valoresList.subList(i, Math.min(i + filasHi, valoresList.size()));
            NumPrimos primo = new NumPrimos(sublist, latch);
            num.add(primo);
            executor.execute(primo);
        }

        // Esperar a que todas las tareas terminen
        latch.await();
        executor.shutdown();

        // Insertar datos en la base de datos
        em.getTransaction().begin();
        for (Valores valores : valoresList) {
            em.persist(valores);
        }
        em.getTransaction().commit();

        // Calcular total de números primos
        int totalPrimos = 0;
        for (NumPrimos tarea : num) {
            totalPrimos += tarea.getContadorPrimos();
        }

        System.out.println("Total de números primos: " + totalPrimos);

        em.close();
        emf.close();
    }
}