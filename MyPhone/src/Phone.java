
public abstract class Phone {
    private String _company;
    private String _phoneNumber;
    private int _screen;
    
    public Phone(String company, String phoneNumber, int screen) {
        _company = company;
        _phoneNumber = phoneNumber;
        _screen = screen;
    }
    
    public String toString() {
        return String.format("Company:%s, Phone#:%s, Screen:%d\"", _company, _phoneNumber, _screen);
    }
    
    public abstract void showBrowser();
}
