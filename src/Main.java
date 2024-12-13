import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Main {
    private static final String FITXER_INDIVIDUAL = "Fitxers/ordinador.json";
    private static final String FITXER_LLISTA = "Fitxers/ordinadors.json";
    public static void main(String[] args) {
        File directory = new File("Fitxers");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        OrdinadorLogic ordinadorLogic = new OrdinadorLogic();
        try {
            Ordinador ordinador = new Ordinador(1, "Asus", "Vivobook", 8, 1000, "Intel Core i7-9700K");
            
            List<Ordinador> ordinadors = new ArrayList<>();
            ordinadors.add(ordinador);
            ordinadors.add(new Ordinador(2, "MSI", "Katana", 32, 256, "Inter Core i9-9900K"));
            ordinadors.add(new Ordinador(3, "Acer", "Predator", 64, 512, "AMD Ryzen 9 3950X"));

            String jsonOrdinador = ordinadorLogic.serializeOrdinador(ordinador);
            ordinadorLogic.writeToFile(FITXER_INDIVIDUAL, jsonOrdinador);

            String jsonOrdinadors = ordinadorLogic.serializeOrdinadors(ordinadors);
            ordinadorLogic.writeToFile(FITXER_LLISTA, jsonOrdinadors);

            String jsonOrdinadorFromFile = ordinadorLogic.readFromFile(FITXER_INDIVIDUAL);
            Ordinador deserializeOrdinador = ordinadorLogic.deserializeOrdinador(jsonOrdinadorFromFile);
            System.out.println("Ordinador:");
            System.out.println(deserializeOrdinador);

            String jsonOrdinadorsFromFile = ordinadorLogic.readFromFile(FITXER_LLISTA);
            List<Ordinador> deserializeOrdinadors = ordinadorLogic.deserializeOrdinadors(jsonOrdinadorsFromFile);
            System.out.println("Llista d'ordinadors:");
            for (Ordinador it : deserializeOrdinadors) {
                System.out.println(it);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}