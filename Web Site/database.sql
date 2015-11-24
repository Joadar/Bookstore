-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:8889
-- Généré le :  Mar 24 Novembre 2015 à 22:29
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
  `biography` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `authors`
--

INSERT INTO `authors` (`id`, `firstname`, `lastname`, `biography`) VALUES
(1, 'Eric', 'Nylud', 'Halo authore'),
(2, 'William', 'C.Dietz', ''),
(3, 'George', 'Orwell', ''),
(4, 'AndrÃ©', 'Massepain', ''),
(5, 'Bernard', 'Werber', 'AprÃ¨s des Ã©tudes de droit et de criminologie Ã  Toulouse, Bernard Werber entre Ã  l''Ã‰cole supÃ©rieure de journalisme de Paris. Il fait ses premiÃ¨res armes dans un journal de Cambrai aux rubriques "chiens Ã©crasÃ©s", mÃ©tÃ©o, mariages et cÃ©rÃ©monies en tout genre, avant de gagner le prix de la fondation News du meilleur jeune reporter qui lui permet de financer son premier vrai grand reportage. Sujet : les redoutables fourmis magnans de CÃ´te-d''Ivoire. A son retour, il devient pigiste (L''Ã‰vÃ©nement, Le Point, VSD...), puis journaliste scientifique au Nouvel Observateur oÃ¹ il reste 7 ans.\r\nSon enquÃªte sur les magnans va lui inspirer son premier roman, Les Fourmis, qui connaÃ®t dÃ¨s sa sortie en 1991, un succÃ¨s immÃ©diat, en France et dans le monde, notamment en CorÃ©e et en Russie. SuccÃ¨s qui ira croissant au fur et Ã  mesure de la parution de ses livres (prÃ¨s d''une vingtaine : romans, nouvelles, piÃ¨ce de thÃ©Ã¢tre...).\r\nLes livres de Bernard Werber sont traduits dans une trentaine de langues.'),
(6, 'Robert Louis', 'Stevenson', ''),
(7, 'Robert', 'Kirkman', 'Robert Kirkman est un jeune mais prolifique auteur. Il se fait connaÃ®tre avec la sÃ©rie Battle Pope quâ€™il publie lui-mÃªme au sein de la structure Ã©ditoriale quâ€™il a crÃ©Ã©, Funk-O-Tron. Il est repÃ©rÃ© par Image Comics qui publie BRIT et Invincible.\r\nLes films de George Romero lui inspirent diffÃ©rents scÃ©narii de comics basÃ©s sur des histoires de zombies, dont The Walking Dead. Il puise dans ses souvenirs de jeunesse pour le scÃ©nario de sa sÃ©rie Invincible. Les aventures de ces superhÃ©ros adolescents sont un immense succÃ¨s et deviennent lâ€™un des fleurons de lâ€™Ã©diteur Image Comics.'),
(8, 'Aldous', 'Huxley', 'Aldous Leonard Huxley est un Ã©crivain britannique, nÃ© le 26 juillet 1894 Ã  Godalming (Royaume-Uni) et mort le 22 novembre 1963 Ã  Los Angeles (Ã‰tats-Unis), plus particuliÃ¨rement connu du grand public pour son roman Le Meilleur des mondes. Connu comme romancier et essayiste, il a aussi Ã©crit quelques nouvelles, de la poÃ©sie, des rÃ©cits de voyage et des scÃ©narios de film. Dans ses romans et ses essais, Huxley se pose en observateur critique des usages, des normes sociales et des idÃ©aux et se prÃ©occupe des applications potentiellement nuisibles Ã  l''humanitÃ© du progrÃ¨s scientifique. Alors que ses premiÃ¨res Å“uvres Ã©taient dominÃ©es par la dÃ©fense d''un certain humanisme, il s''intÃ©resse de plus en plus aux questions spirituelles, et particuliÃ¨rement Ã  la parapsychologie et Ã  la philosophie mystique, un sujet sur lequel il a beaucoup Ã©crit. Dans certains milieux, Huxley Ã©tait considÃ©rÃ© Ã  la fin de sa vie comme l''un des phares de la pensÃ©e contemporaine. Le courant de pensÃ©e dit du " New Age " se rÃ©fÃ¨re frÃ©quemment Ã  ses Ã©crits mystiques et d''Ã©tude des hallucinogÃ¨nes.');

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
  `language` varchar(255) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `books`
--

INSERT INTO `books` (`id`, `title`, `author_id`, `description`, `editor`, `collection`, `pages`, `published`, `genre`, `language`, `image`) VALUES
(1, 'Halo, Tome 1 : La chute de Reach', 1, 'Alors que la redoutable flotte des Covenants sillonne inexorablement l&#39;espace, dans l&#39;intention d&#39;&#233;radiquer l&#39;humanit&#233;, la plan&#232;te Reach est le dernier bastion humain qui ne soit pas encore tomb&#233;. Situ&#233;e aux portes de la Terre, Reach est la seule forteresse militaire &#224; pouvoir esp&#233;rer repousser l&#39;attaque extraterrestre. Mais les d&#233;fenseurs de la plan&#232;te ont une autre priorit&#233; : emp&#234;cher les Covenants de d&#233;couvrir la localisation de la Terre. Avec une puissance de feu et des forces inf&#233;rieures, les soldats humains semblent avoir peu de chances de r&#233;sister aux Covenants ; Reach abrite cependant un secret tr&#232;s bien gard&#233;. Cette plan&#232;te est le centre d&#39;entra&#238;nement des tout premiers &quot; super-soldats &quot;. Ayant pour nom de code Spartans, ces combattants &#233;m&#233;rites, dot&#233;s d&#39;une technologie avanc&#233;e, n&#39;ont pas d&#39;&#233;gal dans l&#39;univers : ils sont silencieux, professionnels et dangereux. Lorsque commence l&#39;attaque des perfides Covenants, une poign&#233;e de Spartans s&#39;appr&#234;te &#224; leur livrer une guerre totale. Ils tueront, ou seront an&#233;antis, mais ne se rendront jamais. Et l&#39;un d&#39;entre eux, le Spartan connu sous le nom d&#39;Adjudant, survivra m&#234;me pour livrer une autre bataille sur un ancien et myst&#233;rieux monde artificiel baptis&#233; Halo...', 'Fleuve Noir', 'Plouf', 486, '2004-03-11', 'Science-Fiction', 'FranÃ§ais', '/img/books/1/1.jpg'),
(2, 'Halo, Tome 2 : Les Floods', 2, 'La guerre entre humains et Covenants, un combat Ã  mort pour la survie de l''humanitÃ©, atteint son point culminant sur le monde mystÃ©rieux de Halo. Mais la puissante armÃ©e extraterrestre n''est pas le seul pÃ©ril embusquÃ© sur cette planÃ¨te... Alors que le monde-forteresse de Reach et ses courageux dÃ©fenseurs disparaissent sous le feu des bombardements ennemis, un unique croiseur Ã©chappe au carnage, avec Ã  son bord les derniers survivants humains - le Capitaine Keyes, quelques centaines de marines, et le dernier spÃ©cimen de super-soldat SPARTAN, l''Adjudant. AssistÃ© de Cortana, l''intelligence artificielle du vaisseau, l''Adjudant atterrit sur Halo au milieu de troupes massives de Covenants. Curieusement, les soldats semblent chercher quelque chose sur l''anneau artificiel. Il s''avÃ¨re en effet que Halo, crÃ©Ã© de toutes piÃ¨ces par une race extraterrestre depuis longtemps Ã©teinte, dissimule de nombreux secrets. Mais l''un d''entre eux Ã©clipse de loin tous les autres...', 'Fleuve Noir', '', 444, '2004-10-04', 'Science-Fiction', 'FranÃ§ais', '/img/books/1/2.jpg'),
(3, 'Halo, Tome 3 : OpÃ©ration First Strike', 1, 'La guerre entre humains et Covenants, un combat Ã  mort pour la survie de l''humanitÃ©, a atteint son point culminant sur le monde mystÃ©rieux de Halo. Mais la puissante armÃ©e extraterrestre ne compte pas stopper lÃ  sa quÃªte destructrice... Halo a Ã©tÃ© dÃ©truit, et la menace que l''anneau artificiel faisait peser sur\r\ntoute forme de vie, neutralisÃ©e. Mais la victoire a coÃ»tÃ© terriblement cher au CSNU. Des milliers de courageux soldats sont tombÃ©s sur le champ de\r\nbataille pour Ã©viter que l''invention extraterrestre ne tombe entre les mains de l''ennemi. Maintenant, le sort de l''humanitÃ© repose tout entier sur l''un des seuls Spartans ayant Ã©chappÃ© au carnage : l''Adjudant. Avec l''aide de Cortana, l''intelligence artificielle du vaisseau, il doit s''efforcer de rassembler les survivants, malgrÃ© la prÃ©sence de nombreuses patrouilles de Covenants gravitant autour des dÃ©bris de Halo...', 'Fleuve Noir', '', 504, '2005-02-01', 'Science-Fiction', 'FranÃ§ais', '/img/books/1/3.jpg'),
(4, '1984', 3, 'Â«De tous les carrefours importants, le visage Ã  la moustache noire vous fixait du regard. BIG BROTHER VOUS REGARDE, rÃ©pÃ©tait la lÃ©gende, tandis que le regard des yeux noirs pÃ©nÃ©trait les yeux de Winston... Au loin, un hÃ©licoptÃ¨re glissa entre les toits, plana un moment, telle une mouche bleue, puis repartit comme une flÃ¨che, dans un vol courbe. C''Ã©tait une patrouille qui venait mettre le nez aux fenÃªtres des gens. Mais les patrouilles n''avaient pas d''importance. Seule comptait la Police de la PensÃ©e.Â»', 'Gallimard', 'Folio', 438, '1949-06-08', 'Science-Fiction', 'FranÃ§ais', '/img/books/1/4.jpg'),
(5, 'L''Ã®le aux fossiles vivants', 4, ' En voulant rejoindre leur pÃ¨re, ingÃ©nieur Ã  la base atomique franÃ§aise de Mururoa, Gilles et JÃ©rÃ´me ont un accident d''avion en plein Pacifique. Seuls rescapÃ©s, ils abordent Ã  la nage une petite Ã®le de l''archipel Salomon.\r\nUne Ã®le extraordinaire, car habitÃ©e par les fossiles vivants qui ont survÃ©cu, les uns Ã  la prÃ©histoire, les autres Ã  la derniÃ¨re guerre mondiale.\r\nEn quelques instants, Gilles et JÃ©rÃ´me sont transportÃ©s tout Ã  la fois dans une actualitÃ© brÃ»lante, et des millions d''annÃ©es en arriÃ¨re.', 'Gallimard', '', 246, '1967-01-01', 'Fantastique', 'FranÃ§ais', '/img/books/1/5.jpg'),
(6, 'Les fourmis', 5, 'Pendant les quelques secondes nÃ©cessaires pour lire cette seule phrase vont naÃ®tre sur terre quarante humains mais surtout sept cents millions de fourmis. Depuis plus de cent millions d''annÃ©es avant nous, elles sont lÃ , rÃ©parties en lÃ©gions, en citÃ©s, en empires sur toute la surface du globe. Iles ont crÃ©Ã© une civilisation parallÃ¨le, bÃ¢ti de vÃ©ritables royaumes, inventÃ© les armes les plus sophistiquÃ©es, conÃ§u tout un art de la guerre et de la citÃ© que nous sommes loin d''Ã©galer, maÃ®trisÃ© une technologie stupÃ©fiante. Elles ont leur propre Attila, Christophe Colomb, Jules CÃ©sar, Machiavel ou LÃ©onard de Vinci. Le jour des fourmis approche. Le roman pas comme les autres nous dit pourquoi et nous plonge de maniÃ¨re saisissante dans un univers de crimes, de monstruositÃ©s, de guerres tel que nous n''en avons jamais connu. Au-delÃ  de toute imagination. Il nous fait entrer dans le monde des infraÂ¬terrestres. Attention oÃ¹ vous mettrez les pieds. AprÃ¨s avoir lu ce roman fascinant, vous risquez de ne plus regarder la rÃ©alitÃ© de la mÃªme maniÃ¨re.', 'Albin Michel', '', 320, '1991-01-01', 'Roman animalier', 'FranÃ§ais', '/img/books/1/6.jpg'),
(7, 'Le jour des fourmis', 5, 'Elles sont un milliard de milliards. Nous les remarquons Ã  peine, elles nous guettent pourtant depuis longtemps. Pour certaines, nous sommes des Dieux. Pour les autres, des Ãªtres malfaisants. Avec une intelligence et une organisation prodigieuses qui n''ont rien Ã  envier aux armÃ©es les plus redoutables, elles se prÃ©parent Ã  une lutte sans merci. Qui seront les vrais maÃ®tres de la terre ? De la rÃ©ponse Ã  cette question leur survie dÃ©pend... La nÃ´tre aussi. LE JOUR DES FOURMIS est-il vraiment arrivÃ© ?', 'Albin Michel', '', 496, '1992-01-01', 'Roman animalier', 'FranÃ§ais', '/img/books/1/7.jpg'),
(8, 'La rÃ©volution des fourmis', 5, 'D''un cÃ´tÃ©, les fourmis. Elles se demandent si nous sommes des monstres gÃ©ants ou des dieux infinis. De l''autre, nous, les hommes. Au mieux, nous sommes indiffÃ©rents Ã  ces Ãªtres minuscules. Au pire, nous nous acharnons Ã  les Ã©craser. Pourtant, aprÃ¨s des millÃ©naires d''incomprÃ©hension, les deux civilisations les plus Ã©voluÃ©es de la planÃ¨te vont peut-Ãªtre se rencontrer, se comprendre, se connaÃ®tre enfin.', 'Albin Michel', '', 672, '1998-01-01', 'Roman animalier', 'FranÃ§ais', '/img/books/1/8.jpg'),
(9, 'L''Ã©trange cas du Dr Jekyll et de Mr Hyde', 6, 'Â«Ã‡a n''a peut-Ãªtre l''air de rien Ã  entendre, mais Ã  voir c''Ã©tait effroyable. Cet individu n''avait presque rien d''un humain. On eÃ»t dit plutÃ´t une espÃ¨ce de monstre aveugle sorti de l''enfer...Â» ', 'Longmans, Green & co', '', 114, '1886-01-05', 'Nouvelle', 'Anglais', '/img/books/1/9.jpg'),
(10, 'L''Ascension du Gouverneur', 7, 'Dans le monde de The Walking Dead, envahi par les morts-vivants oÃ¹ quelques-uns tentent de survivre, il n y a pas plus redoutable que le Gouverneur. Ce tyran sanguinaire qui dirige la ville retranchÃ©e de Woodbury a son propre sens de la justice, qu il organise des combats de prisonniers contre des zombies dans une arÃ¨ne pour divertir les habitants, ou qu il tronÃ§onne les extrÃ©mitÃ©s de ceux qui le contrarient. Mais pourquoi est-il si mÃ©chant ? Dans L Ascension du Gouverneur, le lecteur dÃ©couvre pour la premiÃ¨re fois comment et pourquoi Philip Blake est ce qu il est, ce qui l a conduit Ã  devenir... le Gouverneur.\r\n\r\nSuivie par des millions de lecteurs et spectateurs, The Walking Dead est une sÃ©rie culte.', 'Le Livre de Poche', 'LittÃ©rature & Documents', 352, '2012-03-07', 'Science-Fiction', '', '/img/books/1/10.jpg'),
(11, 'La Route de Woodbury', 7, 'Dans L''Ascension du Gouverneur, le premier roman de la sÃ©rie Walking Dead, le lecteur a dÃ©couvert comment Philip Blake a vÃ©cu l invasion zombie et comment il est arrivÃ© dans la ville retranchÃ©e de Woodbury. Le deuxiÃ¨me roman, La Route de Woodbury, raconte comment il en devient le leader incontestÃ©. Ce ne sera pas simple. Certains qui sont lÃ  depuis longtemps se mÃ©fient de Philippe. Ils n aiment pas trop non plus les bruits Ã©tranges qui proviennent de son appartement. Mais Philip Blake est dÃ©terminÃ© Ã  faire de la ville un havre de paix Ã  l abri du cauchemar post-apocalyptique qui l entoure. Il est prÃªt Ã  tout pour y parvenir. Y compris renverser et tuer ceux qui dirigent aujourd hui Woodbury.', 'Le Livre de Poche', 'LittÃ©rature & Documents', 320, '2012-10-17', 'Science-Fiction', '', '/img/books/1/11.jpg'),
(12, 'Le meilleur des mondes', 8, 'Bienvenue au Centre d''Incubation et de Conditionnement de Londres-Central. Ã€ gauche, les couveuses oÃ¹ l''homme moderne, artificiellement fÃ©condÃ©, attend de rejoindre une sociÃ©tÃ© parfaite. Ã€ droite : la salle de conditionnement oÃ¹ chaque enfant subit les stimuli qui plus tard feront son bonheur. Tel fÅ“tus sera Alpha â€“ l''Ã©lite â€“ tel autre Epsilon â€“ caste infÃ©rieure. Miracle technologique : ici commence un monde parfait, biologiquement programmÃ© pour la stabilitÃ© Ã©ternelle... La visite est Ã  peine terminÃ©e que dÃ©jÃ  certains ricanent. Se pourrait-il qu''avant l''avÃ¨nement de l''Ã‰tat Mondial, l''Ãªtre humain ait Ã©tÃ© issu d''un pÃ¨re et d''une mÃ¨re ? Incroyable, dÃ©goÃ»tant... mais vrai. Dans une rÃ©serve du Nouveau Mexique, un homme Sauvage a Ã©chappÃ© au programme. BientÃ´t, il devra choisir : intÃ©grer cette nouvelle condition humaine ou persister dans sa dÃ©mence...', 'Pocket', '', 284, '1932-01-01', 'Science-Fiction', '', '/img/books/1/12.jpg'),
(13, 'La ferme des animaux', 3, 'Un certain 21 juin eut lieu en Angleterre la rÃ©volte des animaux. Les cochons dirigent le nouveau rÃ©gime. Snowball et NapolÃ©on, cochons en chef, affichent un rÃ¨glement : " Tout ce qui est sur deux jambes est un ennemi. Tout ce qui est sur quatre jambes ou possÃ¨de des ailes est un ami. Aucun animal ne portera de vÃªtements. Aucun animal ne dormira dans un lit. Aucun animal ne boira d''alcool. Aucun animal ne tuera un autre animal. Tous les animaux sont Ã©gaux. " Le temps passe. La pluie efface les commandements. L''Ã¢ne, un cynique, arrive encore Ã  dÃ©chiffrer : " Tous les animaux sont Ã©gaux, mais (il semble que cela ait Ã©tÃ© rajoutÃ©) il y en a qui le sont plus que d''autres. "', 'Gallimard', '', 150, '1954-12-29', 'Science-Fiction', '', '/img/books/1/13.jpg');

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
  `email` varchar(255) NOT NULL,
  `sexe` char(1) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '0',
  `admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `sexe`, `active`, `admin`) VALUES
(1, 'demo', 'a69681bcf334ae130217fea4505fd3c994f5683f', 'demo@demo.com', 'M', 1, 1);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;