# EduSmart — Projeto Semestral

O EduSmart simula uma plataforma educacional com cursos, turmas, professores, alunos, matrículas, avaliações, notas e notificações.

O código inicial **compila e executa**, mas representa um sistema legado propositalmente imperfeito. O aluno deverá analisar e evoluir o projeto progressivamente conforme os conteúdos trabalhados em aula.

## Escopo inicial
- cursos e turmas;
- professores e alunos;
- matrícula;
- avaliações e notas;
- cálculo de resultado;
- notificações;
- integração com sistema acadêmico externo.

## Execução
Requer Java 17.

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out br.edu.edusmart.Main
```

As atividades estão em `atividades/README_EduSmart_AulaXX.md`.

> A presença de classes com nomes de padrões não significa que os padrões estejam corretamente aplicados. O aluno deve justificar problema, necessidade, solução e consequências.
