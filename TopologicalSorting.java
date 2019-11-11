import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class TopologicalSorting {
    public static void main(String args[]) {
        HashMap<String, Vertex> graph = new Graph().getGraph();
        Stack<String> stack = new Stack<String>();
        HashSet<String> visited = new HashSet<String>();
        for (String key : graph.keySet()) {
            if (!visited.contains(key)) {
                getTopologicalSort(graph, visited, stack, key);
            }
        }
        while(!stack.empty())
        System.out.print(stack.pop()+" ");
    }

    static void getTopologicalSort(HashMap<String, Vertex> graph, HashSet<String> visited, Stack<String> stack, String key) {
        if (!visited.contains(key)) {
            if (graph.get(key).descendants.size() == 0) {
                stack.push(key);
                visited.add(key);
            } else {
                for(Vertex descendant: graph.get(key).descendants){
                    if(!visited.contains(descendant.id)){
                        getTopologicalSort(graph, visited, stack, descendant.id);
                    }
                }
                stack.push(key);
                visited.add(key);
            }
        }
    }
}
