public class Staff extends Person implements Output{
    static int idStaff = 0;
    static String kind;
    int idEmployee = 0;
    private String position;
    private int salary;
    private final int[] openingHoursStaff = new int[4];
    static { kind="Сотрудники";}
    Staff(){ this.idEmployee = +idStaff;}
    Staff (String lastName, String name, String middleName, String gender, int age,
           String position, int salary, int openingHours, int openingMinutes, int endHours, int endMinutes){
        this.idEmployee = ++idStaff;
        this.setFio(lastName, name, middleName); this.setGender(gender); this.setAge(age);
        this.setPosition(position); this.setSalary(salary);
        this.setOpeningHoursStaff(openingHours, openingMinutes, endHours, endMinutes);
    }

    public void setPosition(String position){ this.position = position;}
    public void setSalary(int salary){ this.salary = salary;}
    public void setOpeningHoursStaff(int openingHours, int openingMinutes, int endHours, int endMinutes)
    { this.openingHoursStaff[0] = openingHours; this.openingHoursStaff[1] = openingMinutes;
        this.openingHoursStaff[2] = endHours; this.openingHoursStaff[3] = endMinutes;}
    public String getPosition(){ return this.position;}
    public double getSalary(){ return this.salary;}
    public int[] getOpeningHours(){ return this.openingHoursStaff;}
    public String getOpeningHoursString(){
        String openingHours = String.valueOf(this.getOpeningHours()[0]);
        String openingMinutes = String.valueOf(this.getOpeningHours()[1]);
        String endHours = String.valueOf(this.getOpeningHours()[2]);
        String endMinutes = String.valueOf(this.getOpeningHours() [3]);
        if(getOpeningHours() [0] < 10) openingHours = "0" + String.valueOf(this.getOpeningHours()[0]);
        if(getOpeningHours()[1] < 10) openingMinutes = "0" + String.valueOf(this.getOpeningHours()[1]);
        if(getOpeningHours() [2] < 10) endHours = "0" + String.valueOf(this.getOpeningHours() [2]);
        if(getOpeningHours() [3] < 10) endMinutes = "0" + String.valueOf(this.getOpeningHours()[3]);
        return openingHours + ":" + openingMinutes + "—" + endHours + ":" + endMinutes; }

    @Override
    public String Output() {
        return "<html>ФИО: " + this.fio[0] + " " + this.fio[1] + " " + this.fio[2] + "<br>Пол: " + this.gender +
                "<br>Возраст: " + this.age + "<br>Должность: " + this.position + "<br>Зарплата: " + this.salary +
                "<br>Время работы: " + this.getOpeningHoursString() + "</html>";
    }
}
