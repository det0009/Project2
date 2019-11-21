
public class OracleDataAdapter implements IDataAdapter {
    public int connect(String path) {
        //...
        return CONNECTION_OPEN_OK;
    }

    public int disconnect() {
        // ...
        return CONNECTION_CLOSE_OK;

    }

    public ProductModel loadProduct(int id) {
        return null;
    }

    public int saveProduct(ProductModel model) {
        return PRODUCT_SAVED_OK;
    }

    @Override
    public CustomerModel loadCustomer(int id) {
        return null;
    }

    @Override
    public int saveCustomer(CustomerModel model) {
        return CUSTOMER_SAVED_OK;
    }

    @Override
    public PurchaseModel loadPurchase(int id) {
        return null;
    }

    @Override
    public int savePurchase(PurchaseModel model) {
        return PURCHASE_SAVED_OK;
    }


    @Override
    public UserModel loadUser(String username) {
        return null;
    }

    @Override
    public PurchaseListModel loadPurchaseHistory(int customerID) {
        return null;
    }

    @Override
    public ProductListModel searchProduct(String name, double minPrice, double maxPrice) {
        return null;
    }

}
