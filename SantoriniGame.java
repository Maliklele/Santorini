public class SantoriniGame {
   private String[][] board = new String[5][5];
   private Worker[] workers;


   public SantoriniGame() {

      workers = new Worker[4];
      workers[0] = new Worker("w11");
      workers[1] = new Worker("w12");
      workers[2] = new Worker("w21");
      workers[3] = new Worker("w22");


      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            board[i][j] = "";
         }
      }

   }

   //this method move a worker from one place to another if it satisfies the rules that are in Worker class method move.
   public void movePlayer(int x, int y, int w) {
      board[workers[w].getPositionX() - 1][workers[w].getPositionY() - 1] = board[workers[w].getPositionX() - 1][workers[w].getPositionY() - 1].replace(workers[w].getName(), "");
      workers[w].setPositionX(x);
      workers[w].setPositionY(y);
      board[workers[w].getPositionX() - 1][workers[w].getPositionY() - 1] += workers[w].getName();

   }


   //this method excuted at the begining to place the workers on the board.
   public void ininitializing() {
      board[workers[0].getPositionX() - 1][workers[0].getPositionY() - 1] += workers[0].getName();
      board[workers[1].getPositionX() - 1][workers[1].getPositionY() - 1] += workers[1].getName();
      board[workers[2].getPositionX() - 1][workers[2].getPositionY() - 1] += workers[2].getName();
      board[workers[3].getPositionX() - 1][workers[3].getPositionY() - 1] += workers[3].getName();

      

   }

   

   //these are the rules for building for a spesific selected worker.
   public boolean build(int positionX, int positionY, int w) {
      if (board[positionX - 1][positionY - 1].contains("w")) {
         System.err.println("YOU CANNOT BUILD ON TOP OF PLAYER");
         return false;
      }
      if (board[positionX - 1][positionY - 1].equals("BBBD")) {
         System.err.println("THIS BULDING REACHED MAXIMUM HIGHT");
         return false;
      }
      if ((positionX > 5 || positionX < 1) && (positionY > 5 || positionY < 1)) {
         System.err.println("THIS PLACMENT IS OUT IF THE RANGE OF THE BOARD");
         return false;
      }
      if (Math.abs(workers[w].getPositionX() - positionX) == 0 && Math.abs(workers[w].getPositionY() - positionY) == 0) {
         System.err.println("YOU CANNOT BULD ON YOUR SELF");
         return false;
      }
      if ((Math.abs(workers[w].getPositionX() - positionX) == 1 || Math.abs(workers[w].getPositionX() - positionX) == 0) &&
              (Math.abs(workers[w].getPositionY() - positionY) == 1 || Math.abs(workers[w].getPositionY() - positionY) == 0)) {
    	  
	    	  if (board[positionX - 1][positionY - 1].equals("") ||
	                  board[positionX - 1][positionY - 1].equals("B") ||
	                  board[positionX - 1][positionY - 1].equals("BB")
	          ) {
	             board[positionX - 1][positionY - 1] += "B";
	
	          } else if (board[positionX - 1][positionY - 1].equals("BBB")) {
	             board[positionX - 1][positionY - 1] += "D";
	          }
    	  
         return true;
      }
      System.err.println("PLACMENT OUT OF REACH");
      return false;
   }

   //this methods checks after every turn if a player has won.
   public boolean hasWon() {
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j].equals("BBBw11") || board[i][j].equals("BBBw12") || board[i][j].equals("BBBw21") || board[i][j].equals("BBBw22")) {
               return true;
            }
         }
      }
      return false;
   }



   //this methods checks if there is anywhere player would go, if there is no where to go, it returns false
   public boolean isTrapped(SantoriniGame game, int w) {
      
      

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (workers[w].moveNoErrorMesseges(i+1,j+1, game)){
               return true;
            }
         }
      }
      return false;
   }


   //this method resets the board by removing all the elements.
   public void reset() {
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            board[i][j]="";
         }
      }
   }


   //this method returns a representaion of the current board.
   public String toString() {

      return "\n#-------0----------------1--------------2---------------3---------------4-------#\n" +
              "0\t" +board[0][0] + "\t|\t" + board[0][1] + "\t|\t" + board[0][2] + "\t|\t" + board[0][3] + "\t|\t" + board[0][4] + "\t0\t" +
              "\n#-------------------------------------------------------------------------------#\n" +
              "1\t" +board[1][0] + "\t|\t" + board[1][1] + "\t|\t" + board[1][2] + "\t|\t" + board[1][3] + "\t|\t" + board[1][4] + "\t1\t" +
              "\n#-------------------------------------------------------------------------------#\n" +
              "2\t" +board[2][0] + "\t|\t" + board[2][1] + "\t|\t" + board[2][2] + "\t|\t" + board[2][3] + "\t|\t" + board[2][4] + "\t2\t" +
              "\n#-------------------------------------------------------------------------------#\n" +
              "3\t" +board[3][0] + "\t|\t" + board[3][1] + "\t|\t" + board[3][2] + "\t|\t" + board[3][3] + "\t|\t" + board[3][4] + "\t3\t" +
              "\n#-------------------------------------------------------------------------------#\n" +
              "4\t" +board[4][0] + "\t|\t" + board[4][1] + "\t|\t" + board[4][2] + "\t|\t" + board[4][3] + "\t|\t" + board[4][4] + "\t4\t" +
              "\n#-------0----------------1--------------2---------------3---------------4-------#\n" ;
   }

   public String[][] getBoard() {
      return board;
   }

  

   public Worker[] getWorkers() {
      return workers;
   }

   
}
