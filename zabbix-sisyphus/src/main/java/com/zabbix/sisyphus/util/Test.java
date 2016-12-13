package com.zabbix.sisyphus.util;

public class Test {

	
	public void Test2(String ss,StringBuffer sb,int i,int[] a ) {
		// TODO Auto-generated constructor stub
		ss = "11";
		sb.append("aa");
		i =3;
		int[] b = a;
		b[1]=5;
		System.out.println("a[1]= "+ a[1]);
		System.out.println(ss+"  "+sb.toString()+"  , i="+i );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a ={1,2};

		
		
		
		String s1 = "1";
		
		System.out.println("s1= "+s1);
		
		
		String ss = "";
		StringBuffer sb = new StringBuffer();
		int i=9 ;
		Test t =new Test();
		
		t.Test2(ss,sb ,i,a);
		System.out.println("ss = "+ss+" , "+sb.toString() +"  , i= "+i+"  , a[1] =  "+a[1]);
		
		
	}

}
