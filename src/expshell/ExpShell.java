/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expshell;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Debug.Random;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemovePercentage;

/**
 *
 * @author YH Jonathan Kwok
 */
public class ExpShell {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String file = "C:\\Users\\YH Jonathan Kwok\\Documents\\NetBeansProjects\\ExpShell\\src\\expshell\\iris.csv";
        
        DataSource source = new DataSource(file);
        Instances data = source.getDataSet();
        
        if(data.classIndex() == -1)
            data.setClassIndex(data.numAttributes() - 1);
        
        //Randomize it
        data.randomize(new Random(1));
        
        RemovePercentage filter = new RemovePercentage();
        filter.setPercentage(70);
        
        filter.setInputFormat(data);
        Instances training = Filter.useFilter(data, filter);
        
        filter.setInvertSelection(true);
        filter.setInputFormat(data);
        Instances test = Filter.useFilter(data, filter);
        
        //Part 5
        Classifier hardCode = (Classifier) new HardCodeClassifier();
        hardCode.buildClassifier(training);
        Evaluation eval = new Evaluation(training);
        eval.evaluateModel(hardCode, data);
        
        System.out.println(eval.toSummaryString("***** Overall results: *****", false));
        
    }
    
}
