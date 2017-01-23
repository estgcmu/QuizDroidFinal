package cmu.QuizDroidFinal;

import android.widget.EditText;

/**
 * Created by joaosoares on 13/01/17.
 */

public class Pergunta_insert {


    public static abstract class NovaPergunta {

        public static final String KEY_ID = "qid";
        public static final String KEY_QUES = "question";
        public static final String KEY_ANSWER = "answer"; // Opção Correta
        public static final String KEY_OPTA = "opta"; // Opção 1
        public static final String KEY_OPTB = "optb"; // Opção 2
        public static final String KEY_OPTC = "optc"; // Opção 3
        public static final String KEY_OPTD = "optd"; // Opção 4
        public static final String KEY_ODIF = "odif"; // Dificuldade (FACIL,MODERADO,DIFICIL)
        public static final String TABLE_NAME = "quest_teste"; // Tabela


    }


}
