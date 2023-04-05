package br.com.projeto.webll.repository;

import br.com.projeto.webll.model.Editora;

import java.util.ArrayList;
import java.util.List;

public class EditoraDBMemoria {

    private List<Editora> lista = new ArrayList<>();
    private long contador = 1;

    public Editora pegarUm(Long id){
        Integer indice = null;
        for (Integer i = 0; i <lista.size() ; i++) {
            if (lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        return lista.get(indice);
    }

    public Editora criar(Editora editora){
        editora.setId(contador);
        lista.add(editora);
        contador++;
        return editora;
    }

    public Editora editar(Editora editora, Long id){
        editora.setId(id);

        Integer indice = null;
        for (Integer i = 0; i <lista.size() ; i++) {
            if (lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        lista.set(indice, editora);
        return editora;
    }

    public void delete(Long id){
        int indice = -1;
        for (Integer i = 0; i <lista.size() ; i++) {
            if (lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        lista.remove(indice);

    }
}
