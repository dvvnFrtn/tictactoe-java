import java.io.IOException;
import java.util.Scanner;


public class tictactoe {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        char[][] board = new char[3][3];
        char player = 'X';
        String result = "";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }

        while (hasEmptySpot(board) && !hasWinner(board)) {
            
            displayBoard(board);
            //mengantisipasi input user yang tidak sesuai
            try {
                readInput(board,player);
            } catch (Exception e) {
                clrscr();
                System.out.println("Masukkan baris dan kolom dengan benar ! (1-3)");
                continue;
            }
            //menentukan hasil
            if (hasWinner(board)) {
                result += "~ Player " + player + " memenangkan permaianan ~";
            } else if(!hasEmptySpot(board)) {
                result += "~~ Permainan berakhir imbang ~~";
            }
            //ganti player
            if (player == 'O') player = 'X';
            else player = 'O';
            
            clrscr();
        }

        //hasil akhir
        displayBoard(board);
        System.out.println("\n"+result);
        
    }

    /**
     * Method untuk membaca input dari user.
     */
    private static void readInput(char[][] board,char player) {
        System.out.println("Giliran player "+player+" ,Masukkan baris dan kolom !");
        System.out.print("baris : ");
        int row = in.nextInt();
        System.out.print("kolom : ");
        int col = in.nextInt();
        if (board[row-1][col-1] == ' '){ //kondisi ketika tempat belum diisi
            board[row-1][col-1] = player;
        } else { //kondisi ketika tempat telah diisi
            clrscr();
            System.out.println("Tempat telah terisi !");
            displayBoard(board);
            readInput(board, player);
        }
    }

    /**
     * Method untuk mengecek adanya tempat yang kosong.
     * @return true apabila terdapat ' ' pada array.
     */
    private static Boolean hasEmptySpot(char[][] board){
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method untuk mengecek adanya pemenang.
     * @return true apabila terdapat salah satu pemenenang.
     */
    private static Boolean hasWinner(char[][] board){
        return (board[0][0] == board [0][1] && board[0][0] == board [0][2] && board[0][0]!=' ') ||
            (board[0][0] == board [1][1] && board[0][0] == board [2][2] && board[0][0]!=' ') ||
            (board[0][0] == board [1][0] && board[0][0] == board [2][0] && board[0][0]!=' ') ||
            (board[2][0] == board [2][1] && board[2][0] == board [2][2] && board[2][0]!=' ') ||
            (board[2][0] == board [1][1] && board[0][0] == board [0][2] && board[2][0]!=' ') ||
            (board[0][2] == board [1][2] && board[0][2] == board [2][2] && board[0][2]!=' ') ||
            (board[0][1] == board [1][1] && board[0][1] == board [2][1] && board[0][1]!=' ') ||
            (board[1][0] == board [1][1] && board[1][0] == board [1][2] && board[1][0]!=' ');
    }

    /**
     * Method untuk menampilkan permainan.
     */
    private static void displayBoard(char[][] arr) {
        System.out.println("******************************");
        System.out.println( "*         *         *        *");
        System.out.println( "*    "+arr[0][0]+"    *    "+arr[0][1]+"    *    "+arr[0][2]+"   *");
        System.out.println( "*         *         *        *");
        System.out.println("******************************");
        System.out.println( "*         *         *        *");
        System.out.println( "*    "+arr[1][0]+"    *    "+arr[1][1]+"    *    "+arr[1][2]+"   *");
        System.out.println( "*         *         *        *");
        System.out.println("******************************");
        System.out.println( "*         *         *        *");
        System.out.println( "*    "+arr[2][0]+"    *    "+arr[2][1]+"    *    "+arr[2][2]+"   *");
        System.out.println( "*         *         *        *");
        System.out.println("******************************");
    }

    /**
     * Method untuk merefresh console.
     */
    private static void clrscr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
