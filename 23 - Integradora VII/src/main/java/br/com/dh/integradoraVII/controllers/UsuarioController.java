package br.com.dh.integradoraVII.controllers;

import br.com.dh.integradoraVII.entities.Usuario;
import br.com.dh.integradoraVII.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Requisições
http://localhost:8080/usuarios/?id=1&nome=Marta&email=martadh@gmail.com&senha=321654&nivelacesso=1
http://localhost:8080/usuarios/?id=2&nome=Pedro&email=pedro@gmail.com&senha=987654&nivelacesso=2
http://localhost:8080/usuarios/buscar
http://localhost:8080/usuarios/1
http://localhost:8080/usuarios/buscar
 */

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public Usuario salvar(
            @RequestParam(value = "id") Integer idrec,
            @RequestParam(value = "nome") String nomerec,
            @RequestParam(value = "email") String emailrec,
            @RequestParam(value = "senha") String senharec,
            @RequestParam(value = "nivelacesso") Integer nivelacessorec) {
        return service.salvar(new Usuario(idrec, nomerec, emailrec, senharec, nivelacessorec));
    }

    @GetMapping("/buscar")
    public List<Usuario> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public String excluir(@PathVariable Integer id) {
        return service.excluir(id);
    }

}
