/*
 * Tobias Morton
 * updated 5/20/20
 */
package game;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TrekAdventure
{
	private static String version = ("a-0.0.5");
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args)
	{
		menu();
	}
	
	//main menu
	public static void menu() {
	    String[] introARR = new String[3];
	    boolean exit = false;

	    introARR[0] = "\tPlay Game *";
	    introARR[1] = "\tControls";
	    introARR[2] = "\tExit Game";

	    for (int i = 0; i < 100; i++)
	    {
	      System.out.println();
	    }
	    boolean printControls = false;


	    while (exit==false)
	    {
	    	System.out.println("\tWelcome to the Star Trek Adventure Game\n\tSTAG-" + version);
	      	if (printControls == true) {
	    	  	System.out.println("\n\tCONTROLS:\n\tw, a, s, d, for selection");
	        	System.out.println("\n\tCommands that are always available:\n\n\t1.) go [direction] e.g. \"go north\"\n\n\t2.) look\n\n\tthere may be some other commands depending\n\ton the situation.");
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

	      	String doThis = input.nextLine();

	      	if (doThis.equals("w")&&introARR[0].equals("\tPlay Game *"))
	      	{
	    	  	introARR[0] = "\tPlay Game";
	        	introARR[2] = "\tExit Game *";
	      	}
	      	else if (doThis.equals("s")&&introARR[0].equals("\tPlay Game *"))
	      	{
	    	  	introARR[0] = "\tPlay Game";
	        	introARR[1] = "\tControls *";
	      	}
	      	else if (doThis.equals("w")&&introARR[2].equals("\tExit Game *"))
	      	{
	    	  	introARR[2] = "\tExit Game";
	        	introARR[1] = "\tControls *";
	      	}
	      	else if (doThis.equals("s")&&introARR[2].equals("\tExit Game *"))
	      	{
	    	  	introARR[0] = "\tPlay Game *";
	        	introARR[2] = "\tExit Game";
	      	}
	      	else if (doThis.equals("w")&&introARR[1].equals("\tControls *"))
	      	{
	    	  	introARR[1] = "\tControls";
	        	introARR[0] = "\tPlay Game *";
	      	}
	      	else if (doThis.equals("s")&&introARR[1].equals("\tControls *"))
	      	{
	    	  	introARR[1] = "\tControls";
	        	introARR[2] = "\tExit Game *";
	      	}
	      	else if (doThis.equals("")&&introARR[2].equals("\tExit Game *"))
	      	{
	      		for (int i = 0; i < 100; i++)
	      		{
	      			System.out.println();
	      		}
	        	exit = true;
	      	}
	      	else if (doThis.equals("")&&introARR[0].equals("\tPlay Game *"))
	      	{
	    	  	exit = true;
	    	  	Rooms.r1();
	      	}
	      	else if(doThis.equals("")&&introARR[1].equals("\tControls *"))
	      	{
	    	  	printControls = true;
	      	}

	      	for (int i = 0; i < 100; i++)
	      	{
	      		System.out.println();
	      	}
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
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			
			System.out.println("\t" + print + "\n\t=======");
			
			TimeUnit.MILLISECONDS.sleep(time);
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			
			System.out.println("\t" + print + "\n\t======");
			
			TimeUnit.MILLISECONDS.sleep(time);
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			System.out.println("\t" + print + "\n\t=====");
			
			TimeUnit.MILLISECONDS.sleep(time);
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			System.out.println("\t" + print + "\n\t====");
			
			TimeUnit.MILLISECONDS.sleep(time);
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			System.out.println("\t" + print + "\n\t===");
			
			TimeUnit.MILLISECONDS.sleep(time);
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			System.out.println("\t" + print + "\n\t==");
			
			TimeUnit.MILLISECONDS.sleep(time);
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
			System.out.println("\t" + print + "\n\t=");
			
			TimeUnit.MILLISECONDS.sleep(time);
			for(int i = 0; i < 100; i++) {
				System.out.println();
			}
		}
		catch (InterruptedException e)
		{
			
		}
	}
}