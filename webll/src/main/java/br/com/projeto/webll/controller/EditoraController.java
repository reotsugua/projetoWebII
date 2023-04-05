package br.com.projeto.webll.controller;

import br.com.projeto.webll.model.Editora;
import br.com.projeto.webll.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private List<Editora> lista = new ArrayList<>();
    private long contador = 1;

    @Autowired
    private EditoraService editoraService;
    @GetMapping
    public List<Editora> listar(){return lista;}
    @GetMapping("/{id}")
    public Editora pegarUm(@PathVariable("id") Long id){
        return editoraService.pegarEditoraById(id);
    }
    @PostMapping
    public Editora criar(@RequestBody Editora editora){
        return editoraService.criar(editora);
    }

    @PutMapping("/{id}")
    public Editora editar (
            @RequestBody Editora editora,
            @PathVariable("id") Long id){

        return editoraService.editar(editora, id);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable("id") Long id){


        return "Editora com id: "+id+" removido com sucesso!";
    }

}
