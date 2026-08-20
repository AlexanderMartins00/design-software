# ADR-0002 — Extração de responsabilidades

Contexto: `EduSmartService` concentrava matrícula, notas e fechamento de turma.
Decisão: extrair `EnrollmentService`, `GradeService` e `ClassClosingService`.
Vantagens: cada fluxo fica menor e pode ser testado separadamente.
Desvantagens: há mais classes e dependências entre serviços.
