/*
 * Tobias Morton
 * updated 4/26/20
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
	
	//this method handles player typed commands.
	public static void commands()
	{
		String command = input.nextLine();
		command = command.toLowerCase();
		
		if (command.substring(0,command.indexOf(" ")).equals("go"))
		{
			if(command.substring(command.indexOf(" "), command.length()).equals("north"))
			{
				roomList(0);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("north east"))
			{
				roomList(1);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("east"))
			{
				roomList(2);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("south east"))
			{
				roomList(3);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("south"))
			{
				roomList(4);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("south west"))
			{
				roomList(5);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("west"))
			{
				roomList(6);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("north west"))
			{
				roomList(7);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("up"))
			{
				roomList(8);
			}
			if(command.substring(command.indexOf(" "), command.length()).equals("down"))
			{
				roomList(9);
			}
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
			r1();
		}
		else if (navTable[selection] == 5)
		{
			r5();
		}
	}
	
	
	//  ||||||	||||||	||||||	||\\__//||	||||||	//
	//	||	||	||	||	||	||	|| \__/ ||	||		//
	//	||||||	||	||	||	||	||		||	||||||	//
	//	||\\	||	||	||	||	||		||		||	//
	//	||  \\	||||||	||||||	||		||	||||||	//
	
	/* a room method, this has it's own attributes
	 * such as a unique response to commands like a
	 * "look" query. it also has a "navigation table" which
	 * will move the player to a specific room if the player
	 * goes in that direction.
	 */
	public static void r1()
	{//ctrdormroom		
		String navTableInit = "5,-1,2,-1,3,-1,4,-1,-1,-1,";
		navTable = makeTable(navTableInit);
	}
	
	public static void r5()
	{//ctrhallway
		String navTableInit = "-1,";
		navTable = makeTable(navTableInit);
		
	}
}
