INSERT INTO funcionario
(cpf_funcionario, nome, cargo, endereco, telefone, email)
values
('08731834820','Paulo da Silva', 'Recepcionista', 'Rua novaz 303 - Cabral - Curitiba - Parana', '(41) 98808-8808', 'joaosilva@gmail.com'),
('08731834821','Pedro da Silva', 'Tecnico', 'Rua novaz 404 - Cabral - Curitiba - Parana', '(41) 98808-1234', 'pedrosilva@gmail.com');


INSERT INTO ordem_servico
(codigo, nome, cpf, endereco, telefone, email, data_inicio, equipamento, status_os, descricao, funcionario)
values
('1', 'Silvia Monteiro', '08614467820', 'Rua Pinhais 134 - Capão Raso - Curitiba - Paraná', '(41) 98772-1819', 'silviamonteiro@gmail.com', '2022-11-10 12:23:34', 'Telefone - Motorola - G6', 'Aberto', 'Tela quebrada', '08731834820'),
('2', 'Marcio Monteiro', '08614467822', 'Rua Pinhais 431 - Capão Raso - Curitiba - Paraná', '(41) 98772-1819', 'silviamonteiro@gmail.com', '2022-11-10 12:23:34', 'Telefone - Motorola - G6', 'Aberto', 'Tela quebrada', '08731834820');

INSERT INTO alteracaoos
(id, codigo, num_alteracao, descricao, funcionario,  data_alt, status_os)
values
('1', '1', '1', 'Pedido compra tela nova Motorola G6', '08731834820', '2022-11-11 19:30:12', 'Em andamento'),
('2', '1', '2', 'Troca de tela efetuada', '08731834820', '2022-11-11 19:30:12', 'Finalizado');