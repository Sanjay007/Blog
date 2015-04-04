package org.logg;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import org.constants.AppConstants;

public class RunInvLogger {

	private static final InvLoggimpl InvLoggimpl = null;
	
	public static final void initLogMgr(){
	
		if(AppConstants.getLogFilePath()!=null){
			PropertyConfigurator.configure(AppConstants.getLogFilePath().trim());
		}else if(AppConstants.getLogFilePath()==null){
			
			BasicConfigurator.configure();
		}
		
	}
	
	public static InvLoggimpl  getbaseLogger(){
		
	if(	InvLoggimpl==null){
		
		return new InvLoggimpl();
	}
	return InvLoggimpl;
	}
	
}
