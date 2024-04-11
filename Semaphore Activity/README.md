# Thread management using semaphores in Java
The objective of this activity is to understand and demonstrate how threads work. For this purpose, in this activity, it has been decided to test the Semaphores tool. To verify correct operation, five threads will be created. When the first thread or process finishes, the second and third process will start and when threads 2 and 3 are finished, threads 4 and 5 can be executed respectively. A graphical representation is shown in the following figure.
It has been configured so that the activity performed by each thread is to greet and identify itself. Due to this scheme, the possible results will be that the threads are executed in the order 1, 2, 3, 4, 5 or 1, 3, 2, 5, 4.    

 ![Esquema](https://github.com/cristianrodriguez97/Java/assets/72400714/12dac796-0e8f-4c7d-8876-439c0b6a6774)

## Development
For the development of this activity, three classes have been created, that of a starting thread that has only one semaphore to enable, that of the intermediate threads and that of the final threads. 
The following is the code implemented for the correct operation of the system.

### Initial thread class
Class in which the first process will be initialized, which will only have to indicate its identifier and enable the semaphore once it is finished.
```
 import java.util.concurrent.Semaphore;

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
```

### Mid thread class
Class in which the second process will be initialized, which will have to wait for the first process to finish, indicate its identifier and enable the second semaphore.
```
 import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


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
```

### End thread class
Class of the third and last phase of the process, where it is necessary to wait until the previous phases have been completed to be executed.
```
 import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

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
```

### Main class
To verify correct operation, five threads will be created. When the first thread or process finishes, the second and third process will start. When threads 2 and 3 are finished, threads 4 and 5 can be executed respectively. It has been configured so that the activity performed by each thread is to greet and identify itself. Due to this scheme, the possible results will be that the threads are executed in the order 1, 2, 3, 4, 5 or 1, 3, 2, 5, 4.  
```
 import java.util.concurrent.Semaphore;

public class Main {
	
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
```

### Output
The two possible outputs are shown below. They will happen 50% of the time in a random way.

Output 1:

![imagen](https://github.com/cristianrodriguez97/Java/assets/72400714/529cf33e-9cdc-475b-aeed-ddef59f7b830)

Output 2:

![imagen](https://github.com/cristianrodriguez97/Java/assets/72400714/6b721f89-298e-434f-ac9e-ae5d6481506f)

