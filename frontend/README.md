# Frontend do projeto

## Limpando os arquivos iniciais

- No diretorio "public" deixar apenas os arquivos `index.html` e o `favicon.ico` .

- No arquivo `index` limpar os comentários e as tags `<link>` .

- No diretorio "src" deixar apenas os arquivos `App.tsx`, `react-app-env.d.ts` e `index.tsx` .

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

### Adicionando o Bootstrap

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

No arquivo `index.tsx` fazer a importação do css. 

```tsx
import 'assets/css/styles.css';
```

### Criando componentes da página

- No diretorio "src" criar o diretorio "components" .

#### Componente Navbar

- No diretorio "components" criar o diretorio "Navbar" e dentro dele o arquivo `index.tsx` e inserir os codigos para criação do componente . 

```tsx
function NavBar() {
    return (
        <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-light border-bottom shadow-sm">
            <div className="container">
                <nav className="my-2 my-md-0 mr-md-3">
                    <img src={ImgDsDark} alt="DevSuperior" width="120" />
                </nav>
            </div>
        </div>
    );
}

export default NavBar;
```
- Para importar a imagem, dentro do diretorio "assets" criar o diretorio "img" e dentro dele colocar as imagens do projeto  

- No arquivo `index.tsx` do diretorio "NavBar", importar a imagem de dentro do diretorio img, dando um nome para essa imagem: 

```tsx
import ImgDsDark from '../../assets/img/ds-dark.svg'
```

- No arquivo `App.tsx`, dentro da div colocar o component `NavBar` nela e colocar um `className="container` na div .

```tsx
import NavBar from "components/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">SDS 2</h1>
      </div>
    </>
  );
}

export default App;
```

#### Componente Footer

- Repetir o processo de criação do componente Navbar apenas modificando o nome para Footer e alterando os códigos

- Adicionar o Footer depois do conteudo principal no arquivo `App.tsx`

```tsx
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">SDS 2</h1>
      </div>
      <Footer />
    </>
  );
}

export default App;
```

#### Componente DataTable

- Repetir o processo de criação do componente Navbar apenas modificando o nome para DataTable e alterando os códigos

- Adicionar o DataTable depois do conteudo principal no arquivo `App.tsx`

```tsx
import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">SDS 2</h1>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
```

## Adicionando gráficos com Apex Charts

- No termnial, instalar a biblioteca do Apex Charts

```bash
yarn add apexcharts
yarn add react-apexcharts
```
## Criar mais componentes para a página

### Componente BarChart

- Após criar o corpo pricipal de um componente React, adicionar o `apexcharts` no componente .

- Antes do `return()` inserir as funçoes do ApexCharts

```jsx
const options = {
    plotOptions: {
        bar: {
            horizontal: true,
        }
    },
};

const mockData = {
    labels: {
        categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    },
    series: [
        {
            name: "% Sucesso",
            data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
        }
    ]
};
```
- Adicionar no `return()` o componente Charts passando os parametros de criação dos gráficos .

```jsx
import Chart from "react-apexcharts";

function BarChart() {
    // Criando a função de plotagem dos gráficos
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    // Criando função com os dados ficticios
    const mockData = {
        labels: {
            categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
        },
        series: [
            {
                name: "% Sucesso",
                data: [43.6, 67.1, 67.7, 45.6, 71.1]
            }
        ]
    };

    return (
        <Chart 
            options={{...options, xaxis: mockData.labels}}
            series={mockData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;
```

-No `App.tsx` criar uma estrutura html para colocar o gráfico

- Dentro da div container criar duas divs com seus respectivos nomes, e dentro da ultima div criada, adicionar o componente BarChart .

```tsx
import BarChart from "components/BarChart";
import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary py-3">Dashboard de Vendas</h1>
        <div className="row px-3">
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Taxa de sucesso (%)</h5>
            <BarChart />
          </div>
          <div className="col-sm-6">
            <h5>Todas as vendas</h5>
            <BarChart />
          </div>
        </div>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
```

### Componente DonutChart

- Repetir o mesmo processo do BarChart apenas alterando os paramentros de plotagem do gráfico .

```tsx
import Chart from "react-apexcharts";

function DonutChart() {
    // Criando a função de plotagem dos gráficos
    const options = {
        legend: {
            show: true
        }
    }

    // Criando função com os dados ficticios
    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }

    return (
        <Chart 
            options={{...options, labels: mockData.labels}}
            series={mockData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;
```