package geekfor.geeks;

import java.io.File;

public class FileUtil {

	private static final String folderPath = "L:\\Ashu\\Multimedia\\Movies\\hollywood";
//	private static final String folderPath = "L:\\Ashu\\Multimedia\\Movies\\temp";
	
	public static void main(String[] args) {
		
		File file = new File(folderPath);
		File[] movieNames = file.listFiles();
		
		for (File movieFile : movieNames) {
			String currentName = movieFile.getName();

			if(movieFile.isFile()){
				String formattedName = formateYear(currentName);
				File renamedFile = new File(folderPath+"\\"+formattedName);
				movieFile.renameTo(renamedFile);
			}
		}

	}
	
	static String formateYear(String name){
		
		String formattedName = name;
		formattedName = formattedName.replaceAll("()", "");
//		formattedName = formattedName.replaceAll("[]", "");
		
		System.out.println(formattedName+"\n-------------------");
		return formattedName;
		
	}
	
	/*static String formateYear(String name){
		System.out.println(name);
		String year = "";
		for (int i = 0; i < name.length(); i++) {
			String tempYear = "";
			int l = 0;
			while(i<name.length() && Character.isDigit(name.charAt(i))){
				tempYear += ""+name.charAt(i);
				i++;
				l++;
			}
			if(l==4){
				year = tempYear;
			}
		}
		String formattedName = name;
		formattedName = formattedName.replace(year, "");
		formattedName = formattedName.replaceAll("0", "o");
		formattedName = formattedName.replaceAll("1", "i");
		formattedName = formattedName.replaceAll("2", "a");
		formattedName = formattedName.replaceAll("3", "e");
		formattedName = formattedName.replaceAll("4", "u");
		formattedName = formattedName.replaceAll("YouTube", "");
		formattedName = formattedName.replaceAll("youtube", "");
		formattedName = formattedName.replaceAll("()", "");
		
		if(year!=""){
			int indx = formattedName.lastIndexOf('.');
			formattedName = formattedName.substring(0,indx) + " ["+year+"]" + formattedName.substring(indx);
		}
		
		formattedName = formattedName.replaceAll("mpu", "mp4");
		formattedName = formattedName.replaceAll("MPu", "mp4");
		formattedName = formattedName.replaceAll("  ", " ");
		formattedName = formattedName.replaceAll("  ", " ");
		formattedName = formattedName.replaceAll("  ", " ");
		formattedName = formattedName.toLowerCase();
		
		System.out.println(formattedName+"\n-------------------");
		return formattedName;
		
	}*/

}
