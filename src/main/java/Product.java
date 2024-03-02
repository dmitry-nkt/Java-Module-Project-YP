import static java.lang.Math.floor;

import java.util.ArrayList;

public class Product {
    private String productName;
    private double productPrice;
    String rublesName;

    public void setProductPrice(String price) throws NumberFormatException {
        this.productPrice = Double.parseDouble(price);
    }
    public void setProductName(String name) {
        this.productName = name;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public String getProductInfo() {
        if (floor(productPrice) > 4 && floor(productPrice) < 21 || ((floor(productPrice)/10)%10) > 4 && ((floor(productPrice)/10)%10) < 10 || ((floor(productPrice)/10)%10) == 0 ) {
            rublesName = "рублей";
        } else if ( ((floor(productPrice)/10)%10) == 1 || floor(productPrice) == 1) {
            rublesName = "рубль";
        } else if ( ((floor(productPrice)/10)%10) > 1 && ((floor(productPrice)/10)%10) < 5 || floor(productPrice) > 1 && floor(productPrice) < 5) {
            rublesName = "рубля";
        }

        return this.productName + " " + String.format("%.2f", this.productPrice) + " " + rublesName;
    }
}
