package inventorymanagmentsystem;

/**
 *
 * @author Muhammed
 */
public class wearhouse {

    private String name;
    private String adress;

    public wearhouse(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

}
