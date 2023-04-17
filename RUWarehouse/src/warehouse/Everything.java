package warehouse;

/*
 * Use this class to put it all together.
 */ 
public class Everything {
    public static void main(String[] args) {
        StdIn.setFile("everything.in");
        StdOut.setFile("everything.out");

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
            else if(query.equals("restock"))
            {
                int id = StdIn.readInt();
                int addStock = StdIn.readInt();
                tester.restockProduct(id,addStock);
            }
            else if(query.equals("purchase"))
            {
                int day = StdIn.readInt();
                int id = StdIn.readInt();
                int amounpurch = StdIn.readInt();
                tester.purchaseProduct(id, day, amounpurch);
            }
            else if(query.equals("delete"))
            {
                int id = StdIn.readInt();
                tester.deleteProduct(id);
            }
        }
        StdOut.println(tester);

	// Use this file to test all methods
    }
}
