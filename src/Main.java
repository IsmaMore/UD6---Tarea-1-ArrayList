import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void imprimirMenu() {
        System.out.println("-----------------MENÚ------------------");
        System.out.println("0 - Para salir");
        System.out.println("1 - Para imprimir contactos");
        System.out.println("2 - Para añadir nuevo contacto");
        System.out.println("3 - Para actualizar contacto existente");
        System.out.println("4 - Para eliminar contacto");
        System.out.println("5 - Para buscar contacto por nombre");
        System.out.println("6 - Para volver a mostrar el menú");
        System.out.print("--> ");
    }

    public static int leerInt(){
        Scanner sc = new Scanner(System.in);
        int i;
        while (true) {
            try {
                i = sc.nextInt();
                return i;
            } catch (InputMismatchException e) {
                System.out.println("Error: No es válido.");
                imprimirMenu();
                sc.nextLine();
            }
        }
    }

    public static String leerTelefono(){
        Scanner sc3 = new Scanner(System.in);
        String text;
        String number;

        while (true) {
            System.out.print("Teléfono del contacto: ");
            text = sc3.nextLine();
            if (text.matches("[0-9]+") && text.length() == 9) {
                number = text;
                return number;
            } else {
                System.out.println("Error: Teléfono no válido.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int opcion;
        TelefonoMovil telefonoMovil = new TelefonoMovil("722126195");
        Contacto contacto, contactoOld;
        String nombre, telefono;

        do {
            imprimirMenu();
            opcion = leerInt();
            switch (opcion){
                case 0:
                    break;
                case 1:
                    telefonoMovil.printContacts();
                    break;
                case 2:
                    System.out.print("Nombre del contacto: ");
                    nombre = sc1.nextLine();
                    telefono = leerTelefono();
                    contacto = Contacto.createContacto(nombre, telefono);
                    if (telefonoMovil.addNewContact(contacto)){
                        System.out.println("Se ha añadido el contacto correctamente.");
                    }else {
                        System.out.println("No se ha podido añadir el contacto. ");
                    }
                    break;
                case 3:
                    System.out.print("Nombre del contacto que quieres actualizar: ");
                    nombre = sc1.nextLine();
                    contactoOld = telefonoMovil.queryContact(nombre);
                    if (contactoOld != null){
                        System.out.print("El contacto se encuentra en la agenda." + "\n" + "Nombre del nuevo contacto a sustituir: ");
                        nombre = sc1.nextLine();
                        telefono = leerTelefono();
                        contacto = Contacto.createContacto(nombre, telefono);
                        telefonoMovil.updateContact(contactoOld, contacto);
                    }else {
                        System.out.println("No se ha encontrado el contacto en la agenda.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre del contacto que quieres eliminar: ");
                    nombre = sc1.nextLine();
                    contacto = telefonoMovil.queryContact(nombre);
                    if (contacto != null){
                        if (telefonoMovil.removeContact(contacto)){
                            System.out.println("El cantacto ha sido elininado correctamente.");
                        }else {
                            System.out.println("No se ha podido eliminar el contacto.");
                        }
                    }else {
                        System.out.println("No se ha encontrado el contacto en la agenda.");
                    }
                    break;
                case 5:
                    System.out.print("Nombre del contacto que quieres buscar: ");
                    nombre = sc1.nextLine();
                    contacto = telefonoMovil.queryContact(nombre);
                    if (contacto != null){
                        System.out.println("Nombre: " + contacto.getName() + "\n" + "Número de teléfono: " + contacto.getPhoneNumber());
                    }else {
                        System.out.println("No se ha encontrado el contacto en la agenda.");
                    }
                    break;
            }
            if (opcion < 0 || opcion > 6){
                System.out.println("Error: La opción no aparece en el menú.");
            }
        }while (opcion != 0);
    }
}
