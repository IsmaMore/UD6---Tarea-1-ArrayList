public class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String nam, String phN){
        this.name = nam;
        this.phoneNumber = phN;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContacto(String nam, String phN){
        Contacto contacto = new Contacto(nam, phN);
        return contacto;
    }
}
