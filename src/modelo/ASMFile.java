package modelo;

public class ASMFile {
	/*AQUÍ VAN LOS DATOS DEL ARCHIVO RECIBIO (.txt o .asm)
	 * Por el momento solo importan los tokens y la cadena completa original*/
	
	public String originalASM;
	public String tokens;
	
	public String getOriginalASM() {
		return originalASM;
	}
	public void setOriginalASM(String OriginalASM) {
		this.originalASM = OriginalASM;
	}
	public String getTokens() {
		return tokens;
	}
	public void setTokens(String tokens) {
		this.tokens = tokens;
	}
	
	
}
