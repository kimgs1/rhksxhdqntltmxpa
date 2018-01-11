package common;

public class Practice {
	String maxStr = "";
	public String longestPalindrome(String s) {
		
		
		int length = s.length();
		char[] charList = s.toCharArray();
		String sSharp = "#";
		for(int i=1; i< length ; i++){
			sSharp += charList[i] + "#";
		}
		
		char[] charSharpList = sSharp.toCharArray();
		int sharpLength = charSharpList.length;
		
		int centerIdx = 1;
		int maxRight = 1;
		int[] pList = new int[sharpLength];
		pList[0] = 0;
		pList[1] = 1;
		maxStr = "" + charList[0];
		
		for(int i=2; i<sharpLength; i++){
			if(i > maxRight)
				pList[i] = 1;
			else{
				pList[i] = Math.min(pList[2*centerIdx - i], maxRight - i);
			}
			while(i-pList[i] > 0 && i+pList[i] < sharpLength && charSharpList[i-pList[i]] == charSharpList[i+pList[i]]){
				pList[i] = pList[i] + 1;
			}
			
			if(i + pList[i] > maxRight){
				centerIdx = pList[i];
				maxRight = i + pList[i];
			}
		}
		return maxStr;
	}
	
		
}
