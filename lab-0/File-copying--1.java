import java.io.*;
public class CopyFile{
	public static void main(String args[]){
		try(
			FileInputStream inputStream = new FileInputStream("file1.txt");
			FileOutputStream outputStream = new FileOutputStream("file2.txt");
		){
			int data;
			while((data = inputStream.read()) != -1){
				outputStream.write(data);
			}
		}
		catch(FileNotFoundException e){
			System.err.println("File not Found");
		}
		catch(IOException e){
			System.err.println(e);
		}
		System.out.println("Successfully Copied!");
	}
}
