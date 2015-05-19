    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package expshell;

    import java.util.HashMap;
    import java.util.Map;
    import weka.classifiers.Classifier;
    import weka.core.Instance;
    import weka.core.Instances;
    import static weka.core.Utils.log2;

    /**
     *
     * @author YH Jonathan Kwok
     */
    public class DecisionTree extends Classifier{
        private Instances data;

        @Override
        public void buildClassifier(Instances data) throws Exception {
            //this.data = data;
            double tempArray[] = {1.0, 2.0, 1.0, 2.0, 3.0, 4.0};
            System.out.println(calEntropy(tempArray));
            System.out.println(log2(10/3));
        }

        @Override
        public double classifyInstance(Instance i) {
            //I Know Nothing !!!!!!!!!!!!!!!!!!!!!!!!!!!
            return -1;
        }

        public Map<Double, Integer> makeMap(double arrayCount[]){
            Map<Double, Integer> superMap = new HashMap<Double, Integer>();
            for (int i = 0; i < arrayCount.length; i++){
                if (superMap.containsKey(arrayCount[i])){
                    superMap.replace(arrayCount[i], superMap.get(arrayCount[i]) + 1);
                }
                else{
                    superMap.put(arrayCount[i], 1);
                }                
            }
            return superMap;        
        }

        public double calEntropy(double arrayCount[]){
            double entropy;
            double whole = arrayCount.length;

            Map<Double, Integer> theMap= makeMap(arrayCount);

            //entropy = (arrayCounts[0]/whole)*log2(arrayCounts[0]/whole);
            entropy = 0;
            for (Double key : theMap.keySet()) {           
                entropy -= (theMap.get(key)/whole)*log2(theMap.get(key)/whole);
            }

            return entropy;
        }

    }
