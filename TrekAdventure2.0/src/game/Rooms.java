//this class contains the "map" with each room and its specific attributes.
package game;

public class Rooms
{
	int[] navTable = new int[10];
	// navTable format {N, NE, E, SE, S, SW, W, NW, UP, DOWN}
	//idea credit: u/smcameron
	//https://www.reddit.com/r/gamedev/comments/13tilj/ways_of_implementing_the_map_in_text_based_game/
	
	//this method handles moving between rooms.
	public static void navigation()
	{
		
	}
	
	public static int[] makeTable(String navString)
	{
		
	}
	
	/* a room method, this has it's own attributes
	 * such as a unique response to commands like a
	 * "look" query. it also has a "navigation table" which
	 * will move the player to a specific room if the player
	 * goes in that direction.
	 */
	public static void r1()
	{//ctrdormroom		
		String navTableInit = "5, -1, 2, -1, 3, -1, 4, -1, -1, -1";
		makeTable(navTableInit);
	}
	
	public static void r5()
	{//ctrhallway
		
	}
}
