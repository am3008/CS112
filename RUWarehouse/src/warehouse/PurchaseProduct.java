package warehouse;

public class PurchaseProduct {
    public static void main(String[] args) {
        StdIn.setFile("purchaseproduct.in");
        StdOut.setFile("purchaseproduct.out");

        Warehouse tester = new Warehouse();
        int numQuery = StdIn.readInt();
        for(int i = 0; i < numQuery; i++)
        {
            String query = StdIn.readString();
            
            if(query.equals("add"))
            {
                int day = StdIn.readInt();
                int id = StdIn.readInt();
                String name = StdIn.readString();
                int stock = StdIn.readInt();
                int demand = StdIn.readInt();

                tester.addProduct(id, name, stock, day, demand);
            }
            else if(query.equals("purchase"))
            {
                int day = StdIn.readInt();
                int id = StdIn.readInt();
                int amounpurch = StdIn.readInt();
                tester.purchaseProduct(id, day, amounpurch);
            }

        }
        StdOut.println(tester);

	// Use this file to test purchaseProduct
    }
}
