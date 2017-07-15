import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*For the given input 
 input:  dict = {
 "Key1" : "1",
 "Key2" : {
 "a" : "2",
 "b" : "3",
 "c" : {
 "d" : "3",
 "e" : "1"
 }
 }
 }

 output should be 

 output: {
 "Key1" : "1",
 "Key2.a" : "2",
 "Key2.b" : "3",
 "Key2.c.d" : "3",
 "Key2.c.e" : "1"
 }
 */
public class FlattenADictionary {

	static HashMap<String, String> output = new HashMap<String, String>();

	static void flattenDictWithVal(HashMap<String, Object> dict, String str) {

		for (Entry<String, Object> entry : dict.entrySet()) {

			String key = str + entry.getKey();
			Object value = entry.getValue();
			if (value instanceof String) {
				output.put(key, (String) value);
			} else {
				flattenDictWithVal((HashMap<String, Object>) value, key + ".");
			}

		}

	}

	static void flattenDict(HashMap<String, Object> dict) {

		flattenDictWithVal(dict, "");

	}

	public static void main(String[] args) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		HashMap<String, Object> map2 = new HashMap<String, Object>();

		map.put("key1", "1");
		map2.put("d", "3");
		map2.put("e", "1");

		map1.put("a", "2");
		map1.put("b", "3");
		map1.put("c", map2);

		map.put("key2", map1);

		flattenDict(map);

		for (Entry<String, String> entry : output.entrySet()) {

			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
