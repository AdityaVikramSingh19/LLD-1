import java.util.*;

public class InputParser {
    public Map<String, String> parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) {
                kv.put(t[0].trim(), t[1].trim());
            }
        }
        return kv;
    }
    
    public String getName(Map<String, String> data) {
        return data.getOrDefault("name", "");
    }
    
    public String getEmail(Map<String, String> data) {
        return data.getOrDefault("email", "");
    }
    
    public String getPhone(Map<String, String> data) {
        return data.getOrDefault("phone", "");
    }
    
    public String getProgram(Map<String, String> data) {
        return data.getOrDefault("program", "");
    }
}
