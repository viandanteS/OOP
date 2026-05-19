package poo.lambda_stream;

@FunctionalInterface
interface String2Message{ 
	Message getMessage( String msg );
}//String2Message

class Message{
	public Message( String msg ){//constructor
		System.out.print(msg);
	}
}//Message

public class ConstructorAsMethodReference {
	public static void main(String[] args){
		String2Message hello = Message::new;
		hello.getMessage("Hello there! Here I’m.");
	}//main
}//ConstructorAsMethodReference

