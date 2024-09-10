package ru.itlearn.SpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {
    private ArrayList<String>ArrayList = new ArrayList<>();
    private HashMap<Integer, String>HashMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World")String name){
        return String.format("Hello %s!",name);
    }
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s") String s) {
        if (ArrayList.isEmpty()) {
            ArrayList = new ArrayList<>();
        }
        ArrayList.add(s);
        return "Array updated: " + ArrayList;
    }

    @GetMapping("/show-array")
    public String showArrayList() {
        return "Elements in ArrayList: " + ArrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        // Если HashMap пустой, создаем новый
        if (HashMap.isEmpty()) {
            HashMap = new HashMap<>();
        }
        HashMap.put(HashMap.size() + 1, s);
        return "Map updated: " + HashMap;
    }

    @GetMapping("/show-map")
    public String showHashMap() {
        return "Elements in HashMap: " + HashMap;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        return "ArrayList size: " + ArrayList.size() + ", HashMap size: " + HashMap.size();
    }
}



