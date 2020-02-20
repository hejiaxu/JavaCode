/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 20, 2017
 * 
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO 
		String convert = convert("ABC", 3);
		System.out.println(convert);
	}
	
	//43ms
    public static String convert(String s, int numRows) {
    	if (numRows<=1) {
			return s;
		}
    	char[] c = s.toCharArray();
    	char[] r = new char[c.length];
    	int k=0;
    	for(int j=0;j<numRows;j++){
    		if (j==0||j==numRows-1) {
    			for (int i = j; i < c.length; i+=2*numRows-2) {
    				r[k]=c[i];
    				k++;
    			}
			}else {
				for (int l = j; l < c.length; l+=2*numRows-2) {
					r[k]=c[l];
					k++;
					int m =l+2*numRows-2-l%(2*numRows-2)*2;
					if (m<c.length) {
						r[k]=c[m];
						k++;
					}
					
				}
			}
    	}
    	
    	return String.valueOf(r);
    }
    //43ms
    public static String convert2(String s, int numRows) {
    	if (numRows<=1) {
    		return s;
    	}
    	char[] c = s.toCharArray();
    	StringBuilder sBuilder= new StringBuilder();
    	for(int j=0;j<numRows;j++){
    		if (j==0||j==numRows-1) {
    			for (int i = j; i < c.length; i+=2*numRows-2) {
    				sBuilder.append(c[i]);
    			}
    		}else {
    			for (int l = j; l < c.length; l+=2*numRows-2) {
    				sBuilder.append(c[l]);
    				int m =l+2*numRows-2-l%(2*numRows-2)*2;
    				if (m<c.length) {
        				sBuilder.append(c[m]);
    				}
    				
    			}
    		}
    	}
    	return sBuilder.toString();
    }
    
    
    //60ms
    public String convert3(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString(); 
    }

}
