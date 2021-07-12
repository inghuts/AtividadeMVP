package com.contatos.atividadecontatos.presenter;

import com.contatos.atividadecontatos.collection.ContatoCollection;
import com.contatos.atividadecontatos.model.Contato;
import com.contatos.atividadecontatos.view.ListarContatosView;
import com.contatos.atividadecontatos.view.VisualizarContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ingrid
 */
public class ListarContatosPresenter {
    
    private ListarContatosView view;
    private ContatoCollection contatos;
    private DefaultTableModel tmContatos;

    public ListarContatosPresenter(ContatoCollection contatos) {
        this.contatos = contatos;
        
        view = new ListarContatosView();
        
        tmContatos = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Telefone"}
        );
        
        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tmContatos.setNumRows(0);
        ListIterator<Contato> it = contatos.getContatos().listIterator();
        
        while(it.hasNext()) {
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(), contato.getTelefone()});
        }
        
        view.getTblContatos().setModel(tmContatos);
        
        view.getBtnVisualizar().setEnabled(false);
        view.getBtnExcluir().setEnabled(false);
        
        view.getTblContatos().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                view.getBtnVisualizar().setEnabled(!lsm.isSelectionEmpty());
                view.getBtnExcluir().setEnabled(!lsm.isSelectionEmpty());
            }
        });
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                fechar();
            }
        });
        
        view.getCbOrdenarTelefone().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ordenar();
            }
        });
        
        view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                excluir();
            }
        });
        
        view.getBtnVisualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                visualizar();
            }
        });
        
        view.setVisible(true);
    }
    
    private void fechar() {
        view.dispose();
    }
    
    private void ordenar() {
        
    }
    
    private void excluir() {
        if (view.getTblContatos().getSelectedRow() != -1) {
            tmContatos.removeRow(view.getTblContatos().getSelectedRow()); 
        }
        
    }
    
    private void visualizar() {
        VisualizarContatoView viewVisu = new VisualizarContatoView();
        viewVisu.getTxtNome().setText(view.getTblContatos().getValueAt(view.getTblContatos().getSelectedRow(), 0).toString());
        viewVisu.getTxtTelefone().setText(view.getTblContatos().getValueAt(view.getTblContatos().getSelectedRow(), 1).toString());
    }    
    
}
