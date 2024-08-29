package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.ControlPrincipal;
import services.Tokenizer;

public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea codeArea;
    private JTextArea elementsArea;
    private JButton loadButton;
    private JButton analyzeButton;
    private ControlPrincipal control;
    
    public ViewPrincipal(ControlPrincipal control) {
    	this.control = control;
    	initializeUI();
    }
    public void initializeUI() {
    	
        setTitle("Proyecto Ensamblador Fase 1");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear la caja de texto para mostrar el código asm
        codeArea = new JTextArea();
        JScrollPane codeScrollPane = new JScrollPane(codeArea);
        panel.add(codeScrollPane, BorderLayout.CENTER);

        // Crear la caja de texto para mostrar los elementos separados
        elementsArea = new JTextArea();
        JScrollPane elementsScrollPane = new JScrollPane(elementsArea);
        panel.add(elementsScrollPane, BorderLayout.EAST);
        elementsScrollPane.setPreferredSize(new Dimension(200, 0));

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        loadButton = new JButton("Leer Archivo");
        analyzeButton = new JButton("Analizar");
        buttonPanel.add(loadButton);
        buttonPanel.add(analyzeButton);
        panel.add(buttonPanel, BorderLayout.NORTH);

        // Añadir el panel principal a la ventana
        add(panel);

        // Configurar los listeners de los botones
        configureButtonListeners();
    }

    public void configureButtonListeners() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(ViewPrincipal.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Leer el archivo seleccionado y mostrar su contenido en codeArea
                        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                        codeArea.read(reader, null);
                        reader.close();
                    } catch (IOException ioException) {
                        JOptionPane.showMessageDialog(ViewPrincipal.this, "Error al leer el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = codeArea.getText();
                control.processInput(code);
            }
        });
        
    }
    public void showResult(String resultado) {
    	elementsArea.setText(resultado);
    }
	
}
