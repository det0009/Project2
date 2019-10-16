public class CustomerModel {
    public int mCustomerID;
    public String mName2, mAddress, mPhone, mPaymentInfo;


    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(mCustomerID).append(",");
        sb.append("\"").append(mName2).append("\"").append(",");
        sb.append("\"").append(mAddress).append("\"").append(",");
        sb.append("\"").append(mPhone).append("\"").append(",");
        sb.append("\"").append(mPaymentInfo).append("\"").append(")");
        return sb.toString();
    }
}
