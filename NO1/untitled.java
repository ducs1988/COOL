import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{ 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logfile) 
	{
		List<String> list = new ArrayList<String>();
		
		if (logFileSize != logfile.size())
		    return list;
		    
		List<String> digitList = new ArrayList<String>();
		List<String> alphaList = new ArrayList<String>();
		
		for (int i = 0; i < logfile.size(); i++) {
		    String parts[] = logfile.get(i).split("\\s+", 2);
		    if (Character.isDigit(parts[1].charAt(0)))
		        digitList.add(logfile.get(i));
		    else
		        alphaList.add(logfile.get(i));
		}
		
		// sort alphaList with lexicographically
		Collections.sort(alphaList, (a,b) -> {
		   String parts1[] = a.trim().split("\\s+", 2);
		   String parts2[] = b.trim().split("\\s+", 2);
		   
		   if (parts1[1].compareToIgnoreCase(parts2[1]) == 0) {
		       // if log same (exclude id), then compare ID
		       return parts1[0].compareToIgnoreCase(parts2[0]);
		   } else {
		       return parts1[1].compareToIgnoreCase(parts2[1]);
		   }
		});
		
		list.addAll(alphaList);
		list.addAll(digitList);
		return list;
	}
	// METHOD SIGNATURE ENDS
}