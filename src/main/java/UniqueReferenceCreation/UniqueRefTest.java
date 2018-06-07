package UniqueReferenceCreation;

public class UniqueRefTest {

    public static String createUniqueRef(String IATA, Integer idSource, Integer idDestination, String vehicleLabel){

       String idSourceString = idSource.toString();
       String idDestinationString = idDestination.toString();

        String uniqueRef = String.format("AUTH%s%s-%s-%s",IATA, idSourceString, idDestinationString, vehicleLabel);

        return uniqueRef;
    }

    public static void main (String args[]){
        String IATA = "ADL";
        Integer idSource = 1;
        Integer idDestination = 2;
        String vehicleLabel = "em";
        String uniqueRef = createUniqueRef(IATA,idSource,idDestination,vehicleLabel);
        System.out.println(uniqueRef);
    }
}
