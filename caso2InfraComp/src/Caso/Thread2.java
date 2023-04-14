package Caso;

public class Thread2 extends Thread {

    public Buffer buffer;
    public Thread thread1;

    public Thread2(Buffer buffer, Thread thread1) {
        this.buffer = buffer;
        this.thread1 = thread1;
    }

    @Override

    public void run() {
        while (thread1.isAlive()) {
            bufferaños();
        }
    }

    public void bufferaños(){
        buffer.años();

        try{
            Thread.sleep(1);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }  
}
