package webapp;

/**
 * Created by AnaBelén on 24/01/2017.
 */
public class ProductBean {
	private int productId;
	private int userId;
    private String product;
    private String description;
    private float price;
    
    
    public int getProductId() {
        return productId;
    }
    public void setProductId (int newProductId) {
        productId = newProductId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int newId) {
        userId = newId;
    }
    public String getProduct() {
        return product;
    }
    public void setProduct (String newProduct) {
        product = newProduct;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String newDescription) {
        description = newDescription;
    }
    public float getPrice(){
    	return price;
    }
    public void setPrice(float newPrice){
    	price = newPrice;
    }
    
    
}