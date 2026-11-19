# 🏁 Desafio Prático: Evoluindo o Jogo de Corrida POO

## 1. Objetivo

O objetivo desta atividade é colocar em prática os conceitos de Programação Orientada a Objetos estudados durante a monitoria, evoluindo o projeto **Jogo de Corrida**, desenvolvido em Java utilizando a biblioteca Swing.

Você deverá adicionar um novo tipo de veículo ao jogo, aplicando conceitos como:

- Classes e objetos;
- Construtores;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Sobrescrita de métodos (`@Override`);
- Uso de `instanceof`.

## 2. Contextualização

Atualmente, o jogo possui diferentes tipos de veículos participando de uma corrida:

- Carro;
- Moto;
- Caminhão.

Todos esses veículos herdam características e comportamentos da classe abstrata `Veiculo`.

**Sua missão será adicionar um novo participante à corrida: o Ônibus!**

O novo veículo deverá possuir suas próprias características de aceleração e também deverá ser representado graficamente na tela do jogo.

## 3. Desafio principal: Criando a classe Onibus

### Etapa 1 – Criar a classe

Crie uma nova classe chamada `Onibus`.

Ela deverá herdar da classe `Veiculo`.

**Pergunta:** Qual palavra-chave utilizamos em Java para indicar que uma classe herda de outra?

### Etapa 2 – Criar o construtor

O construtor da classe `Onibus` deverá receber o nome e a cor do veículo.

Utilize `super()` para chamar o construtor da classe pai.

**Pergunta:** Por que precisamos utilizar `super()` nesse construtor?

### Etapa 3 – Implementar o método acelerar()

A classe `Onibus` deverá implementar o método abstrato `acelerar()`, definido na classe `Veiculo`.

Crie uma regra própria de aceleração para o ônibus.

Requisitos:
- A aceleração deve ser diferente da regra utilizada pelo carro.
- Utilize o método `setVelocidade()` para atualizar a velocidade.
- Respeite o limite de velocidade já definido na classe `Veiculo`.

**Pergunta:** Por que precisamos sobrescrever o método `acelerar()`?

### Etapa 4 – Adicionar o ônibus à corrida

Localize o construtor da classe `JogoCorrida`, onde os veículos são adicionados à lista.

Adicione um objeto da classe `Onibus` à lista de veículos.

**Atenção:** Não crie uma nova lista. Utilize a lista que já existe no projeto.

### Etapa 5 – Desenhar o ônibus na tela

Localize o método:

`desenharVeiculo(Graphics2D g2, Veiculo v, int x, int y)`

Atualmente, esse método utiliza `instanceof` para identificar o tipo de veículo e desenhar cada um de uma maneira diferente.

Adicione uma nova condição para identificar o objeto `Onibus`.

O ônibus deverá possuir uma representação visual própria, diferente do carro, da moto e do caminhão.

Você pode utilizar os métodos gráficos já utilizados no projeto, como:
- `fillRect()`;
- `fillRoundRect()`;
- `fillOval()`.

**Pergunta:** Qual é a função do `instanceof` nesse trecho do código?

## 4. Testando a implementação

Depois de concluir as etapas, execute o projeto e verifique:

- [ ] O ônibus aparece na tela?
- [ ] O nome do ônibus é exibido corretamente?
- [ ] O ônibus participa da corrida?
- [ ] A velocidade é atualizada durante a corrida?
- [ ] O ônibus possui uma representação visual própria?
- [ ] O jogo continua funcionando com os demais veículos?

## 5. Desafio extra (opcional): Criando uma Ambulância

Se você concluiu o desafio principal, tente adicionar mais um veículo: uma **Ambulância**.

Ela deverá:

1. Herdar da classe `Veiculo`.
2. Possuir seu próprio construtor.
3. Implementar o método `acelerar()`.
4. Ser adicionada à lista de veículos.
5. Possuir uma representação visual própria.

Pense em uma regra de aceleração que diferencie a ambulância dos outros participantes.

## 6. Entrega da atividade

Ao finalizar, apresente:

1. A nova classe `Onibus`.
2. A alteração realizada na classe `JogoCorrida`.
3. A representação visual do ônibus.
4. Uma captura de tela do jogo funcionando com o novo veículo.

Se realizar o desafio extra, apresente também a implementação da Ambulância.

## 7. Reflexão final

Responda às perguntas:

1. Qual é a vantagem de utilizar herança nesse projeto?
2. Como o polimorfismo aparece na execução da corrida?
3. Por que a classe `Veiculo` foi definida como abstrata?
4. Qual é a diferença entre sobrescrever um método e criar um novo método?
5. O que aconteceria se todos os veículos utilizassem exatamente a mesma implementação de `acelerar()`?

**Bom desafio! 🚀**

O objetivo não é apenas fazer o jogo funcionar, mas compreender como os conceitos de POO são aplicados na construção de uma aplicação real.