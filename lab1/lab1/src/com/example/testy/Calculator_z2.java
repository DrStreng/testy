package com.example.testy;

public class Calculator_z2 {
	
	public double add(double  l1,double  l2){
		return l1+l2;
	}
	public double sub(double  l1,double  l2){
		return l1-l2;
	}
	public double multi(double  l1,double  l2){
		return l1*l2;
	}
	public double div(double  l1,double  l2){
		if(l2 == 0)throw new ArithmeticException();
		return l1/l2;
	}
	public boolean greater(double  l1,double  l2){
		if(l1>l2){
			return true;	
		} else {
			return false;
		}
	}
}
