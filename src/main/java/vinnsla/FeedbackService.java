package vinnsla;


/******************************************************************************
 *  Nafn    : María Björk Gunnarsdóttir
 *  T-póstur: mbg13@hi.is
 *
 *  Lýsing  : Klasi sem gefur feedback á hve svar við viðtalsspurningu er gott.
 *            Endurbætið að vild - Hafið feedback á íslensku ef spurningar eru á íslensku
 *
 *
 *****************************************************************************/
public class FeedbackService {

    /**
     * Aðferð til að skila feedback, byggt á svari.
     * @param answer svar notanda
     * @return feedback
     */
    public static String provideFeedback(String answer) {
        if (answer == null || answer.trim().isEmpty()) {
            return "Svarið þitt er heldur stutt. Prófaðu að bæta við meiri upplýsingum.";
        }

        if ((answer.toLowerCase().contains("lausnamiðuð") || answer.toLowerCase().contains("lausnamiðaður")) && answer.toLowerCase().contains("vinn vel í hópi")) {
            return "Frábært! Þú tekur fram að þú leitir að lausnum og vinnir vel í hópi.";
        }

        if (answer.toLowerCase().contains("vinn vel í hópi")) {
            return "Gott. Þú talar um að þú vinnir vel í hópi. Getur þú gefið dæmi?";
        }

        if (answer.toLowerCase().contains("lausnamiðuð") || answer.toLowerCase().contains("lausnamiðaður")) {
            return "Frábært. Að vinna að lausnum er mikilvægur eiginleiki! Getur þú gefið einhver dæmi?";
        }


        if(answer.toLowerCase().contains("java") || answer.toLowerCase().contains("python") || answer.toLowerCase().contains("c#")) {
            return "Flott!";
        }

        if(answer.toLowerCase().contains("mac") || answer.toLowerCase().contains("windows")) {
            return "Flott!";
        }

        return "Svarið þitt er gott. Athugaðu hvort að þu getur bætt við meiri upplýsingum.";
    }
    
}

