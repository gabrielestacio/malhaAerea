# Malha Aérea

Este projeto tem por objetivo descrever um problema e a aplicação de grafos como solução, sendo este problema a gestão de linhas aéreas de uma companhia aérea localizada em Natal, Rio Grande do Norte.

## Introdução
A construção de uma malha aérea não é uma tarefa simples. Envolve muitos estudos, muitas análises e diversas observações para tomar decisões estratégicas sobre logísticas que auxiliem o bom funcionamento da empresa e seu lucro.

Uma abordagem possível para a análise de melhores trajetos para vôos é utilizando grafos, mais especificamente, grafos ponderados, que levem em consideração fatores importantíssimos para o desenvolvimento econômico da companhia, a fim de que ela também ofereça ótimos serviços.

A partir disso, apresento esse estudo de caso, uma simulação de construção da malha aérea de uma companhia fictícia, sediada em Natal e que está buscando ter uma cobertura nacional, para se tornar referência em voos domésticos.

## Descrição do Problema Real
O espaço aéreo brasileiro é bastante restrito a algumas companhias específicas para voos domésticos. Considerando um contexto onde uma nova companhia está sendo criada para adentrar neste mercado, é necessário um estudo estratégico e logístico que possibilite à empresa definir as rotas das linhas áereas que irá operar.

Para isso, é importante levar em consideração alguns fatores: a distância entre dois aeroportos que constituem uma linha aérea, o custo de operação envolvido e, principalmente, a demanda de passagens para aquela linha aérea. A partir destes fatores, a proposta é utilizar grafos ponderados para auxiliar na definição de rotas vantajosas para a companhia.

## Solução Algorítmica
Este é um problema que se caracteriza como um problema do caminho mais curto em um grafo ponderado e sem arestas de valores negativos. Por conta da natureza do problema e da complexidade de implementação, a solução algorítmica utilizada será o Algoritmo de Dijkstra, que será implementado na linguagem Java para a resolução do problema.

O algoritmo foi implementado para todos os destinos. Então, tendo Natal como origem de todos os trajetos, para cada um dos destinos, foram geradas redes com vértices pré-determinados e, a partir disso, com a implementação do Algoritmo de Dijkstra, descobrimos qual a rota mais vantajosa para cada destino partindo de Natal, segundo os parâmetros informados, formando assim, a melhor malha aérea possível para a companhia aérea.

### Instruções Técnicas
O programa foi desenvolvido em linguagem Java, através da IDE Eclipse (Eclipse for Java Developers), com o auxílio das bibliotecas OpenCSV e Apache Common Lang 3, que estão já adicionadas às dependências do projeto e disponibilizadas na pasta “lib” do projeto em formato .jar. Foi desenvolvido utilizando Java 16.

O programa pode ser executado através de uma IDE (recomenda-se o uso do Eclipse).

## Conclusão
Através deste estudo de caso, foi possível analisar e construir conhecimento para uma decisão estratégica das mais importantes para uma companhia aérea, tornando essa decisão prática não uma escolha “às cegas”, mas embasada. Para tanto, o uso de grafos foi fundamental, pois direcionou a escolha por rotas específicas dentro de um mar de possibilidades, além de indicar para a companhia quais linhas são as mais efetivas e com maior potencial lucrativo para a empresa. É importante frisar que, no entanto, este estudo tem algumas abstrações, não sendo um modelo totalmente realístico de execução do cálculo de rotas por um sistema comercial.

Diante da literatura disponível para o problema, vimos que existem diferentes abordagens para resolvê-lo: utilizando algoritmos de caminhos mais curtos, utilizando busca em largura e árvores de extensão, combinando matrizes de adjacência e de pesos, e, por fim, utilizando o Problema do Caixeiro Viajante.

Para nosso problema especificamente, utilizamos o algoritmo de Dijkstra para encontrar o caminho mais curto, consequentemente, a melhor rota entre Natal e os outros estados do Brasil.

<br/>

### Acesse o relatório completo desse projeto para ler toda a descrição no link abaixo! 👇
[Relatório do projeto](https://docs.google.com/document/d/15vXeH8v3TURqOERo9-oFat_90E-M0opaixRC3tHcAbk/edit?usp=sharing)

---
