<table> 
    <td align="left">
        <img src="https://github.com/AlianeAmaral/atlaz-biblioteca-web/blob/main/src/presentation/assets/icons/img_logo_global_transparent.png" width="90">
    </td>
    <td width="750">
        <h1>Atlaz API e Web - Gestão de Biblioteca ✨</h1>
    </td>
</table>

<h2>🧩 Sobre o Projeto </h2>

Este projeto com **Back-end e Front-end**, se trata de um sistema **biblioteca acadêmica**. Possui como principal função a gestão de **livros** e **alunos**, assim como a gestão de **empréstimos** desses livros que são realizados pelos alunos. 
<br>
> [!IMPORTANT]
> 👉🏻 Repositório do Back: https://github.com/AlianeAmaral/atlaz-biblioteca-API
><br>
>👉🏻 Repositório do Front: https://github.com/AlianeAmaral/atlaz-biblioteca-web

<h2>💡 Sobre o Nome </h2>

<table> 
    <td align="left">
        <img src="https://github.com/AlianeAmaral/atlaz-biblioteca-web/blob/main/src/presentation/assets/images/img_mascot_neutral.png" width="90">
    </td>
    <td width="750" align="center">
        <h3>🪐 O nome "Atlaz" foi escolhido com o final do nome em referência à empresa "AZ", para quem foi desenvolvido este portfólio ✨</h3>
    </td>
</table>

<h2>💜 Apresentação do Sistema</h2>

<img src="https://github.com/AlianeAmaral/atlaz-biblioteca-API/blob/main/apresentacao-sistema.gif" width="1000"> 

---

<h2>🚀 Tecnologias Utilizadas e Pré-Requisitos</h2>

Para rodar o projeto, você precisará utilizar as seguintes tecnologias e versões utilizadas:

- **Back-end:**
> ☕ Java (21) <br>
> 🌱 Spring Boot (3.4.2) <br>
**🔹 IDE:** IntelliJ Community

- **Front-end:** 
> ⚡ Vue.js <br>
> 🎨 Tailwind CSS <br>
**🔹 IDE:** VS Code

- **Bancos de Dados:** 
> 🐘 PostgreSQL (dados estruturados) <br>
> 🍃 MongoDB (metadados)

- **Gerenciador de Dependências:**
> 🧱 Maven <br>
> 📦 NPM

---

<h2>🛠️ Técnicas Aplicadas</h2>

 Este projeto foi desenvolvido com as seguintes características e boas práticas de:

- API REST.
- Arquitetura em Camadas Monolítica com Clean Architecture.
- Princípios de Responsabilidade Única (SOLID).
- Clean Code.
- Conventional Commits.
- Conexão com mais de um banco de dados.
- Configuração com Swagger para testes de back-end.
- Manipulação de arquivos.
- Navegação de telas por rotas.
- CRUDs.
- Aplicação de regras de negócio.
- Manutenibilidade para facilidade com futuras funcionalidades.

<h2>🌍 Idiomas</h2>

> - **Idiomas utilizados para uso e orientações no README.md:**
> - VS Code: Idioma PT-BR.
> - IntelliJ: Idioma EN-US.

O código estará completamente em **EN-US**, mas a apresentação das telas do sistema estarão em **PT-BR**.

----

<h2>👩🏻‍💻 Funcionalidades Desenvolvidas</h2>

- Desenvolvimento da página inicial.
- Exibição dos alunos, livros e empréstimos cadastrados com fotos dos alunos e capas dos livros.
- Exbição de telas dinâmicas de mais detalhes de cada aluno ou livro selecionado.
- Possibilidade de upload de imagens e documentos *(.jpg .jpeg .png .webp, pdf, entre outros).*
- Possibilidade de cadastrar e editar alunos, livros e empréstimos de livros feitos por estes alunos com data de início e devolução.
- Exibição do status dos empréstimos, como: *Disponível, Emprestado, Devolvido Dentro do Prazo/Fora do Prazo, Atrasado e Perdido.*
- Exibição do status dos livros, como: *Disponível, Emprestado, Em Falta.*

----

<h2>🗄️ Configuração dos Bancos de Dados</h2>

### 🐘 PostgreSQL (Dados Padrão)

- **Host:** localhost <br>
- **Porta:** 5432 <br>
- **Database:** atlaz_biblioteca <br>
- **Usuário:** postgres <br>
- **Senha:** admin12345 <br>

**🔗 URL de Conexão:** jdbc:postgresql://localhost:5432/atlaz_biblioteca

----

### 🍃 MongoDB (Dados Padrão)

- **Host:** localhost <br>
- **Porta:** 27017 <br>
- **Database:** biblioteca_midia <br>

**🔗 URI de Conexão:** mongodb://localhost:27017/biblioteca_midia

----

<h2>🚪 Portas da Aplicação</h2>

**🚀 Execução da API:** http://localhost:8081 <br>
**🚀 Execução da Web:** http://localhost:5173

🟢 **Swagger:** http://localhost:8081/swagger-ui.html

<img src="https://github.com/AlianeAmaral/atlaz-biblioteca-API/blob/main/apresentacao-swagger.gif" width="1000"> 

---

<H2>▶️ Para Executar o Projeto</H2> 

1. Tenha as ferramentas instaladas nas versões indicadas.
2. Clone os dois repositórios nas IDEs correspondentes.
3. Acesse a pasta correta para execução: <br>
> cd atlaz_biblioteca
4. Para rodar o front-end, pode realizar o comando: <br>
> npm run dev
6. Para rodar o back-end API, pode realizar o comando "Run" através da interface.
7. Ou você pode utilizar o Docker com base nas informações acima.
