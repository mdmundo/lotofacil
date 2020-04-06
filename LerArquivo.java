import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class LerArquivo {
	
	public Object[][] dados(URL url) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter out = new BufferedWriter(new FileWriter("arquivo.txt"));
        String inputLine;
        int linhas = 0;
        
        Object[][] bolas = null;
        ArrayList< Object[]> no = new ArrayList<>();
        int a = 0, b = 0;
        
        while ((inputLine = in.readLine()) != null) {
        	if(inputLine.contains(">")) {
        		inputLine = inputLine.substring(inputLine.indexOf(">")+1);
	        	if(inputLine.contains("<")) {
	            	inputLine = inputLine.substring(0, inputLine.indexOf("<"));
	        	}
        	}
        	
        	if(inputLine.contains("/")) {
        		linhas++;
        		 Object[] bol = new Object[16];
        		 bol[a]= linhas;
        		 a++;
        		for(int i=0; i<30;i++) {
        			inputLine = in.readLine();
        			if(inputLine.contains(">")) {
        	        	inputLine = inputLine.substring(inputLine.indexOf(">")+1);
        	        	if(inputLine.contains("<")) {
        	            	inputLine = inputLine.substring(0, inputLine.indexOf("<"));
        	        	}
        	        } 
        			
        			if(!inputLine.equals("")){
        				bol[a] = (Object) inputLine;
        				a++;
        			}
        			out.write(inputLine+" ");
        		}
        		no.add(bol);
        		out.newLine();
        		a = 0;
        	}
        }
        bolas = new Object[linhas][16];
        for(int i=0;i<linhas;i++) {
        	bolas[i]= no.get(i);
        }
        
        in.close();
        out.flush();
        out.close();
        return bolas;
    }
}
