/**
 **
 * @author Miao He mhe23@myseneca.ca
 * @version 1.0
 */
package CreditCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardValidation {

	public static void main(String[] args) throws NullPointerException{
	long creditCardNumber= 4012888888881881L;
	System.out.println(isValid(creditCardNumber));
	}
	public static List<Long> toDigits(long l) {
		
		List<Long> ints = new ArrayList<>();
		
		/**
		 * convert the long number to list
		 */
		while (l > 0) {
	        ints.add(0, l % 10);
	        l /= 10;
	    }
	    return ints;
		
		}
	public static List<Long> doubleSecond(List<Long> list) {
 
		/**
		 * for this method, the passed list is every second digit of list 
		 * declare long arrays as belows
		 */
		long[] num4=new long [list.size()];
		@SuppressWarnings("unused")
		long[] num5=new long [num4.length];
		/**
		 * get the list size and convert it to long array
		 */
		int retval = list.size();
		for(int i = 0; i< retval;i++){
			num4[i]=list.get(i);
		}
		/**
		 * double the value of long array
		 */
		for (int j = 0; j < num4.length; j++)
	    {
			num4[j] = num4[j] * 2;
	        }
		/**
		 * If the number is greater than 9,then sum the digits to one number
		 */
		for (int k = 0; k < num4.length; k++)
	    {
	        if (num4[k] > 9)
	        {
	        	num4[k]= (num4[k] % 10) + 1;	
	        }
	    }
		/**
		System.out.println(num4[0]);
		System.out.println(num4[1]);
		System.out.println(num4[2]);
		System.out.println(num4[3]);
		System.out.println(num4[4]);
		System.out.println(num4[5]);
		System.out.println(num4[6]);
		System.out.println(num4[7]);*/
		/**
		 * convert the long array to list and return it
		 */
		List<Long> ints2 = new ArrayList<>();	
		for(int m=0; m<num4.length;m++){
		 ints2.add(num4[m]);
		 }
		//System.out.println(ints2);
		return ints2;
	    }
	
	public static List<Long> toDigitsReverse(long l) {
		/**
		 * reverse the long number(credit card number) and 
		 * return the list
		 */
		 List<Long> ints1 = new ArrayList<>();
		 while (l > 0) {
		        ints1.add(0, l % 10);
		        l /= 10;
		    }
		 Collections.reverse(ints1);
		 return ints1;
	}
 
	@SuppressWarnings("unused")
	public static long sumDigits(List<Long> list) {
		long[] num3=new long [list.size()];
		
		List<Long> ints2 = new ArrayList<>();
		List<Long> ints3 = new ArrayList<>();
		List<Long> ints4 = new ArrayList<>();
		/**
		 * get every second digit and first digit and call todigits fucntion
		 */
		int j=1;
		long sum =0;
		for(int i = 0; i< list.size();i++){
			if(j%2==0){
				ints2.add(list.get(i));
		}
		else
		{
			ints4 = toDigits(list.get(i));
			for(int k = 0; k < ints4.size(); k++)
				sum += ints4.get(k);	
			
		}
			j++;
		}
		
		
		long sum1=0;
		long total=0;
		/**
		 *Pass every second digit to "doublSecond" method
		 */
			ints3 = doubleSecond(ints2);
			/**
			 * calculate the sum of every second digit
			 */
		 for(int l = 0; l< ints3.size();l++){
				sum1+=ints3.get(l);
			}
		 /**
			 * calculate the sum of every second digit plus sum of every first digit
			 */
		 total=sum + sum1;
		
		return total;
		
	}
	public static boolean isValid(long l) {
		
		/**
		 * pass the credit card number to "toDigitsReverse"method to 
		 * reverse credit card number's order
		 */
		List<Long> num2 = toDigitsReverse(l);		
		 /**
		 * define a long type number and pass the list to sumDigit
		*/
		long num1=sumDigits(num2);
		
		/**
		 * to valide the credit card number is valid or not
		 */
		if (num1 % 10 == 0) {
			 return true;
			 }else
			 {
			return false;
			 }
}
}
