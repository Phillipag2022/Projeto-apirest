package com.produtos.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtorepository;
		
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> ListaProdutos(){
		return produtorepository.findAll();
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um unico produto baseado em id")
	public Produto ListaProdutosUnico(@PathVariable(value="id") long id){
		return produtorepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Salva um produtos")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtorepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
}

