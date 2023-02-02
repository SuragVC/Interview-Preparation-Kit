class DeadLockExample {
    Object account1 = new Object();
    Object account2= new Object();
     Thread t1  = new Thread(){
         @Override
         public void run() {
             synchronized (account1){
                 System.out.println("Account 1 is locked");
                 try {
                     t1.sleep(100);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
                 synchronized (account2){
                     System.out.println("Account 2 is locked");
                 }
             }
         }
     };
    Thread t2  = new Thread(){
        @Override
        public void run() {
            synchronized (account2){
                System.out.println("Account 2 is locked");
                synchronized (account1){
                    System.out.println("Account 2 is locked");
                }
            }
        }
    };
    public static void main(String[] args) throws InterruptedException {
        //Q. What is Dead Lock situation
        /*      Deadlock situation occurs when two or more threads are waiting for the resources which is locked.
            This will make the threads wait for infinitely for releasing the resources.*/
        //Q. Write an example of deadlock situation
        DeadLockExample threadCaller  = new DeadLockExample();
        threadCaller.t1.start();
        System.out.println("Thread 1 is started!");
        threadCaller.t2.start();
        System.out.println("Thread 2 is started!");
        /* In this example when the main method starts it will create an Object of DeadLockExample class.
        Using that object t1 thread is called. t1 thread will lock the account1 object and sleep for 100 milliseconds.
        In the meantime, t2 will start to execute and it will acquire a lock on the account2 object and try to access account1.
        But the account1 object is already locked by t1 so it will wait for t1 to release the lock. t1 will wake after
        100 milliseconds and it will try to access the account2 object which is already locked. Now both threads are
        waiting for each other to complete each other's execution to release the resources, which will make the program
        work indefinitely. It is called Deadlock.*/
    }
}

