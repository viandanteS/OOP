package poo.app;
import poo.razionali.Razionale;
import poo.date.Data;
import java.util.Arrays;
import poo.util.Array;

public class TestComparabili{
     public static void main( String[] args ){
		String[] as={"lupo","abaco","tana","volpe","dado"};
		Data[] ad={ new Data(2,3,1989), new Data(), new Data(29,12,1970), new Data(29,2,2000) };
		Razionale[] ar={new Razionale(24,14), new Razionale(10,8), new Razionale(30,18) };

		System.out.println("Array iniziale delle stringhe: "+Arrays.toString(as));
		Array.selectionSort( as );
		System.out.println("Array finale delle stringhe: "+Arrays.toString(as));

		System.out.println("Array iniziale delle date: "+Arrays.toString(ad));
		Array.selectionSort( ad );
		System.out.println("Array finale delle date: "+Arrays.toString(ad));

		System.out.println("Array iniziale dei razionali: "+Arrays.toString(ar));
		Array.selectionSort( ar );
		System.out.println("Array finale delle stringhe: "+Arrays.toString(ar));

    }//main
}//TestComparabili