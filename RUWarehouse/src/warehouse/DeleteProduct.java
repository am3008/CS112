package warehouse;

/*
 * Use this class to test the deleteProduct method.
 */ 
public class DeleteProduct {
    public static void main(String[] args) {
        StdIn.setFile("deleteproduct.in");
        StdOut.setFile("deleteproduct.out");

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
            else if(query.equals("delete"))
            {
                int id = StdIn.readInt();
                tester.deleteProduct(id);
            }

        }
        StdOut.println(tester);

	// Use this file to test deleteProduct
    }
}
