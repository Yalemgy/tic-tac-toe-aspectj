package ticTacToeG;

public aspect RefereeAspect {

    before() : execution(void TicTacToeGameMain.player1Turn(java.util.Scanner)) || 
               execution(void TicTacToeGameMain.player2Turn(java.util.Scanner)) {
        
        TicTacToeGameMain mainInstance = new TicTacToeGameMain();
        char[][] board = TicTacToeGameMain.getBoard();
        
        if (ifPlayerWon(board, 'X')) {
            TicTacToeGameMain.displayBoard();
            System.out.println(TicTacToeGameMain.Player1 + " wins!");
            TicTacToeGameMain.setGameFinished(true);
        }
        
        if (ifPlayerWon(board, 'O')) {
            TicTacToeGameMain.displayBoard();
            System.out.println(TicTacToeGameMain.Player2 + " wins!");
            TicTacToeGameMain.setGameFinished(true);
        }
        
        if (isTie(board)) {
            TicTacToeGameMain.displayBoard();
            System.out.println("It is a tie!");
            TicTacToeGameMain.setGameFinished(true);
        }
    }

    public static boolean isTie(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean ifPlayerWon(char[][] board, char symbol) {
           if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
            (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
            (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
            (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
            (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
            (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
            (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }
}
