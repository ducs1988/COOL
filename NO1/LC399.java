import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Evaluate Division
 * 
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<>();
        HashMap<String, ArrayList<Double>> valuePairs = new HashMap<>();
        for (int i = 0; i < equations.length; ++i) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuePairs.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuePairs.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuePairs.get(equation[0]).add(values[i]);
            valuePairs.get(equation[1]).add(1.0/values[i]);
        }

        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String[] query = queries[i];
            results[i] = dfs(query[0], query[1], pairs, valuePairs, new HashSet<String>(), 1.0);
        }
        return results;
    }

    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> valuePairs, HashSet<String> visited, double value) {
        if (visited.contains(start))
            return -1.0;
        if (!pairs.containsKey(start))
            return -1.0;
        if (start.equals(end))
            return value;
        visited.add(start);
        ArrayList<String> startList = pairs.get(start);
        ArrayList<Double> valueList = valuePairs.get(start);
        double val = -1.0;
        for (int i = 0; i < startList.size(); ++i) {
            val = dfs(startList.get(i), end, pairs, valuePairs, visited, value * valueList.get(i));
            if (val != -1.0)
                break;
        }
        visited.remove(start);
        return val;
    }
}
