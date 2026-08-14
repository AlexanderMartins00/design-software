# Respostas das questões 1 - 9

---

## Pergunta 1
O que muda na saída quando você escolhe Escola Pública ou Escola Privada?

## Resposta:
O que muda é o conjunto de objetos concretos que a fábrica escolhida devolve. Ao selecionar Escola Pública, o programa monta a saída com o professor, o material didático e a avaliação característicos da rede pública; ao escolher Escola Privada, ele monta a mesma estrutura, mas com as implementações da rede privada. O fluxo do programa continua o mesmo — só o conteúdo concreto de cada peça muda, porque é a fábrica quem decide qual variante instanciar.

---

## Pergunta 2
Por que usar `MaterialEscolaPrivada` dentro de `EscolaTecnicaFactory` não é adequado?

## Resposta:
Porque cada fábrica concreta existe justamente para garantir que todos os objetos que ela cria pertençam à mesma família. Se `EscolaTecnicaFactory` retornasse um `MaterialEscolaPrivada`, ela estaria misturando produtos de famílias diferentes — o professor e a avaliação seriam da escola técnica, mas o material seria da escola privada. Isso quebra a coerência que o Abstract Factory se propõe a garantir e pode gerar um sistema com comportamento inconsistente, mesmo funcionando "por fora".

---

## Pergunta 3
O Java necessariamente apresentará erro de compilação ou esse é principalmente um erro de projeto/design?

## Resposta:
É principalmente um erro de projeto, não de compilação. Como `MaterialEscolaPrivada` implementa a interface `MaterialDidatico`, o compilador não tem motivo para reclamar — do ponto de vista da linguagem, o tipo está correto. O problema é semântico: a fábrica técnica está devolvendo um produto que não pertence à sua família, o que é um erro de coerência de design que só será percebido em tempo de execução (ou por quem revisa o código), não pelo compilador.

---

## Pergunta 4
Como corrigir o método `criarMaterialDidatico`?

## Resposta:
Basta fazer com que a fábrica retorne o material que realmente pertence à sua própria família de produtos:

```java
@Override
public MaterialDidatico criarMaterialDidatico() {
    return new MaterialEscolaTecnica();
}
```

Assim, `EscolaTecnicaFactory` volta a produzir apenas objetos coerentes com a escola técnica.

---

## Pergunta 5
Qual é a função da interface `EscolaFactory`?

## Resposta:
`EscolaFactory` funciona como o contrato do padrão Abstract Factory: ela declara quais métodos toda fábrica de escola precisa ter (por exemplo, `criarProfessor()`, `criarMaterialDidatico()`, `criarAvaliacao()`), sem se preocupar em como cada tipo de escola implementa isso. Ela garante que todas as fábricas concretas — pública, privada, técnica — sigam a mesma estrutura, permitindo que sejam usadas de forma intercambiável pelo resto do sistema.

---

## Pergunta 6
Qual é a diferença entre `EscolaFactory` e `EscolaTecnicaFactory`?

## Resposta:
`EscolaFactory` é a interface abstrata: ela apenas define o que uma fábrica de escola deve saber fazer, sem implementar nada. Já `EscolaTecnicaFactory` é uma implementação concreta dessa interface — é ela quem efetivamente decide quais objetos instanciar (o professor técnico, o material técnico, a avaliação técnica) quando os métodos são chamados. Em resumo: uma define o "o quê", a outra resolve o "como".

---

## Pergunta 7
Por que `SalaDeAula` não precisa saber se está trabalhando com uma escola pública, privada ou técnica?

## Resposta:
Porque `SalaDeAula` depende apenas da interface `EscolaFactory` (e das interfaces dos produtos, como `Professor` e `MaterialDidatico`), nunca de uma implementação concreta. Toda a responsabilidade de decidir qual variante de escola está em jogo fica isolada dentro da fábrica escolhida. Isso significa que `SalaDeAula` pode operar com qualquer tipo de escola sem precisar de um `if` ou `switch` verificando o tipo — ela simplesmente usa o que a fábrica entrega.

---

## Pergunta 8
Qual vantagem existe em programar usando a interface `Professor`?

## Resposta:
Programar contra a interface `Professor`, em vez de uma classe concreta, permite que o restante do código trabalhe com qualquer tipo de professor (público, privado ou técnico) sem precisar conhecer os detalhes de cada implementação. Isso reduz o acoplamento entre as partes do sistema e torna mais fácil trocar ou adicionar novos tipos de professor no futuro, sem tocar no código que já depende da interface.

---

## Pergunta 9
Ao acrescentar `EscolaTecnicaFactory`, foi necessário modificar `SalaDeAula`? O que isso demonstra sobre o Abstract Factory?

## Resposta:
Não, `SalaDeAula` continuou funcionando sem nenhuma alteração. Isso demonstra bem o principal benefício do Abstract Factory: como o código cliente depende apenas de abstrações (interfaces), é possível incluir novas famílias de produtos — nesse caso, a escola técnica — apenas criando uma nova fábrica concreta, sem mexer em nada que já estava pronto. Isso está diretamente alinhado ao princípio Aberto/Fechado: o sistema fica aberto para extensão, mas fechado para modificação.