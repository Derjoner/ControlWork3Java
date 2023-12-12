class Menu implements Output{
    String category;
    String nameDish;
    Products[] composition;
    int price;
    Menu(){}
    Menu(String category, String nameDish, Products[] composition, int price){
        this.category = category; this.nameDish = nameDish; this.composition = composition; this.price = price;
    }
    public void setCategory(String category) { this.category = category; }
    public void setNameDish (String nameDish) { this.nameDish = nameDish; }
    public void setComposition (Products[] composition) { this.composition = composition; }
    public void setPrice(int price) { this.price = price; }
    String getCategory(){ return this.category;}
    String getNameDish(){ return this.nameDish; }
    Products[] getComposition(){return this.composition;}
    String getCompositionString(){
        String s=""; int i=0;
        for(Products product : this.composition){
            s+= product.nameProduct+" "; i++;
            if(i == 5){ s+="<br>"; i=0;}
        }
        return s;
    }
    String getCompositionString(int p){
        String s=""; int i=0;
        for(Products product : this.composition){
            s+= product.nameProduct+" ";
        }
        return s;
    }
    int getPrice() {return this.price;}

    @Override
    public String Output() {
        return "<html>Категория: " + this.category + "<br>Название: " + this.nameDish + "<br>Состав: " +
                this.getCompositionString() + "</html>";
    }
}