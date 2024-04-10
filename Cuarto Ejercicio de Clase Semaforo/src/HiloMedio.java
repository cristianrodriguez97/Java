


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloMedio extends Thread{
    private int idMedio;
    private Semaphore sem1,sem2;
    
public HiloMedio(int idMedio, Semaphore sem1, Semaphore sem2){
    this.sem1=sem1;
    this.sem2=sem2;
    this.idMedio=idMedio;
    }

public void run(){
        try {
            sem1.acquire(1);
            System.out.println("hola, mi identificador es el " + idMedio);
            sem2.release(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloMedio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
