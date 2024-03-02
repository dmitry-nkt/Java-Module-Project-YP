public class Calculator {
    private double allProductPrice = 0.00;

    public double getAllProductPrice() {
        return allProductPrice;
    }

    int guestNumber;

    String guestBill;
    public void setAllProductPrice(double productPrice) {
        allProductPrice +=productPrice;
    }


    public String getGuestBill(int enterGuestNumber) {
        guestNumber = enterGuestNumber;
        guestBill = String.format("%.2f", allProductPrice /guestNumber);
        return guestBill;
    }

}
