import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Products implements Output{
        String type;
        String nameProduct;
        double weightProduct;
        int[] deliveryDate = new int[3];
        int[] expirationDate = new int[3];
        Products(){}
        Products(String type, String nameProduct, double weightProduct, int dayDelevery, int monthDelevery, int yearDelevery,
                 int dayExpiration, int monthExpiration, int yearExpiration){
            setType(type); setNameProduct(nameProduct); setWeightProduct (weightProduct);
            setDeliveryDate(dayDelevery, monthDelevery, yearDelevery);
            setExpirationDate(dayExpiration, monthExpiration, yearExpiration);}
            void setType(String type) { this.type = type;}
            void setNameProduct(String nameProduct) { this.nameProduct=nameProduct;}
            void setWeightProduct(double weightProduct){ this.weightProduct = weightProduct;}
            void setDeliveryDate(int dayDelevery, int monthDelevery, int yearDelevery){
                this.deliveryDate[0]= dayDelevery;
                this.deliveryDate[1] = monthDelevery;
                this.deliveryDate [2]= yearDelevery;
            }
    void setExpirationDate (int dayExpiration, int monthExpiration, int yearExpiration){
            this.expirationDate[0] = dayExpiration; this.expirationDate[1] = monthExpiration;
            this.expirationDate [2] = yearExpiration;
    }
    String getType(){ return this.type;}
    String getNameProduct(){ return this.nameProduct;}
    double getWeightProduct() { return this.weightProduct;}
    int[] getDeliveryDate(){ return this.deliveryDate;}
    public String getDeliveryDateString(){
        String day = String.valueOf(this.deliveryDate[0]);
        String month = String.valueOf(this.deliveryDate[1]);
        if(getDeliveryDate()[0] < 10) day = "0" + String.valueOf(this.deliveryDate[0]);
        if(getDeliveryDate() [1] < 10) month = "0" + String.valueOf(this.deliveryDate[1]);
        return day + "." + month + "." + String.valueOf(this.deliveryDate[2]);}
    int[] getExpirationDate(){ return this.expirationDate;}
    public String getExpirationDateString(){
        String day = String.valueOf(this.expirationDate[0]);
        String month = String.valueOf(this.expirationDate[1]);
        if(getExpirationDate()[0] < 10) day = "0" + String.valueOf(this.expirationDate[0]);
        if(getExpirationDate()[1] < 10) month = "0" + String.valueOf(this.expirationDate[1]);
        return day + "." + month + "." + String.valueOf(this.expirationDate [2]);}

    @Override
    public String Output() {
        return "<html>Название: " + nameProduct + "<br>Тип: " + type + "<br>Количество (кг): " + weightProduct +
                "<br>Дата поставки: " + getDeliveryDateString() + "<br>Срок годности: " + getExpirationDateString() +
                "</html>";
    }
    String chekingExpiration(){
        String timeStamp = new SimpleDateFormat("dd.MM.y").format(Calendar.getInstance().getTime());
        String[] ti = timeStamp.split("\\.");
        int day = Integer.parseInt(ti[0]); int month = Integer.parseInt(ti[1]); int year = Integer.parseInt(ti[2]);
            if(this.expirationDate[2] > year || (this.expirationDate[2] == year && this.expirationDate[1]> month) ||
            this.expirationDate[2] == year && this.expirationDate[1] == month && this.expirationDate[0] >= day) return "Не истёк";
            else return "Истёк";
    }
}
