/*
 * Tobias Morton
 * Updated 5/19/20
 * File reading tutorial: https://www.youtube.com/watch?time_continue=235&v=lHFlAYaNfdo&feature=emb_logo
 */

package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Saves {

	public static void main(String[] args) throws FileNotFoundException {
		File save = new File("C:\\Users\\truem\\git\\TrekAdventure\\TrekAdventure2.0\\src\\game\\Resources\\save.txt"); //TEMPORARY, path must be changed for release
		Scanner input = new Scanner(save);
		
		System.out.println(input.nextLine());
		System.out.println(input.nextLine());

	}

}
