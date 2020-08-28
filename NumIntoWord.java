package num;
import java.util.Scanner;
/**Write a console application  that takes in a currency value
* (Min Value 00, Max Value 9,99,999.99) and prints out a text. For ex. If provided "123456.78"
*, it should print out "Rs. One Lakh Twenty Three Thousand Four Hundred And Fifty Six 78/100 ONLY".
*/
public class NumIntoWord{
	//unit array having constant values
	static String unit[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
				"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
				"Seventeen","Eighteen","Ninteen"};

	//tens array having constant values
	static String tens[]={"","","Twenty","thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};

	
	
	static String getWord(double n){
		String str="";
		if(n<20){
			
			str=unit[(int)n]+getDecimalFraction((float)(n-(int)n));
		}
		
		if(n>=20 && n<100){
			str=tens[(int)n/10] + unit[(int)n%10] + getDecimalFraction((float)(n-(int)n));
		}
		
		return str;
		
	}//getWord

	//getDecimalFraction method called to get decimal value in fraction e.g 0.453=453/100
	static String getDecimalFraction(float num){

	if(num!=0){	
		String s=String.valueOf(num);
		String s1="";
		int digit=s.length()-1-s.indexOf('.');
		int deno=1;
		for(int i=0;i<digit;i++){
			num*=10;
		 	deno=10*deno;	
		}
		int num1=(int)Math.round(num);
		int deno1=(int)Math.round(deno);
		String d1=String.valueOf(digit);
		String s3=String.valueOf(num1);
		String s4=String.valueOf(deno);
		s1=s3+'/'+s4;
		return s1;
	}
		return " ";
	}//getDecimalFraction
	

	//by calling covert method we getting word format of number
	static String convert(double num){
		//variable to hold the number value as string		
		String str1="";
		
		//this if for number less then 20 like 11	
		if(num<20){
		str1=getWord(num);
		}
		
		//number like 99
		if(num/10>1){
		str1=getWord(num);
		}
		
		//756
		 if(num/100>1){
		str1=getWord((int)num/100)+" Hundred and "+convert((int)num%100)+getDecimalFraction((float)(num-(int)num));
		}

		//4356
		 if(num/1000>1){              
		str1=getWord((int)num/1000)+" Thousand "+convert((int)num%1000)+getDecimalFraction((float)(num-(int)num));				
		}
		
		//546844
		if(num/100000>1){
		str1=getWord((int)num/100000)+" lakh "+convert((int)num%100000)+getDecimalFraction((float)(num-(int)num));
		}
		
		//4534535
		if(num/10000000>1){
		str1=getWord((int)num/10000000)+" crore "+convert((int)num%10000000)+getDecimalFraction((float)(num-(int)num));

		}

		return str1;

	}//convert
	
	//NumIntoWord class loaded and main method call by jvm
	public static void main(String[] arg){
		Scanner sc=new Scanner(System.in);
		//Enter user input number
		System.out.print("Enter number::");
		//read the number
		double num=sc.nextDouble();
		//calling convert method with num value as argument
		System.out.println(convert(num));
		
	}
}
