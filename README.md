# Crud Spring Boot - Endereço

# Tecnologias
- JAVA 1.8
- Spring 4
- Spring Boot
- Spring MVC
- Spring JPA
- HSQLDB
- Postmon(Webservice Rest para consulta de CEP)
- Maven
- JUnit

#Observações Gerais
- O Projeto foi criado utilizando a versão mais recente do Spring Boot

- O Spring faz conversão automática de um JSON para um objeto, sendo os dois na mesma estrutura. Todos os testes são realizados passando um JSON como parametro em uma chamada GET para o método requerido.

- A classe Util, possuí um metodo static "validar" na qual valida se o CEP é valido ou não, caso inválido damos um Throws na exessão.

- Criei uma classe ExceptionController na qual o Spring manipula todas as exception's dos métodos com a anotação @ExceptionHandler devolvendo uma mensagem e HttpStatus 500(Internal_Server_Error)

- Para o Crud utilizei HSQLDB como base, o Spring Boot configura automaticamente essa base, basta colocar a dependecia no arquivo POM, facilitando e agilizando o desenvolvimento.

# 1 - Expor um servico de Busca de CEP
Na classe EnderecoController temos o método GET buscarCep, onde passamos um JSON ex: {"cep":"09951380"}.
Validamos o CEP, e sendo válido chamos o método buscarCep em nosso serviço(classe EnderecoService).
Essa classe é a responsavel pelo algorítimo de busca de CEP descrito na questão, caso não encontre vai subtituindo cada número por 0 do final para o início.

Classe de Teste: TestBuscaCep
Quantidade de Testes: 5

# 2- Salvar endereco de usuario, seguindo as regras de CRUD
Todos os métodos CRUD estão na classe EnderecoController(consultar, atualizar, deletar e incluir).
A validação do Cep na função buscaCep é feita na classe de serviço EnderecoService, a mesma é resposavel por todas as operações transacionais.
O serviço implementa uma interface com toda a estrutura do crud e utiliza Spring JPA para realizar todas as operações no HSQLDB.
Todas as validações pedidas na questão são realizadas e as mensagens de erro exibidas( exceptions tratadas por @ExceptionHandler do Spring).

Classe de Teste: TestCrudEndereco
Quantidade de Testes: 13

# 3- Dada uma stream, encontrar o primeiro caractere que não se repita no resto da stream
Para esse algorítimo utilizo uma implementação da interface Set<> (pois ela não permite adicionar um item repetido, oque facilita o desenvolvimento do algorítimo sem deixar a performance) com apenas 1 loop, utilizo uma lista auxiliar do tipo List<> onde adiciono os caracteres que não se repetem, e por último devolvo o primeiro caracter que não se repete no restante da stream.
A classe que implementa o algorítimo é EncontraChar, com o método firstChar.

Classe de Teste: TestStream
Quantidade de Testes: 4

# 4- Quando digita a url, explique oque acontece no protocolo HTTP(cliente e servidor)
Quando digitamos a URL http://www.lucasbemol.com.br no browser os seguintes passos acontecem:

- Ao digitarmos a ulr fazemos uma requisição GET seguindo o protocolo HTTP/1.1
- Nessa requisição enviamos um cabeçalho(Header) contendo diversas informações, algumas delas são: tipo dos dados esperados no retorno Accept: text/xml,application/xml,application/xhtml+xml, Accept-Language: en-us,en;q=0.5, Accept-Encoding: gzip,deflate e muitos outros parametros.
- Com essas informações o servidor consegue indentificar oque queremos, processa e devolve para o cliente(browser) um pacote com header e o corpo da resposta, nesse header temos: protocolo usado no browser, sucesso ou erro da solicitação(Ex 200 "Sucesso" ou 500 "Erro interno"), e o tipo do conteúdo que vai no corpo da resposta(Ex HTML).
- O Cliente(browser) recebe esse pacote com sucesso, o navegador interpreta a resposta, processa e solicita os arquivos estáticos e recursos necessários para exibir o conteúdo, e para cada recurso necessário é feita uma nova solicitação ao servidor.
- Ao término de todos os processos com sucesso, o cliente(browser) exibe a página ao usuário.
