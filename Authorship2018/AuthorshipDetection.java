
import acm.program.*;
import java.util.ArrayList;

public class AuthorshipDetection extends ConsoleProgram
{
    private static final String PUNCTUATION = "'!\",;:.-?)([]<>*#\n\t\r ";
    private static final double[] WEIGHT = {11.0, 33.0, 50.0, 0.4, 4.0};
    private AuthorSignature[] authors;

    public void run()
    {
        loadAuthorSignatures();
        String filename = readLine("Enter file name: "); 
        String fileContents = FileHelper.getFileContents(filename);
        
        ArrayList<String> sentences = getSentencesFromContents(fileContents);
        ArrayList<String> words = getAllWordsFromSentences(sentences); 
       
        AuthorSignature unknownSignature = new AuthorSignature("unknown", computeAverageWordLength(words), 
        computeDifferentRatio(words), computeHapaxLegomannaRatio(words), computeAverageWordsPerSentence(sentences), 
        computeSentenceComplexity(sentences)); 
        
       println("Here are the values of authorship");
       for(AuthorSignature author: authors)
       {
           println(author.getAuthorName() + "has a value of: " + computeScore(unknownSignature, author)); 
        }
        
        println(); 
        println("The winner is");
        println(detectAuthorship(unknownSignature)); 
        
        // task #1 goes here
    }

    // you'll do tasks #2 through #12 here
    private ArrayList<String> getSentencesFromContents(String fileContents) 
    { 
        String remain = fileContents; 
        ArrayList<String> result = new ArrayList<String>();
        while(remain.length()>0)
        {
            int period = remain.indexOf("."); 
            if (period==-1)
               period = remain.length();
            int exclamation = remain.indexOf("!"); 
            if(exclamation ==-1)
                exclamation = remain.length();
            int question = remain.indexOf("?"); 
            if(question == -1 )
                question = remain.length();
            
           if (period == remain.length() && exclamation == remain.length() && question == remain.length())
           {
               result.add(remain);
               remain = "";
            }
                
           else if(period <= exclamation && period <= question)
           {
               result.add(remain.substring(0, period+1)); 
               remain = remain.substring(period +1); 
            }else if(exclamation < question)
            {
                 result.add(remain.substring(0, exclamation +1));
                remain = remain.substring(exclamation +1); 
            }else{
                 result.add(remain.substring(0, question +1));
                remain = remain.substring(question +1); 
            }
           
        }
        return result; 
        
    } 
    
    private ArrayList<String> getWordsFromSentences(String sentence)
    {
          ArrayList<String> result = new ArrayList<String>(); 
        String remain = sentence.replaceAll("\n", " ");
        while(remain.length() > 0 )
        {
            int index = remain.indexOf(" ");
            if (index != -1)
            {
                String cleanedWord = clean(remain.substring(0, index)); 
                if (cleanedWord.length()>0)
                    result.add(cleanedWord); 
                remain = remain.substring(index+1);
            }else 
            {
                String cW = clean(remain); 
                if (cW.length()>0)
                      result.add(cW); 
                remain = ""; 
            }
        }
        return result; 
        
    }
    
    private ArrayList<String> getAllWordsFromSentences(ArrayList<String> sentences)
    {
        ArrayList<String> result = new ArrayList<String>(); 
        for(int i=0; i<sentences.size(); i++) 
        {
            ArrayList<String> words = getWordsFromSentences(sentences.get(i));
            for(int j=0; j<words.size(); j++)
            {
                result.add(words.get(j));
            }
        }return result; 
    }
    
    private String clean(String word) 
    {
        if (word.length()==0)
           return word;
        String result = word.toLowerCase(); 

        while(result.length()>0 && PUNCTUATION.indexOf(result.substring(0,1)) != -1){
                result = result.substring(1); 

        }


       while(result.length()>0 && PUNCTUATION.indexOf(result.substring(result.length()-1)) != -1 )
       {
           result = result.substring(0, result.length()-1); 
       }
        return result; 
    }
    
    private double computeAverageWordLength(ArrayList<String> words) 
    {
        double sum =0.0;
        
        for(int i=0; i<words.size(); i++)
        {
            sum += words.get(i).length();
            
        }
        return sum/words.size(); 
        
    }
    
    private double computeDifferentRatio(ArrayList<String> words)
    {
        ArrayList<String> uniqueW = new ArrayList<String>(); 
        int denominator = words.size();
        
        for(String w : words)
        {
            if(!uniqueW.contains(w))
            {
                uniqueW.add(w); 
                
            }
        }
        return 1.0*uniqueW.size()/words.size(); 
    }
    
    private double computeHapaxLegomannaRatio(ArrayList<String> words)
    {
       ArrayList<String> once = new ArrayList<String>();
       ArrayList<String> twice = new ArrayList<String>();
      for(String w: words) 
      {
         if(!once.contains(w))
         {
             once.add(w); 
         }else if(!twice.contains(w)){
             twice.add(w);
         }
       }
      
       return ((once.size()-twice.size())*1.0)/words.size(); 
    }
    
    //getting a heap space error
    private double computeAverageWordsPerSentence(ArrayList<String> sentences)
    {
        int sum = 0;
        for(String s: sentences)
        {
            ArrayList<String> words = getWordsFromSentences(s);
            sum += words.size(); 
        }
       
        return sum*1.0/sentences.size(); 
    }
    
    private double computeSentenceComplexity(ArrayList<String> sentences)
    {
        int counter =0; 
      for(String s: sentences)
      {
          String remain = s;
          
            while(remain.length()>0)
        {
            
            int colon = remain.indexOf(":"); 
            if (colon==-1)
               colon = remain.length();
            int semicolon = remain.indexOf(";"); 
            if(semicolon ==-1)
                semicolon = remain.length();
           int comma = remain.indexOf(","); 
            if(comma == -1 )
                comma = remain.length();
            
           if (colon == remain.length() && semicolon == remain.length() && comma == remain.length())
           {
               counter++;
               remain = "";
            }
                
           else if(colon <= semicolon && colon <= comma)
           {
               counter++;
               remain = remain.substring(colon +1); 
            }else if(semicolon < comma)
            {
                counter++; 
                remain = remain.substring(semicolon +1); 
            }else{
                counter++;
                remain = remain.substring(comma +1); 
            }
           
        }
       }
       return counter *1.0/sentences.size(); 
    }
    
    private double computeScore(AuthorSignature first, AuthorSignature second)
    {
        
       double aWL = Math.abs(first.getAverageWordLength()-second.getAverageWordLength()) * WEIGHT[0]; 
       double dWR = Math.abs(first.getDifferentWordRatio()-second.getDifferentWordRatio()) * WEIGHT[1];
       double hLR = Math.abs(first.getHapaxRatio()-second.getHapaxRatio()) * WEIGHT[2];
       double aWPS = Math.abs(first.getAverageWordsPerSentence()-second.getAverageWordsPerSentence()) * WEIGHT[3];
       double sC =  Math.abs(first.getAveragePhrasesPerSentence()-second.getAveragePhrasesPerSentence()) * WEIGHT[4];
       return aWL+dWR+hLR+aWPS+sC; 
    }
    
    private String detectAuthorship(AuthorSignature unknown)
    {
        AuthorSignature champ = authors[0]; 
        for(int i=0; i<authors.length; i++)
        {
            if(computeScore(unknown,authors[i]) < computeScore(unknown, champ))
            {
                champ = authors[i]; 
            }
        }
        return champ.getAuthorName(); 
    }
    
    // I wrote this method for you
    private void loadAuthorSignatures()
    {
        authors = new AuthorSignature[13];
        authors[0] = new AuthorSignature("Agatha Christie", 4.40212537354, 0.103719383127, 0.0534892315963, 10.0836888743, 1.90662947161);
        authors[1] = new AuthorSignature("Alexandre Dumas", 4.38235547477, 0.049677588873, 0.0212183996175, 15.0054854981, 2.63499369483);
        authors[2] = new AuthorSignature("Brothers Grimm", 3.96868608302, 0.0529378997714, 0.0208217283571, 22.2267197987, 3.4129614094);
        authors[3] = new AuthorSignature("Charles Dickens", 4.34760725241, 0.0803220950584, 0.0390662700499, 16.2613453121, 2.87721723105);
        authors[4] = new AuthorSignature("Douglas Adams", 4.33408042189, 0.238435104414, 0.141554321967, 13.2874354561, 1.86574870912);
        authors[5] = new AuthorSignature("Emily Bronte", 4.35858972311, 0.089662598104, 0.0434307152651, 16.1531664212, 2.93439550141);
        authors[6] = new AuthorSignature("Fyodor Dostoevsky", 4.34066732195, 0.0528571428571, 0.0233414043584, 12.8108273249, 2.16705364781);
        authors[7] = new AuthorSignature("James Joyce", 4.52346300961, 0.120109917189, 0.0682315429476, 10.9663296918, 1.79667373227);
        authors[8] = new AuthorSignature("Jane Austen", 4.41553119311, 0.0563451817574, 0.02229943808, 16.8869087498, 2.54817097682);
        authors[9] = new AuthorSignature("Lewis Caroll", 4.22709528497, 0.111591342227, 0.0537026953444, 16.2728740581, 2.86275565124);
        authors[10] = new AuthorSignature("Mark Twain", 4.33272222298, 0.117254215021, 0.0633074228159, 14.3548573631, 2.43716268311);
        authors[11] = new AuthorSignature("Sir Arthur Conan Doyle", 4.16808311494, 0.0822989796874, 0.0394458485444, 14.717564466, 2.2220872148);
        authors[12] = new AuthorSignature("William Shakespeare", 4.16216957834, 0.105602561171, 0.0575348730848, 9.34707371975, 2.24620146314);
    }

}
