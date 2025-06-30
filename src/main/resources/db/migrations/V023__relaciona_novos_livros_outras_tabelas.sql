

INSERT INTO livros_categorias (liv_id, ctl_id) VALUES
(6, 6), (6, 4),
(7, 6), (7, 8),
(8, 4), (8, 6),
(9, 6), (9, 2),
(10, 5),
(11, 2), (11, 3),
(12, 3),
(13, 3), (13, 9),
(14, 3), (14, 9),
(15, 3),
(16, 9),
(17, 2), (17, 9),
(18, 3), (18, 9),
(19, 8),
(20, 4), (20, 8),
(21, 6), (21, 9),
(22, 3), (22, 9),
(23, 3), (23, 9),
(24, 7),
(25, 4), (25, 9),
(26, 3), (26, 9),
(27, 3),
(28, 4), (28, 6),
(29, 3),
(30, 3), (30, 9);

INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 6, 15);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 7, 12);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 8, 0);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 9, 9);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 10, 17);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 11, 22);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 12, 13);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 13, 0);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 14, 6);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 15, 25);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 16, 11);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 17, 19);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 18, 8);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 19, 14);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 20, 10);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 21, 5);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 22, 18);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 23, 9);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 24, 20);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 25, 16);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 26, 7);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 27, 23);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 28, 0);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 29, 2);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 30, 30);

UPDATE livros
SET liv_sinopse = 'Primeiro livro da aclamada série de fantasia de J.K. Rowling. A história começa apresentando Harry Potter, um órfão que vive uma vida miserável com seus cruéis tios, os Dursley, que o maltratam e o mantêm ignorante sobre sua verdadeira origem. No dia de seu décimo primeiro aniversário, a vida de Harry muda drasticamente. Ele recebe uma carta de admissão para a Escola de Magia e Bruxaria de Hogwarts, revelando que ele é um bruxo. Harry é então levado a um mundo mágico completamente novo, onde faz amizade com Ron Weasley e Hermione Granger, que se tornam seus melhores amigos. Juntos, eles descobrem os segredos de Hogwarts e aprendem sobre feitiços, poções e quadribol. Durante o ano, Harry e seus amigos começam a suspeitar que algo precioso está sendo guardado em Hogwarts e que alguém está tentando roubá-lo. Eles descobrem que se trata da Pedra Filosofal, um artefato mágico que pode conceder imortalidade e transformar qualquer metal em ouro. A pedra está sendo protegida por uma série de encantamentos criados pelos professores da escola. No clímax da história, Harry confronta o verdadeiro vilão e descobre a identidade de quem está tentando roubar a Pedra Filosofal, além de ter um novo encontro com o resquício de Lord Voldemort.'
WHERE liv_id = 1;

UPDATE livros
SET liv_sinopse = 'O primeiro volume da aclamada série de livros As Crônicas de Gelo e Fogo, de George R. R. Martin. A história se passa nos continentes ficcionais de Westeros e Essos, num mundo onde as estações podem durar anos ou até décadas. A trama principal se desenrola em Westeros, um continente dividido em Sete Reinos, governados pelo Rei Robert Baratheon. Após a misteriosa morte de Jon Arryn, a Mão do Rei (o principal conselheiro do monarca), o Rei Robert convida seu velho amigo, Lorde Eddard "Ned" Stark, o honrado Guardião do Norte, para assumir o cargo. Ned se vê imerso em um ninho de intrigas, traições e conspirações dentro da corte, especialmente com a poderosa e manipuladora Casa Lannister. Ned logo descobre segredos sombrios que o colocam em grande perigo. Paralelamente, do outro lado do Mar Estreito, os últimos remanescentes da deposta Casa Targaryen, buscam retomar o Trono de Ferro. Viserys Targaryen casa sua jovem irmã, Daenerys Targaryen, com Khal Drogo, um poderoso líder da tribo guerreira Dothraki, em troca de um exército para invadir Westeros. O livro é um mergulho em um mundo complexo, com múltiplos pontos de vista, onde a lealdade é testada, a honra colide com a política e a violência é uma constante.'
WHERE liv_id = 2;

UPDATE livros
SET liv_sinopse = 'O primeiro volume da épica trilogia de fantasia de J.R.R. Tolkien, O Senhor dos Anéis. A história começa na pacífica e pitoresca região do Condado, lar dos pequenos e adoráveis Hobbits. O enredo principal gira em torno de Frodo Bolseiro, um jovem Hobbit que herda um anel mágico de seu tio, Bilbo Bolseiro. No entanto, o anel não é uma joia comum; ele é o Um Anel, forjado há muito tempo pelo maligno Senhor do Escuro, Sauron, para dominar todos os outros anéis de poder e, por consequência, toda a Terra Média. O Um Anel possui uma vontade própria e uma influência corruptora sobre seu portador, além de buscar retornar ao seu mestre. O mago Gandalf, um velho amigo de Bilbo e Frodo, descobre a verdadeira natureza do Um Anel e o perigo iminente que ele representa. Sauron, que foi derrotado em eras passadas, está ressurgindo e buscando seu Anel para recuperar seu poder total e mergulhar a Terra Média nas trevas. Diante da ameaça, Frodo é incumbido de uma missão perigosa: levar o Um Anel para fora do Condado e entregá-lo para que seu destino seja decidido. Ele parte acompanhado de seu fiel jardineiro e amigo, Samwise Gamgee. A jornada os leva a encontrar outros companheiros: os Hobbits Merry Brandybuck e Pippin Took, o elfo Legolas, o anão Gimli, o misterioso e solitário Aragorn e o valente homem Boromir. Eles viajam para Rivendell (Valfenda), um refúgio élfico, onde um conselho é formado para decidir o que fazer com o Anel. Após muitas discussões e diante da impossibilidade de destruí-lo por meios comuns, ou de usá-lo contra Sauron sem cair em sua influência, é decidido que o Anel deve ser levado ao único lugar onde pode ser destruído: as Fendas da Perdição, no coração da terra de Sauron, Mordor. Para cumprir essa missão aparentemente impossível, é formada a Sociedade do Anel: Frodo, Sam, Gandalf, Legolas, Gimli, Aragorn, Boromir, Merry e Pippin. Juntos, eles embarcam em uma jornada épica através de paisagens perigosas, enfrentando orcs, trolls e outras criaturas malignas, além de lidar com a crescente tentação e poder corruptor do Um Anel. O livro culmina com a desintegração da Sociedade do Anel devido a forças externas e internas, preparando o palco para as aventuras e desafios que virão nos próximos volumes.'
WHERE liv_id = 3;

UPDATE livros
SET liv_sinopse = 'Uma coletânea de contos de ficção científica escritos por Isaac Asimov, publicada em 1950. Embora seja uma coletânea de histórias curtas, elas estão interligadas por um tema central: a interação entre humanos e robôs positrônicos, e as implicações das Três Leis da Robótica. Os contos são apresentados como uma série de entrevistas com a Dra. Susan Calvin, uma robopsicóloga que trabalhou para a U.S. Robots and Mechanical Men, Inc. (a principal fabricante de robôs), durante décadas. Através de suas memórias e experiências, somos levados a diferentes épocas e cenários onde os robôs desempenham papéis cruciais, e onde as Três Leis são postas à prova. Cada conto explora um dilema ético, lógico ou social diferente que surge da aplicação ou da interpretação dessas leis. Asimov demonstra como, mesmo com essas regras aparentemente perfeitas, surgem situações complexas e paradoxos. A coletânea Eu, Robô não é apenas uma série de histórias de ficção científica; é uma profunda reflexão sobre a inteligência artificial, a moralidade, a liberdade e o que significa ser humano.'
WHERE liv_id = 4;

UPDATE livros
SET liv_sinopse = 'Um dos mais célebres romances policiais de Agatha Christie, apresentando seu famoso detetive belga, Hercule Poirot. A história se passa em uma noite de inverno, a bordo do luxuoso trem Expresso do Oriente, que viaja de Istambul para Calais. Poirot, que está a caminho de Londres, encontra-se entre um grupo diversificado de passageiros, cada um com sua própria história e segredos. A trama se inicia quando o trem é parado por uma forte nevasca nos Bálcãs, isolando-o completamente do mundo exterior. É nessa noite que o impensável acontece: Samuel Ratchett, um passageiro americano rico e desagradável, é encontrado morto em sua cabine, esfaqueado doze vezes. A porta de sua cabine estava trancada por dentro, sugerindo que o assassino ainda está no trem. Com o trem preso e sem contato com as autoridades locais, cabe a Poirot a difícil tarefa de investigar o crime. Ele logo descobre que Ratchett não era quem parecia ser; na verdade, ele era Cassetti, um criminoso procurado que havia escapado da justiça após o sequestro e assassinato de uma criança, Daisy Armstrong, anos antes. À medida que Poirot interroga os doze passageiros, ele se depara com uma rede de mentiras, segredos e álibis que parecem se encaixar perfeitamente, mas que, ao mesmo tempo, são contraditórios. Com sua mente brilhante e seu famoso método de dedução, Poirot começa a desvendar a complexa teia de eventos. Ele percebe que o caso não é tão simples quanto parece e que as aparências enganam profundamente. O detetive é confrontado com duas possíveis soluções para o crime, uma das quais é chocante e sem precedentes, testando seus princípios morais e sua noção de justiça. Assassinato no Expresso do Oriente é um clássico do gênero whodunit, conhecido por seu enredo engenhoso, reviravoltas surpreendentes e um final inesperado que desafia as convenções do crime e da punição.'
WHERE liv_id = 5;

UPDATE livros
SET liv_sinopse = 'Uma jornada épica de ficção científica que explora a evolução humana, a inteligência artificial e a busca por vida extraterrestre. A história acompanha a descoberta de um misterioso monolito na Lua, que emite um sinal em direção a Júpiter. Uma equipe de astronautas, a bordo da nave Discovery One e assistidos pelo avançado computador com inteligência artificial HAL 9000, embarca em uma missão para investigar a origem do sinal. À medida que se aproximam de seu destino, eventos inesperados e perturbadores desafiam a compreensão da equipe sobre a tecnologia, a existência e o futuro da humanidade. O livro é uma profunda meditação sobre a nossa place no cosmos.'
WHERE liv_id = 6;

UPDATE livros
SET liv_sinopse = 'O romance distópico que serviu de base para o filme Blade Runner. A trama se passa em uma Terra pós-apocalíptica devastada pela Guerra Mundial Terminus, onde a maioria dos animais verdadeiros está extinta e muitos humanos emigraram para outros planetas. Os que permaneceram na Terra usam animais elétricos como substitutos. O protagonista, Rick Deckard, é um caçador de recompensas que tem como trabalho "aposentar" (matar) replicantes — androides avançados que se rebelaram e fugiram de Marte para a Terra. À medida que Deckard persegue seu objetivo, ele é forçado a confrontar a natureza da vida, a empatia e o que realmente define a humanidade, em uma sociedade onde a linha entre o orgânico e o sintético é cada vez mais tênue.'
WHERE liv_id = 7;

UPDATE livros
SET liv_sinopse = 'Uma envolvente história que mergulha no conflito entre deuses antigos e modernos nos Estados Unidos. A narrativa acompanha Shadow Moon, um ex-condenado recém-libertado da prisão, cuja vida é virada de cabeça para baixo quando sua esposa e seu melhor amigo morrem em um acidente. Sem rumo, ele encontra o misterioso Sr. Wednesday (Quarta-feira), que o contrata como seu guarda-costas e o arrasta para uma jornada bizarra e perigosa pelos Estados Unidos. Shadow descobre que Wednesday é, na verdade, uma encarnação do deus nórdico Odin, e que ele está recrutando outros deuses antigos — trazidos para a América pelos imigrantes e agora esquecidos — para uma guerra iminente contra os Novos Deuses: as divindades do século XXI, que representam a tecnologia, a mídia, a globalização e o consumo. É uma reflexão rica sobre fé, crença e a identidade cultural americana.'
WHERE liv_id = 8;

UPDATE livros
SET liv_sinopse = 'Um clássico seminal da ficção científica que popularizou o conceito de viagem no tempo. A história segue um cientista, conhecido apenas como o "Viajante do Tempo", que constrói uma máquina capaz de transportá-lo para o futuro. Ele decide viajar para o ano 802.701 d.C. e se depara com um cenário distópico onde a humanidade se dividiu em duas raças distintas: os Eloi, seres frágeis, infantis e aparentemente idílicos que vivem na superfície, e os Morlocks, criaturas subterrâneas, brutais e canibais que mantêm os Eloi como gado. O Viajante do Tempo tenta desvendar o que causou essa decadência social e biológica, enquanto luta para sobreviver e encontrar uma maneira de retornar ao seu próprio tempo. A obra é uma alegoria social que reflete sobre a evolução, as classes sociais e o futuro da civilização.'
WHERE liv_id = 9;

UPDATE livros
SET liv_sinopse = 'Um épico de horror que aterroriza uma cidade do Maine chamada Derry através de um mal ancestral. A história se desenrola em duas linhas do tempo: uma em 1958 e outra em 1985. Em 1958, um grupo de sete crianças, autodenominado "O Clube dos Perdedores", enfrenta uma entidade maligna e metamórfica conhecida como "A Coisa", que se manifesta principalmente como o palhaço Pennywise. A Coisa se alimenta do medo e da vida das crianças, surgindo a cada 27 anos para um novo ciclo de terror. Vinte e sete anos depois, em 1985, os "Perdedores", agora adultos e com suas memórias da infância suprimidas, são chamados de volta a Derry quando A Coisa ressurge. Eles devem se reunir para cumprir uma promessa feita na infância e, finalmente, tentar derrotar essa força maligna de uma vez por todas, enquanto confrontam seus próprios medos e traumas passados.'
WHERE liv_id = 10;

UPDATE livros
SET liv_sinopse = 'Um clássico da literatura americana que narra a jornada de um jovem pela liberdade e pela consciência moral. A história segue Huckleberry "Huck" Finn, um garoto órfão que foge de seu pai alcoólatra e abusivo. Ele se junta a Jim, um escravo fugitivo, e juntos eles embarcam em uma perigosa viagem rio abaixo pelo rio Mississippi em uma jangada. Ao longo do percurso, Huck e Jim encontram uma variedade de personagens, tanto perigosos quanto bem-intencionados, e enfrentam os desafios de uma sociedade racista e moralmente ambígua no sul dos Estados Unidos antes da Guerra Civil. A narrativa de Huck, escrita em um dialeto regional autêntico, explora temas como a escravidão, a amizade, a busca pela liberdade e a formação da moralidade individual em contraste com as normas sociais.'
WHERE liv_id = 11;

UPDATE livros
SET liv_sinopse = 'Um dos mais amados romances clássicos da literatura inglesa. Ambientado na Inglaterra do século XIX, a história foca na família Bennet, em particular nas cinco filhas e na urgência de casá-las para garantir seu futuro financeiro e social. A protagonista, Elizabeth Bennet, é uma jovem inteligente, espirituosa e independente, que se recusa a se curvar às expectativas sociais de sua época. O enredo principal gira em torno do relacionamento complexo e cheio de idas e vindas entre Elizabeth e o rico e aparentemente arrogante Sr. Darcy. Através de mal-entendidos, falsas primeiras impressões e a superação do orgulho e do preconceito de ambos os personagens, eles aprendem a ver além das aparências e a reconhecer o verdadeiro amor. O romance é uma crítica perspicaz às convenções sociais, às expectativas sobre o casamento e à distinção de classes da época.'
WHERE liv_id = 12;

UPDATE livros
SET liv_sinopse = 'Um drama histórico épico ambientado durante a Revolução Francesa, com o enredo dividido entre Londres e Paris. A história começa com a libertação de Dr. Alexandre Manette, um médico francês que passou dezoito anos preso na Bastilha. Sua filha, Lucie Manette, viaja a Paris para resgatá-lo e trazê-lo de volta a Londres. Anos depois, Lucie se casa com Charles Darnay, um nobre francês que renunciou a seus títulos e herança devido à tirania de sua família. No entanto, o passado de Darnay o alcança quando ele é levado de volta à França revolucionária, onde é acusado e preso pela guilhotina. O livro tece uma intrincada trama de amor, sacrifício, redenção e os horrores da Revolução, explorando temas como ressurreição, sacrifício e a capacidade humana para a crueldade e a compaixão. O advogado inglês Sydney Carton, com sua notável semelhança com Darnay, desempenha um papel crucial no clímax da história.'
WHERE liv_id = 13;

UPDATE livros
SET liv_sinopse = 'Um romance icônico que captura a essência da "Era do Jazz" nos anos 1920 nos Estados Unidos e a busca pelo sonho americano. A história é narrada por Nick Carraway, um jovem que se muda para West Egg, um bairro rico de Long Island, e se torna vizinho do misterioso e extravagante milionário Jay Gatsby. As festas luxuosas e grandiosas de Gatsby, repletas de socialites e aspirantes, são famosas, mas ninguém parece saber a verdade por trás de sua fortuna. Nick logo descobre que a verdadeira motivação de Gatsby para sua riqueza e sua vida de excessos é reconquistar o amor de Daisy Buchanan, seu amor do passado, agora casada com o brutal Tom Buchanan. O livro é uma crítica social mordaz à superficialidade da riqueza, à decadência moral e à ilusão do sonho americano, culminando em uma tragédia que expõe a fragilidade e a corrupção por trás do brilho da era.'
WHERE liv_id = 14;

UPDATE livros
SET liv_sinopse = 'Uma novela clássica que narra a épica e solitária luta de um velho pescador cubano. A história acompanha Santiago, um pescador que está em uma longa maré de azar, sem conseguir pescar nada por 84 dias. Determinado a quebrar essa maré, ele se aventura sozinho em seu pequeno barco para o Golfo, mais longe do que o habitual. Lá, ele fisga um gigantesco marlim, muito maior do que qualquer peixe que já tenha visto. O livro descreve em detalhes a batalha de Santiago contra o marlim, uma luta épica e exaustiva que dura dias e noites, testando sua força física, sua resistência, sua determinação e sua reverência pela natureza. A obra é uma poderosa alegoria sobre a perseverança, a dignidade humana, a derrota e a vitória, e a relação do homem com o mundo natural, onde a força e a sabedoria do velho pescador são postas à prova contra a imensidão do oceano e a grandiosidade da criatura que ele persegue.'
WHERE liv_id = 15;

UPDATE livros
SET liv_sinopse = 'Uma das mais famosas e complexas tragédias da literatura ocidental. A peça se centra no Príncipe Hamlet da Dinamarca, que está em luto profundo pela morte de seu pai, o Rei Hamlet. Sua tristeza é agravada pelo rápido casamento de sua mãe, a Rainha Gertrudes, com seu tio, Cláudio, que agora assume o trono. A aparição do fantasma do Rei Hamlet revela que ele foi assassinado por Cláudio, que derramou veneno em seu ouvido. O fantasma instrui Hamlet a vingar sua morte. Consumido pela dúvida, hesitação e um desejo avassalador por vingança, Hamlet mergulha em uma jornada de loucura aparente para investigar a verdade e planejar sua retaliação. A peça explora temas como a loucura, a traição, a moralidade, a vingança e a natureza da existência, culminando em uma série de mortes trágicas que levam à destruição da família real e à total desgraça do reino.'
WHERE liv_id = 16;

UPDATE livros
SET liv_sinopse = 'Um romance épico russo considerado uma das maiores obras da literatura mundial. Ambientado durante as Guerras Napoleônicas no início do século XIX, especialmente a invasão francesa da Rússia em 1812, o livro entrelaça as vidas de centenas de personagens, focando em cinco famílias aristocráticas: os Bezukhov, Bolkonsky, Rostov, Kuragin e Drubetskoy. A narrativa segue seus membros enquanto eles experimentam amor, perda, traição, glória e desespero em meio a eventos históricos grandiosos. Personagens centrais incluem o idealista Pierre Bezukhov, o ambicioso e orgulhoso Príncipe Andrei Bolkonsky, e a vibrante e apaixonada Natasha Rostova. Tolstói explora temas como o destino versus o livre-arbítrio, o propósito da história, a natureza do heroísmo e a busca pela felicidade e pelo sentido da vida, mesclando o drama pessoal com reflexões filosóficas profundas e descrições vívidas de batalhas e da sociedade russa da época.'
WHERE liv_id = 17;

UPDATE livros
SET liv_sinopse = 'Um profundo drama psicológico e filosófico que mergulha na mente de um assassino e nas consequências de seus atos. A história acompanha Rodion Raskólnikov, um ex-estudante universitário empobrecido em São Petersburgo, que, imbuído de uma teoria niilista sobre o direito de certos indivíduos "extraordinários" de cometer crimes em prol de um bem maior, planeja e executa o assassinato de uma velha e avarenta penhorista, e acidentalmente também de sua irmã. Após o crime, Raskólnikov é atormentado por uma intensa angústia, culpa e paranoia, que o levam à beira da loucura. Ele é perseguido por um astuto investigador, Porfírio Petróvich, que o interroga e o manipula psicologicamente. A trama explora temas como a moralidade, a liberdade, a culpa, a redenção, a alienação social e a luta entre o bem e o mal na alma humana, culminando na busca de Raskólnikov por confissão e punição, influenciado por sua relação com a devota Sônia Marmeládova.'
WHERE liv_id = 18;

UPDATE livros
SET liv_sinopse = 'Uma das obras mais célebres e perturbadoras da literatura moderna, um clássico do existencialismo e realismo mágico. A história começa com uma das frases mais famosas da literatura: "Quando Gregor Samsa acordou certa manhã de sonhos intranquilos, encontrou-se em sua cama metamorfoseado em um inseto monstruoso." Gregor, um caixeiro-viajante, descobre que se transformou em uma criatura gigante e repulsiva. A partir desse evento bizarro, o livro explora a reação de sua família e da própria sociedade à sua transformação. À medida que Gregor se torna cada vez mais isolado e uma aberração para sua família, a história aborda temas como a alienação, o absurdo da existência, a burocracia, a desumanização do trabalho e a indiferença das relações familiares. A Metamorfose é uma poderosa alegoria sobre a condição humana, a fragilidade da identidade e o impacto da doença e da dependência na dinâmica familiar.'
WHERE liv_id = 19;

UPDATE livros
SET liv_sinopse = 'Um romance que tece uma complexa tapeçaria de realismo mágico, mitologia e psicologia. A história acompanha duas narrativas paralelas aparentemente desconectadas que se entrelaçam. Uma delas segue Kafka Tamura, um adolescente que foge de casa no dia de seu 15º aniversário para escapar de uma profecia edipiana e de seu pai abusivo, buscando um novo começo e sua mãe e irmã perdidas. Ele encontra refúgio em uma biblioteca em Takamatsu. A outra narrativa acompanha Satoru Nakata, um idoso que, após um incidente misterioso na infância, perdeu a memória e a capacidade de ler, mas adquiriu a habilidade de conversar com gatos e encontrar objetos perdidos. Nakata embarca em uma jornada estranha após ser contratado para encontrar um gato desaparecido, o que o leva a um assassinato bizarro. O livro explora temas como o destino, o subconsciente, a memória, a solidão e a busca por identidade, em um universo onde sonhos e realidade se misturam de forma onírica e profunda.'
WHERE liv_id = 20;

UPDATE livros
SET liv_sinopse = 'Um romance satírico e antibelicista que utiliza elementos de ficção científica e não-linearidade narrativa para explorar o horror da guerra e o trauma. A história é narrada por Billy Pilgrim, um veterano da Segunda Guerra Mundial que se torna um optometrista próspero e um viajante no tempo. Billy foi capturado pelos alemães durante a guerra e sobreviveu ao bombardeio de Dresden, na Alemanha, que destruiu a cidade e causou uma devastação massiva. Ele também é abduzido por alienígenas do planeta Tralfamadore, que o ensinam sobre a natureza não-linear do tempo e o exibem em um zoológico. A narrativa alterna constantemente entre os diferentes períodos da vida de Billy – sua infância, a guerra, a vida pós-guerra e suas experiências com os Tralfamadorianos – revelando as cicatrizes emocionais e psicológicas da guerra. O livro é uma crítica pungente à violência, à aleatoriedade do sofrimento e à falta de sentido da guerra.'
WHERE liv_id = 21;

UPDATE livros
SET liv_sinopse = 'Um poderoso e comovente romance histórico que aborda os horrores da escravidão e o trauma pós-escravidão nos Estados Unidos. A história se passa em Ohio, em 1873, após a Guerra Civil, e segue Sethe, uma ex-escrava que vive em uma casa assombrada por um fantasma que ela acredita ser de sua filha que morreu sem nome. Sethe havia fugido da plantação Sweet Home, no Kentucky, e para evitar que seus filhos fossem levados de volta para a escravidão, cometeu um ato desesperado e trágico. A chegada de um homem misterioso de seu passado na plantação, Paul D, e a aparição de uma jovem enigmática chamada Beloved, que parece incorporar o espírito da filha morta, desenterram memórias reprimidas e verdades dolorosas. O romance é uma exploração profunda da memória, do luto, da maternidade, da identidade e dos legados persistentes da escravidão na psique de seus sobreviventes.'
WHERE liv_id = 22;

UPDATE livros
SET liv_sinopse = 'Um romance épico de realismo mágico que narra a saga multifacetada da família Buendía ao longo de várias gerações. A história se passa na mítica cidade de Macondo, fundada pelo patriarca da família, José Arcadio Buendía. O livro acompanha a ascensão e a queda dos Buendía, seus amores e paixões, suas guerras e suas loucuras, seus triunfos e suas tragédias, tudo isso pontuado por eventos fantásticos e elementos sobrenaturais que se misturam naturalmente com a realidade. Ao longo de cem anos, a família é atormentada por um ciclo de repetição, solidão e um destino inescapável. Márquez cria um universo rico e vibrante, repleto de personagens inesquecíveis, explorando temas como o tempo, a memória, a fundação e a destruição de civilizações, a fatalidade e a busca incessante por amor e significado.'
WHERE liv_id = 23;

UPDATE livros
SET liv_sinopse = 'O livro apresenta o texto completo do roteiro do aclamado filme de 1941, Cidadão Kane, dirigido e estrelado por Orson Welles. Considerado por muitos um dos maiores filmes de todos os tempos, a história acompanha a investigação de um repórter para desvendar o significado da última palavra pronunciada por Charles Foster Kane, um magnata da mídia excêntrico e recluso, antes de sua morte: "Rosebud". Através de entrevistas com aqueles que o conheceram – desde seus tutores até suas esposas e colegas de trabalho – a narrativa se desenrola em uma série de flashbacks não lineares, revelando as diferentes facetas da vida de Kane, sua ascensão ao poder e sua eventual solidão. O roteiro é uma obra de arte por si só, mostrando a genialidade narrativa e estrutural que revolucionou o cinema, explorando temas como o poder, a corrupção, a ambição, a perda e a impossibilidade de conhecer verdadeiramente outra pessoa.'
WHERE liv_id = 24;

UPDATE livros
SET liv_sinopse = 'Uma distopia feminista e um poderoso romance de advertência. A história se passa na fictícia República de Gilead, uma teocracia totalitária e ultraconservadora que se estabeleceu nos antigos Estados Unidos após uma série de desastres ambientais e uma queda drástica na taxa de natalidade. Neste regime opressivo, as mulheres são privadas de seus direitos e categorizadas rigidamente: Esposas, Marthas (servas), Tias (instrutoras) e Aias. A protagonista, Offred (Off-red, que significa "de Fred", indicando sua posse), é uma Aia, cuja única função é procriar para os Comandantes estéreis e suas esposas, em um ritual de estupro sancionado. O livro é uma exploração aterrorizante da opressão, da perda da liberdade, da vigilância constante e da luta pela sobrevivência e pela identidade em um sistema que tenta desumanizar completamente as mulheres, enquanto Offred tenta encontrar uma maneira de resistir e talvez escapar.'
WHERE liv_id = 25;

UPDATE livros
SET liv_sinopse = 'Um emocionante romance que explora temas como amizade, traição, culpa, redenção e a história tumultuada do Afeganistão. A trama segue a vida de Amir, um garoto rico e privilegiado de Cabul, e seu leal amigo Hassan, filho do servo de seu pai, um membro da etnia hazara. A profunda amizade entre eles é testada por um ato de covardia de Amir e um evento traumático que ele testemunha e não consegue evitar, resultando na separação dos dois meninos. Anos depois, Amir vive nos Estados Unidos e se torna um escritor, mas é assombrado por seu passado. Ele recebe um chamado para retornar ao Afeganistão, agora sob o regime do Talibã, para buscar redenção e fazer as pazes com seu passado, em uma jornada perigosa que revela segredos familiares e o força a confrontar as consequências de suas escolhas.'
WHERE liv_id = 26;

UPDATE livros
SET liv_sinopse = 'Uma novela poderosa e comovente que retrata a dura realidade dos trabalhadores rurais durante a Grande Depressão nos Estados Unidos. A história segue a dupla inseparável de amigos George Milton e Lennie Small. George é um homem inteligente e protetor, enquanto Lennie é um homem grande e forte, mas com deficiência intelectual e uma mente infantil, que tem uma paixão perigosa por tocar coisas macias. Ambos trabalham como peões itinerantes, sonhando em um dia comprar seu próprio pedaço de terra e "viver da gordura da terra", cultivando a própria comida e criando coelhos. A amizade deles e seu sonho são constantemente ameaçados pelos desafios da vida em fazendas, pela solidão e pelos perigos que a ingenuidade de Lennie atrai. O livro é uma meditação sobre a natureza da amizade, a busca pelo sonho americano, a fragilidade da esperança e o papel da sociedade na determinação do destino dos indivíduos.'
WHERE liv_id = 27;

UPDATE livros
SET liv_sinopse = 'Um dos mais influentes e aterrorizantes romances distópicos já escritos, um alerta atemporal sobre os perigos do totalitarismo e da vigilância governamental extrema. A história se passa na Oceania, uma das três superpotências globais, onde o regime é controlado pelo Partido, liderado pela figura onipresente, mas nunca vista, do Grande Irmão. O protagonista, Winston Smith, trabalha no Ministério da Verdade, reescrevendo a história para se alinhar com as narrativas oficiais do Partido. Em um mundo onde o "Duplipensar" é a norma, a liberdade de pensamento e a individualidade são suprimidas pela vigilância constante (tele-telas em cada casa), pela manipulação da linguagem (Novilíngua) e pela Polícia do Pensamento. Winston, no entanto, nutre um desejo secreto de rebelião e busca amor e verdade em um ambiente onde ambos são proibidos. O livro é uma exploração sombria do poder, da manipulação da realidade, da perda da identidade e das consequências devastadoras de um regime que controla cada aspecto da vida de seus cidadãos.'
WHERE liv_id = 28;

UPDATE livros
SET liv_sinopse = 'Um romance de formação que se tornou um marco na literatura americana e um ícone para a juventude. A história é narrada em primeira pessoa por Holden Caulfield, um adolescente de 16 anos que foi expulso de sua quarta escola preparatória. A narrativa segue Holden em sua jornada existencial e desiludida por Nova York durante o fim de semana antes de voltar para casa e enfrentar seus pais. Através de sua voz cínica, irônica e profundamente vulnerável, Holden expressa seu desgosto pelo "mundo dos adultos" e sua hipocrisia, referindo-se a eles como "falsos". Ele busca pureza e autenticidade em um mundo que ele percebe como corrupto, sonhando em ser um "apanhador no campo de centeio" – alguém que impede as crianças de caírem de um precipício. O livro explora temas como a alienação, a rebeldia adolescente, a perda da inocência, a busca por identidade e a dificuldade de lidar com a transição da infância para a vida adulta.'
WHERE liv_id = 29;

UPDATE livros
SET liv_sinopse = 'Um impactante romance histórico que narra as vidas de diversos personagens durante a Guerra Civil da Nigéria (1967-1970), também conhecida como a Guerra de Biafra. A história é centrada em três personagens principais: Olanna, uma mulher de uma família rica que abandona sua vida privilegiada para viver com seu amante, um professor revolucionário; Kainene, a irmã gêmea de Olanna, uma mulher de negócios forte e pragmática; e Ugwu, um jovem camponês que se torna o serviçal de Olanna e seu amante. O romance explora as complexidades da guerra através de seus olhos, mostrando o impacto devastador do conflito nas vidas cotidianas, nas relações, na identidade e na luta pela sobrevivência em meio à fome e à violência. Adichie oferece uma perspectiva íntima e humana sobre um período crucial da história africana, abordando temas como o colonialismo, o tribalismo, o amor, a perda e a resiliência do espírito humano.'
WHERE liv_id = 30;