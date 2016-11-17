package tanksgame.Maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import tanksgame.Objects.ID;
import tanksgame.Objects.Map;

public class ConvertTextToMap {
	// each wall or space in the text is 10 spaces in the program
	// NEEDS TO BE 60 LINES LONG AND 90 SPACES WIDE
	public String[] getText(String fileName){
		String[] map = new String[60];
		String line = null;
		BufferedReader reader = null;
		try{
			InputStream in = this.getClass().getResourceAsStream(fileName);
			reader = new BufferedReader(new InputStreamReader(in));
			int lineNum = 0;
			while( (line = reader.readLine()) != null){
				map[lineNum] = line;
				lineNum++;
			}			
		}catch (IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage()+ "for "+fileName+".txt", "File Error", JOptionPane.ERROR_MESSAGE);
		}
		return map;		
	}

	//	public String lookAbove(String[] text, int count, int index){
	//		String finalLine = "";
	//		if(count <= 59){
	//			String lineAbove = text[count+1];
	//			if(lineAbove.charAt(index) == '0'){
	//				finalLine.concat("0");
	//				lookAbove(text, count+1, index);
	//			}else{
	//				return finalLine;
	//			}
	//		}else{
	//			return finalLine;
	//		}
	//		return finalLine;
	//	}

	public DAS lookSideToSide(String[] text, int count, int index, int start){
		String finalLine = "";
		DAS das = new DAS(start, count, finalLine);
		if(count <= text[0].length()){
			if(text[index].charAt(count+1)== '0'){
				finalLine.concat("0");
				lookSideToSide(text, index, count+1, start);
			}else{
				return das;
			}
		}else{
			return das;
		}
		return das;
	}

	public DAS lookUpDown(String[] text, int count, int index, int start){
		String finalLine = "";
		DAS das = new DAS(start, count, finalLine);
		if(count >= 0){
			String lineBelow = text[count-1];
			if(lineBelow.charAt(index) == '0'){
				finalLine.concat("0");
				lookUpDown(text, count-1, index, start);
			}else{
				return das;
			}
		}else{
			return das;
		}
		return das;
	}

	public Map convertTextToMap(String[] text){
		Map returnMap = new Map(0, 0, 0, 0, ID.Map, "returnMap");
		for(int y = 0; y <)
		LinkedList<DAS> lines = new LinkedList<DAS>();
		DAS finalLine = lookUpDown(text, 0, y, 0);
		lines.add(finalLine);
		while(finalLine.end != 60){
			lines.add(lookUpDown(text, 0, y, lines.getLast().end));

			return returnMap;
		}
	}

	class DAS{
		public int start, end;
		public String str;

		public DAS(int doub, int end, String str){
			this.start =  doub;
			this.end = end;
			this.str = str;
		}
	}
}
