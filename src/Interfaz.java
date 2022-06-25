import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Interfaz extends JFrame {
    private JLabel txtAgregar;
    private JLabel txtBuscar;
    private JLabel txtNombre;
    private JLabel txtApellido;
    private JLabel txtTelefono;
    private JLabel nuevo;
    private JPanel panel;
    private JTextArea areaDeLista;
    private JButton buscando;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel panelBuscar;
    private JTextField aBuscar;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField telefono;
    private JPanel panelAgregar;


    Agenda agenda = new Agenda();
    ArchivoTxt ar = new ArchivoTxt();
    public Interfaz() {
        setSize(300 , 500); // establece tamaño de ventana (JFrame)
        setTitle("Agenda"); // establece titulo de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);// para finalizar el programa.
        setResizable(false);
        setLocationRelativeTo(null);
        panelPrincipal();

    }


    public void panelPrincipal () {
        panel = new JPanel(); // se crea objeto panel.
        panel.setBackground(Color.LIGHT_GRAY); // establece color del panel. debe comenzar en mayuscula.
        panel.setLayout(null); // desactivo el layout (diseño) por defcto qe trae.
        getContentPane().add(panel); // agregamos el panel a la ventana (jframe).


        // etiquetas para ingresar texto
        JLabel etiqueta = new JLabel("Contactos"); // creacion de objeto tipo etiqueta.

        // realiza lo mismo qe con el panel pero debo desactivar el layout por defecto del panel
        etiqueta.setBounds(95 , 125 , 100 , 20);

        etiqueta.setForeground(Color.BLACK); // color de la letra.

        // se establece un tipo de fuente. para ello debemos qe crear un objeto font con ..
        // alguno de sus constructores, en este caso le pasamos 3 parametros. fuente,estilo y tamaño.
        etiqueta.setFont(new Font("Comic Sans" , Font.BOLD , 20));

        panel.add(etiqueta); // agrego la etiqueta al panel.

        // imagen de persona
        ImageIcon imagen1 = new ImageIcon("iconos/Contacto.png"); // creo objeto icon
        JLabel etiquetaImg = new JLabel();  // y creo la etiqueta por separado
        etiquetaImg.setBounds(105 , 25 , 100 , 100);

            /* la linea siguiente es para establecer la imagen creada dentro de la etiqueta pero con
                una redefinicion de tamaño  */
        etiquetaImg.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(80 , 80 , Image.SCALE_SMOOTH)));
        panel.add(etiquetaImg);


        // label con imagen
        txtAgregar = new JLabel();
        ImageIcon imgtxtAgregar = new ImageIcon("iconos/anadir-amigo.png"); // creo objeto icon
        txtAgregar.setBounds(207 , 150 , 30 , 30);

            /* los metodos getWidth y getHeight obtienen el ancho y alto declarado en setbounds para
                redimensionar la imagen a ese tamaño. es otra opcion en vez de ingresarlos en pixeles */
        txtAgregar.setIcon(new ImageIcon(imgtxtAgregar.getImage().getScaledInstance(txtAgregar.getWidth() - 5 , txtAgregar.getHeight() - 5 , Image.SCALE_SMOOTH)));
        panel.add(txtAgregar);


        panelBuscar = new JPanel();
        panelBuscar.setBackground(Color.WHITE);
        panelBuscar.setBounds(35 , 183 , 213 , 40);
        panelBuscar.setLayout(null);

        aBuscar = new JTextField();
        aBuscar.setBounds(10 , 8 , 150 , 25);
        //aBuscar.setText("Introducir nombre: ");
        panelBuscar.add(aBuscar);

        buscando = new JButton();
        ImageIcon labelBuscar = new ImageIcon("iconos/buscar.png"); // creo objeto icon
        buscando.setBounds(170 , 8 , 25 , 25);
        buscando.setIcon(new ImageIcon(labelBuscar.getImage().getScaledInstance(buscando.getWidth() - 7 , buscando.getHeight() - 7 , Image.SCALE_SMOOTH)));
        panelBuscar.add(buscando);

        panel.add(panelBuscar); // agrego el panel al panel principal.


        panelAgregar = new JPanel();
        panelAgregar.setBackground(Color.WHITE);
        panelAgregar.setBounds(35 , 220 , 213 , 210);
        panelAgregar.setLayout(null);

        // este label puede ir o no.
        nuevo = new JLabel("Nuevo contacto");
        nuevo.setBounds(85 , 183 , 213 , 40);
        nuevo.setFont(new Font("Comic sans" , Font.ITALIC , 12));
        panel.add(nuevo);

        txtNombre = new JLabel("Nombre");
        txtNombre.setBounds(20 , 25 , 150 , 25);
        panelAgregar.add(txtNombre);

        nombre = new JTextField();
        nombre.setBounds(20 , 45 , 170 , 25);

        panelAgregar.add(nombre);

        txtApellido = new JLabel("Apellido");
        txtApellido.setBounds(20 , 70 , 150 , 25);
        panelAgregar.add(txtApellido);

        apellido = new JTextField();
        apellido.setBounds(20 , 90 , 170 , 25);

        panelAgregar.add(apellido);

        txtTelefono = new JLabel("Teléfono");
        txtTelefono.setBounds(20 , 120 , 150 , 25);
        panelAgregar.add(txtTelefono);

        telefono = new JTextField();
        telefono.setBounds(20 , 140 , 170 , 25);

        panelAgregar.add(telefono);

        btnEliminar = new JButton();
        ImageIcon labelEliminar = new ImageIcon("iconos/eliminar.png"); // creo objeto icon
        btnEliminar.setBounds(180 , 5 , 25 , 25);
        btnEliminar.setIcon(new ImageIcon(labelEliminar.getImage().getScaledInstance(btnEliminar.getWidth() - 7 , btnEliminar.getHeight() - 7 , Image.SCALE_SMOOTH)));
        panelAgregar.add(btnEliminar);


        btnEditar = new JButton();
        ImageIcon labelEditar = new ImageIcon("iconos/editar-texto.png"); // creo objeto icon
        btnEditar.setBounds(150 , 5 , 25 , 25);
        btnEditar.setIcon(new ImageIcon(labelEditar.getImage().getScaledInstance(btnEditar.getWidth() - 7 , btnEditar.getHeight() - 7 , Image.SCALE_SMOOTH)));
        panelAgregar.add(btnEditar);


        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20 , 180 , 80 , 25);
        btnGuardar.setFont(new Font("Comic sans" , Font.BOLD , 10));
        panelAgregar.add(btnGuardar);


        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(110 , 180 , 80 , 25);
        btnCancelar.setFont(new Font("Comic sans" , Font.BOLD , 10));
        panelAgregar.add(btnCancelar);
        panelAgregar.setVisible(false);

        panel.add(panelAgregar); // agregamos el panel al panel principal.


        areaDeLista = new JTextArea();
        areaDeLista.setBackground(Color.WHITE);
        areaDeLista.setBounds(35 , 220 , 213 , 220);
        areaDeLista.setFont(new Font("Comic Sans" , Font.BOLD , 18));
        areaDeLista.setLayout(null);
        areaDeLista.setVisible(true);

        panel.add(areaDeLista);


    }
    public void eventoAgregar() {
        MouseListener agregando = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelAgregar.setVisible(true);
                aBuscar.setEnabled(false);

                ImageIcon imgtxtAgregar = new ImageIcon("iconos/Contacto.png"); // creo objeto icon
                txtAgregar.setBounds(40,150,30,30);
                txtAgregar.setIcon(new ImageIcon(imgtxtAgregar.getImage().getScaledInstance(txtAgregar.getWidth()-5,txtAgregar.getHeight()-5,Image.SCALE_SMOOTH)));
                panel.add(txtAgregar);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        txtAgregar.addMouseListener(agregando);

    }

    public ArrayList<Contacto> arrayContactos = new ArrayList<>();

    public void eventoGuardar() {
        MouseListener guardado = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {

                areaDeLista.setVisible(true);
                panelAgregar.setVisible(false);

                Contacto contact = new Contacto(nombre.getText() , apellido.getText() , telefono.getText());
                arrayContactos.add(contact);

                ar.escribiendoTxt(contact);

                agenda.escribiendoXml(arrayContactos);
                areaDeLista.append(contact.muestraContacto());

                nombre.setText("");
                apellido.setText("");
                telefono.setText("");

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        btnGuardar.addMouseListener(guardado);

    }


    public void mostrarContactoEnPanel( Contacto c){

        areaDeLista.append("\n@ "+c.getNombre()+" "+c.getApellido());
        areaDeLista.setEditable(false);

    }

    public void eventoBuscar() {
        MouseListener busqueda = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                }
            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        buscando.addMouseListener(busqueda);

    }
}
