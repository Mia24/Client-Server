/**
 **
 * @author Miao He mhe23@myseneca.ca
 * @version 1.0
 */
package CreditCard;
import java.io.*;

@SuppressWarnings("serial")
public class CreditCard implements Serializable {
	long creditCardNumber;
	boolean flag;
	
	CreditCard(){
		creditCardNumber=0L;
		flag=true;
	}
	CreditCard(long cd, boolean f){
		creditCardNumber=cd;
		flag=f;
	}

	/**
	 * @return the creditCardNumber
	 */
	public long getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (creditCardNumber ^ (creditCardNumber >>> 32));
		result = prime * result + (flag ? 1231 : 1237);
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (creditCardNumber != other.creditCardNumber)
			return false;
		if (flag != other.flag)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreditCard [creditCardNumber=" + creditCardNumber + ", flag=" + flag + "]";
	}
	
	
}
