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
import weka.filters.unsupervised.attribute.Standardize;
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
        
        RemovePercentage rp = new RemovePercentage();
        rp.setPercentage(70);
        
        rp.setInputFormat(data);
        Instances training = Filter.useFilter(data, rp);
        
        rp.setInvertSelection(true);
        rp.setInputFormat(data);
        Instances test = Filter.useFilter(data, rp);
        
        //standardize the data
        Standardize filter = new Standardize();
        filter.setInputFormat(training);
        
        Instances newTest = Filter.useFilter(test, filter);
        Instances newTraining = Filter.useFilter(training, filter);
        
        //Part 5 - Now it's a knn
        Classifier knn = new NeuralClassifier();
        knn.buildClassifier(newTraining);
        Evaluation eval = new Evaluation(newTraining);
        eval.evaluateModel(knn, newTest);
        
        System.out.println(eval.toSummaryString("***** Overall results: *****", false));
        
    }
    
}
