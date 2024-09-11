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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Hello %s!\n", name));

        stringBuilder.append(updateArrayList(""));
        stringBuilder.append(showArrayList());
        stringBuilder.append(updateHashMap(""));
        stringBuilder.append(showHashMap());
        stringBuilder.append(showAllLength());
        return stringBuilder.toString();
    }
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s") String s) {
        if (ArrayList.isEmpty()) {
            ArrayList = new ArrayList<>();
        }
        ArrayList.add(s);
        return "Array updated: " + ArrayList + "\n";
    }
    @GetMapping("/show-array")
    public String showArrayList() {
        return "Elements in ArrayList: " + ArrayList + "\n";
    }
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        if (HashMap.isEmpty()) {
            HashMap = new HashMap<>();
        }
        HashMap.put(HashMap.size() + 1, s);
        return "Map updated: " + HashMap + "\n";
    }
    @GetMapping("/show-map")
    public String showHashMap() {
        return "Elements in HashMap: " + HashMap + "\n";
    }
    @GetMapping("/show-all-length")
    public String showAllLength() {
        return "ArrayList size: " + ArrayList.size() + ", HashMap size: " + HashMap.size() + "\n";
    }
}