public class Person implements Output{
    static int idPerson;
    static String kind;
    String[] fio = new String[3];
    String gender;
    int age;
    static {kind = "Человек";}
    public void setFio(String lastName, String name, String middleName){
        this.fio[0] = lastName;
        this.fio[1] = name;
        this.fio[2] = middleName;
    }
    public void setGender(String gender){ this.gender =gender;}
    public void setAge(int age){this.age = age;}
    public final String[] getFio(){ return this.fio;}
    public final String getGender(){ return this.gender;}
    public final int getAge(){ return this.age;}
    @Override
    public String Output() {
        return null;
    }
}
