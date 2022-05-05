public class Worker {
   private String name;
   private int positionX;
   private int positionY;



   public Worker(String name){
      this.name = name;
   }
   
   
   public void placeWorker(int x, int y){
		   positionX = x;
	       positionY = y;
   }




   public boolean move(int newPositionX, int newPositionY, SantoriniGame game,	int w) {


      
			   if((newPositionX < 6 && newPositionX > 0)&&(newPositionY > 0 && newPositionY < 6)) {
				   
				   if(game.getBoard()[newPositionX-1][newPositionY-1].indexOf("w") != -1){
		               System.err.println("THERE IS A PLAYER YOU CANNOT GO THERE!!");
		               return false;
		            }
		            if(!game.getBoard()[positionX-1][positionY-1].contains("B") && (game.getBoard()[newPositionX-1][newPositionY-1].equals("BB") || game.getBoard()[newPositionX-1][newPositionY-1].equals("BBB") || game.getBoard()[newPositionX-1][newPositionY-1].equals("BBBD"))) {
		               System.err.println("THERE IS A HIGHER BULDING YOU CANNOT GO THERE!!");
		               return false;
		            }
		            if(!game.getBoard()[positionX-1][positionY-1].substring(0,2).equals("BB") && game.getBoard()[newPositionX-1][newPositionY-1].equals("BBB")) {
		               System.err.println("THERE IS A BBB YOU CANNOT GO THERE!!");
		             return false;
		            }
		
		            if(game.getBoard()[positionX-1][positionY-1].substring(0,2).equals("BB") && game.getBoard()[newPositionX-1][newPositionY-1].equals("BBBD")) {
		               System.err.println("THERE IS A DOME YOU CANNOT GO THERE!!");
		               return false;
		            }
		
		            
		            if((Math.abs(positionX - newPositionX) == 1 || Math.abs(positionX - newPositionX) == 0) &&
		                    (Math.abs(positionY - newPositionY) == 1 || Math.abs(positionY - newPositionY) == 0)) {
		            	
		            	game.movePlayer(newPositionX, newPositionY, w);
		                
		            	return true;
		            }else{
		               System.err.println("MOVEMENT OUT OF REACH!!");
		                return false;
		            }
		          
		       }else {

		    	   	
		            
		            System.err.println("OUT OF THE RANGE OF THE BOARD!!");
			           return false;
		       }


   }






   public boolean moveNoErrorMesseges(int newPositionX, int newPositionY, SantoriniGame game) {


      if((newPositionX > 5 && newPositionX < 1)&&(newPositionY > 5 && newPositionY < 1)) {
         return false;
      }



      if(game.getBoard()[newPositionX-1][newPositionY-1].indexOf("w") != -1){
         return false;
      }
      if(!game.getBoard()[positionX-1][positionY-1].contains("B") && (game.getBoard()[newPositionX-1][newPositionY-1].equals("BB") || game.getBoard()[newPositionX-1][newPositionY-1].equals("BBB") || game.getBoard()[newPositionX-1][newPositionY-1].equals("BBBD"))) {
         return false;
      }
      if(!game.getBoard()[positionX-1][positionY-1].substring(0,2).equals("BB") && game.getBoard()[newPositionX-1][newPositionY-1].equals("BBB")) {
         return false;
      }

      if(game.getBoard()[positionX-1][positionY-1].substring(0,2).equals("BB") && game.getBoard()[newPositionX-1][newPositionY-1].equals("BBBD")) {
         return false;
      }

      if((Math.abs(positionX - newPositionX) == 1 || Math.abs(positionX - newPositionX) == 0) &&
              (Math.abs(positionY - newPositionY) == 1 || Math.abs(positionY - newPositionY) == 0)) {

         return true;

      }else{
         return false;
      }

   }

   public String getName() {
      return name;
   }

   

   public int getPositionX() {
      return positionX;
   }

   public void setPositionX(int positionX) {
      this.positionX = positionX;
   }

   public int getPositionY() {
      return positionY;
   }

   public void setPositionY(int positionY) {
      this.positionY = positionY;
   }
}
