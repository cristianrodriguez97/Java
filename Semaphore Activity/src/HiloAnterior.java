


import java.util.concurrent.Semaphore;

/**
 * Class in which the first process will be initialized, which will only have to indicate its identifier and enable the semaphore once it is finished.
 */
public class HiloAnterior extends Thread{
    private Semaphore semaforo1;
    private int idAnterior;
    
/**
 * Constructor of the class showing that the first process will need an identifier and a semaphore to enable.     
 * @param idAnterior Thread ID
 * @param semaforo1 Semaphore that will enable when it finishes
 */
public HiloAnterior(int idAnterior, Semaphore semaforo1){
    this.semaforo1=semaforo1;
    this.idAnterior=idAnterior;
    }

/**
 * Activity performed by the thread when it executes.
 */
public void run(){
    System.out.println("Hola, mi identificador es el " + idAnterior);
    // When the execution is finished, it enables the semaphore
    semaforo1.release(4);
    }
}
