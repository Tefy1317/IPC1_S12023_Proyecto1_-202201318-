import javax.swing.*;
import java.util.ArrayList;

public class Main{
    public static JFrame frame;
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Kiosco> kioscos = new ArrayList<>();
    public static ArrayList<Regiones> regiones = new ArrayList<>();
    public static ArrayList<Departamentos> departamentos = new ArrayList<>();
    public static ArrayList<Municipios> municipios = new ArrayList<>();
    public static ArrayList<Tarjetas> tarjetas = new ArrayList<>();
    public static ArrayList<DatosFacturacion> datos = new ArrayList<>();


    public static void main(String[]args){

        regiones.add(new Regiones("(M)", "Metropolitana", 35, 25));
        regiones.add(new Regiones("(NT)", "Norte", 68.50, 45.55));
        regiones.add(new Regiones("(NO)", "Nororiente", 58.68, 35.48));
        regiones.add(new Regiones("(SO)", "Suroriente", 38.68, 32.48));
        regiones.add(new Regiones("(SOC)", "Suroccidente", 34.00, 29.00));
        regiones.add(new Regiones("(NOC)", "Noroccidente", 44.50, 40.00));


        frame = new JFrame("USAC-Delivery");
        frame.setContentPane(new Autenticacion().panelAutenticacion);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 1000);
    }
    //Funcion evitar repetidos
    public static boolean evitarrepetidos(String correo){
        for (Cliente cl: clientes){
            if(cl.getCorreo().equals(correo)){
                return true;
            }
        }
        return false;
    }
    public static boolean evitarkioscosrepetidos(String nombrekiosco){
        for (Kiosco k: kioscos){
            if(k.getNombrekiosco().equals(nombrekiosco)){
                return true;
            }
        }
        return false;
    }
    public static boolean evitarcodigokioscosrepetidos(String codigokiosco){
        for (Kiosco k: kioscos){
            if(k.getCodigokiosco().equals(codigokiosco)){
                return true;
            }
        }
        return false;
    }
    public static boolean evitarregionesrepetidas(String codigoregion){
        for (Regiones k: regiones){

            if(k.getCodigoregion().equals(codigoregion)){
                return true;
            }
        }
        return false;
    }
    public static boolean evitardepartamentosrepetidos(String nombredepartamento){
        for (Departamentos dep: departamentos){

            if(dep.getNombredepartamento().equals(nombredepartamento)){
                return true;
            }
        }
        return false;
    }
    public static boolean evitarmunicipiosrepetidos(String nombremunicipio){
        for (Municipios mun: municipios){

            if(mun.getNombremunicipio().equals(nombremunicipio)){
                return true;
            }
        }
        return false;
    }
    public static boolean evitartarjetasrepetidas(String numerotarjeta){
        for (Tarjetas t: tarjetas){

            if(t.getNumerotarjeta().equals(numerotarjeta)){
                return true;
            }
        }
        return false;
    }

}
