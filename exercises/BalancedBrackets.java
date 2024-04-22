import java.util.*;

class Stack {

    public List<Node> nodes = new ArrayList<>();

    private Character leftBracket1 = '{';
    private Character leftBracket2 = '[';
    private Character leftBracket3 = '(';

    private Character rightBracket1 = '}';
    private Character rightBracket2 = ']';
    private Character rightBracket3 = ')';


    public void add(Node node) {
        var currValue = node.value;

        if (nodes.isEmpty() && 
        List.of(leftBracket1, leftBracket2, leftBracket3).contains(currValue)) {
            throw new RuntimeException("Invalid closing bracket direction");
        }
        if (currValue.equals(leftBracket1)) {
            if (!nodes.get(0).value.equals(rightBracket1)) {
                throw new RuntimeException("invalid closing bracket direction");
            }
            nodes.remove(0);
            return;
        }
        if (currValue.equals(leftBracket2)) {
            if (!nodes.get(0).value.equals(rightBracket2)) {
                throw new RuntimeException("invalid closing bracket direction");
            }
            nodes.remove(0);
            return;
        }
        if (currValue.equals(leftBracket3)) {
            if (!nodes.get(0).value.equals(rightBracket3)) {
                throw new RuntimeException("invalid closing bracket direction");
            }
            nodes.remove(0);
            return;
        }
        nodes.add(0, node);
    }

    public Node get() {
        var s = nodes.remove(0);
        return s; 
    }

    public String toString() {
        return nodes.toString();
    }

    public void validDateStack() {
        if (!nodes.isEmpty()) {
            throw new RuntimeException("One or more bracks does not have enclosing");
        }
    }
}

class Node {

    public Character value;

    // public <T> T getParsedValue(Class<T> classType) {
    //     return classType.cast(value);
    // }

    public Node(Character value) {
        this.value = value;
    }

    public String toString() {
        return this.value.toString();
    }
}

public class BalancedBrackets {
    public static void main(String[] args) {
        var s = new BalancedBrackets();
        s.solution(args[0]);
    }

    
    public void solution(String brackets) {

        // {[()]{}}

        char[] bracketsArray = brackets.toCharArray();
        var stack = new Stack();
        for (int i = bracketsArray.length - 1; i >= 0 ; i--) {
            stack.add(new Node(bracketsArray[i]));
        }
        stack.validDateStack();
        System.out.println(brackets);
        System.out.println(stack);
    }
}
