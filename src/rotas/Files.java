package rotas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Files {
	private String pathBase = "C:\\Teste";
	private String pathConfig = this.pathBase+"\\Configuracao";
	
	Files () {
		File dirB = new File(pathBase);
		File dirC = new File(pathConfig);
		File fileC = new File(pathConfig+"\\config.txt");
		
		if (!dirB.exists()) {
			System.out.println("O diretório "+pathBase+" não existe favor criar!");
			System.exit(1);
		} else if (!dirC.exists()) {
			System.out.println("O diretório "+pathConfig+" não existe favor criar!");
			System.exit(1);
		} else if (!fileC.exists()) {
			System.out.println("O arquivo "+pathConfig+"\\config.txt"+" não existe favor criar!");
			System.exit(1);
		}
	}
	
	public void createDirs() {
		BufferedReader br = null;
		
		try {
			String line;
			InputStream is = new FileInputStream(new File(pathConfig+"\\config.txt"));
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			while ((line = br.readLine()) != null) {
				String[] arr = line.split("=");
				String[] pathConfigs = arr[1].split("\n");
				for (String c : pathConfigs) {
					File dir = new File(c);
					if (!dir.exists()) dir.mkdir();
				}
            }			
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
	}
}
