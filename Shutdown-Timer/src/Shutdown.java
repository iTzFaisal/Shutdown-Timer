//Faisal Alkheraiji
import java.io.IOException;


public final class Shutdown {
	private static String osType = System.getProperty("os.name");
	
	public static void setTimer(int number , int status){
		Runtime set = Runtime.getRuntime();
		try {
			if(status == 0){
				Shutdown.resetTimer();
				if(osType.startsWith("Windows")){
					set.exec("shutdown -s -t " + number);
				}else{
					set.exec("shutdown -h " + number);
				}
			}
			if(status == 1){
				Shutdown.resetTimer();
				number = number * 60;
				if(osType.startsWith("Windows")){
					set.exec("shutdown -s -t " + number);
				}else{
					set.exec("shutdown -h " + number);
				}			
			}
			if(status == 2){
				Shutdown.resetTimer();
				number = number * 60 * 60;
				if(osType.startsWith("Windows")){
					set.exec("shutdown -s -t " + number);
				}else{
					set.exec("shutdown -h " + number);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void resetTimer(){
		Runtime reset = Runtime.getRuntime();
		try {
			if(osType.startsWith("Windows")){
				reset.exec("shutdown -a");				
			}else{
				reset.exec("shutdown -c");
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
