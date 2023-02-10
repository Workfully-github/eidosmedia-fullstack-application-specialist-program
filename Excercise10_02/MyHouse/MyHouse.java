package Excercise10_02.MyHouse;

public class MyHouse {
    int nb_bedRoom;
    String color;
    int nb_beds;
    public MyHouse(int nb_bedRoom, String color, int nb_beds) {
        this.nb_bedRoom = nb_bedRoom;
        this.color = color;
        this.nb_beds = nb_beds;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setNb_bedRoom(int nb_bedRoom, int nb_beds) {
        this.nb_bedRoom = nb_bedRoom;
        this.setNb_beds(nb_beds);
    }

    public void setNb_beds(int nb_beds) {
        this.nb_beds = nb_beds;
    }
    
}
