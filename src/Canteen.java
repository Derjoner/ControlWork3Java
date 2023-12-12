import java.util.ArrayList;

public class Canteen implements Output{
    static int idCanteens = 0;
    int idCanteen = 0;
    private String nameCanteen;
    private final int[] dateCreation = new int[3];
    private final int[] openingHoursCanteen = new int[4];
    private final ArrayList<Products> listProdict = new ArrayList<>();
    private final ArrayList<Staff> listStaff = new ArrayList<>();
    private final ArrayList<Menu> listMenu = new ArrayList<>();

    Canteen(){}
    Canteen(String nameCanteen, int day, int month, int year, int openingHours,
            int openingMinutes, int endHours, int endMinutes){
        this.idCanteen = idCanteens++; this.nameCanteen = nameCanteen;
        this.dateCreation[0] = day; this.dateCreation[1] = month; this.dateCreation[2] = year;
        this.openingHoursCanteen[0] = openingHours; this.openingHoursCanteen[1] = openingMinutes;
        this.openingHoursCanteen[2] = endHours; this.openingHoursCanteen[3] = endMinutes;
    }
    void setNameCanteen(String nameCanteen){ this.nameCanteen = nameCanteen;}
    void setDateCreation(int day, int month, int year){
        this.dateCreation[0] = day;
        this.dateCreation[1] = month;
        this.dateCreation[2] = year;
    }
    void setOpeningHoursCanteen(int openingHours, int openingMinutes, int endHours, int endMinutes){
        this.openingHoursCanteen[0] = openingHours;
        this.openingHoursCanteen[1] = openingMinutes;
        this.openingHoursCanteen[2] = endHours;
        this.openingHoursCanteen[3] = endMinutes;
    }
    String getNameCanteen(){return this.nameCanteen;}
    int[] getDateCreation(){ return this.dateCreation;}
    public String getDateCreationString(){
        String day = String.valueOf(this.dateCreation[0]);
        String month = String.valueOf(this.dateCreation[1]);
        if(getDateCreation()[0] < 10) day = "0" + String.valueOf(this.dateCreation[0]);
        if(getDateCreation()[1] < 10) month = "0" + String.valueOf(this.dateCreation[1]);
        return day + "." + month + "." + String.valueOf(this.dateCreation[2]);
    }

    public int[] getOpeningHoursCanteen(){ return this.openingHoursCanteen;}
    String getOpeningHoursCanteenString(){
        String openingHours = String.valueOf(this.getOpeningHoursCanteen()[0]);
        String openingMinutes = String.valueOf(this.getOpeningHoursCanteen()[1]);
        String endHours = String.valueOf(this.getOpeningHoursCanteen()[2]);
        String endMinutes = String.valueOf(this.getOpeningHoursCanteen()[3]);
        if(getOpeningHoursCanteen()[0] < 10) openingHours = "0" + openingHours;
        if(getOpeningHoursCanteen()[1] < 10) openingMinutes = "0" + openingMinutes;
        if(getOpeningHoursCanteen()[2] < 10) endHours = "0" + endHours;
        if(getOpeningHoursCanteen()[3] < 10) endMinutes = "0" + endMinutes;
        return openingHours + ":" + openingMinutes + "—" + endHours + ":" + endMinutes;
    }
    public String Output(){
        return "<html>Идентификатор: " + idCanteen + "<br>Столовая: " + this.nameCanteen + "<br>" +
                "Дата создания: " + getDateCreationString() + "<br>Время работы: " + this.getOpeningHoursCanteenString()+"</html>";
    }
    public String toString(){
        return this.idCanteen + ";" + this.nameCanteen + ";" +
                this.dateCreation[0] + this.dateCreation[1] + this.dateCreation[2] + ";" +
                this.openingHoursCanteen[0] + this.openingHoursCanteen[1] + ";" +
                this.openingHoursCanteen[2] + ";" + this.openingHoursCanteen[3] + "\n";
    }
    String time(int hours, int minutes){
        if(hours > this.openingHoursCanteen[0] && hours< openingHoursCanteen[2] ||
                (minutes <= this.openingHoursCanteen[3] && hours == openingHoursCanteen[2]) ||
                (minutes <= this.openingHoursCanteen[1] && hours == this.openingHoursCanteen[0]))
            return "Столовая сейчас открыта!";
        else return "Столовая сейчас закрыта!";
    }
    void addProduct(Products product){
        this.listProdict.add(product);
    }
    ArrayList<Products> getProducts(){ return this.listProdict;}
    void removeProduct(Products product){ this.listProdict.remove(product);}
    void addStaff(Staff staff){this.listStaff.add(staff);}
    ArrayList<Staff> getStaff(){ return this.listStaff;}
    void removeStaff(Staff staff){ this.listStaff.remove(staff);}
    void addMenu(Menu menu){this.listMenu.add(menu);}
    ArrayList<Menu> getMenu(){ return this.listMenu;}
    void removeMenu(Menu menu){ this.listMenu.remove(menu);}
}
