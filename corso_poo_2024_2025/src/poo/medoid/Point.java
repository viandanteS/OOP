package poo.medoid;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Point {
	
	private static final int D=3;
	private double[] coordinate;

	public Point(double[] coordinate) {
		if(coordinate.length!=D) throw new RuntimeException("Num di coordinate non rispettato.");
		this.coordinate=Arrays.copyOf(coordinate, D);		
	}
	public Point(Point p) {
		this(Arrays.copyOf(p.coordinate, getD()));
	}
	
	double[] getCoord() {
		return Arrays.copyOf(coordinate, D);
	}
	
	double distance(Point p) {
		double sommaQuadrati=0;
		for(int i=0;i<D;i++) {
			sommaQuadrati+=Math.pow(this.coordinate[i],2)-Math.pow(p.coordinate[i],2);
		}
		return Math.sqrt(sommaQuadrati);
	}
	
	static int getD() {
		return D;		
	}
	
	private static Point medoid(Set<Point> group) {
		Point ret=null;
		double minSum=Double.MAX_VALUE;
		for(Point p:group) {
			double tmp=calcolaSommaDistanze(group,p);
			if(tmp<minSum) {
				ret=p;
				minSum=tmp;
			}
		}
		
		return ret;
	}
	
	private static double calcolaSommaDistanze(Set<Point> group, Point p) {
		double distanza=0;
		for(Point x:group) {
			if(!p.equals(x))
				distanza+=p.distance(x);
		}
		return distanza;
	}
	
	static Set<Point>[]split(Point[] ds,Point[] md){
		int K=md.length;
		Set<Point>[] ret=(Set<Point>[])new HashSet[K];
//		for(Set<Point> r:ret) {
//			r=new HashSet<>();
//		}
		for(int i=0;i<K;i++) {
			ret[i]=new HashSet<>();
		}
		double dist;
		for(int i=0;i<ds.length;i++) {
			dist=ds[i].distance(md[0]); //distanza di pds minima tra i medoidi
			int indexOfGroup=0;
			double tmp;
			for(int j=1;j<K;j++) {
				tmp=(ds[i].distance(md[j]));
				if(tmp<dist) {
					dist=tmp;
					indexOfGroup=j;
				}
//				System.out.println(indexOfGroup);
			}
			ret[indexOfGroup].add(ds[i]);
		}
		return ret;
	}
	static Point[] update( Set<Point>[] partition) {
		Point[] ret=new Point[partition.length];
		for(int i=0;i<partition.length;i++) {
			ret[i]=medoid(partition[i]);
		}
		return ret;
	}
	
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<D;i++) {
			sb.append("["+coordinate[i]+"]");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public static void main(String...Args) {
		int lengthds=1000,K=4;
		Random random=new Random();
		Point[] dataset=new Point[lengthds];
		
		for(int i=0;i<lengthds;i++) {
			double[] coordinatePt=new double[D];
			for(int j=0;j<D;j++) {
				coordinatePt[j]=random.nextDouble(-10000,10000);
			}
			dataset[i]=new Point(coordinatePt);
		}
		
		
		Point[] medoidi= new Point[K];

		for(int i=0;i<K;i++) {
			medoidi[i]=dataset[random.nextInt(lengthds)];
		}

		
		Set<Point>[] grps=split(dataset, medoidi);
		for(int i=0;i<grps.length;i++) {
			System.out.println(grps[i].size());
			System.out.println("*******************************");
		}
		Point[] newMedoidi=update(grps);
		
		for(Point p:newMedoidi) {
			System.out.println(p);
		}
	}

}
