package com.biblioteca.fuctura.services;

import com.biblioteca.fuctura.dtos.CategoriaDto;
import com.biblioteca.fuctura.exceptions.DataIntegrityViolationException;
import com.biblioteca.fuctura.exceptions.IllegalArgumentException;
import com.biblioteca.fuctura.exceptions.ObjectNotFoundException;
import com.biblioteca.fuctura.models.Categoria;
import com.biblioteca.fuctura.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if(cat.isPresent()) {
            return cat.get();
        }
        throw new ObjectNotFoundException("Categoria não encontrada.");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDto categoriaDto) {
        findByNome(categoriaDto);
        categoriaDto.setId(null);
        return categoriaRepository.save(modelMapper.map(categoriaDto, Categoria.class));
    }

    public Categoria update(CategoriaDto categoriaDto) {
        findById(categoriaDto.getId());
        findByNome(categoriaDto);
        return categoriaRepository.save(modelMapper.map(categoriaDto, Categoria.class));
    }

    public void delete(Integer id) {
        findById(id);
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if (!cat.get().getLivros().isEmpty()){
            throw new DataIntegrityViolationException("Categoria possui livros, não pode ser deletada.");
        }
        categoriaRepository.deleteById(id);
    }

    private void findByNome(CategoriaDto categoriaDto) {
        Optional<Categoria> cat = categoriaRepository.findByNome(categoriaDto.getNome());
        if(cat.isPresent() && cat.get().getNome().equalsIgnoreCase(categoriaDto.getNome())) {
         throw new IllegalArgumentException("Já existe uma categoria com esse nome " + categoriaDto.getNome());
        }
    }
}
