package poo.util;

public class eqSecondoGrado {
	
	double[] soluzioni=new double[2];
	double b,a,c;
	
	public double[] getSoluzioni() {
		double[] sol= new double[2];
		for(int i=0;i<soluzioni.length;i++)
			sol[i]=soluzioni[i];
		return sol;
	}
	public double getA() {return a;}
	public double getB() {return b;}
	public double getC() {return c;}
	
	public eqSecondoGrado(final double x, final double y,final double z) {
		b=x;a=y;c=z;		
	}

	public double eqDelta() {
		double delta=b*b-4*a*c;
		return delta;
	}
	
	
	public double[] eqSolver() {
		double delta=eqDelta();
		soluzioni[0]=(-b-Math.sqrt(delta))/(2*a);
		soluzioni[1]=(-b+Math.sqrt(delta))/(2*a);
		return getSoluzioni();
		
	}
	public double eqSol() {
		return (-b-Math.sqrt(eqDelta()))/(2*a);
	}
	
	
	public static void main(String[]args) {
		double x_q=4,x=4,c=1;
		eqSecondoGrado eq1=new eqSecondoGrado(x_q,x,c);
		double delta=eq1.eqDelta();
		System.out.println("Delta= "+delta);
		if (delta==0) {
			System.out.println(eq1.eqSol());
		}
		if(delta>0) {
			double[] sol=new double[2];
			sol=eq1.eqSolver();
			System.out.println(sol[0]);
			System.out.println(sol[1]);
		}
		if(delta<0) {
			System.out.println("Equazione inconsistente, Delta negativo!");			
		}
		
		
				
	}
}
