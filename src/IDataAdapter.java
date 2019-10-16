
public interface IDataAdapter {

    public static final int CONNECTION_OPEN_OK = 100;
    public static final int CONNECTION_OPEN_FAILED = 101;

    public static final int CONNECTION_CLOSE_OK = 200;
    public static final int CONNECTION_CLOSE_FAILED = 201;

    public static final int PRODUCT_SAVED_OK = 0;
    public static final int PRODUCT_DUPLICATE_ERROR = 1;

    public static final int PURCHASE_SAVED_OK = 500;
    public static final int PURCHASE_DUPLICATE_ERROR = 501;

    public int connect(String path);
    public int disconnect();

    public ProductModel loadProduct(int id);
    public int saveProduct(ProductModel p_model);

    public CustomerModel loadCustomer(int id);
    public int saveCustomer(CustomerModel c_model);

//    public int loadCustomer(int id);
//    public int saveCustomer(CustomerModel model);
//
//    public int loadPurchase(int id);
    public int savePurchase(PurchaseModel model);
}
