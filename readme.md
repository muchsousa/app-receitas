## Desenvolvimento de App de receitas

Objetivo: Desenvolver uma aplicação Android utilizando Kotlin. O aplicativo deve permitir que os usuários façam login, naveguem por uma lista de receitas, pesquisem por pratos específicos e visualizem os detalhes de cada receita de maneira detalhada.
Os dados das receitas devem estar armazenados em um banco de dados, que pode ser local ou externo.

### Requisitos Obrigatórios:

- 1. Login:
    - Implementar uma tela de login, que deve utilizar uma API de autenticação (por exemplo, Firebase Authentication ou qualquer outra API de login). O login pode ser feito com email e senha ou por meio de um provedor de login social (Google, Facebook, etc.).
- 2. Lista de Receitas:
    - Exibir uma lista de receitas usando um RecyclerView ou GridView.
    - Cada item da lista deve exibir ao menos a imagem e o nome da receita.
    - A lista deve ser clicável para que, ao selecionar uma receita, o usuário seja levado à tela de detalhes da receita.
- 3. Banco de Dados:
    - Utilizar um banco de dados para armazenar as receitas. O banco de dados pode ser local (SQLite) ou externo (Firebase, Firestore, ou outra API de banco de dados).
    - O banco de dados deve conter as informações da receita, incluindo nome, descrição, ingredientes, modo de preparo e uma imagem ilustrativa.
- 4. Pesquisa:
    - Implementar uma funcionalidade de pesquisa que permita ao usuário buscar receitas pelo nome.
    - A pesquisa pode ser por palavras-chave, com atualização em tempo real ou com um botão de busca que exibe os resultados.
- 5. Tela de Detalhes da Receita:
    - Ao selecionar uma receita na lista, o aplicativo deve abrir uma nova tela com os detalhes da receita.
    - A tela de detalhes deve exibir o nome da receita, imagem, ingredientes, modo de preparo e qualquer outra informação relevante.

---

### Icones
- https://www.flaticon.com/br/icone-gratis/receita_362285?related_id=287051&origin=search
- https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html#foreground.type=clipart&foreground.clipart=android&foreground.space.trim=1&foreground.space.pad=0.25&foreColor=rgba(96%2C%20125%2C%20139%2C%200)&backColor=rgb(68%2C%20138%2C%20255)&crop=0&backgroundShape=circle&effects=none&name=ic_launcher

