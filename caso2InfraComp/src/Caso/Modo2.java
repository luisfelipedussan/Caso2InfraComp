package Caso;

import java.util.ArrayList;



public class Modo2 {


    private Integer marco; // Número de marcos de página disponibles
  
    private ArrayList<Integer> info;
    public Modo1 modo1;
    public Buffer buffer;
    private ArrayList<ArrayList<Integer>> paginas;

    public Modo2(Integer marcos, ArrayList<Integer> info2) throws InterruptedException {
        this.marco = marcos;
        this.info = info2;
        Buffer buffer = new Buffer(marco);
        this.buffer = buffer;

        Thread1 thread1 = new Thread1(buffer,info2);
        Thread2 thread2 = new Thread2(buffer,thread1);

         //Start the threads
         thread1.start();
 
         //Waits for both thread 1 and 2 to finish execution
         thread1.join();
         thread2.join();
      //Output report
      option2ResultConsole();


  }

  //--------------------------------------------------------------------------
  // Methods
  //--------------------------------------------------------------------------

  public void option2ResultConsole(){



      System.out.println("Page frames(Marcos de pagina): " + buffer.marcoPaginas + "\n\n");

      System.out.println("Page errors(Fallos de pagina): " + buffer.falloPagina+ "\n\n");

    

  }


}
