/*
 * Tobias Morton
 * updated 5/26/20
 */
package game;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TrekAdventure
{
	private static String version = ("a-0.0.6");
	private static Scanner input = new Scanner(System.in);
	static String playerName;

	public static void main(String[] args)
	{
		menu();
	}
	
	//main menu
	public static void menu() {
	    String[] introARR = new String[4];
	    boolean exit = false;

	    introARR[0] = "\tPlay Game *";
	    introARR[1] = "\tControls";
	    introARR[2] = "\tOptions";
	    introARR[3] = "\tExit Game";

	    for (int i = 0; i < 100; i++)
	    {
	      System.out.println();
	    }
	    boolean printControls = false;


	    while (exit==false)
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
	    	
	    	System.out.println("\tWelcome to the Star Trek Adventure Game\n\tSTAG-" + version);
	      	if (printControls == true) {
	    	  	System.out.println("\n\tCONTROLS:\n\tw, a, s, d, for selection");
	        	System.out.println("\n\tCommands that are always available:\n\n\t1.) go [direction] e.g. \"go north\"\n\n\t2.) look\n\n\t3.) check [object] or use [object] may be\n\t    available for specific objects.");
	      	}
	      	printControls = false;
	      	for (int i = 0; i < 10; i++)
	      	{
	    	  	System.out.println();
	      	}
	      	System.out.println("\tw, s, ENTER to navigate menu\n\n");
	      	System.out.println(introARR[0]);
	      	System.out.println(introARR[1]);
	      	System.out.println(introARR[2]);
	      	System.out.println(introARR[3]);

	      	String doThis = input.nextLine();

	      	if (doThis.equals("w")&&introARR[0].equals("\tPlay Game *"))
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
	      	else if (doThis.equals("")&&introARR[3].equals("\tExit Game *"))
	      	{
	      		for (int i = 0; i < 100; i++)
	      		{
	      			System.out.println();
	      		}
	        	exit = true;
	      	}
	      	else if (doThis.equals("")&&introARR[0].equals("\tPlay Game *"))
	      	{
	      		if(Rooms.firstr1)
	      		{
	      			clear();
	      			System.out.print("\tWhat's your name, cadet? >> ");
	      			playerName = input.nextLine();
	      		}
	    	  	exit = true;
	    	  	Rooms.inRoom = true;
	    	  	Rooms.r1();
	      	}
	      	else if(doThis.equals("")&&introARR[1].equals("\tControls *"))
	      	{
	    	  	printControls = true;
	      	}
	      	else if(doThis.equals("")&&introARR[2].equals("\tOptions *"))
	      	{
	      		exit = true;
	      		options();
	      	}

	      	clear();
	    }
	}
	
	public static void options()
	{
		String[] optionsARR = new String[2];
		boolean exit = false;
		
		optionsARR[0] = "\tReading Speed *";
		optionsARR[1] = "\tBack";
		
		while(!exit)
		{
			clear(); 
			
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
	    	
	    	System.out.println("\tWelcome to the Star Trek Adventure Game\n\tSTAG-" + version);
	    	
	      	for (int i = 0; i < 10; i++)
	      	{
	    	  	System.out.println();
	      	}
	      	
	      	System.out.println("\tw, s, ENTER to navigate menu\n\n");
	      	
	      	System.out.println(optionsARR[0]);
	      	System.out.println(optionsARR[1]);

	      	String doThis = input.nextLine();

	      	if (doThis.equals("w")&&optionsARR[0].equals("\tReading Speed *"))
	      	{
	    	  	optionsARR[0] = "\tReading Speed";
	        	optionsARR[1] = "\tBack *";
	      	}
	      	else if (doThis.equals("s")&&optionsARR[0].equals("\tReading Speed *"))
	      	{
	    	  	optionsARR[0] = "\tReading Speed";
	        	optionsARR[1] = "\tBack *";
	      	}
	      	else if (doThis.equals("s")&&optionsARR[1].equals("\tBack *"))
	      	{
	    	  	optionsARR[0] = "\tReading Speed *";
	        	optionsARR[1] = "\tBack";
	      	}
	      	else if (doThis.equals("w")&&optionsARR[1].equals("\tBack *"))
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
	      		
	      	}
		}
	}
	
	public static void panel() {
	    boolean checkMail = false;
	    boolean donePanel = false;
	    clear();
	    System.out.print("\tENTER NAME >> ");
	    String command = input.nextLine();
	    if(command.contentEquals(playerName))
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

	  	    String[] panelARR = new String[2];

	  	    panelARR[0] = "\tCheck Mail *";
	  	    panelARR[1] = "\tDone";
	  	    
	  	    while (donePanel == false) {
	  	    	System.out.println("\tWelcome back " + playerName + ",\n\tWhat would you like to do?");
	  	      	if (checkMail == true) {
	  	    	  	System.out.println("\n\n" + Rooms.mail);
	  	      	}
	  		    for(int i = 0; i < 5; i++) {
	  		    	System.out.println();
	  		    }

	  	      	System.out.println(panelARR[0]);
	  	      	System.out.println(panelARR[1]);

	  	      	command = input.nextLine();

	  	      	if (panelARR[0].equals("\tCheck Mail *") && command.equals("s"))
	  	      	{
	  	    	  	panelARR[0] = "\tCheck Mail";
	  	        	panelARR[1] = "\tDone *";
	  	      	}
	  	      	else if (panelARR[0].equals("\tCheck Mail *") && command.equals("w"))
	  	      	{
	  	    	  	panelARR[0] = "\tCheck Mail";
	  	        	panelARR[1] = "\tDone *";
	  	      	}
	  	      	else if (panelARR[1].equals("\tDone *") && command.equals("w"))
	  	      	{
	  	    	  	panelARR[0] = "\tCheck Mail *";
	  	    	  	panelARR[1] = "\tDone";
	  	      	}
	  	      	else if (panelARR[1].equals("\tDone *") && command.equals("s"))
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
	    else
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
	    	
	    	textTimer("AUTHENTICATION FAILED", 250);
	    	donePanel = true;
	    }
	}
	
	public static void clear()
	{
		for(int i = 0; i < 100; i++)
		{
			System.out.println();
		}
	}
	
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