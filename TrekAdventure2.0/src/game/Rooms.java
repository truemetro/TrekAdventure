/*
 * Tobias Morton
 * updated 5/26/20
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
	
	private static int roomCode; //used for determining the player's location in the "commands" method
	static boolean inRoom = true; //condition for the interaction loop
	static String mail = "\tyou don't have any mail right now."; //mail string accessed in the "panel" menu
	
	//this method handles player typed commands.
	public static void commands(String look, int lookLines, boolean first)
	{
		TrekAdventure.clear();
		
		System.out.print("\tTYPE COMMAND>> ");
		
		String command = input.nextLine(); //gets input
		
		command = command.toLowerCase(); //sets the entered string to lower case to avoid errors
		
		command += " "; //adds a space to the end of the line, which is used to find the end of the actual command
						//for example the command "look" will be caught both if the player enters "look" or "look around"
						//because in both cases the string from 0 to the first space is "look"
		
		firstConditions(roomCode); //sets first visit condition to false
		
		if (command.substring(0,command.indexOf(" ")).equals("go")) //navigation command e.g. "go north"
		{
			if(command.equals("go north "))
			{
				roomList(0, command); //calls the room list and checks which room is "north" from the player's current location
			}
			if(command.equals("go north east "))
			{
				roomList(1, command);
			}
			if(command.equals("go east "))
			{
				roomList(2, command);
			}
			if(command.equals("go south east "))
			{
				roomList(3, command);
			}
			if(command.equals("go south "))
			{
				roomList(4, command);
			}
			if(command.equals("go south west "))
			{
				roomList(5, command);
			}
			if(command.equals("go west "))
			{
				roomList(6, command);
			}
			if(command.equals("go north west "))
			{
				roomList(7, command);
			}
			if(command.equals("go up "))
			{
				roomList(8, command);
			}
			if(command.equals("go down "))
			{
				roomList(9, command);
			}
		}
		
		else if(command.substring(0,command.indexOf(" ")).equals("look")) //look commands, prints a description of the room which is defined for each room.
		{
			TrekAdventure.textTimer(look, TrekAdventure.readSpeed*lookLines);
		}
		
		else if(command.equals("exit ")) //returns to the menu
		{
			inRoom = false;
			TrekAdventure.menu();
		}
		
		else //if none of the above commands are entered, this checks to see if it was a room-specific command.
		{
			roomCommands(command);
		}
		
	}
	
	//for non-standard or room specific commands
	public static void roomCommands(String command)
	{
		if (roomCode == 1)
		{
			if (command.equals("check panel "))
			{
				TrekAdventure.textTimer("The panel asks for a name and handprint", TrekAdventure.readSpeed);
				TrekAdventure.panel();
			}
			else
			{
				TrekAdventure.textTimer("COMMAND NOT FOUND", TrekAdventure.readSpeed);
			}
		}
		else
		{
			TrekAdventure.textTimer("COMMAND NOT FOUND", TrekAdventure.readSpeed);
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
	public static void roomList(int selection, String command)
	{
		if (navTable[selection] == -1)
		{
			TrekAdventure.textTimer("You cant go that way", TrekAdventure.readSpeed);
		}
		else if (navTable[selection] == 1)
		{
			if (roomCode == 7)
			{
				TrekAdventure.textTimer("You walk into your dorm room", TrekAdventure.readSpeed);
			}
			else
			{
				
				TrekAdventure.textTimer("You walk" + command.substring(command.indexOf(" "), command.length()), TrekAdventure.readSpeed);
			}
			r1();
		}
		else if (navTable[selection] == 2)
		{
			TrekAdventure.textTimer("You walk" + command.substring(command.indexOf(" "), command.length()), TrekAdventure.readSpeed);
			r2();
		}
		else if (navTable[selection] == 3)
		{
			TrekAdventure.textTimer("You walk" + command.substring(command.indexOf(" "), command.length()), TrekAdventure.readSpeed);
			r3();
		}
		else if (navTable[selection] == 4)
		{
			TrekAdventure.textTimer("You walk" + command.substring(command.indexOf(" "), command.length()), TrekAdventure.readSpeed);
			r4();
		}
		else if (navTable[selection] == 5)
		{
			TrekAdventure.textTimer("You walk" + command.substring(command.indexOf(" "), command.length()), TrekAdventure.readSpeed);
			r5();
		}
		else if (navTable[selection] == 6)
		{
			TrekAdventure.textTimer("You walk" + command.substring(command.indexOf(" "), command.length()), TrekAdventure.readSpeed);
			r6();
		}
		else if (navTable[selection] == 7)
		{
			if (roomCode == 1)
				TrekAdventure.textTimer("You walk into the hallway", TrekAdventure.readSpeed);
			else
				TrekAdventure.textTimer("You walk" + command.substring(command.indexOf(" "), command.length()) + "down the hallway", TrekAdventure.readSpeed);
			r7();
		}
		else if (navTable[selection] == 8)
		{
			TrekAdventure.textTimer("You walk east down the hallway", TrekAdventure.readSpeed);
			r8();
		}
		else if (navTable[selection] == 9)
		{
			TrekAdventure.textTimer("As you go to walk west down the hallway,", TrekAdventure.readSpeed);
			TrekAdventure.textTimer("You realize that there's no hallway afterall.", TrekAdventure.readSpeed);
			TrekAdventure.textTimer("You find yourself floating in a void of spaghetti-code.", TrekAdventure.readSpeed);
			TrekAdventure.textTimer("it seems the programmer failed to complete the universe.", TrekAdventure.readSpeed);
			TrekAdventure.textTimer("So that's unfortunate.", TrekAdventure.readSpeed);
			inRoom = false;
			TrekAdventure.menu();
		}
	}
	
	//sets first visit conditions
	public static void firstConditions(int selection)
	{
		if (selection == 1)
		{
			firstr1 = false;
		}
		else if (selection == 7)
		{
			firstr7 = false;
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
	
	/* boolean condition which will be used when a room has a different set
	 * of options depending on whether the player has visited them or not:
	 * "private static boolean first(room number)"
	 */
	
	private static boolean noFirstCondition; //if no first condition exists, this will be passed to the "commands" method instead
	
	public static boolean firstr1 = true;
	private static boolean checkedMail = false;
	public static void r1()
	{//ctrdormroom
		int lookLines;
		roomCode = 1;
		String look = "You're in your dorm room.\n\tto the north is the door\n\tto the east is your bunk.\n\tto the west is a window looking\n\tout at Golden Gate park.\n\tto the south is your replicator.\n\tThere's a notification flashing\n\ton the door comms panel.";
		lookLines = 5;
		String navTableInit = "7,-1,2,3,4,5,6,-1,-1,-1,";
		navTable = makeTable(navTableInit);
		TrekAdventure.clear();
		
		if (firstr1)
		{
			mail = "\tFrom: Cpt. Cromwell\n\tCongratulations " + TrekAdventure.playerName + ", you made it through the academy!\n\tI'm an old friend of Mr. Lansing and he sung your praises.\n\tI trust his judgement, so I asked for you to be assigned to the Opportunity.\n\tI heard you were already aiming for this assignment, so I hope this makes your day.\n\tGo have a word with Admiral Jennings for more info.";
			TrekAdventure.textTimer("you're in your dorm room at Starfleet academy.", TrekAdventure.readSpeed);
			TrekAdventure.textTimer("It's Saturday, yesterday was graduation.", TrekAdventure.readSpeed);
			TrekAdventure.textTimer("There's a notification on the door comms panel.", TrekAdventure.readSpeed);
		}
		else
		{
			if(checkedMail)
			{
				look = "You're in your dorm room.\n\tto the north is the door\n\tto the east is your bunk.\n\tto the west is a window looking\n\tout at Golden Gate park.\n\tto the south is your replicator.";
				lookLines = 4;
			}
		}
		
		while(inRoom)
		{
			commands(look, lookLines, firstr1);
		}
	}
	
	public static void r2()
	{//eastdormroom
		roomCode = 2;
		int lookLines;
		String look;
		String navTableInit = "-1,-1,-1,-1,3,4,1,-1,-1,-1,";
		navTable = makeTable(navTableInit);
		
		if (checkedMail)
		{
			lookLines = 4;
			look = "You're in the east side of your dorm room\n\tnext to your bunk.\n\tto the north and east are walls.\n\tacross the room to the west is a window.";
		}
		else
		{
			lookLines = 5;
			look = "You're in the east side of your dorm room\n\tnext to your bunk.\n\tto the north and east are walls.\n\tacross the room to the west is a window.\n\tthere's a notification flashing on the door comms panel.";
		}
		
		while(inRoom)
		{
			commands(look, lookLines, noFirstCondition);
		}
	}
	
	public static void r3()
	{//southeastdormroom
		roomCode = 3;
		int lookLines;
		String look;
		String navTableInit = "2,-1,-1,-1,-1,-1,4,1,-1,-1,";
		navTable = makeTable(navTableInit);
		
		if (checkedMail)
		{
			lookLines = 3;
			look = "You're in the south east corner of your dorm room\n\tto the south and east are walls.\n\tacross the room to the west is a window.\n\tyou wonder why you're standing in a corner";
		}
		else
		{
			lookLines = 4;
			look = "You're in the south east corner of your dorm room\n\tto the south and east are walls.\n\tacross the room to the west is a window.\n\tyou wonder why you're standing in a corner\n\tthere's a notification flashing on the door comms panel.";
		}
		
		while(inRoom)
		{
			commands(look, lookLines, noFirstCondition);
		}
	}
	
	public static void r4()
	{//southdormroom
		roomCode = 4;
		int lookLines;
		String look;
		String navTableInit = "1,2,3,-1,-1,-1,5,6,-1,-1,";
		navTable = makeTable(navTableInit);
		
		if (checkedMail)
		{
			lookLines = 5;
			look = "You're in the south side of your dorm room\n\ton the wall are your replicator and a shelf with a fishtank\n\tand a model of the Enterprise\n\tto the south is a wall.\n\tacross the room to the north is the door.";
		}
		else
		{
			lookLines = 5;
			look = "You're in the south side of your dorm room\n\ton the wall are your replicator and a shelf with a fishtank\n\tand a model of the Enterprise\n\tto the south is a wall.\n\tacross the room to the north is the door.\n\tthere's a notification flashing on the door comms panel.";
		}
		
		while(inRoom)
		{
			commands(look, lookLines, noFirstCondition);
		}
	}
	
	public static void r5()
	{//southwestdormroom
		roomCode = 5;
		int lookLines;
		String look;
		String navTableInit = "6,1,4,-1,-1,-1,-1,-1,-1,-1,";
		navTable = makeTable(navTableInit);
		
		if (checkedMail)
		{
			lookLines = 4;
			look = "You're in the south west corner of your dorm room\n\there's some dust.\n\tto the west and south are walls.\n\tacross the room to the north east is the door.\n\tyou're not sure why you're here";
		}
		else
		{
			lookLines = 5;
			look = "You're in the south west corner of your dorm room\n\there's some dust.\n\tto the west and south are walls.\n\tacross the room to the north east is the door.\n\tyou're not sure why you're here\n\tthere's a notification flashing on the door comms panel.";
		}
		
		while(inRoom)
		{
			commands(look, lookLines, noFirstCondition);
		}
	}
	
	public static void r6()
	{//southwestdormroom
		roomCode = 6;
		int lookLines;
		String look;
		String navTableInit = "-1,-1,1,4,5,-1,-1,-1,-1,-1,";
		navTable = makeTable(navTableInit);
		
		if (checkedMail)
		{
			lookLines = 4;
			look = "You're in the west side of your dorm room\n\tnext to the window.\n\tto the west you can see a great view of\n\tGolden Gate park through the window\n\tacross the room to the east is a your bunk.";
		}
		else
		{
			lookLines = 5;
			look = "You're in the west side of your dorm room\n\tnext to the window.\n\tto the west you can see a great view of\n\tGolden Gate park through the window\n\tacross the room to the east is a your bunk.\n\tthere's a notification flashing on the door comms panel.";
		}
		
		while(inRoom)
		{
			commands(look, lookLines, noFirstCondition);
		}
	}
	
	public static boolean firstr7 = true;
	public static void r7()
	{//ctrhallway
		roomCode = 7;
		String look;
		String navTableInit = "-1,-1,8,-1,1,-1,9,-1,-1,-1,";
		navTable = makeTable(navTableInit);
		
		if(firstr7)
		{
			TrekAdventure.textTimer("As you exit your room the annunciator blares \"RED ALERT\"", TrekAdventure.readSpeed);
			look = "You're in the hallway outside your dorm room.\n\tit extends to the east and west.\n\tto the west is the turbolift.\n\tred lights flash along the walkway\n\tas the red alert siren echoes around you.";
		}
		else
		{
			look = "You're in the hallway outside your dorm room.\n\tit extends to the east and west.\n\tto the west is the turbolift.";
		}
		
		while(inRoom)
		{
			commands(look, 3, firstr7);
		}
	}
	public static void r8()
	{//easthallway
		roomCode = 8;
		String navTableInit = "-1,-1,-1,-1,-1,-1,7,-1,-1,-1,";
		navTable = makeTable(navTableInit);
		String look = "You're in the east end of the dormatory hallway.\n\tthere's a window in front of you looking to the east,\n\tyou can see the campus from here.";
		
		while(inRoom)
		{
			commands(look, 3, noFirstCondition);
		}
	}
}
