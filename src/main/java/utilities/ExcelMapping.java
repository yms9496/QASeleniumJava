package utilities;

import java.util.HashMap;

public class ExcelMapping {

	public HashMap <String,String> excelMapping;
	
	public ExcelMapping(){
		
		// HashMap to store excel Mapping
		excelMapping = new HashMap<String, String>();
		
		// Add new mapping entries below //
		
		excelMapping.put("CurrentEnv","Configuration,1,1"); // current env
		excelMapping.put("Browser","Configuration,2,1"); // current browser
		excelMapping.put("ChromeVersion","Configuration,1,4"); // current browser version
		excelMapping.put("FireFoxVersion","Configuration,2,4"); // current browser version
		excelMapping.put("DB_Region","Configuration,3,1"); // current DB region
		excelMapping.put("CurrentEnvURL", "Configuration,4,1"); // get the URL based on env
		excelMapping.put("DB_Uname","Configuration,1,5"); // current browser version
		excelMapping.put("DB_Pass","Configuration,1,6"); // current browser version
	}
}
