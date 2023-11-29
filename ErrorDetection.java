package jhansi;

import java.util.*;

public class ErrorDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner o = new Scanner(System.in);
		System.out.println("Enter generator : ");
		String generator = o.next();
		System.out.println("Enter data : ");
		String data = o.next();
		String code = data;
		while(code.length()<(data.length()+generator.length()-1))
			code+="0";
		
		code = data + div(code, generator);
		System.out.println("Transmitted code : "+code);
		System.out.println("Enter received code : ");
		String received = o.next();
		if(Integer.parseInt(div(received,generator))==0)
			System.out.println("No error Found");
		else
			System.out.println("Error is detected");
		o.close();
	}
	public static String div(String code, String generator) { 
		String result = code; 
		String remainder = "";int i;
		int prev = 0;
		while(true) {
			for (i=0;i<generator.length();i++) { 
				if(result.charAt(i)==generator.charAt(i)) 
					remainder+="0";
				else
					remainder+="1";
			}
			System.out.println("remainder : "+remainder);
			i=0;
			while(remainder.length()>=1) {
				if(remainder.charAt(0)=='0') {
					remainder=remainder.substring(1);
					prev++;
					i++;
				}
				else {
					break;
				}
			}
			
			result = remainder+code.substring(generator.length()-i+prev);
			System.out.println(result);
			if(result.length()<generator.length())
				break;
			remainder ="";
		}
		while(result.length()!=generator.length()) {
			result = "0"+result;
		}
		
		return result.substring(1, result.length());
	}
}
