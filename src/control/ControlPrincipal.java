package control;

import modelo.ASMFile;
import services.Tokenizer;
import view.ViewPrincipal;

public class ControlPrincipal {
	//TODO CLASE ENCARGADA DE LA MAYORÍA DE LA COMUNICACIÓN ENTRE CLASES
	private ASMFile asmFile;
    private Tokenizer tokenizer;
    private ViewPrincipal view;

    public ControlPrincipal() {
        this.asmFile = new ASMFile();
        this.tokenizer = new Tokenizer();
        this.view = new ViewPrincipal(this); // Pass the controller to the view
        view.setVisible(true);
    }

    public void processInput(String input) {
        // Update the model with the original input
    	asmFile.setOriginalASM(input);

        // Use Tokenizer to process the input
        String tokens = tokenizer.analyzeCode(input);

        // Update the model with the processed result
        asmFile.setTokens(tokens);

        // Pass the result back to the view
        view.showResult(tokens);
    }
}
