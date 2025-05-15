package ticTacToeG;

import java.util.Scanner;

public class TicTacToeGameMain {
    public static String Player1;
    public static String Player2;
    private static boolean gameFinished = false;
    private static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '}, 
        {' ', ' ', ' '}
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        getPlayerNames(in);
        
        displayBoard();
        
        while (true) {
            player1Turn(scanner);
            displayBoard();

            if (RefereeAspect.ifPlayerWon(board, 'X')) {
                System.out.println(Player1 + " wins!");
                break;
            }

            if (RefereeAspect.isTie(board)) {
                System.out.println("It is a tie!");
                break;
            }

            player2Turn(scanner);
            displayBoard();

            if (RefereeAspect.ifPlayerWon(board, 'O')) {
                System.out.println(Player2 + " wins!");
                break;
            }

            if (RefereeAspect.isTie(board)) {
                System.out.println("It is a tie!");
                break;
            }
        }

        
        scanner.close();
        in.close();
    }
    
    public static void getPlayerNames(Scanner in) {
        System.out.println("Player 1, what is your name?");
        Player1 = in.nextLine();
        System.out.println("Player 2, what is your name?");
        Player2 = in.nextLine();
    }

    public static void player2Turn(Scanner scanner) {
        String userInput;
        
        while (true) {
            System.out.println("The board is numbered 1|2|3");
            System.out.println("                      4|5|6");
            System.out.println("                      7|8|9");
            System.out.println(Player2 + " Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.  ");
            }
        }
        placeMove(userInput, 'O');
    }

    public static boolean isValidMove(String position) {
        switch(position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    public static void player1Turn(Scanner scanner) {
        String userInput;
        
        while (true) {
            System.out.println("The board is numbered 1|2|3");
            System.out.println("                      4|5|6");
            System.out.println("                      7|8|9");
            System.out.println(Player1 + " Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (isValidMove(userInput)){
                break;
            } else {
                System.out.println(userInput + " is not a valid move.  ");
            }
        }
        placeMove(userInput, 'X');
    }

    public static void placeMove(String position, char symbol) {
        switch(position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    public static void displayBoard() {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2]);
    }
    
    public static boolean isGameFinished() {
        return gameFinished;
    }
    
    public static void setGameFinished(boolean finished) {
        gameFinished = finished;
    }
    
    public static char[][] getBoard() {
        return board;
    }
    
    
}
