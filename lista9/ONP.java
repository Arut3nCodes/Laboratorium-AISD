import dataStructures.ArrayStack;

public class ONP {
    String convertToONP(String equation){
        ArrayStack<Character> stack = new ArrayStack<>(10);
        int length = equation.length();
        String product = "";
        for(int i = 0; i < length; i++){
            if(equation.charAt(i) == '('){
                stack.push(equation.charAt(i));
            }

            else if(equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '*' || equation.charAt(i) == '/' || equation.charAt(i) == '%'){
                while(!stack.isEmpty() && priority(stack.top()) >= priority(equation.charAt(i))){
                    String toString = Character.toString(stack.pop());
                    product += " " + toString;
                }
                stack.push(equation.charAt(i));
                //System.out.println(equation.charAt(i));
                product += " ";
            }
            else if(equation.charAt(i) == ')'){
                while(!stack.isEmpty() && stack.top() != '(') {
                    char c = stack.pop();
                    product += " " + Character.toString(c);
                    // System.out.println(product);
                    if(stack.isEmpty()) return "error1";
                }
                char c = stack.pop();
               // System.out.println(Character.toString(c));
            }

            else if(equation.charAt(i) != ' '){
                product += "" + Character.toString(equation.charAt(i));
            }
        }

        while(!stack.isEmpty()){
           // System.out.println(product);
            product += " " + Character.toString(stack.pop());
          //  System.out.println(product);
        }

        if(stack.isEmpty() != true)
            return "error2";

        product.replaceAll("  ", " ");
        return product;
    }

    int priority(char c){
        switch(c){
            case '+':
            case '-': return 1;
            case '*':
            case '/':
            case '%': return 2;
            default: return 0;
        }
    }
}
