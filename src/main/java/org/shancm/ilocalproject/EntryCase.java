package org.shancm.ilocalproject;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class EntryCase {

    public static void main(String[] args) throws ParseException {
		/*Map<String, String> map = new HashMap<>();
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		Set<Entry<String, String>> entries = map.entrySet();
		for(Entry entry:entries) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}*/

        String time = "20171212151300";
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
//        System.out.println(format.parse(time));


        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.forEach(n -> System.out.println(n));


    }
}
