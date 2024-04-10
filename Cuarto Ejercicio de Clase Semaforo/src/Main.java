


import java.util.concurrent.Semaphore;

/**
 * The objective of this activity is to understand and demonstrate how threads work. 
 * For this purpose, in this activity, it has been decided to test the Semaphores tool.
 */
public class Main {
	
/**
 * To verify correct operation, five threads will be created. When the first thread or process finishes, the second and third process will start. 
 * When threads 2 and 3 are finished, threads 4 and 5 can be executed respectively. 
 * It has been configured so that the activity performed by each thread is to greet and identify itself.
 * Due to this scheme, the possible results will be that the threads are executed in the order 1, 2, 3, 4, 5 or 1, 3, 2, 5, 4.    
 * @param args
 */
public static void main(String[]args){
	// In order for this scheme to be executed correctly, it will be necessary to initialize three semaphores which is the maximum number to be used at one time. 
	// A single semaphore will be required for the execution of the first thread. 
	// When it finishes, it will enable the first semaphore so that threads 2 and 3 can start, which, when finished, will enable a second and third semaphore. 
	// When these threads finish, threads 4 and 5 can start respectively.
    Semaphore semaforoPrimero=new Semaphore(0, true);
    Semaphore semaforoSegundo=new Semaphore(0, true);
    Semaphore semaforoTercero=new Semaphore(0, true);
    
    // Threads are initialized indicating the semaphore they must wait for, if any, and the semaphore they must enable when they finish their execution.
    HiloAnterior T1 = new HiloAnterior(1, semaforoPrimero);
    // When first semaphore is enabled, threads 2 and 3 can start
    HiloMedio T2 = new HiloMedio(2, semaforoPrimero, semaforoSegundo);
    HiloMedio T3 = new HiloMedio(3, semaforoPrimero, semaforoTercero);
    // When first semaphore and second or third, the forth and fifth thread can be executed respectively.
    HiloUltimo T4 = new HiloUltimo(4, semaforoPrimero, semaforoSegundo);
    HiloUltimo T5 = new HiloUltimo(5, semaforoPrimero, semaforoTercero);
    
    T1.start();
    T2.start();
    T3.start();
    T4.start();
    T5.start();
    }
}
