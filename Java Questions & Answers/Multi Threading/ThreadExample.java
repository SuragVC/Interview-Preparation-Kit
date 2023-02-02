class ThreadExample {
    Thread t1 = new Thread(new Runnable() {
        public void run() {
            System.out.println("Thread 1 running");
        }
    });
    Thread t2 = new Thread(new Runnable() {
        public void run() {
            System.out.println("Thread 2 running");
        }
    });
    public static void main(String[] args) throws InterruptedException {
        //Q. What is multithreading in Java
        /*      Multithreading means multiple threads executing at same time.Which will help
        * to use resources at maximum capacity. */
        //Q. Write an example of multithreading
        ThreadExample threads = new ThreadExample();
        threads.t1.start();
        threads.t2.start();
        /*Two threads, t1 and t2. The start() method of both threads will be called in the main method, which will start the execution of each thread concurrently.
        The output of the program will be:
        Thread 1 running
        Thread 2 running
        Exact order of the output may vary each time the program is executed as the two threads are running concurrently. */
    }
}
