//The parkingspot empties itself  
import java.util.ArrayList;
import java.util.List;
class Parking{
private List<String> spots = new ArrayList<String>();
Parking(){
spots.add("L1-A07");
spots.add("L1-A02");
spots.add("L1-A03");
}
public List<String> getSpots(){
return spots;
}
public List<String> getSafeSpots(){
return List.copyOf(spots);
}
}
class Bug1{
public static void main(String args[]){
Parking p = new Parking();
System.out.println("Initial Spots:"+p.getSpots());
try{
p.getSafeSpots().clear();
}
catch(UnsupportedOperationException e){
System.out.println("Modification failed");
}
System.out.println("Spots:"+p.getSpots());
}
}