package com.contatos.atividadecontatos.presenter;

import com.contatos.atividadecontatos.collection.ContatoCollection;
import com.contatos.atividadecontatos.view.EditarContatoView;
import com.contatos.atividadecontatos.view.ListarContatosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ingrid
 */
public class EditarContatoPresenter {
    
    EditarContatoView view;
    private ContatoCollection contatos;

    public EditarContatoPresenter(ContatoCollection contatos) {
        this.contatos = contatos;
        
        view = new EditarContatoView();
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                fechar();
            }
        });
    }
    public void fechar() {
        view.dispose();
    }
}
