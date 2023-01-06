package Algorithms.RecursiveAndDynamic;

import java.util.*;
import java.util.stream.Stream;

public class EvaluateDivision {

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ArrayList<Double> answer = new ArrayList<>();
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations,values);
        HashSet<String> visited = new HashSet<>();
        for(List<String> query: queries) {
            if(!helper(query.get(0),1,query.get(1), graph, answer,visited)){
                answer.add(-1.0);
            }
            visited.clear();
        }

        return answer.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static boolean helper(String dividend,double runningCalc ,String target, HashMap<String, HashMap<String, Double>> map, ArrayList<Double> answer, HashSet<String> visited) {

        if(visited.contains(dividend))
            return false;

        HashMap<String, Double> mapOfDividend = map.get(dividend);
        if(mapOfDividend == null)
            return false;
        for(Map.Entry<String,Double> entry : mapOfDividend.entrySet()) {
            visited.add(dividend);

            if(dividend.equals(target) ) {
                answer.add(runningCalc);
                return  true;
            }

            if(helper(entry.getKey(),entry.getValue() * runningCalc, target,map,answer, visited)) {
                visited.remove(dividend);
                return true;
            }
        }

        return false;
    }

    public static HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            HashMap<String, Double> divisorMap = map.getOrDefault(dividend, new HashMap<>());
            divisorMap.put(divisor, values[i]);
            map.put(dividend, divisorMap);

            HashMap<String, Double> divisorMapAlternate = map.getOrDefault(divisor, new HashMap<>());
            divisorMapAlternate.put(dividend, 1/values[i]);
            map.put(divisor, divisorMapAlternate);
        }

        return map;
    }
}
