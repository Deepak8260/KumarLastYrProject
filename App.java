import java.net.URI;
import java.awt.Desktop;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;


public class App {
    public static void main(String[] args) throws Exception {

        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\Dictionary.dic");
        config.setLanguageModelPath("src\\LanguageModel.lm");

        try 
        {
            LiveSpeechRecognizer rec= new LiveSpeechRecognizer(config);
            //System.out.println("Listening...");
            rec.startRecognition(true);
            Desktop desk = Desktop.getDesktop();

            while(rec.getResult()!=null){
                String result=rec.getResult().getHypothesis();
                if(result.toLowerCase().equals("open google"))
                {
                    URI uri=new URI("https://www.google.com/");
                    System.out.println("Opening "+result);
                    desk.browse(uri);
                }
                else if(result.toLowerCase().equals("open youtube"))
                {
                    URI uri=new URI("https://www.youtube.com/");
                    System.out.println("Opening "+result);
                    desk.browse(uri);
                }
            }
        }
        
        catch (Exception e) 
        {
            System.err.println(e);
        }
    }
}
