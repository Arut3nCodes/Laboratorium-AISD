import dataStructures.BinaryTree;
public class Main {
    public static void main(String[] args){
        // rownania do wklejenia : |  ((4+3)-(2+1)*2+3)/2 | "12+(3*2+6)" |
        String rownanie = "((4+3)-(2+1)*2+3)/2";
        ONP onp = new ONP();
        String onps = onp.convertToONP(rownanie);
        System.out.println(onps);
        BinaryTree<String> bt = new BinaryTree<>(onps);
        System.out.println("Wynik dzialania: " + bt.wynik(bt.getRoot(), false));
        System.out.println("Infiks: " + bt.inorder(bt.getRoot()));
        System.out.println("Postfiks:" + bt.postorder(bt.getRoot()));
        System.out.println("Ilosc lisci: " + bt.howManyLeaves(bt.getRoot()));
        System.out.println("Ilosc wezlow: " + bt.howManyNodes(bt.getRoot()));
        System.out.println("Wysokosc drzewa: " + bt.treeHeight(bt.getRoot()));
        System.out.print("Drzewo binarne odczytywane wszerz: ");
        bt.wyswietlWszerz();
    }
}
