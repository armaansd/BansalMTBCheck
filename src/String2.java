
public class String2 {
	public static void main(String args[])
	{
		String S1="NAMAN",S2=" ";
		int l,i,K;
		char c;
		l=S1.length();
		for(i=l-1;i>=0;i++)
		{
			c=S1.charAt(i);
			S2=S2.concat(Character.toString(c));
		}
		K=S2.compareTo(S1);
		System.out.println(K);
	}
}
