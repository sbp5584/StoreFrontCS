package CampingStore242;

/**Defines store
 *
 */
public class Store {


    private Object lastName;

    public int getStoreId() {

        return storeId;

    }

    public void setStoreId(int iStore) {

        storeId = iStore;

    }

    public void setStoreName(String sname) {

        storename = sname;

    }

    public void StoreId(int storeId) {

        this.storeId = storeId;

    }

    public String getStorename() {

        return storename;

    }

    public void setStorename(String camping_store) {

        this.storename = camping_store;
    }

    public String Str() {
        return storename;
    }

    private int storeId;

    private String storename; //class level variable


    public Store(int sId) {

        storeId = sId;

    }

    public Store(String storename, String lastName, String email, String phoneNumber) {

        this.storename = storename;

    }

    public Store(int sId, String sname) {

        storeId = sId;

        storename = sname;

    }

}