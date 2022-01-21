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