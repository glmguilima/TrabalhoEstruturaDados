package com.example.trabalhoestruturadados;


import com.example.trabalhoestruturadados.Base.Cliente;
import com.example.trabalhoestruturadados.Lista.LDEcliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HelloController {

    private LDEcliente ldEcliente = new LDEcliente();
    @FXML
    private AnchorPane MenuCadastro;

    @FXML
    private Button buttonCadastrarCliente;

    @FXML
    private TextField textCNh;

    @FXML
    private TextField textCPF;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textTele;


    @FXML
    void cadastrarButton(ActionEvent event) {

        String nome ;
        Long CNh, CPF, Tele;
        nome = textNome.getText().toLowerCase();
        CNh= Long.valueOf(textCNh.getText());
        CPF = Long.valueOf(textCPF.getText());
        Tele = Long.valueOf(textTele.getText());
        Cliente cliente = new Cliente(nome,CNh,Tele,CPF);
        ldEcliente.insereFim(cliente);
        limparCampos();
        System.out.println(" Cliente cadastrado" +cliente.toString());

    }


    void limparCampos(){
        textNome.setText("");
        textCPF.setText("");
        textTele.setText("");
        textCNh.setText("");
    }


}
