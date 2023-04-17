package warehouse;

/*
 * Use this class to test the betterAddProduct method.
 */ 
public class BetterAddProduct {
    public static void main(String[] args) {
        StdIn.setFile("betteraddproduct.in");
        StdOut.setFile("betteraddproduct.out");

        Warehouse tester = new Warehouse();
        int numProducts = StdIn.readInt();
        for(int i = 0; i < numProducts; i++)
        {
            int day = StdIn.readInt();
            int id = StdIn.readInt();
            String name = StdIn.readString();
            int stock = StdIn.readInt();
            int demand = StdIn.readInt();

            tester.betterAddProduct(id, name, stock, day, demand);
        }
        StdOut.println(tester);

        
        // Use this file to test betterAddProduct
    }
}
