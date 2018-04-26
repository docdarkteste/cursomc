package com.lucasedc.cursomc;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasedc.cursomc.domain.Categoria;
import com.lucasedc.cursomc.domain.Cidade;
import com.lucasedc.cursomc.domain.Cliente;
import com.lucasedc.cursomc.domain.Endereco;
import com.lucasedc.cursomc.domain.Estado;
import com.lucasedc.cursomc.domain.Produto;
import com.lucasedc.cursomc.domain.enums.TipoCliente;
import com.lucasedc.cursomc.repositories.CategoriaRepository;
import com.lucasedc.cursomc.repositories.CidadeRepository;
import com.lucasedc.cursomc.repositories.ClienteRepository;
import com.lucasedc.cursomc.repositories.EnderecoRepository;
import com.lucasedc.cursomc.repositories.EstadoRepository;
import com.lucasedc.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade cid1 = new Cidade(null,"Uberlândia", est1);
		Cidade cid2 = new Cidade(null,"São Paulo", est2);
		Cidade cid3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","55797322285",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3421210000","3497820000"));
		
		Endereco end1 = new Endereco(null,"Av. Maranhão","casa 3","2328","Umuarama", "38405318",cli1,cid1);
		Endereco end2 = new Endereco(null,"Rua Jataí","","1150","Aparecida", "38100000",cli1,cid1);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
	}
}
