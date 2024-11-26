import java.util.Scanner;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ClinicaMedica clinicaMedica = new ClinicaMedica();
		SistemaDeEventos sistemaDeEventos = new SistemaDeEventos();
		SistemaDeRestaurante sistemaDeRestaurante = new SistemaDeRestaurante();

		while (true) {
			System.out.println("===== MENU PRINCIPAL =====");
			System.out.println("1. Sistema de Clínica Médica");
			System.out.println("2. Sistema de Eventos");
			System.out.println("3. Sistema de Restaurante");
			System.out.println("4. Gerenciar Evento Beneficente");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				menuClinicaMedica(clinicaMedica, scanner);
				break;
			case 2:
				menuSistemaDeEventos(sistemaDeEventos, scanner);
				break;
			case 3:
				menuSistemaDeRestaurante(sistemaDeRestaurante, scanner);
				break;
			case 4:
				gerenciarEventoBeneficente(clinicaMedica, sistemaDeRestaurante, scanner);
				break;
			case 5:
				System.out.println("Saindo do sistema...");
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private static void menuClinicaMedica(ClinicaMedica clinica, Scanner scanner) {
        while (true) {
            System.out.println("===== MENU CLÍNICA MÉDICA =====");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Listar Consultas");
            System.out.println("5. Buscar Paciente (por CPF)");
            System.out.println("6. Buscar Paciente (por Nome e CPF)");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
    
            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    clinica.cadastrarPaciente(nomePaciente, cpfPaciente);
                    System.out.println("Paciente cadastrado com sucesso.");
                    break;
                case 2:
                    System.out.print("Nome do médico: ");
                    String nomeMedico = scanner.nextLine();
                    System.out.print("Especialidade do médico: ");
                    String especialidade = scanner.nextLine();
                    clinica.cadastrarMedico(nomeMedico, especialidade);
                    System.out.println("Médico cadastrado com sucesso.");
                    break;
                case 3:
                    System.out.print("CPF do paciente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidadeConsulta = scanner.nextLine();
                    System.out.print("Data da consulta: ");
                    String dataConsulta = scanner.nextLine();
                    clinica.agendarConsulta(cpf, especialidadeConsulta, dataConsulta);
                    break;
                case 4:
                    clinica.listarConsultas();
                    break;
                case 5:
                    System.out.print("Digite o CPF do paciente: ");
                    String cpfBusca = scanner.nextLine();
                    Paciente paciente = clinica.buscarPaciente(cpfBusca);
                    if (paciente != null) {
                        System.out.println("Paciente encontrado: " + paciente.getNome());
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Digite o Nome do paciente: ");
                    String nomeBusca = scanner.nextLine();
                    System.out.print("Digite o CPF do paciente (opcional): ");
                    String cpfBusca2 = scanner.nextLine();
                    List<Paciente> pacientes = clinica.buscarPaciente(nomeBusca, cpfBusca2);
                    if (!pacientes.isEmpty()) {
                        System.out.println("Pacientes encontrados:");
                        for (Paciente p : pacientes) {
                            System.out.println("- " + p.getNome() + " (CPF: " + p.getCpf() + ")");
                        }
                    } else {
                        System.out.println("Nenhum paciente encontrado.");
                    }
                    break;
                case 7:
                    return; 
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }



	private static void menuSistemaDeRestaurante(SistemaDeRestaurante sistema, Scanner scanner) {
		while (true) {
			System.out.println("===== MENU RESTAURANTE =====");
			System.out.println("1. Adicionar Item ao Cardapio");
			System.out.println("2. Registrar Pedido");
			System.out.println("3. Verificar Pedidos e Mesas");
			System.out.println("4. Voltar");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine(); 

			switch (opcao) {
			case 1:
				System.out.print("Nome do item: ");
				String nomeItem = scanner.nextLine();
				System.out.print("Preço do item: ");
				double precoItem = scanner.nextDouble();
				scanner.nextLine();
				sistema.adicionarItemAoCardapio(nomeItem, precoItem);
				System.out.println("Item adicionado ao cardápio.");
				break;
			case 2:
				System.out.print("Número da mesa: ");
				int numeroMesa = scanner.nextInt();
				scanner.nextLine();
				Pedido pedido = new Pedido();
				while (true) {
					sistema.exibirCardapio();
					System.out.print("Escolha o número do item (0 para finalizar): ");
					int escolha = scanner.nextInt();
					scanner.nextLine();
					if (escolha == 0) break;
					ItemDoPedido item = sistema.getItemDoCardapio(escolha - 1);
					if (item != null) {
						pedido.adicionarItem(item);
					} else {
						System.out.println("Item inválido.");
					}
				}
				sistema.registrarPedido(numeroMesa, pedido);
				System.out.println("Pedido registrado na mesa " + numeroMesa + ".");
				break;
			case 3:
				sistema.checarMesas();
				break;
			case 4:
				return; 
			default:
				System.out.println("Oppção inválida.");
			}
		}
	}
	
private static void menuSistemaDeEventos(SistemaDeEventos sistema, Scanner scanner) {
    while (true) {
        System.out.println("===== MENU SISTEMA DE EVENTOS =====");
        System.out.println("1. Registrar Evento");
        System.out.println("2. Registrar Participante");
        System.out.println("3. Listar Eventos");
        System.out.println("4. Buscar Evento por Nome");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                System.out.print("Nome do evento: ");
                String nomeEvento = scanner.nextLine();
                System.out.print("Data do evento: ");
                String dataEvento = scanner.nextLine();
                System.out.print("Valor do ingresso: ");
                double valorIngresso = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Nome do local: ");
                String nomeLocal = scanner.nextLine();
                System.out.print("Endereço do local: ");
                String enderecoLocal = scanner.nextLine();
                Local local = new Local(nomeLocal, enderecoLocal);
                sistema.registrarEvento(nomeEvento, dataEvento, valorIngresso, local);
                break;
            case 2:
                System.out.print("Nome do evento: ");
                String eventoNome = scanner.nextLine();
                System.out.print("Nome do participante: ");
                String nomeParticipante = scanner.nextLine();
                System.out.print("Tipo de ingresso: ");
                String tipoIngresso = scanner.nextLine();
                Participante participante = new Participante(nomeParticipante, tipoIngresso);
                sistema.adicionarParticipante(eventoNome, participante);
                break;
            case 3:
                sistema.listarEventos();
                break;
            case 4:
                System.out.print("Digite o nome do evento: ");
                String buscaNome = scanner.nextLine();
                Evento evento = sistema.buscarEventoPorNome(buscaNome);
                if (evento != null) {
                    System.out.println(evento);
                } else {
                    System.out.println("Evento não encontrado.");
                }
                break;
            case 5:
                return; 
            default:
                System.out.println("Opção inválida.");
        }
    }
}



	private static void gerenciarEventoBeneficente(ClinicaMedica clinica, SistemaDeRestaurante restaurante, Scanner scanner) {
		System.out.print("Nome do evento beneficente: ");
		String nomeEvento = scanner.nextLine();
		System.out.print("Data do evento: ");
		String dataEvento = scanner.nextLine();
		System.out.print("Quantidade de marmitas: ");
		int quantidadeMarmitas = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Escolha um médico:");
		List<Medico> medicos = clinica.getMedicos();
		for (int i = 0; i < medicos.size(); i++) {
			System.out.println((i + 1) + ". " + medicos.get(i).getNome() + " (" + medicos.get(i).getEspecialidade() + ")");
		}
		int escolhaMedico = scanner.nextInt() - 1;
		scanner.nextLine();

		if (escolhaMedico < 0 || escolhaMedico >= medicos.size()) {
			System.out.println("Médico inválido.");
			return;
		}
		Medico medicoEscolhido = medicos.get(escolhaMedico);

		restaurante.exibirCardapio();
		System.out.print("Escolha o número do prato: ");
		int escolhaPrato = scanner.nextInt() - 1;
		scanner.nextLine();

		ItemDoPedido pratoEscolhido = restaurante.getItemDoCardapio(escolhaPrato);
		if (pratoEscolhido == null) {
			System.out.println("Prato inválido.");
			return;
		}

		EventoBeneficente evento = new EventoBeneficente(nomeEvento, dataEvento, 0, medicoEscolhido, pratoEscolhido, quantidadeMarmitas);
		evento.mostrarDetalhes();
	}
}
