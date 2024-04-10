


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloUltimo extends Thread{
    private int idUltimo;
    private Semaphore semaf1, semaf2;
    
public HiloUltimo(int idUltimo, Semaphore semaf1, Semaphore semaf2){
    this.idUltimo=idUltimo;
    this.semaf1=semaf1;
    this.semaf2=semaf2;
    }

public void run(){
        try {
            semaf1.acquire(1);
            semaf2.acquire(1);
            System.out.println("Hola, mi identificador es el " + idUltimo);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloUltimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
