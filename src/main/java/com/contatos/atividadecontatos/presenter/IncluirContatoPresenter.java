package com.contatos.atividadecontatos.presenter;

import com.contatos.atividadecontatos.collection.ContatoCollection;
import com.contatos.atividadecontatos.model.Contato;
import com.contatos.atividadecontatos.view.IncluirContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Ingrid
 */
public class IncluirContatoPresenter {
    
    private IncluirContatoView view;
    private ContatoCollection contatos;

    public IncluirContatoPresenter(ContatoCollection contatos) {
        this.contatos = contatos;
        view = new IncluirContatoView();
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                fechar();
            }
            
        });
        
        view.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                salvar();
            }
            
        });

        view.setVisible(true);
    }
    
    private void fechar() {
        view.dispose();
    }
    private void salvar() {
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
        
        JOptionPane.showMessageDialog(view, 
                "Contato " + contato.getNome() + " salvo com sucesso!",
                "Salvo com sucesso",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
