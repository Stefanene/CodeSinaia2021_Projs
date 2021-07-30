
public class AndroidPhone extends Phone {
    private boolean _alwaysOnDisplay;

    public AndroidPhone(String company, String phoneNumber, int screen) {
        super(company, phoneNumber, screen);
        _alwaysOnDisplay = false;
    }

    @Override
    public String toString() {
        String output = super.toString();
        output += String.format(" AlwayOn = [%s]", (_alwaysOnDisplay ? "on" : "off"));
        return output;
    }

    @Override
    public void showBrowser() {
        // TODO Auto-generated method stub
        
    }

}
