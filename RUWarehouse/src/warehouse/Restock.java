package warehouse;

public class Restock {
    public static void main(String[] args) {
        StdIn.setFile("restock.in");
        StdOut.setFile("restock.out");

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

        }
        StdOut.println(tester);

	// Uset his file to test restock
    }
}
