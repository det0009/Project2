import javax.swing.*;

public class StoreManager {

    public static final String db = "SQLite";
    public static final String path = "C:/Users/dturn/Desktop/COMP3700_Programs/StoreManager/store.db";
    IDataAdapter adapter = null;

    private static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {
        String dbfile = path;
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            dbfile = fc.getSelectedFile().getAbsolutePath();

        instance = new StoreManager(db, dbfile);
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

        adapter.connect(path);
        ProductModel product = adapter.loadProduct(1);

        System.out.println("Loaded product: " + product);

    }


    public IDataAdapter getDataAdapter() {
        return adapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        adapter = a;
    }

    public void run() {
        MainUI ui = new MainUI();
        ui.view.setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("Hello class!");
//        StoreManager.getInstance().init();
        StoreManager.getInstance().run();
    }


}
