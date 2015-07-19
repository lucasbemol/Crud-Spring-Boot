package br.com.teste.netshoes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.teste.netshoes.entity.Endereco;

import com.google.gson.Gson;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { TesteNetshoesApplication.class })
@WebAppConfiguration
public class TestCrudEndereco {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	/**** Testes Para Inclusão ***/
	@Test
	 public void testIncluirEnderecoComCamposNull() throws Exception {
	        Endereco vo = new Endereco();
	        vo.setCep("09951380");
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/incluir")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	@Test
	 public void testIncluirEndereco() throws Exception {
	        Endereco vo = new Endereco();
	        vo.setCep("09951380");
	        vo.setBairro("Piraporinha");
	        vo.setCidade("Diadema");
	        vo.setEstado("SP");
	        vo.setNumero("59");
	        vo.setRua("Tupinimos");
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/incluir")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isOk());
	 }
	
	/**** Testes Para Atualizar ***/
	@Test
	 public void testAltualizarEnderecoSemId() throws Exception {
	        Endereco vo = new Endereco();
	        vo.setCep("09951380");
	        vo.setBairro("Canhema");
	        vo.setCidade("São Bernardo");
	        vo.setEstado("SP");
	        vo.setNumero("206");
	        vo.setRua("Yaya");
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/atualizar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	@Test
	 public void testIncluiEAltualizarEnderecoComId() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        vo.setId(new Long(1));
	        vo.setCep("09951380");
	        vo.setBairro("Canhema");
	        vo.setCidade("São Bernardo");
	        vo.setEstado("SP");
	        vo.setNumero("206");
	        vo.setRua("Yaya");
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/atualizar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isOk());
	 }
	
	@Test
	 public void testIncluiEAltualizarEnderecoComCidadeNull() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        vo.setId(new Long(1));
	        vo.setCep("09951380");
	        vo.setBairro("Canhema");
	        vo.setEstado("SP");
	        vo.setNumero("206");
	        vo.setRua("Yaya");
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/atualizar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	/**** Testes Para Consulta ***/
	@Test
	 public void testConsultaEnderecoComId() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        vo.setId(new Long(1));
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/consultar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isOk());
	 }
	
	@Test
	 public void testConsultaEnderecoSemId() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/consultar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	@Test
	 public void testConsultaEnderecoInexistente() throws Exception {
	        Endereco vo = new Endereco();
	        vo.setId(new Long(123));
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/consultar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	/**** Testes Para Exclusão ***/
	
	@Test
	 public void testDeletarEnderecoComId() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        vo.setId(new Long(1));
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/deletar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isOk());
	 }
	
	@Test
	 public void testDeletarEnderecoSemId() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/deletar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	@Test
	 public void testDeletarEnderecoInexistente() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        vo.setId(new Long(123));
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/deletar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	/**** Testes Para Inclusão/Alteração com CEP Inválido ***/
	@Test
	 public void testIncluirEnderecoCepInvalido() throws Exception {
	        Endereco vo = new Endereco();
	        vo.setCep("099");
	        vo.setBairro("Piraporinha");
	        vo.setCidade("Diadema");
	        vo.setEstado("SP");
	        vo.setNumero("59");
	        vo.setRua("Tupinimos");
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/incluir")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
	
	@Test
	 public void testAtualizarEnderecoCepInvalido() throws Exception {
			testIncluirEndereco();
	        Endereco vo = new Endereco();
	        vo.setId(new Long(1));
	        vo.setCep("112");
	        vo.setBairro("Piraporinha");
	        vo.setCidade("Diadema");
	        vo.setEstado("SP");
	        vo.setNumero("59");
	        vo.setRua("Tupinimos");
	        Gson gson = new Gson();
	        String json = gson.toJson(vo);
	        
	        this.mockMvc.perform(get("/atualizar")
	        		.contentType(MediaType.APPLICATION_JSON)
	        		.content(json))
	            .andExpect(status().isInternalServerError());
	 }
}
