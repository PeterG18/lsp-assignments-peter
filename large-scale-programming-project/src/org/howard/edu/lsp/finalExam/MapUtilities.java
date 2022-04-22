package org.howard.edu.lsp.finalExam;
import java.util.HashMap;
import java.util.Map;

public class MapUtilities {
public static int commonKeyValuePairs(
HashMap<String, String> map1,
   HashMap<String, String> map2)throws NullMapException {
   int res = 0;
   
   	//checks if hashmap is null
 	if (map1 == null || map2 == null){
 		throw new NullMapException("at least one hashmap is null");
 	}
 	//checks if anyone of the hashmap is empty
 	if (map1.isEmpty() || map2.isEmpty()) {
 		return 0;
 	}
   
   for (Map.Entry<String, String> mapW: map1.entrySet()){
     String x = mapW.getKey();
     String val = mapW.getValue();
     
     if (map2.containsKey(x)){
       String pas2 = map2.get(x);
       if (val.equals(pas2)){
         res++;
       }
     }
   }
   return res;
   

   }
   

   

}
