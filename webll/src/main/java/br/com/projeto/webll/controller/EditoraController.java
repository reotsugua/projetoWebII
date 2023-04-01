package br.com.projeto.webll.controller;

import br.com.projeto.webll.model.Editora;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private List<Editora> lista = new ArrayList<>();
    private long contador = 1;
    @GetMapping
    public List<Editora> listar(){return lista;}
    @GetMapping("/{id}")
    public Editora pegarUm(@PathVariable("id") Long id){
        Integer indice = null;
        for (Integer i = 0; i <lista.size() ; i++) {
            if (lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        return lista.get(indice);}
    @PostMapping
    public Editora criar(@RequestBody Editora editora){
        editora.setId(contador);
        lista.add(editora);
        contador++;
        return editora;
    }

    @PutMapping("/{id}")
    public Editora editar (
            @RequestBody Editora editora,
            @PathVariable("id") Long id){
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

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Long id){

        int indice = -1;
        for (Integer i = 0; i <lista.size() ; i++) {
            if (lista.get(i).getId().equals(id)){
                indice = i;
                break;
            }
        }
        lista.remove(indice);
        return "Editora com id: "+id+" removido com sucesso!";
    }

}
