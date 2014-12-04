package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private Properties properties;
	private ContactHelper ñontactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;
	
	
	public static ApplicationManager getInstance(Properties properties) throws IOException{
		if(singleton == null){
			singleton = new ApplicationManager();
			singleton.setProperties(properties);
			singleton.start();
		}
		return singleton;
	} 
	
	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();
	}
	
	public void stop() {
		getProcessHelper().stopAppUnderTest();
	}
	
	public void setProperties(Properties properties){
		 this.properties = properties;	
	}
	
	public String getProperties(String key){
		return properties.getProperty(key);
	}

	public ProcessHelper getProcessHelper() {
		if(processHelper == null){
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}

	public ContactHelper getContactHelper() {
		if(ñontactHelper == null){
			ñontactHelper = new ContactHelper(this);
		}
		return ñontactHelper;
	}
	
	public AutoItHelper getAutoItHelper() {
		if(autoItHelper == null){
			autoItHelper = new AutoItHelper(this);
		}
		return autoItHelper;
	}
	

}
