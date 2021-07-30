
public class IPhone extends Phone {

    public IPhone(String phoneNumber, int screen) {
        super("Apple", phoneNumber, screen);
    }
    
    public void showBrowser() {
        System.out.println("browser is Safari");
    }

}
