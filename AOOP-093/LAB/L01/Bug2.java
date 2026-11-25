import java.util.*;
class ParkingSpot{
String id;
ParkingSpot(String id){
this.id=id;
}
@Override
public boolean equals(Object o){
if(this==o)
return true;
if(!(o instanceof ParkingSpot))
return false;
ParkingSpot s=(ParkingSpot)o;
return id.equals(s.id);
}
@Override
public int hashCode(){
return id.hashCode();
}
}
public class Bug2{
public static void main(String[] args){
Set<ParkingSpot> spots=new HashSet<>();
ParkingSpot s1=new ParkingSpot("L1-A01");
ParkingSpot s2=new ParkingSpot("L1-A01");
if(spots.add(s1)){
System.out.println("L1-A01 added successfully");
}
else{
System.out.println("L1-A01 Rejected");
}
if(spots.add(s2)){
System.out.println("L1-A01 added successfully");
}
else{
System.out.println("L1-A01 Rejected");
}
System.out.println("Spots:"+spots.size());
}
}