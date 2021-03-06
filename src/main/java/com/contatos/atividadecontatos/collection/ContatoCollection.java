package com.contatos.atividadecontatos.collection;

import com.contatos.atividadecontatos.model.Contato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ingrid
 */
public class ContatoCollection {
    private ArrayList<Contato> contatos;

    public ContatoCollection() {
        contatos = new ArrayList<>();
    }
    
    public void add(Contato contato) {
        if (contatos.contains(contato)) {
            throw new RuntimeException("Contato já existente.");
        }
        if (contato != null) {
            contatos.add(contato);
        } else {
            throw new RuntimeException("Forneça uma instância válida de um contato.");
        }
    }
    
    public List<Contato> getContatos(){
        return Collections.unmodifiableList(contatos);
    };
    

}
