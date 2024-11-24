public class Product {

    String name;
    String size;
    int SNumber;
    boolean isDamaged;
    int status;
    int price;
    int[] priceHistory = new int[100];
    int priceHistoryNumber = 0;

    public Product(String name, String size, int SNumber, boolean isDamaged, int status, int price) {
        setName(name);
        setSize(size);
        setSNumber(SNumber);
        setDamaged(isDamaged);
        setStatus(status);
        setPrice(price);
    }

    Product(){

    }

    public String returnHistory(){
        String a = "";
        for(int i = 0;i<priceHistoryNumber;i++){
            if(i == priceHistoryNumber-1) a = a + priceHistory[i];
            else {
                a = a + priceHistory[i] + " -> ";
            }
        }
       // a = a + "\n" + priceHistoryNumber;
        return a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSNumber() {
        return SNumber;
    }

    public void setSNumber(int SNumber) {
        this.SNumber = SNumber;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int[] getPriceHistory() {
        return priceHistory;
    }


}
