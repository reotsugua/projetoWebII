package br.com.projeto.webll.service;

import br.com.projeto.webll.model.Editora;
import br.com.projeto.webll.repository.EditoraDBMemoria;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

    private EditoraDBMemoria repositorio = new EditoraDBMemoria();
    public Editora pegarEditoraById(Long id){
        return repositorio.pegarUm(id);}

    public Editora criar(Editora editora){
        return repositorio.criar(editora);}

    public Editora editar(Editora editora, Long id){
        Editora editoraFromDB = repositorio.pegarUm(id);
        editoraFromDB.setDescricao(editora.getDescricao());
        editoraFromDB.setNome(editora.getNome());
        repositorio.editar(editoraFromDB);
        return repositorio.editar(editoraFromDB);}

    public void deletar(Long id){
        repositorio.delete(id);
    }
}
