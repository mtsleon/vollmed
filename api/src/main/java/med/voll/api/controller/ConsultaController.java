package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.consultas.DadosDetalhamentoConsulta;
import med.voll.api.domain.consultas.ValidacaoAgendamentoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {


  @Autowired
  private MedicoRepository medicoRepository;

  @Autowired
  private PacienteRepository pacienteRepository;

  @PostMapping
  @Transactional
  public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
    
    if(!pacienteRepository.existsById(dados.idPaciente())) {
      throw new ValidacaoAgendamentoException("Id do paciente informado não existe!");
    }

    if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
      throw new ValidacaoAgendamentoException("Id do médico informado não existe!");
    }
        
    var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
    var medico = escolherMedico(dados);

    // var consulta = new Consulta(null, medico, paciente, dados.data());

    return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
  }

  private Medico escolherMedico(DadosAgendamentoConsulta dados) {

    if(dados.idMedico() != null) {
      return medicoRepository.getReferenceById(dados.idMedico());
    }

    if(dados.especialidade() == null) {
      throw new ValidacaoAgendamentoException("A 'especialidade' é obrigatória quando o médico não for escolhido!");
    }

    return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
  }

}
