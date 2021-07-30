import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        System.out.println("Hello MyPhone!");
        
        IPhone iPhone = new IPhone("123-456", 6);
        AndroidPhone aPhone = new AndroidPhone("Samsung", "654-3241", 11);
        
        ArrayList<Phone> phones = new ArrayList<Phone>();
        phones.add(iPhone);
        phones.add(aPhone);
        
        for(Phone p : phones) {
            System.out.println(p.toString());
            // if (p instanceof IPhone) {
                p.showBrowser();
            // }
        }
        
//        System.out.println(phone);
//        System.out.println(iPhone);
//        System.out.println(aPhone);
        
//        iPhone.showBrowser();
    }

}
