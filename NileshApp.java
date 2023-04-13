import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class NileshApp {
        public static void main(String[] args) throws Exception {
    
            Configuration config = new Configuration();
            config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            config.setDictionaryPath("src\\Dictionary.dic");
            config.setLanguageModelPath("src\\LanguageModel.lm");

            LiveSpeechRecognizer rec= new LiveSpeechRecognizer(config);
            rec.startRecognition(true);

            SpeechResult speechResult;
            while((speechResult = rec.getResult()) != null){
                String command = speechResult.getHypothesis();
                String work = null;
                System.out.println("Input command is "+command);
                if(command.equalsIgnoreCase("open google")){
                    work = "open -a Google http://www.google.com";
                }
                else if(command.equalsIgnoreCase(" open youtube")){
                    work = "open -a YouTube http://www.youtube.com";
                }

                if(work!=null){
                    
                }
            }
        }
    }