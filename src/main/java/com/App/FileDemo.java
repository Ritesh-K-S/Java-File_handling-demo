package com.App;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;

public class FileDemo {
     
	private static String UPLOAD_DIR=null;
	public static void main(String args[])
	{
		
		File file=null;
		
		try {
			
	    //Making a directory/directories path...
		UPLOAD_DIR=System.getProperty("user.dir")+File.separator+"FileDemo"+File.separator+"FileList";
		System.out.println("File Upload Directory is : "+UPLOAD_DIR);
		
		//file object is now pointing to the directory/directories path..
		file=new File(UPLOAD_DIR);
		System.out.println("Is Directory/Directories Exists : "+file.isDirectory());
		
		//checking if directory is existis or not...
		//if not exists then make directory..
		//directory can be made only if last folder is not exist, if multiple folder is not exists then it doesnot made directory..
		if(!file.isDirectory()) {
			boolean mkdir = file.mkdir();
			System.out.println("Is Directory Has Been Made : "+mkdir);
		}
		
		//making directories if multiple folder is not exists, (i.e), when we need to make multiple folder one inside other..
		if(!file.isDirectory()) {
			boolean mkdirs = file.mkdirs();
			System.out.println("Is Directories Has Been Made : "+mkdirs);
		}
		
		//making a file inside directory, after creation of directory..
		String fullFilePath=UPLOAD_DIR+File.separator+"test.txt";
		file=new File(fullFilePath);
		
		System.out.println("File Full Path : "+fullFilePath);
		System.out.println("Is File Exists : "+file.exists());
		
		//checking if file is exists or not..
		//if file is not exists then create a new file in that directory..
		if(!file.exists()) {
			boolean isFileCreated = file.createNewFile();
			System.out.println("Is File Created : "+isFileCreated);
		}
		
		
		
		
		/**Now exploring all other method of File class, after successfull creation of File...*/
		
		System.out.println("================File General Info====================");
		System.out.println("File Compare To : "+file.compareTo(new File("test")));
		System.out.println("file Name : "+file.getName());
		System.out.println("File Hashcode : "+file.hashCode());
		System.out.println("File Last Modified : "+new Date(file.lastModified()));
		
		
		//all method related to the check file is hidden , directory exists or not and file exists or not..
		System.out.println("================File Existence Info====================");
		System.out.println("File Is Exists : "+file.exists());
		System.out.println("File Is Direcotry : "+file.isDirectory());
		System.out.println("File Is Hidden : "+file.isHidden());
		
		
		//all method related to get absolute and canonical path in string and File format..
		System.out.println("================File And Path Info====================");
		System.out.println("File Is Absolute : "+file.isAbsolute());	
		System.out.println("File Is File : "+file.isFile());
		System.out.println("File Path : "+file.getPath());
		System.out.println("File Absolute Path : "+file.getAbsolutePath());      //return String..
		System.out.println("File Get Absolute File : "+file.getAbsoluteFile());
		System.out.println("File Canonical Path : "+file.getCanonicalPath());     //return File..
		System.out.println("File Get Canonical File : "+file.getCanonicalFile());
		System.out.println("File Parent : "+file.getParent());
		System.out.println("File Get Parent File : "+file.getParentFile());
		
		
		//all method related to the file space occupied and remaning and file size..
		System.out.println("================File Space Info====================");
		System.out.println("File Length : "+file.length());
		System.out.println("File Free Space : "+file.getFreeSpace());
		System.out.println("File Usable Space : "+file.getUsableSpace());
		System.out.println("File Total Space : "+file.getTotalSpace());
		
		
		//all method related to the File seperator and file path seperator..
		System.out.println("================File and Path Seperator Info====================");
		System.out.println("File Path Seperator : "+file.pathSeparator);
		System.out.println("File Path Seperator Char : "+file.pathSeparatorChar);
		System.out.println("File Seperator : "+file.separator);
		System.out.println("File Seperator Char : "+file.separatorChar);
		
		
		//all method related to check the access of execution, read and write in file...
		System.out.println("================File Access Permission Info====================");
		System.out.println("File Can Excute : "+file.canExecute());
		System.out.println("File Can Read : "+file.canRead());
		System.out.println("File Can Write : "+file.canWrite());
		
		
		//all method related to return the directory/file present inside the given directory... 
		System.out.println("================List of File inside File/Dir Info====================");
		File f=new File(UPLOAD_DIR);
		String [] fileListInString=f.list();
		File [] fileListInFile=f.listFiles();
		String [] fileListInStringJsonExt=f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File f, String name) {
				
				if(name.endsWith(".txt"))
				return false;
				else
				return true;
			}
		});
		File [] fileListInFileJsonExt=f.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File f, String name) {
				
				if(name.endsWith(".txt"))
				return false;
				else
				return true;
			}
		});
		
		System.out.println("All File List : ");
		for(String s: fileListInString) {
		System.out.println(s);
		}
		
		System.out.println();
		System.out.println("All File List Files : ");
		for(File f1:fileListInFile) {
		System.out.println(f1.toString());
		}
		
		System.out.println();
		System.out.println("File List Without txt : ");
		for(String s: fileListInStringJsonExt) {
			System.out.println(s);
			}
		
		System.out.println();
		System.out.println("File List Files Without txt : ");
		for(File f1:fileListInFileJsonExt) {
			System.out.println(f1.toString());
			}
		
		
		
		//all method related to modification of file(like renaming, modify access permission of read, write and excute..)
		//System.out.println(""+file.renameTo(file));
		//System.out.println(""+file.setExecutable(false));
		//System.out.println(""+file.setLastModified(0));
		//System.out.println(""+file.setReadable(false));
		//System.out.println(""+file.setWritable(false));
		
		
		//all method related to change the file object into different data type(like String, Path, URI, URL..) 
		System.out.println("================File Data Type Conversion====================");
		System.out.println("File To String : "+file.toString());
		System.out.println("Files To Path : "+file.toPath());
		System.out.println("File To URI : "+file.toURI());
		System.out.println("File To URL : "+file.toURL());
		
		
		//System.out.println(""+file.createTempFile(fullFilePath, fullFilePath));
		System.out.println("File List Roots : "+file.listRoots());
		
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
