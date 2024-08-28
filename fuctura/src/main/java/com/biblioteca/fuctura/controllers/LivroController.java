package com.biblioteca.fuctura.controllers;

import com.biblioteca.fuctura.dtos.LivroDto;
import com.biblioteca.fuctura.models.Livro;
import com.biblioteca.fuctura.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    //    @GetMapping
//    public ResponseEntity<List<LivroDto>> findAll(){
//        List<Livro> list = livroService.findAll();
//        return ResponseEntity.ok().body(list.stream()
//                .map(LivroDto::new).collect(Collectors.toList()));
//    }
    @GetMapping
    public ResponseEntity<List<LivroDto>> findByAllCategoria(@RequestParam(value = "categoria", defaultValue = "0") Integer id) {
        List<Livro> list = livroService.findByCategoria(id);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }
    //localhost:8080/livro?categoria=0

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<LivroDto>> findByAllCategoriaNome(@PathVariable String nome) {
        List<Livro> list = livroService.findAllByCategoriaNome(nome);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<LivroDto> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat, @RequestBody LivroDto livroDto) {
        Livro livro = livroService.save(id_cat, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> update(@PathVariable Integer id, @RequestBody LivroDto livroDto) {
        Livro livro = livroService.update(id, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
