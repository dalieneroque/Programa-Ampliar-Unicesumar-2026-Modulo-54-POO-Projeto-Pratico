# 🏁 Lista de Exercícios – Programação Orientada a Objetos em Java

**Projeto:** Jogo de Corrida POO  
**Linguagem:** Java  
**Biblioteca gráfica:** Swing

## 🎯 Objetivo

Esta atividade tem como objetivo revisar e praticar os principais conceitos de Programação Orientada a Objetos (POO), utilizando como base o projeto Jogo de Corrida desenvolvido durante a monitoria.

Os exercícios estão divididos em três níveis:

- **Nível 1:** Compreensão do código.
- **Nível 2:** Análise dos conceitos de POO.
- **Nível 3:** Modificações práticas no projeto.

---

# 🟢 Nível 1 – Compreensão do código

## Exercício 1 – Classes e objetos

Responda às questões:

1. O que é uma classe em Java?
2. Qual é a diferença entre classe e objeto?
3. No projeto Jogo de Corrida, quais são as classes criadas?
4. Quantos objetos de veículos são instanciados no construtor de `JogoCorrida`?

## Exercício 2 – Atributos e métodos

Observe a classe `Veiculo` e responda:

1. Quais são os atributos dessa classe?
2. Qual é a função do método `mover()`?
3. Para que serve o método `getVelocidade()`?
4. Por que os atributos foram declarados como `private`?

## Exercício 3 – Construtores

Responda:

1. Qual é a função de um construtor?
2. Por que utilizamos `super()` nas classes `Carro`, `Moto` e `Caminhao`?
3. O que aconteceria se não inicializássemos a posição e a velocidade dos veículos?

---

# 🟡 Nível 2 – Análise dos conceitos de POO

## Exercício 4 – Herança

Observe a declaração:

```java
public class Carro extends Veiculo {
}
```

Responda:

1. O que significa `extends`?
2. Qual é a classe pai?
3. Qual é a classe filha?
4. Quais características a classe `Carro` herda de `Veiculo`?

## Exercício 5 – Polimorfismo

Observe o trecho:

```java
for (Veiculo v : veiculo) {
    v.acelerar();
    v.mover();
}
```

Responda:

1. Por que a variável `v` é do tipo `Veiculo`?
2. Como o Java sabe qual método `acelerar()` executar?
3. O que acontece quando o objeto é um `Carro`?
4. O que acontece quando o objeto é uma `Moto`?

## Exercício 6 – Classes abstratas

Responda:

1. O que é uma classe abstrata?
2. Por que `Veiculo` foi definida como `abstract`?
3. É possível criar diretamente um objeto da classe `Veiculo`?
4. Qual é a função de um método abstrato?

---

# 🔴 Nível 3 – Prática no código

Nesta etapa, você deverá abrir o projeto Jogo de Corrida e realizar as alterações solicitadas.

## Exercício 7 – Criando um novo veículo

Crie uma classe chamada `Onibus` que:

- Herde de `Veiculo`;
- Tenha um construtor;
- Utilize `super()`;
- Implemente o método `acelerar()`;
- Tenha uma regra de aceleração diferente das demais classes.

Depois, adicione o ônibus à corrida.

**Atenção:** utilize a lista de veículos que já existe no projeto.

## Exercício 8 – Modificando a aceleração

Na classe `Carro`, atualmente a velocidade aumenta em 1 unidade.

Modifique o comportamento para que a aceleração aumente em 2 unidades.

Teste o resultado e responda:

1. Qual método foi alterado?
2. Por que essa alteração não precisou ser feita na classe `Veiculo`?
3. O que acontece com a velocidade máxima?

## Exercício 9 – Identificando tipos de veículos

No método `desenharVeiculo()`, utilize `instanceof` para identificar o novo veículo criado.

Faça com que ele tenha uma representação gráfica diferente dos outros.

**Desafio:** utilize os métodos gráficos já estudados, como `fillRect()`, `fillRoundRect()` e `fillOval()`.

## Exercício 10 – Reiniciando a corrida

Analise o método `resetar()` da classe `Veiculo`.

Responda:

1. O que acontece com a posição do veículo?
2. O que acontece com a velocidade?
3. Por que esse método é importante quando uma nova corrida começa?

---

# 💭 Reflexão final

Responda com suas próprias palavras:

1. Qual é a vantagem de utilizar herança nesse projeto?
2. Como o polimorfismo aparece na execução da corrida?
3. Por que a classe `Veiculo` foi definida como abstrata?
4. Qual é a diferença entre sobrescrever um método e criar um novo método?
5. O que aconteceria se todos os veículos utilizassem exatamente a mesma implementação de `acelerar()`?

---

**Bom trabalho! 🚀**

O objetivo não é apenas fazer o jogo funcionar, mas compreender como os conceitos de Programação Orientada a Objetos são aplicados na construção de uma aplicação.