


import java.util.concurrent.Semaphore;

public class HiloAnterior extends Thread{
    private Semaphore semaforo1;
    private int idAnterior;
    
public HiloAnterior(int idAnterior, Semaphore semaforo1){
    this.semaforo1=semaforo1;
    this.idAnterior=idAnterior;
    }

public void run(){
    System.out.println("Hola, mi identificador es el " + idAnterior);
    semaforo1.release(4);
    }
}
