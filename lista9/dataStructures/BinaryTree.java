package dataStructures;

import java.util.ArrayList;

public class  BinaryTree<T> {
    private Node root;

    public BinaryTree(String equation){
        ArrayStack<Node> stack = new ArrayStack<>(equation.length());
        System.out.println(equation);
        String[] toPut = equation.split(" ");

        for(int i = 0; i < toPut.length; i++){
            System.out.print(toPut[i] + " ");
        }
        System.out.println();

        for (String s : toPut)
        {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%"))
            {
                Node node = new Node(s);
                node.setRight(stack.pop());
                node.setLeft(stack.pop());
                stack.push(node);
            }
            else {
                stack.push(new Node(s));
            }
        }
        setRoot(stack.pop());
    }

    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    public double wynik(Node node, boolean notZero){
        double product;
        String s = node.getValue();
        notZero = false;

        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%")){
            switch(s){
                case "+": return wynik(node.getLeft(), notZero) + wynik(node.getRight(),notZero);
                case "-": return wynik(node.getLeft(),notZero) - wynik(node.getRight(),notZero);
                case "*": return wynik(node.getLeft(),notZero) * wynik(node.getRight(),notZero);
                case "/": {
                    if(wynik(node.getRight(),notZero) != 0)
                        return wynik(node.getLeft(), notZero) / wynik(node.getRight(),notZero);
                    else{
                        System.out.println("Nie dziel przez 0!");
                        notZero = true;
                        return 0;
                    }
                }
                case "%": {
                    if (wynik(node.getRight(), notZero) != 0)
                        return wynik(node.getLeft(),notZero) % wynik(node.getRight(),notZero);
                    else{
                        System.out.println("Nie dziel przez 0!");
                        notZero = true;
                        return 0;
                    }
                }
            }
        }
        if(notZero != false){
            return 0;
        }
        return Double.parseDouble(s);
    }

    public String inorder(Node node){
        String product = "";
        product += "(";
        if(node.getLeft() != null){
            product += inorder(node.getLeft());
        }
        product += node.getValue();
        if(node.getRight() != null){
            product += inorder(node.getRight());
        }
        product += ")";
        return product;
    }

    public String postorder(Node node){
        String product = "";
        if(node.getLeft() != null){
            product += postorder(node.getLeft());
        }
        if(node.getRight() != null){
            product += postorder(node.getRight());
        }

        product += " " + node.getValue();

        return product;
    }

    public int howManyLeaves(Node node){
    int product = 0;
        if(node.getLeft() != null ||  node.getRight() != null){
            if (node.getLeft() != null) {
                product += howManyLeaves(node.getLeft());
            }
            if (node.getRight() != null) {
                product += howManyLeaves(node.getRight());
            }
        }
        else product++;
        return product;
    }

    public int howManyNodes(Node node){
        int product = 0;
        if (node.getLeft() != null) {
            product += howManyNodes(node.getLeft());
        }
        if (node.getRight() != null) {
               product += howManyNodes(node.getRight());
        }
        product++;
        return product;
    }

    public int treeHeight(Node node){
        int product = 0;
    if(node.getLeft() != null || node.getRight() != null){
        if(node.getLeft() != null && node.getRight() != null){
            product = Integer.max(treeHeight(node.getLeft()) + 1, treeHeight(node.getRight()) + 1);
        }
        else if(node.getLeft() != null) product = treeHeight(node.getLeft()) + 1;
        else if(node.getRight() != null) product = treeHeight(node.getRight()) + 1;
    }
    return product;
    }

    public void wyswietlWszerz(){
        ArrayList<Node> kolejka = new ArrayList<>();
        kolejka.add(getRoot());
        Node node;
        while(!kolejka.isEmpty()){
            node = kolejka.get(0);
            System.out.print(node.getValue() + ", ");
            if(node.getLeft() != null) kolejka.add(node.getLeft());
            if(node.getRight() != null) kolejka.add(node.getRight());
            kolejka.remove(0);
        }
    }
}
