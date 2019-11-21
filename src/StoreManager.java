import javax.swing.*;

public class StoreManager {

    public static  String db = "Network";
    public static  String path = "localhost:1000";
    IDataAdapter adapter = null;

    private static StoreManager instance = null;

    public static StoreManager getInstance() {
       if (instance == null) {
        instance = new StoreManager(db, path);
    }
        return instance;
}


   /* public static StoreManager getInstance(String db, String path) {
        if (instance == null) {

            String dbfile = path;
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                dbfile = fc.getSelectedFile().getAbsolutePath();

            instance = new StoreManager(db, dbfile);
        }
        return instance;
    }*/
    private StoreManager(String db, String path) {
        if (db.equals("Oracle"))
            adapter = new OracleDataAdapter();
        else
        if (db.equals("SQLite"))
            adapter = new SQLiteDataAdapter();
        else
        if (db.equals("Network"))
            adapter= new NetworkDataAdapter();

        adapter.connect(path);
       // adapter.connect(path);
        //ProductModel product = adapter.loadProduct(1);

        //System.out.println("Loaded product: " + product);

    }


    public IDataAdapter getDataAdapter() {
        return adapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        adapter = a;
    }

    public void run() {
        LoginUI ui = new LoginUI();
        ui.view.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello class!");
        if (args.length > 0) { // having runtime arguments
            db = args[0];
            if (args.length == 1) { // do not have 2nd arguments for dbfile
                if (db.equals("SQLite")) {
                    JFileChooser fc = new JFileChooser();
                    if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                        path = fc.getSelectedFile().getAbsolutePath();
                }
                else
                    path = JOptionPane.showInputDialog("Enter address of database server as host:port");
            }
            else
                path = args[1];
        }
        StoreManager.getInstance().run();
    }


}
