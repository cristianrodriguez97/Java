
The objective of this activity is to understand and demonstrate how threads work. For this purpose, in this activity, it has been decided to test the Semaphores tool. To verify correct operation, five threads will be created. When the first thread or process finishes, the second and third process will start and when threads 2 and 3 are finished, threads 4 and 5 can be executed respectively. A graphical representation is shown in the following figure.
It has been configured so that the activity performed by each thread is to greet and identify itself. Due to this scheme, the possible results will be that the threads are executed in the order 1, 2, 3, 4, 5 or 1, 3, 2, 5, 4.    

 ![Esquema](https://github.com/cristianrodriguez97/Java/assets/72400714/12dac796-0e8f-4c7d-8876-439c0b6a6774)

The two possible outputs are shown below. They will happen 50% of the time in a random way.

Output 1:

![imagen](https://github.com/cristianrodriguez97/Java/assets/72400714/529cf33e-9cdc-475b-aeed-ddef59f7b830)

Output 2:

![imagen](https://github.com/cristianrodriguez97/Java/assets/72400714/6b721f89-298e-434f-ac9e-ae5d6481506f)

