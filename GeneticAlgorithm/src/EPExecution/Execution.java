package EPExecution;

import java.util.Scanner;

import main.controllers.Handler;
import main.utils.io.folder.FolderNamesList;

public class Execution {

   public Person friend;
   private Handler handler;

    Execution(int friendOption) {
        switch(friendOption) {
            case 1:
                friend = Person.FELIPE;
                break;
            case 2:
                friend = Person.HUGO;
                break;
            case 3:
                friend = Person.MATHEUS;
                break;
        }
        System.out.println(this.friend.message);
        
        try {
        Thread.sleep(1000);
        } catch(Exception e) {
        	
        }
    }
    
    
   public void execute(int firstPopulationSize, int lastPopulationSize, int numberOfExecutions,
		   int generationsNumber, 
		   double mutationProbability,
		   double crossoverProbability) {
	   int populationSize = firstPopulationSize;
	   
	   this.handler = new Handler
			   (populationSize,
			   generationsNumber,
			   mutationProbability,
			   crossoverProbability);
	   
	   System.out.println("\n");
	   
	   System.out.println(1 + "º source file being created...\n");
	   this.handler.run();
	   System.out.println(1 + "º source file was createad\n");
	   
	   int inc = (lastPopulationSize - firstPopulationSize) / (numberOfExecutions -1);
	   
	   for(int i = 0; i < numberOfExecutions - 1; i++) {
		   populationSize = populationSize + inc;
		   
		   this.handler = new Handler
				   (populationSize,
				   generationsNumber,
				   mutationProbability,
				   crossoverProbability);
		   
		   System.out.println(i + 2 + "º source file being created...\n");
		   this.handler.run();
		   System.out.println(i + 2 + "º source file was createad\n");
	   } 
	   
	   System.out.println("It`s Over! Now you can check on: " +
	   FolderNamesList.ROOT_PATH_ORIGIN + " your execution Logs!");
   }

   public static void main(String[] args) {
	 int friendOption;
	 
	 System.out.println("Olar, digite quem é você: \n(1) para FELIPE, \n(2) para HUGO, \n(3) para MATHEUS;");
	 
	 Scanner in = new Scanner(System.in);
	 friendOption = in.nextInt();
	 in.close();
	 
	 
	 int firstPopulationSize = 100;
	 int lastPopulationSize = 1000;
	 int numberOfExecutions = 10;
	 int generationsNumber = 10;
	 double mutationProbability = 0.3;
	 double crossoverProbability = 0.75;
	 
     Execution execution = new Execution(friendOption);
     execution.execute
                (firstPopulationSize,
        		 lastPopulationSize,
        		 numberOfExecutions, 
        		 generationsNumber, 
        		 mutationProbability,
        		 crossoverProbability);
   }

   private enum Person {
       FELIPE(1), HUGO(2), MATHEUS(3);
       String message;

       Person(int friend) {
           switch(friend) {
               case 1:
                   message = " Nossa Vai! Shooow!! Sucesso!";
                   break;
               case 2:
                   message = "E ae pae!! Ooo, to fino, bixo!";
                   break;
               case 3:
                   message = "MANO, VOCE VIU O QUE ELE FALOU? HAHAHAHAHAHA!  LA na federal, tinha um cara..." ;
                   break;
               default:
            	   message = "Ixi...";
            	   break;
           }
       }
   }

}
