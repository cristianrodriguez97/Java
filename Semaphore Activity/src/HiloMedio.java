


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class in which the second process will be initialized, which will have to wait for the first process to finish, indicate its identifier and enable the second semaphore.
 */
public class HiloMedio extends Thread{
    private int idMedio;
    private Semaphore sem1,sem2;
    
/**
 * Constructor of the class showing that the second process will need an identifier and two semaphore, one to wait and other to enable.
 * @param idMedio Thread ID
 * @param sem1 Semaphore for which you will have to wait to start the process
 * @param sem2 Semaphore that will enable the when it finishes
 */
public HiloMedio(int idMedio, Semaphore sem1, Semaphore sem2){
    this.sem1=sem1;
    this.sem2=sem2;
    this.idMedio=idMedio;
    }

/**
 * Activity performed by the thread when it executes.
 */
public void run(){
        try {
        	// Wait until the semaphore is free to start the process.
            sem1.acquire(1);
            System.out.println("hola, mi identificador es el " + idMedio);
            // When the execution is finished, it enables the semaphore            
            sem2.release(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloMedio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
