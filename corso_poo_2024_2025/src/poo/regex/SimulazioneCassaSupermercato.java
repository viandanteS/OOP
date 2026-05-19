package poo.regex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SimulazioneCassaSupermercato {
	public static void main( String[] args ) {
		String STOP="[Ss][Tt][Oo][Pp]";
		String ARRIVO="[Aa]\\s+\\w+";
		String PARTENZA="[Pp]";
		String COMANDO="("+STOP+"|"+ARRIVO+"|"+PARTENZA+")";
		Scanner sc=new Scanner( System.in );
		String com=null;
		Queue<String> coda=new LinkedList<>();
		for(;;) {
			System.out.print(">> ");
			com=sc.nextLine();
			if( !com.matches(COMANDO) )
				System.out.println("Comando sconosciuto.");
			else {
				if( com.matches(STOP) ) {
					System.out.println("STOP con residuo: "+coda);
					break;
				}
				else {
					if( com.matches(ARRIVO) ){
						int i=com.lastIndexOf(' ');
						String nick=com.substring(i+1);
						coda.offer(nick);
						System.out.println("Arriva "+nick+" "+coda);
					}
					else{//com e' necessariamente una partenza
						if( coda.isEmpty() )
							System.out.println("Coda vuota.");
						else
							System.out.println("Esce "+coda.poll()+" "+coda);
					}
				}
			}
		}
		sc.close();
		System.out.println("Bye.");
	}//main
}//SimulazioneCassaSupermercato
