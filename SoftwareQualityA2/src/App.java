
import net.sf.javaml.clustering.*;
import net.sf.javaml.clustering.Cobweb;
import net.sf.javaml.clustering.FarthestFirst;
import net.sf.javaml.clustering.KMedoids;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\saiee\\Documents\\SoftwareQualityA2\\src\\iris.data";
        //Load a dataset
        Dataset data = FileHandler.loadDataset(new File(filePath), 4, ",");
      //System.out.println(data);


        // KMEANS ALGORITHM
       
        /* Create a new instance of the KMeans algorithm, with no options
         * specified. By default, this will generate 4 clusters. */
        Clusterer km = new net.sf.javaml.clustering.KMeans();
        /* Cluster the data, it will be returned as an array of data sets, with
         * each dataset representing a cluster. */
        Dataset[] clusters = km.cluster(data);
        /* Create a measure for the cluster quality */
        ClusterEvaluation sse= new SumOfSquaredErrors();
        /* Measure the quality of the clustering */
        double score=sse.score(clusters);
        // Print score
        System.out.println("K-Means score: " + score);


        // FARTHESTFIRST ALGORITHM
        Clusterer ff = new FarthestFirst();
        /* Cluster the data, it will be returned as an array of data sets, with
         * each dataset representing a cluster. */
        Dataset[] clusters3 = ff.cluster(data);
        /* Create a measure for the cluster quality */
        ClusterEvaluation sse3= new SumOfSquaredErrors();
        /* Measure the quality of the clustering */
        double score3=sse3.score(clusters3);
        // Print the score
        System.out.println("Farthest First Score: " + score3);

    
        
        // KMedoids ALGORITHM
        Clusterer km2 = new KMedoids();
        /* Cluster the data, it will be returned as an array of data sets, with
         * each dataset representing a cluster. */
        Dataset[] clusters4 = km2.cluster(data);
        /* Create a measure for the cluster quality */
        ClusterEvaluation sse4= new SumOfSquaredErrors();
        /* Measure the quality of the clustering */
        double score4=sse4.score(clusters4);
        // Print the score
        System.out.println("K-Medoids Score: " + score4);
    
    
    
    
    
    }
}