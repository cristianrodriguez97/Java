


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class of the third and last phase of the process, where it is necessary to wait until the previous phases have been completed to be executed.
 */
public class HiloUltimo extends Thread{
    private int idUltimo;
    private Semaphore semaf1, semaf2;
    
/**
 * Constructor of the class showing that the second process will need an identifier and two semaphore, for which it must wait for.    
 * @param idUltimo Thread ID
 * @param semaf1 Semaphore for which you will have to wait to start the process
 * @param semaf2 Semaphore for which you will have to wait to start the process
 */
public HiloUltimo(int idUltimo, Semaphore semaf1, Semaphore semaf2){
    this.idUltimo=idUltimo;
    this.semaf1=semaf1;
    this.semaf2=semaf2;
    }

/**
 * Activity performed by the thread when it executes.
 */
public void run(){
        try {
        	// Wait until both semaphore are free to start the process.
            semaf1.acquire(1);
            semaf2.acquire(1);
            System.out.println("Hola, mi identificador es el " + idUltimo);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloUltimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
