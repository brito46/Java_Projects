import java.util.*;

//This application allows a user to go against a non-AI computer. If you get three symbols consecutively, you win! 

public class TicTacToe {
	static ArrayList<Integer> playerPos = new ArrayList<>(); //static so it can be accessed by any function
    static ArrayList<Integer> cpuPos = new ArrayList<>(); 

     public static void main(String []args){

     	 char [][] game = {{' ', '|', ' ', '|', ' '}, //how to create a multi dim array for any kind(int and str too)
     	 				   {'-', '+', '-', '+', '-'},
     	 				   {' ', '|', ' ', '|', ' '}, 
     	                   {'-', '+', '-', '+', '-'},
     	                   {' ', '|', ' ', '|', ' '}};
     	while(true){
     		printBoard(game);  //showing where cpu put their piece
     		Scanner scan = new Scanner(System.in);   //you have to create a new input everytime for a new player input
     		System.out.println("Enter position from 1-9:");
     		int pos = scan.nextInt();
     		while(playerPos.contains(pos) || cpuPos.contains(pos)){
     			System.out.println("position taken! try another one:");
     			pos = scan.nextInt(); //try a new input for a value that isnt taken
     		}
     		playerPos.add(pos);
			move(game, pos, "Player");
			String ans = checkWinner();
			printBoard(game); //seeing where i put my piece after i've gone
     		System.out.println(ans);
     		if(ans.length() > 0) break; //game ended so get out of forver loop

     		Random rand = new Random();
     		int rando = rand.nextInt(9) + 1; //prints out a random number from 1-9
     		while(playerPos.contains(rando) || cpuPos.contains(rando)){
     			System.out.println("position taken! try another one:");
     			rando = rand.nextInt(9) + 1;//try a new input for a value that isnt taken
     		}
     		cpuPos.add(rando);
     		move(game, rando, "cpu");

     		System.out.println(ans);
     		if(ans.length() > 0) break; //game ended so get out of forver loop
     	}
     }
     public static void printBoard(char [][] g){

        for(int i = 0; i < g.length; i++){
     		for(int j = 0; j < g[0].length; j++){

     			System.out.print(g[i][j]); //printing out every column in row
     		}
     		System.out.println();//so the new row can be printed below the prev
     	}
     }
     public static void move(char[][] game, int x, String user){
     		char symbol = 'X'; //assuming it is Player's turn
     		if(user.equals("cpu")) symbol = 'O'; //switching symbols depedning on whos turn

          	switch(x) {

     		case 1 :  //if pos == 1;
     			game[0][0] = symbol;
     			break;
     		case 2 :  
     			game[0][2] = symbol;
     			break;
     		case 3 :  
     			game[0][4] = symbol;
     			break;
     		case 4 :  
     			game[2][0] = symbol;
     			break;
     		case 5 :  
     			game[2][2] = symbol;
     			break;
     		case 6 :  
     			game[2][4] = symbol;
     			break;
     		case 7 :  
     			game[4][0] = symbol;
     			break;
     		case 8 :  
     			game[4][2] = symbol;
     			break;
     		case 9 :  
     			game[4][4] = symbol;
     			break;
     		default:
     		 	break;
     	}
     }
     public static String checkWinner() {
     	List topRow = Arrays.asList(1, 2, 3); //the first three elements are the first three columns in first row
     	List midRow = Arrays.asList(4, 5, 6);
     	List botRow = Arrays.asList(7, 8, 9);
     	List leftCol = Arrays.asList(1, 4, 7);
     	List midCol = Arrays.asList(2, 5, 8);
     	List rightCol = Arrays.asList(3, 6, 9);
     	List diag1 = Arrays.asList(1, 5, 9);
     	List diag2 = Arrays.asList(3, 5, 7);

     	ArrayList<List> winning = new ArrayList<>();
     	winning.add(topRow);
     	winning.add(midRow);
     	winning.add(botRow);
     	winning.add(leftCol);
     	winning.add(midCol);
     	winning.add(rightCol);
     	winning.add(diag1);
     	winning.add(diag2);

     	for(List l : winning){ //this is going through every list in winning, so basically winning.get(i)
     		if(playerPos.containsAll(l)) return "Player wins";  //checking every list in winning

     		else if(cpuPos.containsAll(l)) return "cpu wins";

     		else if(playerPos.size() + cpuPos.size() == 9) return "Tie"; //board is full and nobody won

     	}
     	return ""; //if there is no winners or tie at the moment
     }
 }