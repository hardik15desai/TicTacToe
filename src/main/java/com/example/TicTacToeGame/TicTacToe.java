package com.example.TicTacToeGame;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TicTacToe {
    private char[] gameboard;
    private boolean myTurn = true;

    /**
     * The TicTacToe Constructor
     */
    public TicTacToe()
    {
        //instantiate the previous declared value
        gameboard = new char[9];
        final int RADIX = 10;

        for (int x = 0; x<gameboard.length; x++)
        {
            gameboard[x] = Character.forDigit(x,RADIX);
        }
        System.out.println("TicTacToe");

        while (!isFinished())
        {
            printBoard();
            yourTurn();
        }
        System.out.println("Game Over!!");
    }

    /**
     *  We'll check for lines of three of the same char (not a '-')
     *  @return
     */

    public boolean isFinished()
    {
        if(gameboard[0] ==  gameboard[1] && gameboard[1] ==  gameboard[2] ||
                gameboard[3] ==  gameboard[4] && gameboard[4] ==  gameboard[5] ||
                gameboard[6] ==  gameboard[7] && gameboard[7] ==  gameboard[8] ||
                gameboard[0] ==  gameboard[3] && gameboard[3] ==  gameboard[6] ||
                gameboard[1] ==  gameboard[4] && gameboard[4] ==  gameboard[7] ||
                gameboard[2] ==  gameboard[5] && gameboard[5] ==  gameboard[8] ||
                gameboard[0] ==  gameboard[4] && gameboard[4] ==  gameboard[8] ||
                gameboard[6] ==  gameboard[4] && gameboard[4] ==  gameboard[2])
        {
            bigWinner();
            return true;
        }
        for (int x = 0; x< gameboard.length ; x++)
        {
            if(gameboard[x] != 'O' &&  gameboard[x] != 'X');{
            return false;
        }
        }
        System.out.println("TIE GAME.");
        return  true;
    }
    public  void yourTurn(){

        Scanner s = new Scanner(System.in);
        int selection;
        while(true){
            try{
                System.out.print("At which position want to play: ");
                selection = s.nextInt();

                if(gameboard[selection] != 'X' && gameboard[selection] != 'O')
                {
                    gameboard[selection] = 'X';
                    break;
                }
                else
                {
                    System.out.println("This position already occupied");
                }
            }
            catch (Exception e)
            {
                System.out.println("Invalid selection. Please try again");
            }
        }
        if(!isFinished()){
            this.myTurn = !myTurn;
            ComputerTurn();
        }
    }
    public void bigWinner(){
        if(myTurn){
            System.out.println("Congraulations, You win the match!");
        }
        else
        {
            System.out.println("Opps, you lost the game!");
        }
    }

    /**
     * Computer select a random open slot and play its 'O'
     */

    public  void ComputerTurn()
    {
        System.out.println("Now it's the Computer player's turn");
        while(true)
        {
            //generate a random number between 0- 8
            int choice  = ThreadLocalRandom.current().nextInt(0,8);

            //isSpace Free?
            if (gameboard[choice] != 'X' && gameboard[choice] != 'O')
            {
                //if so, set equal to an 'O'
                gameboard[choice] = 'O';
                //bust out of this while loop
                this.myTurn = !myTurn;
                break;
            }
        }//close while loop
    }//closes computerTurn

    /**
     * Loop through the gameboard array and print current status
     */

    public  void  printBoard(){
        for (int x = 1;  x<=gameboard.length;x++)
        {
            System.out.print(" | " + gameboard[x-1]);
            if(x % 3 == 0 )
            {
                System.out.println(" |");
            }
        }
    }
}
