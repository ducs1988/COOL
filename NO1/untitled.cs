using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Program
{
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public List<String> retrieveMostFrequentlyUsedWords(String literatureText, 
	                                               List<String> wordsToExclude)
	{
		List<String> results = new List<String>();
		int max = 0;
		
		if (literatureText == null || literatureText.Length == 0)
		    return results;
		    
		string pattern = @"[a-zA-Z]+";
		string input = literatureText.ToLower();
		
		RegexOptions options = RegexOptions.Singleline;
		
		Dictionary<string, int> dict = new Dictionary<string, int>();
		
		foreach (Match m in Regex.Matches(input, pattern, options)) {
		    string str = m.Value;
		    
		    // if match word listed in exclude, skip
		    if (wordsToExclude != null && wordsToExclude.Contains(str, StringComparer.OrdinalIgnoreCase))
		        continue;
		        
		    if (dict.ContainsKey(str)) {
		        dict[str] += 1;
		    } else {
		        dict.Add(str, 1);
		    }
		    
		    if (max < dict[str])
		        max = dict[str];
		}
		
		foreach (KeyValuePair<string, int> pair in dict) {
		    if (pair.Value == max) {
		        results.Add(pair.Key);
		    }
		}
		
		return results;
		
	}
	// METHOD SIGNATURE ENDS
}