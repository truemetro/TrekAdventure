/*
 * Tobias Morton
 * updated 5/26/20
 */
package game;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TrekAdventure
{
	private static String version = ("a-0.0.7");
	private static Scanner input = new Scanner(System.in);
	public static String playerName;
	public static int readSpeed = 250; //option for reading speed (in milliseconds per tick)

	public static void main(String[] args)
	{
		menu(); //calls the menu when program is run
	}
	
	//main menu
	public static void menu() {
	    String[] introARR = new String[4];
	    boolean exit = false;

	    introARR[0] = "\tPlay Game *";
	    introARR[1] = "\tControls";
	    introARR[2] = "\tOptions";
	    introARR[3] = "\tExit Game";

	    clear();
	    boolean printControls = false; //option for whether "Controls" option has been selected


	    while (!exit) //menu interaction loop
	    {
	    	
	    	printLogo(); //prints the star trek insignia
	    	
	    	System.out.println("\tWelcome to the Star Trek Adventure Game\n\tSTAG-" + version);
	      	if (printControls == true) { //prints controls if selected.
	    	  	System.out.println("\n\tCONTROLS:\n\tw, a, s, d, for selection");
	        	System.out.println("\n\tCommands that are always available:\n\n\t1.) go [direction] e.g. \"go north\"\n\n\t2.) look\n\n\t3.) check [object] or use [object] may be\n\t    available for specific objects.");
	      	}
	      	printControls = false; //sets printcontrols to false for next loop
	      	for (int i = 0; i < 10; i++)
	      	{
	    	  	System.out.println();
	      	}
	      	System.out.println("\tw, s, ENTER to navigate menu\n\n");
	      	System.out.println(introARR[0]); //
	      	System.out.println(introARR[1]); // Prints the menu options
	      	System.out.println(introARR[2]); //
	      	System.out.println(introARR[3]); //

	      	String doThis = input.nextLine();

	      	if (doThis.equals("w")&&introARR[0].equals("\tPlay Game *")) //this whole mess handles navigation of the menu options.
	      	{
	    	  	introARR[0] = "\tPlay Game";
	        	introARR[3] = "\tExit Game *";
	      	}
	      	else if (doThis.equals("s")&&introARR[0].equals("\tPlay Game *"))
	      	{
	    	  	introARR[0] = "\tPlay Game";
	        	introARR[1] = "\tControls *";
	      	}
	      	else if (doThis.equals("w")&&introARR[3].equals("\tExit Game *"))
	      	{
	    	  	introARR[3] = "\tExit Game";
	        	introARR[2] = "\tOptions *";
	      	}
	      	else if (doThis.equals("s")&&introARR[3].equals("\tExit Game *"))
	      	{
	    	  	introARR[0] = "\tPlay Game *";
	        	introARR[3] = "\tExit Game";
	      	}
	      	else if (doThis.equals("w")&&introARR[1].equals("\tControls *"))
	      	{
	    	  	introARR[1] = "\tControls";
	        	introARR[0] = "\tPlay Game *";
	      	}
	      	else if (doThis.equals("s")&&introARR[1].equals("\tControls *"))
	      	{
	    	  	introARR[1] = "\tControls";
	        	introARR[2] = "\tOptions *";
	      	}
	      	else if (doThis.equals("w")&&introARR[2].equals("\tOptions *"))
	      	{
	    	  	introARR[1] = "\tControls *";
	        	introARR[2] = "\tOptions";
	      	}
	      	else if (doThis.equals("s")&&introARR[2].equals("\tOptions *"))
	      	{
	        	introARR[2] = "\tOptions";
	        	introARR[3] = "\tExit Game *";
	      	}
	      	else if (doThis.equals("")&&introARR[3].equals("\tExit Game *")) //if the user selects the "Exit Game" option, the program terminates
	      	{
	      		for (int i = 0; i < 100; i++)
	      		{
	      			System.out.println();
	      		}
	        	exit = true;
	      	}
	      	else if (doThis.equals("")&&introARR[0].equals("\tPlay Game *")) //if Play Game is selected, this puts them in room 1
	      	{
	      		if(Rooms.firstr1) //if the user has never played, this asks them to enter a name.
	      		{
	      			clear();
	      			System.out.print("\tWhat's your name, cadet? >> ");
	      			playerName = input.nextLine();
	      		}
	    	  	exit = true;
	    	  	Rooms.inRoom = true;
	    	  	Rooms.r1();
	      	}
	      	else if(doThis.equals("")&&introARR[1].equals("\tControls *")) //displays list of controls if selected
	      	{
	    	  	printControls = true;
	      	}
	      	else if(doThis.equals("")&&introARR[2].equals("\tOptions *")) //starts the options menu loop and ends the main menu loop
	      	{
	      		exit = true;
	      		options();
	      	}

	      	clear();
	    }
	}
	
	public static void options() //the options menu accessed from the main menu
	{
		/*
		 * this menu and the "panel" method are built the same as the main menu, documentation for
		 * the main menu applies to both.
		 */
		
		String[] optionsARR = new String[2];
		String[] readingARR = new String[4];
		boolean exit = false;
		boolean subExit;
		
		optionsARR[0] = "\tReading Speed *";
		optionsARR[1] = "\tBack";
		
		readingARR[0] = "\t2 seconds *";
		readingARR[1] = "\t4 seconds";
		readingARR[2] = "\t6 seconds";
		readingARR[3] = "\tBack";
		
		while(!exit) //interaction loop
		{
			clear();
			
			printLogo();
	    	
	    	System.out.println("\tWelcome to the Star Trek Adventure Game\n\tSTAG-" + version);
	    	
	      	for (int i = 0; i < 10; i++)
	      	{
	    	  	System.out.println();
	      	}
	      	
	      	System.out.println("\tw, s, ENTER to navigate menu\n\n");
	      	
	      	System.out.println(optionsARR[0]);
	      	System.out.println(optionsARR[1]);

	      	String doThis = input.nextLine();

	      	if (doThis.equals("w")&&optionsARR[0].equals("\tReading Speed *") || doThis.equals("s")&&optionsARR[0].equals("\tReading Speed *"))
	      	{
	    	  	optionsARR[0] = "\tReading Speed";
	        	optionsARR[1] = "\tBack *";
	      	}
	      	else if (doThis.equals("s")&&optionsARR[1].equals("\tBack *") || doThis.equals("w")&&optionsARR[1].equals("\tBack *"))
	      	{
	    	  	optionsARR[0] = "\tReading Speed *";
	        	optionsARR[1] = "\tBack";
	      	}
	      	else if (doThis.equals("")&&optionsARR[1].equals("\tBack *"))
	      	{
	      		exit = true;
	      		menu();
	      	}
	      	else if (doThis.equals("")&&optionsARR[0].equals("\tReading Speed *"))
	      	{
	      		subExit = false;
	      		
	      		while(!subExit)
	      		{
	      			clear();
	      			printLogo();
	      			
	      			System.out.println("\tWelcome to the Star Trek Adventure Game\n\tSTAG-" + version);
	      			System.out.println("\n\tHow long would you like text to stay on the screen?");
	      			System.out.println("\tCurrently set to: " + (int)(readSpeed * .008) + " seconds.");
	      			
	    	      	for (int i = 0; i < 7; i++)
	    	      	{
	    	    	  	System.out.println();
	    	      	}
	    	      	
	    	      	System.out.println("\tw, s, ENTER to navigate menu\n\n");
	      			
	      			System.out.println(readingARR[0]);
	    	      	System.out.println(readingARR[1]);
	    	      	System.out.println(readingARR[2]);
	    	      	System.out.println(readingARR[3]);
	    	      	doThis = input.nextLine();
	      			
	      			if (doThis.equals("w")&&readingARR[0].equals("\t2 seconds *"))
			      	{
			    	  	readingARR[0] = "\t2 seconds";
			        	readingARR[3] = "\tBack *";
			      	}
			      	else if (doThis.equals("s")&&readingARR[0].equals("\t2 seconds *"))
			      	{
			    	  	readingARR[0] = "\t2 seconds";
			        	readingARR[1] = "\t4 seconds *";
			      	}
			      	else if (doThis.equals("w")&&readingARR[1].equals("\t4 seconds *"))
			      	{
			    	  	readingARR[0] = "\t2 seconds *";
			        	readingARR[1] = "\t4 seconds";
			      	}
			      	else if (doThis.equals("s")&&readingARR[1].equals("\t4 seconds *"))
			      	{
			        	readingARR[1] = "\t4 seconds";
			        	readingARR[2] = "\t6 seconds *";
			      	}
			      	else if (doThis.equals("w")&&readingARR[2].equals("\t6 seconds *"))
			      	{
			        	readingARR[1] = "\t4 seconds *";
			        	readingARR[2] = "\t6 seconds";
			      	}
			      	else if (doThis.equals("s")&&readingARR[2].equals("\t6 seconds *"))
			      	{
			        	readingARR[3] = "\tBack *";
			        	readingARR[2] = "\t6 seconds";
			      	}
			      	else if (doThis.equals("s")&&readingARR[3].equals("\tBack *"))
			      	{
			        	readingARR[0] = "\t2 seconds *";
			        	readingARR[3] = "\tBack";
			      	}
			      	else if (doThis.equals("w")&&readingARR[3].equals("\tBack *"))
			      	{
			        	readingARR[2] = "\t6 seconds *";
			        	readingARR[3] = "\tBack";
			      	}
			      	else if (doThis.equals("")&&readingARR[3].equals("\tBack *"))
			      	{
			        	subExit = true;
			      	}
			      	else if (doThis.equals("")&&readingARR[2].equals("\t6 seconds *"))
			      	{
			        	readSpeed = 750;
			      	}
			      	else if (doThis.equals("")&&readingARR[1].equals("\t4 seconds *"))
			      	{
			        	readSpeed = 500;
			      	}
			      	else if (doThis.equals("")&&readingARR[0].equals("\t2 seconds *"))
			      	{
			        	readSpeed = 250;
			      	}
	      		}
	      	}
		}
	}
	
	public static void panel() {
	    boolean checkMail = false;
	    boolean donePanel = false;
	    clear();
	    System.out.print("\tENTER NAME >> ");
	    String command = input.nextLine();
	    if(command.contentEquals(playerName)) //asks for player name and then animates
	    {
	    	clear();
	    	try
	    	{
	    		System.out.print("\tAUTHENTICATING.");
	    		TimeUnit.MILLISECONDS.sleep(250);
	    		clear();
	    		
	    		System.out.print("\tAUTHENTICATING. .");
	    		TimeUnit.MILLISECONDS.sleep(250);
	    		clear();
	    		
	    		System.out.print("\tAUTHENTICATING. . .");
	    		TimeUnit.MILLISECONDS.sleep(250);
	    	}
	    	catch (InterruptedException e)
	    	{
	    		
	    	}
	    	clear();

	  	    String[] panelARR = new String[2]; //this is all done the same as the main menu.

	  	    panelARR[0] = "\tCheck Mail *";
	  	    panelARR[1] = "\tDone";
	  	    
	  	    while (donePanel == false) {
	  	    	System.out.println("\tWelcome back " + playerName + ",\n\tWhat would you like to do?");
	  	      	if (checkMail == true) {
	  	    	  	System.out.println("\n\n" + Rooms.mail);
	  	    	  	Rooms.mail = "\tyou don't have any mail right now.";
	  	      	}
	  		    for(int i = 0; i < 5; i++) {
	  		    	System.out.println();
	  		    }

	  	      	System.out.println(panelARR[0]);
	  	      	System.out.println(panelARR[1]);

	  	      	command = input.nextLine();

	  	      	if (panelARR[0].equals("\tCheck Mail *") && command.equals("s") || panelARR[0].equals("\tCheck Mail *") && command.equals("w"))
	  	      	{
	  	    	  	panelARR[0] = "\tCheck Mail";
	  	        	panelARR[1] = "\tDone *";
	  	      	}
	  	      	else if (panelARR[1].equals("\tDone *") && command.equals("w") || panelARR[1].equals("\tDone *") && command.equals("s"))
	  	      	{
	  	    	  	panelARR[0] = "\tCheck Mail *";
	  	    	  	panelARR[1] = "\tDone";
	  	      	}
	  	      	else if (panelARR[1].equals("\tDone *") && command.equals(""))
	  	      	{
	  	    	  	donePanel = true;
	  	      	}
	  	      	else if (panelARR[0].equals("\tCheck Mail *") && command.equals(""))
	  	      	{
	  	    	  	checkMail = true;
	  	      	}
	  	      	clear();
	  	    }
	    }
	    else //if player fails to enter name correctly
	    {
	    	clear();
	    	try
	    	{
	    		System.out.print("\tAUTHENTICATING.");
	    		TimeUnit.MILLISECONDS.sleep(250);
	    		clear();
	    		
	    		System.out.print("\tAUTHENTICATING. .");
	    		TimeUnit.MILLISECONDS.sleep(250);
	    		clear();
	    		
	    		System.out.print("\tAUTHENTICATING. . .");
	    		TimeUnit.MILLISECONDS.sleep(250);
	    	}
	    	catch (InterruptedException e)
	    	{
	    		
	    	}
	    	
	    	textTimer("AUTHENTICATION FAILED", readSpeed);
	    	donePanel = true;
	    }
	}
	
	public static void clear() //method for clearing the screen. very useful.
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.println();
		}
	}
	
	public static void printLogo() //just prints the ASCII art so it's not using up inordinate amounts of lines.
	{
		// ASCII art from here : https://www.asciiart.eu/television/star-trek
    	System.out.println("\t               .");
    	System.out.println("\t              .:.");
    	System.out.println("\t             .:::.");
    	System.out.println("\t            .:::::.");
    	System.out.println("\t        ***.:::::::.***");
    	System.out.println("\t   *******.:::::::::.*******");
    	System.out.println("\t ********.:::::::::::.********");
    	System.out.println("\t********.:::::::::::::.********");
    	System.out.println("\t*******.::::::'***`::::.*******");
    	System.out.println("\t******.::::'*********`::.******");
    	System.out.println("\t ****.:::'*************`:.****");
    	System.out.println("\t   *.::'*****************`.*");
    	System.out.println("\t   .:'  ***************    .");
    	System.out.println("\t  .");
    	
    	System.out.println();
    	System.out.println();
	}
	
	
	/*
	 * method for stylized printing of text lines on a timer.
	 * the timing of each "tick" is affected by the readSpeed option.
	 */
	public static void textTimer(String print, int time)
	{
		clear();
		try
		{
			
			System.out.println("\t" + print + "\n\t========");
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
			
			System.out.println("\t" + print + "\n\t=======");
			
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
			System.out.println("\t" + print + "\n\t======");
			
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
			System.out.println("\t" + print + "\n\t=====");
			
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
			System.out.println("\t" + print + "\n\t====");
			
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
			System.out.println("\t" + print + "\n\t===");
			
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
			System.out.println("\t" + print + "\n\t==");
			
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
			System.out.println("\t" + print + "\n\t=");
			
			TimeUnit.MILLISECONDS.sleep(time);
			clear();
		}
		catch (InterruptedException e)
		{
			
		}
	}
}