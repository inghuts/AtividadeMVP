package com.contatos.atividadecontatos.presenter;

import com.contatos.atividadecontatos.collection.ContatoCollection;
import com.contatos.atividadecontatos.view.VisualizarContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ingrid
 */
public class VisualizarContatoPresenter {
    
    VisualizarContatoView view;
    private ContatoCollection contatos;

    public VisualizarContatoPresenter(ContatoCollection contatos) {
        this.contatos = contatos;
        
        view = new VisualizarContatoView();
        
        /*view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                editar();
            }
        });*/
    }
    /*public void editar(){
        view.dispose();
    }*/
}
