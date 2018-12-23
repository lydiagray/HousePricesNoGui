import java.sql.*;
import java.util.Scanner;

import org.sqlite.*;

public class Filepath {
	private String filepath;
	private boolean databaseLoaded = false;
	
	public Filepath() {}
	
	public void setFilepath(String _filepath) {
		filepath = _filepath;
	}
	
	public String getFilepath() {
		return filepath;
	}
	
	public boolean getDatabaseLoaded() {
		return databaseLoaded;
	}
	
	public void requestFilepath() {
		System.out.println("Enter the filepath for the database you want to use eg. C:/Documents/mydatabase");
		Scanner scanner = new Scanner(System.in);
		filepath = scanner.next();
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + filepath);
			databaseLoaded = true;
			System.out.println("It worked");
		}
		
		catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}
