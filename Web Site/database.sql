-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Dim 13 Décembre 2015 à 15:39
-- Version du serveur :  5.5.42
-- Version de PHP :  5.6.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `bookstore`
--

-- --------------------------------------------------------

--
-- Structure de la table `authors`
--

CREATE TABLE `authors` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `biography` text NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `authors`
--

INSERT INTO `authors` (`id`, `firstname`, `lastname`, `biography`, `image`) VALUES
(1, 'Eric', 'Nylund', 'Halo authore', '/img/authors/1/1.jpeg'),
(2, 'William', 'C.Dietz', '', '/img/authors/1/2.jpg'),
(3, 'George', 'Orwell', '', '/img/authors/1/3.jpg'),
(4, 'André', 'Massepain', '', '/img/no_image.jpg'),
(5, 'Bernard', 'Werber', 'Après des études de criminologie, Bernard Werber intègre une école de journalisme à Paris. Il fait d''abord ses preuves dans la presse locale de Cambrai, puis devient un collaborateur régulier du Nouvel Observateur. En 1991, il publie son premier roman, ''Les Fourmis'', et l''ouvrage fait une irruption remarquée sur la scène littéraire. Le roman suivant, ''Le Jour des fourmis'' est traduit en vingt-deux langues. Il obtient le Prix des lectrices de Elle et se retrouve propulsé sur le pupitre des lycéens. Ce succès est en partie dû au fait que Werber a repris un genre ignoré en France mais dans lequel excellent les Anglo-Saxons, celui du roman scientifique, auquel l''auteur ajoute des considérations plus philosophiques portant sur l''organisation de nos sociétés humaines. Werber s''est également fait un nom dans le cinéma, avec la réalisation de ''La Reine de nacre''. En 2006, il sort son premier long métrage, ''Nos amis les Terriens''. Capable de se renouveler sans cesse, il propose aussi pour la rentrée littéraire un nouveau roman très attendu, ''Le Papillon des étoiles'' (3 octobre 2006). Ecrivain talentueux, il a su imposer son style avec audace et détermination', '/img/authors/1/5.jpg'),
(6, 'Robert Louis', 'Stevenson', '', '/img/authors/1/6.jpg'),
(7, 'Robert', 'Kirkman', 'Robert Kirkman est un jeune mais prolifique auteur. Il se fait connaître avec la série Battle Pope qu’il publie lui-même au sein de la structure éditoriale qu’il a créé, Funk-O-Tron. Il est repéré par Image Comics qui publie BRIT et Invincible. Les films de George Romero lui inspirent différents scénarii de comics basés sur des histoires de zombies, dont The Walking Dead. Il puise dans ses souvenirs de jeunesse pour le scénario de sa série Invincible. Les aventures de ces superhéros adolescents sont un immense succès et deviennent l’un des fleurons de l’éditeur Image Comics. \r\n', '/img/authors/1/7.jpg'),
(8, 'Aldous', 'Huxley', 'Aldous Leonard Huxley, né le 26 juillet 1894 à Godalming (Royaume-Uni) et mort le 22 novembre 1963 à Los Angeles (États-Unis), est un écrivain britannique plus particulièrement connu du grand public pour son roman Le Meilleur des mondes.\r\n\r\nConnu comme romancier et essayiste, il a aussi écrit quelques nouvelles, de la poésie, des récits de voyage et des scénarios de film. Dans ses romans et ses essais, Huxley se pose en observateur critique des usages, des normes sociales et des idéaux et se préoccupe des applications du progrès scientifique potentiellement nuisibles à l''humanité. Alors que ses premières œuvres étaient dominées par la défense d''un certain humanisme, il s''intéresse de plus en plus aux questions spirituelles, et particulièrement à la parapsychologie et à la philosophie mystique, un sujet sur lequel il a beaucoup écrit. Dans certains milieux, Huxley était considéré, à la fin de sa vie, comme l''un des phares de la pensée contemporaine. Le courant de pensée dit du « New Age » se réfère fréquemment à ses écrits mystiques et d''étude des hallucinogènes.', '/img/authors/1/8.jpg'),
(9, 'Ray', 'Bradbury', 'Raymond Douglas « Ray » Bradbury, né le 22 août 1920 à Waukegan dans l''Illinois et mort le 5 juin 2012 (à 91 ans) à Los Angeles en Californie, est un écrivain américain, référence du genre de l''anticipation. Il est particulièrement connu pour ses Chroniques martiennes, écrites en 1950, L''Homme illustré, recueil de nouvelles publié en 1951, et surtout Fahrenheit 451, roman dystopique publié en 1953.', '/img/authors/1/9.jpg'),
(10, 'William', 'R. Forstchen', 'William R. Forstchen est professeur d''histoire et membre du corps professoral du Montreat College, à Montreat en Caroline du Nord. Il a obtenu son doctorat à l''université Purdue avec des spécialisations dans l''histoire militaire, la guerre de Sécession et en histoire de la technologie.\r\n\r\nWilliam est l''auteur de plus de quarante livres, comprenant le très récompensé We look like men of War, un roman pour jeunes adultes au sujet d''un régiment afro-américain qui a combattu à la bataille du Cratère, qui est basé sur sa thèse de doctorat, The 28th USCTs: Indiana''s African-Américans go to War, 1863-1865 et la série du Régiment perdu qui a été retenu par Tom Cruise et M. Night Shyamalan.\r\n\r\nCes dernières années, les romans de William Forstchen ont évolué vers la fiction historique et la non-fiction. En 2002, il a commencé la trilogie Gettysburg avec le président de la Chambre Newt Gingrich, la trilogie se compose de Gettysburg, Grant Comes East, et Never call retreat. Plus récemment, ils ont publié deux ouvrages sur les événements menant à Pearl Harbor et immédiatement après que l''attaque, Pearl Harbor, et Days of infamy. Forstchen et Gingrich ont déjà collaboré sur le roman alternatif historique 1945.\r\n\r\nLe dernier ouvrage de Forstchen, One second after, a été publié en mars 2009 et parue en France sous le titre Une seconde après. Sur la base de plusieurs années de recherches intensives et d''entretiens, il examine ce qui pourrait arriver dans une ville américaine « typique » à la suite d''une attaque contre les États-Unis avec des armes à Impulsion électromagnétique (EMP).\r\n\r\nSemblable dans la construction des ouvrages tels que On the beach et de Alas Babylone, Une seconde après est situé dans une petite ville universitaire dans l''ouest de la Caroline du Nord et est un récit édifiant de l''effondrement de l''ordre social à la suite d''une panne électrique. Les droits cinématographiques de l''ouvrage ont été opté par la Warner Bros. et il est actuellement en développement comme un long métrage. Le livre a été présenté au Congrès et après à la Commission des Forces armées de la Chambre par le député Roscoe Bartlett (R-MD), président du comité de la Chambre chargé d''évaluer les armes EMP, comme une réalité des dommages potentiels en cas d''attaque EMP sur le territoire des États-Unis.\r\n\r\nForstchen réside près de Asheville en Caroline du Nord avec sa fille Meghan. Il est passionné d''archéologie, et il a participé à plusieurs expéditions en Mongolie et en Russie. Il a un brevet de pilote d''avion et est copropriétaire de l''avion Aeronca L-3B utilisé pendant la Seconde Guerre mondiale. Il a également écrit le premier livre de la série Magic: The Gathering, Arena.', '/img/authors/1/10.jpg'),
(11, 'Robert', 'A. Heinlein', 'Robert Anson Heinlein, né le 7 juillet 1907 à Butler dans le Missouri (États-Unis) et mort le 8 mai 1988 à Carmel-sur-mer en Californie (États-Unis), est un écrivain américain de science-fiction.\r\n\r\nÉcrivain engagé, son influence sur l''imaginaire nucléaire et spatial américain a marqué l''histoire technique de la seconde moitié du xxe siècle.', '/img/authors/1/11.jpg'),
(12, 'Arthur', 'Conan Doyle', 'Arthur Conan Doyle (né Arthur Ignatius Conan Doyle le 22 mai 1859 à Édimbourg, en Écosse, et mort le 7 juillet 1930 à Crowborough dans le Sussex), est un écrivain et médecin britannique. Il doit sa célébrité à ses romans et nouvelles mettant en scène le détective Sherlock Holmes - considérés comme une innovation majeure du roman policier - et le professeur Challenger. Cet écrivain prolifique a également été l''auteur de livres de science-fiction, de romans historiques, de pièces de théâtre, de poésies et d''œuvres historiques.\r\n\r\nIl a été élevé au rang de Chevalier de l''ordre du Très vénérable ordre de Saint-Jean par le roi Édouard VII le 24 octobre 1902.', '/img/authors/1/12.jpeg'),
(13, 'Wilson', 'Colin', 'Il devient renommé en 1956 avec The Outsider (L''Homme en-dehors) un livre qui popularisa la philosophie existentielle en Grande-Bretagne, dans les divers aspects d''aliénation développés chez Albert Camus, Jean-Paul Sartre, Ernest Hemingway, Hermann Hesse, Fiodor Dostoïevski, T. E. Lawrence, Vaslav Nijinski ou Vincent van Gogh.\r\n\r\nParallèlement, il s''intéresse à ce que les Anglais nomment « True crime », à la vie après la mort, au fantastique (H. P. Lovecraft) et à la psychologie. Son roman Les Vampires de l''espace a été adapté au cinéma par Tobe Hooper (Lifeforce, 1985 avec Mathilda May).\r\n\r\nAuteur de plus de 80 ouvrages, il donnait régulièrement des conférences aux États-Unis.\r\n', '/img/authors/1/13.jpg'),
(14, 'Joseph', 'Staten', 'Joseph Staten, né à San Francisco en Californie, est un écrivain américain. Il travaille depuis 1988 pour le développeur de jeux Bungie Studios, notamment sur la célèbre trilogie Halo. Son premier roman, Halo : Contact Harvest, a atteint la 3e place des best-sellers sur la liste du New York Times dès la première semaine de sa sortie.', '/img/authors/1/14.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author_id` int(11) NOT NULL,
  `description` text NOT NULL,
  `editor` varchar(255) NOT NULL,
  `collection` varchar(255) NOT NULL,
  `pages` int(4) NOT NULL,
  `published` date NOT NULL,
  `genre` varchar(255) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `books`
--

INSERT INTO `books` (`id`, `title`, `author_id`, `description`, `editor`, `collection`, `pages`, `published`, `genre`, `image`) VALUES
(1, 'Halo, Tome 1 : La chute de Reach', 1, 'Alors que la redoutable flotte des Covenants sillonne inexorablement l''espace, dans l''intention d''éradiquer l''humanité, la planète Reach est le dernier bastion humain qui ne soit pas encore tombé. Située aux portes de la Terre, Reach est la seule forteresse militaire à pouvoir espérer repousser l''attaque extraterrestre. Mais les défenseurs de la planète ont une autre priorité : empêcher les Covenants de découvrir la localisation de la Terre. Avec une puissance de feu et des forces inférieures, les soldats humains semblent avoir peu de chances de résister aux Covenants ; Reach abrite cependant un secret très bien gardé. Cette planète est le centre d''entraînement des tout premiers " super-soldats ". Ayant pour nom de code Spartans, ces combattants émérites, dotés d''une technologie avancée, n''ont pas d''égal dans l''univers : ils sont silencieux, professionnels et dangereux. Lorsque commence l''attaque des perfides Covenants, une poignée de Spartans s''apprête à leur livrer une guerre totale. Ils tueront, ou seront anéantis, mais ne se rendront jamais. Et l''un d''entre eux, le Spartan connu sous le nom d''Adjudant, survivra même pour livrer une autre bataille sur un ancien et mystérieux monde artificiel baptisé Halo...', 'Fleuve Noir', 'Plouf', 486, '2004-03-11', 'Science-Fiction', '/img/books/1/1.jpg'),
(2, 'Halo, Tome 2 : Les Floods', 2, 'La guerre entre humains et Covenants, un combat à mort pour la survie de l''humanité, atteint son point culminant sur le monde mystérieux de Halo. Mais la puissante armée extraterrestre n''est pas le seul péril embusqué sur cette planète...Alors que le monde-forteresse de Reach et ses courageux défenseurs disparaissent sous le feu des bombardements ennemis, un unique croiseur échappe au carnage, avec à son bord les derniers survivants humains -le Capitaine Keyes, quelques centaines de marines, et le dernier spécimen de super-soldat SPARTAN, l''Adjudant.Assisté de Cortana, l''intelligence artificielle du vaisseau, l''Adjudant atterrit sur Halo au milieu de troupes massives de Covenants. Curieusement, les soldats semblent chercher quelque chose sur l''anneau artificiel. Il s''avère en effet que Halo, créé de toutes pièces par une race extraterrestre depuis longtemps eteinte, dissimule de nombreux secrets. Mais l''un d''entre eux éclipse de loin tous les autres ...', 'Fleuve Noir', '', 444, '2004-10-04', 'Science-Fiction', '/img/books/1/2.jpg'),
(3, 'Halo, Tome 3 : Opération First Strike', 1, 'La guerre entre humains et Covenants, un combat à mort pour la survie de l''humanité, a atteint son point culminant sur le monde mystérieux de Halo. Mais la puissante armée extraterrestre ne compte pas stopper là sa quête destructrice... Halo a été détruit, et la menace que l''anneau artificiel faisait peser sur\r\ntoute forme de vie, neutralisée. Mais la victoire a coûté terriblement cher au CSNU. Des milliers de courageux soldats sont tombés sur le champ de\r\nbataille pour éviter que l''invention extraterrestre ne tombe entre les mains de l''ennemi. Maintenant, le sort de l''humanité repose tout entier sur l''un des seuls Spartans ayant échappé au carnage : l''Adjudant. Avec l''aide de Cortana, l''intelligence artificielle du vaisseau, il doit s''efforcer de rassembler les survivants, malgré la présence de nombreuses patrouilles de Covenants gravitant autour des débris de Halo...', 'Fleuve Noir', '', 504, '2005-02-01', 'Science-Fiction', '/img/books/1/3.jpg'),
(4, '1984', 3, '«De tous les carrefours importants, le visage à la moustache noire vous fixait du regard. BIG BROTHER VOUS REGARDE, répétait la légende, tandis que le regard des yeux noirs pénétrait les yeux de Winston... Au loin, un hélicoptère glissa entre les toits, plana un moment, telle une mouche bleue, puis repartit comme une flèche, dans un vol courbe. C''était une patrouille qui venait mettre le nez aux fenêtres des gens. Mais les patrouilles n''avaient pas d''importance. Seule comptait la Police de la Pensée.»', 'Gallimard', 'Folio', 438, '1949-06-08', 'Science-Fiction', '/img/books/1/4.jpg'),
(5, 'L''île aux fossiles vivants', 4, 'En voulant rejoindre leur père, ingénieur à la base atomique française de Mururoa, Gilles et Jérôme ont un accident d''avion en plein Pacifique. Seuls rescapés ils abordent à la nage une petite île de l''archipel Salomon.Une île extraordinaire, car habitée par les fossiles vivant qui ont survécu, les uns à la préhistoire, les autres à la première guerre mondiale.\r\nEn quelques instants, Gilles et Jérôme sont transportés tout à la fois dans une actualité brûlante, et des millions d’années en arrière.', 'Gallimard', '', 246, '1967-01-01', 'Fantastique', '/img/books/1/5.jpg'),
(6, 'Les fourmis', 5, 'Le temps que vous lisiez ces lignes, sept cents millions de fourmis seront nées sur la planète. Sept cents millions d''individus dans une communauté estimée à un milliard de milliards, et qui a ses villes, sa hiérarchie, ses colonies, son langage, sa production industrielle, ses esclaves, ses mercenaires... Ses armes aussi. Terriblement destructrices.\r\nLorsqu''il entre dans la cave de la maison léguée par un vieil oncle entomologiste, Jonathan Wells est loin de se douter qu''il va à leur rencontre.\r\nA sa suite, nous allons découvrir le monde fabuleusement riche, monstrueux et fascinant de ces «infraterrestres», au fil d''un thriller unique en son genre, où le suspense et l''horreur reposent à chaque page sur les données scientifiques les plus rigoureuses.\r\nVoici pour la première fois un roman dont les héros sont des... fourmis !', 'Albin Michel', '', 320, '1991-01-01', 'Roman animalier', '/img/books/1/6.jpg'),
(7, 'Le jour des fourmis', 5, 'Sus aux Doigts ! Exterminez-les tous ! C''est à ce mot d''ordre donné par la nouvelle reine des fourmis que s''ébranle la croisade purificatrice du monde afin d''exterminer tous les hommes. Parallèlement, le commissaire Méliès est amené à enquêter sur les meurtres horribles et mystérieux de plusieurs grands scientifiques.\r\nVoici comment, dans ce passionnant roman, deux mondes, celui des hommes et celui des fourmis, vont au travers de ces deux histoires, après moult rebondissements, converger et se confondre. Ce thriller implacable, au suspens haletant, où se mêlent l''aventure, le fantastique et la réflexion nous apporte un grand nombre d''informations sur le monde, à la fois si proche et si lointain, des insectes.', 'Albin Michel', '', 496, '1992-01-01', 'Roman animalier', '/img/books/1/7.jpg'),
(8, 'La révolution des fourmis', 5, 'D''un côté, les fourmis. Elles se demandent si nous sommes des monstres géants ou des dieux infinis. De l''autre, nous, les hommes. Au mieux, nous sommes indifférents à ces êtres minuscules. Au pire, nous nous acharnons à les écraser. Pourtant, après des millénaires d''incompréhension, les deux civilisations les plus évoluées de la planète vont peut-être se rencontrer, se comprendre, se connaître enfin.', 'Albin Michel', '', 672, '1998-01-01', 'Roman animalier', '/img/books/1/8.jpg'),
(9, 'L''étrange cas du Dr Jekyll et de Mr Hyde', 6, 'Quand la nuit tombe, le terrifiant Mr Hyde se faufile dans les ruelles désertes et martyrise fillettes et vieillards avec un sang-froid démoniaque. Chacune de ses apparitions inspire le frisson. Pourquoi cet être abject est-il protégé par le respectable Dr Jekyll, gentleman et philanthrope reconnu à Londres ? Pour Mr Utterson, notaire de son état, il ne peut s''agir que de quelque manipulation diabolique. Chef-d''oeuvre du récit d''épouvante, inspiré d''un cauchemar de l''auteur, L''Etrange Cas du Dr Jekyll et de Mr Hyde fascine aussi par son réalisme psychologique.', 'Longmans, Green & co', '', 114, '1886-01-05', 'Nouvelle', '/img/books/1/9.jpg'),
(10, 'L''Ascension du Gouverneur', 7, 'Dans le monde de The Walking Dead, envahi par les morts-vivants où quelques-uns tentent de survivre, il n y a pas plus redoutable que le Gouverneur. Ce tyran sanguinaire qui dirige la ville retranchée de Woodbury a son propre sens de la justice, qu''il organise des combats de prisonniers contre des zombies dans une arène pour divertir les habitants, ou qu''il tronçonne les extrémités de ceux qui le contrarient. Mais pourquoi est-il si méchant ? Dans L Ascension du Gouverneur, le lecteur découvre pour la première fois comment et pourquoi Philip Blake est ce qu''il est, ce qui l a conduit à devenir... le Gouverneur.\r\n', 'Le Livre de Poche', 'Littérature & Documents', 352, '2012-03-07', 'Science-Fiction', '/img/books/1/10.jpg'),
(11, 'La Route de Woodbury', 7, 'Dans L Ascension du Gouverneur, le premier roman de la série Walking Dead, le lecteur a découvert comment Philip Blake a vécu l invasion zombie et comment il est arrivé dans la ville retranchée de Woodbury. Le deuxième roman, La Route de Woodbury, raconte comment il en devient le leader incontesté. Ce ne sera pas simple. Certains qui sont là depuis longtemps se méfient de Philippe. Ils n aiment pas trop non plus les bruits étranges qui proviennent de son appartement. Mais Philip Blake est déterminé à faire de la ville un havre de paix à l abri du cauchemar post-apocalyptique qui l entoure. Il est prêt à tout pour y parvenir. Y compris renverser et tuer ceux qui dirigent aujourd''hui Woodbury.\r\n', 'Le Livre de Poche', 'Littérature & Documents', 320, '2012-10-17', 'Science-Fiction', '/img/books/1/11.jpg'),
(12, 'Le meilleur des mondes', 8, 'Bienvenue au Centre d''Incubation et de Conditionnement de Londres-Central. À gauche, les couveuses où l''homme moderne, artificiellement fécondé, attend de rejoindre une société parfaite. À droite : la salle de conditionnement où chaque enfant subit les stimuli qui plus tard feront son bonheur. Tel fœtus sera Alpha – l''élite – tel autre Epsilon – caste inférieure. Miracle technologique : ici commence un monde parfait, biologiquement programmé pour la stabilité éternelle... La visite est à peine terminée que déjà certains ricanent. Se pourrait-il qu''avant l''avènement de l''État Mondial, l''être humain ait été issu d''un père et d''une mère ? Incroyable, dégoûtant... mais vrai. Dans une réserve du Nouveau Mexique, un homme Sauvage a échappé au programme. Bientôt, il devra choisir : intégrer cette nouvelle condition humaine ou persister dans sa démence...', 'Pocket', '', 284, '1932-01-01', 'Science-Fiction', '/img/books/1/12.jpg'),
(13, 'La ferme des animaux', 3, '«Un certain 21 juin eut lieu en Angleterre la révolte des animaux. Les cochons dirigent le nouveau régime. Snowball et Napoléon, cochons en chef, affichent un règlement : "Tout ce qui est sur deux jambes est un ennemi. Tout ce qui est sur quatre jambes ou possède des ailes est un ami. Aucun animal ne portera de vêtements. Aucun animal ne dormira dans un lit. Aucun animal ne boira d''alcool. Aucun animal ne tuera un autre animal. Tous les animaux sont égaux."Le temps passe. La pluie efface les commandements. L''âne, un cynique, arrive encore à déchiffrer : "Tous les animaux sont égaux, mais (il semble que cela ait été rajouté) il y en a qui le sont plus que d''autres."»', 'Gallimard', '', 150, '1954-12-29', 'Science-Fiction', '/img/books/1/13.jpg'),
(14, 'La Chute du Gouverneur, tome 1', 7, 'Woodbury, petite ville fortifiée qui résiste à l’invasion zombie… Le Gouverneur, son chef autoproclamé, commence à montrer des signes de pure démence, et ses actions plongent les habitants dans les ténèbres et la terreur. Woodbury a succombé à l’enfer. Au milieu de ce cauchemar post-apocalyptique, Rick, Michonne et Glenn, personnages phares de la bande dessinée éponyme, font enfin leur entrée. Les fans de la série The Walking Dead auront la surprise de découvrir ces trois héros sous un jour nouveau.', 'Le Livre de Poche', 'Littérature & Documents', 288, '2014-06-11', 'Science-Fiction', '/img/books/1/14.jpg'),
(15, 'La Chute du Gouverneur, tome 2', 7, 'Rick, Michonne et Glenn ont infligé une cuisante défaite au Gouverneur despotique qui dirige Woodbury.\r\n\r\nCe quatrième tome de la série nous plonge dans les errances de Philip Blake, tandis qu’il tente de revenir au pouvoir. Mais sa soif inextinguible de domination ne fera que précipiter sa perte.\r\n\r\nDans un formidable twist final, beaucoup des destins déroulés tout au long des précédents tomes vont être scellés. Une nouvelle ère commence pour les survivants de la communauté de Woodbury.\r\n', 'Le Livre de Poche', 'Fantastique', 352, '2014-10-15', 'Science-Fiction', '/img/books/1/15.jpg'),
(16, 'L''Ere du Prédicateur', 7, 'Woodbury renaît peu à peu après la chute du Gouverneur, le tyrannique Philip Blake, et Lilly Caul est devenue, un peu malgré elle, la chef de file des survivants. La ville tente de se reconstruire, mais une horde de zombies approche. Ils sont des centaines, des milliers peut-être. Lilly et les habitants assiégés unissent leurs forces à une mystérieuse secte religieuse menée par un énigmatique prédicateur, Jeremiah. Parviendront-ils à se défendre ?\r\n', 'Le Livre de Poche', 'LDP LITT. IMAGI', 352, '2015-09-16', 'Science-Fiction', '/img/books/1/16.jpg'),
(17, 'Fahrenheit 451', 9, '451 degrés Fahrenheit représentent la température à laquelle un livre s''enflamme et se consume.', 'Gallimard', 'Folio SF', 224, '1953-01-01', 'Science-Fiction', '/img/books/1/17.jpg'),
(18, 'Le Régiment perdu, tome 1 : Ralliement', 10, '1865, City Point, Virginie. Le colonel nordiste Andrew Keane conduit ses soldats à bord d''un navire de transport, ignorant que leur prochain port d''attache n''est ni au Nord ni au Sud, mais... sur un autre monde ! Une tempête les balaie dans une faille surnaturelle et les expédie sur une terre étrangère, où quelques fusils sont tout ce qui sépare le régiment perdu de l''extermination... face à des épées, des lances et des arcs. Dans ce monde féodal, Keane et ses hommes introduisent les idées de liberté, d''égalité et de démocratie. Mais cela suffira-t-il à les sauver de ceux qui détiennent le vrai pouvoir ? De terrifiantes créatures qu''on n''évoque qu''à voix basse et qui élèvent les humains comme du bétail... pour les dévorer !', 'Milady', 'Fantasy', 544, '1990-01-01', 'Fantasy', '/img/books/1/18.jpg'),
(19, 'Le Régiment perdu, tome 2 : Rassemblement', 10, 'Le colonel Keane et ses " tuniques bleues " ont été projetés dans un autre monde dominé par des hordes de créatures guerrières qui traitent les humains comme du bétail. Les fusils et les canons de la guerre de Sécession ont vaincu les épées et les flèches de leurs ennemis monstrueux, les Tugars, et une partie de la population a finalement été libérée. Mais les autres sont devenus le jouet de ces créatures dans le cadre d''une vaste contre-attaque. Désormais, les humains affrontent leurs propres frères, tandis que deux empires se dressent l''un contre l''autre afin de décider de l''avenir d''un monde au-delà du temps...', 'Milady', 'Fantasy', 480, '1991-01-01', 'Fantasy', '/img/books/1/19.jpg'),
(20, 'Etoiles, garde à vous !', 11, 'Après la grande guerre atomique de la fin du XXe siècle, le monde ne fut plus que chaos et désordre. Pour éliminer les hordes barbares qui s''étaient formées, les survivants durent remettre leur sort entre les mains de l''armée. Un siècle plus tard la civilisation, arrivée à l''âge des étoiles, reste dirigée par les militaires. Dans cet univers, Juan Rico s''engage le jour de ses dix-huit ans dans l''infanterie spatiale. Il ne sait pas quel sort terrible attend les fantassins qui, sur les mondes lointains, vont devoir affronter les armées arachnides..', 'J''ai lu ', 'J''ai lu Science-fiction', 314, '1959-12-01', 'Science-Fiction', '/img/books/1/20.jpg'),
(21, 'Le monde perdu', 12, 'Prêt à tout pour conquérir Gladys - qui ne veut épouser qu''un homme célèbre -, Edward Malone, jeune journaliste en début de carrière, s''engage à suivre le terrible professeur Challenger en Amérique du Sud, pour rapporter des preuves de ce qu''il affirme envers et contre tous : les animaux de la préhistoire existent encore de nos jours !', 'Livre de Poche Jeunesse', 'Livre de Poche Jeunesse', 384, '1912-01-01', 'Fantastique', '/img/books/1/21.jpg'),
(22, 'Les Vampires de l''Espace', 13, 'Retour de mission, le vaisseau du commandant Carlsen rencontre un immense astronef, masse sombre et immobile dans l''infini de l''espace. Une épave vide sans doute...  \r\nPas exactement : les hommes de Carlsen y découvrent une trentaine de créatures d''apparence humaine, en animation suspendue. Trois d''entre elles un homme et deux femmes - seront ramenées sur Terre, mais Carlsen est loin de se douter des conséquences atroces de ce "transfert". Dès. leur réveil, les mystérieux passagers de l''astronef révèlent leur nature : ce sont des vampires, affamés d''énergie vitale, et pour leurs victimes c''est la mort immédiate.  \r\nLa destruction des "monstres" est aussitôt décrétée mais l''une des femmes s''échappe. D''autant plus dangereuse qu''elle est extraordinairement belle. \r\nL''espèce humaine est en péril...', 'J''ai lu ', 'J''ai lu Science-fiction', 288, '1976-01-01', 'Science-Fiction', '/img/books/1/22.jpg'),
(23, 'Halo, Tome 4 : Les fantômes d''Onyx', 1, 'Le programme Spartan-II a été dévoilé. Les histoires de super-soldats repoussant des milliers d''attaques Covenant sont entrées dans la légende. Mais combien resta-t-il de Spartans ? Pendant que Master Chief défend une Terre assiégée et que des myriades de factions Covenant poursuivent leurs croisades pour éradiquer l''humanité, la "Section Trois", une cellule ultrasecrète de l''espionnage des forces navales, élabore un plan afin de donner un peu de répit à l''armée. Pour cela, elle aura besoin de centaines de soldats... et d''un Spartan supplémentaire. Pratiquement déserte, la planète Onyx est l''endroit idéal pour un tel plan. Mais quand Master Chief détruit Halo, quelque chose s''éveille dans les profondeurs d''Onyx. Une ancienne technologie Forerunner ressuscite et la Navy se lance dans une course contre les Covenants pour la récupérer et changer ainsi le cours de la guerre. Mais une fois revenue à la vie, cette force aura peut-être ses propres plans...', 'Milady', 'Gaming', 450, '2006-10-31', 'Science-Fiction', '/img/books/1/23.jpg'),
(24, 'Halo, Tome 5 : Contact Harvest', 14, 'En 2524, l''humanité a colonisé une grande partie de l''espace. Située à la frontière des zones contrôlées, Harvest est une colonie agricole pacifique... jusqu''à ce qu''elle devienne la proie d''une menace inconnue, représentée par le Covenant, une faction extraterrestre redoutable. Face à elle, quelques militaires menés par le jeune sergent Avery Johnson doivent réussir l''impossible : sauver une planète entière d''un ennemi tentaculaire, et au-delà, préserver l''humanité d''un conflit interstellaire...', 'Milady', 'Gaming', 480, '2007-10-30', 'Science-Fiction', '/img/books/1/24.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `rating` int(1) NOT NULL,
  `created` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `book_id`, `content`, `rating`, `created`) VALUES
(1, 1, 9, 'Une oeuvre remarquable.', 3, '2014-04-09 19:24:24'),
(2, 1, 9, 'AprÃ¨s avoir vu la sÃ©rie Jekyll interprÃ©tÃ© par le talentueux James Nesbit, je voulais connaÃ®tre l''histoire de ce docteur et je ne suis pas dÃ©Ã§u par le voyage.', 4, '2014-04-09 20:00:35'),
(3, 1, 4, 'Ce livre est devenu ma bible, il nous montre que George Orwell a anticipÃ© l''avenir avec son Big Brother. \r\nUne rÃ©fÃ©rence que tout amateur de science-fiction doit lire.', 5, '2014-05-20 11:54:58'),
(4, 1, 8, 'Un livre qui conclut la trilogie avec un peu de mal. J''ai personnellement eu l''impression que Werber Ã©crivait juste pour remplir le roman et c''Ã©tait parfois lassant.\r\n\r\nAh oui, j''ai bien rigolÃ© pour le coup du jeu et du parc informatique dÃ©veloppÃ© en une nuit par un jeune adolescent, chose biensÃ»r impossible.', 3, '2014-05-20 11:57:36');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `token` text NOT NULL,
  `email` varchar(255) NOT NULL,
  `sexe` char(1) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  `admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `token`, `email`, `sexe`, `active`, `admin`) VALUES
(1, 'demo', 'a69681bcf334ae130217fea4505fd3c994f5683f', '', 'demo@demo.com', 'M', 1, 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `authors`
--
ALTER TABLE `authors`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `authors`
--
ALTER TABLE `authors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT pour la table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;