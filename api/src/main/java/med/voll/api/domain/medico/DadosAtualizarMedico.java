package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizarMedico(
  @NotNull
  Long id,
  String nome,
  String telefone,
  Especialidade especialidade,
  DadosEndereco endereco
) {}
