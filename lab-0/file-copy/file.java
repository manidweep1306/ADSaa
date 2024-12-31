import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class file{
	public static void copyFile(String sourceFilePath,String destFilePath){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(sourceFilePath);
			fos=new FileOutputStream(destFilePath);
			int byteData;
			while((byteData=fis.read())!=-1){
				fos.write(byteData);
			}
			System.out.println("File copied successfully");
		}catch(IOException e){
			System.out.println("An error occured");
		}finally{
			try{
				if(fis!=null)
					fis.close();
				if(fos!=null)
					fos.close();
			}catch(IOException e){
				System.out.println("Error closing streams:"+e.getMessage());
			}
		}
	}
	public static void main(String[] args){
		String sourceFilePath="source.txt";
		String destFilePath="destination.txt";
		copyFile(sourceFilePath,destFilePath);
	}
}

