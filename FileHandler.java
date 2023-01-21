import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	
	public FileHandler(int pointsMax) {
		try {
		FileWriter myFileWriter = new FileWriter("Highscore.txt", true);
		myFileWriter.write("Score : "+pointsMax +"\n");
		myFileWriter.close();
		} catch (IOException e) {
			System.out.println("Error writing to file.");
			e.printStackTrace();
		}
	}
	public void FileReader() {
		try {
			File highscoreList = new File("Highscore.txt");
			Scanner scan = new Scanner(highscoreList);
			while (scan.hasNextLine()) {
				String list = scan.nextLine();
				System.out.println(list);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
