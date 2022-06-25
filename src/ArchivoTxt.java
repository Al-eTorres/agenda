import java.io.*;
import java.util.ArrayList;

public class ArchivoTxt {

    ArrayList<String> listaContactos = new ArrayList<>();

    public ArchivoTxt() {
    }

    public void encuentraCont (ArrayList<String> a){

        for (int i = 0; i < a.size();i++){
            String encontrado = a.get(i);
            System.out.println(encontrado);

        }
    }

    public ArrayList<String> leeArchivo() {

        try {
            FileReader lee = new FileReader("C:\\Users\\Ale\\IdeaProjects\\Agenda\\agendados.txt");
            BufferedReader buffer = new BufferedReader(lee);

            String linea = "";
            while (linea != null) {
                linea = buffer.readLine();
                if (linea != null) {
                    listaContactos.add(linea);
                }
            }
            lee.close();
        } catch (IOException e) {
            System.out.println("No se encontró archivo");
            e.printStackTrace();
        }
        return listaContactos;
    }

    public void escribiendoTxt(Contacto c){

        String nombre = c.getNombre();
        String apellido = c.getApellido();
        String telefono = c.getTelefono();

        try{
            FileWriter escribe = new FileWriter("agendados.txt",true);

            escribe.write("\n"+nombre+" "+apellido+"  Teléfono: "+telefono);
            escribe.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}




