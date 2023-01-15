package estrategia01;

import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.service.UsuarioService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioServicoTest {
    //variaveis globais
    private UsuarioService servico = new UsuarioService();
    private static Usuario usuarioGlobal;


    @Test
    public void test1_inserir() throws Exception {

        Usuario usuario = new Usuario("Usuario estrategia #1", "marcos3dt@marcos", "123");
        usuarioGlobal = servico.salvar(usuario);
        Assert.assertNotNull(usuarioGlobal.getId());

    }

    @Test
    public void test2_consultar() throws Exception {
        Usuario usuario = servico.findById(usuarioGlobal.getId());
        Assert.assertEquals("Usuario estrategia #1", usuario.getNome());

    }

    @Test
    public void test3_alterar() throws Exception {
        Usuario usuario = servico.findById(usuarioGlobal.getId());
        usuario.setNome("Usuário Alterado");
        Usuario usuarioAlterado = servico.salvar(usuario);
        Assert.assertEquals("Usuário Alterado", usuarioAlterado.getNome());
    }

    @Test
    public void test4_excluir() throws Exception {
        servico.delete(usuarioGlobal);
        Usuario usuarioRemovido = servico.findById(usuarioGlobal.getId());
        Assert.assertNull(usuarioRemovido);
    }

}
