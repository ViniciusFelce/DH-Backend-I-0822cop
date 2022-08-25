package br.com.dh.integradoraVII.services;

import br.com.dh.integradoraVII.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService implements IDao<Usuario> {

    private static Map<Integer, Usuario> usuarios = new HashMap<>();

    @Override // Simulação do método save (JPA)
    public Usuario salvar(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    @Override
    public List<Usuario> buscarTodos() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public String excluir(Integer id) {
        usuarios.remove(id);
        return "O resgistro foi removido.";
    }
}
