# Frontend do projeto

## Limpando os arquivos iniciais

- No diretorio "public" deixar apenas os arquivos `index.html` e o `favicon.ico` .

- No arquivo `index` limpar os comentários e as tags `<link>` .

- No diretorio "src" deixar apenas os arquivos `App.tsx` e `index.tsx` .

- No arquivo `tsconfig.json` na linha "compilerOptions" adicionar a seguinte linha: 

```json
"baseUrl": "./src",
```
Ficando assim essa parte: 

```json
{
  "compilerOptions": {
    "baseUrl": "./src",
    "target": "es5",
    "lib": [
      "dom",
      "dom.iterable",
      "esnext"
    ],
  }
}
```

> Para que o projeto possa rodar na plataforma do Netlify quando estiver na nuvem, é necessario criar um arquivo chamado `_redirects` no diretório "public" e inserir o seguinte código:

```
/* /index.html 200
```

- Nos arquivos `App.tsx` e `index.tsx` remover as importações que não são mais necessárias

## Estilizando o Frontend

- Instalar a biblioteca do `bootstrap` .

```
yarn add bootstrap
```

No arquivo `index.tsx` fazer a importação do bootstrap .

```tsx
import 'bootstrap/dist/css/bootstrap.css';
```

No diretorio "src" criar o direotorio "assets" e dentro dele criar o diretorio "css" .

No direotorio "css" criar o arquivo `styles.css` e inserir os códigos: 

```css
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap');
:root {
    --color-primary: #FF8400;
}

html, body {
    height: 100%;
    font-family: "Ubuntu", sans-serif;
}

#root {
    display: flex;
    flex-direction: column;
    height: 100%;
}

.content {
    flex: 1 0 auto;
}

.footer {
    flex-shrink: 0;
    text-align: center;
}

.bg-primary {
    background-color: var(--color-primary) !important;
}

.text-primary {
    color: var(--color-primary) !important;
}
```

No arquivo index.tsx fazer a importação do css. 

```tsx
import 'assets/css/styles.css';
```