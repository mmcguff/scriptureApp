import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class URL {
	
	private String address;
	
	public String getURL(){
		return address;
	}
	public void setURL(String add){
		address = add;
	}
	private boolean testURL(){
		try (Socket socket = new Socket()) {
			//ping the server to check if it exist
	        socket.connect(new InetSocketAddress(address, 23));
	        //if no errors return true
	        return true;
	    } catch (IOException e) {
	    	//if it doesn't catch return false
	        return false; 
	    }
	}

}
