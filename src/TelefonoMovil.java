import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts = new ArrayList<Contacto>();

    public TelefonoMovil(String myN){
        this.myNumber = myN;
        myContacts.add(new Contacto("Yo", myN));
    }

    private int findContact(Contacto con){
        if (myContacts.contains(con)){
            return myContacts.indexOf(con);
        }else {
            return -1;
        }
    }

    private int findContact(String nam){
        for (int i = 0; i < myContacts.size(); i++){
            if (myContacts.get(i).getName().equalsIgnoreCase(nam)){
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact(Contacto con){
        if (findContact(con.getName()) >= 0){
            return false;
        }
        myContacts.add(con);
        return true;
    }

    public boolean updateContact(Contacto old, Contacto neww){
        int i = findContact(old);
        if (i >= 0){
            myContacts.set(i, neww);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contacto con){
        int i = findContact(con);
        if (i >= 0){
            myContacts.remove(i);
            return true;
        }
        return false;
    }

    public Contacto queryContact(String nam){
        int i = findContact(nam);
        if (i >= 0){
            return myContacts.get(i);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Lista de contactos:");
        for (int i = 0; i < myContacts.size(); i++){
            System.out.println((i+1) + ". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}

