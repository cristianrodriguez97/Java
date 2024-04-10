


import java.util.concurrent.Semaphore;

public class Main {
    
public static void main(String[]args){
    Semaphore semaforoPrimero=new Semaphore(0, true);
    Semaphore semaforoSegundo=new Semaphore(0, true);
    Semaphore semaforoTercero=new Semaphore(0, true);
    
    HiloAnterior T1 = new HiloAnterior(1, semaforoPrimero);
    HiloMedio T2 = new HiloMedio(2, semaforoPrimero, semaforoSegundo);
    HiloMedio T3 = new HiloMedio(3, semaforoPrimero, semaforoTercero);
    HiloUltimo T4 = new HiloUltimo(4, semaforoPrimero, semaforoSegundo);
    HiloUltimo T5 = new HiloUltimo(5, semaforoPrimero, semaforoTercero);
    
    T1.start();
    T2.start();
    T3.start();
    T4.start();
    T5.start();
    }
}
