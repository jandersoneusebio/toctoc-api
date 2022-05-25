package br.edu.fpb.gti.controller.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fpb.gti.exception.BusinessException;
import br.edu.fpb.gti.messages.Mensagens;
import br.edu.fpb.gti.model.dto.CadastroUsuarioDTO;
import br.edu.fpb.gti.model.dto.LoginDTO;
import br.edu.fpb.gti.model.dto.UsuarioDTO;
import br.edu.fpb.gti.model.entity.Usuario;
import br.edu.fpb.gti.model.repository.UsuarioRepository;
import br.edu.fpb.gti.util.StringUtil;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void cadastrarUsuario(CadastroUsuarioDTO cadastro) throws NoSuchAlgorithmException, BusinessException, UnsupportedEncodingException {
		
		validarDadosCadastro(cadastro);
		
		Usuario usuario = montarCadastroUsuario(cadastro);
		
		usuarioRepository.save(usuario);
		
	}
	
	private static Usuario montarCadastroUsuario(CadastroUsuarioDTO cadastro) throws NoSuchAlgorithmException, BusinessException, UnsupportedEncodingException {
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin(cadastro.getLogin());
		usuario.setNome(cadastro.getNome());
		usuario.setSenha(gerarHash(cadastro.getSenha()));
		usuario.setPermissoes(montarPermissoes(cadastro.getPermissoes()));
		
		return usuario;
		
	}
	
	private static String montarPermissoes(List<String> permissoesList) {
		
		StringBuilder sb = new StringBuilder();
		
		if(!StringUtil.isNullOrEmpty(permissoesList)) {
			permissoesList.stream()
				.forEach(permissao -> sb.append(permissao).append(";"));
		}
		
		return sb.toString();
		
	}
	
	public UsuarioDTO login(LoginDTO login) throws NoSuchAlgorithmException, BusinessException, UnsupportedEncodingException {
		
		validarDados(login);
		
		Optional<Usuario> usuario = usuarioRepository.findByLoginAndSenha(login.getUsuario(), gerarHash(login.getSenha()));
		
		if(usuario.isPresent()) {
			return montarUsuarioDTO(usuario.get());
		} else {
			throw new BusinessException(Mensagens.CREDENCIAIS_INVALIDAS);
		}
		
	}
	
	private static UsuarioDTO montarUsuarioDTO(Usuario usuario) {
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome(usuario.getNome());
		dto.setPermissoes(splitPermissoes(usuario.getPermissoes()));
		
		return dto;
		
	}
	
	private static List<String> splitPermissoes(String permissoesStr){
		return Arrays.asList(permissoesStr.split(";"));
	}
	
	private static String gerarHash(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		
        md.update(senha.getBytes());
        
        byte[] digest = md.digest();
        
        StringBuffer sb = new StringBuffer();

        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        
        System.out.println("string original: " + senha);
        System.out.println("digested(hex): " + sb.toString());
		/*
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		
		byte[] senhaCriptografada = md5.digest(senha.getBytes("UTF-8"));
		
		return StringUtils.string   .toString(senhaCriptografada, "UTF-8");
		*/
        
        return sb.toString();
	}
	
	private static void validarDados(LoginDTO login) throws BusinessException {
		if(StringUtil.isNullOrEmpty(login.getUsuario()) || StringUtil.isNullOrEmpty(login.getSenha())) {
			throw new BusinessException(Mensagens.DADOS_LOGIN_INVALIDOS);
		}
	}
	
	private static void validarDadosCadastro(CadastroUsuarioDTO cadastro) throws BusinessException {
		if(StringUtil.isNullOrEmpty(cadastro.getLogin()) 
				|| StringUtil.isNullOrEmpty(cadastro.getSenha())
				|| StringUtil.isNullOrEmpty(cadastro.getNome())) {
			throw new BusinessException(Mensagens.DADOS_CADASTRO_INVALIDOS);
		}
	}
	
}
