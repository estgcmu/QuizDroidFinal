package cmu.QuizDroidFinal;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "teste_2"; //Nome da base de dados
	// tasks table name
	private static final String TABLE_QUEST = "quest_teste"; // Nome da tabela
	// tasks Table Columns names
	private static final String KEY_ID = "qid";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; // correct option
	private static final String KEY_OPTA = "opta"; // option a
	private static final String KEY_OPTB = "optb"; // option b
	private static final String KEY_OPTC = "optc"; // option c
	private static final String KEY_OPTD = "optd"; // option d
    private static final String KEY_ODIF = "odif"; // option dificuldade
	private SQLiteDatabase dbase;

	public QuizHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
				+ KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD + " TEXT, " + KEY_ODIF + " TEXT " +")";
		db.execSQL(sql);
		addQuestion();
	}

	private void addQuestion() {
                                 //Pergunta, Opção 1, Opção 2, Opção 3, Opção 4, Nivel de dficuldade, Opção correta
		Question q1 = new Question("A Internet foi inventada", "na década de 80", "na década de 90", "em 1978", "na década de 60", "FACIL", "na década de 60");
		this.addQuestion(q1);
		Question q2 = new Question("A dentição humana, em adulto, é composta por", "24 dentes", "45 dentes", "48 dentes", "32 dentes", "FACIL", "32 dentes");
		this.addQuestion(q2);
        Question q3 = new Question("Joaquim Guilherme Gomes Coelho, era o verdadeiro nome do escritor", "Miguel Torga", "António Aleixo", "Júlio Dinis", "Alexandre Herculano", "FACIL", "Júlio Dinis");
        this.addQuestion(q3);
        Question q4 = new Question("O verdadeiro nome do escritor Miguel Torga era:", "Pedro Miguel de Vasconcelos", "José da Silva Corte-Real", "Adolfo Correia da Rocha", "José Sebastião Saraiva e Melo", "FACIL", "Adolfo Correia da Rocha");
        this.addQuestion(q4);
        Question q5 = new Question("O Brasil foi oficialmente descoberto por", "Tristão da Cunha", "Pedro Álvares Cabral", "Cristóvão Colombo", "Afonso de Albuquerque", "FACIL", "Pedro Álvares Cabral");
        this.addQuestion(q5);
        Question q6 = new Question("O esqueleto humano, em adulto, tem", "67 ossos", "206 Ossos", "127 ossos", "298 ossos", "FACIL", "206 Ossos");
        this.addQuestion(q6);
        Question q7 = new Question("O maior órgão do corpo humano chama-se", "Fígado", "Pâncreas", "Pele", "Pulmões", "FACIL", "Pele");
        this.addQuestion(q7);
        Question q8 = new Question("A célebre frase Penso, logo existo, foi pronuncciada por", "Homero", "Aristóteles", "Galilei Galileu", "René Descartes", "FACIL", "René Descartes");
        this.addQuestion(q8);
        Question q9 = new Question("Cirrus, Nimbos e Cúmulos, são nomes dos três tipos de", "Nuvens", "Caravelas", "Deuses", "Montes", "FACIL", "Nuvens");
        this.addQuestion(q9);
        Question q10 = new Question("O Papa português foi", "S. Francisco Xavier", "Inocêncio III", "João XXI", "S. João de Brito", "FACIL", "João XXI");
        this.addQuestion(q10);
        Question q11 = new Question("A constelação em forma de W, visível no hemisfério Norte, chama-se", "Orion", "Cassiopeia", "Áries", "Pégaso", "FACIL", "Cassiopeia");
        this.addQuestion(q11);
        Question q12 = new Question("Qual a capital da Turquia?", "Antuérpia", "Budapeste", "Vaduz", "Ankara", "FACIL", "Ankara");
        this.addQuestion(q12);
        Question q13 = new Question("A afirmação Na natureza nada se perde, nada se cria, tudo se transforma. pertence a", "René Descarte", "Lavoisier", "Platão", "Aristoteles", "FACIL", "Lavoisier");
        this.addQuestion(q13);
        Question q14 = new Question("Qual a capital da Venezuela?", "Livorno", "Camberra", "Caracas", "Buenos Aires", "FACIL", "Caracas");
        this.addQuestion(q14);
        Question q15 = new Question("Com quem era casada a Rainha Santa Isabel?", "Marquês de Pombal", "D. Afonso Henriques", "D. Nuno Álvares Pereira", "D. Dinis", "FACIL", "D. Dinis");
        this.addQuestion(q15);
        Question q16 = new Question("Qual o mineral mais duro?", "Ferro", "Diamante", "Cobre", "Platina", "FACIL", "Diamante");
        this.addQuestion(q16);
        Question q17 = new Question("O maior osso do corpo humano chama-se", "Fémur", "Cúbito", "Tarso", "Tíbia", "FACIL", "Fémur");
        this.addQuestion(q17);
        Question q18 = new Question("Em que ano se deu a 1ª invasão Francesa em Portugal?", "1910", "1380", "1807", "1640", "FACIL", "1807");
        this.addQuestion(q18);
        Question q19 = new Question("Em que ano foi abolida a escravatura nos Estados da Unidos da América", "1903", "1865", "1728", "1526", "FACIL", "1865");
        this.addQuestion(q19);
        Question q20 = new Question("Quantas sinfonias escreveu Beethoven?", "7", "10", "9", "8", "FACIL", "9");
        this.addQuestion(q20);
        Question q21 = new Question("Aonde fica situado o tribunal internacional de Haia?", "França", "Holanda", "Suiça", "Bélgica", "FACIL", "Holanda");
        this.addQuestion(q21);
        Question q22 = new Question("Alfred Nobel, fundador do prémio com o seu nome era", "Alemão", "Austríaco", "Filandês", "Sueco", "FACIL", "Sueco");
        this.addQuestion(q22);
        Question q23 = new Question("Um almude é uma vasilha que mede", "25 litros", "15 litros", "12 litros", "20 litros", "FACIL", "25 litros");
        this.addQuestion(q23);
        Question q24 = new Question("O principal explosivo constituinte da dinamite é", "Nitroglicerina", "Pólvora", "Nitrato de amónia", "Gasolina", "FACIL", "Nitroglicerina");
        this.addQuestion(q24);
        Question q25 = new Question("Qual o domínio sob o qual se encontra a ilha da Córsega?", "Francês", "Italiano", "Inglês", "Espanhol", "FACIL", "Francês");
        this.addQuestion(q25);

        Question q26 = new Question("A capital da Bolívia é", "Santiago", "Lima", "Buenos Aires", "La paz", "MODERADO", "La paz");
        this.addQuestion(q26);
        Question q27 = new Question("Qual a língua oficial da China?", "O chinês", "O mandarim", "O cantonês", "O flamengo", "MODERADO", "O mandarim");
        this.addQuestion(q27);
        Question q28 = new Question("Em que ano foi inaugurado o metropolitano de Lisboa", "1952", "1974", "1960", "1968", "MODERADO", "1960");
        this.addQuestion(q28);
        Question q29 = new Question("O minério de Alumínio é", "A galena", "A bauxite", "A pirite", "A alumina", "MODERADO", "A bauxite");
        this.addQuestion(q29);
        Question q30 = new Question("Qual é o Estado mais pequeno do mundo?", "Andorra", "Mónaco", "Pirinéus", "Vaticano", "MODERADO", "Vaticano");
        this.addQuestion(q30);
        Question q31 = new Question("Qual dos países fica no continente africano?", "Nepal", "Nicarágua", "Itália", "Nigéria", "MODERADO", "Nigéria");
        this.addQuestion(q31);
        Question q32 = new Question("Qual o nome do satélite do planeta Urano descoberto em 1851 por W. Lassell?", "Calipso", "Ariel", "Titã", "Lua", "MODERADO", "Ariel");
        this.addQuestion(q32);
        Question q33 = new Question("Quem foi o autor da célebre figura de barro conhecida por Zé Povinho?", "António Vitorino", "Almada Negreiros", "Josefa de Óbidos", "Rafael Bordalo Pinheiro", "MODERADO", "Rafael Bordalo Pinheiro");
        this.addQuestion(q33);
        Question q34 = new Question("Qual o maior país da América do Sul descoberto pelos europeus em 1500?", "Cuba", "Brasil", "Canadá", "Estados Unidos da América", "MODERADO", "Brasil");
        this.addQuestion(q34);
        Question q35 = new Question("Em que ano chegou Vasco da Gama à Índia?", "1499", "1500", "1502", "1498", "MODERADO", "1498");
        this.addQuestion(q35);
        Question q36 = new Question("Qual o deus grego relacionado com o Inferno?", "Apolo", "Dionísio", "Zeus", "Hades", "MODERADO", "Hades");
        this.addQuestion(q36);
        Question q37 = new Question("Qual o nome dado à arte de edificar?", "Pintura", "Escultura", "Arquitectura", "Edificação", "MODERADO", "Arquitectura");
        this.addQuestion(q37);
        Question q38 = new Question("Qual o nome do deus romano do vinho, da vegetação e do delírio?", "Dionísio", "Neptuno", "Baco", "Marte", "MODERADO", "Baco");
        this.addQuestion(q38);
        Question q39 = new Question("Qual a estrela que, no hemisfério norte, permite determinar o norte terrestre?", "Orion", "Cassiopeia", "Cruzeiro do Sul", "Polar", "MODERADO", "Polar");
        this.addQuestion(q39);
        Question q40 = new Question("Qual dos nomes não corresponde a um apóstolo de Cristo?", "Tiago", "André", "Bartolomeu", "António", "MODERADO", "António");
        this.addQuestion(q40);
        Question q41 = new Question("Qual o nome do satélite de Júpiter descoberto por Galileu em 1610?", "Ganimedes", "Europa", "Lua", "Calipso", "MODERADO", "Ganimedes");
        this.addQuestion(q41);
        Question q42 = new Question("Qual a capital do Paraguai?", "Paraguai", "Assunção", "Filadélfia", "Encarnação", "MODERADO", "Assunção");
        this.addQuestion(q42);
        Question q43 = new Question("Qual o plural correcto de júnior?", "junióres", "juniores", "júniores", "juníores", "MODERADO", "juniores");
        this.addQuestion(q43);
        Question q44 = new Question("Qual o nome dado ao pêlo longo e sedoso de alguns animais?", "Crinolina", "Crina", "Crista", "Cabelo", "MODERADO", "Crina");
        this.addQuestion(q44);
        Question q45 = new Question("O que designa o símbolo químico Na?", "Nitrato", "Sódio", "Outo", "Alumínio", "MODERADO", "Sódio");
        this.addQuestion(q45);
        Question q46 = new Question("Em que país se pode ver um DVD de zona 2?", "Estados Unidos", "França", "Rússia", "Austrália", "MODERADO", "França");
        this.addQuestion(q46);
        Question q47 = new Question("Quem inventou o telefone?", "Alexander Graham Bell", "Clemente Ader", "Isac Newton", "Henry Ford", "MODERADO", "Alexander Graham Bell");
        this.addQuestion(q47);
        Question q48 = new Question("Como se chamava a amada de Napoleão?", "Josephine", "Joana D'Arc", "Gautier", "Marion Bartoli", "MODERADO", "Josephine");
        this.addQuestion(q48);
        Question q49 = new Question("Qual foi a primeira rainha de Portugal?", "D. Mafalda de Saboia", "D. Urraca de Castela", "D. Dulce de Berenguer", "D. Matilde de Bolonha", "MODERADO", "D. Mafalda de Saboia");
        this.addQuestion(q49);
        Question q50 = new Question("Quem escreveu o romance E Tudo o Vento Levou", "Margaret Mitchell", "Lauren Weisbergen", "Steve Berry", "Isaac Asimov", "MODERADO", "Margaret Mitchell");
        this.addQuestion(q50);


        Question q51 = new Question("Que matemático e geógrafo grego calculou o perímetro da Terra em 240 a.C.?", "Descartes", "Sócrates", "Sófocles", "Eratóstenes", "DIFICIL", "Eratóstenes");
        this.addQuestion(q51);
        Question q52 = new Question("Segundo o tratado assinado em 1971, que região do planeta ficou interdita a armas nucleares?", "Sara", "África", "Antártida", "Bahamas", "DIFICIL", "Antártida");
        this.addQuestion(q52);
        Question q53 = new Question("Por que nome se tornou mais conhecido o escritor norte-americano Samuel Langhorne Clemens?", "Paul Auster", "Mark Twain", "Paulo Coelho", "Nicolau Gogol", "DIFICIL", "Mark Twain");
        this.addQuestion(q53);
        Question q54 = new Question("Que expressão alemã significa guerra-relâmpago ?", "Sauerkraut", "Glasnost", "Blitzkrieg", "Reichstag", "DIFICIL", "Blitzkrieg");
        this.addQuestion(q54);
        Question q55 = new Question("Como se chamou o Sporting Club de Portugal entre 1904 e 1906?", "Sporting de Portugal", "Não teve nome", "Leões da Estrela", "Campo Grande Football Club", "DIFICIL", "Campo Grande Football Club");
        this.addQuestion(q55);
        Question q56 = new Question("Junto a que cidade do Novo México se julga ter caído um OVNI em 1947?", "Tijuana", "Las Vegas", "Roswell", "Chihuahua", "DIFICIL", "Roswell");
        this.addQuestion(q56);
        Question q57 = new Question("Em Portugal, a que cidadãos foi retirado o direito de voto em 1913?", "Mulheres", "Analfabetos", "Emigrantes", "Idosos", "DIFICIL", "Analfabetos");
        this.addQuestion(q57);
        Question q58 = new Question("Qual é o mais famoso detetive criado por Raymond Chandler?", "Hercule Poirot", "Sherlock Holmes", "Philip Marlowe", "Agatha Christie", "DIFICIL", "Philip Marlowe");
        this.addQuestion(q58);
        Question q59 = new Question("Em que atividade se destacou La Corbusier?", "Cinema", "Teatro", "Literatura", "Arquitetura", "DIFICIL", "Arquitetura");
        this.addQuestion(q59);
        Question q60 = new Question("Que parque natural na região de Bragança foi criado em 1979?", "Peneda-Gerês", "Montesinho", "Alto Douro", "Arrábida", "DIFICIL", "Montesinho");
        this.addQuestion(q60);
        Question q61 = new Question("Como se chama a personagem principal do filme Touro Enraivecido?", "Sugar Ray Robinson", "Belarmino", "Muhamad Ali", "Jake La Motta", "DIFICIL", "Jake La Motta");
        this.addQuestion(q61);
        Question q62 = new Question("Quanto tempo demora a Lua a dar a volta à Terra período orbital?", "27 dias e 8 horas", "25 dias", "30 dias", "29 dias e 12 horas", "DIFICIL", "27 dias e 8 horas");
        this.addQuestion(q62);
        Question q63 = new Question("Quem recebeu um prémio Nobel devido ao desenvolvimento da encefalografia arterial?", "Júlio de Matos", "Egas Moniz", "Michael Faraday", "Sousa Martins", "DIFICIL", "Egas Moniz");
        this.addQuestion(q63);
        Question q64 = new Question("Que eletrodoméstico foi criado por Murray Spangler em 1907 e que ainda hoje é vendido praticamente inalterado?", "Esquentador", "Torradeira", "Micro-ondas", "Aspirador", "DIFICIL", "Aspirador");
        this.addQuestion(q64);
        Question q65 = new Question("Que modalidade desportiva foi introduzida em Portugal Continental em 1888 por Guilherme Pinto Basto?", "Futebol", "Corfebol", "Andebol", "Ténis", "DIFICIL", "Futebol");
        this.addQuestion(q65);
        Question q66 = new Question("Qual é o objeto de estudo do puericultor?", "Crianças", "Coelhos", "Galinhas", "Abelhas", "DIFICIL", "Crianças");
        this.addQuestion(q66);
        Question q67 = new Question("Que país sul-americano é o maior produtor de vinho?", "Brasil", "Venezuela", "Canadá", "Argentina", "DIFICIL", "Argentina");
        this.addQuestion(q67);
        Question q68 = new Question("Quem comandou a segunda invasão napoleónica em Portugal?", "Napoleão", "Junot", "Wellington", "Soult", "DIFICIL", "Soult");
        this.addQuestion(q68);
        Question q69 = new Question("Qual é a corrente filosófica defendida por Martin Heidegger?", "Positivismo", "Niilismo", "Abstracionismo", "Existencialismo", "DIFICIL", "Existencialismo");
        this.addQuestion(q69);
        Question q70 = new Question("Que corpo militar de elite foi criado em França por Luís XIII como guarda pessoal em 1922 e existiu até 1815?", "Guarda Suíça", "Rangers", "Escuteiros", "Mosqueteiros", "DIFICIL", "Mosqueteiros");
        this.addQuestion(q70);
        Question q71 = new Question("O que mudou na personagem Lucky Luke em 1983?", "Começou a usar óculos", "Tornou-se vegetariano", "Deixou de fumar", "Deixou de usar armas", "DIFICIL", "Deixou de fumar");
        this.addQuestion(q71);
        Question q72 = new Question("Qual foi a primeira moeda a ser usada em toda a Europa Ocidental?", "ECU", "Euro", "Sestércio", "Dracma", "DIFICIL", "Sestércio");
        this.addQuestion(q72);
        Question q73 = new Question("Quem escreveu A Arte da Guerra?", "Confúcio", "Gandhi", "Sun Tzu", "Mao Tsé Tung", "DIFICIL", "Sun Tzu");
        this.addQuestion(q73);
        Question q74 = new Question("Que expressão náutica foi sugerida por Alexander Bell para ser usada quando se atende o telefone?", "Ahoy", "Over", "Hi", "All aboard", "DIFICIL", "Ahoy");
        this.addQuestion(q74);
        Question q75 = new Question("Que palavra de origem inuíte significa casa?", "Quiosque", "Caiaque", "Anoraque", "Uglu", "DIFICIL", "Iglu");
        this.addQuestion(q75);

        // END
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}

	// Adding new question
	public void addQuestion(Question quest) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        values.put(KEY_ODIF, quest.getODIF());

		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
    }
    //CONSULTA PERUGUNTAS POR NIVEL DE DIFICULDADE
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST +" WHERE " + KEY_ODIF + "='FACIL' ORDER BY RANDOM() LIMIT 0,10";
		dbase = this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) do {
            Question quest = new Question();
            quest.setID(cursor.getInt(0));
            quest.setQUESTION(cursor.getString(1));
            quest.setANSWER(cursor.getString(2));
            quest.setOPTA(cursor.getString(3));
            quest.setOPTB(cursor.getString(4));
            quest.setOPTC(cursor.getString(5));
            quest.setOPTD(cursor.getString(6));
            quest.setODIF(cursor.getString(7));


            quesList.add(quest);
        } while (cursor.moveToNext());
        cursor.close();
        // return quest list
		return quesList;

	}


}
