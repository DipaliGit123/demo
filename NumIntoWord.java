
import java.util.Scanner;
/**Write a console application  that takes in a currency value
* (Min Value 00, Max Value 9,99,999.99) and prints out a text. For ex. If provided "123456.78"
*, it should print out "Rs. One Lakh Twenty Three Thousand Four Hundred And Fifty Six 78/100 ONLY".
*/
public class NumIntoWord{
	static String unit[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
				"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
				"Seventeen","Eighteen","Ninteen"};

	static String tens[]={"","","Twenty","thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};

	
	
	static String getWord(double n){
		String str="";
		if(n<20){
			
			str=unit[(int)n]+decimal((float)(n-(int)n));
		}
		
		if(n>=20 && n<100){
			str=tens[(int)n/10] + unit[(int)n%10] + decimal((float)(n-(int)n));
		}
		
		return str;
		
	}//getWord
	static String decimal(float num){

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
	}//decimal
	
	static String convert(double num){
				
		String str1="";
		
		
		if(num<100){
		str1=getWord(num);
		}
		
		
		else if(num>=100 && num<1000){
		str1=getWord((int)num/100)+" Hundred and "+convert((int)num%100)+decimal((float)(num-(int)num));
		}

		
		else if(num>=1000 && num<100000){              
		str1=getWord((int)num/1000)+" Thousand "+convert((int)num%1000)+decimal((float)(num-(int)num));				
		}
		
		else if(num>=100000 && num<10000000){
		str1=getWord((int)num/100000)+" lakh "+convert((int)num%100000)+decimal((float)(num-(int)num));
		}

		else if(num>=10000000 && num<1000000000){
		str1=getWord((int)num/10000000)+" crore "+convert((int)num%10000000)+decimal((float)(num-(int)num));
		}

		return str1;

	}//convert

	public static void main(String[] arg){
		Scanner sc=new Scanner(System.in);
		//Enter input number
		System.out.print("Enter number::");
		double num=sc.nextDouble();
		//input value in word
		System.out.println(convert(num));
		
	}
}