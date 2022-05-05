import java.util.*;
import java.io.*;

public class Santorini {
	public static void main(String[] args) throws FileNotFoundException {
		
		int loop = 1;
		
		while (loop >= 0) {

			Scanner s = new Scanner( /*System.in*/ new FileInputStream("Trapped.txt"));
			SantoriniGame game = new SantoriniGame();
			System.out.println("Please enter the name of the first player:");
			String player1 = s.nextLine();
			System.out.println("Please enter the name of the Second player player:");
			String player2 = s.nextLine();
			int worker = 0;
			
			
				/////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////

			{

				int ix = 0;
				int iy = 0;

				while (true) {
					
					System.out.println("Player " + player1 + " please enter the inisial coordinats for w11");
					System.out.println("Please enter the x and y coordinate for the worker ");
					
					s.next();
					ix = s.nextInt()+1;
					iy = s.nextInt()+1;

					if ((ix <= 5 && ix >= 1) && (iy >=1  && iy <= 5)) {
						game.getWorkers()[0].placeWorker(ix,iy);
						break;
					} else {
						System.err.println("OUT OF THE RANGE OF THE BOARD!!");
					}
					
				}

				while (true) {
					System.out.println("Player " + player1 + " please enter the inisial coordinats for w12");
					System.out.println("Please enter the x and y coordinate for the worker ");
					s.next();
					ix = s.nextInt()+1;
					iy = s.nextInt()+1;
					if ((ix <= 5 && ix >= 1) && (iy >=1  && iy <= 5)) {
						if (ix != game.getWorkers()[0].getPositionX() || iy != game.getWorkers()[0].getPositionY()) {
							game.getWorkers()[1].placeWorker(ix, iy);
							break;
						} else {
							System.err.println("You cannot have 2 workers at the same position!! try again");
							
						}
					} else {
						System.err.println("OUT OF THE RANGE OF THE BOARD!!");
					}
				}

				while (true) {
					System.out.println("Player " + player2 + " please enter the inisial coordinats for w21");
					System.out.println("Please enter the x and y coordinate for the worker ");
					s.next();
					ix = s.nextInt()+1;
					iy = s.nextInt()+1;
					if ((ix <= 5 && ix >= 1) && (iy >=1  && iy <= 5)) {
						if ((ix != game.getWorkers()[0].getPositionX() || iy != game.getWorkers()[0].getPositionY())
								&& (ix != game.getWorkers()[1].getPositionX()
										|| iy != game.getWorkers()[1].getPositionY())) {
							game.getWorkers()[2].placeWorker(ix, iy);
							break;
						} else {
							System.err.println("You cannot have 2 workers at the same position!! try again");
							
						}
					} else {
						System.err.println("OUT OF THE RANGE OF THE BOARD!!");
					}
				}
				
				
				
				

				while (true) {
					System.out.println("Player " + player2 + " please enter the inisial coordinats for w22");
					System.out.println("Please enter the x and y coordinate for the worker ");
					s.next();
					ix = s.nextInt()+1;
					iy = s.nextInt()+1;
					
					if ((ix <= 5 && ix >= 1) && (iy >=1  && iy <= 5)) {
						if ((ix != game.getWorkers()[0].getPositionX() || iy != game.getWorkers()[0].getPositionY())
								&& (ix != game.getWorkers()[1].getPositionX()
										|| iy != game.getWorkers()[1].getPositionY())
								&& (ix != game.getWorkers()[2].getPositionX()
										|| iy != game.getWorkers()[2].getPositionY())) {
							game.getWorkers()[3].placeWorker(ix, iy );
							break;
						} else {
							System.err.println("You cannot have 2 workers at the same position!! try again");
							
						}
					} else {
						System.err.println("OUT OF THE RANGE OF THE BOARD!!");
					}
				}
			}
			
			/////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////  the game /////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////

			game.ininitializing();

			System.out.println(game);

			boolean trapped = false;
			boolean turns = true;
			
			while (!game.hasWon()) {

				if (turns) {
					
					
					System.out.println("It is " + player1 + " turn.\nPlease choose worker [w11][w12]");
					String choosen = s.next();

					
					
							if (choosen.equalsIgnoreCase("w11")) {
								worker = 0;
							} else if (choosen.equalsIgnoreCase("w12")) {
								worker = 1;
							} else {
								System.out.println("wrong input");
								continue;
							}

					
					
					int w = worker;
					
					boolean tMove = true;
					
					while (tMove) {
						
						
						System.out.println("Please enter [X,Y] for movment");
						int x = s.nextInt() + 1;
						int y = s.nextInt() + 1;
						System.out.println("moving "+choosen+" to x=" + (x-1) + " y=" + (y-1));
						
						
						if (!game.isTrapped(game, w)) {
							trapped = true;
							System.err.println("TRAPPED TRAPPED TRAPPED TRAPPED TRAPPED ");
							break;
						}
						
						

						if (game.getWorkers()[w].move(x, y, game, w) && game.isTrapped(game, w)) {
							System.out.println(game);
									
									
										if (game.hasWon()) {
											break;
										}
		
									
									
									tMove = false;
									
									boolean tBuild = true;
									
											while (tBuild) {
												System.out.println("Please enter [X,Y] for building");
												int bx = s.nextInt() + 1;
												int by = s.nextInt() + 1;
												
													
														if (game.build(bx, by, w)) {
														System.out.println("building to x=" + (bx-1) + " y=" + (by-1));
														System.out.println(game);
														tBuild = false;
														} else {
														System.err.println("the selected cell does not satisfy the rules");
														}
											}
					

							} else {
								System.err.println("the selected cell does not satisfy the rules");
							}

						
						
					}

					if (!game.isTrapped(game, w)) {
						trapped = true;
						break;
					}

					
					
					
					
					turns = false;

				} else if (!turns) {
					System.out.println("It is " + player2 + " turn.\nPlease choose worker [w21][w22]");
					String choosen = s.next();

					
					
							if (choosen.equalsIgnoreCase("w21")) {
								worker = 2;
							} else if (choosen.equalsIgnoreCase("w22")) {
								worker = 3;
							} else {
								System.out.println("wrong input");
								continue;
							}

							
					int w = worker;
					
					boolean tMove = true;
					
					while (tMove) {
						System.out.println("Please enter [X,Y] for movment");
						int x = s.nextInt() + 1;
						int y = s.nextInt() + 1;
						System.out.println("moving "+choosen+" to x=" + (x-1) + " y=" + (y-1));
						
						if (!game.isTrapped(game, w)) {
							trapped = true;
							System.err.println("TRAPPED TRAPPED TRAPPED TRAPPED TRAPPED ");
							break;
						}
						
						

						if (game.getWorkers()[w].move(x, y, game, w) && game.isTrapped(game, w)) {
							System.out.println(game);
							
							if (game.hasWon()) {
								break;
							}
							
							
							

							if (!game.isTrapped(game, w)) {
								trapped = true;
								System.err.println("TRAPPED TRAPPED TRAPPED TRAPPED TRAPPED ");
								break;
							}
							
							
							

							tMove = false;
							boolean tBuild = true;
							while (tBuild) {
								System.out.println("Please enter [X,Y] for building");
								int bx = s.nextInt() + 1;
								int by = s.nextInt() + 1;
								
									if (game.build(bx, by, w)) {
										
										System.out.println("building to x=" + (bx-1) + " y=" + (by-1));
										System.out.println(game);
	
										tBuild = false;
									} else {
										System.err.println("the selected cell does not satisfy the rules");
									}
							}

							
							
							} else {
								System.err.println("the selected cell does not satisfy the rules");
							}

					}

					
					
					if (!game.isTrapped(game, w)) {
						trapped = true;
						break;
					}
					
					

					
					turns = true;
				}

			}
			
			

			if ((worker == 0 || worker == 1) && trapped) {
				System.out.println(
						"Player [" + player1 + "] have been trapped!!\nPlayer [" + player2 + "] won the game!!");
			} else if ((worker == 2 || worker == 3) && trapped) {
				System.out.println(
						"Player [" + player2 + "] have been trapped!!\nPlayer [" + player1 + "] won the game!!");
			} else if (worker == 2 || worker == 3) {
				System.out.println("Player [" + player2 + "] has won!!");
			} else if (worker == 0 || worker == 1) {
				System.out.println("Player [" + player1 + "] has won!!");
			}

			/* System.out.println("Do you wish to reset the game? [enter a negative number
			 to quit or a postive to reset]");

			 loop = s.nextInt();

			 if (loop >= 0) {
			 game.reset();
			 } else {
			System.out.println("Exiting....");*/
			System.exit(1);
			/*} */

			s.close();

		}

	}
}
