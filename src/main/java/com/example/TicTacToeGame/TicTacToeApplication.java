package com.example.TicTacToeGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {

		SpringApplication.run(TicTacToeApplication.class, args);

		//Display will return the user input and we use that in our switch
		switch (MenuDisplay())
		{
			//PlayGame
			case 1:
				TicTacToe gameplay = new TicTacToe();
				break;
			//QUITGAME
			default:
				System.out.println("GoodBye!");
		}
		//confirmQuit();
	} //COLSE MAIN METHOD

	public static int MenuDisplay(){

		Scanner inputNum = new Scanner(System.in);
		int selection = 0;

		System.out.println("Press 1 to play the game.");
		System.out.println("Press anything else to Quit");
		System.out.println("Your Selection : ");

		//attempt to store the user input as a Int
		try
		{
			selection = inputNum.nextInt();
			//if there's any problem, store it in the variable "e" and yell at user
		}
		catch (Exception e)
		{
			System.out.println("I asked for a number. No TicTacToe for you.");
		}

		//Close the function and return the user's selection
		return selection;
	}//close the displayMenu
}
