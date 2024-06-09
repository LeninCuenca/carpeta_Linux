package Semana1;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class NumPrimos implements Runnable {

    private final List<Valores> sublist;
    private final CountDownLatch latch;
    public int contadorPrimos;

    public NumPrimos(List<Valores> sublist, CountDownLatch latch) {
        this.sublist = sublist;
        this.latch = latch;
        this.contadorPrimos = 0;
    }

    @Override
    public void run() {
        int totalPrimos = 0;
        for (Valores valores : sublist) {
            if (esPrimo(valores.getCol1())) {
                totalPrimos += valores.getCol1();
            }
            if (esPrimo(valores.getCol2())) {
                totalPrimos += valores.getCol2();
            }
            if (esPrimo(valores.getCol3())) {
                totalPrimos += valores.getCol3();
            }
            if (esPrimo(valores.getCol4())) {
                totalPrimos += valores.getCol4();
            }
        }

        contadorPrimos = totalPrimos;
        latch.countDown();
    }

    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int getContadorPrimos() {
        return contadorPrimos;
    }

    public void persistResults(EntityManager em) {
        for (Valores valores : sublist) {
            em.persist(valores);
        }
    }
}
