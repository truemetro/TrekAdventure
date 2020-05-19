/*
 * Tobias Morton
 * updated 5/19/20
 */

//this class contains the "map" with each room and its specific attributes.
package game;

import java.util.Arrays;
import java.util.Scanner;

public class Rooms
{
	private static Scanner input = new Scanner(System.in);
	
	public static int[] navTable = new int[10];
	// navTable format {N, NE, E, SE, S, SW, W, NW, UP, DOWN}
	//idea credit: u/smcameron
	//https://www.reddit.com/r/gamedev/comments/13tilj/ways_of_implementing_the_map_in_text_based_game/
	
	private static int roomCode;
	
	//this method handles player typed commands.
	public static void commands(String look, boolean first)
	{
		String command = input.nextLine();
		command = command.toLowerCase();
		command += " ";
		firstConditions(roomCode);
		
		if (command.substring(0,command.indexOf(" ")).equals("go"))
		{
			if(command.equals("go north "))
			{
				roomList(0);
			}
			if(command.equals("go north east "))
			{
				roomList(1);
			}
			if(command.equals("go east "))
			{
				roomList(2);
			}
			if(command.equals("go south east "))
			{
				roomList(3);
			}
			if(command.equals("go south "))
			{
				roomList(4);
			}
			if(command.equals("go south west "))
			{
				roomList(5);
			}
			if(command.equals("go west "))
			{
				roomList(6);
			}
			if(command.equals("go north west "))
			{
				roomList(7);
			}
			if(command.equals("go up "))
			{
				roomList(8);
			}
			if(command.equals("go down "))
			{
				roomList(9);
			}
		}
		else if(command.substring(0,command.indexOf(" ")).equals("look"))
		{
			System.out.println(look);
		}
	}
	
	//this method turns the navTable initialization string into an array which can be referenced
	public static int[] makeTable(String navString)
	{
		int[] returnArray = new int[10];
		for (int i = 0; i < 10; i++)
		{
			returnArray[i] = Integer.parseInt(navString.substring(0, navString.indexOf(",")));
			navString = navString.substring(navString.indexOf(",") + 1, navString.length());
		}
		return returnArray;
	}
	
	//this will be used as a reference for the commands method to actually change which room method is running.
	public static void roomList(int selection)
	{
		if (navTable[selection] == -1)
		{
			System.out.println("you cant go that way");
		}
		else if (navTable[selection] == 1)
		{
			System.out.println("You wallk into your dorm room");
			r1();
		}
		else if (navTable[selection] == 5)
		{
			if (roomCode == 1)
				System.out.println("you walk into the hallway");
			else
				System.out.println("you walk down the hallway");
			r5();
		}
	}
	
	public static void firstConditions(int selection)
	{
		if (selection == 1)
		{
			firstr1 = false;
		}
	}
	
	
	//  ||||||	||||||	||||||	||\\__//||	||||||	\\
	//	||	||	||	||	||	||	|| \__/ ||	||		\\
	//	||||||	||	||	||	||	||		||	||||||	\\
	//	|| \\	||	||	||	||	||		||		||	\\
	//	||  \\	||||||	||||||	||		||	||||||	\\
	
	/* a room method, this has it's own attributes
	 * such as a unique response to commands like a
	 * "look" query. it also has a "navigation table" which
	 * will move the player to a specific room if the player
	 * goes in that direction.
	 */
	
	// navTable format {N, NE, E, SE, S, SW, W, NW, UP, DOWN}
	// Initialization template "-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,"
	
	/* boolean format which will be used when a room has a different set
	 * of options depending on whether the player has visited them or not:
	 * "first(room number)"
	 */
	
	private static boolean noFirstCondition;
	
	private static boolean firstr1 = true;
	public static void r1()
	{//ctrdormroom
		roomCode = 1;
		if (firstr1)
		{
			System.out.println("test");
		}
		String navTableInit = "5,-1,2,-1,3,-1,4,-1,-1,-1,";
		String look = "You're in your dorm room,";
		navTable = makeTable(navTableInit);
		commands(look, firstr1);
	}
	
	public static void r5()
	{//ctrhallway
		roomCode = 5;
		String navTableInit = "-1,-1,-1,-1,1,-1,-1,-1,-1,-1,"; //NOT FINAL REMEMBER TO CHANGE
		String look = "";
		navTable = makeTable(navTableInit);
		commands(look, noFirstCondition);
	}
}
