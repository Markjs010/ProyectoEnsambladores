package services;

public class Tokenizer {
	//TODO clase que divide la cadena original en sus respectivos tokens
	public String analyzeCode(String code) {
        String[] lines = code.split("\n");
        StringBuilder elements = new StringBuilder();
        
        for (String line : lines) {
            line = line.trim();
            if (!line.isEmpty() && !line.startsWith(";")) { // Ignorar líneas vacías y comentarios
                String[] tokens = line.split("\\s+|,");
                for (String token : tokens) {
                    elements.append(token).append("\n");
                }
            }
        }
        
        return elements.toString();
    }
}
